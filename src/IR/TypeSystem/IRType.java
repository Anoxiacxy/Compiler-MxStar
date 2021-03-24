package IR.TypeSystem;

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
}
