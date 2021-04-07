set ff=UNIX
set -e
# cd "$(dirname "$0")"
mkdir -p bin
find ./src -name *.java | javac -d bin -cp /ulib/java/antlr-4.9.1-complete.jar @/dev/stdin
# find ./src -name *.java | javac -d bin -cp lib/antlr-4.9.1-complete.jar @/dev/stdin
cp ./builtin/builtin.s .