package IR.TypeSystem;

import IR.Operand.Operand;
import Util.Error.ComplicationError;
import Util.Position;

public class VoidIRT extends IRType {

    @Override
    public int getByte() {
        return 0;
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public Operand getDefaultValue() {
        throw new ComplicationError("", new Position());
    }
}
