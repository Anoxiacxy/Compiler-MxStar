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

    public void removeFromBlock () {
        super.removeFromBlock();
    }

    public VirtualRegister getRd() {
        return rd;
    }

    public void setRd(VirtualRegister rd) {
        this.rd = rd;
    }

    public VirtualRegister getRs() {
        return rs;
    }

    public void setRs(VirtualRegister rs) {
        this.rs = rs;
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        super.replaceDef(oldRegister, newRegister);
        if (rd == oldRegister)
            rd = newRegister;
    }

    @Override
    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        super.replaceUse(oldRegister, newRegister);
        if (rs == oldRegister)
            rs = newRegister;
    }

    @Override
    public String emitCode() {
        return "mv\t" + rd.emitCode() + ", " + rs.emitCode();
    }
}
