package AST.Expr;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.TypeNode;
import Util.Position;

import java.util.ArrayList;

public class NewExprNode extends ExprNode {
    private ArrayList<ExprNode> expressions;
    private TypeNode typeNode;

    public ArrayList<ExprNode> getExpressions() {
        return expressions;
    }

    public void setExpressions(ArrayList<ExprNode> expressions) {
        this.expressions = expressions;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public void setTypeNode(TypeNode typeNode) {
        this.typeNode = typeNode;
    }

    public NewExprNode(Position position, ArrayList<ExprNode> expressions, TypeNode typeNode) {
        super(position);
        this.expressions = expressions;
        this.typeNode = typeNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
