package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Module;
import Util.Pass;

public class AggressiveDeadCodeElimination extends Pass {
    public AggressiveDeadCodeElimination(Module module) {
        super(module);
    }

    @Override
    protected void modulePass(Module module) {

    }

    @Override
    protected void functionPass(Function function) {

    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        return false;
    }
}