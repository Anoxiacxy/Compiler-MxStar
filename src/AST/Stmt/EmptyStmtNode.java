package AST.Stmt;

import AST.ASTVisitor;
import AST.StmtNode;
import Util.Position;

public class EmptyStmtNode extends StmtNode {
    public EmptyStmtNode(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
