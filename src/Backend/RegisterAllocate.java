package Backend;

import IR.Module;
import Optimism.Pass;

public class RegisterAllocate extends Pass {

    public RegisterAllocate(Module module) {
        super(module);
    }

    @Override
    public boolean run() {
        return false;
    }
}
