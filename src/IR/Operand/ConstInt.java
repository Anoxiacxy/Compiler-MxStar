package IR.Operand;

import IR.TypeSystem.IRType;
import IR.TypeSystem.IntegerIRT;

public class ConstInt extends Constant {
    private long value;

    public ConstInt(IRType type, long value) {
        super(type);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public Operand clone() {
        return new ConstInt(getType(), getValue());
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
