package IR.Operand;

import IR.Function;
import IR.TypeSystem.IRType;

public class Parameter extends LocalRegister {
    private Function function;

    public Parameter(IRType type, String name) {
        super(type, name);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
