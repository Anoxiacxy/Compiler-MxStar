package Frontend;

import AST.TypeNode;
import Util.Type.Type;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ASTTypeTable {
    private Map<TypeNode, Type> typeNodeTypeMap;

    public ASTTypeTable() {
        this.typeNodeTypeMap = new LinkedHashMap<>();
    }

    public void put(TypeNode typeNode, Type type) {
        this.typeNodeTypeMap.put(typeNode, type);
    }

    public Type get(TypeNode typeNode) {
        return this.typeNodeTypeMap.get(typeNode);
    }

    public Map<TypeNode, Type> getTypeNodeTypeMap() {
        return typeNodeTypeMap;
    }

    public void setTypeNodeTypeMap(Map<TypeNode, Type> typeNodeTypeMap) {
        this.typeNodeTypeMap = typeNodeTypeMap;
    }
}
