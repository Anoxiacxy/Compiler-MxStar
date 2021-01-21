package AST.Stmt;

import AST.ASTVisitor;
import AST.StmtNode;
import Util.Position;

public class BreakStmtNode extends StmtNode {
    public BreakStmtNode(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
