package RISCV.Operand.Register;

import RISCV.Operand.Operand;

abstract public class Register extends Operand {
    abstract public String emitCode();
}
