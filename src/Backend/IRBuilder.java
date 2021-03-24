package Backend;

import AST.*;
import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Expr.*;
import AST.Literal.*;
import AST.Stmt.*;
import IR.Module;

public class IRBuilder implements ASTVisitor {
    private Module module;

    @Override
    public void visit(BlockStmtNode node) {
        node.getBlockNode().accept(this);
    }

    @Override
    public void visit(BreakStmtNode node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(IfStmtNode node) {

    }

    @Override
    public void visit(ReturnStmtNode node) {

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(BlockNode node) {
        for (StmtNode stmtNode : node.getStatements())
            stmtNode.accept(this);
    }

    @Override
    public void visit(ContinueStmtNode node) {

    }

    @Override
    public void visit(ExprStmtNode node) {

    }

    @Override
    public void visit(EmptyStmtNode node) {

    }

    @Override
    public void visit(BinaryExprNode node) {

    }

    @Override
    public void visit(PrefExprNode node) {

    }

    @Override
    public void visit(SuccExprNode node) {

    }

    @Override
    public void visit(TypeNode node) {

    }

    @Override
    public void visit(NewExprNode node) {

    }

    @Override
    public void visit(VarDefNode node) {

    }

    @Override
    public void visit(ClassDefNode node) {
        for (DefNode defNode : node.getClassComponenet()) {
            if (defNode instanceof FuncDefNode)
                defNode.accept(this);
        }
    }

    @Override
    public void visit(FuncExprNode node) {

    }

    @Override
    public void visit(FuncDefNode node) {

    }

    @Override
    public void visit(VarDefStmtNode node) {

    }

    @Override
    public void visit(ArrayExprNode node) {

    }

    @Override
    public void visit(IdentifierExprNode node) {

    }

    @Override
    public void visit(LiteralExprNode node) {

    }

    @Override
    public void visit(MemberExprNode node) {

    }

    @Override
    public void visit(BoolLiteralNode node) {

    }

    @Override
    public void visit(IntLiteralNode node) {

    }

    @Override
    public void visit(NullLiteralNode node) {

    }

    @Override
    public void visit(StringLiteralNode node) {

    }

    @Override
    public void visit(ThisLiteralNode node) {

    }

    @Override
    public void visit(ProgramNode node) {

    }

    @Override
    public void visit(VarDefStmtNodes node) {

    }

    @Override
    public void visit(ListExprNode node) {

    }
}
