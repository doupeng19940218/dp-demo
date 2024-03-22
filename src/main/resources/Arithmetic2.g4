grammar Arithmetic2;

/*
 * Parser rules
 */

parse
    : expr
    ;

expr
    :  (('+'|'-'))*
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

