package RISCV.Operand;

import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class Address {
    private VirtualRegister base;

    private Immediate offset;

    public Address(VirtualRegister base, Immediate offset) {
        this.base = base;
        this.offset = offset;
    }

    public String emitCode() {
        return offset.emitCode() + "(" + base.emitCode() + ")";
    }

    public VirtualRegister getBase() {
        return base;
    }

    public void setBase(VirtualRegister base) {
        this.base = base;
    }

    public Immediate getOffset() {
        return offset;
    }

    public void setOffset(Immediate offset) {
        this.offset = offset;
    }
}
