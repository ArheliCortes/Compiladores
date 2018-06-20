%{
int yystopparser=0;
%}

%token FONTANA NOMBRE ENT RAC NAT RISTRA GRAF ASIGNAR ASIGNARMAS ASIGNARMENOS ASIGNARPOR ASIGNARDIV IGUAL MAYORIGUAL MENORIGUAL MAYOR MENOR SUMA RES MUL DIV MOD POSINCREMENTO POSDECREMENTO DIFERENTE BOOLEANO AUMENTA ENTERO RACIONAL GRAFEMA RISTRAS DISMINUYE CASO ES CUANDO FIN ENOTROCASO MIENTRAS PARA HACER SI CONTRASI CONTRA FORMATO VACIO 

%start programa

%%

programa		: funcionprincipal  funcion | funcionprincipal;

funcionprincipal	: FONTANA '<' listasentencias '>';

listasentencias		: listasentencias estructuracontrol | estructuracontrol | metodospropios '_' |;

estructuracontrol   : sentenciadeclaracion | sentenciaexpresion | sentenciaseleccion | sentenciaiteracion | sentenciasalto;

sentenciadeclaracion	: tipodato NOMBRE '_';

tipodato		: ENT | RAC | NAT | RISTRA | GRAF;

sentenciaexpresion	: variable op valor '_' | variable op valor op valor '_' | NOMBRE '(' parametros ')' '<' listasentencias '>' '_' | variable '_' | incredismivar '_';

variable		: tipodato NOMBRE | valor;

op			: op_asig | op_comp | op_arit;

op_asig			: ASIGNAR | ASIGNARMAS | ASIGNARMENOS | ASIGNARPOR | ASIGNARDIV;

op_comp			: IGUAL | MAYORIGUAL | MENORIGUAL | MAYOR | MENOR | DIFERENTE;

op_arit			: SUMA | RES | MUL | DIV | MOD | POSINCREMENTO | POSDECREMENTO;

valor			: ENTERO | RACIONAL | BOOLEANO | GRAFEMA | RISTRAS;

parametros		: parametro | parametro ',' parametro;

parametro		: tipodato NOMBRE | NOMBRE;

incredismivar		: NOMBRE POSINCREMENTO | NOMBRE POSDECREMENTO;

sentenciaseleccion	: condicion_caso;

condicion_caso		: CASO variable ES CUANDO listasentencias FIN ENOTROCASO listasentencias FIN;

sentenciaiteracion	: condicion_mientras | condicion_para | condicion_hacer-mientras;

condicion_mientras	: MIENTRAS '(' condicion ')' '<' listasentencias '>';

condicion_para		: PARA '(' variable '_' condicion '_' incredismivar ')' '<' listasentencias '>';

condicion_hacer-mientras: HACER '<' listasentencias '>' MIENTRAS '(' condicion ')';

sentenciasalto		: condicion_si;

condicion_si		: SI '(' condicion ')' '<' listasentencias '>' | SI '(' condicion ')' '<' listasentencias '>'  condicion_si | SI '(' condicion ')' '<' listasentencias '>' CONTRASI '(' condicion ')' '<' listasentencias '>' CONTRA '<' listasentencias '>';

condicion		: NOMBRE op valor | valor op NOMBRE;

funcion			: tiporetorno NOMBRE '(' ')' '<' listasentencias '>' | tiporetorno NOMBRE '(' parametros ')' '<' listasentencias '>';

tiporetorno		: tipodato | VACIO;

metodospropios		: escribe | lee;

escribe			: '(' '"'  RISTRAS '"' ',' NOMBRE ')';

lee			: '(' FORMATO ')' ',' '&' NOMBRE ')';

