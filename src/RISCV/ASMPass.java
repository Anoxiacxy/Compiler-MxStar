package RISCV;

public interface ASMPass {
    void run();

    void modulePass(ASMModule module);
    void functionPass(ASMFunction function);
    void blockPass(ASMBlock block);


}
