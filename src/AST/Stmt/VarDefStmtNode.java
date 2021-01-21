package AST.Stmt;

import AST.*;
import Util.Position;

public class VarDefStmtNode extends StmtNode {
    private TypeNode type;
    private String name;
    private ExprNode expression;

    public VarDefStmtNode(Position position, TypeNode type, String name, ExprNode expression) {
        super(position);
        this.type = type;
        this.name = name;
        this.expression = expression;
    }

    public VarDefStmtNode setType(TypeNode type) {
        this.type = type;
        return this;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public TypeNode getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExprNode getExpression() {
        return expression;
    }

    public void setExpression(ExprNode expression) {
        this.expression = expression;
    }
}
