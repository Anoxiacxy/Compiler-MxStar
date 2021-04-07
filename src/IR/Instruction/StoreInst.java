package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;

public class StoreInst extends IRInst {
    private Operand value;
    private Operand address;

    public StoreInst(BasicBlock basicBlock, Operand value, Operand address) {
        super(basicBlock);
        this.value = value;
        this.address = address;
    }

    @Override
    public String toString() {
        return "store " + value.getType() + " " + value + ", " + address.getType() + " " + address;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public Operand getValue() {
        return value;
    }

    public void setValue(Operand value) {
        this.value = value;
    }

    public Operand getAddress() {
        return address;
    }

    public void setAddress(Operand address) {
        this.address = address;
    }
}
