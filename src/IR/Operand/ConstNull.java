package IR.Operand;

import IR.TypeSystem.IRType;

public class ConstNull extends Constant {
    public ConstNull(IRType type) {
        super(type);
    }

    @Override
    public String toString() {
        return "null";
    }
}
