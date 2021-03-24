package IR.Instruction;

import IR.BasicBlock;
import IR.Operand.Operand;
import IR.Operand.Register;

public class BinaryInst extends IRInst {
    public enum OpType {
        add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
    }

    private OpType opType;
    private Operand lhs, rhs;
    private Register result;

    public BinaryInst(BasicBlock basicBlock, OpType opType, Operand lhs, Operand rhs, Register result) {
        super(basicBlock);
        this.opType = opType;
        this.lhs = lhs;
        this.rhs = rhs;
        this.result = result;
    }

    public OpType getOpType() {
        return opType;
    }

    public void setOpType(OpType opType) {
        this.opType = opType;
    }

    public Operand getLhs() {
        return lhs;
    }

    public void setLhs(Operand lhs) {
        this.lhs = lhs;
    }

    public Operand getRhs() {
        return rhs;
    }

    public void setRhs(Operand rhs) {
        this.rhs = rhs;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result + " = " + opType.name() + result.getType() + " " + lhs + ", " + rhs;
    }
}
