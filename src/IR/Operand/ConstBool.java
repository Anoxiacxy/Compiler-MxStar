package IR.Operand;

import IR.TypeSystem.IRType;

public class ConstBool extends Constant {
    boolean value;

    public ConstBool(IRType type, boolean value) {
        super(type);
        this.value = value;
    }



    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
