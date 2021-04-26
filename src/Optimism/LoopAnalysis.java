package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Module;
import Util.Pass;

public class LoopAnalysis extends Pass {
    public LoopAnalysis(Module module) {
        super(module);
    }

    public LoopAnalysis(Function function) {
        super(null);
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

    public int computeLoopDepth(BasicBlock basicBlock) {
        // TODO: 2021/4/25  
        return 0;
    }

    @Override
    public boolean run() {
        return false;
    }
}
