package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class BinaryExprNode extends ExprNode {
    private ExprNode lExpr, rExpr;
    private String op;

    public BinaryExprNode(Position position, ExprNode lExpr, ExprNode rExpr, String op) {
        super(position);
        this.lExpr = lExpr;
        this.rExpr = rExpr;
        this.op = op;
    }

    public ExprNode getlExpr() {
        return lExpr;
    }

    public ExprNode getrExpr() {
        return rExpr;
    }

    public void setlExpr(ExprNode lExpr) {
        this.lExpr = lExpr;
    }

    public void setrExpr(ExprNode rExpr) {
        this.rExpr = rExpr;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
