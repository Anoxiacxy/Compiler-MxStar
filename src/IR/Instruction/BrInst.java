package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;

public class BrInst extends IRInst {
    private Operand cond;
    private BasicBlock themBlock;
    private BasicBlock elseBlock;

    public BrInst(BasicBlock basicBlock, Operand cond, BasicBlock themBlock, BasicBlock elseBlock) {
        super(basicBlock);
        this.cond = cond;
        this.themBlock = themBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public String toString() {
        if (cond != null)
            return "br i1 " + cond + ", label " + themBlock + ", label " + elseBlock;
        else
            return "br label " + themBlock;
    }

    public BasicBlock getThemBlock() {
        return themBlock;
    }

    public BasicBlock getElseBlock() {
        return elseBlock;
    }

    public void setThemBlock(BasicBlock themBlock) {
        this.themBlock = themBlock;
    }

    public void setElseBlock(BasicBlock elseBlock) {
        this.elseBlock = elseBlock;
    }

    public Operand getCond() {
        return cond;
    }

    public void setCond(Operand cond) {
        this.cond = cond;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
