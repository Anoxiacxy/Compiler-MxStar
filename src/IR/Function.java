package IR;

import IR.Instruction.*;
import IR.Operand.LocalRegister;
import IR.Operand.Parameter;
import IR.Operand.Register;
import IR.TypeSystem.FuncIRT;
import IR.TypeSystem.IRType;
import IR.TypeSystem.PointerIRT;
import IR.TypeSystem.VoidIRT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static IR.Module.void_t;

public class Function extends IRObject {
    private Module module;

    private String name;
    private FuncIRT funcType;
    private ArrayList<Parameter> parameters;
    private Register returnValueAddress;

    public void setExitBlock(BasicBlock exitBlock) {
        this.exitBlock = exitBlock;
    }

    private Register thisPointer;
    private boolean external;

    private BasicBlock entryBlock;
    private BasicBlock exitBlock;
    private BasicBlock returnBlock;

    public Function(Module module, String name, IRType returnType, ArrayList<Parameter> parameters, boolean external) {
        this.module = module;
        this.name = name;

        this.parameters = parameters;
        ArrayList<IRType> parametersType = new ArrayList<>();
        parameters.forEach(x->parametersType.add(x.getType()));
        this.funcType = new FuncIRT(returnType, parametersType);
        this.external = external;

        if (!external) {
            entryBlock = new BasicBlock(this, "entry");
            exitBlock = entryBlock;
            returnBlock = new BasicBlock(this, "return");

            if (this.funcType.getReturnType() instanceof VoidIRT) {
                returnBlock.appendInstBack(new RetInst(returnBlock, void_t, null));
            } else {
                returnValueAddress = new LocalRegister(new PointerIRT(this.funcType.getReturnType()), "returnValue$address");
                entryBlock.appendInstBack(new AllocaInst(entryBlock, returnValueAddress, this.funcType.getReturnType()));
                entryBlock.appendInstBack(new StoreInst(entryBlock, this.funcType.getReturnType().getDefaultValue(), returnValueAddress));
                Register returnValue = new LocalRegister(this.funcType.getReturnType(), "returnValue");
                returnBlock.appendInstBack(new LoadInst(returnBlock, this.funcType.getReturnType(), returnValueAddress, returnValue));
                returnBlock.appendInstBack(new RetInst(returnBlock, this.funcType.getReturnType(), returnValue));
            }
        }
    }

    public void finish() {
        exitBlock.appendInstBack(new BrInst(exitBlock, null, returnBlock, null));
        appendBlock(returnBlock);
    }

    public void appendBlock(BasicBlock block) {
        block.setPrevBlock(exitBlock);
        exitBlock.setNextBlock(block);
        exitBlock = block;
    }


    private Set<BasicBlock> visTag;

    public ArrayList<BasicBlock> getDfsOrder() {
        ArrayList<BasicBlock> dfsOrder = new ArrayList<>();
        for (BasicBlock block = getEntryBlock(); block != null; block = block.getNextBlock())
            block.getPredecessors().clear();
        visTag = new LinkedHashSet<>();
        entryBlock.setDfsFather(null);
        dfsBlock(entryBlock, dfsOrder);
        return dfsOrder;
    }

    public void dfsBlock(BasicBlock cur, ArrayList<BasicBlock> dfsOrder) {
        dfsOrder.add(cur);
        cur.calcSuccessors();
        for (BasicBlock next : cur.getSuccessors()) {
            next.getPredecessors().add(cur);
            if (!visTag.contains(next)) {
                visTag.add(cur);
                next.setDfsFather(cur);
                dfsBlock(next, dfsOrder);
            }
        }
    }

    public void insertBlockBefore(BasicBlock index, BasicBlock newBlock) {
        if (index == entryBlock)
            entryBlock = newBlock;
        newBlock.setPrevBlock(index.getPrevBlock());
        newBlock.setNextBlock(index);
        if (index.getPrevBlock() != null)
            index.getPrevBlock().setNextBlock(newBlock);
        index.setPrevBlock(newBlock);
    }

    public void insertBlockAfter(BasicBlock index, BasicBlock newBlock) {
        if (index == exitBlock)
            exitBlock = newBlock;
        newBlock.setNextBlock(index.getNextBlock());
        newBlock.setPrevBlock(index);
        if (index.getNextBlock() != null)
            index.getNextBlock().setPrevBlock(newBlock);
        index.setNextBlock(newBlock);
    }

    public BasicBlock getEntryBlock() {
        return entryBlock;
    }

    public void setEntryBlock(BasicBlock entryBlock) {
        this.entryBlock = entryBlock;
    }

    public BasicBlock getReturnBlock() {
        return returnBlock;
    }

    public void setReturnBlock(BasicBlock returnBlock) {
        this.returnBlock = returnBlock;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

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

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Register getReturnValueAddress() {
        return returnValueAddress;
    }

    public void setReturnValueAddress(Register returnValueAddress) {
        this.returnValueAddress = returnValueAddress;
    }

    public Register getThisPointer() {
        return thisPointer;
    }

    public void setThisPointer(Register thisPointer) {
        this.thisPointer = thisPointer;
    }

    @Override
    public String toString() {
        return "@" + this.name;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public String declareToString() {
        StringBuilder header = new StringBuilder("declare ");
        header.append(getFuncType().getReturnType().toString());
        header.append(" @").append(getName());

        header.append("(");
        for (int i = 0; i < getParameters().size(); i++) {
            Parameter parameter = getParameters().get(i);
            header.append(parameter.getType().toString()).append(" ");
            header.append(parameter.toString());
            if (i != getParameters().size() - 1)
                header.append(", ");
        }
        header.append(")");

        return header.toString();
    }
}
