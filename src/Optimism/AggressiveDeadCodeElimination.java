package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Instruction.IRInst;
import IR.Module;
import IR.Operand.Operand;
import RISCV.Instruction.Li;
import Util.Pass;

import java.util.*;

public class AggressiveDeadCodeElimination extends Pass {
    Map<BasicBlock, Set<Operand>> liveIn, liveOut;
    public AggressiveDeadCodeElimination(Module module) {
        super(module);
    }

    private void livenessAnalysis(Function function) {
        liveIn = new LinkedHashMap<>();
        liveOut = new LinkedHashMap<>();
        Map<BasicBlock, Set<Operand>> def = new LinkedHashMap<>();
        Map<BasicBlock, Set<Operand>> use = new LinkedHashMap<>();
        Map<BasicBlock, Integer> liveInSize = new LinkedHashMap<>();
        Map<BasicBlock, Integer> liveOutSize = new LinkedHashMap<>();

        ArrayList<BasicBlock> blocks = function.getDfsOrder();
        for (BasicBlock block : blocks) {
            Set<Operand> curDef = new LinkedHashSet<>();
            Set<Operand> curUse = new LinkedHashSet<>();

            for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                for (Operand operand : inst.getUse().keySet())
                    if (!curDef.contains(operand))
                        curUse.add(operand);
                curDef.addAll(inst.getDef().keySet());
            }

            def.put(block, curDef);
            use.put(block, curUse);
        }

        for (BasicBlock block : blocks) {
            liveOut.put(block, new LinkedHashSet<>());
            liveIn.put(block, new LinkedHashSet<>());
            liveOutSize.put(block, 0);
            liveInSize.put(block, 0);
        }

        Collections.reverse(blocks);

        boolean changed;
        do {
            for (BasicBlock block : blocks) {
                Set<Operand> curOut = new LinkedHashSet<>();
                for (BasicBlock succ : block.getSuccessors())
                    curOut.addAll(liveIn.get(succ));
                liveOut.replace(block, curOut);

                Set<Operand> curIn = new LinkedHashSet<>(curOut);
                curIn.removeAll(def.get(block));
                curIn.addAll(use.get(block));
                liveIn.replace(block, curIn);
            }
            changed = false;
            for (BasicBlock block : blocks) {
                if (liveOutSize.get(block) != liveOut.get(block).size())
                    changed = true;
                liveOutSize.replace(block, liveOut.get(block).size());

                if (liveInSize.get(block) != liveIn.get(block).size())
                    changed = true;
                liveInSize.replace(block, liveIn.get(block).size());
            }

        } while (changed);
    }

    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values())
            functionPass(function);
    }

    @Override
    protected void functionPass(Function function) {
        livenessAnalysis(function);

    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        modulePass(module);
        return false;
    }
}
