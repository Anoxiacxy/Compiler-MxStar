package IR;

import IR.Instruction.*;

public interface IRVisitor {
    void visit(Module module);

    void visit(Function function);

    void visit(BasicBlock block);

    void visit(AllocaInst inst);
    void visit(BinaryInst inst);
    void visit(BitCastToInst inst);
    void visit(BrInst inst);
    void visit(CallInst inst);
    void visit(GetElementPtrInst inst);
    void visit(GlobalInst inst);
    void visit(IcmpInst inst);
    void visit(LoadInst inst);
    void visit(PhiInst inst);
    void visit(RetInst inst);
    void visit(StoreInst inst);
    void visit(MoveInst inst);
}
