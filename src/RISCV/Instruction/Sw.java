package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.Instruction.Catagory.StoreInst;
import RISCV.Operand.Address;
import RISCV.Operand.Register.VirtualRegister;

public class Sw extends StoreInst {
    public Sw(ASMBlock asmBlock, VirtualRegister rs, Address address) {
        super(asmBlock, rs, address, OpType.sw);
    }
}
