package IR;

import IR.Instruction.GlobalInst;
import IR.Operand.ConstStr;
import IR.Operand.GlobalRegister;
import IR.Operand.Parameter;
import IR.TypeSystem.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Module extends IRObject {
    public static IRType void_t = new VoidIRT();
    public static IRType bool_t = new IntegerIRT(1);
    public static IRType char_t = new IntegerIRT(8);
    public static IRType int_t = new IntegerIRT(32);
    public static IRType string_t = new PointerIRT(char_t);
    public static IRType pointer_t = new PointerIRT(char_t);


    private Map<String, Function> functionMap;
    private Map<String, Function> systemFunctionMap;
    private Map<String, GlobalRegister> globalVariableMap;
    private Map<String, GlobalRegister> constantStringMap;

    public Module() {
        functionMap = new HashMap<>();
        systemFunctionMap = new HashMap<>();
        globalVariableMap = new HashMap<>();
        constantStringMap = new HashMap<>();

        initSystemFunctionMap();

        Function __init__ = new Function(this, "mx__init", void_t, new ArrayList<>(), false);
        this.addFunction(__init__);

    }

    public GlobalRegister addConstantString(String str) {
        str = str.replace("\\\\", "\\");
        str = str.replace("\\n", "\n");
        str = str.replace("\\\"", "\"");
        str = str + "\0";
        if (constantStringMap.containsKey(str)) {
            return constantStringMap.get(str);
        } else {
            IRType irType = new PointerIRT(new ArrayIRT(char_t, str.length()));
            ConstStr constStr = new ConstStr(new ArrayIRT(char_t, str.length()), str);
            GlobalRegister globalRegister = new GlobalRegister(irType,
                    ".str." + constantStringMap.size(), constStr);
            // TODO: 2021/3/27
            constantStringMap.put(str, globalRegister);
            globalVariableMap.put(globalRegister.getName(), globalRegister);
            return globalRegister;
        }
    }

    public void addFunction(Function function) {
        functionMap.put(function.getName(), function);
    }

    public Map<String, Function> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<String, Function> functionMap) {
        this.functionMap = functionMap;
    }

    public Map<String, Function> getSystemFunctionMap() {
        return systemFunctionMap;
    }

    public void setSystemFunctionMap(Map<String, Function> systemFunctionMap) {
        this.systemFunctionMap = systemFunctionMap;
    }

    public Map<String, GlobalRegister> getGlobalVariableMap() {
        return globalVariableMap;
    }

    public void setGlobalVariableMap(Map<String, GlobalRegister> globalVariableMap) {
        this.globalVariableMap = globalVariableMap;
    }

    public Map<String, GlobalRegister> getConstantStringMap() {
        return constantStringMap;
    }

    public void setConstantStringMap(Map<String, GlobalRegister> constantStringMap) {
        this.constantStringMap = constantStringMap;
    }

    private void initSystemFunctionMap() {
        // void print(string str)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "str"));
            Function function = new Function(this, "mx__print", void_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // void println(string str)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "str"));
            Function function = new Function(this, "mx__println", void_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // void printInt(int n)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(int_t, "n"));
            Function function = new Function(this, "mx__printInt", void_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // void printlnInt(int n)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(int_t, "n"));
            Function function = new Function(this, "mx__printlnInt", void_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // string getString()
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            Function function = new Function(this, "mx__getString", string_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // int getInt()
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            Function function = new Function(this, "mx__getInt", int_t, parameters, true);
            systemFunctionMap.put(function.getName(),function);
        }

        // string toString(int i)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(int_t, "i"));
            Function function = new Function(this, "mx__toString", string_t, parameters, true);
            systemFunctionMap.put(function.getName(),function);
        }

        // void * malloc(int size)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(int_t, "size"));
            Function function = new Function(this, "mx__malloc", pointer_t, parameters, true);
            systemFunctionMap.put(function.getName(),function);
        }

        // string string.add(string a, string b)    a + b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_add", string_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }


        // bool string_lt(string a, string b)    a < b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_lt", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // bool string_gt(string a, string b)    a > b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_gt", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // bool string_le(string a, string b)    a <= b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_le", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // bool string_ge(string a, string b)    a >= b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_ge", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // bool string_eq(string a, string b)    a == b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_eq", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // bool string_ne(string a, string b)    a != b
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "a"));
            parameters.add(new Parameter(string_t, "b"));
            Function function = new Function(this, "mx__string_ne", bool_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // int string.length(string this)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "this"));
            Function function = new Function(this, "mx__string_length", int_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // string string.substring(string this, int left, int right)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "this"));
            parameters.add(new Parameter(int_t, "left"));
            parameters.add(new Parameter(int_t, "right"));
            Function function = new Function(this, "mx__string_substring", string_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // int string.parseInt(string this)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "this"));
            Function function = new Function(this, "mx__string_parseInt", int_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // int string.ord(string this, int pos)
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(string_t, "this"));
            parameters.add(new Parameter(int_t, "pos"));
            Function function = new Function(this, "mx__string_ord", int_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }

        // int array.size(array this)
        /*
        {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(pointer_t, "this"));
            Function function = new Function(this, "array_size", int_t, parameters, true);
            systemFunctionMap.put(function.getName(), function);
        }
        */

    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
