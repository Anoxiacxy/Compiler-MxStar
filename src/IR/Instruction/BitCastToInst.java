package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Register;
import IR.TypeSystem.IRType;

public class BitCastToInst extends IRInst {
    private Operand source;
    private IRType irType;
    private Register result;

    public BitCastToInst(BasicBlock basicBlock, Operand source, IRType irType, Register result) {
        super(basicBlock);
        this.source = source;
        this.irType = irType;
        this.result = result;
    }

    public Operand getSource() {
        return source;
    }

    public void setSource(Operand source) {
        this.source = source;
    }

    public IRType getIrType() {
        return irType;
    }

    public void setIrType(IRType irType) {
        this.irType = irType;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result + " = bitcast " + source.getType() + " " + source + " to " + irType;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
