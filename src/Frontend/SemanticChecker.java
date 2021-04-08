package Frontend;

import AST.*;
import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Expr.*;
import AST.Literal.*;
import AST.Stmt.*;
import Util.Error.SemanticError;
import Util.Position;
import Util.Scope;
import Util.Type.FuncSymbol;
import Util.Type.VarSymbol;
import Util.Type.ArrayType;
import Util.Type.ClassType;
import Util.Type.PrimaryType;
import Util.Type.Type;

public class SemanticChecker implements ASTVisitor {
    private final Scope globalScope;
    private Scope scope;

    public SemanticChecker() {
        globalScope = new Scope(Scope.ScopeType.globalScope, null);
        globalScope.newType("int", new PrimaryType("int"), new Position());
        globalScope.newType("bool", new PrimaryType("bool"), new Position());
        globalScope.newType("void", new PrimaryType("void"), new Position());
        globalScope.newType("null", new PrimaryType("null"), new Position());
        {
            ClassType stringType = new ClassType("string");
            {
                FuncSymbol func = new FuncSymbol(globalScope.getType("int", new Position()), "length");
                stringType.putFuncSymbol("length", func);
            }
            {
                FuncSymbol func = new FuncSymbol(stringType, "substring");
                func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "left"));
                func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "right"));
                stringType.putFuncSymbol("substring", func);
            }
            {
                FuncSymbol func = new FuncSymbol(globalScope.getType("int", new Position()), "parseInt");
                stringType.putFuncSymbol("parseInt", func);
            }
            {
                FuncSymbol func = new FuncSymbol(globalScope.getType("int", new Position()), "ord");
                func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "pos"));
                stringType.putFuncSymbol("ord", func);
            }
            globalScope.newType("string", stringType, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("void", new Position()), "print");
            func.getParameter().add(new VarSymbol(globalScope.getType("string", new Position()), "str"));
            globalScope.newFunSymbol("print", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("void", new Position()), "println");
            func.getParameter().add(new VarSymbol(globalScope.getType("string", new Position()), "str"));
            globalScope.newFunSymbol("println", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("void", new Position()), "printInt");
            func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "n"));
            globalScope.newFunSymbol("printInt", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("void", new Position()), "printlnInt");
            func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "n"));
            globalScope.newFunSymbol("printlnInt", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("string", new Position()), "getString");
            globalScope.newFunSymbol("getString", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("int", new Position()), "getInt");
            globalScope.newFunSymbol("getInt", func, new Position());
        }
        {
            FuncSymbol func = new FuncSymbol(globalScope.getType("string", new Position()), "toString");
            func.getParameter().add(new VarSymbol(globalScope.getType("int", new Position()), "i"));
            globalScope.newFunSymbol("toString", func, new Position());
        }
    }

    @Override
    public void visit(BlockStmtNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.blockScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            if (node.getBlockNode() != null)
                node.getBlockNode().accept(this);
        }
        scope = parentScope;
    }

    @Override
    public void visit(BreakStmtNode node) {
        node.setBelongScope(scope);
        if (scope.getLoopDepth() == 0)
            throw new SemanticError("break out of any loop", node.getPosition());
    }

    @Override
    public void visit(ForStmtNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.loopScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            scope.setLoopDepth(scope.getLoopDepth() + 1);
            if (node.getInit() != null)
                node.getInit().accept(this);

            if (node.getCond() != null) {
                node.getCond().accept(this);
                if (!node.getCond().getType().isBool())
                    throw new SemanticError("condition is not bool type", node.getCond().getPosition());
            }

            if (node.getIncr() != null)
                node.getIncr().accept(this);

            if (node.getBody() != null)
                node.getBody().accept(this);
        }
        scope = parentScope;
    }

    @Override
    public void visit(IfStmtNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.blockScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            if (node.getCond() != null) {
                node.getCond().accept(this);
                if (!node.getCond().getType().isBool())
                    throw new SemanticError("condition is not bool type", node.getPosition());
            } else
                throw new SemanticError("condition cannot be empty", node.getPosition());

            Scope curScope2 = new Scope(Scope.ScopeType.blockScope, scope);
            Scope parentScope2 = scope;
            parentScope2.getChildrenScope().add(curScope2);
            scope = curScope2;
            {
                if (node.getTrueBody() != null)
                    node.getTrueBody().accept(this);
            }
            scope = parentScope2;

            Scope curScope3 = new Scope(Scope.ScopeType.blockScope, scope);
            Scope parentScope3 = scope;
            parentScope2.getChildrenScope().add(curScope3);
            scope = curScope3;
            {
                if (node.getFalseBody() != null)
                    node.getFalseBody().accept(this);
            }
            scope = parentScope3;


        }
        scope = parentScope;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        node.setBelongScope(scope);
        if (scope.getFuncSymbol() == null)
            throw new SemanticError("return out of any function", node.getPosition());
        if (node.getReturnValue() != null) {
            node.getReturnValue().accept(this);
            if (!node.getReturnValue().getType().equals(scope.getFuncSymbol().getType()))
                throw new SemanticError("return type not match", node.getPosition());
        } else {
            if (!scope.getFuncSymbol().isConstructor() && !scope.getFuncSymbol().getType().isVoid())
                throw new SemanticError("return type not match", node.getPosition());
        }
        scope.getFuncSymbol().setReturned(true);
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.loopScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            scope.setLoopDepth(scope.getLoopDepth() + 1);
            if (node.getCond() != null) {
                node.getCond().accept(this);
                if (!node.getCond().getType().isBool())
                    throw new SemanticError("while condition should be bool type", node.getPosition());
            } else
                throw new SemanticError("while condition cannot be empty", node.getPosition());
            if (node.getBody() != null)
                node.getBody().accept(this);
            else
                throw new SemanticError("while body cannot be empty", node.getPosition());
        }
        scope = parentScope;
    }

    @Override
    public void visit(BlockNode node) {
        node.setBelongScope(scope);
        node.getStatements().forEach(x->x.accept(this));
    }

    @Override
    public void visit(ContinueStmtNode node) {
        node.setBelongScope(scope);
        if (scope.getLoopDepth() == 0)
            throw new SemanticError("continue out of any loop", node.getPosition());
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.setBelongScope(scope);
        node.getExpression().accept(this);
    }

    @Override
    public void visit(EmptyStmtNode node) {
        node.setBelongScope(scope);
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.setBelongScope(scope);
        node.getlExpr().accept(this);
        node.getrExpr().accept(this);
        switch (node.getOp()) {
            case "*":
            case "/":
            case "%":
            case "-":
            case "<<":
            case ">>":
            case "&":
            case "^":
            case "|":
                if (!node.getlExpr().getType().isInt())
                    throw new SemanticError("not int", node.getlExpr().getPosition());
                if (!node.getrExpr().getType().isInt())
                    throw new SemanticError("not int", node.getrExpr().getPosition());
                node.setType(globalScope.getType("int", node.getPosition()));
                break;
            case "+":
                if (!node.getlExpr().getType().equals(node.getrExpr().getType()))
                    throw new SemanticError("type not match", node.getPosition());
                if (!node.getlExpr().getType().isInt() && !node.getlExpr().getType().isString())
                    throw new SemanticError("not int or string", node.getPosition());
                node.setType(node.getlExpr().getType());
                break;
            case "<":
            case ">":
            case "<=":
            case ">=":
                if (!node.getlExpr().getType().equals(node.getrExpr().getType()))
                    throw new SemanticError("type not match", node.getPosition());
                if (!node.getlExpr().getType().isInt() && !node.getlExpr().getType().isString())
                    throw new SemanticError("not int or string", node.getPosition());
                node.setType(globalScope.getType("bool", node.getPosition()));
                break;
            case "&&":
            case "||":
                if (!node.getlExpr().getType().isBool())
                    throw new SemanticError("not bool", node.getlExpr().getPosition());
                if (!node.getrExpr().getType().isBool())
                    throw new SemanticError("not bool", node.getrExpr().getPosition());
                node.setType(globalScope.getType("bool", node.getPosition()));
                break;
            case "==":
            case "!=":
                if (!node.getlExpr().getType().equals(node.getrExpr().getType())
                    && !node.getrExpr().getType().equals(node.getlExpr().getType()))
                    throw new SemanticError("type not match", node.getPosition());
                node.setType(globalScope.getType("bool", node.getPosition()));
                break;
            case "=":
                if (!node.getrExpr().getType().equals(node.getlExpr().getType()))
                    throw new SemanticError("type not match", node.getPosition());
                if (!node.getlExpr().isLvalue())
                    throw new SemanticError("not lvalue", node.getPosition());
                node.setType(node.getlExpr().getType());
                node.setLvalue(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void visit(PrefExprNode node) {
        node.setBelongScope(scope);
        node.getrExpr().accept(this);
        switch (node.getOp()) {
            case "++":
            case "--":
                if (!node.getrExpr().isLvalue())
                    throw new SemanticError("not lvalue", node.getPosition());
                if (!node.getrExpr().getType().isInt())
                    throw new SemanticError("not int", node.getrExpr().getPosition());
                node.setLvalue(true);
                node.setType(globalScope.getType("int", node.getPosition()));
                break;
            case "+":
            case "-":
            case "~":
                if (!node.getrExpr().getType().isInt())
                    throw new SemanticError("not int", node.getrExpr().getPosition());
                node.setType(globalScope.getType("int", node.getPosition()));
                break;
            case "!":
                if (!node.getrExpr().getType().isBool())
                    throw new SemanticError("not bool", node.getrExpr().getPosition());
                node.setType(globalScope.getType("bool", node.getPosition()));
                break;
            default:
                break;
        }
    }

    @Override
    public void visit(SuccExprNode node) {
        node.setBelongScope(scope);
        node.getlExpr().accept(this);
        switch (node.getOp()) {
            case "++":
            case "--":
                if (!node.getlExpr().isLvalue())
                    throw new SemanticError("not lvalue", node.getPosition());
                if (!node.getlExpr().getType().isInt())
                    throw new SemanticError("not int", node.getlExpr().getPosition());
                node.setType(globalScope.getType("int", node.getPosition()));
                break;
            default:
                break;
        }
    }

    @Override
    public void visit(TypeNode node) {
        node.setBelongScope(scope);
    }

    @Override
    public void visit(NewExprNode node) {
        node.setBelongScope(scope);
        if (node.getExpressions() != null)
            node.getExpressions().forEach(x->{
                x.accept(this);
                if (!x.getType().isInt())
                    throw new SemanticError("not int", x.getPosition());
            });
        node.setType(scope.getType(node.getTypeNode()));
    }

    @Override
    public void visit(VarDefNode node) {
        node.setBelongScope(scope);
        node.getVarDefStmtNode().accept(this);
    }

    @Override
    public void visit(ClassDefNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.classScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            scope.setClassDefType((ClassType) globalScope.getType(node.getName(), node.getPosition()));
            scope.getClassDefType().getFuncSymbolHashMap().forEach((k, v)->scope.newFunSymbol(k, v, node.getPosition()));
            scope.getClassDefType().getVarSymbolHashMap().forEach((k, v)->scope.newVarSymbol(k, v, node.getPosition()));
            node.getClassComponenet().forEach(x->{
                if (x instanceof FuncDefNode)
                    x.accept(this);
            });
        }
        scope = parentScope;
    }

    @Override
    public void visit(FuncExprNode node) {
        node.setBelongScope(scope);
        if (node.getPointer() instanceof IdentifierExprNode)
            node.getPointer().setType(scope.getFuncSymbol(((IdentifierExprNode) node.getPointer()).getName(), node.getPosition()));
        else
            node.getPointer().accept(this);

        if (!(node.getPointer().getType() instanceof FuncSymbol))
            throw new SemanticError(node.getPointer().getType().getTypeName() + " is not a function", node.getPosition());

        FuncSymbol func = (FuncSymbol) node.getPointer().getType();
        node.getArgumentList().forEach(x->x.accept(this));
        if (func.getParameter().size() != node.getArgumentList().size())
            throw new SemanticError(node.getPointer().getType().getTypeName() + " parameter's number not match", node.getPosition());
        for (int i = 0; i < func.getParameter().size(); i++) {
            if (!node.getArgumentList().get(i).getType().equals(func.getParameter().get(i).getType()))
                throw new SemanticError(node.getArgumentList().get(i).getType().getTypeName() + " parameter's number not match",
                        node.getArgumentList().get(i).getPosition());
        }
        node.setType(func.getType());
    }

    @Override
    public void visit(FuncDefNode node) {
        node.setBelongScope(scope);
        Scope curScope = new Scope(Scope.ScopeType.functionScope, scope);
        Scope parentScope = scope;
        parentScope.getChildrenScope().add(curScope);
        scope = curScope;
        {
            scope.getFuncSymbol(node.getName(), node.getPosition()).getParameter().forEach(x->
                    scope.newVarSymbol(x.getName(), x, node.getPosition()));
            scope.setFuncSymbol(scope.getFuncSymbol(node.getName(), node.getPosition()));
            node.getBody().accept(this);
            if (node.getName().equals("main"))
                scope.getFuncSymbol().setReturned(true);

            if (!scope.getFuncSymbol().getType().isNull()
                    && !scope.getFuncSymbol().getType().isVoid()
                    && !scope.getFuncSymbol().isReturned())
                throw new SemanticError("no return", node.getPosition());
        }
        scope = parentScope;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.setBelongScope(scope);
        Type type = globalScope.getType(node.getType());
        if (type.isVoid())
            throw new SemanticError("void type cannot define a variable", node.getPosition());
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
            if (!type.isNull()) {
                if (!node.getExpression().getType().equals(type))
                    throw new SemanticError(type.getTypeName() + " type does not match", node.getPosition());
            } else
                type = node.getExpression().getType();
        }
        if (type.isNull())
            throw new SemanticError("type not offered", node.getPosition());
        scope.newVarSymbol(node.getName(), new VarSymbol(type, node.getName()), node.getPosition());
    }

    @Override
    public void visit(ArrayExprNode node) {
        node.setBelongScope(scope);
        node.getPointer().accept(this);
        node.getOffset().accept(this);
        if (!(node.getPointer().getType() instanceof ArrayType))
            throw new SemanticError(node.getPointer().getType().getTypeName() + " is not an array", node.getPosition());
        if (!node.getOffset().getType().isInt())
            throw new SemanticError("array index must be int", node.getOffset().getPosition());
        if (((ArrayType) node.getPointer().getType()).getDimension() == 1)
            node.setType(((ArrayType) node.getPointer().getType()).getBaseType());
        else
            node.setType(new ArrayType(((ArrayType) node.getPointer().getType()).getDimension() - 1,
                    ((ArrayType) node.getPointer().getType()).getBaseType()));
        node.setLvalue(true);
    }

    @Override
    public void visit(IdentifierExprNode node) {
        node.setBelongScope(scope);
        node.setVarSymbol(scope.getVarSymbol(node.getName(), node.getPosition()));
        node.setType(node.getVarSymbol().getType());
        node.setLvalue(true);
    }

    @Override
    public void visit(LiteralExprNode node) {
        node.setBelongScope(scope);
        System.out.println("should never used");
        node.getLiteral().accept(this);
        node.setType(node.getLiteral().getType());
    }

    @Override
    public void visit(MemberExprNode node) {
        node.setBelongScope(scope);
        node.getPointer().accept(this);
        if (node.getPointer().getType() instanceof ArrayType && node.isFunc() && node.getMember().equals("size")) {
            FuncSymbol func = new FuncSymbol(new PrimaryType("int"), "size"); // unused
            node.setType(func);
            return;
        }
        if (!(node.getPointer().getType() instanceof ClassType))
            throw new SemanticError(node.getPointer().getType().getTypeName() + " is not an instance of class", node.getPosition());

        ClassType classType = (ClassType) node.getPointer().getType();
        if (node.isFunc() && classType.getFuncSymbolHashMap().containsKey(node.getMember())) {
            node.setType(classType.getFuncSymbolHashMap().get(node.getMember()));
            return;
        }
        if (!node.isFunc() && classType.getVarSymbolHashMap().containsKey(node.getMember())) {
            node.setType(classType.getVarSymbol(node.getMember(), node.getPosition()).getType());
            node.setLvalue(true);
            return;
        }
        throw new SemanticError("member " + node.getMember() + " not exist", node.getPosition());
    }

    @Override
    public void visit(BoolLiteralNode node) {
        node.setBelongScope(scope);
        node.setType(globalScope.getType("bool", node.getPosition()));
    }

    @Override
    public void visit(IntLiteralNode node) {
        node.setBelongScope(scope);
        node.setType(globalScope.getType("int", node.getPosition()));
    }

    @Override
    public void visit(NullLiteralNode node) {
        node.setBelongScope(scope);
        node.setType(globalScope.getType("null", node.getPosition()));
    }

    @Override
    public void visit(StringLiteralNode node) {
        node.setBelongScope(scope);
        node.setType(globalScope.getType("string", node.getPosition()));
    }

    @Override
    public void visit(ThisLiteralNode node) {
        node.setBelongScope(scope);
        if (scope.getClassDefType() == null)
            throw new SemanticError("this is not in a class definition", node.getPosition());
        node.setType(scope.getClassDefType());
    }

    @Override
    public void visit(ProgramNode node) {
        node.getProgramComponent().forEach(x->{
            if (x instanceof ClassDefNode)
                globalScope.newType(((ClassDefNode) x).getName(), new ClassType(((ClassDefNode) x).getName()), x.getPosition());
        });
        node.getProgramComponent().forEach(x->{
            if (x instanceof FuncDefNode) {
                FuncSymbol func = new FuncSymbol(globalScope.getType(((FuncDefNode) x).getReturnType()), ((FuncDefNode) x).getName());
                for (VarDefStmtNode obj : ((FuncDefNode) x).getParameterList())
                    func.getParameter().add(new VarSymbol(globalScope.getType(obj.getType()), obj.getName()));
                globalScope.newFunSymbol(((FuncDefNode) x).getName(), func, x.getPosition());
                if (globalScope.getType(((FuncDefNode) x).getReturnType()).isNull())
                    throw new SemanticError("no return type", x.getPosition());
            }
        });
        node.getProgramComponent().forEach(x->{
            if (x instanceof VarDefNode) {
                globalScope.newVarSymbol(((VarDefNode) x).getVarDefStmtNode().getName(),
                        new VarSymbol(globalScope.getType(((VarDefNode) x).getVarDefStmtNode().getType()),
                                ((VarDefNode) x).getVarDefStmtNode().getName()),
                        x.getPosition());
            }
        });
        node.getProgramComponent().forEach(x->{
            if (x instanceof ClassDefNode) {
                ClassType classType = (ClassType) globalScope.getType(((ClassDefNode) x).getName(), x.getPosition());
                ((ClassDefNode) x).getClassComponenet().forEach(y->{
                    if (y instanceof FuncDefNode) {
                        FuncSymbol func = new FuncSymbol(globalScope.getType(((FuncDefNode) y).getReturnType()), ((FuncDefNode) y).getName());
                        func.setMethod(true);
                        ((FuncDefNode) y).getParameterList().forEach(z->
                                func.getParameter().add(new VarSymbol(globalScope.getType(z.getType()), z.getName())));
                        if (classType.getFuncSymbolHashMap().containsKey(((FuncDefNode) y).getName()))
                            throw new SemanticError(((FuncDefNode) y).getName() + " redefined", y.getPosition());

                        if (globalScope.getType(((FuncDefNode) y).getReturnType()).isNull()
                                ^ ((FuncDefNode) y).getName().equals(((ClassDefNode) x).getName()))
                            throw new SemanticError("constructor error", y.getPosition());
                        if (((FuncDefNode) y).getName().equals(((ClassDefNode) x).getName()))
                            func.setConstructor(true);

                        classType.putFuncSymbol(((FuncDefNode) y).getName(), func);
                    }
                    if (y instanceof VarDefNode) {
                        if (classType.getVarSymbolHashMap().containsKey(((VarDefNode) y).getVarDefStmtNode().getName()))
                            throw new SemanticError(((VarDefNode) y).getVarDefStmtNode().getName() + " redefined", y.getPosition());
                        classType.putVarSymbol(((VarDefNode) y).getVarDefStmtNode().getName(),
                                new VarSymbol(globalScope.getType(((VarDefNode) y).getVarDefStmtNode().getType()),
                                        ((VarDefNode) y).getVarDefStmtNode().getName()));
                    }
                });
            }
        });
        scope = globalScope;
        node.setBelongScope(scope);
        scope.getVarSymbolHashMap().clear();
        node.getProgramComponent().forEach(x->x.accept(this));
        FuncSymbol mainFunc = globalScope.getFuncSymbol("main", node.getPosition());
        if (!mainFunc.getType().isInt())
            throw new SemanticError("return type int required in function main", node.getPosition());
        if (mainFunc.getParameter().size() != 0)
            throw new SemanticError("no parameter needed in function main", node.getPosition());
    }

    @Override
    public void visit(VarDefStmtNodes node) {
        node.setBelongScope(scope);
        node.getDefNodes().forEach(x-> x.accept(this));
    }

    @Override
    public void visit(ListExprNode node) {
        node.setBelongScope(scope);
        node.getExprNodes().forEach(x-> x.accept(this));
    }
}
