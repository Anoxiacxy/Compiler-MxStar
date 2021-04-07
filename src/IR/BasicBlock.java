package IR;

import IR.Instruction.BrInst;
import IR.Instruction.IRInst;
import RISCV.Instruction.Catagory.BranchInst;

import java.util.HashSet;
import java.util.Set;

public class BasicBlock extends IRObject {
    private Function function;
    private BasicBlock nextBlock, prevBlock;
    private IRInst instBegin, instEnd;
    private String name;

    private BasicBlock dfsFather;



    private Set<BasicBlock> successors, predecessors;

    public void insertInstAfter(IRInst index, IRInst newInst) {
        if (index == instEnd) {
            instEnd = newInst;
        }
        newInst.setNextInst(index.getNextInst());
        newInst.setPrevInst(index);
        if (index.getNextInst() != null)
            index.getNextInst().setPrevInst(newInst);
        index.setNextInst(newInst);

    }

    public void insertInstBefore(IRInst index, IRInst newInst) {
        if (index == instBegin) {
            instBegin = newInst;
        }
        newInst.setPrevInst(index.getPrevInst());
        newInst.setNextInst(index);
        if (index.getPrevInst() != null)
            index.getPrevInst().setNextInst(newInst);
        index.setPrevInst(newInst);
    }

    public BasicBlock(Function function, String name) {
        this.function = function;
        this.name = name;

        instBegin = null;
        instEnd = null;
        nextBlock = null;
        prevBlock = null;

        successors = new HashSet<>();
        predecessors = new HashSet<>();
    }

    public Set<BasicBlock> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(Set<BasicBlock> predecessors) {
        this.predecessors = predecessors;
    }

    public void calcSuccessors() {
        successors.clear();
        IRInst inst = getInstEnd();
        assert inst instanceof BrInst;
        successors.add(((BrInst) inst).getThemBlock());
        if (((BrInst) inst).getElseBlock() != null)
            successors.add(((BrInst) inst).getElseBlock());
    }

    public Set<BasicBlock> getSuccessors() {
        return successors;
    }

    public void setSuccessors(Set<BasicBlock> successors) {
        this.successors = successors;
    }

    public void replaceSuccessors(BasicBlock oldBlock, BasicBlock newBlock) {
        IRInst inst = getInstEnd();
        assert inst instanceof BrInst;
        if (((BrInst) inst).getThemBlock() == oldBlock)
            ((BrInst) inst).setThemBlock(newBlock);
        if (((BrInst) inst).getElseBlock() == oldBlock)
            ((BrInst) inst).setElseBlock(newBlock);
    }

    public BasicBlock getDfsFather() {
        return dfsFather;
    }

    public void setDfsFather(BasicBlock dfsFather) {
        this.dfsFather = dfsFather;
    }



    @Override
    public String toString() {
        return name;
    }

    public boolean isEmpty() {
        return instBegin == null;
    }

    public void appendInstFront(IRInst irInst) {
        if (isEmpty()) {
            instEnd = irInst;
            instBegin = irInst;
        } else {
            irInst.setNextInst(instBegin);
            instBegin.setPrevInst(irInst);
            instBegin = irInst;
        }
    }

    public void appendInstBack(IRInst irInst) {
        if (isEmpty()) {
            instEnd = irInst;
            instBegin = irInst;
        } else {
            irInst.setPrevInst(instEnd);
            instEnd.setNextInst(irInst);
            instEnd = irInst;
        }
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public BasicBlock getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(BasicBlock nextBlock) {
        this.nextBlock = nextBlock;
    }

    public BasicBlock getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(BasicBlock prevBlock) {
        this.prevBlock = prevBlock;
    }

    public IRInst getInstBegin() {
        return instBegin;
    }

    public void setInstBegin(IRInst instBegin) {
        this.instBegin = instBegin;
    }

    public IRInst getInstEnd() {
        return instEnd;
    }

    public void setInstEnd(IRInst instEnd) {
        this.instEnd = instEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
