%{
#include <stdio.h>
#include <conio.h>
#include "C:\Users\itzel\OneDrive\Documentos\Compiladores\Compiladores\Bison\analexico.h"
%}

%option noyywrap
%option yylineno

ignora " "|\t|\n
letra [A-Za-z]
digito  [0-9]
booleano "valido"|"invalido"

%%

{ignora}*			{;}
"."					{return ('.');}
"_"					{return ('_');}
","					{return (',');}
")"					{return (')');}
"("					{return ('(');}
"@"				{return ('@');}
"<"				{return ('<');}
">"				{return ('>');}
"si"				{return SI;}
"contrasi"			{return CONTRASI;}
"contra"				{return CONTRA;}
"para"			        {return PARA;}
"hacer"			        {return HACER;}
"mientras"			        {return MIENTRAS;}
"caso"			        {return CASO;}
"es"			        {return ES;}
"cuando"			        {return CUANDO;}
"fin"			        {return FIN;}
"enotrocaso"			{return ENOTROCASO;}
"vacio"				{return VACIO;}
"fontana"			{return FONTANA;}
"ent"			{return ENT;}
"ristra"			{return RISTRA;}
"graf"			{return GRAF;}
"rac"			{return RAC;}
"nat"			{return NAT;}
"%n"				{return FORMATO;}
"%r"				{return FORMATO;}
"%d"				{return FORMATO;}
"+"				{return SUMA;}
"*"  				{return MUL;}
"-"  				{return RES;}
"/"  				{return DIV;}
"%"  				{return MOD;}
":="  				{return ASIGNAR;}
":+"  				{return ASIGNARMAS;}
":-"  				{return ASIGNARMENOS;}
":*"  				{return ASIGNARPOR;}
":/"  				{return ASIGNARDIV;}
"::" 				{return IGUAL;}
"!=" 				{return DIFERENTE;}
">::"  				{return MAYORIGUAL;}
"<::"  				{return MENORIGUAL;}
"++"				{return POSINCREMENTO;}
"--"				{return POSDECREMENTO;}
{digito}+				{return ENTERO;}
{digito}+"."{digito}			{return RACIONAL;}
{booleano}			{return BOOLEANO;}
{letra} 				{return GRAFEMA;}
"\""({digito}|{letra}|" ")*"\""                {return RISTRAS;}
{letra}({letra}|(digito))*			{return NOMBRE;}
.				{printf("Error en linea: %d\n",yylineno);}

%%

yyerror(char * msg)
{
printf("%s\n",msg);
}

int main(void)
{
char NombreArchivo[50];
printf("Ruta del archivo: ");
gets(NombreArchivo);
yyin=fopen(NombreArchivo,"rt");
if(yyin==NULL)
printf("\nNo se puede leer el archivo");
else
yyparse();
fclose(yyin);
getch();
}
