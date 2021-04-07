package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.GlobalVariable;
import RISCV.Operand.Register.VirtualRegister;

public class La extends ASMInst {
    private VirtualRegister rd;
    private GlobalVariable globalVariable;

    public La(ASMBlock asmBlock, VirtualRegister rd, GlobalVariable globalVariable) {
        super(asmBlock);
        this.rd = rd;
        this.globalVariable = globalVariable;

        this.rd.addDef(this);
        this.addDef(this.rd);
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert this.rd == oldRegister;
        this.rd = newRegister;
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public String emitCode() {
        return "la\t" + rd.emitCode() + "," + globalVariable.getName();
    }
}
