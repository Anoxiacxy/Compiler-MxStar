package RISCV;

import IR.BasicBlock;
import IR.Function;

import java.util.*;

public class ASMFunction extends ASMObject {
    private ASMModule module;
    private String name;

    private Function irFunction;
    private ASMBlock entryBlock, exitBlock;
    private Map<BasicBlock, ASMBlock> asmBlockMap;

    private StackFrame stackFrame;

    public StackFrame getStackFrame() {
        return stackFrame;
    }

    public void setStackFrame(StackFrame stackFrame) {
        this.stackFrame = stackFrame;
    }

    public ASMModule getModule() {
        return module;
    }

    public void setModule(ASMModule module) {
        this.module = module;
    }

    public ASMBlock getEntryBlock() {
        return entryBlock;
    }

    public void setEntryBlock(ASMBlock entryBlock) {
        this.entryBlock = entryBlock;
    }

    public ASMBlock getExitBlock() {
        return exitBlock;
    }

    public void setExitBlock(ASMBlock exitBlock) {
        this.exitBlock = exitBlock;
    }

    public Map<BasicBlock, ASMBlock> getAsmBlockMap() {
        return asmBlockMap;
    }

    public void setAsmBlockMap(Map<BasicBlock, ASMBlock> asmBlockMap) {
        this.asmBlockMap = asmBlockMap;
    }

    public ASMFunction(ASMModule module, String name) {
        this.module = module;
        this.name = name;
    }

    public ASMFunction(ASMModule module, Function function) {
        this.name = function.getName();
        this.module = module;
        this.irFunction = function;

        asmBlockMap = new HashMap<>();
        ArrayList<BasicBlock> basicBlocks = new ArrayList<>();

        int blockID = 0;
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock()) {
            ASMBlock asmBlock = new ASMBlock(this , block,
                    ".L" + module.getFunctionMap().size() + "_" + blockID);
            this.appendASMBlock(asmBlock);
            asmBlockMap.put(block, asmBlock);
            basicBlocks.add(block);
            blockID++;
        }

        for (BasicBlock block : basicBlocks) {
            ASMBlock asmBlock = asmBlockMap.get(block);
            asmBlock.setIrBlock(block);
            for (BasicBlock prev : block.getPredecessors())
                asmBlock.getPredecessors().add(asmBlockMap.get(prev));
            for (BasicBlock next : block.getSuccessors())
                asmBlock.getSuccessors().add(asmBlockMap.get(next));
        }
    }

    public Function getIrFunction() {
        return irFunction;
    }

    public void setIrFunction(Function irFunction) {
        this.irFunction = irFunction;
    }

    public void appendASMBlock(ASMBlock asmBlock) {
        if (entryBlock == null) {
            entryBlock = asmBlock;
            exitBlock = asmBlock;
        } else {
            asmBlock.setPrevBlock(exitBlock);
            exitBlock.setNextBlock(asmBlock);
            exitBlock = asmBlock;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String emitCode() {
        return name;
    }

    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }


    private Set<ASMBlock> visited;
    private void dfs(ASMBlock block, ArrayList<ASMBlock> blocks) {
        blocks.add(block);
        for (ASMBlock next : block.getSuccessors())
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next, blocks);
            }
    }

    public ArrayList<ASMBlock> getDfsOrder() {
        visited = new HashSet<>();
        ArrayList<ASMBlock> blocks = new ArrayList<>();
        dfs(getEntryBlock(), blocks);
        return blocks;
    }
}
