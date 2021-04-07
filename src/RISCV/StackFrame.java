package RISCV;

import RISCV.ASMFunction;
import RISCV.Operand.Address;
import RISCV.Operand.Immediate.IntImm;
import RISCV.Util.StackLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StackFrame {
    private ASMFunction function;
    private int byteSize;
    private ArrayList<Address> parameterLocation;
    private ArrayList<Address> runtimeRegisterLocation;
    private Map<ASMFunction, ArrayList<Address>> calleeParameterLocation;

    public StackFrame(ASMFunction function) {
        this.function = function;
        parameterLocation = new ArrayList<>();
        runtimeRegisterLocation = new ArrayList<>();
        calleeParameterLocation = new HashMap<>();
    }

    public int getByteSize() {
        return byteSize;
    }

    public void calcByteSize() {
        byteSize = 0;
        for (ArrayList<Address> stackLocations : calleeParameterLocation.values()) {
            byteSize = Integer.max(byteSize, stackLocations.size());
            for (int i = 0; i < stackLocations.size(); i++)
                stackLocations.get(i).setOffset(new IntImm(i * 4));
        }

        for (int i = 0; i < runtimeRegisterLocation.size(); i++)
            runtimeRegisterLocation.get(i).setOffset(new IntImm((i + byteSize) * 4));
        byteSize = byteSize + runtimeRegisterLocation.size();

        for (int i = 0; i < parameterLocation.size(); i++)
            parameterLocation.get(i).setOffset(new IntImm((i + byteSize) * 4));
    }

    public ASMFunction getFunction() {
        return function;
    }

    public void setFunction(ASMFunction function) {
        this.function = function;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public ArrayList<Address> getParameterLocation() {
        return parameterLocation;
    }

    public void setParameterLocation(ArrayList<Address> parameterLocation) {
        this.parameterLocation = parameterLocation;
    }

    public ArrayList<Address> getRuntimeRegisterLocation() {
        return runtimeRegisterLocation;
    }

    public void setRuntimeRegisterLocation(ArrayList<Address> runtimeRegisterLocation) {
        this.runtimeRegisterLocation = runtimeRegisterLocation;
    }

    public Map<ASMFunction, ArrayList<Address>> getCalleeParameterLocation() {
        return calleeParameterLocation;
    }

    public void setCalleeParameterLocation(Map<ASMFunction, ArrayList<Address>> calleeParameterLocation) {
        this.calleeParameterLocation = calleeParameterLocation;
    }
}
