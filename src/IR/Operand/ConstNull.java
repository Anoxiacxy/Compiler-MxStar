package IR.Operand;

import IR.TypeSystem.IRType;
import IR.TypeSystem.PointerIRT;
import IR.TypeSystem.VoidIRT;

public class ConstNull extends Constant {
    public ConstNull() {
        super(new PointerIRT(new VoidIRT()));
    }

    @Override
    public String toString() {
        return "null";
    }
}
