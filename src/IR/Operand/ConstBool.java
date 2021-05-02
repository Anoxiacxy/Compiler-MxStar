package IR.Operand;

import IR.TypeSystem.IRType;

public class ConstBool extends Constant {
    boolean value;

    public ConstBool(IRType type, boolean value) {
        super(type);
        this.value = value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public Operand clone() {
        return new ConstBool(getType(), getValue());
    }
}
