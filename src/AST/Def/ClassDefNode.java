package AST.Def;

import AST.ASTVisitor;
import AST.DefNode;
import Util.Position;

import java.util.ArrayList;

public class ClassDefNode extends DefNode {
    private String name;
    private ArrayList<DefNode> classComponenet;

    public String getName() {
        return name;
    }

    public ArrayList<DefNode> getClassComponenet() {
        return classComponenet;
    }

    public ClassDefNode(Position position, String name, ArrayList<DefNode> classComponenet) {
        super(position);
        this.name = name;
        this.classComponenet = classComponenet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassComponenet(ArrayList<DefNode> classComponenet) {
        this.classComponenet = classComponenet;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
