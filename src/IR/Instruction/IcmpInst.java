package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Register;
import IR.TypeSystem.IRType;

public class IcmpInst extends IRInst {
    public enum OpType {
        eq, ne, sgt, sge, slt, sle
    }

    private OpType opType;
    private Operand lhs, rhs;
    private Register result;
    private IRType irType;

    public IcmpInst(BasicBlock basicBlock, OpType opType, Operand lhs, Operand rhs,
                    Register result, IRType irType) {
        super(basicBlock);
        this.opType = opType;
        this.lhs = lhs;
        this.rhs = rhs;
        this.result = result;
        this.irType = irType;
        result.addDef(this);
        lhs.addUse(this);
        rhs.addUse(this);
        addDef(result);
        addUse(lhs);
        addUse(rhs);
    }

    @Override
    public void replaceDef(Operand oldOperand, Operand newOperand) {
        super.replaceDef(oldOperand, newOperand);
        if (oldOperand == result) {
            oldOperand.removeDef(this);
            assert newOperand instanceof Register;
            result = (Register) newOperand;
            newOperand.addDef(this);
        }
    }

    @Override
    public void replaceUse(Operand oldOperand, Operand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        if (oldOperand == lhs) {
            oldOperand.removeUse(this);
            lhs = newOperand;
            newOperand.addUse(this);
        }

        if (oldOperand == rhs) {
            oldOperand.removeUse(this);
            rhs = newOperand;
            newOperand.addUse(this);
        }

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

    public IRType getIrType() {
        return irType;
    }

    public void setIrType(IRType irType) {
        this.irType = irType;
    }

    @Override
    public String toString() {
        return result + " = icmp " + opType.name() + " " + irType + " " + lhs + ", " + rhs;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IRInst clone(BasicBlock newBlock) {
        return new IcmpInst(newBlock, getOpType(), getLhs(), getRhs(), getResult(), getIrType());
    }
}
