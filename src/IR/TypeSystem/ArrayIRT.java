package IR.TypeSystem;

public class ArrayIRT extends IRType {
    private int size;
    private IRType base;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public IRType getBase() {
        return base;
    }

    public void setBase(IRType base) {
        this.base = base;
    }

    public ArrayIRT(int size, IRType base) {
        this.size = size;
        this.base = base;
    }

    @Override
    public String toString() {
        return "[" + this.size + " x " + this.base.toString() + "]";
    }
}
