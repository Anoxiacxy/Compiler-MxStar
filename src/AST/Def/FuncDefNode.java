package AST.Def;

import AST.ASTVisitor;
import AST.BlockNode;
import AST.DefNode;
import AST.Stmt.VarDefStmtNode;
import AST.TypeNode;
import Util.Position;

import java.util.ArrayList;

public class FuncDefNode extends DefNode {
    private String name;
    private TypeNode returnType;
    private ArrayList<VarDefStmtNode> parameterList;
    private BlockNode body;

    public String getName() {
        return name;
    }

    public FuncDefNode(Position position, String name, TypeNode returnType, ArrayList<VarDefStmtNode> parameterList, BlockNode body) {
        super(position);
        this.name = name;
        this.returnType = returnType;
        this.parameterList = parameterList;
        this.body = body;
    }

    public TypeNode getReturnType() {
        return returnType;
    }

    public ArrayList<VarDefStmtNode> getParameterList() {
        return parameterList;
    }

    public BlockNode getBody() {
        return body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public void setReturnType(TypeNode returnType) {
        this.returnType = returnType;
    }

    public void setParameterList(ArrayList<VarDefStmtNode> parameterList) {
        this.parameterList = parameterList;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }
}
