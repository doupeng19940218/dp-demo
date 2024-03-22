grammar Arithmetic;

/*
 * Parser rules
 */

parse
    : expr
    ;

expr
    : term (('+'|'-') term)*
    ;

term
    : factor (('*'|'/') factor)*
    ;

factor
    : NUMBER
    | '(' expr ')'
    ;

/*
 * Lexer rules
 */

NUMBER
    : DIGIT+ ('.' DIGIT+)?
    ;

DIGIT
    : [0-9]
    ;

WHITESPACE
    : [ \t\n\r] -> skip
    ;

