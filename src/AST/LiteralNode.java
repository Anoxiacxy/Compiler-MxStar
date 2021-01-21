package AST;

import Util.Position;

public abstract class LiteralNode extends ExprNode {
    public LiteralNode(Position position) {
        super(position);
    }
}
