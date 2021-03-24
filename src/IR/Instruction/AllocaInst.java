package IR.Instruction;

import IR.BasicBlock;
import IR.Operand.Register;
import IR.TypeSystem.IRType;

public class AllocaInst extends IRInst {
    private IRType type;
    private Register result;

    public AllocaInst(BasicBlock basicBlock, Register result, IRType type) {
        super(basicBlock);
        this.result = result;
        this.type = type;
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
        if (this.result != null) {
            stringBuilder.append(this.result.toString()).append(" = ");
        } else {
            //TODO
        }
        stringBuilder.append("alloca ").append(type.toString());
        return stringBuilder.toString();
    }
}
