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

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
