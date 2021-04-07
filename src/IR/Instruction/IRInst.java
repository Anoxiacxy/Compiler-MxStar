package IR.Instruction;

import Backend.IRPrinter;
import IR.BasicBlock;
import IR.IRVisitor;
import IR.Operand.Register;

abstract public class IRInst {
    private BasicBlock basicBlock;
    private IRInst nextInst, prevInst;

    public IRInst(BasicBlock basicBlock) {
        this.basicBlock = basicBlock;
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

    public void removeFromBasicBlock() {
        if (nextInst != null) {
            nextInst.setPrevInst(prevInst);
            if (prevInst == null)
                basicBlock.setInstBegin(nextInst);
        }

        if (prevInst != null) {
            prevInst.setNextInst(nextInst);
            if (nextInst == null)
                basicBlock.setInstEnd(prevInst);
        }

    }
}
