package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.LiteralNode;
import Util.Position;

public class LiteralExprNode extends ExprNode {
    private LiteralNode literal;

    public LiteralExprNode(Position position, LiteralNode literal) {
        super(position);
        this.literal = literal;
    }

    public LiteralNode getLiteral() {
        return literal;
    }

    public void setLiteral(LiteralNode literal) {
        this.literal = literal;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
