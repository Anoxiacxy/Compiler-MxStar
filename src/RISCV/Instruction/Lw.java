package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Instruction.Catagory.LoadInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class Lw extends LoadInst {
    public Lw(ASMBlock asmBlock, VirtualRegister rd, Address address) {
        super(asmBlock, rd, address, OpType.lw);
    }
}
