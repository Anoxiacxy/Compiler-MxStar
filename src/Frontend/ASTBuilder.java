package Frontend;

import AST.*;
import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Expr.*;
import AST.Literal.*;
import AST.Stmt.*;
import Parser.MxStarBaseVisitor;
import Parser.MxStarParser;
import Util.Error.InternalError;
import Util.Error.SemanticError;
import Util.Position;

import java.util.ArrayList;

public class ASTBuilder extends MxStarBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitErrorExpression(MxStarParser.ErrorExpressionContext ctx) {
        throw new SemanticError("error new expression", new Position(ctx));
    }

    @Override
    public ASTNode visitProgram(MxStarParser.ProgramContext ctx) {
        Position position = new Position(ctx);
        ArrayList<DefNode> programComponent = new ArrayList<>();
        if (ctx.programComponent() != null) {
            for (MxStarParser.ProgramComponentContext obj : ctx.programComponent()) {
                ASTNode subTree = visit(obj);
                if (subTree instanceof VarDefStmtNodes) {
                    for (VarDefStmtNode defStmtNode : ((VarDefStmtNodes) subTree).getDefNodes()) {
                        programComponent.add(new VarDefNode(position, defStmtNode));
                    }
                }
                else
                    programComponent.add((DefNode) subTree);
            }
        }
        return new ProgramNode(position, programComponent);
    }

    @Override
    public ASTNode visitProgramComponent(MxStarParser.ProgramComponentContext ctx) {
        if (ctx.functionDefinition() != null) return visit(ctx.functionDefinition());
        if (ctx.classDefinition() != null) return visit((ctx.classDefinition()));
        if (ctx.variableDefinition() != null) return visit(ctx.variableDefinition());
        throw new InternalError("visitProgramComponent", new Position(ctx));
    }

    @Override
    public ASTNode visitFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx) {
        Position position = new Position(ctx);
        TypeNode typeNode;
        if (ctx.returnType() != null)
            typeNode = (TypeNode) visit(ctx.returnType());
        else
            typeNode = new TypeNode(position, 0, "null");
        ArrayList<VarDefStmtNode> varDefStmtNodes = new ArrayList<>();
        BlockNode blockNode = (BlockNode) visit(ctx.block());
        if (ctx.parameterList() != null) {
            varDefStmtNodes.addAll(((VarDefStmtNodes) visit(ctx.parameterList())).getDefNodes());
        }
        return new FuncDefNode(position, ctx.Identifier().getText(), typeNode, varDefStmtNodes, blockNode);
    }

    @Override
    public ASTNode visitParameterList(MxStarParser.ParameterListContext ctx) {
        Position position = new Position(ctx);
        ArrayList<VarDefStmtNode> defNodes = new ArrayList<>();
        if (ctx.parameter() != null) {
            for (MxStarParser.ParameterContext obj : ctx.parameter()) {
                defNodes.add((VarDefStmtNode) visit(obj));
            }
        }
        return new VarDefStmtNodes(position, defNodes);
    }

    @Override
    public ASTNode visitParameter(MxStarParser.ParameterContext ctx) {
        Position position = new Position(ctx);
        TypeNode typeNode = (TypeNode) visit(ctx.type());
        return new VarDefStmtNode(position, typeNode, ctx.Identifier().getText(), null);
    }

    @Override
    public ASTNode visitClassDefinition(MxStarParser.ClassDefinitionContext ctx) {
        Position position = new Position(ctx);
        ArrayList<DefNode> classComponent = new ArrayList<>();
        if (ctx.classComponent() != null) {
            for (MxStarParser.ClassComponentContext obj : ctx.classComponent()) {
                ASTNode subTree = visit(obj);
                if (subTree instanceof VarDefStmtNodes) {
                    for (VarDefStmtNode defStmtNode : ((VarDefStmtNodes) subTree).getDefNodes()) {
                        classComponent.add(new VarDefNode(position, defStmtNode));
                    }
                }
                else
                    classComponent.add((DefNode) subTree);
            }
        }
        return new ClassDefNode(position, ctx.Identifier().getText(), classComponent);
    }

    @Override
    public ASTNode visitClassComponent(MxStarParser.ClassComponentContext ctx) {
        if (ctx.functionDefinition() != null) return visit(ctx.functionDefinition());
        if (ctx.classDefinition() != null) return visit((ctx.classDefinition()));
        if (ctx.variableDefinition() != null) return visit(ctx.variableDefinition());
        throw new InternalError("visitClassComponent", new Position(ctx));
    }


    @Override
    public ASTNode visitVariableDefinition(MxStarParser.VariableDefinitionContext ctx) {
        Position position = new Position(ctx);
        TypeNode typeNode;
        ArrayList<VarDefStmtNode> defNodes = new ArrayList<>();
        if (ctx.type() != null)
            typeNode = (TypeNode) visit(ctx.type());
        else
            typeNode = new TypeNode(position, 0, "null");
        if (ctx.singleDefinition() != null) {
            for (MxStarParser.SingleDefinitionContext obj : ctx.singleDefinition()) {
                defNodes.add(((VarDefStmtNode) visit(obj)).setType(typeNode));
            }
        }
        return new VarDefStmtNodes(position, defNodes);
    }

    @Override
    public ASTNode visitSingleDefinition(MxStarParser.SingleDefinitionContext ctx) {
        Position position = new Position(ctx);
        ExprNode exprNode = null;
        if (ctx.expression() != null)
            exprNode = (ExprNode) visit(ctx.expression());
        return new VarDefStmtNode(position, null, ctx.Identifier().getText(), exprNode);
    }

    @Override
    public ASTNode visitBlock(MxStarParser.BlockContext ctx) {
        Position position = new Position(ctx);
        ArrayList<StmtNode> stmtNodes = new ArrayList<>();
        if (ctx.statement() != null) {
            for (MxStarParser.StatementContext obj : ctx.statement()) {
                StmtNode subTree = (StmtNode) visit(obj);
                if (subTree instanceof VarDefStmtNodes)
                    stmtNodes.addAll(((VarDefStmtNodes) subTree).getDefNodes());
                else
                    stmtNodes.add((StmtNode) visit(obj));
            }
        }
        return new BlockNode(position, stmtNodes);
    }

    @Override
    public ASTNode visitVarDefStatement(MxStarParser.VarDefStatementContext ctx) {
        return visit(ctx.variableDefinition());
    }

    @Override
    public ASTNode visitBlockStatement(MxStarParser.BlockStatementContext ctx) {
        Position position = new Position(ctx);
        BlockNode blockNode = (BlockNode) visit(ctx.block());
        return new BlockStmtNode(position, blockNode);
    }

    @Override
    public ASTNode visitIfStatement(MxStarParser.IfStatementContext ctx) {
        Position position = new Position(ctx);
        ExprNode cond = (ExprNode) visit(ctx.cond);
        StmtNode trueBody = (StmtNode) visit(ctx.trueStmt);
        StmtNode falseBody = null;
        if (ctx.falseStmt != null)
            falseBody = (StmtNode) visit(ctx.falseStmt);
        return new IfStmtNode(position, cond, trueBody, falseBody);
    }

    @Override
    public ASTNode visitWhileStatement(MxStarParser.WhileStatementContext ctx) {
        Position position = new Position(ctx);
        ExprNode cond = (ExprNode) visit(ctx.cond);
        StmtNode body = (StmtNode) visit(ctx.statement());
        return new WhileStmtNode(position, cond, body);
    }

    @Override
    public ASTNode visitForStatement(MxStarParser.ForStatementContext ctx) {
        Position position = new Position(ctx);
        ExprNode init = null;
        if (ctx.init != null)
            init = (ExprNode) visit(ctx.init);
        ExprNode cond = null;
        if (ctx.cond != null)
            cond = (ExprNode) visit(ctx.cond);
        ExprNode incr = null;
        if (ctx.incr != null)
            incr = (ExprNode) visit(ctx.incr);
        StmtNode body = (StmtNode) visit(ctx.statement());
        return new ForStmtNode(position, init, cond, incr, body);
    }

    @Override
    public ASTNode visitReturnStatement(MxStarParser.ReturnStatementContext ctx) {
        Position position = new Position(ctx);
        ExprNode value = null;
        if (ctx.expression() != null)
            value = (ExprNode) visit(ctx.expression());
        return new ReturnStmtNode(position, value);
    }

    @Override
    public ASTNode visitBreakStatement(MxStarParser.BreakStatementContext ctx) {
        return new BreakStmtNode(new Position(ctx));
    }

    @Override
    public ASTNode visitContinueStatement(MxStarParser.ContinueStatementContext ctx) {
        return new ContinueStmtNode(new Position(ctx));
    }

    @Override
    public ASTNode visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx) {
        Position position = new Position(ctx);
        ExprNode exprNode = (ExprNode) visit(ctx.expression());
        return new ExprStmtNode(position, exprNode);
    }

    @Override
    public ASTNode visitEmptyStatement(MxStarParser.EmptyStatementContext ctx) {
        return new EmptyStmtNode(new Position(ctx));
    }

    @Override
    public ASTNode visitBinaryExpression(MxStarParser.BinaryExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode lExpr = (ExprNode) visit(ctx.expression(0));
        ExprNode rExpr = (ExprNode) visit(ctx.expression(1));
        return new BinaryExprNode(position, lExpr, rExpr, ctx.op.getText());
    }

    @Override
    public ASTNode visitArrayExpression(MxStarParser.ArrayExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode pointer = (ExprNode) visit(ctx.pointer);
        ExprNode offset = (ExprNode) visit(ctx.offset);
        return new ArrayExprNode(position, pointer, offset);
    }

    @Override
    public ASTNode visitNewExpression(MxStarParser.NewExpressionContext ctx) {
        Position position = new Position(ctx);
        TypeNode typeNode = (TypeNode) visit(ctx.baseType());
        ArrayList<ExprNode> exprNodes = new ArrayList<>();
        if (ctx.expression() != null) {
            for (MxStarParser.ExpressionContext obj : ctx.expression()) {
                exprNodes.add((ExprNode) visit(obj));
            }
        }
        typeNode.setDimension(ctx.LeftBracket().size());
        return new NewExprNode(position, exprNodes, typeNode);
    }

    @Override
    public ASTNode visitIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx) {
        return new IdentifierExprNode(new Position(ctx), ctx.Identifier().getText());
    }

    @Override
    public ASTNode visitLiteralExpression(MxStarParser.LiteralExpressionContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public ASTNode visitMemberExpression(MxStarParser.MemberExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode pointer = (ExprNode) visit(ctx.pointer);
        return new MemberExprNode(position, pointer, ctx.Identifier().getText());
    }

    @Override
    public ASTNode visitSubExpression(MxStarParser.SubExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public ASTNode visitPrefExpression(MxStarParser.PrefExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode rExpr = (ExprNode) visit(ctx.expression());
        return new PrefExprNode(position, rExpr, ctx.op.getText());
    }

    @Override
    public ASTNode visitFuncExpression(MxStarParser.FuncExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode pointer = (ExprNode) visit(ctx.pointer);
        pointer.setFunc(true);
        ListExprNode arguments = new ListExprNode(position, new ArrayList<>());
        if (ctx.argumentList != null)
            arguments = (ListExprNode) visit(ctx.argumentList);
        return new FuncExprNode(position, pointer, arguments.getExprNodes());
    }

    @Override
    public ASTNode visitExpressionList(MxStarParser.ExpressionListContext ctx) {
        Position position = new Position(ctx);
        ArrayList<ExprNode> exprNodes = new ArrayList<>();
        if (ctx.expression() != null) {
            for (MxStarParser.ExpressionContext obj : ctx.expression()) {
                exprNodes.add((ExprNode) visit(obj));
            }
        }
        return new ListExprNode(position, exprNodes);
    }

    @Override
    public ASTNode visitSuccExpression(MxStarParser.SuccExpressionContext ctx) {
        Position position = new Position(ctx);
        ExprNode lExpr = (ExprNode) visit(ctx.expression());
        return new SuccExprNode(position, lExpr, ctx.op.getText());
    }

    @Override
    public ASTNode visitType(MxStarParser.TypeContext ctx) {
        TypeNode typeNode = (TypeNode) visit(ctx.baseType());
        typeNode.setDimension(ctx.LeftBracket().size());
        return typeNode;
    }

    @Override
    public ASTNode visitReturnType(MxStarParser.ReturnTypeContext ctx) {
        if (ctx.type() != null)
            return visit(ctx.type());
        else
            return new TypeNode(new Position(ctx), 0, "void");

    }

    @Override
    public ASTNode visitBaseType(MxStarParser.BaseTypeContext ctx) {
        return new TypeNode(new Position(ctx), 0, ctx.getText());
    }

    @Override
    public ASTNode visitBoolLiteral(MxStarParser.BoolLiteralContext ctx) {
        return new BoolLiteralNode(new Position(ctx), ctx.BoolLiteral().getText().equals("true"));
    }

    @Override
    public ASTNode visitIntLiteral(MxStarParser.IntLiteralContext ctx) {
        return new IntLiteralNode(new Position(ctx), (int) Long.parseLong(ctx.IntegerLiteral().getText()));
    }

    @Override
    public ASTNode visitStringLiteral(MxStarParser.StringLiteralContext ctx) {
        return new StringLiteralNode(new Position(ctx), ctx.StringLiteral().getText());
    }

    @Override
    public ASTNode visitNullLiteral(MxStarParser.NullLiteralContext ctx) {
        return new NullLiteralNode(new Position(ctx));
    }

    @Override
    public ASTNode visitThisLiteral(MxStarParser.ThisLiteralContext ctx) {
        return new ThisLiteralNode(new Position(ctx));
    }


}
