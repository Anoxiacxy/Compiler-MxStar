package IR.Instruction;

import IR.BasicBlock;
import IR.Function;
import IR.Operand.Operand;
import IR.Operand.Register;

import java.util.ArrayList;

public class CallInst extends IRInst {
    private Function function;
    private ArrayList<Operand> parameters;
    private Register result;

    public CallInst(BasicBlock basicBlock, Register result, Function function, ArrayList<Operand> parameters) {
        super(basicBlock);
        this.function = function;
        this.parameters = parameters;
        this.result = result;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public ArrayList<Operand> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Operand> parameters) {
        this.parameters = parameters;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.result != null) {
            assert result.getType().equals(function.getFuncType().getReturnType());
            stringBuilder.append(result.toString()).append(" = ");
        }
        stringBuilder.append("call ");
        stringBuilder.append(function.getFuncType().getReturnType().toString()).append(" ");
        stringBuilder.append(function.toString());
        stringBuilder.append("(");
        for (int i = 0; i < parameters.size(); i++) {
            //assert
            stringBuilder.append(function.getFuncType().getParameterType().get(i).toString());


        }
        stringBuilder.append(")");

        return stringBuilder.toString();
    }
}
