package Optimism;

import IR.BasicBlock;
import IR.Function;
import IR.Module;
import Util.Pass;

import java.util.*;

public class DominatorTree extends Pass {
    private Function function;
    private Map<BasicBlock, BasicBlock> semi;
    private Map<BasicBlock, BasicBlock> idom;
    private Map<BasicBlock, Set<BasicBlock>> tree;
    private Map<BasicBlock, Set<BasicBlock>> domFrontier;

    private Map<BasicBlock, Integer> dfn;
    private Map<BasicBlock, BasicBlock> father;
    private ArrayList<BasicBlock> order;

    private Map<BasicBlock, BasicBlock> alias;
    private Map<BasicBlock, BasicBlock> mn;

    public DominatorTree(Module module) {
        super(module);
        this.function = null;
    }

    public DominatorTree(Function function) {
        super(null);
        this.function = function;
    }

    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values()) {
            this.function = function;
            functionPass(function);
        }
    }


    private void tarjan(BasicBlock u) {
        dfn.put(u, order.size());
        order.add(u);

        for (BasicBlock v : u.getSuccessors())
            if (!dfn.containsKey(v)) {
                father.put(v, u);
                tarjan(v);
            }
    }

    BasicBlock aliasQuery(BasicBlock u) {
        if (alias.get(u) == u)
            return u;
        BasicBlock result = aliasQuery(alias.get(u));
        if (dfn.get(semi.get(mn.get(u))) > dfn.get(semi.get(mn.get(alias.get(u)))))
            mn.replace(u, mn.get(alias.get(u)));
        alias.replace(u, result);
        return result;
    }

    private void lengauerTarjan(BasicBlock root) {
        tarjan(root);

        for (int i = order.size() - 1; i >= 1; i--) {
            BasicBlock u = order.get(i);
            for (BasicBlock v : u.getPredecessors()) {
                assert dfn.containsKey(v);
                aliasQuery(v);
                if (dfn.get(semi.get(u)) > dfn.get(semi.get(mn.get(v))))
                    semi.replace(u, mn.get(v));
            }
            alias.replace(u, father.get(u));
            tree.get(semi.get(u)).add(u);
            u = father.get(u);
            for (BasicBlock v : tree.get(u)) {
                aliasQuery(v);
                if (u == semi.get(mn.get(v)))
                    idom.replace(v, u);
                else
                    idom.replace(v, mn.get(v));
            }
            tree.get(u).clear();
        }

        for (int i = 1; i < order.size(); i++) {
            BasicBlock u = order.get(i);
            if (idom.get(u) != semi.get(u))
                idom.replace(u, idom.get(idom.get(u)));
        }

        for (BasicBlock u : order) {
            tree.get(u).clear();
            tree.get(idom.get(u)).add(u);
        }

        for (BasicBlock b : order) {
            if (b.getPredecessors().size() >= 2) {
                for (BasicBlock p : b.getPredecessors()) {
                    BasicBlock runner = p;
                    while (runner != idom.get(b)) {
                        domFrontier.get(runner).add(b);
                        runner = idom.get(runner);
                    }
                }
            }
        }
    }

    @Override
    protected void functionPass(Function function) {
        dfn = new HashMap<>();
        order = new ArrayList<>();
        alias = new HashMap<>();
        mn = new HashMap<>();
        father = new HashMap<>();

        ArrayList<BasicBlock>blocks = function.getDfsOrder();
        for (BasicBlock block : blocks) {
            semi.put(block, block);
            idom.put(block, null);
            tree.put(block, new HashSet<>());
            alias.put(block, block);
            mn.put(block, block);
            domFrontier.put(block, new HashSet<>());
        }

        lengauerTarjan(function.getEntryBlock());
    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        semi = new HashMap<>();
        idom = new HashMap<>();
        tree = new HashMap<>();
        domFrontier = new HashMap<>();

        if (this.function == null)
            modulePass(this.module);
        else
            functionPass(this.function);
        return false;
    }
}
