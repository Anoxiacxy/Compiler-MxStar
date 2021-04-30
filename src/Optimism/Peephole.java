package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Module;
import Util.Pass;

public class Peephole extends Pass {
    public Peephole(Module module) {
        super(module);
    }

    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values())
            functionPass(function);
    }

    @Override
    protected void functionPass(Function function) {
        function.getDfsOrder();
/*
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock()) {
            if (block != function.getEntryBlock() && block.getPredecessors().isEmpty())
                block.removeFromFunction();
            else if (block.getPredecessors().size() == 1 && block.getPredecessors().get(0).getSuccessors().size() == 1)
                block.mergeTo(block.getPredecessors().get(0));
        }

 */
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
