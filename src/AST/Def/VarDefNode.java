package AST.Def;

import AST.ASTVisitor;
import AST.DefNode;
import AST.Stmt.VarDefStmtNode;
import Util.Position;

public class VarDefNode extends DefNode {
    private VarDefStmtNode varDefStmtNode;

    public VarDefNode(Position position, VarDefStmtNode varDefStmtNode) {
        super(position);
        this.varDefStmtNode = varDefStmtNode;
    }

    public void setVarDefStmtNode(VarDefStmtNode varDefStmtNode) {
        this.varDefStmtNode = varDefStmtNode;
    }

    public VarDefStmtNode getVarDefStmtNode() {
        return varDefStmtNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
