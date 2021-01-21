package Util.Type;

public class PrimaryType extends Type {
    private String typeName;

    @Override
    public String getTypeName() {
        return typeName;
    }

    public PrimaryType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Type type) {
        if (isNull())
            return type.isNull() || ((type instanceof ClassType) && ((ClassType) type).getTypeName() != "string") || (type instanceof ArrayType);
        else
            return (type instanceof PrimaryType) && (this.typeName.equals(((PrimaryType) type).getTypeName()));
    }

    @Override
    public boolean isBool() {
        return typeName.equals("bool");
    }

    @Override
    public boolean isInt() {
        return typeName.equals("int");
    }

    @Override
    public boolean isNull() {
        return typeName.equals("null");
    }

    @Override
    public boolean isVoid() {
        return typeName.equals("void");
    }
}
