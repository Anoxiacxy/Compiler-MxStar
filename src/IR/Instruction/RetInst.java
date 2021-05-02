package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.TypeSystem.IRType;
import IR.TypeSystem.VoidIRT;

public class RetInst extends IRInst {
    private IRType type;
    private Operand value;

    public RetInst(BasicBlock basicBlock, IRType type, Operand value) {
        super(basicBlock);
        this.type = type;
        this.value = value;
        if (value != null) {
            value.addUse(this);
            addUse(value);
        }
    }

    @Override
    public void replaceDef(Operand oldOperand, Operand newOperand) {
        super.replaceDef(oldOperand, newOperand);
    }

    @Override
    public void replaceUse(Operand oldOperand, Operand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        if (value != null && oldOperand == value) {
            oldOperand.removeUse(this);
            value = newOperand;
            newOperand.addUse(this);
        }
    }

    public IRType getType() {
        return type;
    }

    public void setType(IRType type) {
        this.type = type;
    }

    public Operand getValue() {
        return value;
    }

    public void setValue(Operand value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (type instanceof VoidIRT)
            return "ret void";
        else
            return "ret " + value.getType() + " " + value;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IRInst clone(BasicBlock newBlock) {
        return new RetInst(newBlock, getType(), getValue());
    }
}
