package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

import java.util.ArrayList;

public class FuncExprNode extends ExprNode {
    private ExprNode pointer;
    private ArrayList<ExprNode> argumentList;

    public FuncExprNode(Position position, ExprNode pointer, ArrayList<ExprNode> argumentList) {
        super(position);
        this.pointer = pointer;
        this.argumentList = argumentList;
    }

    public ExprNode getPointer() {
        return pointer;
    }

    public void setPointer(ExprNode pointer) {
        this.pointer = pointer;
    }

    public ArrayList<ExprNode> getArgumentList() {
        return argumentList;
    }

    public void setArgumentList(ArrayList<ExprNode> argumentList) {
        this.argumentList = argumentList;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
