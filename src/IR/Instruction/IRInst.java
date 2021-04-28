package IR.Instruction;

import Backend.IRPrinter;
import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Operand;
import IR.Operand.Register;
import RISCV.Instruction.J;

import java.util.*;

abstract public class IRInst {
    private BasicBlock basicBlock;
    private IRInst nextInst, prevInst;
    private Map<Operand, Integer> def, use;

    public void addUse(Operand operand) {
        if (use.containsKey(operand))
            use.replace(operand, use.get(operand) + 1);
        else
            use.put(operand, 1);
    }

    public void addDef(Operand operand) {
        if (def.containsKey(operand))
            def.replace(operand, def.get(operand) + 1);
        else
            def.put(operand, 1);
    }

    public void replaceDef(Operand oldOperand, Operand newOperand) {
        int oldCnt = def.getOrDefault(oldOperand, 0);
        int newCnt = def.getOrDefault(newOperand, 0);
        if (oldCnt != 0) {
            def.remove(oldOperand);
            if (newCnt != 0)
                def.replace(newOperand, newCnt + oldCnt);
            else
                def.put(newOperand, oldCnt);
        }
    }

    public void replaceUse(Operand oldOperand, Operand newOperand) {
        int oldCnt = use.getOrDefault(oldOperand, 0);
        int newCnt = use.getOrDefault(newOperand, 0);
        if (oldCnt != 0) {
            use.remove(oldOperand);
            if (newCnt != 0)
                use.replace(newOperand, newCnt + oldCnt);
            else
                use.put(newOperand, oldCnt);
        }
    }

    public IRInst(BasicBlock basicBlock) {
        this.basicBlock = basicBlock;
        def = new HashMap<>();
        use = new HashMap<>();
    }

    public BasicBlock getBasicBlock() {
        return basicBlock;
    }

    public void setBasicBlock(BasicBlock basicBlock) {
        this.basicBlock = basicBlock;
    }

    public IRInst getNextInst() {
        return nextInst;
    }

    public void setNextInst(IRInst nextInst) {
        this.nextInst = nextInst;
    }

    public IRInst getPrevInst() {
        return prevInst;
    }

    public void setPrevInst(IRInst prevInst) {
        this.prevInst = prevInst;
    }

    public abstract void accept(IRVisitor visitor);

    public void removeFromBlock() {
        for (Operand operand : def.keySet())
            operand.removeDef(this);
        for (Operand operand : use.keySet())
            operand.removeUse(this);

        def.clear();
        use.clear();

        if (getPrevInst() == null)
            basicBlock.setInstBegin(getNextInst());
        else
            getPrevInst().setNextInst(getNextInst());

        if (getNextInst() == null)
            basicBlock.setInstEnd(getPrevInst());
        else
            getNextInst().setPrevInst(getPrevInst());

        /*
        if (nextInst != null) {
            nextInst.setPrevInst(prevInst);
        } else {
            basicBlock.setInstEnd(prevInst);
        }

        if (prevInst != null) {
            prevInst.setNextInst(nextInst);
        } else {
            basicBlock.setInstBegin(nextInst);
        }
        */

    }
}
