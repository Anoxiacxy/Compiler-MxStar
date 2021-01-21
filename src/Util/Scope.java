package Util;

import AST.TypeNode;
import Util.Error.SemanticError;
import Util.Symbol.FuncSymbol;
import Util.Symbol.VarSymbol;
import Util.Type.ArrayType;
import Util.Type.ClassType;
import Util.Type.PrimaryType;
import Util.Type.Type;

import javax.swing.*;
import java.util.HashMap;

public class Scope {
    private Scope parentScope;
    private HashMap<String, VarSymbol> varSymbolHashMap = new HashMap<>();
    private HashMap<String, FuncSymbol> funcSymbolHashMap = new HashMap<>();
    private HashMap<String, Type> typeMap = new HashMap<>();
    private FuncSymbol funcSymbol;
    private ClassType classDefType;
    private int loopDepth;

    public FuncSymbol getFuncSymbol() {
        return funcSymbol;
    }

    public HashMap<String, VarSymbol> getVarSymbolHashMap() {
        return varSymbolHashMap;
    }

    public HashMap<String, FuncSymbol> getFuncSymbolHashMap() {
        return funcSymbolHashMap;
    }

    public HashMap<String, Type> getTypeMap() {
        return typeMap;
    }

    public void setFuncSymbol(FuncSymbol funcSymbol) {
        this.funcSymbol = funcSymbol;
    }

    public void setClassDefType(ClassType classDefType) {
        this.classDefType = classDefType;
    }

    public void setLoopDepth(int loopDepth) {
        this.loopDepth = loopDepth;
    }

    public ClassType getClassDefType() {
        return classDefType;
    }

    public int getLoopDepth() {
        return loopDepth;
    }

    public Scope(Scope parentScope) {
        this.parentScope = parentScope;
        if (parentScope != null) {
            this.funcSymbol = parentScope.funcSymbol;
            this.classDefType = parentScope.classDefType;
            this.loopDepth = parentScope.loopDepth;
        } else {
            this.funcSymbol = null;
            this.classDefType = null;
            this.loopDepth = 0;
        }
    }

    public void newType(String typeName, Type type, Position position) {
        if (type == null)
            throw new SemanticError("null type", position);
        if (typeMap.containsKey(typeName)) throw new SemanticError(typeName + " class redefined", position);
        if (containsVarSymbol(typeName)) throw new SemanticError(typeName + " is a variable", position);
        if (containsFunSymbol(typeName)) throw new SemanticError(typeName + " is a function", position);
        typeMap.put(typeName, type);
    }

    public void newVarSymbol(String symbol, VarSymbol varSymbol, Position position) {
        if (varSymbolHashMap.containsKey(symbol)) throw new SemanticError( symbol + " variable redefined", position);
        if (containsType(symbol)) throw new SemanticError(symbol + " is a type", position);
        varSymbolHashMap.put(symbol, varSymbol);
    }

    public void newFunSymbol(String symbol, FuncSymbol funcSymbol, Position position) {
        if (funcSymbolHashMap.containsKey(symbol)) throw new SemanticError("function redefined", position);
        if (!funcSymbol.isConstructor() && containsType(symbol))
            throw new SemanticError(symbol + " is a type", position);
        funcSymbolHashMap.put(symbol, funcSymbol);
    }

    public Type getType(String typeName, Position position) {
        if (typeMap.containsKey(typeName)) return typeMap.get(typeName);
        if (parentScope != null) return parentScope.getType(typeName, position);
        throw new SemanticError( typeName + " class undefined", position);
    }

    public Type getType(TypeNode node) {
        Type type = getType(node.getName(), node.getPosition());
        if (node.getDimension() == 0)
            return type;
        else
            return new ArrayType(node.getDimension(), type);
    }

    public VarSymbol getVarSymbol(String symbol, Position position) {
        if (varSymbolHashMap.containsKey(symbol)) return varSymbolHashMap.get(symbol);
        if (parentScope != null) return parentScope.getVarSymbol(symbol, position);
        throw new SemanticError(symbol + " var undefined", position);
    }

    public FuncSymbol getFuncSymbol(String symbol, Position position) {
        if (funcSymbolHashMap.containsKey(symbol)) return funcSymbolHashMap.get(symbol);
        if (parentScope != null) return parentScope.getFuncSymbol(symbol, position);
        throw new SemanticError(symbol + " func undefined", position);
    }

    public boolean containsType(String typeName) {
        return typeMap.containsKey(typeName) || (parentScope != null && parentScope.containsType(typeName));
    }

    public boolean containsVarSymbol(String symbol) {
        return varSymbolHashMap.containsKey(symbol) || (parentScope != null && parentScope.containsVarSymbol(symbol));
    }

    public boolean containsFunSymbol(String symbol) {
        return funcSymbolHashMap.containsKey(symbol) || (parentScope != null && parentScope.containsFunSymbol(symbol));
    }

}
