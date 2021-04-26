package RISCV;

import IR.Instruction.IRInst;
import IR.TypeSystem.IntegerIRT;
import RISCV.Operand.Register.VirtualRegister;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class ASMInst extends ASMObject {
    private Map<VirtualRegister, Integer> def;
    private Map<VirtualRegister, Integer> use;
    private ASMBlock asmBlock;
    private ASMInst nextInst, prevInst;

    public Map<VirtualRegister, Integer> getDef() {
        return def;
    }

    public void setDef(Map<VirtualRegister, Integer> def) {
        this.def = def;
    }

    public Map<VirtualRegister, Integer> getUse() {
        return use;
    }

    public void setUse(Map<VirtualRegister, Integer> use) {
        this.use = use;
    }

    public ASMBlock getAsmBlock() {
        return asmBlock;
    }

    public void setAsmBlock(ASMBlock asmBlock) {
        this.asmBlock = asmBlock;
    }

    public ASMInst getNextInst() {
        return nextInst;
    }

    public void setNextInst(ASMInst nextInst) {
        this.nextInst = nextInst;
    }

    public ASMInst getPrevInst() {
        return prevInst;
    }

    public void setPrevInst(ASMInst prevInst) {
        this.prevInst = prevInst;
    }

    public ASMInst(ASMBlock asmBlock) {
        this.asmBlock = asmBlock;

        prevInst = null;
        nextInst = null;
        def = new LinkedHashMap<>();
        use = new LinkedHashMap<>();

    }

    abstract public String emitCode();

    public void addDef(VirtualRegister register) {
        if (def.containsKey(register))
            def.replace(register, def.get(register) + 1);
        else
            def.put(register, 1);
    }

    public void removeDef(VirtualRegister register) {
        if (def.get(register) != 1)
            def.replace(register, def.get(register) - 1);
        else
            def.remove(register);
    }

    public void replaceDef(VirtualRegister oldRegister, VirtualRegister newRegister) {
        int cntOld = def.getOrDefault(oldRegister, 0);
        int cntNew = def.getOrDefault(newRegister, 0);
        assert cntNew == 0;
        def.put(newRegister, cntOld);
        for (int i = 0; i < cntOld; i++)
            newRegister.addDef(this);
        def.remove(oldRegister);
        for (int i = 0; i < cntOld; i++)
            oldRegister.removeDef(this);
    }

    public void addUse(VirtualRegister register) {
        if (use.containsKey(register))
            use.replace(register, use.get(register) + 1);
        else
            use.put(register, 1);
    }

    public void removeUse(VirtualRegister register) {
        if (use.get(register) != 1)
            use.replace(register, use.get(register) - 1);
        else
            use.remove(register);
    }

    public void replaceUse(VirtualRegister oldRegister, VirtualRegister newRegister) {
        int cntOld = use.getOrDefault(oldRegister, 0);
        int cntNew = use.getOrDefault(newRegister, 0);
        assert cntNew == 0;
        use.put(newRegister, cntOld);
        for (int i = 0; i < cntOld; i++)
            newRegister.addUse(this);
        use.remove(oldRegister);
        for (int i = 0; i < cntOld; i++)
            oldRegister.removeUse(this);
    }

    public ArrayList<VirtualRegister> getVirtualRegister() {
        return new ArrayList<>();
    }



}
