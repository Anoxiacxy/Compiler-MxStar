package Backend;

import AST.ProgramNode;
import Optimism.LoopAnalysis;
import RISCV.*;
import RISCV.Instruction.*;
import RISCV.Operand.Address;
import RISCV.Operand.Immediate.IntImm;
import RISCV.Operand.Register.PhysicalRegister;
import RISCV.Operand.Register.VirtualRegister;
import org.antlr.v4.runtime.misc.Pair;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;


public class RegisterAllocate implements ASMPass {
    private final ASMModule module;
    public RegisterAllocate(ASMModule module) {
        this.module = module;
    }

    // TODO: 2021/4/7 stackFrame in every function

    public void piss() {
        module.getFunctionMap().values().forEach(asmFunction -> {
            HashMap<VirtualRegister, Address> addressHashMap = new HashMap<>();
            for (ASMBlock block = asmFunction.getEntryBlock(); block != null;  block = block.getNextBlock()) {
                for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    ArrayList<VirtualRegister> def = new ArrayList<>(inst.getDef().keySet());
                    ArrayList<VirtualRegister> use = new ArrayList<>(inst.getUse().keySet());
                    int count = 0;
                    for (VirtualRegister vr : def) {
                        if (vr.getPhysicalRegister() != null) continue;

                        if (!addressHashMap.containsKey(vr)) {
                            addressHashMap.put(vr, new Address(PhysicalRegister.getv("sp"), new IntImm(0)));
                        }
                        Address address = addressHashMap.get(vr);
                        VirtualRegister pvr = PhysicalRegister.getv("s" + count);
                        inst.replaceDef(vr, pvr);
                        block.insertASMInstAfter(inst, new Sw(block, pvr, address));
                        count++;
                    }

                    for (VirtualRegister vr : use) {
                        if (vr.getPhysicalRegister() != null) continue;

                        if (!addressHashMap.containsKey(vr)) {
                            addressHashMap.put(vr, new Address(PhysicalRegister.getv("sp"), new IntImm(0)));
                        }
                        Address address = addressHashMap.get(vr);
                        VirtualRegister pvr = PhysicalRegister.getv("s" + count);
                        block.insertASMInstBefore(inst, new Lw(block, pvr, address));
                        inst.replaceUse(vr, pvr);
                        count++;
                    }
                }
            }
            asmFunction.getStackFrame().setRuntimeRegisterLocation(new ArrayList<>(addressHashMap.values()));
            asmFunction.getStackFrame().calcFrameSize();
            int frameSize = asmFunction.getStackFrame().getFrameSize();

            asmFunction.getEntryBlock().appendASMInstFront(new Addi(asmFunction.getEntryBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(-4 * frameSize)));
            asmFunction.getExitBlock().insertASMInstBefore(asmFunction.getExitBlock().getInstEnd(), new Addi(
                    asmFunction.getExitBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(4 * frameSize)
            ));
        });
    }

    @Override
    public void run() {
        modulePass(module);
    }

    @Override
    public void modulePass(ASMModule module) {
        for (ASMFunction function : module.getFunctionMap().values())
            functionPass(function);
    }

    private Map<ASMBlock, Set<VirtualRegister>> liveIn, liveOut;
    private Map<VirtualRegister, Set<Mv>> moveList;

    private Set<VirtualRegister> simplifyWorkList;
    private Set<VirtualRegister> freezeWorkList;
    private Set<VirtualRegister> spillWorkList;
    private Set<VirtualRegister> spilledNodes;
    private Set<Mv> workListMoves;
    private Set<Mv> activeMoves;
    private Set<Mv> frozenMoves;
    private Set<Mv> coalescedMoves;
    private Set<Mv> constrainedMoves;

    private Map<VirtualRegister, Integer> degree;
    private Map<VirtualRegister, Double> spillCost;
    private Set<Pair<VirtualRegister, VirtualRegister>> adjSet;
    private Map<VirtualRegister, Set<VirtualRegister>> adjList;
    private Set<VirtualRegister> preColored;
    private Set<VirtualRegister> coloredNodes;

    private Stack<VirtualRegister> selectStack;
    private Set<VirtualRegister> coalescedNodes;
    private Set<VirtualRegister> initial;
    private final int K = PhysicalRegister.getAllocatableRegisters().size();

    private Map<VirtualRegister, VirtualRegister> alias;

    private void livenessAnalysis(ASMFunction function) {
        liveIn = new HashMap<>();
        liveOut = new HashMap<>();
        Map<ASMBlock, Set<VirtualRegister>> def = new HashMap<>();
        Map<ASMBlock, Set<VirtualRegister>> use = new HashMap<>();
        Map<ASMBlock, Integer> liveInSize = new HashMap<>();
        Map<ASMBlock, Integer> liveOutSize = new HashMap<>();

        ArrayList<ASMBlock> blocks = function.getDfsOrder();
        for (ASMBlock block : blocks) {
            Set<VirtualRegister> curDef = new HashSet<>();
            Set<VirtualRegister> curUse = new HashSet<>();

            for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                for (VirtualRegister register : inst.getUse().keySet())
                    if (!curDef.contains(register))
                        curUse.add(register);
                curDef.addAll(inst.getDef().keySet());
            }

            def.put(block, curDef);
            use.put(block, curUse);
        }

        for (ASMBlock block : blocks) {
            liveOut.put(block, new HashSet<>());
            liveIn.put(block, new HashSet<>());
            liveOutSize.put(block, 0);
            liveInSize.put(block, 0);
        }

        Collections.reverse(blocks);

        boolean changed;
        do {
            for (ASMBlock block : blocks) {
                Set<VirtualRegister> curOut = new HashSet<>();
                for (ASMBlock succ : block.getSuccessors())
                    curOut.addAll(liveIn.get(succ));
                liveOut.replace(block, curOut);

                Set<VirtualRegister> curIn = new HashSet<>(curOut);
                curIn.removeAll(def.get(block));
                curIn.addAll(use.get(block));
                liveIn.replace(block, curIn);
            }
            changed = false;
            for (ASMBlock block : blocks) {
                if (liveOutSize.get(block) != liveOut.get(block).size())
                    changed = true;
                liveOutSize.replace(block, liveOut.get(block).size());

                if (liveInSize.get(block) != liveIn.get(block).size())
                    changed = true;
                liveInSize.replace(block, liveIn.get(block).size());
            }

        } while (changed);
    }



    private void addEdge(VirtualRegister u, VirtualRegister v) {
        if (!adjSet.contains(new Pair<>(u, v)) && u != v) {
            adjSet.add(new Pair<>(u, v));
            adjSet.add(new Pair<>(v, u));
            if (!preColored.contains(u)) {
                adjList.get(u).add(v);
                degree.replace(u, degree.get(u) + 1);
            }
            if (!preColored.contains(v)) {
                adjList.get(v).add(u);
                degree.replace(v, degree.get(v) + 1);
            }
        }
    }

    private void build(ASMFunction function) {
        for (ASMBlock block : function.getDfsOrder()) {
            Set<VirtualRegister> live = liveOut.get(block);
            for (ASMInst inst = block.getInstEnd(); inst != null; inst = inst.getPrevInst()) {
                if (inst instanceof Mv) {
                    live.removeAll(inst.getUse().keySet());
                    Set<VirtualRegister> defAndUse = new HashSet<>(inst.getUse().keySet());
                    defAndUse.addAll(inst.getDef().keySet());
                    for (VirtualRegister n : defAndUse) {
                        moveList.get(n).add((Mv) inst);
                    }
                    workListMoves.add((Mv) inst);
                }
                live.addAll(inst.getDef().keySet());
                for (VirtualRegister d : inst.getDef().keySet())
                    for (VirtualRegister l : live)
                        addEdge(l, d);
                live.removeAll(inst.getDef().keySet());
                live.addAll(inst.getUse().keySet());
            }
        }
        /*
        try {
            OutputStream outputStream = new FileOutputStream("reg", false);
            PrintWriter printWriter = new PrintWriter(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------");
        for (Pair<VirtualRegister, VirtualRegister> edge : adjSet) {
            System.out.println(edge.a.emitCode() + " <-----> " + edge.b.emitCode());
        }*/
    }

    private Set<Mv> nodeMoves(VirtualRegister n) {
        Set<Mv> result = new HashSet<>(workListMoves);
        result.addAll(activeMoves);
        result.retainAll(moveList.get(n));
        return result;
    }

    private boolean moveRelated(VirtualRegister n) {
        return !nodeMoves(n).isEmpty();
    }

    private void makeWorkList() {
        for (VirtualRegister n : initial) {
            if (degree.get(n) >= K)
                spillWorkList.add(n);
            else if (moveRelated(n))
                freezeWorkList.add(n);
            else
                simplifyWorkList.add(n);
        }
    }

    private Set<VirtualRegister> adjacent(VirtualRegister n) {
        Set<VirtualRegister> result = new HashSet<>(adjList.get(n));
        result.removeAll(selectStack);
        result.removeAll(coalescedNodes);
        return result;
    }

    private void enableMoves(Set<VirtualRegister> nodes) {
        for (VirtualRegister n : nodes)
            for (Mv m : nodeMoves(n))
                if (activeMoves.contains(m)) {
                    activeMoves.remove(m);
                    workListMoves.add(m);
                }
    }

    private void decrementDegree(VirtualRegister m) {
        int d = degree.get(m);
        degree.replace(m, d - 1);
        if (d == K) {
            Set<VirtualRegister> registers = new HashSet<>(adjacent(m));
            registers.add(m);
            enableMoves(registers);
            spillWorkList.remove(m);
            if (moveRelated(m))
                freezeWorkList.add(m);
            else
                simplifyWorkList.add(m);
        }
    }

    private void simplify() {
        VirtualRegister n = simplifyWorkList.iterator().next();
        simplifyWorkList.remove(n);
        selectStack.push(n);
        for (VirtualRegister m : adjacent(n))
            decrementDegree(m);
    }

    private VirtualRegister getAlias(VirtualRegister n) {
        if (coalescedNodes.contains(n)) {
            VirtualRegister result = getAlias(alias.get(n));
            alias.replace(n, result);
            return result;
        } else
            return n;
    }

    private void addWorkList(VirtualRegister u) {
        if (!preColored.contains(u) && !moveRelated(u) && degree.get(u) < K) {
            freezeWorkList.remove(u);
            simplifyWorkList.add(u);
        }
    }

    private boolean OK(VirtualRegister t, VirtualRegister r) {
        return degree.get(t) < K || preColored.contains(t) || adjSet.contains(new Pair<>(t, r));
    }

    private boolean allOK(VirtualRegister v, VirtualRegister u) {
        for (VirtualRegister t : adjacent(v))
            if (!OK(t, u))
                return false;
        return true;
    }

    private boolean conservative(Set<VirtualRegister> nodes) {
        int k = 0;
        for (VirtualRegister n : nodes)
            if (degree.get(n) >= K)
                k++;
        return k < K;
    }

    private void combine(VirtualRegister u, VirtualRegister v) {
        if (freezeWorkList.contains(v))
            freezeWorkList.remove(v);
        else
            spillWorkList.remove(v);
        coalescedNodes.add(v);
        alias.replace(v, u);
        moveList.get(u).addAll(moveList.get(v));

        Set<VirtualRegister> vSet = new HashSet<>();
        vSet.add(v);
        enableMoves(vSet);
        for (VirtualRegister t : adjacent(v)) {
            addEdge(t, u);
            decrementDegree(t);
        }
        if (degree.get(u) >= K && freezeWorkList.contains(u)) {
            freezeWorkList.remove(u);
            spillWorkList.add(u);
        }

    }

    private Set<VirtualRegister> unionAdj(VirtualRegister u, VirtualRegister v) {
        Set<VirtualRegister> result = new HashSet<>(adjacent(u));
        result.addAll(adjacent(v));
        return result;
    }

    private void coalesce() {
        Mv m = workListMoves.iterator().next();
        VirtualRegister x = getAlias(m.getRd());
        VirtualRegister y = getAlias(m.getRs());

        VirtualRegister u, v;

        if (preColored.contains(y)) {
            u = y;
            v = x;
        } else {
            u = x;
            v = y;
        }

        workListMoves.remove(m);
        if (u == v) {
            coalescedMoves.add(m);
            addWorkList(u);
        }
        else if (preColored.contains(v) || adjSet.contains(new Pair<>(u, v))) {
            constrainedMoves.add(m);
            addWorkList(u);
            addWorkList(v);
        }
        else if ((preColored.contains(u) && allOK(v, u)) || (!preColored.contains(u) && conservative(unionAdj(u, v)))) {
            coalescedMoves.add(m);
            combine(u, v);
            addWorkList(u);
        }
        else {
            activeMoves.add(m);
        }
    }

    private void freezeMoves(VirtualRegister u) {
        for (Mv m : nodeMoves(u)) {
            VirtualRegister v;
            if (getAlias(m.getRs()) == getAlias(u))
                v = getAlias(m.getRd());
            else
                v = getAlias(m.getRs());
            activeMoves.remove(m);
            frozenMoves.add(m);
            if (freezeWorkList.contains(v) && nodeMoves(u).isEmpty()) {
                freezeWorkList.remove(v);
                simplifyWorkList.add(v);
            }
        }
    }

    private void freeze() {
        VirtualRegister u = freezeWorkList.iterator().next();
        freezeWorkList.remove(u);
        simplifyWorkList.add(u);
        freezeMoves(u);
    }

    private VirtualRegister selectVirtualRegisterToSpill() {
        double minCost = Double.POSITIVE_INFINITY;
        VirtualRegister selection = null;
        for (VirtualRegister v : spillWorkList) {
            double curCost;
            if (v.hashNegInfCost())
                curCost = Double.NEGATIVE_INFINITY;
            else if (v.hasPosInfCost())
                curCost = Double.POSITIVE_INFINITY;
            else
                curCost = spillCost.get(v) / degree.get(v);
            if (curCost <= minCost) {
                minCost = curCost;
                selection = v;
            }
        }
        assert selection != null;
        return selection;
    }

    private void selectSpill() {
        VirtualRegister m = selectVirtualRegisterToSpill();
        spillWorkList.remove(m);
        simplifyWorkList.add(m);
        freezeMoves(m);
    }

    private PhysicalRegister selectColor(ArrayList<PhysicalRegister> okColors) {
        for (PhysicalRegister c : okColors) {
            if (c.getRegType() == PhysicalRegister.RegType.caller)
                return c;
        }
        return okColors.iterator().next();
    }

    private void assignColors() {
        while (!selectStack.isEmpty()) {
            VirtualRegister n = selectStack.pop();
            ArrayList<PhysicalRegister> okColors = new ArrayList<>(PhysicalRegister.getAllocatableRegisters().values());
            for (VirtualRegister w : adjList.get(n)) {
                if (preColored.contains(getAlias(w)) || coloredNodes.contains(getAlias(w))) {
                    okColors.remove(getAlias(w).getPhysicalRegister());
                }
            }

            if (okColors.isEmpty())
                spilledNodes.add(n);
            else {
                coloredNodes.add(n);
                PhysicalRegister c = selectColor(okColors);
                n.setPhysicalRegister(c);
            }
        }
        for (VirtualRegister n : coalescedNodes)
            n.setPhysicalRegister(getAlias(n).getPhysicalRegister());
    }

    private void rewriteProgram(ASMFunction function) {
        for (VirtualRegister v : spilledNodes) {
            Address address = new Address(PhysicalRegister.getv("sp"), new IntImm(0));
            function.getStackFrame().getRuntimeRegisterLocation().add(address);

            Set<ASMInst> defs = new HashSet<>(v.getDef().keySet());
            Set<ASMInst> uses = new HashSet<>(v.getUse().keySet());

            for (ASMInst inst : defs) {
                VirtualRegister spilledVR = new VirtualRegister(v.getName() + ".spill");

                ASMBlock block = inst.getAsmBlock();
                inst.replaceDef(v, spilledVR);
                block.insertASMInstAfter(inst, new Sw(block, spilledVR, address));
            }
            for (ASMInst inst : uses) {
                VirtualRegister spilledVR = new VirtualRegister(v.getName() + ".spill");

                ASMBlock block = inst.getAsmBlock();
                inst.replaceUse(v, spilledVR);
                block.insertASMInstBefore(inst, new Lw(block, spilledVR, address));
            }
        }

    }

    private void init(ASMFunction function) {
        preColored = new HashSet<>();
        initial = new HashSet<>();
        simplifyWorkList = new LinkedHashSet<>();
        freezeWorkList = new LinkedHashSet<>();
        spillWorkList = new LinkedHashSet<>();
        spilledNodes = new HashSet<>();
        coalescedNodes = new HashSet<>();
        coloredNodes = new HashSet<>();
        selectStack = new Stack<>();
        degree = new HashMap<>();

        coalescedMoves = new HashSet<>();
        constrainedMoves = new HashSet<>();
        frozenMoves = new HashSet<>();
        workListMoves = new LinkedHashSet<>();
        activeMoves = new HashSet<>();
        adjSet = new HashSet<>();
        adjList = new HashMap<>();
        moveList = new HashMap<>();
        alias = new HashMap<>();
        spillCost = new HashMap<>();


        for (ASMBlock block : function.getDfsOrder())
            for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                initial.addAll(inst.getDef().keySet());
                initial.addAll(inst.getUse().keySet());
            }

        preColored.addAll(PhysicalRegister.virtualRegisters.values());

        for (VirtualRegister v : initial) {

            adjList.put(v, new HashSet<>());
            moveList.put(v, new HashSet<>());
            alias.put(v, null);
            degree.put(v, 0);

            if (!preColored.contains(v)) {
                spillCost.put(v, (double) 0);
                v.setPhysicalRegister(null);
            } else {
                spillCost.put(v, (double) 1000000000);
            }
        }

        initial.removeAll(preColored);
    }

    private void computeSpillCost(ASMFunction function) {
        LoopAnalysis loopAnalysis = new LoopAnalysis(function.getIrFunction());
        for (ASMBlock block : function.getDfsOrder()) {
            int depth = loopAnalysis.computeLoopDepth(block.getIrBlock());
            double extraCost = Math.pow(10, depth);
            for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                inst.getDef().keySet().forEach(v->spillCost.replace(v, spillCost.get(v) + extraCost));
                inst.getUse().keySet().forEach(v->spillCost.replace(v, spillCost.get(v) + extraCost));
            }
        }
    }

    @Override
    public void functionPass(ASMFunction function) {
        init(function);
        livenessAnalysis(function);
        computeSpillCost(function);
        build(function);
        makeWorkList();
        do {
            if (!simplifyWorkList.isEmpty()) simplify();
            else if (!workListMoves.isEmpty()) coalesce();
            else if (!freezeWorkList.isEmpty()) freeze();
            else if (!spillWorkList.isEmpty()) selectSpill();
        } while (
            !simplifyWorkList.isEmpty() || !workListMoves.isEmpty() ||
            !freezeWorkList.isEmpty()   || !spillWorkList.isEmpty()
        );

        assignColors();

        if (!spilledNodes.isEmpty()) {
            rewriteProgram(function);
            functionPass(function);
        } else {

            for (ASMBlock block : function.getDfsOrder())
                for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
                    if (inst instanceof Mv && ((Mv) inst).getRd().getPhysicalRegister() == ((Mv) inst).getRs().getPhysicalRegister())
                        ((Mv) inst).remove();


            function.getStackFrame().calcFrameSize();
            int frameSize = function.getStackFrame().getFrameSize();
            if (frameSize == 0)
                return;
            function.getEntryBlock().appendASMInstFront(new Addi(function.getEntryBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(-4 * frameSize)));
            function.getExitBlock().insertASMInstBefore(function.getExitBlock().getInstEnd(), new Addi(
                    function.getExitBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(4 * frameSize)
            ));
        }
    }

    @Override
    public void blockPass(ASMBlock block) {

    }
}
