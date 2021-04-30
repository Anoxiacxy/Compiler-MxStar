package IR.Operand;

import IR.IRObject;
import IR.Instruction.IRInst;
import IR.TypeSystem.IRType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class Operand extends IRObject {
    private IRType type;

    private Map<IRInst, Integer> def, use;

    public Operand(IRType type) {
        this.type = type;
        def = new LinkedHashMap<>();
        use = new LinkedHashMap<>();
    }

    public void addUse(IRInst inst) {
        if (use.containsKey(inst))
            use.replace(inst, use.get(inst) + 1);
        else
            use.put(inst, 1);
    }

    public void addDef(IRInst inst) {
        if (def.containsKey(inst))
            def.replace(inst, def.get(inst) + 1);
        else
            def.put(inst, 1);
    }

    public void removeUse(IRInst inst) {
        if (use.containsKey(inst)) {
            if (use.get(inst) == 1)
                use.remove(inst);
            else
                use.replace(inst, use.get(inst) - 1);
        }
    }

    public void removeDef(IRInst inst) {
        if (def.containsKey(inst)) {
            if (def.get(inst) == 1)
                def.remove(inst);
            else
                def.replace(inst, def.get(inst) - 1);
        }
    }

    private void replaceDef(IRInst oldInst, IRInst newInst) {
        while (def.containsKey(oldInst)) {
            removeDef(oldInst);
            addUse(newInst);
        }
    }

    private void replaceUse(IRInst oldInst, IRInst newInst) {
        while (use.containsKey(oldInst)) {
            removeUse(oldInst);
            addUse(newInst);
        }
    }

    public IRType getType() {
        return type;
    }

    public Map<IRInst, Integer> getDef() {
        return def;
    }

    public Map<IRInst, Integer> getUse() {
        return use;
    }

    public String getName() { return null; }

    public void setType(IRType type) {
        this.type = type;
    }

    abstract public boolean isConstant();

    @Override
    abstract public String toString();
}
