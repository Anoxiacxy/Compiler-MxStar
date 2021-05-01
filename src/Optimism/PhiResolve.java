package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.BrInst;
import IR.Instruction.IRInst;
import IR.Instruction.MoveInst;
import IR.Instruction.PhiInst;
import IR.Module;
import IR.Operand.LocalRegister;
import IR.Operand.Operand;
import IR.Operand.Register;
import Util.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class PhiResolve extends Pass {
    public PhiResolve(Module module) {
        super(module);
    }

    @Override
    protected void modulePass(Module module) {

    }

    @Override
    protected void functionPass(Function function) {

    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    Map<BasicBlock, Set<MoveInst>> parallelMoves;

    @Override
    public boolean run() {
        parallelMoves = new LinkedHashMap<>();
        module.getFunctionMap().forEach((s, function) -> splitCriticalEdges(function));
        applyParallelMoves();
        return false;
    }

    private void applyParallelMoves() {
        for (BasicBlock block : parallelMoves.keySet()) {
            Set<MoveInst> moveInstSet = parallelMoves.get(block);
            Map<Operand, Integer> outDegree = new HashMap<>();

            for (MoveInst moveInst : moveInstSet)
                if (outDegree.containsKey(moveInst.getSource()))
                    outDegree.replace(moveInst.getSource(), outDegree.get(moveInst.getSource()) + 1);
                else
                    outDegree.put(moveInst.getSource(), 1);

            while (!moveInstSet.isEmpty()) {
                MoveInst moveInst = null;
                for (MoveInst inst : moveInstSet)
                    if (!outDegree.containsKey(inst.getResult())) {
                        moveInst = inst;
                        break;
                    }

                if (moveInst != null) {
                    moveInstSet.remove(moveInst);
                    block.insertInstBefore(block.getInstEnd(), moveInst);
                    if (outDegree.get(moveInst.getSource()) == 1)
                        outDegree.remove(moveInst.getSource());
                    else
                        outDegree.replace(moveInst.getSource(), outDegree.get(moveInst.getSource()) - 1);
                } else {
                    moveInst = moveInstSet.iterator().next();
                    assert moveInst.getSource() instanceof Register;

                    Register temp = new LocalRegister(moveInst.getSource().getType(), moveInst.getSource().getName() + ".temp");
                    block.insertInstBefore(block.getInstEnd(), new MoveInst(block, moveInst.getSource(), temp));

                    if (outDegree.get(moveInst.getSource()) == 1)
                        outDegree.remove(moveInst.getSource());
                    else
                        outDegree.replace(moveInst.getSource(), outDegree.get(moveInst.getSource()) - 1);

                    outDegree.put(temp, 1);

                    moveInst.replaceUse(moveInst.getSource(), temp);
                }


            }
        }
    }

    private void splitCriticalEdges(Function function) {
        ArrayList<BasicBlock> dfsOrder = function.getDfsOrder();
        for (BasicBlock block : dfsOrder)
            parallelMoves.put(block, new LinkedHashSet<>());

        for (BasicBlock block : dfsOrder) {
            if (block.getPredecessors().size() == 0) continue;

            ArrayList<PhiInst> phiInstArrayList = new ArrayList<>();
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof PhiInst)
                    phiInstArrayList.add((PhiInst) inst);
            }

            if (phiInstArrayList.size() == 0) continue;

            if (block.getPredecessors().size() == 1) {
                BasicBlock preBlock = block.getPredecessors().get(0);
                for (PhiInst phiInst : phiInstArrayList) {
                    assert phiInst.getBranch().size() == 1;
                    // TODO: 2021/4/4  
                    // phiInst.setResult((Register) phiInst.getBranch().get(0).a);
                    parallelMoves.get(preBlock).add(new MoveInst(preBlock,
                            phiInst.getBranch().get(0).a, phiInst.getResult()));
                    //block.insertInstBefore(phiInst, ));
                    phiInst.removeFromBlock();
                }
                continue;
            }

            //System.out.println(function.toString() + " " + block.toString() + " " + block.getPredecessors().size());

            //System.out.println(block.getPredecessors().get(0));
            //System.out.println(block.getPredecessors().get(1));

            ArrayList<BasicBlock> predecessors = new ArrayList<>(block.getPredecessors());

            for (BasicBlock pre : predecessors) {
            //for (int i = 0; i < block.getPredecessors().size(); i++) {
                //BasicBlock pre = block.getPredecessors().get(i);
                if (pre.getSuccessors().size() > 1) {
                    BasicBlock preNext = new BasicBlock(pre.getFunction(), "extra");
                    parallelMoves.put(preNext, new LinkedHashSet<>());
                    preNext.appendInstBack(new BrInst(preNext, null, block, null));

                    assert pre.getInstEnd() instanceof BrInst;
                    if (((BrInst) pre.getInstEnd()).getThemBlock() == block)
                        ((BrInst) pre.getInstEnd()).setThemBlock(preNext);
                    if (((BrInst) pre.getInstEnd()).getElseBlock() == block)
                        ((BrInst) pre.getInstEnd()).setElseBlock(preNext);

                    pre.getSuccessors().add(preNext);
                    pre.getSuccessors().remove(block);
                    preNext.getPredecessors().add(pre);
                    preNext.getSuccessors().add(block);
                    block.getPredecessors().remove(pre);
                    block.getPredecessors().add(preNext);
                    preNext.getSuccessors().remove(block);
                    preNext.getSuccessors().add(preNext);

                    pre.getFunction().insertBlockAfter(pre, preNext);

                    for (PhiInst phiInst : phiInstArrayList) {
                        for (Pair<Operand, BasicBlock> pair : phiInst.getBranch()) {
                            if (pair.b == pre) {
                                parallelMoves.get(preNext).add(new MoveInst(preNext, pair.a, phiInst.getResult()));
                            }
                        }
                    }
                } else {
                    for (PhiInst phiInst : phiInstArrayList) {
                        for (Pair<Operand, BasicBlock> pair : phiInst.getBranch()) {
                            if (pair.b == pre) {
                                parallelMoves.get(pre).add(new MoveInst(pre, pair.a, phiInst.getResult()));
                            }
                        }
                    }
                }
            }
            for (PhiInst phiInst : phiInstArrayList)
                phiInst.removeFromBlock();
        }



    }
}
