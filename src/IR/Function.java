package IR;

import IR.TypeSystem.FuncIRT;

public class Function extends IRObject {
    private Module module;

    private String name;
    private FuncIRT funcType;

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuncIRT getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncIRT funcType) {
        this.funcType = funcType;
    }

    @Override
    public String toString() {
        return "@" + this.name;
    }
}
