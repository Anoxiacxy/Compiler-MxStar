package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BranchInst;
import RISCV.Operand.Register.VirtualRegister;

public class Bgt extends BranchInst {
    public Bgt(ASMBlock asmBlock, VirtualRegister rs1, VirtualRegister rs2, ASMBlock targetBlock) {
        super(asmBlock, rs1, rs2, targetBlock, OpType.bgt);
    }
}
