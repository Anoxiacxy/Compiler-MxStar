package IR.Instruction;

import IR.BasicBlock;
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
}
