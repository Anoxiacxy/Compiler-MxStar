grammar MxStar;

program : (functionDefination | classDefination | variableDefination)* EOF;

functionDefination : (typeName (LeftBracket RightBracket)* | Void) functionIdentifier LeftParenthesis parameterList ? RightParenthesis statement;
parameterList : parameter (Comma parameter)*;
parameter : typeName(LeftBracket RightBracket)* Identifier;

constructDefination : functionIdentifier LeftParenthesis RightParenthesis statement;
classDefination : Class classIdentifier LeftBrace
        (
            functionDefination
            | constructDefination
            | variableDefination
        )*
    RightBrace Semi;
variableDefination : typeName(LeftBracket RightBracket)*
        (Identifier (Assign expression)?) (Comma Identifier (Assign expression)?)* Semi;

statement
    : variableDefination                                                            #varDefStatement
    | LeftBrace statement* RightBrace                                               #blockStatement
    | If LeftParenthesis expression RightParenthesis statement (Else statement)?    #ifStatement
    | While LeftParenthesis expression RightParenthesis statement                   #whileStatement
    | For LeftParenthesis
              init ? Semi expression ? Semi expression
          RightParenthesis statement                                                #forStatement
    | Return expression ? Semi                                                      #returnStatement
    | Break Semi                                                                    #breakStatement
    | Continue Semi                                                                 #continueStatement
    | expression Semi                                                               #expressionStatement
    ;

init : typeName ? expression;

expression
    : primaryExpression                                                             #atomExpression
    | expression (PlusPlus | MinusMinus)                                            #succExpression
    | (Plus | Minus | PlusPlus | MinusMinus) expression                             #prefExpression
    | expression (Mul | Div | Mod) expression                                       #multiExpression
    | expression (Plus | Minus) expression                                          #addiExpression
    | expression (LeftShift | RightShift) expression                                #shiftExpression
    | expression (Less|Greater|LessEqual|GreaterEqual) expression                   #compareExpression
    | expression (Equal | NotEqual) expression                                      #equalExpression
    | expression BitwiseAnd expression                                              #bitAndExpression
    | expression BitwiseXor expression                                              #bitXorExpression
    | expression BitwiseOr expression                                               #bitOrExpression
    | expression LogicalAnd expression                                              #logAndExpression
    | expression LogicalOr expression                                               #logOrExpression
    | <assoc=right>expression Assign expression                                     #assignExpression
    | expression Comma expression                                                   #listExpression
    ;

primaryExpression
    : identifierExpression
    | literal
    | LeftParenthesis expression RightParenthesis
    | functionCallExpression
    | newExpression
    ;

newExpression : New typeName (LeftBracket expression RightBracket)*
                            (LeftBracket RightBracket)* (LeftParenthesis RightParenthesis)?;
functionCallExpression : identifierExpression
        ( (LeftParenthesis RightParenthesis) 
        | (LeftParenthesis expression RightParenthesis)
    );

identifierExpression
    : Identifier                                                # identitfier
    | This                                                      # this
    | identifierExpression LeftBracket expression RightBracket  # array
    | identifierExpression Dot identifierExpression             # member
    ;

typeName : Bool | Int | String | classIdentifier;
classIdentifier : Identifier;
functionIdentifier : Identifier;
fundamentalType : Bool | Int | Void | String;

literal : BooleanLiteral | IntegerLiteral | StringLiteral | NullLiteral;

BooleanLiteral : True | False;
IntegerLiteral : [0-9]+;
StringLiteral  : '"' PrintableChar* '"';
NullLiteral    : Null;

fragment PrintableChar : ~["\\\n\r] | '\\n'| '\\\\' | '\\"';



Comment
    : ((CommentSymbol ~[\n]*)
    | (LeftCommentSymbol .*? RightCommentSymbol))
    -> skip;


WhiteSpace : (Space | Tab | NewLine) -> skip;

keyWord : Int | Bool | String | Null | Void | True | False | If | Else
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

Identifier : [a-zA-Z] IdentifierSymbol*;

fragment IdentifierSymbol : [a-zA-Z0-9_];
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
LeftCommentSymbol : '/*';
RightCommentSymbol : '*/';

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