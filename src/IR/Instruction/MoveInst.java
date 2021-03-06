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
        source.addUse(this);
        result.addDef(this);
        addUse(source);
        addDef(result);
    }

    @Override
    public void replaceDef(Operand oldOperand, Operand newOperand) {
        super.replaceDef(oldOperand, newOperand);
        if (oldOperand == result) {
            oldOperand.removeDef(this);
            assert newOperand instanceof Register;
            result = (Register) newOperand;
            newOperand.addDef(this);
        }
    }

    @Override
    public void replaceUse(Operand oldOperand, Operand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        if (oldOperand == source) {
            oldOperand.removeUse(this);
            source = newOperand;
            newOperand.addUse(this);
        }
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

    @Override
    public IRInst clone(BasicBlock newBlock) {
        return new MoveInst(newBlock, getSource(), getResult());
    }
}
