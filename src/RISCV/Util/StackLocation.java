package RISCV.Util;

import RISCV.ASMObject;

public class StackLocation extends ASMObject {
    private int offset;
    private String name;

    public StackLocation(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }

    @Override
    public String emitCode() {
        return offset + "(sp)";
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
