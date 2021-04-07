package IR.TypeSystem;

import IR.Operand.ConstNull;
import IR.Operand.Operand;
import Util.Error.ComplicationError;
import Util.Position;

public class PointerIRT extends IRType {
    private IRType base;

    public PointerIRT(IRType base) {
        this.base = base;
    }

    public IRType getBase() {
        return base;
    }

    public void setBase(IRType base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return this.base.toString() + "*";
    }

    @Override
    public int getByte() {
        return 4; // 8
    }

    @Override
    public Operand getDefaultValue() {
        return new ConstNull();
    }
}
