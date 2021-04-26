package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class Li extends ASMInst {
    private VirtualRegister rd;
    private Immediate imm;

    public Li(ASMBlock asmBlock, VirtualRegister rd, Immediate imm) {
        super(asmBlock);
        this.rd = rd;
        this.imm = imm;

        this.rd.addDef(this);
        this.addDef(this.rd);
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert  this.rd == oldRegister;
        this.rd = newRegister;
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public String emitCode() {
        return "li\t" + rd.emitCode() + ", " + imm.emitCode();
    }
}
