grammar MxStar;

program : (functionDefination | classDefination | variableDefination)* EOF;

functionDefination : (TypeName | Void) FunctionIdentifier statement;
constructDefination : FunctionIdentifier statement;
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

succExpression : (primaryExpression (PlusPlus | MinusMinus)) | primaryExpression;
prefExpression : ((PlusPlus | MinusMinus | LogicalNeg | BitwiseNeg | Plus | Minus) succExpression) | succExpression;
multiExpression : ((prefExpression (Mul | Div | Mod))* prefExpression) | prefExpression;
addiExpression : ((multiExpression (Plus | Minus))* multiExpression) | multiExpression;
shiftExpression : ((addiExpression (LeftShift | RightShift))* addiExpression) | addiExpression;
compareExpression : ((shiftExpression (Less|LessEqual|Greater|GreaterEqual))* shiftExpression) | shiftExpression;
equalExpression : ((compareExpression (Equal | NotEqual))* compareExpression) | compareExpression;
bitAndExpression : ((equalExpression BitwiseAnd)* equalExpression) | equalExpression;
bitXorExpression  : ((bitAndExpression BitwiseXor)* bitAndExpression ) | bitAndExpression;
bitOrExpression  : ((bitXorExpression  BitwiseOr)*  bitXorExpression)  | bitXorExpression;
logAndExpression  : ((bitOrExpression  LogicalAnd)* bitOrExpression)  | bitOrExpression;
logOrExpression  : ((logAndExpression  LogicalOr)* logAndExpression)  | logAndExpression;
assignExpression  : (logOrExpression (Assign logOrExpression)*) | logOrExpression;
listExpression  : ((assignExpression Comma)* assignExpression) | assignExpression;

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