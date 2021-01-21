package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class SuccExprNode extends ExprNode {
    private ExprNode lExpr;
    private String op;

    public SuccExprNode(Position position, ExprNode lExpr, String op) {
        super(position);
        this.lExpr = lExpr;
        this.op = op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ExprNode getlExpr() {
        return lExpr;
    }

    public void setlExpr(ExprNode lExpr) {
        this.lExpr = lExpr;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
