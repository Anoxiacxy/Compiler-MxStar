package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.GlobalRegister;
import IR.Operand.Operand;
import IR.TypeSystem.IRType;

public class GlobalInst extends IRInst {
    private GlobalRegister result;
    private IRType type;
    private Operand init;

    private GlobalInst(BasicBlock basicBlock, GlobalRegister result, IRType type, Operand init) {
        super(basicBlock);
        this.result = result;
        this.type = type;
        this.init = init;
        // should never used
    }

    @Override
    public String toString() {
        return result + " = global " + type + " " + init;
    }

    public GlobalRegister getResult() {
        return result;
    }

    public void setResult(GlobalRegister result) {
        this.result = result;
    }

    public IRType getType() {
        return type;
    }

    public void setType(IRType type) {
        this.type = type;
    }

    public Operand getInit() {
        return init;
    }

    public void setInit(Operand init) {
        this.init = init;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IRInst clone(BasicBlock newBlock) {
        return new GlobalInst(newBlock, getResult(), getType(), getInit());
    }
}
