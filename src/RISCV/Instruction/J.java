package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;

public class J extends ASMInst {
    private ASMBlock targetBlock;

    public J(ASMBlock asmBlock, ASMBlock targetBlock) {
        super(asmBlock);
        this.targetBlock = targetBlock;
    }

    @Override
    public String emitCode() {
        return "j\t" + targetBlock.emitCode();
    }
}
