package RISCV.Instruction.Catagory;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class LoadInst extends ASMInst {
    public enum OpType { lw, lb }
    private VirtualRegister rd;
    private Address address;
    private OpType opType;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LoadInst(ASMBlock asmBlock, VirtualRegister rd, Address address, OpType opType) {
        super(asmBlock);
        this.rd = rd;
        this.address = address;
        this.opType = opType;

        this.rd.addDef(this);
        this.addDef(this.rd);

        this.address.getBase().addUse(this);
        this.addUse(this.address.getBase());
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert this.rd == oldRegister;
        this.rd = newRegister;
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        super.replaceUse(oldRegister, newRegister);
        if (this.address.getBase() == oldRegister)
            this.address.setBase(newRegister);
    }

    @Override
    public String emitCode() {
        return opType.name() + "\t" + rd.emitCode() + ", " + address.emitCode();
    }
}
