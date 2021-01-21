package AST;

import Util.Position;

import java.util.ArrayList;

public class ProgramNode extends ASTNode {
    private ArrayList<DefNode> programComponent;

    public ArrayList<DefNode> getProgramComponent() {
        return programComponent;
    }

    public void setProgramComponent(ArrayList<DefNode> programComponent) {
        this.programComponent = programComponent;
    }

    public ProgramNode(Position position, ArrayList<DefNode> programComponent) {
        super(position);
        this.programComponent = programComponent;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
