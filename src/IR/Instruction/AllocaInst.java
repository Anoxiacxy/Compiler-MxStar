package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Register;
import IR.TypeSystem.IRType;
import IR.TypeSystem.PointerIRT;

public class AllocaInst extends IRInst {
    private IRType type;
    private Register result;

    public AllocaInst(BasicBlock basicBlock, Register result, IRType type) {
        super(basicBlock);
        this.result = result;
        this.type = type;
        assert result.getType() instanceof PointerIRT;
    }

    public IRType getType() {
        return type;
    }

    public void setType(IRType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        assert this.result != null;
        stringBuilder.append(this.result).append(" = ");
        stringBuilder.append("alloca ").append(type);
        return stringBuilder.toString();
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
