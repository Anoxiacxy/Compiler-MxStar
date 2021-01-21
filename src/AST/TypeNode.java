package AST;

import Util.Position;

public class TypeNode extends ASTNode {
    private int dimension;
    private String name;

    public TypeNode(Position position, int dimension, String name) {
        super(position);
        this.dimension = dimension;
        this.name = name;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public int getDimension() {
        return dimension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
