set ff=UNIX
set -e
cat | java -cp /ulib/java/antlr-4.9.1-complete.jar:./bin Main
# cat | java -cp lib/antlr-4.9.1-complete.jar:./bin Main -emit-llvm -emit-ast