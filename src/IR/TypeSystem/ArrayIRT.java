package IR.TypeSystem;

import IR.Operand.Operand;
import Util.Error.ComplicationError;
import Util.Position;

public class ArrayIRT extends IRType {
    private int size;
    private IRType base;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public IRType getBase() {
        return base;
    }

    public void setBase(IRType base) {
        this.base = base;
    }

    public ArrayIRT(IRType base, int size) {
        this.size = size;
        this.base = base;
    }

    @Override
    public String toString() {
        return "[" + this.size + " x " + this.base.toString() + "]";
    }

    @Override
    public int getByte() {
        return size * base.getByte();
    }

    @Override
    public Operand getDefaultValue() {
        throw new ComplicationError("", new Position());
    }
}
