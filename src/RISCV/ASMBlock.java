package RISCV;

import IR.BasicBlock;

import java.util.ArrayList;
import java.util.Set;

public class ASMBlock extends ASMObject {
    private String name;

    private BasicBlock irBlock;

    private ASMFunction asmFunction;
    private ASMBlock nextBlock, prevBlock;
    private ASMInst instBegin, instEnd;

    private ArrayList<ASMBlock> successors, predecessors;

    public void appendASMInstBack(ASMInst inst) {
        if (instBegin == null) {
            instBegin = inst;
            instEnd = inst;
        } else {
            instEnd.setNextInst(inst);
            inst.setPrevInst(instEnd);
            instEnd = inst;
        }
    }

    public BasicBlock getIrBlock() {
        return irBlock;
    }

    public void setIrBlock(BasicBlock irBlock) {
        this.irBlock = irBlock;
    }

    public void appendASMInstFront(ASMInst inst) {
        if (instBegin == null) {
            instBegin = inst;
            instEnd = inst;
        } else {
            instBegin.setPrevInst(inst);
            inst.setNextInst(instBegin);
            instBegin = inst;
        }
    }

    public void insertASMInstBefore(ASMInst inst, ASMInst newInst) {
        if (instBegin == inst)
            instBegin = newInst;
        newInst.setNextInst(inst);
        newInst.setPrevInst(inst.getPrevInst());
        if (inst.getPrevInst() != null)
            inst.getPrevInst().setNextInst(newInst);
        inst.setPrevInst(newInst);
    }

    public void insertASMInstAfter(ASMInst inst, ASMInst newInst) {
        if (instEnd == inst)
            instEnd = newInst;
        newInst.setPrevInst(inst);
        newInst.setNextInst(inst.getNextInst());
        if (inst.getNextInst() != null)
            inst.getNextInst().setPrevInst(newInst);
        inst.setNextInst(newInst);
    }

    public ArrayList<ASMBlock> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<ASMBlock> successors) {
        this.successors = successors;
    }

    public ArrayList<ASMBlock> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(ArrayList<ASMBlock> predecessors) {
        this.predecessors = predecessors;
    }

    public ASMBlock(ASMFunction asmFunction, BasicBlock basicBlock, String name) {
        this.name = name;
        this.asmFunction = asmFunction;
        successors = new ArrayList<>();
        predecessors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ASMFunction getAsmFunction() {
        return asmFunction;
    }

    public void setAsmFunction(ASMFunction asmFunction) {
        this.asmFunction = asmFunction;
    }

    public ASMBlock getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(ASMBlock nextBlock) {
        this.nextBlock = nextBlock;
    }

    public ASMBlock getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(ASMBlock prevBlock) {
        this.prevBlock = prevBlock;
    }

    public ASMInst getInstBegin() {
        return instBegin;
    }

    public void setInstBegin(ASMInst instBegin) {
        this.instBegin = instBegin;
    }

    public ASMInst getInstEnd() {
        return instEnd;
    }

    public void setInstEnd(ASMInst instEnd) {
        this.instEnd = instEnd;
    }

    @Override
    public String emitCode() {
        return name;
    }

    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
