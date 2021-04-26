package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
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
        address.addUse(this);
        result.addDef(this);
        addUse(address);
        addDef(result);
    }

    @Override
    public void replaceUse(Operand oldOperand, Operand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        if (oldOperand == address) {
            oldOperand.removeUse(this);
            address = newOperand;
            newOperand.addUse(this);
        }
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
    public String toString() {
        assert result.getType().equals(type);
        return result + " = load " + type
                + ", " + address.getType() + " " + address.toString();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public IRType getType() {
        return type;
    }

    public void setType(IRType type) {
        this.type = type;
    }

    public Operand getAddress() {
        return address;
    }

    public void setAddress(Operand address) {
        this.address = address;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }
}
