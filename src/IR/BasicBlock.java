package IR;

import IR.Instruction.IRInst;

public class BasicBlock extends IRObject {
    private Function function;
    private BasicBlock nextBlock, prevBlock;
    private IRInst instBegin, instEnd;
    private String name;

    public BasicBlock(Function function, String name) {
        this.function = function;
        this.name = name;
    }
}
