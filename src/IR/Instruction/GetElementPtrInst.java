package IR.Instruction;

import IR.Operand.Operand;
import IR.Operand.Register;

import java.util.ArrayList;

public class GetElementPtrInst extends IRInst {
    private Register result;
    private ArrayList<Operand> index;
    private Operand address;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result).append(" = getelementptr ");
        return ;
    }
}
