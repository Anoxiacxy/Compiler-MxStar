import AST.ASTNode;
import AST.ProgramNode;
import Frontend.ASTPrinter;
import Frontend.Builder;
import Frontend.SemanticChecker;
import Parser.MxStarLexer;
import Parser.MxStarParser;
import Util.Error.Error;
import Util.MxStarErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;

        try {
            MxStarLexer lexer = new MxStarLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxStarErrorListener());
            MxStarParser parser = new MxStarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxStarErrorListener());
            MxStarParser.ProgramContext parseTreeRoot = parser.program();
            Builder builder = new Builder();
            ProgramNode ASTRoot = (ProgramNode) builder.visit(parseTreeRoot);
            new ASTPrinter("ast.txt").visit(ASTRoot);
            new SemanticChecker().visit(ASTRoot);
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}