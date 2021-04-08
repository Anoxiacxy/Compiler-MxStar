package RISCV.Instruction.Catagory;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class StoreInst extends ASMInst {
    public enum OpType { sw, sb }

    private VirtualRegister rs;
    private Address address;
    private OpType opType;

    public StoreInst(ASMBlock asmBlock, VirtualRegister rs, Address address, OpType opType) {
        super(asmBlock);
        this.rs = rs;
        this.address = address;
        this.opType = opType;
        this.rs.addUse(this);
        this.addUse(rs);
        this.address.getBase().addUse(this);
        this.addUse(this.address.getBase());
    }

    @Override
    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        super.replaceUse(oldRegister, newRegister);
        if (rs == oldRegister)
            rs = newRegister;
        if (this.address.getBase() == oldRegister)
            this.address.setBase(newRegister);
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public String emitCode() {
        return opType.name() + "\t" + rs.emitCode() + ", " + address.emitCode();
    }
}
