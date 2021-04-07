package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BinaryInst;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class Ori extends BinaryInst {
    public Ori(ASMBlock asmBlock, VirtualRegister rd, VirtualRegister rs1, Immediate imm) {
        super(asmBlock, rd, rs1, null, imm, OpType.ori);
    }
}
