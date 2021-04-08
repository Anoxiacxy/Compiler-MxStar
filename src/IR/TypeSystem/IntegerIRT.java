package IR.TypeSystem;

import IR.Operand.ConstBool;
import IR.Operand.ConstInt;
import IR.Operand.Operand;
import Util.Error.ComplicationError;
import Util.Position;

import static IR.Module.bool_t;
import static IR.Module.int_t;

public class IntegerIRT extends IRType {
    private int size;

    public IntegerIRT(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "i" + this.size;
    }

    @Override
    public int getByte() {
        return (size + 7) / 8;
    }

    @Override
    public Operand getDefaultValue() {
        return size == 1 ?
                new ConstBool(bool_t, false) :
                new ConstInt(int_t, 0);
    }
}
