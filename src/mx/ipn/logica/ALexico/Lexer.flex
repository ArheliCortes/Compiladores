package mx.ipn.logica.ALexico;
import static mx.ipn.logica.ALexico.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z]
D = [0-9]
S=[&/%$'?¿!¡*~]
Comilla=[']
FinLinea = [\r|\n|\r\n]
CaracterEntrada = [^\r\n]
ComentarioTradicional   = "#*" [^*] ~"*#" | "#*" "*"+ "#"
FindeComentarioLinea    = "#" {CaracterEntrada}* {FinLinea}?
ComentarioContenido     = ( [^*] | #*+ [^#*] )*
Documentacion = "#**" {ComentarioContenido} "*"+ "#"
Comentario = {ComentarioTradicional} | {FindeComentarioLinea} | {Documentacion}
WHITE=[\r\n]
SPACE=[\t|" "]
VACIO=[" "]
NULO=[0]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}
{SPACE} {return ESPACIO_BLANCO}
{Comentario} {/*Ignore*/}
"::"  {return ASIGNAR;}
":+"  {return ASIGNAR_MAS;}
":-"  {return ASIGNAR_MENOS;}
":*"  {return ASIGNAR_POR;}
":/"  {return ASIGNAR_DIV;}
"::" {return IGUAL;}
"!=" {return DIFERENTE;}
">"  {return MAYOR;}
"<"  {return MENOR;}
"<::"  {return MENOR_IGUAL;}
"<::"  {return MAYOR_IGUAL;}
"+"  {return SUMA;}
"-"  {return RESTA;}
"*"  {return MUL;}
"/"  {return DIV;}
"%"  {return MOD;}
"++"  {return POS_INCREMENTO;}
"--"  {return POS_DECREMENTO;}
"&&"  {return YLOGICO;}
"||"  {return OLOGICO;}
{Comilla}  {return COMILLA;}
","  {return COMA;}
"("  {return PARENTESIS_ABIERTO;}
")"  {return PARENTESIS_CERRADO;}
"{"  {return LLAVE_ABIERTA;}
"}"  {return LLAVE_CERRADA;}
"_"  {return GUION_BAJO;}
"<" {return DIPLE_ABIERTO;}
">" {return DIPLE_CERRADO;}
"@" {return ARROBA_ABIERTO;}
"@" {return ARROBA_CERRADO;}
"si" {return SI;}
"contrasi" {return CONTRASI;}
"contra" {return CONTRA;}
"para" {return PARA;}
"hacer" {return HACER;}
"mientras" {return MIENTRAS;}
"caso" {return CASO;}
"es" {return ES;}
"cuando" {return CUANDO;}
"fin_" {return FIN_;}
"enotrocaso" {return ENOTROCASO;}
{VACIO} {return VACIO;}
"regresa" {return REGRESA;}
"escribe" {return ESCRIBE;}
"lee" {return LEE;}
"fontana" {return FONTANA;}
"valido" {return VALIDO;}
"falso" {return FALSO;}
"coleccion" {return COLECCION;}
{L}({L}|{D})* {lexeme=yytext(); return ID;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return ENT;}
{D}* {lexeme=yytext(); return NAT;}
"\""({D}|{L}|{S})*"\""|"\""{VACIO}"\"" {lexeme=yytext(); return RISTRA;}
{Comilla}({D}|{L}|{S}){Comilla}|({Comilla}{VACIO}{Comilla}) {lexeme=yytext(); return GRAF;}
. {return ERROR;}
