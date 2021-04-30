package IR;

import AST.Stmt.ForStmtNode;
import IR.Instruction.BrInst;
import IR.Instruction.IRInst;
import IR.Instruction.RetInst;
import RISCV.Instruction.Catagory.BranchInst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BasicBlock extends IRObject {
    private static Integer blockCounter = 0;
    private Function function;
    private BasicBlock nextBlock, prevBlock;
    private IRInst instBegin, instEnd;
    private String name;

    private BasicBlock dfsFather;

    private ArrayList<BasicBlock> successors, predecessors;


    public void mergeTo(BasicBlock block) {
        assert predecessors.size() == 1;
        assert predecessors.get(0) == block;
        assert block.getSuccessors().size() == 1;
        assert block.getSuccessors().get(0) == this;

        block.getSuccessors().clear();
        block.getSuccessors().addAll(successors);

        IRInst instEnd = block.getInstEnd();
        block.getInstEnd().setNextInst(getInstBegin());
        instEnd.removeFromBlock();

        block.setInstEnd(getInstEnd());

        setInstBegin(null);
        setInstEnd(null);

        removeFromFunction();
    }

    public void removeFromFunction() {
        for (IRInst inst = getInstBegin(); inst != null; inst = inst.getNextInst())
            inst.removeFromBlock();

        assert isEmpty();

        if (getPrevBlock() == null)
            function.setEntryBlock(getNextBlock());
        else
            getPrevBlock().setNextBlock(getNextBlock());

        if (getNextBlock() == null)
            function.setExitBlock(getPrevBlock());
        else
            getNextBlock().setPrevBlock(getPrevBlock());
    }

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
        this.name = name + ++blockCounter;

        instBegin = null;
        instEnd = null;
        nextBlock = null;
        prevBlock = null;

        successors = new ArrayList<>();
        predecessors = new ArrayList<>();
    }

    public ArrayList<BasicBlock> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(ArrayList<BasicBlock> predecessors) {
        this.predecessors = predecessors;
    }

    public void calcSuccessors() {
        successors.clear();
        IRInst inst = getInstEnd();
        if (inst instanceof RetInst)
            return;
        assert inst instanceof BrInst;
        successors.add(((BrInst) inst).getThemBlock());
        if (((BrInst) inst).getElseBlock() != null)
            successors.add(((BrInst) inst).getElseBlock());
    }

    public ArrayList<BasicBlock> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<BasicBlock> successors) {
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
