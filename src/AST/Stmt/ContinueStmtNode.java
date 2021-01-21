package AST.Stmt;

import AST.ASTVisitor;
import AST.StmtNode;
import Util.Position;

public class ContinueStmtNode extends StmtNode {
    public ContinueStmtNode(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
