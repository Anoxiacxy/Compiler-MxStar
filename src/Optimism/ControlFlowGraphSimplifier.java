package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.IRInst;
import IR.Instruction.PhiInst;
import IR.Module;
import Util.Pass;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ControlFlowGraphSimplifier extends Pass {
    public ControlFlowGraphSimplifier(Module module) {
        super(module);
    }

    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values())
            functionPass(function);
    }

    private void mergeBlock(Function function) {

    }

    private void removeUnreachedBlock(Function function) {
        Set<BasicBlock> reachable = new LinkedHashSet<>(function.getDfsOrder());
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock())
            if (!reachable.contains(block)) {
                block.removeFromRelatedPhi();
                block.removeFromFunction();
                changed = true;
            }
    }

    private void removeUnusedPhiInst(Function function) {
        for (BasicBlock block : function.getDfsOrder()) {
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof PhiInst) {
                    if (((PhiInst) inst).getBranch().size() == 1) {
                        assert block.getPredecessors().size() == 1;
                        ((PhiInst) inst).getResult()
                                .replaceAllUse(((PhiInst) inst).getBranch().get(0).a);
                        inst.removeFromBlock();
                        changed = true;
                    }
                }
            }
        }
    }

    @Override
    protected void functionPass(Function function) {
        removeUnreachedBlock(function);
        removeUnusedPhiInst(function);
    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        modulePass(module);
        return false;
    }
}
