package RISCV.Operand.Immediate;

public class IntImm extends Immediate {
    int value;

    public IntImm(int value) {
        this.value = value;
    }

    public IntImm getNegative() {
        return new IntImm(-value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String emitCode() {
        return Integer.toString(value);
    }
}
