package Util.Type;

import java.util.ArrayList;

public class FuncSymbol extends Type {
    private Type type;
    private String name;
    private ArrayList<VarSymbol> parameter = new ArrayList<>();
    private boolean returned;
    private boolean constructor;
    private boolean method;

    public void setName(String name) {
        this.name = name;
        this.constructor = false;
        this.method = false;
    }

    public void setParameter(ArrayList<VarSymbol> parameter) {
        this.parameter = parameter;
    }

    public boolean isMethod() {
        return method;
    }

    public void setMethod(boolean method) {
        this.method = method;
    }

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
    public ArrayList<VarSymbol> getParameter() {
        return parameter;
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

    @Override
    public String toString() {
        return "FuncSymbol{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", parameter=" + parameter +
                ", returned=" + returned +
                ", constructor=" + constructor +
                ", method=" + method +
                '}';
    }
}
