package AST.Stmt;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.StmtNode;
import Util.Position;

public class ReturnStmtNode extends StmtNode {
    private ExprNode returnValue;

    public ReturnStmtNode(Position position, ExprNode returnValue) {
        super(position);
        this.returnValue = returnValue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ExprNode getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(ExprNode returnValue) {
        this.returnValue = returnValue;
    }
}
