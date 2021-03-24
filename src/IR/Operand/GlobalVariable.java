package IR.Operand;

import IR.TypeSystem.IRType;

public class GlobalVariable extends Operand {
    private String name;

    public GlobalVariable(IRType type, String name) {
        super(type);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return toString();
    }

    @Override
    boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "@" + this.name;
    }
}
