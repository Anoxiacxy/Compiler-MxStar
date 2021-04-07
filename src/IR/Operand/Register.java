package IR.Operand;

import IR.Instruction.IRInst;
import IR.TypeSystem.IRType;

abstract public class Register extends Operand {
    private String name;
    private IRInst definition;
    private static int count = 0;
    private int thisCount;
    private boolean temporary;

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public static void resetCount() {
        setCount(0);
    }

    public static int getCount() {
        return count;
    }

    public int getThisCount() {
        return thisCount;
    }

    public void setThisCount(int thisCount) {
        this.thisCount = thisCount;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public static void setCount(int count) {
        Register.count = count;
    }

    public Register(IRType type, String name) {
        super(type);
        this.name = name;
        this.definition = null;
        this.temporary = true;
        this.thisCount = ++count;
    }

    public Register(IRType type, String name, boolean temporary) {
        super(type);
        this.name = name;
        this.definition = null;
        this.temporary = true;
        this.thisCount = ++count;
        this.temporary = temporary;
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
        return getDefinition().getBasicBlock().getFunction() + "." + getName();
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isConstant() {
        return false;
    }
}
