package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.*;
import Util.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.rmi.MarshalledObject;
import java.util.*;

import static IR.Module.bool_t;
import static IR.Module.int_t;

public class SparseConditionalConstantPropagation extends Pass {
    public SparseConditionalConstantPropagation(Module module) {
        super(module);
    }

    @Override
    protected void modulePass(Module module) {
        boolean totalChanged = false;
        for (Function function : module.getFunctionMap().values()) {
            changed = false;
            functionPass(function);
            totalChanged |= changed;
        }
        changed = totalChanged;
    }

    Set<BasicBlock> visitedBlocks;

    @Override
    protected void functionPass(Function function) {
        visitedBlocks = new LinkedHashSet<>();
        boolean totalChanged = false;
        do {
            changed = false;
            blockPass(function.getEntryBlock());
            totalChanged |= changed;
        } while (changed);
        changed = totalChanged;
    }

    @Override
    protected void blockPass(BasicBlock block) {
        visitedBlocks.add(block);
        for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
            if (inst instanceof PhiInst) {

                boolean same = true;
                boolean allConstInt = true;
                boolean allConstBool = true;

                Operand firstOperand = null;

                for (Pair<Operand, BasicBlock> blockPair : ((PhiInst) inst).getBranch()) {
                    allConstBool &= blockPair.a instanceof ConstBool;
                    allConstInt &= blockPair.a instanceof ConstInt;
                    if (!allConstBool && !allConstInt) break;
                    if (firstOperand == null) {
                        firstOperand = blockPair.a;
                    } else {
                        if (allConstBool)
                            same &= ((ConstBool) firstOperand).getValue() == ((ConstBool) blockPair.a).getValue();
                        else
                            same &= ((ConstInt) firstOperand).getValue() == ((ConstInt) blockPair.a).getValue();
                    }
                }
                if ((allConstInt || allConstBool) && same) {
                    ((PhiInst) inst).getResult().replaceAllUse(firstOperand);
                    inst.removeFromBlock();
                    changed = true;
                }
            }
            else if (inst instanceof BrInst) {

                if (((BrInst) inst).getCond() != null && ((BrInst) inst).getCond() instanceof ConstBool) {
                    assert ((BrInst) inst).getThemBlock() != null;
                    assert ((BrInst) inst).getElseBlock() != null;
                    BasicBlock target = ((BrInst) inst).getThemBlock();
                    if (!((ConstBool) ((BrInst) inst).getCond()).getValue())
                        target = ((BrInst) inst).getElseBlock();
                    block.appendInstBack(new BrInst(block, null, target, null));

                    BasicBlock succ = ((BrInst) inst).getThemBlock();
                    if (target == ((BrInst) inst).getThemBlock())
                        succ = ((BrInst) inst).getElseBlock();

                    for (IRInst irInst = succ.getInstBegin(); irInst != null; irInst = irInst.getNextInst()) {
                        if (irInst instanceof PhiInst)
                            ((PhiInst) irInst).removeBranch(block);
                    }

                    inst.removeFromBlock();

                    changed = true;

                }

            }
            else if (inst instanceof BinaryInst) {
                Operand cLhs = ((BinaryInst) inst).getLhs();
                Operand cRhs = ((BinaryInst) inst).getRhs();
                if (cLhs instanceof ConstInt && cRhs instanceof ConstInt) {
                    int result = 0;
                    boolean removable = true;
                    switch (((BinaryInst) inst).getOpType()) {
                        case or -> result = (int) (((ConstInt) cLhs).getValue() | ((ConstInt) cRhs).getValue());
                        case and -> result = (int) (((ConstInt) cLhs).getValue() & ((ConstInt) cRhs).getValue());
                        case xor -> result = (int) (((ConstInt) cLhs).getValue() ^ ((ConstInt) cRhs).getValue());
                        case add -> result = (int) (((ConstInt) cLhs).getValue() + ((ConstInt) cRhs).getValue());
                        case sub -> result = (int) (((ConstInt) cLhs).getValue() - ((ConstInt) cRhs).getValue());
                        case mul -> result = (int) (((ConstInt) cLhs).getValue() * ((ConstInt) cRhs).getValue());
                        case sdiv -> {
                            if (((ConstInt) cRhs).getValue() != 0)
                                result = (int) (((ConstInt) cLhs).getValue() / ((ConstInt) cRhs).getValue());
                            else
                                removable = false;
                        }
                        case srem -> {
                            if (((ConstInt) cRhs).getValue() != 0)
                                result = (int) (((ConstInt) cLhs).getValue() % ((ConstInt) cRhs).getValue());
                            else
                                removable = false;
                        }
                        case shl -> result = (int) (((ConstInt) cLhs).getValue() << ((ConstInt) cRhs).getValue());
                        case ashr -> result = (int) (((ConstInt) cLhs).getValue() >> ((ConstInt) cRhs).getValue());
                    }
                    changed |= removable;
                    if (removable) {
                        ConstInt value = new ConstInt(int_t, result);
                        ((BinaryInst) inst).getResult().replaceAllUse(value);
                        inst.removeFromBlock();
                    }
                }
                else if (cLhs instanceof ConstBool && cRhs instanceof ConstBool) {
                    boolean result = false;
                    boolean removable = false;
                    switch (((BinaryInst) inst).getOpType()) {
                        case and -> {
                            removable = true;
                            result = ((ConstBool) cLhs).getValue() && ((ConstBool) cRhs).getValue();
                        }
                        case xor -> {
                            removable = true;
                            result = ((ConstBool) cLhs).getValue() ^ ((ConstBool) cRhs).getValue();
                        }
                        case or -> {
                            removable = true;
                            result = ((ConstBool) cLhs).getValue() || ((ConstBool) cRhs).getValue();
                        }
                    }
                    changed |= removable;
                    if (removable) {
                        ConstBool value = new ConstBool(bool_t, result);
                        ((BinaryInst) inst).getResult().replaceAllUse(value);
                        inst.removeFromBlock();
                    }
                }
            }
            else if (inst instanceof IcmpInst) {
                Operand cLhs = ((IcmpInst) inst).getLhs();
                Operand cRhs = ((IcmpInst) inst).getRhs();
                if (cLhs instanceof ConstInt && cRhs instanceof ConstInt) {
                    boolean result = false;
                    switch (((IcmpInst) inst).getOpType()) {
                        case eq -> result = ((ConstInt) cLhs).getValue() == ((ConstInt) cRhs).getValue();
                        case ne -> result = ((ConstInt) cLhs).getValue() != ((ConstInt) cRhs).getValue();
                        case sgt -> result = ((ConstInt) cLhs).getValue() > ((ConstInt) cRhs).getValue();
                        case sge -> result = ((ConstInt) cLhs).getValue() >= ((ConstInt) cRhs).getValue();
                        case slt -> result = ((ConstInt) cLhs).getValue() < ((ConstInt) cRhs).getValue();
                        case sle -> result = ((ConstInt) cLhs).getValue() <= ((ConstInt) cRhs).getValue();
                    }
                    changed = true;
                    ConstBool value = new ConstBool(bool_t, result);
                    ((IcmpInst) inst).getResult().replaceAllUse(value);
                    inst.removeFromBlock();
                }
                else if (cLhs instanceof ConstBool && cRhs instanceof ConstBool) {
                    boolean result = false;
                    boolean removable = false;
                    switch (((IcmpInst) inst).getOpType()) {
                        case eq -> {
                            removable = true;
                            result = ((ConstBool) cLhs).getValue() == ((ConstBool) cRhs).getValue();
                        }
                        case ne -> {
                            removable = true;
                            result = ((ConstBool) cLhs).getValue() != ((ConstBool) cRhs).getValue();
                        }
                    }
                    changed |= removable;
                    if (removable) {
                        ConstBool value = new ConstBool(bool_t, result);
                        ((IcmpInst) inst).getResult().replaceAllUse(value);
                        inst.removeFromBlock();
                    }
                }
                else if (cLhs instanceof ConstNull && cRhs instanceof ConstNull) {
                    boolean result = false;
                    boolean removable = false;
                    switch (((IcmpInst) inst).getOpType()) {
                        case eq -> {
                            removable = true;
                            result = true;
                        }
                        case ne -> {
                            removable = true;
                            result = false;
                        }
                    }
                    changed |= removable;
                    if (removable) {
                        ConstBool value = new ConstBool(bool_t, result);
                        ((IcmpInst) inst).getResult().replaceAllUse(value);
                        inst.removeFromBlock();
                    }
                }
            }
        }

        block.calcSuccessors();
        for (BasicBlock succ : block.getSuccessors())
            if (!visitedBlocks.contains(succ)) blockPass(succ);
    }

    @Override
    public boolean run() {
        modulePass(module);
        return changed;
    }
}
