package Util.Type;

import Util.Symbol.FuncSymbol;
import Util.Symbol.VarSymbol;

import java.util.HashMap;

public class ClassType extends Type {
    private String typeName;
    private HashMap<String, VarSymbol> varSymbolHashMap = new HashMap<>();
    private HashMap<String, FuncSymbol> funcSymbolHashMap = new HashMap<>();
    private HashMap<String, ClassType> classTypeHashMap = new HashMap<>();

    public HashMap<String, VarSymbol> getVarSymbolHashMap() {
        return varSymbolHashMap;
    }

    public HashMap<String, FuncSymbol> getFuncSymbolHashMap() {
        return funcSymbolHashMap;
    }

    public HashMap<String, ClassType> getClassTypeHashMap() {
        return classTypeHashMap;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    public ClassType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Type type) {
        return (type instanceof ClassType) && (this.typeName.equals(((ClassType) type).getTypeName()));
    }

    @Override
    public boolean isString() {
        return typeName.equals("string");
    }
}
