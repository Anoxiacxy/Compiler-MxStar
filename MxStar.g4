grammar MxStar;

functionDefination : (TypeName | Void) FunctionIdentifier statement;
classDefination : Class ClassIdentifier LeftBrace
        (
            // TODO
        ) *
    RightBrace;
VariableDefination : ;


statement
    : blockStatement
    | returnStatement
    ;

blockStatement : LeftBrace statement* RightBrace;
returnStatement : Return expression;



expression : primaryExpression;


succExpression : (primaryExpression (PlusPlus | MinusMinus)) | primaryExpression;
prefExpression : ((PlusPlus | MinusMinus | LogicalNeg | BitwiseNeg | Plus | Minus) succExpression) | succExpression;
mulBinaryExpression15 : (PrefExpression17 (Mul | Div | Mod) PrefExpression17) | PrefExpression17;
BinaryExpression14 : (BinaryExpression15 (Plus | Minus) BinaryExpression15) | BinaryExpression15;
BinaryExpression13 : (BinaryExpression14 (LeftShift | RightShift) BinaryExpression14) | BinaryExpression14;
BinaryExpression12 : (BinaryExpression13 (Less | LessEqual | Greater | GreaterEqual) BinaryExpression13) | BinaryExpression13;
BinaryExpression11 : (BinaryExpression12 (Equal | NotEqual) BinaryExpression12) | BinaryExpression12;
BinaryExpression10 : (BinaryExpression11 BitwiseAnd BinaryExpression11) | BinaryExpression11;
BinaryExpression9  : (BinaryExpression10 BitwiseXor BinaryExpression10) | BinaryExpression10;
BinaryExpression8  : (BinaryExpression9  BitwiseOr  BinaryExpression9)  | BinaryExpression9;
BinaryExpression7  : (BinaryExpression8  LogicalAnd BinaryExpression8)  | BinaryExpression8;
BinaryExpression6  : (BinaryExpression7  LogicalOr BinaryExpression7)   | BinaryExpression7;
BinaryExpression3  : IntegerLiteral;
binaryExpression0  : <assoc=right>BinaryExpression0  Comma  BinaryExpression3;

primaryExpression
    : This
    | identifierExpression
    | literal
    | LeftParenthesis expression RightParenthesis
    | functionCallExpression
    | newExpression
    ;

newExpression : New TypeName (LeftBracket expression RightBracket)* (LeftBracket RightBracket)*;
functionCallExpression : FunctionIdentifier ((LeftParenthesis RightParenthesis) | (LeftParenthesis expression RightParenthesis));

identifierExpression
    : Identifier
    | identifierExpression LeftBracket expression RightBracket
    | identifierExpression Dot identifierExpression;

TypeName : Bool | Int | String | ClassIdentifier;
ClassIdentifier : Identifier;
FunctionIdentifier : Identifier;
FundamentalType : Bool | Int | Void | String;

literal : BooleanLiteral | IntegerLiteral | StringLiteral | NullLiteral;

BooleanLiteral : True | False;
IntegerLiteral : '-' ? [0-9]+;
StringLiteral  : '"' PrintableChar* '"';
NullLiteral    : Null;

PrintableChar : ~["\\\n\r] | '\\n'| '\\\\' | '\\"';

Identifier : [a-zA-Z] IdentifierSymbol*;

Comment : (CommentSymbol ~[\n]) -> skip;

WhiteSpace : (Space | Tab | NewLine) -> skip;

KeyWord : Int | Bool | String | Null | Void | True | False | If | Else
        | For | While | Break | Continue | Return | New | Class | This;

Int : 'int';
Bool : 'bool';
String : 'string';
Null : 'null';
Void : 'void';
True : 'true';
False : 'false';
If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';
New : 'new';
Class : 'class';
This : 'this';

IdentifierSymbol : [a-zA-Z0-9_];
StandardOperator : Plus | Minus | Mul | Div | Mod;
RelationOperator : Greater | Less | GreaterEqual | LessEqual | NotEqual | Equal;
LogicalOperator  : LogicalAnd | LogicalOr | LogicalNeg;
BitwiseOperator  : RightShift | LeftShift | BitwiseAnd | BitwiseOr | BitwiseXor | BitwiseNeg;
AssignOperator   : Assign;
IterateOperator  : PlusPlus | MinusMinus;
ComponentOperator: Dot;
PriorityOperator : LeftParenthesis | RightParenthesis;
SpecialSymbol    : Space | NewLine | Tab | CommentSymbol;

Space : ' ';
NewLine : '\n';
Tab : '\t';
CommentSymbol : '//';

LeftBrace : '{';
RightBrace : '}';

LeftBracket : '[';
RightBracket : ']';

LeftParenthesis : '(';
RightParenthesis : ')';

Dot : '.';
Comma : ',';
Semi: ';';
Assign : '=';

PlusPlus : '++';
MinusMinus : '--';

RightShift : '>>';
LeftShift  : '<<';
BitwiseAnd : '&';
BitwiseOr  : '|';
BitwiseXor : '^';
BitwiseNeg : '~';

LogicalAnd : '&&';
LogicalOr  : '||';
LogicalNeg : '!';

Greater : '>';
Less : '<';
GreaterEqual : '>=';
LessEqual : '<=';
NotEqual : '!=';
Equal : '==';

Plus : '+';
Minus : '-';
Mul : '*';
Div : '/';
Mod : '%';
















