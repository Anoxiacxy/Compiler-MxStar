package AST.Literal;

import AST.ASTVisitor;
import AST.LiteralNode;
import Util.Position;

public class ThisLiteralNode extends LiteralNode {
    public ThisLiteralNode(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
