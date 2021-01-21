package AST.Literal;

import AST.ASTVisitor;
import AST.LiteralNode;
import Util.Position;

public class IntLiteralNode extends LiteralNode {
    private int value;

    public IntLiteralNode(Position position, int value) {
        super(position);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
