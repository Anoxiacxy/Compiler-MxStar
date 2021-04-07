package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Register.VirtualRegister;

public class Mv extends ASMInst {
    private VirtualRegister rd, rs;

    public Mv(ASMBlock asmBlock, VirtualRegister rd, VirtualRegister rs) {
        super(asmBlock);
        this.rd = rd;
        this.rs = rs;

        this.rd.addDef(this);
        this.rs.addUse(this);

        this.addDef(this.rd);
        this.addUse(this.rs);
    }

    @Override
    public String emitCode() {
        return "mv\t" + rd.emitCode() + "," + rs.emitCode();
    }
}
