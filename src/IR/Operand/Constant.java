package IR.Operand;

import IR.TypeSystem.IRType;

abstract public class Constant extends Operand {
    public Constant(IRType type) {
        super(type);
    }

    @Override
    public boolean isConstant() {
        return true;
    }
}
