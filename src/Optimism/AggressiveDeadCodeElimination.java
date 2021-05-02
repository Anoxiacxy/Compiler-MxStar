package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.*;
import IR.TypeSystem.ArrayIRT;
import IR.TypeSystem.PointerIRT;
import Util.Pass;

import java.util.*;

public class AggressiveDeadCodeElimination extends Pass {
    Map<Function, Set<Function>> caller;

    Map<BasicBlock, Set<Operand>> liveIn, liveOut;
    Set<IRInst> liveInstSet;
    Set<Operand> outerOperandSet;
    Set<Function> sideEffect;

    public AggressiveDeadCodeElimination(Module module) {
        super(module);
    }

    private void livenessAnalysis(Function function) {
        liveIn = new LinkedHashMap<>();
        liveOut = new LinkedHashMap<>();
        Map<BasicBlock, Set<Operand>> def = new LinkedHashMap<>();
        Map<BasicBlock, Set<Operand>> use = new LinkedHashMap<>();
        Map<BasicBlock, Integer> liveInSize = new LinkedHashMap<>();
        Map<BasicBlock, Integer> liveOutSize = new LinkedHashMap<>();

        ArrayList<BasicBlock> blocks = function.getDfsOrder();
        for (BasicBlock block : blocks) {
            Set<Operand> curDef = new LinkedHashSet<>();
            Set<Operand> curUse = new LinkedHashSet<>();

            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                for (Operand operand : inst.getUse().keySet())
                    if (!curDef.contains(operand))
                        curUse.add(operand);
                curDef.addAll(inst.getDef().keySet());
            }

            def.put(block, curDef);
            use.put(block, curUse);
        }

        for (BasicBlock block : blocks) {
            liveOut.put(block, new LinkedHashSet<>());
            liveIn.put(block, new LinkedHashSet<>());
            liveOutSize.put(block, 0);
            liveInSize.put(block, 0);
        }

        Collections.reverse(blocks);

        boolean changed;
        do {
            for (BasicBlock block : blocks) {
                Set<Operand> curOut = new LinkedHashSet<>();
                for (BasicBlock succ : block.getSuccessors())
                    curOut.addAll(liveIn.get(succ));
                liveOut.replace(block, curOut);

                Set<Operand> curIn = new LinkedHashSet<>(curOut);
                curIn.removeAll(def.get(block));
                curIn.addAll(use.get(block));
                liveIn.replace(block, curIn);
            }
            changed = false;
            for (BasicBlock block : blocks) {
                if (liveOutSize.get(block) != liveOut.get(block).size())
                    changed = true;
                liveOutSize.replace(block, liveOut.get(block).size());

                if (liveInSize.get(block) != liveIn.get(block).size())
                    changed = true;
                liveInSize.replace(block, liveIn.get(block).size());
            }

        } while (changed);
    }

    void buildCaller(Module module) {
        for (Function function : module.getFunctionMap().values()) {
            for (BasicBlock block : function.getDfsOrder()) {
                for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    if (inst instanceof CallInst) {
                        if (((CallInst) inst).getFunction().isExternal()) continue;
                        caller.get(function).add(((CallInst) inst).getFunction());
                    }
                }
            }
        }
    }

    @Override
    protected void modulePass(Module module) {
        caller = new LinkedHashMap<>();
        for (Function function : module.getFunctionMap().values())
            caller.put(function, new LinkedHashSet<>());

        outerOperandSet = new LinkedHashSet<>();
        sideEffect = new LinkedHashSet<>();
        liveInstSet = new LinkedHashSet<>();
        buildCaller(module);
        initOuterOperand(module);
        initLiveInstSet(module);

        for (Function function : module.getFunctionMap().values())
            functionPass(function);

        for (Function function : module.getFunctionMap().values())
            elimination(function);
    }

    @Override
    protected void functionPass(Function function) {
        for (BasicBlock block : function.getDfsOrder())
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
                if (liveInstSet.contains(inst))
                    makeLive(inst);
        //livenessAnalysis(function);

    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        changed = false;
        modulePass(module);
        return changed;
    }

    private void addSideEffect(Function function) {
        sideEffect.add(function);
        for (Function caller : caller.get(function)) {
            if (!sideEffect.contains(caller))
                addSideEffect(caller);
        }
    }

    private void initLiveInstSet(Module module) {
        sideEffect.add(module.getSystemFunctionMap().get("mx__print"));
        sideEffect.add(module.getSystemFunctionMap().get("mx__println"));
        sideEffect.add(module.getSystemFunctionMap().get("mx__printInt"));
        sideEffect.add(module.getSystemFunctionMap().get("mx__printlnInt"));
        sideEffect.add(module.getSystemFunctionMap().get("mx__getString"));
        sideEffect.add(module.getSystemFunctionMap().get("mx__getInt"));

        for (Function function : module.getFunctionMap().values()) {
            for (BasicBlock block : function.getDfsOrder()) {
                for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    if (inst instanceof StoreInst) {
                        if (outerOperandSet.contains(((StoreInst) inst).getAddress())) {
                            liveInstSet.add(inst);
                            addSideEffect(function);
                        }
                    }
                    else if (inst instanceof CallInst) {
                        if (sideEffect.contains(((CallInst) inst).getFunction())) {
                            liveInstSet.add(inst);
                            addSideEffect(function);
                        }
                    }
                    else if (inst instanceof RetInst) {
                        liveInstSet.add(inst);
                    }
                }
            }
        }

        for (Function function : module.getFunctionMap().values())
            for (BasicBlock block : function.getDfsOrder())
                for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
                    if (inst instanceof CallInst && sideEffect.contains(((CallInst) inst).getFunction()))
                        liveInstSet.add(inst);
    }

    private void initOuterOperand(Module module) {
        outerOperandSet.addAll(module.getGlobalVariableMap().values());
        outerOperandSet.addAll(module.getConstantStringMap().values());

        for (Function function : module.getFunctionMap().values()) {
            for (Parameter parameter : function.getParameters()) {
                if (parameter.getType() instanceof ArrayIRT || parameter.getType() instanceof PointerIRT) {
                    outerOperandSet.add(parameter);
                }
            }
        }

        Queue<Operand> operandQueue = new ArrayDeque<>(outerOperandSet);
        while (!operandQueue.isEmpty()) {
            Operand operand = operandQueue.poll();
            assert operand.getType() instanceof PointerIRT || operand.getType() instanceof ArrayIRT;
            for (IRInst inst : operand.getUse().keySet()) {
                if (inst instanceof StoreInst) {
                    if (!outerOperandSet.contains(((StoreInst) inst).getAddress())) {
                        operandQueue.offer(((StoreInst) inst).getAddress());
                        outerOperandSet.add(((StoreInst) inst).getAddress());
                    }
                }
                else if (inst instanceof BitCastToInst
                        || inst instanceof GetElementPtrInst
                        || inst instanceof CallInst
                        || inst instanceof LoadInst
                        || inst instanceof PhiInst
                ) {
                    if (inst.getDef().isEmpty()) continue;
                    Operand def = inst.getDef().keySet().iterator().next();
                    if (!outerOperandSet.contains(def)) {
                        operandQueue.offer(def);
                        outerOperandSet.add(def);
                    }
                }
            }
        }
    }

    private void makeLive(IRInst inst) {
        liveInstSet.add(inst);

        for (Operand operand : inst.getUse().keySet()) {
            if (!operand.getDef().isEmpty()) {
                assert operand instanceof LocalRegister;
                if (!liveInstSet.contains(((LocalRegister) operand).getDefInst()))
                    makeLive(((LocalRegister) operand).getDefInst());
            } else if (operand.getType() instanceof PointerIRT || operand.getType() instanceof ArrayIRT) {
                for (IRInst relativeInst : operand.getUse().keySet()) {
                    if (relativeInst instanceof StoreInst
                            || relativeInst instanceof LoadInst && (
                                ((LoadInst) relativeInst).getType() instanceof PointerIRT
                                    || ((LoadInst) relativeInst).getType() instanceof ArrayIRT
                            )
                            || relativeInst instanceof BitCastToInst
                            || relativeInst instanceof GetElementPtrInst
                            || relativeInst instanceof PhiInst
                    ) {
                        if (!liveInstSet.contains(relativeInst))
                            makeLive(relativeInst);
                    }
                }
            }
        }

        for (Operand operand : inst.getDef().keySet()) {
            if (operand.getType() instanceof PointerIRT || operand.getType() instanceof ArrayIRT) {
                for (IRInst relativeInst : operand.getUse().keySet()) {
                    if (relativeInst instanceof StoreInst
                            || relativeInst instanceof LoadInst && (
                            ((LoadInst) relativeInst).getType() instanceof PointerIRT
                                    || ((LoadInst) relativeInst).getType() instanceof ArrayIRT
                    )
                            || relativeInst instanceof BitCastToInst
                            || relativeInst instanceof GetElementPtrInst
                            || relativeInst instanceof PhiInst
                    ) {
                        if (!liveInstSet.contains(relativeInst))
                            makeLive(relativeInst);
                    }
                }
            }
        }

        for (BasicBlock pre : inst.getBasicBlock().getPredecessors()) {
            IRInst terminal = pre.getInstEnd();
            if (!liveInstSet.contains(terminal))
                makeLive(terminal);
        }

    }

    private void elimination(Function function) {
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock()) {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (!liveInstSet.contains(inst)) {
                    changed = true;
                    if (inst instanceof RetInst) {
                        assert false;
                    } else if (inst instanceof BrInst) {
                        BasicBlock target = ((BrInst) inst).getThemBlock();

                        block.appendInstBack(new BrInst(block, null, block, null));

                        for (IRInst irInst = target.getInstBegin(); irInst != null; irInst = irInst.getNextInst()) {
                            if (irInst instanceof PhiInst)
                                ((PhiInst) irInst).removeBranch(block);
                        }

                        inst.removeFromBlock();

                        changed = true;
                    } else
                        inst.removeFromBlock();
                }
            }
        }
    }
}
