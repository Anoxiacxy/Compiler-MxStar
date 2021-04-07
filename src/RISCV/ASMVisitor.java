package RISCV;

import RISCV.Instruction.*;

public interface ASMVisitor {

    void visit(ASMModule module);
    void visit(ASMFunction function);
    void visit(ASMBlock block);

    void visit(Add inst);
    void visit(Addi inst);
    void visit(And inst);
    void visit(Andi inst);
    void visit(Beq inst);
    void visit(Beqz inst);
    void visit(Bge inst);
    void visit(Bgez inst);
    void visit(Bgt inst);
    void visit(Bgtz inst);
    void visit(Ble inst);
    void visit(Blez inst);
    void visit(Blt inst);
    void visit(Bltz inst);
    void visit(Bne inst);
    void visit(Bnez inst);
    void visit(Call inst);
    void visit(Div inst);
    void visit(J inst);
    void visit(La inst);
    void visit(Lb inst);
    void visit(Li inst);
    void visit(Lui inst);
    void visit(Lw inst);
    void visit(Mul inst);
    void visit(Mv inst);
    void visit(Or inst);
    void visit(Ori inst);
    void visit(Rem inst);
    void visit(Ret inst);
    void visit(Sb inst);
    void visit(Seqz inst);
    void visit(Sgtz inst);
    void visit(Sll inst);
    void visit(Slli inst);
    void visit(Slt inst);
    void visit(Slti inst);
    void visit(Sltz inst);
    void visit(Snez inst);
    void visit(Sra inst);
    void visit(Srai inst);
    void visit(Sub inst);
    void visit(Sw inst);
    void visit(Xor inst);
    void visit(Xori inst);
}
