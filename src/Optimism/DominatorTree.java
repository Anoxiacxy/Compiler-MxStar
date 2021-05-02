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

    private Map<BasicBlock, Set<BasicBlock>> postDomFrontier;
    private Map<BasicBlock, BasicBlock> postIdom;

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

    public Set<BasicBlock> getDomFrontier(BasicBlock block) {
        return domFrontier.get(block);
    }
    public BasicBlock getIDom(BasicBlock block) { return idom.get(block); }

    public Set<BasicBlock> getPostDomFrontier(BasicBlock block) {
        return postDomFrontier.get(block);
    }
    public BasicBlock getPostIDom(BasicBlock block) { return postIdom.get(block); }

    @Override
    protected void modulePass(Module module) {
        for (Function function : module.getFunctionMap().values()) {
            this.function = function;
            functionPass(function);
        }
    }

    public BasicBlock lca(BasicBlock u, BasicBlock v) {
        return null;
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

    private void postTarjan(BasicBlock u) {
        dfn.put(u, order.size());
        order.add(u);

        for (BasicBlock v : u.getPredecessors())
            if (!dfn.containsKey(v)) {
                father.put(v, u);
                postTarjan(v);
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
                    semi.replace(u, semi.get(mn.get(v)));
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

    private void postLengauerTarjan(BasicBlock root) {
        postTarjan(root);

        for (int i = order.size() - 1; i >= 1; i--) {
            BasicBlock u = order.get(i);
            for (BasicBlock v : u.getSuccessors()) {
                assert dfn.containsKey(v);
                aliasQuery(v);
                if (dfn.get(semi.get(u)) > dfn.get(semi.get(mn.get(v))))
                    semi.replace(u, semi.get(mn.get(v)));
            }
            alias.replace(u, father.get(u));
            tree.get(semi.get(u)).add(u);
            u = father.get(u);
            for (BasicBlock v : tree.get(u)) {
                aliasQuery(v);
                if (u == semi.get(mn.get(v)))
                    postIdom.replace(v, u);
                else
                    postIdom.replace(v, mn.get(v));
            }
            tree.get(u).clear();
        }

        for (int i = 1; i < order.size(); i++) {
            BasicBlock u = order.get(i);
            if (postIdom.get(u) != semi.get(u))
                postIdom.replace(u, postIdom.get(postIdom.get(u)));
        }

        for (BasicBlock b : order) {
            if (b.getSuccessors().size() >= 2) {
                for (BasicBlock p : b.getSuccessors()) {
                    BasicBlock runner = p;
                    while (runner != postIdom.get(b)) {
                        postDomFrontier.get(runner).add(b);
                        runner = postIdom.get(runner);
                    }
                }
            }
        }
    }

    @Override
    protected void functionPass(Function function) {
        dfn = new LinkedHashMap<>();
        order = new ArrayList<>();
        alias = new LinkedHashMap<>();
        mn = new LinkedHashMap<>();
        father = new LinkedHashMap<>();

        ArrayList<BasicBlock>blocks = function.getDfsOrder();
        for (BasicBlock block : blocks) {
            semi.put(block, block);
            idom.put(block, null);
            tree.put(block, new LinkedHashSet<>());
            alias.put(block, block);
            mn.put(block, block);
            domFrontier.put(block, new LinkedHashSet<>());
        }

        lengauerTarjan(function.getEntryBlock());


        dfn = new LinkedHashMap<>();
        order = new ArrayList<>();
        alias = new LinkedHashMap<>();
        mn = new LinkedHashMap<>();
        father = new LinkedHashMap<>();

        for (BasicBlock block : blocks) {
            semi.put(block, block);
            tree.put(block, new LinkedHashSet<>());
            alias.put(block, block);
            mn.put(block, block);
            postIdom.put(block, null);
            postDomFrontier.put(block, new LinkedHashSet<>());
        }

        postLengauerTarjan(function.getExitBlock());
    }

    @Override
    protected void blockPass(BasicBlock block) {

    }

    @Override
    public boolean run() {
        semi = new LinkedHashMap<>();
        idom = new LinkedHashMap<>();
        postIdom = new LinkedHashMap<>();
        tree = new LinkedHashMap<>();
        domFrontier = new LinkedHashMap<>();
        postDomFrontier = new LinkedHashMap<>();

        if (this.function == null)
            modulePass(this.module);
        else
            functionPass(this.function);
        return false;
    }
}
