package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.LocalRegister;
import IR.Operand.Operand;
import IR.Operand.Register;
import Util.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class Mem2Reg extends Pass {
    private DominatorTree dominatorTree;
    private Map<BasicBlock, Map<AllocaInst, PhiInst>> phiMap;
    private Map<BasicBlock, Map<AllocaInst, Operand>> renameTable;
    private Map<LoadInst, AllocaInst> loadInstAllocaInstMap;
    private Map<StoreInst, AllocaInst> storeInstAllocaInstMap;

    public Mem2Reg(Module module) {
        super(module);
    }

    @Override
    public boolean run() {
        phiMap = new LinkedHashMap<>();
        renameTable = new LinkedHashMap<>();
        loadInstAllocaInstMap = new LinkedHashMap<>();
        storeInstAllocaInstMap = new LinkedHashMap<>();
        modulePass(module);
        return false;
    }

    @Override
    protected void modulePass(Module module) {
        module.getFunctionMap().values().forEach(this::functionPass);
    }

    private void basicOptimizations(AllocaInst allocaInst) {
        Register address = allocaInst.getResult();
        assert address.getDef().keySet().size() == 1;
        ArrayList<IRInst> useInstList = new ArrayList<>(address.getUse().keySet());

        // Unused allocas are removed.
        if (useInstList.size() == 0) {
            allocaInst.removeFromBlock();
            return;
        }

        boolean onlyForLoadAndStore = true;
        ArrayList<StoreInst> allocStore = new ArrayList<>();
        ArrayList<LoadInst> allocLoad = new ArrayList<>();
        for (IRInst inst : useInstList)
            if (inst instanceof LoadInst) {
                allocLoad.add((LoadInst) inst);
            } else if (inst instanceof StoreInst) {
                allocStore.add((StoreInst) inst);
            } else {
                onlyForLoadAndStore = false;
                break;
            }

        assert onlyForLoadAndStore;

        // If there is only one defining block for an alloca,
        // all loads which are dominated by the definition are replaced with the value.
        if (allocStore.size() == 1) {

            StoreInst storeInst = allocStore.get(0);
            assert storeInst.getAddress() == address;
            Operand value = allocStore.get(0).getValue();

            for (LoadInst loadInst : allocLoad) {
                if (loadInst.getResult().getUse().size() > 0) {
                    Operand oldOperand = ((LoadInst) loadInst).getResult();
                    ArrayList<IRInst> irInsts = new ArrayList<>(oldOperand.getUse().keySet());
                    for (IRInst irInst : irInsts)
                        irInst.replaceUse(oldOperand, value);

                    //loadInst.getBasicBlock().insertInstAfter(loadInst,
                    //        new MoveInst(loadInst.getBasicBlock(), value, loadInst.getResult()));
                }
                loadInst.removeFromBlock();
            }
            storeInst.removeFromBlock();
            allocaInst.removeFromBlock();

            return;
        }


        // allocas which are read and written only in a block can avoid traversing CFG,
        // and PHI-node insertion by simply inserting each load with the value from nearest store.
        boolean allInSameBlock = true;
        for (IRInst inst : useInstList)
            if (inst.getBasicBlock() != useInstList.get(0).getBasicBlock()) {
                allInSameBlock = false;
                break;
            }

        if (allInSameBlock) {
            BasicBlock block = useInstList.get(0).getBasicBlock();
            ArrayList<IRInst> instFromBlock = new ArrayList<>();
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
                instFromBlock.add(inst);

            Operand curValue = null;
            for (IRInst inst : instFromBlock) {
                if (inst instanceof LoadInst && ((LoadInst) inst).getAddress() == address) {
                    assert curValue != null;

                    Operand oldOperand = ((LoadInst) inst).getResult();
                    ArrayList<IRInst> irInsts = new ArrayList<>(((LoadInst) inst).getResult().getUse().keySet());
                    for (IRInst irInst : irInsts)
                        irInst.replaceUse(oldOperand, curValue);

                    inst.removeFromBlock();
                }
                if (inst instanceof StoreInst && ((StoreInst) inst).getAddress() == address) {
                    curValue = ((StoreInst) inst).getValue();
                    inst.removeFromBlock();
                }
            }
            allocaInst.removeFromBlock();
        }
    }

    @Override
    protected void functionPass(Function function) {
        Set<AllocaInst> allocInstSet = new HashSet<>();
        ArrayList<BasicBlock> blocks = function.getDfsOrder();
        blocks.forEach(block -> {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof AllocaInst)
                    allocInstSet.add((AllocaInst) inst);
            }
        });

        blocks.forEach(basicBlock -> {
            phiMap.put(basicBlock, new LinkedHashMap<>());
            renameTable.put(basicBlock, new LinkedHashMap<>());
        });

        for (AllocaInst allocaInst : allocInstSet)
            basicOptimizations(allocaInst);

        allocInstSet.clear();
        blocks.forEach(block -> {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof AllocaInst)
                    allocInstSet.add((AllocaInst) inst);
            }
        });

        if (allocInstSet.isEmpty()) return;

        dominatorTree = new DominatorTree(function);
        dominatorTree.run();

        for (AllocaInst allocaInst : allocInstSet)
            placingPhi(allocaInst);

        blocks.forEach(block -> {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof LoadInst && ((LoadInst) inst).getResult().getUse().isEmpty())
                    inst.removeFromBlock();
            }
        });

        rename(function, allocInstSet);


    }

    private void rename(Function function, Set<AllocaInst> allocaInstArrayList) {
        Stack<Pair<BasicBlock,BasicBlock>> blockStack = new Stack<>();
        Set<BasicBlock> visited = new HashSet<>();
        blockStack.push(new Pair<>(function.getEntryBlock(), null));

        while (!blockStack.isEmpty()) {
            Pair<BasicBlock, BasicBlock> data = blockStack.pop();
            BasicBlock block = data.a;
            Map<AllocaInst, PhiInst> curPhiMap = phiMap.get(block);
            for (AllocaInst allocaInst : curPhiMap.keySet()) {
                PhiInst phiInst = curPhiMap.get(allocaInst);
                Operand operand = renameTable.get(data.b)
                        .getOrDefault(allocaInst, allocaInst.getType().getDefaultValue());
                phiInst.appendBranch(operand, data.b);
            }

            if (data.b != null) {
                for (AllocaInst inst : allocaInstArrayList)
                    if (!curPhiMap.containsKey(inst))
                        renameTable.get(block).put(inst, renameTable.get(data.b).get(inst));
            }
            if (visited.contains(block))
                continue;
            visited.add(block);

            for (AllocaInst allocaInst : curPhiMap.keySet())
                renameTable.get(block).put(allocaInst, curPhiMap.get(allocaInst).getResult());

            for (IRInst irInst = block.getInstBegin(); irInst != null; irInst = irInst.getNextInst()) {
                if (irInst instanceof LoadInst && loadInstAllocaInstMap.containsKey(irInst)) {
                    AllocaInst allocaInst = loadInstAllocaInstMap.get(irInst);
                    Operand newOperand = renameTable.get(block).get(allocaInst);
                    Operand oldOperand = ((LoadInst) irInst).getResult();
                    ArrayList<IRInst> irInsts = new ArrayList<>(oldOperand.getUse().keySet());
                    for (IRInst inst : irInsts)
                        inst.replaceUse(oldOperand, newOperand);
                    irInst.removeFromBlock();
                } else if (irInst instanceof StoreInst && storeInstAllocaInstMap.containsKey(irInst)) {
                    AllocaInst allocaInst = storeInstAllocaInstMap.get(irInst);
                    Operand newOperand = ((StoreInst) irInst).getValue();
                    if (renameTable.get(block).containsKey(allocaInst))
                        renameTable.get(block).replace(allocaInst, newOperand);
                    else
                        renameTable.get(block).put(allocaInst,newOperand);
                    irInst.removeFromBlock();
                }
            }

            //blockStack.addAll(block.getSuccessors());
            for (BasicBlock basicBlock : block.getSuccessors())
                blockStack.push(new Pair<>(basicBlock, block));

            for (PhiInst phiInst : curPhiMap.values())
                block.appendInstFront(phiInst);

        }
    }

    private void placingPhi(AllocaInst allocaInst) {
        Queue<BasicBlock> blockQueue = new ArrayDeque<>();
        Set<BasicBlock> visited = new HashSet<>();

        Operand address = allocaInst.getResult();
        ArrayList<IRInst> useInstList = new ArrayList<>(address.getUse().keySet());

        for (IRInst irInst : useInstList) {
            if (irInst instanceof LoadInst) {
                loadInstAllocaInstMap.put((LoadInst) irInst, allocaInst);
            } else {
                assert irInst instanceof StoreInst;
                if (!visited.contains(irInst.getBasicBlock())) {
                    blockQueue.offer(irInst.getBasicBlock());
                    visited.add(irInst.getBasicBlock());
                }
                storeInstAllocaInstMap.put((StoreInst) irInst, allocaInst);
            }
        }

        while (!blockQueue.isEmpty()) {
            BasicBlock block = blockQueue.poll();

            for (BasicBlock dom : dominatorTree.getDomFrontier(block)) {
                if (!visited.contains(dom)) {
                    PhiInst phiInst = new PhiInst(dom, new LinkedHashMap<>(),
                            new LocalRegister(allocaInst.getType(), allocaInst.getResult().getName() + ".phi"));
                    phiMap.get(dom).put(allocaInst, phiInst);
                    visited.add(dom);
                    blockQueue.offer(dom);
                }
            }
        }

        allocaInst.removeFromBlock();
    }
    @Override
    protected void blockPass(BasicBlock block) {

    }
}
