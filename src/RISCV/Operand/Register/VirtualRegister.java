package RISCV.Operand.Register;

import RISCV.ASMInst;

import java.util.HashMap;
import java.util.Map;

public class VirtualRegister extends Register {
    private String name;
    private Map<ASMInst, Integer> use, def;
    private PhysicalRegister physicalRegister;

    public VirtualRegister(String name) {
        this.name = name;

        use = new HashMap<>();
        def = new HashMap<>();

    }

    public VirtualRegister(String name, PhysicalRegister register) {
        this.name = name;

        use = new HashMap<>();
        def = new HashMap<>();

        this.physicalRegister = register;
    }

    public String emitCode() {
        if (physicalRegister == null)
            return ("[v]") + name;
        return physicalRegister.emitCode();
    }


    public void addDef(ASMInst asmInst) {
        if (def.containsKey(asmInst))
            def.replace(asmInst, def.get(asmInst) + 1);
        else
            def.put(asmInst, 1);
    }

    public void removeDef(ASMInst register) {
        if (def.get(register) != 1)
            def.replace(register, def.get(register) - 1);
        else
            def.remove(register);
    }

    public void replaceDef(ASMInst asmInst, ASMInst asmInst1) {
        int cntOld = def.containsKey(asmInst) ? 0 : def.get(asmInst);
        int cntNew = def.containsKey(asmInst1) ? 0 : def.get(asmInst1);
        assert cntNew == 0;
        def.put(asmInst1, cntOld);
        def.remove(asmInst);
    }

    public void addUse(ASMInst asmInst) {
        if (use.containsKey(asmInst))
            use.replace(asmInst, use.get(asmInst) + 1);
        else
            use.put(asmInst, 1);
    }

    public void removeUse(ASMInst asmInst) {
        if (use.get(asmInst) != 1)
            use.replace(asmInst, use.get(asmInst) - 1);
        else
            use.remove(asmInst);
    }

    public void replaceUse(ASMInst asmInst, ASMInst asmInst1) {
        int cntOld = use.containsKey(asmInst) ? 0 : use.get(asmInst);
        int cntNew = use.containsKey(asmInst1) ? 0 : use.get(asmInst1);
        assert cntNew == 0;
        use.put(asmInst1, cntOld);
        use.remove(asmInst);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<ASMInst, Integer> getUse() {
        return use;
    }

    public void setUse(Map<ASMInst, Integer> use) {
        this.use = use;
    }

    public Map<ASMInst, Integer> getDef() {
        return def;
    }

    public void setDef(Map<ASMInst, Integer> def) {
        this.def = def;
    }

    public PhysicalRegister getPhysicalRegister() {
        return physicalRegister;
    }

    public void setPhysicalRegister(PhysicalRegister physicalRegister) {
        this.physicalRegister = physicalRegister;
    }
}
