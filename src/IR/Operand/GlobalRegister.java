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
    public Operand clone() {
        return this;
    }

    @Override
    public String toString() {
        return "@" + getName();
    }

    public String definitionToString() {
        StringBuilder string = new StringBuilder(toString() + " = ");
        assert init instanceof Constant;
        if (init instanceof ConstStr)
            string.append("private unnamed_addr constant ").
                    append(getType().toString()).append(" ").append(init.toString());
        else
            string.append("global ").append(getType().toString()).append(" ").append(init.toString());
        return string.toString();
    }
}


