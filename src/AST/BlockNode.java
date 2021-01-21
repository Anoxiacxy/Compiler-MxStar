package AST;

import Util.Position;

import java.util.ArrayList;

public class BlockNode extends ASTNode {
    private ArrayList<StmtNode> statements;

    public void setStatements(ArrayList<StmtNode> statements) {
        this.statements = statements;
    }

    public ArrayList<StmtNode> getStatements() {
        return statements;
    }

    public BlockNode(Position position, ArrayList<StmtNode> statements) {
        super(position);
        this.statements = statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
