package IR.TypeSystem;

import java.util.ArrayList;

public class ClassIRT extends IRType {
    private String name;
    private ArrayList<IRType> irTypeArrayList;

    public ClassIRT(String name) {
        this.name = name;
        irTypeArrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IRType> getIrTypeArrayList() {
        return irTypeArrayList;
    }

    public void setIrTypeArrayList(ArrayList<IRType> irTypeArrayList) {
        this.irTypeArrayList = irTypeArrayList;
    }

    public String toConstructorString() {
        StringBuilder stringBuilder = new StringBuilder(this.toString());
        stringBuilder.append(" = type { ");
        for (int i = 0; i < irTypeArrayList.size(); i++) {
            stringBuilder.append(irTypeArrayList.get(i).toString());
            if (i != irTypeArrayList.size() - 1) stringBuilder.append(", ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "%class." + this.name;
    }
}
