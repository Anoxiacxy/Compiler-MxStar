package AST;

import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.VarDefStmtNodes;
import AST.Expr.*;
import AST.Literal.*;
import AST.Stmt.*;

public interface ASTVisitor {
    public void visit(BlockStmtNode node);
    public void visit(BreakStmtNode node);
    public void visit(ForStmtNode node);
    public void visit(IfStmtNode node);
    public void visit(ReturnStmtNode node);
    public void visit(WhileStmtNode node);
    public void visit(BlockNode node);
    public void visit(ContinueStmtNode node);
    public void visit(ExprStmtNode node);
    public void visit(EmptyStmtNode node);
    public void visit(BinaryExprNode node);
    public void visit(PrefExprNode node);
    public void visit(SuccExprNode node);
    public void visit(TypeNode node);
    public void visit(NewExprNode node);
    public void visit(VarDefNode node);
    public void visit(ClassDefNode node);
    public void visit(FuncExprNode node);
    public void visit(FuncDefNode node);
    public void visit(VarDefStmtNode node);
    public void visit(ArrayExprNode node);
    public void visit(IdentifierExprNode node);
    public void visit(LiteralExprNode node);
    public void visit(MemberExprNode node);
    public void visit(BoolLiteralNode node);
    public void visit(IntLiteralNode node);
    public void visit(NullLiteralNode node);
    public void visit(StringLiteralNode node);
    public void visit(ThisLiteralNode node);
    public void visit(ProgramNode node);
    public void visit(VarDefStmtNodes node);
    public void visit(ListExprNode node);
}
