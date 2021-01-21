package Util.Type;

import java.util.Collections;

public class ArrayType extends Type {
    private int dimension;
    private Type baseType;

    public int getDimension() {
        return dimension;
    }

    public Type getBaseType() {
        return baseType;
    }

    public ArrayType(int dimension, Type baseType) {
        this.dimension = dimension;
        this.baseType = baseType;
    }

    @Override
    public String getTypeName() {
        return baseType.getTypeName() + String.join("", Collections.nCopies(dimension, "[]"));
    }

    @Override
    public boolean equals(Type type) {
        return type.isNull() || ((type instanceof ArrayType)
                    && dimension == ((ArrayType) type).getDimension()
                    && baseType.equals(((ArrayType) type).getBaseType()));
    }
}
