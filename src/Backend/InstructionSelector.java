package Backend;

import IR.BasicBlock;
import IR.Function;
import IR.IRVisitor;
import IR.Instruction.*;
import IR.Module;
import IR.Operand.*;
import IR.TypeSystem.*;
import RISCV.ASMBlock;
import RISCV.ASMFunction;
import RISCV.ASMModule;
import RISCV.Instruction.*;
import RISCV.Operand.Address;
import RISCV.Operand.GlobalVariable;
import RISCV.Operand.Immediate.Immediate;
import RISCV.Operand.Immediate.IntImm;
import RISCV.Operand.Immediate.Relocation;
import RISCV.Operand.Register.PhysicalRegister;
import RISCV.Operand.Register.VirtualRegister;
import RISCV.StackFrame;
import Util.Error.ComplicationError;
import Util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static IR.Module.int_t;
import static IR.Module.void_t;

public class InstructionSelector implements IRVisitor {
    private ASMModule asmModule;
    private ASMFunction curAsmFunction;
    private ASMBlock curAsmBlock;
    private Map<String, VirtualRegister> virtualRegisterTable;

    private Map<Operand, VirtualRegister> operandVirtualRegisterMap;

    public InstructionSelector() {
        this.asmModule = new ASMModule();
        curAsmBlock = null;
        curAsmFunction = null;
        virtualRegisterTable = new LinkedHashMap<>();
        operandVirtualRegisterMap = new LinkedHashMap<>();
    }

    public ASMModule getAsmModule() {
        return asmModule;
    }

    public void setAsmModule(ASMModule asmModule) {
        this.asmModule = asmModule;
    }

    @Override
    public void visit(Module module) {
        for (GlobalRegister globalRegister : module.getGlobalVariableMap().values()) {
            String name = globalRegister.getName();
            GlobalVariable globalVariable = new GlobalVariable(name);
            asmModule.getGlobalVariableMap().put(name, globalVariable);

            assert globalRegister.getType() instanceof PointerIRT;
            IRType irType = ((PointerIRT) globalRegister.getType()).getBase();

            //System.out.println(globalRegister.getType());

            if (irType instanceof ArrayIRT) { // const.string
                assert globalRegister.getInit() instanceof ConstStr;
                globalVariable.setString(((ConstStr) globalRegister.getInit()).getValue());
            }
            if (irType instanceof IntegerIRT) {
                if (globalRegister.getInit() instanceof ConstBool) {
                    assert ((IntegerIRT) irType).getSize() == 1;
                    globalVariable.setBool(((ConstBool) globalRegister.getInit()).getValue());
                }
                else if (globalRegister.getInit() instanceof ConstInt) {
                    // System.out.println(irType.getByte());
                    assert ((IntegerIRT) irType).getByte() == 4;
                    globalVariable.setInt((int) ((ConstInt) globalRegister.getInit()).getValue());
                } else {
                    assert globalRegister.getInit() instanceof ConstNull;
                    globalVariable.setInt(0);
                }
            }
            if (irType instanceof PointerIRT) {
                globalVariable.setInt(0);
            }
        }
        for (Function function : module.getSystemFunctionMap().values())
            asmModule.getSystemFunctionMap().put(function.getName(),
                    new ASMFunction(asmModule, function.getName()));
        for (Function function : module.getFunctionMap().values())
            asmModule.getFunctionMap().put(function.getName(),
                    new ASMFunction(asmModule, function));
        for (Function function : module.getFunctionMap().values())
            function.accept(this);
    }

    @Override
    public void visit(Function function) {
        curAsmFunction = asmModule.getFunctionMap().get(function.getName());
        curAsmFunction.setStackFrame(new StackFrame(curAsmFunction));
        curAsmBlock = curAsmFunction.getEntryBlock();

        // ra
        {
            VirtualRegister raCopy = new VirtualRegister(PhysicalRegister.getv("ra").getName() + ".copy");
            virtualRegisterTable.put(raCopy.getName(), raCopy);
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, raCopy, PhysicalRegister.getv("ra")));
        }


        // callee
        for (VirtualRegister vr : PhysicalRegister.virtualRegisters.values()) {
            if (vr.getPhysicalRegister().getRegType() == PhysicalRegister.RegType.callee) {
                VirtualRegister copy = new VirtualRegister(vr.getName() + ".copy");
                virtualRegisterTable.put(copy.getName(), copy);
                curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, copy, vr));
            }
        }


        ArrayList<Parameter> parameters = function.getParameters();

        for (int i = 0; i < Integer.min(8, parameters.size()); i++) {
            VirtualRegister vr = getVirtualRegisterOfOperand(parameters.get(i));
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, vr, PhysicalRegister.getv("a" + i)));
        }

        for (int i = 8; i < parameters.size(); i++) {
            VirtualRegister vr = getVirtualRegisterOfOperand(parameters.get(i));
            Address address = new Address(PhysicalRegister.getv("sp"), new IntImm(0));
            curAsmFunction.getStackFrame().getParameterLocation().add(address);
            curAsmBlock.appendASMInstBack(new Lw(curAsmBlock, vr, address));
        }

        // TODO: 2021/4/5
        for (BasicBlock block = function.getEntryBlock(); block != null; block = block.getNextBlock())
            block.accept(this);

        curAsmFunction.getStackFrame().calcFrameSize();
    }

    @Override
    public void visit(BasicBlock block) {
        curAsmBlock = curAsmFunction.getAsmBlockMap().get(block);
        for (IRInst inst = block.getInstBegin(); inst != null; inst = inst.getNextInst())
            inst.accept(this);
    }

    @Override
    public void visit(AllocaInst inst) {
        CallInst malloc = new CallInst(null,
                inst.getBasicBlock().getFunction().getModule().getSystemFunctionMap().get("mx__malloc"),
                new ConstInt(int_t, inst.getType().getByte()), inst.getResult());
        malloc.accept(this);
    }

    @Override
    public void visit(BinaryInst inst) {
        inst.trySwapOperand();
        VirtualRegister lhs = getVirtualRegisterOfOperand(inst.getLhs());
        RISCV.Operand.Operand rhs;
        VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());

        switch (inst.getOpType()) {
            case add -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new Add(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case sub -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, result, lhs, ((IntImm) rhs).getNegative()));
                else
                    curAsmBlock.appendASMInstBack(new Sub(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case mul -> {
                rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Mul(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case sdiv -> {
                rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Div(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case srem -> {
                rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Rem(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case shl -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Slli(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new Sll(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case ashr -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Srai(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new Sra(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case and -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Andi(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new And(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case or -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Ori(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new Or(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
            case xor -> {
                rhs = getOperand(inst.getRhs());
                if (rhs instanceof Immediate)
                    curAsmBlock.appendASMInstBack(new Xori(curAsmBlock, result, lhs, (Immediate) rhs));
                else
                    curAsmBlock.appendASMInstBack(new Xor(curAsmBlock, result, lhs, (VirtualRegister) rhs));
            }
        }
    }

    @Override
    public void visit(BitCastToInst inst) {
        curAsmBlock.appendASMInstBack(new Mv(curAsmBlock,
                getVirtualRegisterOfOperand(inst.getResult()),
                getVirtualRegisterOfOperand(inst.getSource())));
    }

    @Override
    public void visit(BrInst inst) {
        // TODO: 2021/4/6
        if (inst.getCond() == null)
            curAsmBlock.appendASMInstBack(new J(curAsmBlock, curAsmFunction.getAsmBlockMap().get(inst.getThemBlock())));
        else {
            curAsmBlock.appendASMInstBack(new Beqz(curAsmBlock,
                    getVirtualRegisterOfOperand(inst.getCond()),
                    curAsmFunction.getAsmBlockMap().get(inst.getElseBlock())));
            curAsmBlock.appendASMInstBack(new J(curAsmBlock, curAsmFunction.getAsmBlockMap().get(inst.getThemBlock())));
        }
    }

    @Override
    public void visit(CallInst inst) {
        ASMFunction asmFunction;
        String funcName = inst.getFunction().getName();
        if (asmModule.getFunctionMap().containsKey(funcName))
            asmFunction = asmModule.getFunctionMap().get(funcName);
        else {
            assert asmModule.getSystemFunctionMap().containsKey(funcName);
            asmFunction = asmModule.getSystemFunctionMap().get(funcName);
        }

        ArrayList<Operand> parameters = inst.getParameters();

        for (int i = 0; i < Integer.min(8, parameters.size()); i++) {
            VirtualRegister vr = getVirtualRegisterOfOperand(parameters.get(i));
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, PhysicalRegister.getv("a" + i), vr));
        }

        StackFrame stackFrame = curAsmFunction.getStackFrame();
        if (!stackFrame.getCalleeParameterLocation().containsKey(asmFunction)) {
            stackFrame.getCalleeParameterLocation().put(asmFunction, new ArrayList<>());
            for (int i = 8; i < parameters.size(); i++)
                stackFrame.getCalleeParameterLocation().get(asmFunction)
                        .add(new Address(PhysicalRegister.getv("sp"), new IntImm(0)));
        }

        for (int i = 8; i < parameters.size(); i++) {
            VirtualRegister vr = getVirtualRegisterOfOperand(parameters.get(i));
            curAsmBlock.appendASMInstBack(new Sw(curAsmBlock,
                    vr, stackFrame.getCalleeParameterLocation().get(asmFunction).get(i - 8)));
        }

        curAsmBlock.appendASMInstBack(new Call(curAsmBlock, asmFunction));

        if (inst.getFunction().getFuncType().getReturnType() != void_t) {
            VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, result, PhysicalRegister.getv("a0")));
        }
    }

    @Override
    public void visit(RetInst inst) {
        if (inst.getValue() != null)
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock,
                    PhysicalRegister.getv("a0"), getVirtualRegisterOfOperand(inst.getValue())));

        // callee
        for (VirtualRegister vr : PhysicalRegister.virtualRegisters.values()) {
            if (vr.getPhysicalRegister().getRegType() == PhysicalRegister.RegType.callee) {
                VirtualRegister copy = virtualRegisterTable.get(vr.getName() + ".copy");
                curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, vr, copy));
            }
        }


        // ra
        {
            VirtualRegister raCopy = virtualRegisterTable.get(PhysicalRegister.getv("ra").getName() + ".copy");
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, PhysicalRegister.getv("ra"), raCopy));
        }

        curAsmBlock.appendASMInstBack(new Ret(curAsmBlock));
    }

    @Override
    public void visit(GetElementPtrInst inst) {
        VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());

        if (inst.getAddress() instanceof GlobalRegister) {
            curAsmBlock.appendASMInstBack(new La(curAsmBlock,
                    result, asmModule.getGlobalVariableMap().get(inst.getAddress().getName())));
            return;
        }

        VirtualRegister address = getVirtualRegisterOfOperand(inst.getAddress());

        if (inst.getIndex().size() == 1) {
            Operand operand = inst.getIndex().get(0);
            if (operand instanceof ConstInt) {
                int offsetInt = (int) (4 * ((ConstInt) operand).getValue());
                RISCV.Operand.Operand offsetOpt = getOperand(new ConstInt(int_t, offsetInt));
                if (offsetOpt instanceof IntImm)
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, result, address, (Immediate) offsetOpt));
                else
                    curAsmBlock.appendASMInstBack(new Add(curAsmBlock, result, address, (VirtualRegister) offsetOpt));
            } else {
                VirtualRegister temp = getVirtualRegisterOfOperand(operand);
                VirtualRegister offset = new VirtualRegister("array_offset");
                curAsmBlock.appendASMInstBack(new Slli(curAsmBlock, offset, temp, new IntImm(2)));
                curAsmBlock.appendASMInstBack(new Add(curAsmBlock, result, address, offset));
            }
            return;
        }

        if (inst.getIndex().size() == 2) {
            assert inst.getIndex().get(0) instanceof ConstInt;
            assert inst.getIndex().get(1) instanceof ConstInt;
            assert ((ConstInt) inst.getIndex().get(0)).getValue() == 0;
            int elementID = (int) ((ConstInt) inst.getIndex().get(1)).getValue();
            assert inst.getAddress().getType() instanceof PointerIRT;
            IRType irType = ((PointerIRT) inst.getAddress().getType()).getBase();
            // System.out.println(irType);
            assert irType instanceof ClassIRT;
            int offsetInt = ((ClassIRT) irType).getElementOffset(elementID);
            RISCV.Operand.Operand offsetOpt = getOperand(new ConstInt(int_t, offsetInt));
            if (offsetOpt instanceof IntImm)
                curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, result, address, (Immediate) offsetOpt));
            else
                curAsmBlock.appendASMInstBack(new Add(curAsmBlock, result, address, (VirtualRegister) offsetOpt));
            return;
        }

        throw new ComplicationError("error getelementptr index", new Position());
    }

    @Override
    public void visit(GlobalInst inst) {
        // TODO: 2021/4/6  ignore
    }

    @Override
    public void visit(IcmpInst inst) {
        // TODO: 2021/4/6 if it will be use for binary 

        VirtualRegister lhs = getVirtualRegisterOfOperand(inst.getLhs());
        VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());
        VirtualRegister temp = new VirtualRegister("icmp");

        switch (inst.getOpType()) {
            case eq -> {
                RISCV.Operand.Operand rhs = getOperand(inst.getRhs());
                if (rhs instanceof IntImm)
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, temp, lhs, ((IntImm) rhs).getNegative()));
                else
                    curAsmBlock.appendASMInstBack(new Sub(curAsmBlock, temp, lhs, (VirtualRegister) rhs));
                curAsmBlock.appendASMInstBack(new Seqz(curAsmBlock, result, temp));
            }
            case ne -> {
                RISCV.Operand.Operand rhs = getOperand(inst.getRhs());
                if (rhs instanceof IntImm)
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock, temp, lhs, ((IntImm) rhs).getNegative()));
                else
                    curAsmBlock.appendASMInstBack(new Sub(curAsmBlock, temp, lhs, (VirtualRegister) rhs));
                curAsmBlock.appendASMInstBack(new Snez(curAsmBlock, result, temp));
            }
            case sge -> {
                VirtualRegister rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Slt(curAsmBlock, temp, lhs, rhs));
                curAsmBlock.appendASMInstBack(new Xori(curAsmBlock, result, temp, new IntImm(1)));
            }
            case sgt -> {
                VirtualRegister rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Slt(curAsmBlock, result, rhs, lhs));
            }
            case sle -> {
                VirtualRegister rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Slt(curAsmBlock, temp, rhs, lhs));
                curAsmBlock.appendASMInstBack(new Xori(curAsmBlock, result, temp, new IntImm(1)));
            }
            case slt -> {
                VirtualRegister rhs = getVirtualRegisterOfOperand(inst.getRhs());
                curAsmBlock.appendASMInstBack(new Slt(curAsmBlock, result, lhs, rhs));
            }
        }
    }

    @Override
    public void visit(LoadInst inst) {
        VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());
        IRType irType = inst.getType();

        if (inst.getAddress() instanceof GlobalRegister) {
            GlobalVariable gv = asmModule.getGlobalVariableMap().get(inst.getAddress().getName());
            VirtualRegister lui = new VirtualRegister("lui");
            curAsmBlock.appendASMInstBack(new Lui(curAsmBlock, lui, new Relocation(gv, Relocation.ImmType.hi)));
            if (irType.getByte() == 1)
                curAsmBlock.appendASMInstBack(new Lb(curAsmBlock,
                        result, new Address(lui, new Relocation(gv, Relocation.ImmType.lo))));
            else
                curAsmBlock.appendASMInstBack(new Lw(curAsmBlock,
                        result, new Address(lui, new Relocation(gv, Relocation.ImmType.lo))));
        } else {
            VirtualRegister address = getVirtualRegisterOfOperand(inst.getAddress());
            if (irType.getByte() == 1)
                curAsmBlock.appendASMInstBack(new Lb(curAsmBlock, result, new Address(address, new IntImm(0))));
            else
                curAsmBlock.appendASMInstBack(new Lw(curAsmBlock, result, new Address(address, new IntImm(0))));
        }
    }

    @Override
    public void visit(PhiInst inst) {
        // TODO: 2021/4/6
        throw new ComplicationError("unexpected phi instruction", new Position());
    }



    @Override
    public void visit(StoreInst inst) {
        VirtualRegister value = getVirtualRegisterOfOperand(inst.getValue());
        IRType irType = inst.getValue().getType();

        if (inst.getAddress() instanceof GlobalRegister) {
            GlobalVariable gv = asmModule.getGlobalVariableMap().get(inst.getAddress().getName());
            VirtualRegister lui = new VirtualRegister("lui");
            curAsmBlock.appendASMInstBack(new Lui(curAsmBlock, lui, new Relocation(gv, Relocation.ImmType.hi)));
            if (irType.getByte() == 1)
                curAsmBlock.appendASMInstBack(new Sb(curAsmBlock,
                        value, new Address(lui, new Relocation(gv, Relocation.ImmType.lo))));
            else
                curAsmBlock.appendASMInstBack(new Sw(curAsmBlock,
                        value, new Address(lui, new Relocation(gv, Relocation.ImmType.lo))));
        } else {
            VirtualRegister address = getVirtualRegisterOfOperand(inst.getAddress());
            if (irType.getByte() == 1)
                curAsmBlock.appendASMInstBack(new Sb(curAsmBlock, value, new Address(address, new IntImm(0))));
            else
                curAsmBlock.appendASMInstBack(new Sw(curAsmBlock, value, new Address(address, new IntImm(0))));
        }
    }

    @Override
    public void visit(MoveInst inst) {
        VirtualRegister result = getVirtualRegisterOfOperand(inst.getResult());
        RISCV.Operand.Operand source = getOperand(inst.getSource());
        if (source instanceof VirtualRegister)
            curAsmBlock.appendASMInstBack(new Mv(curAsmBlock, result, (VirtualRegister) source));
        else {
            assert source instanceof IntImm;
            curAsmBlock.appendASMInstBack(new Addi(curAsmBlock,
                    result, PhysicalRegister.getv("zero"), (Immediate) source));
        }
    }

    int constCnt = 0;
    public VirtualRegister getVirtualRegisterOfOperand(Operand operand) {
        assert operand != null;
        if (operand instanceof ConstBool) {
            if (((ConstBool) operand).getValue()) {
                VirtualRegister vr = new VirtualRegister("const.bool(true)" + ++constCnt);
                curAsmBlock.appendASMInstBack(new Addi(curAsmBlock,
                        vr, PhysicalRegister.getv("zero"), new IntImm(1)));
                return vr;
            } else
                return PhysicalRegister.getv("zero");
        }
        if (operand instanceof ConstInt) {
            long value = ((ConstInt) operand).getValue();
            if (value != 0) {
                VirtualRegister vr = new VirtualRegister("const.int(" + value + ")" + ++constCnt);
                if (needLoad(value))
                    curAsmBlock.appendASMInstBack(new Li(curAsmBlock, vr, new IntImm((int) value)));
                else
                    curAsmBlock.appendASMInstBack(new Addi(curAsmBlock,
                            vr, PhysicalRegister.getv("zero"), new IntImm((int) value)));
                return vr;
            } else
                return PhysicalRegister.getv("zero");
        }
        if (operand instanceof ConstNull)
            return PhysicalRegister.getv("zero");
        if (operand instanceof GlobalRegister) {
            throw new RuntimeException();
            // throw new ComplicationError("global register ? " + operand, new Position());
        }
        if (operand instanceof LocalRegister) {
            if (operandVirtualRegisterMap.containsKey(operand))
                return operandVirtualRegisterMap.get(operand);
            else {
                VirtualRegister vr = new VirtualRegister(operand.getName() + operandVirtualRegisterMap.size());
                operandVirtualRegisterMap.put(operand, vr);
                return vr;
            }
        }
        throw new RuntimeException("operand type error: " + operand);
    }

    public boolean needLoad(long value) {
        return value >= (1 << 11) || value <= -(1 << 11);
    }

    public RISCV.Operand.Operand getOperand(Operand operand) {
        assert operand != null;
        if (operand instanceof ConstBool)
            return new IntImm(((ConstBool) operand).getValue() ? 1 : 0);
        if (operand instanceof ConstInt) {
            long value = ((ConstInt) operand).getValue();
            if (needLoad(value)) {
                return getVirtualRegisterOfOperand(operand);
            } else
                return new IntImm((int) value);
        }
        if (operand instanceof ConstNull)
            return PhysicalRegister.getv("zero");
        if (operand instanceof GlobalRegister)
            throw new ComplicationError("global register ? " + operand, new Position());
        if (operand instanceof LocalRegister)
            return getVirtualRegisterOfOperand(operand);
        throw new RuntimeException("operand type error: " + operand);
    }

}
