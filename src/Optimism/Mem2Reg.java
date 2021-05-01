package Optimism;

import Backend.IRPrinter;
import IR.BasicBlock;
import IR.Function;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.LocalRegister;
import IR.Operand.Operand;
import IR.Operand.Register;
import IR.TypeSystem.PointerIRT;
import Util.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class Mem2Reg extends Pass {
    private DominatorTree dominatorTree;
    private Map<BasicBlock, Map<Register, PhiInst>> phiMap;
    private Map<BasicBlock, Map<Register, Operand>> addressLiveOut;
    private Map<BasicBlock, Set<LoadInst>> loadInstSet;
    private Map<BasicBlock, Map<AllocaInst, Operand>> renameTable;
    private Map<LoadInst, AllocaInst> loadInstAllocaInstMap;
    private Map<StoreInst, AllocaInst> storeInstAllocaInstMap;

    private Map<Operand, Operand> replaceMap;

    public Mem2Reg(Module module) {
        super(module);
    }

    @Override
    public boolean run() {
        phiMap = new LinkedHashMap<>();
        renameTable = new LinkedHashMap<>();
        loadInstAllocaInstMap = new LinkedHashMap<>();
        storeInstAllocaInstMap = new LinkedHashMap<>();
        addressLiveOut = new LinkedHashMap<>();
        replaceMap = new LinkedHashMap<>();
        loadInstSet = new LinkedHashMap<>();
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
                    Operand oldOperand = loadInst.getResult();
                    ArrayList<IRInst> irInsts = new ArrayList<>(oldOperand.getUse().keySet());
                    for (IRInst irInst : irInsts) {
                        oldOperand.removeUse(irInst);
                        irInst.replaceUse(oldOperand, value);
                        value.addUse(irInst);
                    }

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
                    for (IRInst irInst : irInsts) {
                        oldOperand.removeUse(irInst);
                        irInst.replaceUse(oldOperand, curValue);
                        curValue.addUse(irInst);
                    }

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
        Set<AllocaInst> allocInstSet = new LinkedHashSet<>();
        ArrayList<BasicBlock> blocks = function.getDfsOrder();
        blocks.forEach(block -> {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof AllocaInst)
                    allocInstSet.add((AllocaInst) inst);
            }
        });

        blocks.forEach(basicBlock -> {
            phiMap.put(basicBlock, new LinkedHashMap<>());
            addressLiveOut.put(basicBlock, new LinkedHashMap<>());
            renameTable.put(basicBlock, new LinkedHashMap<>());
            loadInstSet.put(basicBlock, new LinkedHashSet<>());
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

        Set<BasicBlock> defBlocks = new LinkedHashSet<>();

        collectInfo(function, allocInstSet, blocks, defBlocks);

        placingPhi(function, allocInstSet, defBlocks);

        rename(function, allocInstSet, blocks);

    }

    private void collectInfo(Function function, Set<AllocaInst> allocaInstSet, ArrayList<BasicBlock> blocks, Set<BasicBlock> defBlocks) {
        Set<Operand> allocaArrdessSet = new LinkedHashSet<>();
        for (AllocaInst allocaInst : allocaInstSet)
            allocaArrdessSet.add(allocaInst.getResult());

        for (BasicBlock block : blocks) {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof LoadInst) {
                    Operand address = ((LoadInst) inst).getAddress();
                    if (((LoadInst) inst).getResult().getUse().isEmpty())
                        inst.removeFromBlock();
                    else if (allocaArrdessSet.contains(address)) {
                        assert address instanceof Register;
                        if (addressLiveOut.get(block).containsKey(address)) {
                            replaceMap.put(((LoadInst) inst).getResult(),
                                    addressLiveOut.get(block).get(address));
                            inst.removeFromBlock();
                        } else
                            loadInstSet.get(block).add((LoadInst) inst);
                    }
                } else if (inst instanceof StoreInst && allocaArrdessSet.contains(((StoreInst) inst).getAddress())) {
                    defBlocks.add(block);
                    addressLiveOut.get(block).put((Register) ((StoreInst) inst).getAddress(), ((StoreInst) inst).getValue());
                    inst.removeFromBlock();
                }
            }
        }
    }

    private void rename(Function function, Set<AllocaInst> allocaInstArrayList, ArrayList<BasicBlock> blocks) {
        for (BasicBlock block : blocks) {
            if (!phiMap.get(block).isEmpty()) {
                for (Register register : phiMap.get(block).keySet()) {
                    PhiInst phiInst = phiMap.get(block).get(register);
                    for (BasicBlock preBlock : block.getPredecessors()) {
                        BasicBlock runner = preBlock;
                        while (runner != null && !addressLiveOut.get(runner).containsKey(register))
                            runner = dominatorTree.getIDom(runner);
                        if (runner != null)
                            phiInst.appendBranch(addressLiveOut.get(runner).get(register), preBlock);
                        else
                            phiInst.appendBranch(phiInst.getResult().getType().getDefaultValue(), preBlock);
                    }
                }
            }
            if (!loadInstSet.get(block).isEmpty()) {
                for (LoadInst loadInst : loadInstSet.get(block)) {
                    assert loadInst.getAddress() instanceof Register;
                    Register address = (Register) loadInst.getAddress();
                    Operand replace;
                    if (phiMap.get(block).containsKey(address)) {
                        replace = phiMap.get(block).get(address).getResult();
                    } else {
                        BasicBlock runner = dominatorTree.getIDom(block);
                        while (true) {
                            if (addressLiveOut.get(runner).containsKey(address)) {
                                replace = addressLiveOut.get(runner).get(address);
                                break;
                            } else runner = dominatorTree.getIDom(runner);
                        }
                    }
                    replaceMap.put(loadInst.getResult(), replace);
                    loadInst.removeFromBlock();
                }
            }
        }
        replaceMap.forEach((operand1, operand2) -> {
            while (replaceMap.containsKey(operand2))
                operand2 = replaceMap.get(operand2);
            operand1.replaceAllUse(operand2);
        });

        for (AllocaInst allocaInst : allocaInstArrayList)
            allocaInst.removeFromBlock();
    }

    private void placingPhi(Function function, Set<AllocaInst> allocaInstSet, Set<BasicBlock> defBlocks) {
        Queue<BasicBlock> blockQueue = new ArrayDeque<>();
        Set<BasicBlock> visited = new LinkedHashSet<>();
        Set<BasicBlock> phiSet = new LinkedHashSet<>();

        blockQueue.addAll(defBlocks);

        while (!blockQueue.isEmpty()) {
            BasicBlock block = blockQueue.poll();
            if (!addressLiveOut.get(block).isEmpty()) {
                for (BasicBlock dom : dominatorTree.getDomFrontier(block)) {
                    for (Register register : addressLiveOut.get(block).keySet()) {
                        Operand operand = addressLiveOut.get(block).get(register);
                        IRInst inst = register.getDef().keySet().iterator().next();
                        assert inst instanceof AllocaInst;
                        if (!phiMap.get(dom).containsKey(register)) {
                            PhiInst phiInst = new PhiInst(dom, new LinkedHashMap<>(),
                                    new LocalRegister(((AllocaInst) inst).getType(), register.getName() + ".phi"));
                            // TODO: 2021/5/1
                            dom.appendInstFront(phiInst);
                            if (!addressLiveOut.get(dom).containsKey(register)) {
                                addressLiveOut.get(dom).put(register, phiInst.getResult());
                                blockQueue.offer(dom);
                            }
                            phiMap.get(dom).put(register, phiInst);
                        }
                    }
                }
            }
        }
    }
    @Override
    protected void blockPass(BasicBlock block) {

    }
}
