package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BinaryInst;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class And extends BinaryInst {
    public And(ASMBlock asmBlock, VirtualRegister rd, VirtualRegister rs1, VirtualRegister rs2) {
        super(asmBlock, rd, rs1, rs2, null, OpType.and);
    }
}
