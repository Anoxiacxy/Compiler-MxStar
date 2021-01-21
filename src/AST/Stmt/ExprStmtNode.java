package AST.Stmt;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.StmtNode;
import Util.Position;

public class ExprStmtNode extends StmtNode {
    private ExprNode expression;

    public ExprNode getExpression() {
        return expression;
    }

    public void setExpression(ExprNode expression) {
        this.expression = expression;
    }

    public ExprStmtNode(Position position, ExprNode expression) {
        super(position);
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
