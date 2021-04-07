package RISCV.Instruction.Catagory;

import IR.BasicBlock;
import RISCV.ASMBlock;
import RISCV.ASMInst;
import RISCV.Operand.Register.VirtualRegister;

public class BranchInst extends ASMInst {
    public enum OpType {
        beq, bne, blt, bge, ble, bgt,
        beqz, bnez, bltz, bgez, blez, bgtz
    }

    private VirtualRegister rs1;
    private VirtualRegister rs2;
    private ASMBlock targetBlock;
    private OpType opType;

    public BranchInst(ASMBlock asmBlock, VirtualRegister rs1, VirtualRegister rs2, ASMBlock targetBlock, OpType opType) {
        super(asmBlock);
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.targetBlock = targetBlock;
        this.opType = opType;

        rs1.addUse(this);
        this.addUse(rs1);

        if (rs2 != null) {
            rs2.addUse(this);
            this.addUse(rs2);
        }
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
        return opType.name() + "\t" + rs1.emitCode() + "," +
                ((rs2 != null) ? rs2.emitCode() + "," : "") + targetBlock.emitCode();
    }
}
