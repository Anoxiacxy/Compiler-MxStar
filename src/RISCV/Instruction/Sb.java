package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.StoreInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class Sb extends StoreInst {
    public Sb(ASMBlock asmBlock, VirtualRegister rs, Address address) {
        super(asmBlock, rs, address, OpType.sb);
    }
}
