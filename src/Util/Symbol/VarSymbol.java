package Util.Symbol;

import Util.Type.Type;

public class VarSymbol {
    private Type type;
    private String name;

    public VarSymbol(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
