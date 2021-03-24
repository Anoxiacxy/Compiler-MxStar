package IR.Instruction;

import IR.BasicBlock;
import IR.Operand.Operand;
import IR.Operand.Register;

import java.util.Iterator;
import java.util.Map;

public class PhiInst extends IRInst {
    private Map<Operand, BasicBlock> branch;
    private Register result;

    public PhiInst(BasicBlock basicBlock, Map<Operand, BasicBlock> branch, Register result) {
        super(basicBlock);
        this.branch = branch;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result).append(" = phi ").append(result.getType());
        Iterator<Map.Entry<Operand, BasicBlock>> iterator = branch.entrySet().iterator();
        Map.Entry<Operand, BasicBlock> entry = iterator.next();
        stringBuilder.append(" [ ").append(entry.getKey())
                .append(", ").append(entry.getValue()).append(" ]");
        while (iterator.hasNext()) {
            entry = iterator.next();
            stringBuilder.append(", [ ").append(entry.getKey())
                    .append(", ").append(entry.getValue()).append(" ]");
        }
        return stringBuilder.toString();
    }
}
