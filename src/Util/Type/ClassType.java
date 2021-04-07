package Util.Type;

import Util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassType extends Type {
    private String typeName;

    private Map<String, VarSymbol> varSymbolHashMap = new HashMap<>();
    private Map<String, FuncSymbol> funcSymbolHashMap = new HashMap<>();
    private Map<String, ClassType> classTypeHashMap = new HashMap<>();

    private Map<String, Integer> varMember = new HashMap<>();
    private ArrayList<VarSymbol> varSymbolArrayList = new ArrayList<>();
    private Map<String, Integer> funcMember = new HashMap<>();

    public int getVarMemberIndex(String name) {
        return varMember.get(name);
    }

    public int getFuncMemberIndex(String name) {
        return funcMember.get(name);
    }

    public Map<String, VarSymbol> getVarSymbolHashMap() {
        return varSymbolHashMap;
    }

    public Map<String, FuncSymbol> getFuncSymbolHashMap() {
        return funcSymbolHashMap;
    }

    public ArrayList<VarSymbol> getVarSymbolArrayList() {
        return varSymbolArrayList;
    }

    public void setVarSymbolArrayList(ArrayList<VarSymbol> varSymbolArrayList) {
        this.varSymbolArrayList = varSymbolArrayList;
    }

    public void putVarSymbol(String name, VarSymbol varSymbol) {
        // if (varSymbolHashMap.containsKey(name))
        varSymbolHashMap.put(name, varSymbol);
        varMember.put(name, varMember.size());
        varSymbolArrayList.add(varSymbol);
    }

    public VarSymbol getVarSymbol(String name, Position position) {
        if (varSymbolHashMap.containsKey(name))
            return varSymbolHashMap.get(name);
        else
            throw new RuntimeException();
    }

    public void putFuncSymbol(String name, FuncSymbol funcSymbol) {
        funcSymbolHashMap.put(name, funcSymbol);
        funcMember.put(name, funcMember.size());
    }

    public FuncSymbol getFuncSymbol(String name, Position position) {
        if (funcSymbolHashMap.containsKey(name))
            return funcSymbolHashMap.get(name);
        else
            throw new RuntimeException();
    }

    public Map<String, ClassType> getClassTypeHashMap() {
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

    @Override
    public boolean isClass() {
        return true;
    }

    @Override
    public String toString() {
        return "ClassType{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
