package Backend;

import IR.BasicBlock;
import IR.Function;
import IR.IRVisitor;
import IR.Instruction.BrInst;
import IR.Instruction.IRInst;
import IR.Instruction.MoveInst;
import IR.Instruction.PhiInst;
import IR.Module;
import IR.Operand.Operand;
import IR.Operand.Register;
import Optimism.Pass;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class PhiResolve extends Pass {
    public PhiResolve(Module module) {
        super(module);
    }

    @Override
    public boolean run() {
        module.getFunctionMap().forEach((s, function) -> {
            splitCriticalEdges(function);
        });
        return false;
    }

    public void splitCriticalEdges(Function function) {
        ArrayList<BasicBlock> dfsOrder = function.getDfsOrder();
        for (BasicBlock block : dfsOrder) {
            if (block.getPredecessors().size() == 0) continue;

            ArrayList<PhiInst> phiInstArrayList = new ArrayList<>();
            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof PhiInst)
                    phiInstArrayList.add((PhiInst) inst);
            }

            if (phiInstArrayList.size() == 0) continue;

            if (block.getPredecessors().size() == 1) {
                for (PhiInst phiInst : phiInstArrayList) {
                    assert phiInst.getBranch().size() == 1;
                    // TODO: 2021/4/4  
                    // phiInst.setResult((Register) phiInst.getBranch().get(0).a);
                    block.insertInstBefore(phiInst, new MoveInst(block,
                            phiInst.getBranch().get(0).a, phiInst.getResult()));
                    phiInst.removeFromBasicBlock();
                }
                continue;
            }

            for (BasicBlock pre : block.getPredecessors()) {
                if (pre.getSuccessors().size() > 1) {
                    BasicBlock preNext = new BasicBlock(pre.getFunction(), "extra");
                    preNext.appendInstBack(new BrInst(preNext, null, block, null));

                    assert pre.getInstEnd() instanceof BrInst;
                    if (((BrInst) pre.getInstEnd()).getThemBlock() == block)
                        ((BrInst) pre.getInstEnd()).setThemBlock(preNext);
                    if (((BrInst) pre.getInstEnd()).getElseBlock() == block)
                        ((BrInst) pre.getInstEnd()).setElseBlock(preNext);

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
                                preNext.insertInstBefore(preNext.getInstEnd(), new MoveInst(preNext,
                                        pair.a, phiInst.getResult()));
                            }
                        }
                    }
                } else {
                    for (PhiInst phiInst : phiInstArrayList) {
                        for (Pair<Operand, BasicBlock> pair : phiInst.getBranch()) {
                            if (pair.b == pre) {
                                pre.insertInstBefore(pre.getInstEnd(), new MoveInst(pre,
                                        pair.a, phiInst.getResult()));
                            }
                        }
                    }
                }
            }
            for (PhiInst phiInst : phiInstArrayList)
                phiInst.removeFromBasicBlock();
        }
    }
}
