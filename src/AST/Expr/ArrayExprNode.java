package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class ArrayExprNode extends ExprNode {
    private ExprNode pointer, offset;

    public ArrayExprNode(Position position, ExprNode pointer, ExprNode offset) {
        super(position);
        this.pointer = pointer;
        this.offset = offset;
    }

    public ExprNode getPointer() {
        return pointer;
    }

    public ExprNode getOffset() {
        return offset;
    }

    public void setPointer(ExprNode pointer) {
        this.pointer = pointer;
    }

    public void setOffset(ExprNode offset) {
        this.offset = offset;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
