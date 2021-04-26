package Util;

import IR.BasicBlock;
import IR.Function;
import IR.Module;

abstract public class Pass {
    protected Module module;
    protected boolean changed;

    public Pass(Module module) {
        this.module = module;
        this.changed = false;
    }

    protected abstract void modulePass(Module module);
    protected abstract void functionPass(Function function);
    protected abstract void blockPass(BasicBlock block);

    abstract public boolean run();

}
