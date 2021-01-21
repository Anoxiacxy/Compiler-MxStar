package AST.Stmt;

import AST.ASTVisitor;
import AST.StmtNode;
import Util.Position;

import java.util.ArrayList;

public class VarDefStmtNodes extends StmtNode {
    private ArrayList<VarDefStmtNode> defNodes;

    public VarDefStmtNodes(Position position, ArrayList<VarDefStmtNode> defNodes) {
        super(position);
        this.defNodes = defNodes;
    }

    public ArrayList<VarDefStmtNode> getDefNodes() {
        return defNodes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public void setDefNodes(ArrayList<VarDefStmtNode> defNodes) {
        this.defNodes = defNodes;
    }
}
