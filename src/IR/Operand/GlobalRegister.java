package IR.Operand;

import IR.TypeSystem.IRType;

public class GlobalRegister extends Register {
    private Operand init;

    public Operand getInit() {
        return init;
    }

    public void setInit(Operand init) {
        this.init = init;
    }

    public GlobalRegister(IRType type, String name, Operand init) {
        super(type, name, false);
        this.init = init;
    }

    public GlobalRegister(IRType type, String name, boolean temporary) {
        super(type, name, temporary);
    }

    @Override
    public String toString() {
        return "@" + getName();
    }


}


