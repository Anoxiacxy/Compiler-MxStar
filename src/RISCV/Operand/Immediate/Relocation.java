package RISCV.Operand.Immediate;

import RISCV.Operand.GlobalVariable;

public class Relocation extends Immediate {
    public enum ImmType { lo, hi }

    private GlobalVariable globalVariable;
    private ImmType immType;

    public Relocation(GlobalVariable globalVariable, ImmType immType) {
        this.globalVariable = globalVariable;
        this.immType = immType;
    }

    @Override
    public String emitCode() {
        return "%" + immType.name() + "(" + globalVariable.getName() + ")";
    }
}
