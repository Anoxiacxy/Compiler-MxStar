package IR.Operand;

import IR.TypeSystem.ArrayIRT;
import IR.TypeSystem.IRType;

public class ConstStr extends Constant {
    private String value;

    public ConstStr(IRType type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "c\"" + this.value
                .replace("\\", "\\5C")
                .replace("\n", "\\0A")
                .replace("\"", "\\22")
                .replace("\0", "\\00")
                + "\"";
    }

    public void setValue(String value) {
        this.value = value;
    }
}
