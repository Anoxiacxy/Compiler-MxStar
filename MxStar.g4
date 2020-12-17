grammar MxStar;

program : (functionDefination | classDefination | variableDefination)* EOF;

functionDefination : (typeName | Void) functionIdentifier LeftParenthesis expression ? RightParenthesis statement;
constructDefination : functionIdentifier statement;
classDefination : Class ClassIdentifier LeftBrace
        (
            functionDefination
            | constructDefination
            | variableDefination
        )*
    RightBrace Semi;
variableDefination : TypeName(LeftBracket RightBracket)* 
        (Identifier (Assign expression)?) (Comma Identifier (Assign expression)?)* Semi;

statement
    : variableDefination
    | blockStatement
    | ifStatement
    | whileStatement
    | forStatement
    | returnStatement
    | breakStatement
    | continueStatement
    | expressionStatement
    ;

blockStatement : LeftBrace statement* RightBrace;
ifStatement : If LeftParenthesis expression RightParenthesis statement (Else statement)?;
whileStatement : While LeftParenthesis expression RightParenthesis statement;
forStatement : For LeftParenthesis
        expression ? Semi expression ? Semi expression
    RightParenthesis statement;
returnStatement : Return expression ? Semi;
breakStatement : Break Semi;
continueStatement : Continue Semi;
expressionStatement : expression Semi;

succExpression   :  primaryExpression (PlusPlus | MinusMinus) ?;
prefExpression   : (PlusPlus | MinusMinus | LogicalNeg | BitwiseNeg | Plus | Minus)* succExpression;
multiExpression  : (prefExpression (Mul | Div | Mod))* prefExpression;
addiExpression   : (multiExpression (Plus | Minus))* multiExpression;
shiftExpression  : (addiExpression (LeftShift | RightShift))* addiExpression;
compareExpression: (shiftExpression (Less|LessEqual|Greater|GreaterEqual))* shiftExpression;
equalExpression  : (compareExpression (Equal | NotEqual))* compareExpression;
bitAndExpression : (equalExpression BitwiseAnd)* equalExpression;
bitXorExpression : (bitAndExpression BitwiseXor)* bitAndExpression;
bitOrExpression  : (bitXorExpression  BitwiseOr)*  bitXorExpression;
logAndExpression : (bitOrExpression  LogicalAnd)* bitOrExpression;
logOrExpression  : (logAndExpression  LogicalOr)* logAndExpression;
assignExpression :  logOrExpression (Assign logOrExpression)*;
listExpression   : (assignExpression Comma)* assignExpression;

expression : listExpression;

primaryExpression
    : This
    | identifierExpression
    | literal
    | LeftParenthesis expression RightParenthesis
    | functionCallExpression
    | newExpression
    ;

newExpression : New TypeName (LeftBracket expression RightBracket)* 
                            (LeftBracket RightBracket)* (LeftParenthesis RightParenthesis)?;
functionCallExpression : FunctionIdentifier 
        ( (LeftParenthesis RightParenthesis) 
        | (LeftParenthesis expression RightParenthesis)
    );

identifierExpression
    : Identifier
    | identifierExpression LeftBracket expression RightBracket
    | identifierExpression Dot identifierExpression;

typeName : Bool | Int | String | classIdentifier;
classIdentifier : Identifier;
functionIdentifier : Identifier;
fundamentalType : Bool | Int | Void | String;

literal : BooleanLiteral | IntegerLiteral | StringLiteral | NullLiteral;

BooleanLiteral : True | False;
IntegerLiteral : '-' ? [0-9]+;
StringLiteral  : '"' PrintableChar* '"';
NullLiteral    : Null;

fragment PrintableChar : ~["\\\n\r] | '\\n'| '\\\\' | '\\"';

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
standardOperator : Plus | Minus | Mul | Div | Mod;
relationOperator : Greater | Less | GreaterEqual | LessEqual | NotEqual | Equal;
logicalOperator  : LogicalAnd | LogicalOr | LogicalNeg;
bitwiseOperator  : RightShift | LeftShift | BitwiseAnd | BitwiseOr | BitwiseXor | BitwiseNeg;
assignOperator   : Assign;
iterateOperator  : PlusPlus | MinusMinus;
componentOperator: Dot;
priorityOperator : LeftParenthesis | RightParenthesis;
specialSymbol    : Space | NewLine | Tab | CommentSymbol;

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