package IR;

import java.util.HashMap;
import java.util.Map;

public class IRObject {
    Map<String, Object> symbolTable;

    public IRObject() {
        this.symbolTable = new HashMap<>();
    }

    public Object get(String str) {
        return symbolTable.get(str);
    }

    public void put(String str, Object obj) {
        symbolTable.put(str, obj);
    }


}
