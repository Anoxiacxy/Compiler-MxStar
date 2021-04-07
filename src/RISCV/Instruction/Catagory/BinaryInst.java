package RISCV.Instruction.Catagory;

import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Register.VirtualRegister;

public class BinaryInst extends ASMInst {
    public enum OpType {
        add, sub, mul, div, rem, sll, sra, and, or, xor, slt,
        addi, slli, srai, andi, ori, xori, slti
    }

    private VirtualRegister rd;
    private VirtualRegister rs1;
    private VirtualRegister rs2;
    private Immediate imm;
    private OpType opType;


    public BinaryInst(ASMBlock asmBlock, VirtualRegister rd,
                      VirtualRegister rs1, VirtualRegister rs2, Immediate imm, OpType opType) {
        super(asmBlock);
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        this.opType = opType;

        rd.addDef(this);
        this.addDef(rd);

        rs1.addUse(this);
        this.addUse(rs1);

        if (rs2 != null) {
            rs2.addUse(this);
            this.addUse(rs2);
        }
    }

    @Override
    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        assert rd == oldRegister;
        rd = newRegister;
        super.replaceDef(oldRegister, newRegister);
    }

    @Override
    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        if (rs1 == oldRegister)
            rs1 = newRegister;
        if (rs2 == oldRegister)
            rs2 = newRegister;
        super.replaceUse(oldRegister, newRegister);
    }

    @Override
    public String emitCode() {
        return opType.name() + "\t" + rd.emitCode() + "," + rs1.emitCode() + "," +
                ((rs2 == null) ? imm.emitCode() : rs2.emitCode());
    }
}
