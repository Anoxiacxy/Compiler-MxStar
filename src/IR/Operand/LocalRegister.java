package IR.Operand;

import IR.Instruction.IRInst;
import IR.TypeSystem.IRType;

public class LocalRegister extends Register {
    public LocalRegister(IRType type, String name) {
        super(type, name, true);
    }

    @Override
    public Operand clone() {
        return new LocalRegister(getType(), getName() + ".clone");
    }

    public IRInst getDefInst() {
        assert getDef().size() == 1;
        return getDef().keySet().iterator().next();
    }

    public LocalRegister(IRType type, String name, boolean temporary) {
        super(type, name, temporary);
    }

    @Override
    public String toString() {
        // return "%" + getName();
        if (isTemporary())
            return "%" + getThisCount() + "_" + getName();
        else
            return "%" + getName();
    }
}
