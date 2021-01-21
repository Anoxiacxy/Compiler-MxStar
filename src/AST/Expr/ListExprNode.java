package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import Util.Position;

import java.util.ArrayList;

public class ListExprNode extends ExprNode {
    private ArrayList<ExprNode> exprNodes;

    public ListExprNode(Position position, ArrayList<ExprNode> exprNodes) {
        super(position);
        this.exprNodes = exprNodes;
    }

    public void setExprNodes(ArrayList<ExprNode> exprNodes) {
        this.exprNodes = exprNodes;
    }

    public ArrayList<ExprNode> getExprNodes() {
        return exprNodes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
