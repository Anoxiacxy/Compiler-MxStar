package IR.TypeSystem;

public class IntegerIRT extends IRType {
    private int size;

    public IntegerIRT(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "i" + this.size;
    }
}
