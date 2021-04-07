package RISCV;

import IR.BasicBlock;

import java.util.Set;

public class ASMBlock extends ASMObject {
    private String name;

    private ASMFunction asmFunction;
    private ASMBlock nextBlock, prevBlock;
    private ASMInst instBegin, instEnd;

    private Set<ASMBlock> successors, predecessors;

    public void appendASMInst(ASMInst inst) {
        if (instBegin == null) {
            instBegin = inst;
            instEnd = inst;
        } else {
            instEnd.setNextInst(inst);
            inst.setPrevInst(instEnd);
            instEnd = inst;
        }
    }

    public Set<ASMBlock> getSuccessors() {
        return successors;
    }

    public void setSuccessors(Set<ASMBlock> successors) {
        this.successors = successors;
    }

    public Set<ASMBlock> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(Set<ASMBlock> predecessors) {
        this.predecessors = predecessors;
    }

    public ASMBlock(ASMFunction asmFunction, BasicBlock basicBlock, String name) {
        this.name = name;
        this.asmFunction = asmFunction;

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
