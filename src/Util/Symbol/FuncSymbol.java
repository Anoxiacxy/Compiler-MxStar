package Util.Symbol;

import Util.Type.Type;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol extends Type {
    private Type type;
    private String name;
    private ArrayList<VarSymbol> paramater = new ArrayList<>();
    private boolean returned;
    private boolean constructor;

    public boolean isConstructor() {
        return constructor;
    }

    public void setConstructor(boolean constructor) {
        this.constructor = constructor;
    }

    public FuncSymbol(Type type, String name) {
        this.type = type;
        this.name = name;
        this.returned = false;
        this.constructor = false;
    }
    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
    public ArrayList<VarSymbol> getParamater() {
        return paramater;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
