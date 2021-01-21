package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class PrefExprNode extends ExprNode {
    private ExprNode rExpr;
    private String op;

    public PrefExprNode(Position position, ExprNode rExpr, String op) {
        super(position);
        this.rExpr = rExpr;
        this.op = op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ExprNode getrExpr() {
        return rExpr;
    }

    public void setrExpr(ExprNode rExpr) {
        this.rExpr = rExpr;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
