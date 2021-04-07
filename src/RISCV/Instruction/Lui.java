package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class Lui extends ASMInst {
    private VirtualRegister rd;
    private Immediate imm;

    public Lui(ASMBlock asmBlock, VirtualRegister rd, Immediate imm) {
        super(asmBlock);
        this.rd = rd;
        this.imm = imm;

        this.rd.addUse(this);
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
        return "lui\t" + rd.emitCode() + "," + imm.emitCode();
    }
}
