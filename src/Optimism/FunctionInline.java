package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.Operand;
import IR.Operand.Register;
import Util.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class FunctionInline extends Pass {
    private final int instructionLimit = 200;
    Map<Function, Integer> instCountOfFunction;
    Map<Function, Set<Function>> calleeSet;
    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values()) functionPass(function);
        for (Function function : module.getFunctionMap().values()) calcCalleeSet(function);

        boolean totalChanged = false;
        do {
            changed = false;
            nonRecursiveInline();
            totalChanged |= changed;
            break;
        } while (changed);

        /*

        int inlineDepth = 3;
        do {
            changed = false;
            recursiveInline();
            totalChanged |= changed;
            break;
        } while (inlineDepth -- > 0);
        */
        changed = totalChanged;
    }

    private Pair<ArrayList<BasicBlock>, RetInst> cloneFunction(Function caller, Function callee, ArrayList<Operand> parameter) {
        Map<BasicBlock, BasicBlock> clonedBlockMap = new LinkedHashMap<>();
        Map<Operand, Operand> clonedOperandMap = new LinkedHashMap<>();

        ArrayList<BasicBlock> clonedBlocks = new ArrayList<>();
        RetInst retInst = null;

        for (int i = 0; i < parameter.size(); i++)
            clonedOperandMap.put(callee.getParameters().get(i), parameter.get(i));

        for (BasicBlock block = callee.getEntryBlock(); block != null; block = block.getNextBlock()) {
            BasicBlock clonedBlock = new BasicBlock(caller, block.getName() + ".clone");
            clonedBlockMap.put(block, clonedBlock);
            clonedBlocks.add(clonedBlock);
        }

        for (int i = 0; i < clonedBlocks.size(); i++) {
            BasicBlock block = clonedBlocks.get(i);
            if (i > 0)
                block.setPrevBlock(clonedBlocks.get(i - 1));

            if (i < clonedBlocks.size() - 1)
                block.setNextBlock(clonedBlocks.get(i + 1));
        }

        for (BasicBlock block = callee.getEntryBlock(); block != null; block = block.getNextBlock()) {
            BasicBlock clonedBlock = clonedBlockMap.get(block);

            ArrayList<IRInst> clonedInsts = new ArrayList<>();

            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                IRInst clonedInst = inst.clone(clonedBlock);
                clonedInsts.add(clonedInst);
                for (Operand operand : inst.getDef().keySet()) {
                    if (!clonedOperandMap.containsKey(operand))
                        clonedOperandMap.put(operand, operand.clone());
                    clonedInst.replaceDef(operand, clonedOperandMap.get(operand));
                }
                for (Operand operand : inst.getUse().keySet()) {
                    if (!clonedOperandMap.containsKey(operand))
                        clonedOperandMap.put(operand, operand.clone());
                    clonedInst.replaceUse(operand, clonedOperandMap.get(operand));
                }
                if (clonedInst instanceof RetInst) {
                    assert retInst == null;
                    retInst = (RetInst) clonedInst;
                }
                if (clonedInst instanceof PhiInst) {
                    assert inst instanceof PhiInst;
                    for (Pair<Operand, BasicBlock> pair : ((PhiInst) inst).getBranch()) {
                        ((PhiInst)clonedInst).replaceBranch(pair.b, clonedBlockMap.get(pair.b));
                    }
                }
                if (clonedInst instanceof BrInst) {
                    if (((BrInst) inst).getThemBlock() != null)
                        ((BrInst) clonedInst).setThemBlock(clonedBlockMap.get(((BrInst) inst).getThemBlock()));
                    if (((BrInst) inst).getElseBlock() != null)
                        ((BrInst) clonedInst).setElseBlock(clonedBlockMap.get(((BrInst) inst).getElseBlock()));
                }
            }

            for (int i = 0; i < clonedInsts.size(); i++) {
                IRInst inst = clonedInsts.get(i);
                if (i > 0)
                    inst.setPrevInst(clonedInsts.get(i - 1));
                else
                    clonedBlock.setInstBegin(inst);

                if (i < clonedInsts.size() - 1)
                    inst.setNextInst(clonedInsts.get(i + 1));
                else
                    clonedBlock.setInstEnd(inst);
            }
        }

        return new Pair<>(clonedBlocks, retInst);
    }

    private BasicBlock inlineFunction(CallInst callInst) {
        Function caller = callInst.getBasicBlock().getFunction();
        Function callee = callInst.getFunction();

        Pair<ArrayList<BasicBlock>, RetInst> cloneResult = cloneFunction(caller, callee, callInst.getParameters());
        ArrayList<BasicBlock> cloneBlocks = cloneResult.a;
        RetInst retInst = cloneResult.b;

        BasicBlock up = callInst.getBasicBlock();
        BasicBlock down = up.spilt(callInst);

        int blockCount = cloneBlocks.size();
        up.setNextBlock(cloneBlocks.get(0));
        cloneBlocks.get(0).setPrevBlock(up);
        down.setPrevBlock(cloneBlocks.get(blockCount - 1));
        cloneBlocks.get(blockCount - 1).setNextBlock(down);

        assert retInst != null;

        if (callInst.getResult() != null) {
            assert retInst.getValue() != null;
            callInst.getResult().replaceAllUse(retInst.getValue());
        }

        retInst.removeFromBlock();
        callInst.removeFromBlock();

        assert up.getInstEnd() instanceof BrInst;
        ((BrInst) up.getInstEnd()).setThemBlock(cloneBlocks.get(0));
        cloneBlocks.get(blockCount - 1).appendInstBack(
                new BrInst(cloneBlocks.get(blockCount - 1), null, down, null));

        return down;
    }


    private void recursiveInline() {
        for (Function function : module.getFunctionMap().values()) {
            for (BasicBlock block = function.getExitBlock(), next; block != null; block = next) {
                next = block.getNextBlock();
                for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    if (inst instanceof CallInst) {
                        if (!module.getFunctionMap().values().contains(
                                ((CallInst) inst).getFunction()
                        )) continue;
                        if (!calleeSet.get(((CallInst) inst).getFunction()).contains(function))
                            continue;
                        if (instCountOfFunction.get(((CallInst) inst).getFunction()) > instructionLimit)
                            continue;
                        instCountOfFunction.replace(function,
                                instCountOfFunction.get(function) - 2 +
                                        instCountOfFunction.get(((CallInst) inst).getFunction()));
                        next = inlineFunction((CallInst) inst);
                        changed = true;
                        break;
                    }
                }
            }
        }
    }

    private void nonRecursiveInline() {
        for (Function function : module.getFunctionMap().values()) {
            for (BasicBlock block = function.getExitBlock(), next; block != null; block = next) {
                next = block.getNextBlock();
                for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    if (inst instanceof CallInst) {
                        if (!module.getFunctionMap().values().contains(
                                ((CallInst) inst).getFunction()
                        )) continue;
                        if (function == ((CallInst) inst).getFunction())
                            continue;
                        if (calleeSet.get(((CallInst) inst).getFunction())
                            .contains(((CallInst) inst).getFunction()))
                            continue;
                        if (instCountOfFunction.get(((CallInst) inst).getFunction()) > instructionLimit)
                            continue;
                        instCountOfFunction.replace(function,
                             instCountOfFunction.get(function) - 2 +
                             instCountOfFunction.get(((CallInst) inst).getFunction()));
                        next = inlineFunction((CallInst) inst);
                        changed = true;
                        break;
                    }
                }
            }
        }
    }

    private void calcCalleeSet(Function function) {
        Queue<Function> functionQueue = new ArrayDeque<>();
        functionQueue.addAll(calleeSet.get(function));
        while (!functionQueue.isEmpty()) {
            Function caller = functionQueue.poll();
            for (Function callee : calleeSet.get(caller)) {
                if (!calleeSet.get(function).contains(callee)) {
                    functionQueue.add(callee);
                    calleeSet.get(function).add(callee);
                }
            }
        }
    }

    @Override
    protected void functionPass(Function function) {
        calleeSet.put(function, new LinkedHashSet<>());
        int count = 0;
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock()) {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                count++;
                if (inst instanceof CallInst) {
                    if (module.getFunctionMap().values().contains(((CallInst) inst).getFunction()))
                        calleeSet.get(function).add(((CallInst) inst).getFunction());
                }
            }
        }
        instCountOfFunction.put(function, count);
    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        instCountOfFunction = new LinkedHashMap<>();
        calleeSet = new LinkedHashMap<>();
        modulePass(module);

        return changed;
    }

    public FunctionInline(Module module) {
        super(module);
    }
}
