package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Register;

public class MoveInst extends IRInst {
    private Operand source;
    private Register result;

    public MoveInst(BasicBlock basicBlock, Operand source, Register result) {
        super(basicBlock);
        this.source = source;
        this.result = result;

    }

    public Operand getSource() {
        return source;
    }

    public void setSource(Operand source) {
        this.source = source;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "move " + result + " " + source;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
