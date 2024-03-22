grammar Arithmetic3;

/*
 * Parser rules
 */

parse
    : expr
    ;

expr
    : NUMBER (('+'|'-')) NUMBER*
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

