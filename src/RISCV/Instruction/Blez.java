package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.BranchInst;
import RISCV.Operand.Register.VirtualRegister;

public class Blez extends BranchInst {
    public Blez(ASMBlock asmBlock, VirtualRegister rs1, ASMBlock targetBlock) {
        super(asmBlock, rs1, null, targetBlock, OpType.blez);
    }
}
