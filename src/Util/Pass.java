package Util;

import IR.Module;

abstract public class Pass {
    protected Module module;
    protected boolean changed;

    public Pass(Module module) {
        this.module = module;
        this.changed = false;
    }

    abstract public boolean run();
}
