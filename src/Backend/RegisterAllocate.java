package Backend;

import IR.Module;
import RISCV.*;
import RISCV.Instruction.Add;
import RISCV.Instruction.Addi;
import RISCV.Instruction.Lw;
import RISCV.Instruction.Sw;
import RISCV.Operand.Address;
import RISCV.Operand.Immediate.IntImm;
import RISCV.Operand.Register.PhysicalRegister;
import RISCV.Operand.Register.VirtualRegister;
import Util.Pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RegisterAllocate {
    private ASMModule module;
    public RegisterAllocate(ASMModule module) {
        this.module = module;
    }

    // TODO: 2021/4/7 stackFrame in every function

    public void piss() {
        module.getFunctionMap().values().forEach(asmFunction -> {
            HashMap<VirtualRegister, Address> addressHashMap = new HashMap<>();
            for (ASMBlock block = asmFunction.getEntryBlock(); block != null;  block = block.getNextBlock()) {
                for (ASMInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst()) {
                    ArrayList<VirtualRegister> def = new ArrayList<>(inst.getDef().keySet());
                    ArrayList<VirtualRegister> use = new ArrayList<>(inst.getUse().keySet());
                    int count = 0;
                    for (VirtualRegister vr : def) {
                        if (vr.getPhysicalRegister() != null) continue;

                        if (!addressHashMap.containsKey(vr)) {
                            addressHashMap.put(vr, new Address(PhysicalRegister.getv("sp"), new IntImm(0)));
                        }
                        Address address = addressHashMap.get(vr);
                        VirtualRegister pvr = PhysicalRegister.getv("s" + count);
                        inst.replaceDef(vr, pvr);
                        block.insertASMInstAfter(inst, new Sw(block, pvr, address));
                        count++;
                    }

                    for (VirtualRegister vr : use) {
                        if (vr.getPhysicalRegister() != null) continue;

                        if (!addressHashMap.containsKey(vr)) {
                            addressHashMap.put(vr, new Address(PhysicalRegister.getv("sp"), new IntImm(0)));
                        }
                        Address address = addressHashMap.get(vr);
                        VirtualRegister pvr = PhysicalRegister.getv("s" + count);
                        block.insertASMInstBefore(inst, new Lw(block, pvr, address));
                        inst.replaceUse(vr, pvr);
                        count++;
                    }
                }
            }
            asmFunction.getStackFrame().setRuntimeRegisterLocation(new ArrayList<>(addressHashMap.values()));
            asmFunction.getStackFrame().calcFrameSize();
            int frameSize = asmFunction.getStackFrame().getFrameSize();

            asmFunction.getEntryBlock().appendASMInstFront(new Addi(asmFunction.getEntryBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(-4 * frameSize)));
            asmFunction.getExitBlock().insertASMInstBefore(asmFunction.getExitBlock().getInstEnd(), new Addi(
                    asmFunction.getExitBlock(),
                    PhysicalRegister.getv("sp"), PhysicalRegister.getv("sp"), new IntImm(4 * frameSize)
            ));
        });
    }

    public void run() {

    }
}
