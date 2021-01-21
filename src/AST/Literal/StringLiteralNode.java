package AST.Literal;

import AST.ASTVisitor;
import AST.LiteralNode;
import Util.Position;

public class StringLiteralNode extends LiteralNode {
    private String value;

    public StringLiteralNode(Position position, String value) {
        super(position);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
