package Backend;

import AST.*;
import AST.Def.ClassDefNode;
import AST.Def.FuncDefNode;
import AST.Def.VarDefNode;
import AST.Expr.*;
import AST.Literal.*;
import AST.Stmt.*;
import IR.*;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.*;
import IR.TypeSystem.ClassIRT;
import IR.TypeSystem.IRType;
import IR.TypeSystem.IntegerIRT;
import IR.TypeSystem.PointerIRT;
import Util.Error.ComplicationError;
import Util.Type.*;

import java.util.*;

import static IR.Module.*;

public class IRBuilder extends IRObject implements ASTVisitor {
    private TypeTable typeTable;

    private Module module;
    private Function curFunction;
    private BasicBlock curBasicBlock;
    private Map<ASTNode, Operand> nodeOperandLValue;
    private Map<ASTNode, Operand> nodeOperandResult;

    private Stack<BasicBlock> breakStack;
    private Stack<BasicBlock> continueStack;

    public IRBuilder() {
        this.module = new Module();
        nodeOperandResult = new LinkedHashMap<>();
        nodeOperandLValue = new LinkedHashMap<>();

        breakStack = new Stack<>();
        continueStack = new Stack<>();
    }

    public Module getModule() {
        return module;
    }

    @Override
    public void visit(BlockStmtNode node) {
        node.getBlockNode().accept(this);
    }

    @Override
    public void visit(BreakStmtNode node) {
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, breakStack.peek(), null));
        BasicBlock block = new BasicBlock(curFunction, "afterBreak");
        curFunction.appendBlock(block);
        curBasicBlock = block;
    }

    @Override
    public void visit(ForStmtNode node) {
        BasicBlock condBlock = new BasicBlock(curFunction, "condBlock");
        BasicBlock bodyBlock = new BasicBlock(curFunction, "bodyBlock");
        BasicBlock incrBlock = new BasicBlock(curFunction, "incrBlock");
        BasicBlock mergeBlock = new BasicBlock(curFunction, "mergeBlock");

        if (node.getInit() != null)
            node.getInit().accept(this);

        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));

        curBasicBlock = condBlock;
        curFunction.appendBlock(condBlock);
        Operand condResult = new ConstBool(bool_t, true);
        if (node.getCond() != null) {
            node.getCond().accept(this);
            condResult = nodeOperandResult.get(node.getCond());
        }
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, condResult, bodyBlock, mergeBlock));

        breakStack.push(mergeBlock);
        continueStack.push(incrBlock);
        curBasicBlock = bodyBlock;
        curFunction.appendBlock(bodyBlock);
        if (node.getBody() != null)
            node.getBody().accept(this);
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, incrBlock, null));
        breakStack.pop();
        continueStack.pop();

        curBasicBlock = incrBlock;
        curFunction.appendBlock(incrBlock);
        if (node.getIncr() != null)
            node.getIncr().accept(this);
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));

        curBasicBlock = mergeBlock;
        curFunction.appendBlock(mergeBlock);

    }

    @Override
    public void visit(IfStmtNode node) {
        BasicBlock thenBlock = new BasicBlock(curFunction, "ifThenBlock");
        BasicBlock elseBlock = new BasicBlock(curFunction, "ifElseBlock");
        BasicBlock mergeBlock = new BasicBlock(curFunction, "ifMergeBlock");

        node.getCond().accept(this);
        Operand condResult = (Operand) nodeOperandResult.get(node.getCond());
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, condResult, thenBlock, elseBlock));

        curBasicBlock = thenBlock;
        curFunction.appendBlock(thenBlock);
        if (node.getTrueBody() != null)
            node.getTrueBody().accept(this);
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, mergeBlock, null));

        curBasicBlock = elseBlock;
        curFunction.appendBlock(elseBlock);
        if (node.getFalseBody() != null)
            node.getFalseBody().accept(this);
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, mergeBlock, null));

        curBasicBlock = mergeBlock;
        curFunction.appendBlock(mergeBlock);
    }

    @Override
    public void visit(WhileStmtNode node) {
        BasicBlock condBlock = new BasicBlock(curFunction, "whileCondBlock");
        BasicBlock bodyBlock = new BasicBlock(curFunction, "whileBodyBlock");
        BasicBlock mergeBlock = new BasicBlock(curFunction, "whileMergeBlock");

        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));

        curBasicBlock = condBlock;
        curFunction.appendBlock(condBlock);
        node.getCond().accept(this);
        Operand condResult = nodeOperandResult.get(node.getCond());
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, condResult, bodyBlock, mergeBlock));

        curBasicBlock = bodyBlock;
        curFunction.appendBlock(bodyBlock);
        breakStack.push(mergeBlock);
        continueStack.push(condBlock);
        node.getBody().accept(this);
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));
        breakStack.pop();
        continueStack.pop();

        curBasicBlock = mergeBlock;
        curFunction.appendBlock(mergeBlock);
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.getReturnValue() != null) {
            node.getReturnValue().accept(this);
            Operand result = (Operand) nodeOperandResult.get(node.getReturnValue());
            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, result, curFunction.getReturnValueAddress()));
        }
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, curFunction.getReturnBlock(), null));

        BasicBlock block = new BasicBlock(curFunction, "afterReturn");
        curFunction.appendBlock(block);
        curBasicBlock = block;
    }
    
    @Override
    public void visit(BlockNode node) {
        for (StmtNode stmtNode : node.getStatements())
            stmtNode.accept(this);
    }

    @Override
    public void visit(ContinueStmtNode node) {
        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, continueStack.peek(), null));
        BasicBlock block = new BasicBlock(curFunction, "afterContinue");
        curFunction.appendBlock(block);
        curBasicBlock = block;
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.getExpression().accept(this);
    }

    @Override
    public void visit(EmptyStmtNode node) {
        // nothing to do
    }

    @Override
    public void visit(BinaryExprNode node) {
        boolean shortCircuitEvaluation =
                node.getOp().equals("||") || node.getOp().equals("&&");
        if (!shortCircuitEvaluation) {
            node.getlExpr().accept(this);
            node.getrExpr().accept(this);
            Operand lhs = nodeOperandResult.get(node.getlExpr());
            Operand lhs$addr = nodeOperandLValue.get(node.getlExpr());
            Operand rhs = nodeOperandResult.get(node.getrExpr());
            Operand result = new LocalRegister(typeTable.getIRType(node.getType()), "result");
            Operand result$addr = null;

            Type lType = node.getlExpr().getType();
            Type rType = node.getrExpr().getType();

            switch (node.getOp()) {
                case "*":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() * ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.mul, lhs, rhs, (Register) result));
                    break;
                case "/":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt && ((ConstInt) rhs).getValue() != 0) {
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() / ((ConstInt) rhs).getValue());
                    }
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.sdiv, lhs, rhs, (Register) result));
                    break;
                case "%":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt && ((ConstInt) rhs).getValue() != 0) {
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() % ((ConstInt) rhs).getValue());
                    }
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.srem, lhs, rhs, (Register) result));
                    break;
                case "-":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() - ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.sub, lhs, rhs, (Register) result));
                    break;
                case "<<":
                    if (rhs instanceof ConstInt && ((ConstInt) rhs).getValue() >= 32)
                        result = new ConstInt(int_t, 0);
                    else if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() << ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.shl, lhs, rhs, (Register) result));
                    break;
                case ">>":
                    if (rhs instanceof ConstInt && ((ConstInt) rhs).getValue() >= 32)
                        result = new ConstInt(int_t, 0);
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() >> ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.ashr, lhs, rhs, (Register) result));
                    break;
                case "&":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() & ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.and, lhs, rhs, (Register) result));
                    break;
                case "|":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() | ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.or, lhs, rhs, (Register) result));
                    break;
                case "^":
                    if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                        result = new ConstInt(int_t, ((ConstInt) lhs).getValue() ^ ((ConstInt) rhs).getValue());
                    else
                        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                BinaryInst.OpType.xor, lhs, rhs, (Register) result));
                    break;
                case "+":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_add");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstInt(int_t, ((ConstInt) lhs).getValue() + ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                                    BinaryInst.OpType.add, lhs, rhs, (Register) result));
                    }
                    break;
                case ">":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_gt");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() > ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.sgt, lhs, rhs, (Register) result, int_t));
                    }
                    break;
                case "<":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_lt");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() < ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.slt, lhs, rhs, (Register) result, int_t));
                    }
                    break;
                case ">=":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_ge");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() >= ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.sge, lhs, rhs, (Register) result, int_t));
                    }
                    break;
                case "<=":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_le");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() <= ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.sle, lhs, rhs, (Register) result, int_t));
                    }
                    break;
                case "==":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_eq");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else if (lType.isInt() && rType.isInt()) {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() == ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.eq, lhs, rhs, (Register) result, int_t));
                    } else if (lType.isBool() && rType.isBool()) {
                        if (lhs instanceof ConstBool && rhs instanceof ConstBool)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() == ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.eq, lhs, rhs, (Register) result, int_t));
                    } else if (lType.isArray() && rType.isNull()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.eq, lhs, rhs, (Register) result, lhs.getType()));
                    } else if (lType.isNull() && rType.isArray()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.eq, lhs, rhs, (Register) result, rhs.getType()));
                    } else if (lType.isClass() && rType.isNull()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.eq, lhs, rhs, (Register) result, lhs.getType()));
                    } else if (lType.isNull() && rType.isClass()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.eq, lhs, rhs, (Register) result, rhs.getType()));
                    } else if (lType.isNull() && rType.isNull()) {
                        result = new ConstBool(bool_t, true);
                    }
                    break;
                case "!=":
                    if (lType.isString() && rType.isString()) {
                        Function function = module.getSystemFunctionMap().get("mx__string_ne");
                        ArrayList<Operand> parameters = new ArrayList<>();
                        parameters.add(lhs);
                        parameters.add(rhs);
                        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, parameters, (Register) result));
                    } else if (lType.isInt() && rType.isInt()) {
                        if (lhs instanceof ConstInt && rhs instanceof ConstInt)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() != ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.ne, lhs, rhs, (Register) result, int_t));
                    } else if (lType.isBool() && rType.isBool()) {
                        if (lhs instanceof ConstBool && rhs instanceof ConstBool)
                            result = new ConstBool(bool_t, ((ConstInt) lhs).getValue() != ((ConstInt) rhs).getValue());
                        else
                            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                    IcmpInst.OpType.ne, lhs, rhs, (Register) result, int_t));
                    } else if (lType.isArray() && rType.isNull()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.ne, lhs, rhs, (Register) result, lhs.getType()));
                    } else if (lType.isNull() && rType.isArray()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.ne, lhs, rhs, (Register) result, rhs.getType()));
                    } else if (lType.isClass() && rType.isNull()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.ne, lhs, rhs, (Register) result, lhs.getType()));
                    } else if (lType.isNull() && rType.isClass()) {
                        curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                                IcmpInst.OpType.ne, lhs, rhs, (Register) result, rhs.getType()));
                    } else if (lType.isNull() && rType.isNull()) {
                        result = new ConstBool(bool_t, true);
                    }
                    break;
                case "=":
                    result$addr = nodeOperandLValue.get(node.getlExpr());
                    curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, rhs, result$addr));
                    result = rhs;
                    break;
                default:
                    throw new ComplicationError("Unexpected value: " + node.getOp(), node.getPosition());
            }

            nodeOperandResult.put(node, result);
            nodeOperandLValue.put(node, result$addr);
        } else {
            BasicBlock calcBlock = new BasicBlock(curFunction, "shortCalcBlock");
            BasicBlock mergeBlock = new BasicBlock(curFunction, "shortMergeBlock");
            Operand result = new LocalRegister(typeTable.getIRType(node.getType()), "result");
            Operand result$addr = null;
            Operand lhs = null;
            Operand rhs = null;
            switch (node.getOp()) {
                case "&&":
                    node.getlExpr().accept(this);
                    lhs = nodeOperandResult.get(node.getlExpr());

                    if (lhs instanceof ConstBool) {
                        if (!((ConstBool) lhs).getValue()) { // false
                            result = new ConstBool(bool_t, false);
                        } else { // true
                            node.getrExpr().accept(this);
                            rhs = nodeOperandResult.get(node.getrExpr());
                            if (rhs instanceof ConstBool) {
                                result = new ConstBool(bool_t, ((ConstBool) lhs).getValue() && ((ConstBool) rhs).getValue());
                            } else {
                                result = rhs;
                            }
                        }
                    } else {
                        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, lhs, calcBlock, mergeBlock));
                        BasicBlock phi1 = curBasicBlock;

                        curBasicBlock = calcBlock;
                        curFunction.appendBlock(calcBlock);
                        node.getrExpr().accept(this);
                        rhs = nodeOperandResult.get(node.getrExpr());
                        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, mergeBlock, null));
                        BasicBlock phi2 = curBasicBlock;

                        curBasicBlock = mergeBlock;
                        curFunction.appendBlock(mergeBlock);
                        Map<Operand, BasicBlock>branch = new LinkedHashMap<>();
                        branch.put(new ConstBool(bool_t, false), phi1);
                        branch.put(rhs, phi2);
                        curBasicBlock.appendInstBack(new PhiInst(curBasicBlock, branch, (Register) result));
                    }
                    break;
                case "||":
                    node.getlExpr().accept(this);
                    lhs = nodeOperandResult.get(node.getlExpr());

                    if (lhs instanceof ConstBool) {
                        if (((ConstBool) lhs).getValue()) { // true
                            result = new ConstBool(bool_t, true);
                        } else { // false
                            node.getrExpr().accept(this);
                            rhs = nodeOperandResult.get(node.getrExpr());
                            if (rhs instanceof ConstBool) {
                                result = new ConstBool(bool_t, ((ConstBool) lhs).getValue() && ((ConstBool) rhs).getValue());
                            } else {
                                result = rhs;
                            }
                        }
                    } else {
                        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, lhs, mergeBlock, calcBlock));
                        BasicBlock phi1 = curBasicBlock;

                        curBasicBlock = calcBlock;
                        curFunction.appendBlock(calcBlock);
                        node.getrExpr().accept(this);
                        rhs = nodeOperandResult.get(node.getrExpr());
                        curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, mergeBlock, null));
                        BasicBlock phi2 = curBasicBlock;

                        curBasicBlock = mergeBlock;
                        curFunction.appendBlock(mergeBlock);
                        Map<Operand, BasicBlock>branch = new LinkedHashMap<>();
                        branch.put(new ConstBool(bool_t, true), phi1);
                        branch.put(rhs, phi2);
                        curBasicBlock.appendInstBack(new PhiInst(curBasicBlock, branch, (Register) result));
                    }
                    break;
            }
            nodeOperandResult.put(node, result);
            nodeOperandLValue.put(node, result$addr);
        }
    }

    @Override
    public void visit(PrefExprNode node) {
        node.getrExpr().accept(this);
        Operand rhs = nodeOperandResult.get(node.getrExpr());
        Operand rhs$addr = nodeOperandLValue.get(node.getrExpr());
        Operand result = new LocalRegister(typeTable.getIRType(node.getType()), "result");

        switch (node.getOp()) {
            case "++":
                if (rhs$addr == null)
                    throw new ComplicationError("", node.getPosition());
                curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                        BinaryInst.OpType.add, rhs, new ConstInt(int_t, 1), (Register) result));
                curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, result, rhs$addr));
                break;
            case "--":
                if (rhs$addr == null)
                    throw new ComplicationError("", node.getPosition());
                curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                        BinaryInst.OpType.sub, rhs, new ConstInt(int_t, 1), (Register) result));
                curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, result, rhs$addr));
                break;
            case "+":
                result = rhs;
                rhs$addr = null;
                break;
            case "-":
                if (rhs instanceof ConstInt)
                    result = new ConstInt(int_t, -((ConstInt) rhs).getValue());
                else
                    curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                            BinaryInst.OpType.sub, new ConstInt(int_t, 0), rhs, (Register) result));
                rhs$addr = null;
                break;
            case "~":
                if (rhs instanceof ConstInt)
                    result = new ConstInt(int_t, ~((ConstInt) rhs).getValue());
                else
                    curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                            BinaryInst.OpType.xor, rhs, new ConstInt(int_t, -1), (Register) result));
                rhs$addr = null;
                break;
            case "!":
                if (rhs instanceof ConstBool)
                    result = new ConstBool(bool_t, !((ConstBool) rhs).getValue());
                else
                    curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                            BinaryInst.OpType.xor, rhs, new ConstBool(bool_t, true), (Register) result));
                rhs$addr = null;
                break;
            default:
                throw new ComplicationError("Unexpected value: " + node.getOp(), node.getPosition());
        }

        nodeOperandResult.put(node, result);
        nodeOperandLValue.put(node, rhs$addr);

    }

    @Override
    public void visit(SuccExprNode node) {
        node.getlExpr().accept(this);
        Operand lhs = nodeOperandResult.get(node.getlExpr());
        Operand lhs$addr = nodeOperandLValue.get(node.getlExpr());
        Operand result = new LocalRegister(typeTable.getIRType(node.getType()), "result");
        switch (node.getOp()) {
            case "++":
                if (lhs instanceof ConstInt) {
                    result = new ConstInt(int_t, ((ConstInt) lhs).getValue());
                    throw new ComplicationError("must be l value", node.getPosition());
                }
                else {
                    curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                            BinaryInst.OpType.add, lhs, new ConstInt(int_t, 1), (Register) result));
                    curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, result, lhs$addr));
                }

                break;
            case "--":
                if (lhs instanceof ConstInt) {
                    result = new ConstInt(int_t, ((ConstInt) lhs).getValue());
                    throw new ComplicationError("must be l value", node.getPosition());
                }
                else {
                    curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                            BinaryInst.OpType.sub, lhs, new ConstInt(int_t, 1), (Register) result));
                    curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, result, lhs$addr));
                }

                break;
            default:
                throw new ComplicationError("Unexpected value: " + node.getOp(), node.getPosition());
        }

        nodeOperandResult.put(node, lhs);
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(TypeNode node) {

    }

    private Register generateNewArrayExpr(int cur, ArrayList<Operand> arraySizeList, IRType pointerType) {
        assert pointerType instanceof PointerIRT;

        Register mallocPointer = new LocalRegister(pointer_t, "mallocPointer");
        Function function = module.getSystemFunctionMap().get("mx__malloc");
        ArrayList<Operand> operands = new ArrayList<>();
        int baseSize;
        //if (((PointerIRT) pointerType).getBase() instanceof IntegerIRT)
        //    baseSize = ((PointerIRT) pointerType).getBase().getByte();
        //else
        baseSize = pointerType.getByte(); // 4 or 8

        Operand length = arraySizeList.get(cur);

        Register totalByte = new LocalRegister(int_t, "totalByte");
        Register contentSize = new LocalRegister(int_t, "contentSize");

        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                BinaryInst.OpType.mul, length, new ConstInt(int_t, baseSize), contentSize));
        curBasicBlock.appendInstBack(new BinaryInst(curBasicBlock,
                BinaryInst.OpType.add, contentSize, new ConstInt(int_t, 4), totalByte));

        operands.add(totalByte);
        curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, operands, mallocPointer));

        Register mallocInt = new LocalRegister(new PointerIRT(int_t), "mallocInt");
        curBasicBlock.appendInstBack(new BitCastToInst(curBasicBlock,
                mallocPointer, new PointerIRT(int_t), mallocInt));
        curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, length, mallocInt));

        Register arrayBeginInt = new LocalRegister(new PointerIRT(int_t), "arrayBeginInt");
        Register arrayBegin = new LocalRegister(pointerType, "arrayBegin");

        ArrayList<Operand> index = new ArrayList<>();
        index.add(new ConstInt(int_t, 1));
        curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock, arrayBeginInt, index, mallocInt));
        curBasicBlock.appendInstBack(new BitCastToInst(curBasicBlock, arrayBeginInt, pointerType, arrayBegin));

        if (cur != arraySizeList.size() - 1) {
            Register arrayEnd = new LocalRegister(pointerType, "arrayEnd");
            index = new ArrayList<>();
            index.add(length);
            curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock, arrayEnd, index, arrayBegin));

            Register arrayIterator = new LocalRegister(pointerType, "arrayIterator");
            Register arrayIterator$addr = new LocalRegister(new PointerIRT(pointerType), "arrayIterator");
            curFunction.getEntryBlock().appendInstFront(new AllocaInst(curFunction.getEntryBlock(),
                    arrayIterator$addr, pointerType));
            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, arrayBegin, arrayIterator$addr));

            // loop to construct every pointer
            BasicBlock condBlock = new BasicBlock(curFunction, "loopCondBlock");
            BasicBlock bodyBlock = new BasicBlock(curFunction, "loopBodyBlock");
            BasicBlock mergeBlock = new BasicBlock(curFunction, "loopMergeBlock");

            // load arrayIterator, and check arrayIterator != arrayEnd
            curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));
            curFunction.appendBlock(condBlock);
            curBasicBlock = condBlock;

            curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, pointerType,
                    arrayIterator$addr, arrayIterator));
            Register cond = new LocalRegister(bool_t, "cond");
            curBasicBlock.appendInstBack(new IcmpInst(curBasicBlock,
                    IcmpInst.OpType.ne, arrayIterator, arrayEnd, cond, pointerType));
            curBasicBlock.appendInstBack(new BrInst(curBasicBlock, cond, bodyBlock, mergeBlock));

            curFunction.appendBlock(bodyBlock);
            curBasicBlock = bodyBlock;
            Register nextDimArrayBegin = generateNewArrayExpr(
                    cur + 1, arraySizeList, ((PointerIRT) pointerType).getBase());
            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, nextDimArrayBegin, arrayIterator));
            // arrayIteratorNext = arrayIterator + 1
            Register arrayIteratorNext = new LocalRegister(pointerType, "arrayIteratorNext");
            index = new ArrayList<>();
            index.add(new ConstInt(int_t, 1));
            curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock,
                    arrayIteratorNext, index, arrayIterator));
            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, arrayIteratorNext, arrayIterator$addr));
            curBasicBlock.appendInstBack(new BrInst(curBasicBlock, null, condBlock, null));

            curFunction.appendBlock(mergeBlock);
            curBasicBlock = mergeBlock;
        }

        return arrayBegin;
    }

    @Override
    public void visit(NewExprNode node) {
        Register result;
        if (node.getExpressions() != null && node.getExpressions().size() != 0) {
            // array
            Type type = node.getType();

            ArrayList<Operand> arraySizeList = new ArrayList<>();
            node.getExpressions().forEach(exprNode -> {
                exprNode.accept(this);
                arraySizeList.add(nodeOperandResult.get(exprNode));
            });

            result = (Register) generateNewArrayExpr(0, arraySizeList, typeTable.getIRType(type));
        } else {
            // class
            Type classType = node.getType();
            assert classType instanceof ClassType;
            IRType irType = typeTable.getIRType(classType);
            assert irType instanceof PointerIRT;
            IRType csType = ((PointerIRT) irType).getBase();
            assert csType instanceof ClassIRT;
            int size = csType.getByte();

            Function function = module.getSystemFunctionMap().get("mx__malloc");
            ArrayList<Operand> operands = new ArrayList<>();
            operands.add(new ConstInt(int_t, size));

            result = new LocalRegister(irType, "class$addr");
            Register register = new LocalRegister(pointer_t, "space");

            curBasicBlock.appendInstBack(new CallInst(curBasicBlock, function, operands, register));
            curBasicBlock.appendInstBack(new BitCastToInst(curBasicBlock, register, irType, result));

            String constructorName = ((ClassIRT) csType).getName() + "." + ((ClassIRT) csType).getName();
            if (module.getFunctionMap().containsKey(constructorName)) {
                Function constructor = module.getFunctionMap().get(constructorName);
                operands = new ArrayList<>();
                operands.add(result);
                curBasicBlock.appendInstBack(new CallInst(curBasicBlock, constructor, operands, null));
            }
        }
        nodeOperandResult.put(node, result);
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(VarDefNode node) {
        node.getVarDefStmtNode().accept(this);
    }

    @Override
    public void visit(ClassDefNode node) {
        for (DefNode defNode : node.getClassComponenet()) {
            if (defNode instanceof FuncDefNode) {
                defNode.accept(this);
            }

        }
    }

    @Override
    public void visit(FuncExprNode node) {
        if (node.getPointer() instanceof IdentifierExprNode) {
            String name = ((IdentifierExprNode) node.getPointer()).getName();
            FuncSymbol funcSymbol = (FuncSymbol) node.getPointer().getType();
            //System.out.println(funcSymbol);
            Function function;
            ArrayList<Operand> parameters = new ArrayList<>();
            if (funcSymbol.isMethod()) {
                ClassType classType = node.getBelongScope().getClassDefType();
                //System.out.println(classType);
                function = module.getFunctionMap().get(classType.getTypeName() + "." + funcSymbol.getName());
                //System.out.println(classType.getTypeName() + "." + funcSymbol.getName());
                Register address = (Register) curFunction.get("this$addr");
                assert address.getType() instanceof PointerIRT;
                IRType irType = ((PointerIRT) address.getType()).getBase();
                Register thisPtr = new LocalRegister(irType, "this");
                curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, irType, address, thisPtr));
                parameters.add(thisPtr);
            } else {
                if (module.getFunctionMap().containsKey(funcSymbol.getName()))
                    function = module.getFunctionMap().get(funcSymbol.getName());
                else
                    function = module.getSystemFunctionMap().get("mx__" + funcSymbol.getName());
            }
            assert function != null;
            IRType returnType = function.getFuncType().getReturnType();
            Register result = new LocalRegister(returnType, "result");
            node.getArgumentList().forEach(exprNode -> {
                exprNode.accept(this);
                parameters.add(nodeOperandResult.get(exprNode));
            });
            curBasicBlock.appendInstBack(new CallInst(curBasicBlock,
                    function, parameters, result));

            nodeOperandResult.put(node, result);
            nodeOperandLValue.put(node, null);
        } else if (node.getPointer() instanceof MemberExprNode) {
            ((MemberExprNode) node.getPointer()).getPointer().accept(this);
            Operand pointer = nodeOperandResult.get(((MemberExprNode) node.getPointer()).getPointer());
            Type type = ((MemberExprNode) node.getPointer()).getPointer().getType();
            if (type.isArray()) {
                assert ((MemberExprNode) node.getPointer()).getMember().equals("size");
                Register arraySizePtr = new LocalRegister(new PointerIRT(int_t), "arraySizePtr");
                if (pointer.getType().equals(new PointerIRT(int_t))) {
                    Register castPtr = new LocalRegister(new PointerIRT(int_t), "castPtr");
                    curBasicBlock.appendInstBack(new BitCastToInst(curBasicBlock,
                            pointer, new PointerIRT(int_t), castPtr));
                    pointer = castPtr;
                }
                curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock,
                        arraySizePtr, new ConstInt(int_t, -1), pointer));

                Register arraySize = new LocalRegister(int_t, "arraySize");
                curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, int_t, arraySizePtr, arraySize));
                nodeOperandResult.put(node, arraySize);
                nodeOperandLValue.put(node, null);
            } else {
                Function function = null;
                if (type.isString()) {
                    function = module.getSystemFunctionMap().get("mx__string_" + ((MemberExprNode) node.getPointer()).getMember());
                } else {
                    assert type.isClass();
                    function = module.getFunctionMap().get(type.getTypeName() + "." + ((MemberExprNode) node.getPointer()).getMember());
                }
                assert function != null;
                ArrayList<Operand> parameters = new ArrayList<>();
                IRType returnType = function.getFuncType().getReturnType();
                Register result = returnType.equals(void_t) ? null : new LocalRegister(returnType, "result");

                parameters.add(pointer);
                node.getArgumentList().forEach(exprNode -> {
                    exprNode.accept(this);
                    parameters.add(nodeOperandResult.get(exprNode));
                });

                curBasicBlock.appendInstBack(new CallInst(curBasicBlock,
                        function, parameters, result));

                nodeOperandResult.put(node, result);
                nodeOperandLValue.put(node, null);
            }
        }

    }

    @Override
    public void visit(FuncDefNode node) {
        String name;
        if (node.getBelongScope().getClassDefType() != null) {
            ClassType classType = node.getBelongScope().getClassDefType();
            name = classType.getTypeName() + "." + node.getName();
        } else {
            name = node.getName();
        }
        Function function = module.getFunctionMap().get(name);

        curFunction = function;
        curBasicBlock = function.getEntryBlock();

        node.getBody().accept(this);

        if (!node.getFuncSymbol().getType().isVoid()
                && !node.getFuncSymbol().getType().isNull()
                && !node.getFuncSymbol().isReturned()
        ) {
            //System.out.println(curFunction.getName());
            //assert curFunction.getName().equals("main");
            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock,
                    new ConstInt(int_t, 0), curFunction.getReturnValueAddress()));
        }

        curFunction.finish();
        if (curFunction.getName().equals("main")) {
            Function init = module.getFunctionMap().get("mx__init");
            curFunction.getEntryBlock().appendInstFront(new CallInst(
                    curFunction.getEntryBlock(), init, new ArrayList<>(), null
            ));
        }

        curFunction = null;
        curBasicBlock = null;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        Type type = node.getBelongScope().getType(node.getType());
        IRType irType = typeTable.getIRType(type);
        if (node.getBelongScope().getFuncSymbol() != null) {
            LocalRegister address = new LocalRegister(new PointerIRT(irType), node.getName(), false);
            IRInst inst = new AllocaInst(curFunction.getEntryBlock(), address, irType);
            curFunction.getEntryBlock().appendInstFront(inst);
            address.setDefinition(inst);
            Operand value;
            if (node.getExpression() != null) {
                node.getExpression().accept(this);
                value = nodeOperandResult.get(node.getExpression());
            } else
                value = irType.getDefaultValue();

            curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, value, address));

            VarSymbol varSymbol = node.getBelongScope().getVarSymbol(node.getName(), node.getPosition());
            //System.out.println("Def: " + varSymbol);
            assert varSymbol.getAllocAddr() == null;
            varSymbol.setAllocAddr(address);
            //System.out.println("Def: " + varSymbol);
        } else if (node.getBelongScope().getClassDefType() != null) {

        } else {
            GlobalRegister address = new GlobalRegister(new PointerIRT(irType), node.getName(), null);
            Operand value = irType.getDefaultValue();
            if (node.getExpression() != null) {
                node.getExpression().accept(this);
                value = nodeOperandResult.get(node.getExpression());
                if (! (value instanceof Constant)) {
                    curBasicBlock.appendInstBack(new StoreInst(curBasicBlock, value, address));
                    value = irType.getDefaultValue();
                }
            }
            address.setInit(value);
            module.getGlobalVariableMap().put(node.getName(), address);
            VarSymbol varSymbol = node.getBelongScope().getVarSymbol(node.getName(), node.getPosition());
            varSymbol.setAllocAddr(address);;
        }
    }

    @Override
    public void visit(ArrayExprNode node) {
        node.getPointer().accept(this);
        node.getOffset().accept(this);

        IRType irType = typeTable.getIRType(node.getType());
        Operand pointer = nodeOperandResult.get(node.getPointer());
        Register element$addr = new LocalRegister(new PointerIRT(irType), "element$addr");

        curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock,
                element$addr, nodeOperandResult.get(node.getOffset()), pointer));

        Register element = new LocalRegister(irType, "element");

        curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, irType, element$addr, element));

        nodeOperandLValue.put(node, element$addr);
        nodeOperandResult.put(node, element);
    }

    @Override
    public void visit(IdentifierExprNode node) {
        VarSymbol varSymbol = node.getVarSymbol();
        IRType irType = typeTable.getIRType(varSymbol.getType());
        Register variable = new LocalRegister(irType, "variable");
        if (varSymbol.getAllocAddr() != null) {
            curBasicBlock.appendInstBack(new LoadInst(curBasicBlock,
                    irType, varSymbol.getAllocAddr(), variable));
            nodeOperandResult.put(node, variable);
            nodeOperandLValue.put(node, varSymbol.getAllocAddr());
        } else {
            Register this$addr = curFunction.getThisPointer();
            // System.out.println(varSymbol);
            assert this$addr.getType() instanceof PointerIRT;
            IRType type = ((PointerIRT) this$addr.getType()).getBase();
            Register thisPtr = new LocalRegister(type, "this");
            curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, type, this$addr, thisPtr));

            ClassType classType = node.getBelongScope().getClassDefType();

            ArrayList<Operand> index = new ArrayList<>();
            index.add(new ConstInt(int_t, 0));
            index.add(new ConstInt(int_t, classType.getVarMemberIndex(node.getName())));
            Register variable$addr = new LocalRegister(new PointerIRT(irType), "variable$addr");
            curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock, variable$addr, index, thisPtr));
            curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, irType, variable$addr, variable));
            nodeOperandResult.put(node, variable);
            nodeOperandLValue.put(node, variable$addr);
        }
    }

    @Override
    public void visit(LiteralExprNode node) {

    }

    @Override
    public void visit(MemberExprNode node) {
        node.getPointer().accept(this);
        Operand pointer = nodeOperandResult.get(node.getPointer());
        Type pointerType = node.getPointer().getType();

        if (!node.isFunc()) {
            assert pointerType instanceof ClassType;
            VarSymbol varSymbol = ((ClassType) pointerType).getVarSymbol(node.getMember(), node.getPosition());

            IRType irType = typeTable.getIRType(varSymbol.getType());
            Register member = new LocalRegister(irType,
                    pointerType.getTypeName() + "." + node.getMember());
            Register member$addr = new LocalRegister(new PointerIRT(irType),
                    pointerType.getTypeName() + "." + node.getMember() + "$addr");
            ArrayList<Operand> index = new ArrayList<>();

            index.add(new ConstInt(int_t, 0));
            index.add(new ConstInt(int_t, ((ClassType) pointerType).getVarMemberIndex(node.getMember())));

            curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock, member$addr, index, pointer));
            curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, irType, member$addr, member));

            nodeOperandResult.put(node, member);
            nodeOperandLValue.put(node, member$addr);
        }


    }

    @Override
    public void visit(BoolLiteralNode node) {
        nodeOperandResult.put(node, new ConstBool(bool_t, node.isValue()));
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(IntLiteralNode node) {
        nodeOperandResult.put(node, new ConstInt(int_t, node.getValue()));
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(NullLiteralNode node) {
        nodeOperandResult.put(node, new ConstNull());
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(StringLiteralNode node) {
        GlobalRegister str = module.addConstantString(node.getValue());
        ArrayList<Operand> index = new ArrayList<>();
        index.add(new ConstInt(int_t, 0));
        index.add(new ConstInt(int_t, 0));
        Register result = new LocalRegister(string_t, "string");
        curBasicBlock.appendInstBack(new GetElementPtrInst(curBasicBlock, result, index, str));

        nodeOperandResult.put(node, result);
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(ThisLiteralNode node) {
        Register address = (Register) curFunction.get("this$addr");
        assert address.getType() instanceof PointerIRT;
        IRType irType = ((PointerIRT) address.getType()).getBase();
        Register thisPtr = new LocalRegister(irType, "this");

        curBasicBlock.appendInstBack(new LoadInst(curBasicBlock, irType, address, thisPtr));
        curFunction.put(thisPtr.getName(), thisPtr);

        nodeOperandResult.put(node, thisPtr);
        nodeOperandLValue.put(node, null);
    }

    @Override
    public void visit(ProgramNode node) {

        typeTable = new TypeTable(node.getBelongScope().getTypeMap());

        node.getProgramComponent().forEach(classNode->{
            // add method from class
            if (classNode instanceof ClassDefNode) {
                ClassType classType = (ClassType) typeTable
                        .getType(((ClassDefNode) classNode).getName(), classNode.getPosition());
                ((ClassDefNode) classNode).getClassComponenet().forEach(funcNode->{
                    if (funcNode instanceof FuncDefNode) {
                        FuncSymbol funcSymbol = classType
                                .getFuncSymbol(((FuncDefNode) funcNode).getName(), funcNode.getPosition());
                        String funcName = ((ClassDefNode) classNode).getName() + "." + ((FuncDefNode) funcNode).getName();
                        ArrayList<Parameter> parameters = new ArrayList<>();

                        parameters.add(new Parameter(typeTable.getIRType(classType), "this"));

                        for (VarSymbol varSymbol : funcSymbol.getParameter())
                            parameters.add(new Parameter(typeTable.getIRType(varSymbol.getType()), varSymbol.getName()));
                        //System.out.println(funcSymbol);
                        Function function = new Function(this.module, funcName,
                                typeTable.getIRType(funcSymbol.getType()), parameters, false);
                        BasicBlock block = function.getEntryBlock();

                        for (int i = 0; i < parameters.size(); i++) {
                            Parameter parameter = parameters.get(i);
                            Register address = new LocalRegister(
                                    new PointerIRT(parameter.getType()), parameter.getName() + "$addr");
                            block.appendInstBack(new AllocaInst(block, address, parameter.getType()));
                            block.appendInstBack(new StoreInst(block, parameter, address));
                            function.put(address.getName(), address);
                            if (i != 0)
                                funcSymbol.getParameter().get(i - 1).setAllocAddr(address);
                            else
                                function.setThisPointer(address);
                        }
                        this.module.addFunction(function);

                    }
                });
            }
        });

        node.getProgramComponent().forEach(funcNode->{
            if (funcNode instanceof FuncDefNode) {
                FuncSymbol funcSymbol = funcNode.getBelongScope()
                        .getFuncSymbol(((FuncDefNode) funcNode).getName(), funcNode.getPosition());
                ArrayList<Parameter> parameters = new ArrayList<>();
                for (VarSymbol varSymbol : funcSymbol.getParameter())
                    parameters.add(new Parameter(typeTable.getIRType(varSymbol.getType()), varSymbol.getName()));
                Function function = new Function(this.module, ((FuncDefNode) funcNode).getName(),
                        typeTable.getIRType(funcSymbol.getType()), parameters, false);
                BasicBlock block = function.getEntryBlock();
                for (int i = 0; i < parameters.size(); i++) {
                    Parameter parameter = parameters.get(i);
                    Register address = new LocalRegister(new PointerIRT(parameter.getType()), parameter.getName() + "$addr");
                    block.appendInstBack(new AllocaInst(block, address, parameter.getType()));
                    block.appendInstBack(new StoreInst(block, parameter, address));
                    function.put(address.getName(), address);
                    funcSymbol.getParameter().get(i).setAllocAddr(address);
                }
                this.module.addFunction(function);
            }
        });

        Function init = this.module.getFunctionMap().get("mx__init");
        curFunction = init;
        curBasicBlock = curFunction.getEntryBlock();
        node.getProgramComponent().forEach(varNode->{
            if (varNode instanceof VarDefNode)
                varNode.accept(this);
        });
        curFunction.finish();
        curBasicBlock = null;
        curFunction = null;

        node.getProgramComponent().forEach(classNode->{
            if (classNode instanceof ClassDefNode)
                classNode.accept(this);
        });

        node.getProgramComponent().forEach(funcNode->{
            if (funcNode instanceof FuncDefNode)
                funcNode.accept(this);
        });

        module.setClassIRTMap(typeTable.getClassIRTMap());
    }

    @Override
    public void visit(VarDefStmtNodes node) {
        node.getDefNodes().forEach(x->x.accept(this));
    }

    @Override
    public void visit(ListExprNode node) {
        node.getExprNodes().forEach(x->x.accept(this));
        ArrayList<ExprNode> exprNodeArrayList = node.getExprNodes();
        nodeOperandResult.put(node,
                nodeOperandResult.get(exprNodeArrayList.get(exprNodeArrayList.size() - 1)));
    }
}
