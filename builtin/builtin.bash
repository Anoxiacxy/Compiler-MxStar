clang -S -emit-llvm --target=riscv32 builtin.c -Ofast
llc --march=riscv32 --mattr=+m builtin.ll -O3