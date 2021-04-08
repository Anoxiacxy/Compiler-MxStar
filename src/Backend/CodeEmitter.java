package Backend;

import RISCV.*;
import RISCV.Instruction.*;
import RISCV.Operand.GlobalVariable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CodeEmitter implements ASMVisitor {
    private String fileName;
    private OutputStream outputStream;
    private PrintWriter printWriter;
    private String indent;

    public CodeEmitter(String fileName) {
        this.fileName = fileName;
    }

    private void println(String string) {
        printWriter.println(indent + string);
    }

    private void print(String string) {
        printWriter.print(indent + string);
    }

    @Override
    public void visit(ASMModule module) {
        try {
            File file = new File(fileName);
            assert file.exists() || file.createNewFile();
            outputStream = new FileOutputStream(fileName, false);
            printWriter = new PrintWriter(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        indent = "\t";
        println(".text");
        indent = "";
        println("");

        for (ASMFunction function : module.getFunctionMap().values())
            function.accept(this);

        println("");

        indent = "\t";
        println(".section\t.sdata,\"aw\",@progbits");
        for (GlobalVariable gv : module.getGlobalVariableMap().values()) {
            if (!gv.isString()) {
                println(".global\t" + gv.getName());
                println(".p2align\t2");
            }
            println(gv.getName() + ":");
            println(gv.emitCode());
        }
        indent = "";


        try {
            printWriter.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void visit(ASMFunction function) {
        indent = "\t";
        println(".globl\t" + function.getName());
        println(".p2align\t2");
        println(".type\t" + function.getName() +",@function");
        indent = "";

        println(function.emitCode() + ":");
        for (ASMBlock block =  function.getEntryBlock(); block != null; block = block.getNextBlock())
            block.accept(this);

        indent = "\t";
        println(".size\t" + function.getName() + ", " + ".-" + function.getName());
        indent = "";
    }

    @Override
    public void visit(ASMBlock block) {
        println(block.getName() + ":");
        indent = "\t";
        for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
            println(inst.emitCode());
        indent = "";
    }

    @Override
    public void visit(Add inst) {

    }

    @Override
    public void visit(Addi inst) {

    }

    @Override
    public void visit(And inst) {

    }

    @Override
    public void visit(Andi inst) {

    }

    @Override
    public void visit(Beq inst) {

    }

    @Override
    public void visit(Beqz inst) {

    }

    @Override
    public void visit(Bge inst) {

    }

    @Override
    public void visit(Bgez inst) {

    }

    @Override
    public void visit(Bgt inst) {

    }

    @Override
    public void visit(Bgtz inst) {

    }

    @Override
    public void visit(Ble inst) {

    }

    @Override
    public void visit(Blez inst) {

    }

    @Override
    public void visit(Blt inst) {

    }

    @Override
    public void visit(Bltz inst) {

    }

    @Override
    public void visit(Bne inst) {

    }

    @Override
    public void visit(Bnez inst) {

    }

    @Override
    public void visit(Call inst) {

    }

    @Override
    public void visit(Div inst) {

    }

    @Override
    public void visit(J inst) {

    }

    @Override
    public void visit(La inst) {

    }

    @Override
    public void visit(Lb inst) {

    }

    @Override
    public void visit(Li inst) {

    }

    @Override
    public void visit(Lui inst) {

    }

    @Override
    public void visit(Lw inst) {

    }

    @Override
    public void visit(Mul inst) {

    }

    @Override
    public void visit(Mv inst) {

    }

    @Override
    public void visit(Or inst) {

    }

    @Override
    public void visit(Ori inst) {

    }

    @Override
    public void visit(Rem inst) {

    }

    @Override
    public void visit(Ret inst) {

    }

    @Override
    public void visit(Sb inst) {

    }

    @Override
    public void visit(Seqz inst) {

    }

    @Override
    public void visit(Sgtz inst) {

    }

    @Override
    public void visit(Sll inst) {

    }

    @Override
    public void visit(Slli inst) {

    }

    @Override
    public void visit(Slt inst) {

    }

    @Override
    public void visit(Slti inst) {

    }

    @Override
    public void visit(Sltz inst) {

    }

    @Override
    public void visit(Snez inst) {

    }

    @Override
    public void visit(Sra inst) {

    }

    @Override
    public void visit(Srai inst) {

    }

    @Override
    public void visit(Sub inst) {

    }

    @Override
    public void visit(Sw inst) {

    }

    @Override
    public void visit(Xor inst) {

    }

    @Override
    public void visit(Xori inst) {

    }
}
