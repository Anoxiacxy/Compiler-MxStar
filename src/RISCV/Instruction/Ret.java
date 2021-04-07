package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;

public class Ret extends ASMInst {
    public Ret(ASMBlock asmBlock) {
        super(asmBlock);
    }

    @Override
    public String emitCode() {
        return "ret";
    }
}
