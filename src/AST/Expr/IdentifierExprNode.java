package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class IdentifierExprNode extends ExprNode {
    private String name;

    public IdentifierExprNode(Position position, String name) {
        super(position);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
