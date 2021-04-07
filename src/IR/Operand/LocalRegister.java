package IR.Operand;

import IR.TypeSystem.IRType;

public class LocalRegister extends Register {
    public LocalRegister(IRType type, String name) {
        super(type, name, true);

    }

    public LocalRegister(IRType type, String name, boolean temporary) {
        super(type, name, temporary);
    }

    @Override
    public String toString() {
        // return "%" + getName();
        if (isTemporary())
            return "%" + getThisCount();
        else
            return "%" + getName();
    }
}
