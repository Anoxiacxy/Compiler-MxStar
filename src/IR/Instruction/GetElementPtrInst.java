package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Register;
import IR.TypeSystem.PointerIRT;

import java.util.ArrayList;

public class GetElementPtrInst extends IRInst {
    private Register result;
    private ArrayList<Operand> index;
    private Operand address;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result).append(" = getelementptr ");
        stringBuilder.append(((PointerIRT)address.getType()).getBase()).append(". ");
        stringBuilder.append(address.getType()).append(" ").append(address);
        for (Operand aIndex : index)
            stringBuilder.append(", ").append(aIndex.getType()).append(" ").append(aIndex);
        return stringBuilder.toString();
    }

    public GetElementPtrInst(BasicBlock basicBlock, Register result, ArrayList<Operand> index, Operand address) {
        super(basicBlock);
        this.result = result;
        this.index = index;
        this.address = address;
    }

    public GetElementPtrInst(BasicBlock basicBlock, Register result, Operand index, Operand address) {
        super(basicBlock);
        this.result = result;
        this.index = new ArrayList<>();
        this.index.add(index);
        this.address = address;
    }

    public Register getResult() {
        return result;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    public ArrayList<Operand> getIndex() {
        return index;
    }

    public void setIndex(ArrayList<Operand> index) {
        this.index = index;
    }

    public Operand getAddress() {
        return address;
    }

    public void setAddress(Operand address) {
        this.address = address;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
