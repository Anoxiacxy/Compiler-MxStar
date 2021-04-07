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
}
