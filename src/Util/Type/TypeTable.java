package Util.Type;

import IR.TypeSystem.ClassIRT;
import IR.TypeSystem.IRType;
import IR.TypeSystem.PointerIRT;
import Util.Error.ComplicationError;
import Util.Error.SemanticError;
import Util.Position;

import java.util.HashMap;
import java.util.Map;

import static IR.Module.*;

public class TypeTable {
    private Map<String, Type> stringTypeMap;
    private Map<Type, IRType> typeIRTypeMap = new HashMap<>();

    public TypeTable(Map<String, Type> stringTypeMap) {
        this.stringTypeMap = stringTypeMap;

        for (Type type : stringTypeMap.values()) {

            if (type instanceof PrimaryType) {
                if (type.isVoid())
                    typeIRTypeMap.put(type, void_t);
                if (type.isBool())
                    typeIRTypeMap.put(type, bool_t);
                if (type.isInt())
                    typeIRTypeMap.put(type, int_t);
            } else if (type instanceof ClassType) {
                if (type.isString())
                    typeIRTypeMap.put(type, string_t);
                else
                    typeIRTypeMap.put(type, new ClassIRT(type.getTypeName()));
            } else if (type instanceof ArrayType) {
                // Nothing to do
            }
        }

        for (Type type : stringTypeMap.values())
            if (type instanceof ClassType && !type.isString()) {
                ClassIRT classType = (ClassIRT) typeIRTypeMap.get(type);
                for (VarSymbol varSymbol : ((ClassType) type).getVarSymbolArrayList())
                    classType.getIrTypeArrayList().add(getIRType(varSymbol.getType()));
            }

    }

    public Map<String, Type> getStringTypeMap() {
        return stringTypeMap;
    }

    public void setStringTypeMap(Map<String, Type> stringTypeMap) {
        this.stringTypeMap = stringTypeMap;
    }

    public Type getType(String name, Position position) {
        if (stringTypeMap.containsKey(name))
            return stringTypeMap.get(name);
        else
            throw new SemanticError("cannot find '" + name + "' in typeTable", position);
    }

    public Map<String, ClassIRT> getClassIRTMap() {
        Map<String, ClassIRT> classIRTMap = new HashMap<>();
        for (IRType irType : typeIRTypeMap.values()) {
            if (irType instanceof ClassIRT)
                classIRTMap.put(((ClassIRT) irType).getName(), (ClassIRT) irType);
        }
        return classIRTMap;
    }

    public IRType getIRType(Type type) {
        if (type.isNull()) {
            return void_t;
        }
        else if (type instanceof ArrayType) {
            IRType irType = getIRType(((ArrayType) type).getBaseType());
            for (int i = 0; i < ((ArrayType) type).getDimension(); i++)
                irType = new PointerIRT(irType);
            return irType;
        } else if (typeIRTypeMap.containsKey(type)) {
            IRType irType = typeIRTypeMap.get(type);
            if (irType instanceof ClassIRT)
                return new PointerIRT(irType);
            else
                return irType;
        }
        else
            throw new RuntimeException("Type : " + type.toString());
    }
}
