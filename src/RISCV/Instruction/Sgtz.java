package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.UnaryInst;
import RISCV.Operand.Register.VirtualRegister;

public class Sgtz extends UnaryInst {
    public Sgtz(ASMBlock asmBlock, VirtualRegister rd, VirtualRegister rs) {
        super(asmBlock, rd, rs, OpType.sgtz);
    }
}
