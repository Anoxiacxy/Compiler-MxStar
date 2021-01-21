package AST.Stmt;

import AST.ASTVisitor;
import AST.ExprNode;
import AST.StmtNode;
import Util.Position;

public class IfStmtNode extends StmtNode {
    private ExprNode cond;
    private StmtNode trueBody, falseBody;

    public IfStmtNode(Position position, ExprNode cond, StmtNode trueBody, StmtNode falseBody) {
        super(position);
        this.cond = cond;
        this.trueBody = trueBody;
        this.falseBody = falseBody;
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

    public StmtNode getTrueBody() {
        return trueBody;
    }

    public void setTrueBody(StmtNode trueBody) {
        this.trueBody = trueBody;
    }

    public StmtNode getFalseBody() {
        return falseBody;
    }

    public void setFalseBody(StmtNode falseBody) {
        this.falseBody = falseBody;
    }
}
