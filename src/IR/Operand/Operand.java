package IR.Operand;

import IR.IRObject;
import IR.TypeSystem.IRType;

abstract public class Operand extends IRObject {
    private IRType type;

    public Operand(IRType type) {
        this.type = type;
    }

    public IRType getType() {
        return type;
    }

    public String getName() { return null; }

    public void setType(IRType type) {
        this.type = type;
    }

    abstract boolean isConstant();

    @Override
    public String toString() {
        return "Operand{" +
                "type=" + type +
                '}';
    }
}
