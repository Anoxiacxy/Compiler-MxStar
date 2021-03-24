package IR.TypeSystem;

import java.util.ArrayList;

public class FuncIRT extends IRType {
    private IRType returnType;
    private ArrayList<IRType> parameterType;

    public FuncIRT(IRType returnType, ArrayList<IRType> parameterType) {
        this.returnType = returnType;
        this.parameterType = parameterType;
    }

    public IRType getReturnType() {
        return returnType;
    }

    public void setReturnType(IRType returnType) {
        this.returnType = returnType;
    }

    public ArrayList<IRType> getParameterType() {
        return parameterType;
    }

    public void setParameterType(ArrayList<IRType> parameterType) {
        this.parameterType = parameterType;
    }



    @Override
    public String toString() {
        return null;
    }
}
