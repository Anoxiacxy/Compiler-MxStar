package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.LoadInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class Lb extends LoadInst {
    public Lb(ASMBlock asmBlock, VirtualRegister rd, Address address) {
        super(asmBlock, rd, address, OpType.lb);
    }
}
