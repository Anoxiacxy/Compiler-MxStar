package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

public class MemberExprNode extends ExprNode {
    private ExprNode pointer;
    private String member;

    public ExprNode getPointer() {
        return pointer;
    }

    public void setPointer(ExprNode pointer) {
        this.pointer = pointer;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public MemberExprNode(Position position, ExprNode pointer, String member) {
        super(position);
        this.pointer = pointer;
        this.member = member;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
