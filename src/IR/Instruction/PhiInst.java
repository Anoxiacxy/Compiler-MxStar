package IR.Instruction;

import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Parameter;
import IR.Operand.Register;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class PhiInst extends IRInst {
    private ArrayList<Pair<Operand, BasicBlock>> branch;
    private Register result;

    public PhiInst(BasicBlock basicBlock, Map<Operand, BasicBlock> branch, Register result) {
        super(basicBlock);
        this.result = result;
        this.branch = new ArrayList<>();
        branch.forEach((operand, block) -> {
            this.branch.add(new Pair<>(operand, block));
            operand.addUse(this);
            addUse(operand);
        });
        result.addDef(this);
        addDef(result);
    }

    public void appendBranch(Operand operand, BasicBlock basicBlock) {
        branch.add(new Pair<>(operand, basicBlock));
        operand.addUse(this);
        addUse(operand);
    }

    @Override
    public void replaceUse(Operand oldOperand, Operand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        for (int i = 0; i < branch.size(); i++) {
            if (oldOperand == branch.get(i).a) {
                oldOperand.removeUse(this);
                branch.set(i, new Pair<>(newOperand, branch.get(i).b));
                newOperand.addUse(this);
            }
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

    public ArrayList<Pair<Operand, BasicBlock>> getBranch() {
        return branch;
    }

    public void setResult(Register result) {
        this.result = result;
    }

    public Register getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result).append(" = phi ").append(result.getType());
        if (branch.isEmpty())
            return stringBuilder.toString();
        ListIterator<Pair<Operand, BasicBlock>> iterator = branch.listIterator();;
        Pair<Operand, BasicBlock> entry = iterator.next();
        stringBuilder.append(" [ ").append(entry.a)
                .append(", ").append(entry.b).append(" ]");
        while (iterator.hasNext()) {
            entry = iterator.next();
            stringBuilder.append(", [ ").append(entry.a)
                    .append(", ").append(entry.b).append(" ]");
        }
        return stringBuilder.toString();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
