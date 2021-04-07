package RISCV;

import IR.Instruction.IRInst;
import IR.TypeSystem.IntegerIRT;
import RISCV.Operand.Register.VirtualRegister;

import java.util.LinkedHashMap;

abstract public class ASMInst extends ASMObject {
    private LinkedHashMap<VirtualRegister, Integer> def;
    private LinkedHashMap<VirtualRegister, Integer> use;
    private ASMBlock asmBlock;
    private ASMInst nextInst, prevInst;


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
        int cntOld = def.containsKey(oldRegister) ? 0 : def.get(oldRegister);
        int cntNew = def.containsKey(newRegister) ? 0 : def.get(newRegister);
        assert cntNew == 0;
        def.put(newRegister, cntOld);
        def.remove(oldRegister);
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
        int cntOld = use.containsKey(oldRegister) ? 0 : use.get(oldRegister);
        int cntNew = use.containsKey(newRegister) ? 0 : use.get(newRegister);
        assert cntNew == 0;
        use.put(newRegister, cntOld);
        use.remove(oldRegister);
    }
}
