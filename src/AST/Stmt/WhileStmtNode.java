package AST.Stmt;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.StmtNode;
import Util.Position;

public class WhileStmtNode extends StmtNode {
    private ExprNode cond;
    private StmtNode body;

    public WhileStmtNode(Position position, ExprNode cond, StmtNode body) {
        super(position);
        this.cond = cond;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ExprNode getCond() {
        return cond;
    }

    public void setCond(ExprNode cond) {
        this.cond = cond;
    }

    public StmtNode getBody() {
        return body;
    }

    public void setBody(StmtNode body) {
        this.body = body;
    }
}
