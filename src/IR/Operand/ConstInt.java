package IR.Operand;

import IR.TypeSystem.IRType;
import IR.TypeSystem.IntegerIRT;

public class ConstInt extends Constant {
    private long value;

    public ConstInt(IntegerIRT type, long value) {
        super(type);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }


}
