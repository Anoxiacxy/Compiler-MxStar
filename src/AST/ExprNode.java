package AST;

import Util.Position;
import Util.Type.Type;

public abstract class ExprNode extends ASTNode {
    private Type type;
    private boolean lvalue;
    private boolean func;

    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    public boolean isLvalue() {
        return lvalue;
    }

    public ExprNode(Position position) {
        super(position);
        type = null;
        lvalue = false;
        func = false;
    }

    public boolean isFunc() {
        return func;
    }

    public void setFunc(boolean func) {
        this.func = func;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
