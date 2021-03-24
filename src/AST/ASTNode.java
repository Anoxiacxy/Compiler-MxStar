package AST;

import Util.Position;
import Util.Scope;

public abstract class ASTNode {
    private Position position;
    private Scope belongScope;

    public Scope getBelongScope() {
        return belongScope;
    }

    public void setBelongScope(Scope belongScope) {
        this.belongScope = belongScope;
    }

    public ASTNode(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void accept(ASTVisitor visitor);

    public void setPosition(Position position) {
        this.position = position;
    }
}