grammar Theater;

program
    : ( definicion ';' ) *
    ;

definicion
    : DEFINICION TYPE ':' ( feature )* FIN
    ;

feature
    : SECUENCIAL '(' MEDIA ID ':' STRING ',' expr ',' INT ',' INT ')' ';'
    | PARALELO '(' MEDIA ID ':' STRING ',' expr ')' ';'
    | AUDIO '(' ID ':' STRING ',' INT ')' ';'
    ;

expr
    : IMAGEN
    | VIDEO
    | AUDIO
    | TEXTO
    ;

DEFINICION : D E F I N I C I O N ;
SECUENCIAL : S E C U E N C I A L ;
PARALELO : P A R A L E L O ;
MEDIA : M E D I A ;
TEXTO : T E X T O ;
IMAGEN : I M A G E N;
VIDEO : V I D E O;
AUDIO : A U D I O;
FIN : F I N ;

TYPE: [A-Z][_a-zA-Z0-9]* ;
ID: [a-z][_a-zA-Z0-9]* ;
INT: [0-9]* ;
STRING : '"' .*? '"';