package Backend;

import IR.BasicBlock;
import IR.Function;
import IR.IRVisitor;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.Parameter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class IRPrinter implements IRVisitor {
    private String fileName;
    private OutputStream outputStream;
    private PrintWriter printWriter;
    private String indent;

    public IRPrinter(String fileName) {
        this.fileName = fileName;

    }



    public void run(Module module) {
        try {
            File file = new File(fileName);
            assert file.exists() || file.createNewFile();
            outputStream = new FileOutputStream(fileName, false);
            printWriter = new PrintWriter(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        indent = "";

        module.accept(this);

        try {
            printWriter.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void println(String string) {
        printWriter.println(indent + string);
    }

    private void print(String string) {
        printWriter.print(indent + string);
    }

    @Override
    public void visit(Module module) {
        println("; ModuleID = 'test.cpp'");
        println("source_filename = \"test.cpp\"");
        println("");
        // TODO: 2021/4/2
        /*
        if (module.getStructureMap().size() > 0) {
            for (String name : module.getStructureMap().keySet())
                println(module.getStructureMap().get(name).structureToString());
            println("");
        }
        */
        /*
        if (module.getGlobalVariableMap().size() > 0) {
            for (String name : module.getGlobalVariableMap().keySet())
                println(module.getGlobalVariableMap().get(name).definitionToString());
            println("");
        }

        if (module.getSystemFunctionMap().size() > 0) {
            for (String name : module.getSystemFunctionMap().keySet())
                println(module.getSystemFunctionMap().get(name).declareToString());
            println("");
        }
        */

        for (String name : module.getFunctionMap().keySet()) {
            module.getFunctionMap().get(name).accept(this);
            println("");
        }
    }

    @Override
    public void visit(Function function) {
        StringBuilder header = new StringBuilder("define ");
        header.append(function.getFuncType().getReturnType().toString());
        header.append(" @").append(function.getName());

        header.append("(");
        for (int i = 0; i < function.getParameters().size(); i++) {
            Parameter parameter = function.getParameters().get(i);
            header.append(parameter.getType().toString()).append(" ");
            header.append(parameter.toString());
            if (i != function.getParameters().size() - 1)
                header.append(", ");
        }
        header.append(")").append(" ");
        print(header.toString());
        println("{");

        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock()) {
            block.accept(this);
            if (block.getName() != null)
                println("");
        }

        println("}");

    }

    @Override
    public void visit(BasicBlock block) {
        println(block.getName() + ":");
        indent = "\t";
        for (IRInst irInst = block.getInstBegin(); irInst != null; irInst = irInst.getNextInst()) {
            irInst.accept(this);
        }
        indent = "";
    }

    @Override
    public void visit(AllocaInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(BinaryInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(BitCastToInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(BrInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(CallInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(GetElementPtrInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(GlobalInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(IcmpInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(LoadInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(PhiInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(RetInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(StoreInst inst) {
        println(inst.toString());
    }

    @Override
    public void visit(MoveInst inst) {
        println(inst.toString());
    }
}
