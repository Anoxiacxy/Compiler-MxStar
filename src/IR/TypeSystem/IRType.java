package IR.TypeSystem;

import IR.IRVisitor;
import IR.Operand.Operand;

abstract public class IRType {
    public IRType() { }


    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IRType)
            return this.toString().equals(obj.toString());
        else
            return false;
    }

    abstract public Operand getDefaultValue();

    abstract public int getByte();

}
