package AST.Stmt;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.StmtNode;
import Util.Position;

public class ForStmtNode extends StmtNode {
    private ExprNode init, cond, incr;
    private StmtNode body;

    public ExprNode getInit() {
        return init;
    }

    public ExprNode getCond() {
        return cond;
    }

    public void setInit(ExprNode init) {
        this.init = init;
    }

    public void setCond(ExprNode cond) {
        this.cond = cond;
    }

    public void setIncr(ExprNode incr) {
        this.incr = incr;
    }

    public void setBody(StmtNode body) {
        this.body = body;
    }

    public ExprNode getIncr() {
        return incr;
    }

    public StmtNode getBody() {
        return body;
    }

    public ForStmtNode(Position position, ExprNode init, ExprNode cond, ExprNode incr, StmtNode body) {
        super(position);
        this.init = init;
        this.cond = cond;
        this.incr = incr;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
