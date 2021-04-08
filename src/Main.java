import AST.ProgramNode;
import Backend.*;
import Frontend.ASTPrinter;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import IR.Module;
import Parser.MxStarLexer;
import Parser.MxStarParser;
import RISCV.ASMModule;
import Util.Error.Error;
import Util.Error.SemanticError;
import Util.MxStarErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;

        boolean doOptimization = true;
        boolean doCodeGen = true;
        boolean emitLLVM = false;
        boolean emitAST = false;

        if (args.length > 0) {
            for (String arg : args) {
                switch (arg) {
                    case "-O0": doOptimization = false; break;
                    case "-semantic": doCodeGen = false; break;
                    case "-emit-llvm": emitLLVM = true; break;
                    case "-emit-ast": emitAST = true; break;
                    default: break;
                }
            }
        }

        try {
            MxStarLexer lexer = new MxStarLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxStarErrorListener());
            MxStarParser parser = new MxStarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxStarErrorListener());
            MxStarParser.ProgramContext parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ProgramNode ASTRoot = (ProgramNode) astBuilder.visit(parseTreeRoot);

            {
                SemanticChecker semanticChecker = new SemanticChecker();
                semanticChecker.visit(ASTRoot);

                if (emitAST)
                    new ASTPrinter("output.ast").visit(ASTRoot);
            }

            if (!doCodeGen) return;

            IRBuilder irBuilder = new IRBuilder();
            irBuilder.visit(ASTRoot);
            Module irModule = irBuilder.getModule();
            if (emitLLVM)
                new IRPrinter("output-O0.ll").visit(irModule);

            // TODO: 2021/4/7 optimize
            new PhiResolve(irModule).run();

            if (emitLLVM)
                new IRPrinter("output-O1.ll").visit(irModule);

            InstructionSelector instructionSelector = new InstructionSelector();
            instructionSelector.visit(irModule);
            ASMModule asmModule = instructionSelector.getAsmModule();

            new CodeEmitter("lab/test.ir").visit(asmModule);

            // new RegisterAllocate(asmModule).run();
            new RegisterAllocate(asmModule).piss();

            //new CodeEmitter("output.s").visit(asmModule);
            new CodeEmitter("lab/test.s").visit(asmModule);

        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}