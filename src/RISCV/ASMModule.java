package RISCV;

import IR.Function;
import RISCV.Operand.GlobalVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ASMModule {
    private Map<String, ASMFunction> functionMap;
    private Map<String, ASMFunction> systemFunctionMap;
    private Map<String, GlobalVariable> globalVariableMap;

    public ASMModule() {
        this.functionMap = new HashMap<>();
        this.systemFunctionMap = new HashMap<>();
        this.globalVariableMap = new HashMap<>();
    }

    public Map<String, ASMFunction> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<String, ASMFunction> functionMap) {
        this.functionMap = functionMap;
    }

    public Map<String, ASMFunction> getSystemFunctionMap() {
        return systemFunctionMap;
    }

    public void setSystemFunctionMap(Map<String, ASMFunction> systemFunctionMap) {
        this.systemFunctionMap = systemFunctionMap;
    }

    public Map<String, GlobalVariable> getGlobalVariableMap() {
        return globalVariableMap;
    }

    public void setGlobalVariableMap(Map<String, GlobalVariable> globalVariableMap) {
        this.globalVariableMap = globalVariableMap;
    }

    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
