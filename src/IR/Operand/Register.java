package IR.Operand;

import IR.Instruction.IRInst;
import IR.TypeSystem.IRType;

public class Register extends Operand {
    private String name;
    private IRInst definition;

    public Register(IRType type, String name) {
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

    public IRInst getDefinition() {
        return definition;
    }

    public void setDefinition(IRInst definition) {
        this.definition = definition;
    }

    public String getFullName() {
        //TODO
        return null;
    }

    @Override
    public String toString() {
        return "%" + name;
    }

    @Override
    boolean isConstant() {
        return false;
    }
}
