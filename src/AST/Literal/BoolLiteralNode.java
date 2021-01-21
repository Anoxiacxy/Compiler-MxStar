package AST.Literal;

import AST.ASTVisitor;
import AST.LiteralNode;
import Util.Position;

public class BoolLiteralNode extends LiteralNode {
    private boolean value;

    public BoolLiteralNode(Position position, boolean value) {
        super(position);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
