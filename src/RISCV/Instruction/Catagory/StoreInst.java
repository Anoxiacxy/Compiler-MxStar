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
    }

    @Override
    public String emitCode() {
        return opType.name() + "\t" + rs.emitCode() + "," + address.emitCode();
    }
}
