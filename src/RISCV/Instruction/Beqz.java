package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BranchInst;
import RISCV.Operand.Register.VirtualRegister;

public class Beqz extends BranchInst {
    public Beqz(ASMBlock asmBlock, VirtualRegister rs1, ASMBlock targetBlock) {
        super(asmBlock, rs1, null, targetBlock, OpType.beqz);
    }
}
