grammar MxStar;

program : programComponent* EOF;
programComponent : (functionDefinition | classDefinition | variableDefinition);

functionDefinition : returnType ? Identifier
                        LeftParenthesis parameterList ? RightParenthesis block;
parameterList : parameter (Comma parameter)*;
parameter : type Identifier;

classDefinition : Class Identifier LeftBrace classComponent* RightBrace Semi;
classComponent : functionDefinition | variableDefinition | classDefinition;

block : LeftBrace statement* RightBrace;

statement
    : variableDefinition                                                            #varDefStatement
    | block                                                                         #blockStatement
    | If LeftParenthesis cond=expression RightParenthesis trueStmt=statement
                                                       (Else falseStmt=statement)?  #ifStatement
    | While LeftParenthesis cond=expression RightParenthesis statement              #whileStatement
    | For LeftParenthesis
              init=expression ? Semi cond=expression ? Semi incr=expression ?
          RightParenthesis statement                                                #forStatement
    | Return expression ? Semi                                                      #returnStatement
    | Break Semi                                                                    #breakStatement
    | Continue Semi                                                                 #continueStatement
    | expression Semi                                                               #expressionStatement
    | Semi                                                                          #emptyStatement
    ;

expression
    : literal                                                                           #literalExpression
    | Identifier                                                                        #identifierExpression
    | pointer=expression (LeftParenthesis
            (argumentList=expressionList) ?
        RightParenthesis)                                                               #funcExpression
    | (New baseType (LeftBracket expression RightBracket)*
                  (LeftBracket RightBracket)+) (LeftBracket expression RightBracket)+   #errorExpression
    | pointer=expression LeftBracket offset=expression RightBracket                     #arrayExpression
    | pointer=expression Dot Identifier                                                 #memberExpression
    | (New baseType (LeftBracket expression RightBracket)*
            (LeftBracket RightBracket)*) (LeftParenthesis RightParenthesis)?            #newExpression
    | LeftParenthesis expression RightParenthesis                                       #subExpression
    | expression op=(PlusPlus | MinusMinus)                                             #succExpression
    | <assoc=right>op=(Plus | Minus | PlusPlus | MinusMinus) expression                 #prefExpression
    | <assoc=right>op=(LogicalNeg | BitwiseNeg) expression                              #prefExpression
    | expression op=(Mul | Div | Mod) expression                                        #binaryExpression
    | expression op=(Plus | Minus) expression                                           #binaryExpression
    | expression op=(LeftShift | RightShift) expression                                 #binaryExpression
    | expression op=(Less | Greater | LessEqual | GreaterEqual) expression              #binaryExpression
    | expression op=(Equal | NotEqual) expression                                       #binaryExpression
    | expression op=BitwiseAnd expression                                               #binaryExpression
    | expression op=BitwiseXor expression                                               #binaryExpression
    | expression op=BitwiseOr expression                                                #binaryExpression
    | expression op=LogicalAnd expression                                               #binaryExpression
    | expression op=LogicalOr expression                                                #binaryExpression
    | <assoc=right>expression op=Assign expression                                      #binaryExpression
    ;
expressionList : expression (Comma expression)*;

variableDefinition : type singleDefinition (Comma singleDefinition)* Semi;
singleDefinition : Identifier (Assign expression)?;

returnType : (type | Void);
type : baseType (LeftBracket RightBracket)*;
baseType : Bool | Int | String | Identifier;

literal
    : BoolLiteral       #boolLiteral
    | IntegerLiteral    #intLiteral
    | StringLiteral     #stringLiteral
    | NullLiteral       #nullLiteral
    | This              #thisLiteral
    ;

BoolLiteral : True | False;
IntegerLiteral : [0-9]+;
StringLiteral  : '"' PrintableChar* '"';
NullLiteral    : Null;

fragment PrintableChar : ~["\\\n\r] | '\\n'| '\\\\' | '\\"';

Comment
    : ((CommentSymbol ~[\n]*)
    | (LeftCommentSymbol .*? RightCommentSymbol))
    -> skip;


WhiteSpace : (Space | Tab | NewLine) -> skip;

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