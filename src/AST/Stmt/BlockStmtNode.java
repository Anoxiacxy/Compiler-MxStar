package AST.Stmt;

import AST.ASTVisitor;
import AST.BlockNode;
import AST.StmtNode;
import Util.Position;

public class BlockStmtNode extends StmtNode {
    private BlockNode blockNode;

    public void setBlockNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public BlockStmtNode(Position position, BlockNode blockNode) {
        super(position);
        this.blockNode = blockNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
