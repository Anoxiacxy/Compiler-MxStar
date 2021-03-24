package IR.TypeSystem;

public class PointerIRT extends IRType {
    private IRType base;

    public PointerIRT(IRType base) {
        this.base = base;
    }

    public IRType getBase() {
        return base;
    }

    public void setBase(IRType base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return this.base.toString() + "*";
    }
}
