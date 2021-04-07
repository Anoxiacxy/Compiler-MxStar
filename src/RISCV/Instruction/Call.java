package RISCV.Instruction;

import RISCV.ASMBlock;
import RISCV.ASMFunction;
import RISCV.ASMInst;
import RISCV.Operand.Register.PhysicalRegister;

public class Call extends ASMInst {
    private ASMFunction asmFunction;

    public Call(ASMBlock asmBlock, ASMFunction asmFunction) {
        super(asmBlock);
        this.asmFunction = asmFunction;

        for (int i = 0; i < PhysicalRegister.phyRegName.size(); i++) {
            if (PhysicalRegister.saveStatus.get(i) == PhysicalRegister.RegType.caller) {
                PhysicalRegister.getv(i).addDef(this);
                this.addDef(PhysicalRegister.getVirtualRegister(i));
            }
        }
    }

    @Override
    public String emitCode() {
        return "call\t" + asmFunction.emitCode();
    }


}

