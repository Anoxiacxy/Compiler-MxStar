package RISCV.Operand.Register;

import java.util.*;

public class PhysicalRegister extends Register {
    public static ArrayList<String> phyRegName = new ArrayList<>(Arrays.asList(
            "zero",
            "ra",
            "sp", "gp", "tp",
            "t0", "t1", "t2",
            "s0", "s1",
            "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11",
            "t3", "t4", "t5", "t6"
    ));

    public enum RegType {
        caller, callee, special
    }

    public static ArrayList<RegType> saveStatus = new ArrayList<>(Arrays.asList(
            RegType.special,
            RegType.caller,
            RegType.special, RegType.special, RegType.special,
            RegType.caller, RegType.caller, RegType.caller,
            RegType.callee, RegType.callee,
            RegType.caller, RegType.caller, RegType.caller, RegType.caller, RegType.caller, RegType.caller, RegType.caller, RegType.caller,
            RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee, RegType.callee,
            RegType.caller, RegType.caller, RegType.caller, RegType.caller
    ));

    public static Map<String, PhysicalRegister> allocatableRegisters;
    public static Map<String, PhysicalRegister> physicalRegisters;
    public static Map<String, VirtualRegister> virtualRegisters;

    static {
        physicalRegisters = new LinkedHashMap<>();
        virtualRegisters = new LinkedHashMap<>();
        allocatableRegisters = new LinkedHashMap<>();

        for (int i = 0; i < phyRegName.size(); i++)
            physicalRegisters.put(phyRegName.get(i), new PhysicalRegister(phyRegName.get(i), saveStatus.get(i), i));

        for (int i = 0; i < phyRegName.size(); i++)
            if (saveStatus.get(i) != RegType.special)
                allocatableRegisters.put(phyRegName.get(i), physicalRegisters.get(phyRegName.get(i)));

        for (String name : phyRegName)
            virtualRegisters.put(name, new VirtualRegister(name, physicalRegisters.get(name)));

    }

    public static Map<String, PhysicalRegister> getAllocatableRegisters() {
        return allocatableRegisters;
    }

    public static VirtualRegister getv(String name) {
        return virtualRegisters.get(name);
    }

    public static VirtualRegister getv(int name) {
        return virtualRegisters.get(phyRegName.get(name));
    }

    public static PhysicalRegister getp(String name) {
        return physicalRegisters.get(name);
    }

    private String name;
    private RegType regType;
    private Integer id;

    public void setName(String name) {
        this.name = name;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private static final Map<String, VirtualRegister> phy2varRegisterMap = new LinkedHashMap<>();
    public static VirtualRegister getVirtualRegister(String name) {
        return phy2varRegisterMap.get(name);
    }

    public static VirtualRegister getVirtualRegister(int id) {
        return phy2varRegisterMap.get(phyRegName.get(id));
    }

    public static void setVirtualRegister(String name, VirtualRegister register) {
        if (phy2varRegisterMap.containsKey(name))
            phy2varRegisterMap.replace(name, register);
        else
            phy2varRegisterMap.put(name, register);
    }

    public PhysicalRegister(String name, RegType regType, int id) {
        this.name = name;
        this.regType = regType;
        this.id = id;
    }

    @Override
    public String emitCode() {
        return name;
    }

    public String getName() {
        return name;
    }
}
