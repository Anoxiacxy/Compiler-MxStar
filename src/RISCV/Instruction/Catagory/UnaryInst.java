package RISCV.Instruction.Catagory;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Register.VirtualRegister;
import org.antlr.v4.runtime.atn.BasicBlockStartState;

public class UnaryInst extends ASMInst {
    public enum OpType { seqz, snez, sltz, sgtz }

    private VirtualRegister rd;
    private VirtualRegister rs;
    private OpType opType;

    public UnaryInst(ASMBlock asmBlock, VirtualRegister rd, VirtualRegister rs, OpType opType) {
        super(asmBlock);
        this.rd = rd;
        this.rs = rs;
        this.opType = opType;

        rs.addUse(this);
        addUse(rs);
        rd.addDef(this);
        addDef(rd);
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert rd == oldRegister;
        rd = newRegister;
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert rs == oldRegister;
        rs = newRegister;
        super.replaceUse(oldRegister, newRegister);
    }

    @Override
    public String emitCode() {
        return opType.name() + "\t" + rd.emitCode() + "," + rs.emitCode();
    }
}
