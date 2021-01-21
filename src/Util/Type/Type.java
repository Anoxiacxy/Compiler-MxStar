package Util.Type;

public abstract class Type {
    public String getTypeName() {
        return "undefined";
    }

    public boolean equals(Type type) {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isBool() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isVoid() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

}
