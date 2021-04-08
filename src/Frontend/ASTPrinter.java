package Frontend;

import AST.ASTVisitor;
import AST.BlockNode;
import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Expr.*;
import AST.Literal.*;
import AST.ProgramNode;
import AST.Stmt.*;
import AST.TypeNode;
import Util.Type.ArrayType;
import Util.Type.ClassType;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ASTPrinter implements ASTVisitor {
    private PrintStream output;
    private int indentNum;

    private void outputIndent() {
        output.print("   ");
    }
    private void outputLine(String msg) {
        for (int i = 0;i < indentNum;++i) outputIndent();
        output.println(msg);
    }

    public ASTPrinter(String outFile) throws FileNotFoundException {
        this.output = new PrintStream(outFile);
        this.indentNum = 0;
    }

    @Override
    public void visit(BlockStmtNode node) {
        outputLine(BlockStmtNode.class.toString());
        ++indentNum;
        node.getBlockNode().accept(this);
        --indentNum;
    }

    @Override
    public void visit(BreakStmtNode node) {
        outputLine(BreakStmtNode.class.toString());
    }

    @Override
    public void visit(ForStmtNode node) {
        outputLine(ForStmtNode.class.toString());
        if (node.getInit() != null) {
            outputLine("init");
            ++indentNum;
            node.getInit().accept(this);
            --indentNum;
        }
        if (node.getCond() != null) {
            outputLine("cond");
            ++indentNum;
            node.getCond().accept(this);
            --indentNum;
        }
        if (node.getIncr() != null) {
            outputLine("incr");
            ++indentNum;
            node.getIncr().accept(this);
            --indentNum;
        }
        if (node.getBody() != null) {
            outputLine("body");
            ++indentNum;
            node.getBody().accept(this);
            --indentNum;
        }
    }

    @Override
    public void visit(IfStmtNode node) {
        outputLine(IfStmtNode.class.toString());
        if (node.getCond() != null) {
            outputLine("cond");
            ++indentNum;
            node.getCond().accept(this);
            --indentNum;
        }
        if (node.getTrueBody() != null) {
            outputLine("true");
            ++indentNum;
            node.getTrueBody().accept(this);
            --indentNum;
        }
        if (node.getFalseBody() != null) {
            outputLine("false");
            ++indentNum;
            node.getFalseBody().accept(this);
            --indentNum;
        }
    }

    @Override
    public void visit(ReturnStmtNode node) {
        outputLine(ReturnStmtNode.class.toString());
    }

    @Override
    public void visit(WhileStmtNode node) {
        outputLine(WhileStmtNode.class.toString());
        if (node.getCond() != null) {
            outputLine("cond");
            ++indentNum;
            node.getCond().accept(this);
            --indentNum;
        }
        if (node.getBody() != null) {
            outputLine("body");
            ++indentNum;
            node.getBody().accept(this);
            --indentNum;
        }
    }

    @Override
    public void visit(BlockNode node) {
        outputLine(BlockNode.class.toString());
        if (node.getStatements() != null)
            node.getStatements().forEach(x->x.accept(this));
    }

    @Override
    public void visit(ContinueStmtNode node) {
        outputLine(ContinueStmtNode.class.toString());
    }

    @Override
    public void visit(ExprStmtNode node) {
        outputLine(ExprStmtNode.class.toString());
        ++indentNum;
        node.getExpression().accept(this);
        --indentNum;
    }

    @Override
    public void visit(EmptyStmtNode node) {
        outputLine(EmptyStmtNode.class.toString());
    }

    @Override
    public void visit(BinaryExprNode node) {
        outputLine(BinaryExprNode.class.toString());
        outputLine("left");
        ++indentNum;
        node.getlExpr().accept(this);
        --indentNum;
        outputLine("op");
        ++indentNum;
        outputLine(node.getOp());
        --indentNum;
        outputLine("right");
        ++indentNum;
        node.getrExpr().accept(this);
        --indentNum;
    }

    @Override
    public void visit(PrefExprNode node) {
        outputLine(PrefExprNode.class.toString());
        outputLine("op");
        ++indentNum;
        outputLine(node.getOp());
        --indentNum;
        outputLine("right");
        ++indentNum;
        node.getrExpr().accept(this);
        --indentNum;
    }

    @Override
    public void visit(SuccExprNode node) {
        outputLine(SuccExprNode.class.toString());
        outputLine("left");
        ++indentNum;
        node.getlExpr().accept(this);
        --indentNum;
        outputLine("op");
        ++indentNum;
        outputLine(node.getOp());
        --indentNum;
    }

    @Override
    public void visit(TypeNode node) {
        outputLine(TypeNode.class.toString());
        outputLine("name");
        ++indentNum;
        outputLine("" + node.getName());
        --indentNum;
        outputLine("dimension");
        ++indentNum;
        outputLine("" + node.getDimension());
        --indentNum;
    }

    @Override
    public void visit(NewExprNode node) {
        outputLine(NewExprNode.class.toString());
        ++indentNum;
        node.getTypeNode().accept(this);
        if (node.getExpressions() != null)
            node.getExpressions().forEach(x->x.accept(this));
        --indentNum;
    }

    @Override
    public void visit(VarDefNode node) {
        outputLine(VarDefNode.class.toString());
        ++indentNum;
        node.getVarDefStmtNode().accept(this);
        --indentNum;
    }

    @Override
    public void visit(ClassDefNode node) {
        outputLine(ClassDefNode.class.toString());
        outputLine("name");
        ++indentNum;
        outputLine(node.getName());
        --indentNum;
        outputLine("body");
        ++indentNum;
        node.getClassComponenet().forEach(x-> x.accept(this));
        --indentNum;
    }

    @Override
    public void visit(FuncExprNode node) {
        outputLine(FuncExprNode.class.toString());
        ++indentNum;
        node.getPointer().accept(this);
        if (node.getArgumentList() != null)
            node.getArgumentList().forEach(x-> x.accept(this));
        --indentNum;
    }

    @Override
    public void visit(FuncDefNode node) {
        outputLine(FuncDefNode.class.toString());
        outputLine("name");
        ++indentNum;
        outputLine(node.getName());
        --indentNum;
        outputLine("return type");
        ++indentNum;
        node.getReturnType().accept(this);
        --indentNum;
        outputLine("argument");
        ++indentNum;
        node.getParameterList().forEach(x-> x.accept(this));
        --indentNum;
        outputLine("body");
        ++indentNum;
        node.getBody().accept(this);
        --indentNum;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        outputLine(VarDefStmtNode.class.toString());
        outputLine("type");
        ++indentNum;
        node.getType().accept(this);
        --indentNum;
        outputLine("name");
        ++indentNum;
        outputLine(node.getName());
        --indentNum;
        if (node.getExpression() != null) {
            outputLine("value");
            ++indentNum;
            node.getExpression().accept(this);
            --indentNum;
        }
    }

    @Override
    public void visit(ArrayExprNode node) {
        outputLine(ArrayExprNode.class.toString());
        outputLine("pointer");
        ++indentNum;
        node.getPointer().accept(this);
        --indentNum;
        outputLine("offset");
        ++indentNum;
        node.getOffset().accept(this);
        --indentNum;
    }

    @Override
    public void visit(IdentifierExprNode node) {
        outputLine(IdentifierExprNode.class.toString());
        ++indentNum;
        outputLine(node.getName());
        --indentNum;
    }

    @Override
    public void visit(LiteralExprNode node) {
        outputLine(LiteralExprNode.class.toString());
        ++indentNum;
        node.getLiteral().accept(this);
        --indentNum;
    }

    @Override
    public void visit(MemberExprNode node) {
        outputLine(MemberExprNode.class.toString());
        outputLine("pointer");
        ++indentNum;
        node.getPointer().accept(this);
        --indentNum;
        outputLine("member");
        ++indentNum;
        outputLine(node.getMember());
        --indentNum;
    }

    @Override
    public void visit(BoolLiteralNode node) {
        outputLine(BoolLiteralNode.class.toString());
        ++indentNum;
        outputLine(node.isValue() ? "true" : "false");
        --indentNum;
    }

    @Override
    public void visit(IntLiteralNode node) {
        outputLine(IntLiteralNode.class.toString());
        ++indentNum;
        outputLine("" + node.getValue());
        --indentNum;
    }

    @Override
    public void visit(NullLiteralNode node) {
        outputLine(NullLiteralNode.class.toString());
    }

    @Override
    public void visit(StringLiteralNode node) {
        outputLine(StringLiteralNode.class.toString());
        ++indentNum;
        outputLine(node.getValue());
        --indentNum;
    }

    @Override
    public void visit(ThisLiteralNode node) {
        outputLine(ThisLiteralNode.class.toString());
    }

    @Override
    public void visit(ProgramNode node) {
        outputLine(ProgramNode.class.toString());
        ++indentNum;
        node.getProgramComponent().forEach(x->x.accept(this));
        --indentNum;
    }

    @Override
    public void visit(VarDefStmtNodes node) {
        outputLine(VarDefStmtNode.class.toString());
        ++indentNum;
        node.getDefNodes().forEach(x-> x.accept(this));
        --indentNum;
    }

    @Override
    public void visit(ListExprNode node) {
        outputLine(ListExprNode.class.toString());
        ++indentNum;
        node.getExprNodes().forEach(x-> x.accept(this));
        --indentNum;
    }
}
