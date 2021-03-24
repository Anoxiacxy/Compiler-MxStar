import AST.ProgramNode;
import Frontend.ASTPrinter;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Parser.MxStarLexer;
import Parser.MxStarParser;
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

            SemanticChecker semanticChecker = new SemanticChecker();
            semanticChecker.visit(ASTRoot);
            if (emitAST)
                new ASTPrinter("ast.txt").visit(ASTRoot);
            if (doCodeGen) {
                
            }
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}