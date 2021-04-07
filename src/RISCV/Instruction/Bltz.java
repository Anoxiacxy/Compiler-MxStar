package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BranchInst;
import RISCV.Operand.Register.VirtualRegister;

public class Bltz extends BranchInst {
    public Bltz(ASMBlock asmBlock, VirtualRegister rs1, ASMBlock targetBlock) {
        super(asmBlock, rs1, null, targetBlock, OpType.bltz);
    }
}
