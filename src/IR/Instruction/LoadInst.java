package IR.Instruction;

import IR.BasicBlock;
import IR.Operand.Operand;
import IR.Operand.Register;
import IR.TypeSystem.IRType;

public class LoadInst extends IRInst {
    private IRType type;
    private Operand address;
    private Register result;

    public LoadInst(BasicBlock basicBlock, IRType type, Operand address, Register result) {
        super(basicBlock);
        this.type = type;
        this.address = address;
        this.result = result;
    }

    @Override
    public String toString() {
        assert result.getType().equals(type);
        return result + " = load " + type
                + ", " + address.getType() + " " + address.toString();
    }
}
