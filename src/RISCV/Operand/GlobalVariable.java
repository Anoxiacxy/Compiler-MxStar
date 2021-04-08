package RISCV.Operand;

public class GlobalVariable extends Operand {
    public enum VarType { string_t, int_t, bool_t, void_t }

    private String name;
    private VarType varType;

    private String strValue;
    private int intValue;

    public GlobalVariable(String name) {
        this.name = name;
        varType = VarType.void_t;
    }

    public String getName() {
        return name;
    }

    public void setString(String string) {
        this.strValue = string;
        this.varType = VarType.string_t;
    }

    public void setInt(int intValue) {
        this.intValue = intValue;
        this.varType = VarType.int_t;
    }

    public void setBool(boolean bool) {
        this.intValue = bool ? 1 : 0;
        this.varType = VarType.bool_t;
    }

    public boolean isInt() {
        return this.varType == VarType.int_t;
    }

    public boolean isString() { return this.varType == VarType.string_t; }

    public boolean isBool() {
        return this.varType == VarType.string_t;
    }

    @Override
    public String emitCode() {
        switch (varType) {
            case bool_t -> {
                return ".byte\t" + intValue + " ".repeat(23) + "# " + (intValue == 1);
            }
            case int_t -> {
                return ".word\t" + Integer.toUnsignedLong(intValue)
                        + " ".repeat(24 - Integer.toUnsignedString(intValue).length()) + "# " + intValue;
            }
            case string_t -> {
                return ".asciz\t\"" + strValue.replace("\\", "\\\\")
                        .replace("\n", "\\n")
                        .replace("\"", "\\\"") + "\"";
            }
            default -> {
                //System.out.println(varType);
                throw new RuntimeException();
            }
        }
    }


}
