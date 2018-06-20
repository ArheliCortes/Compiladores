package mx.ipn.logica.ALexico;
/*Comentario de prueba*/
import java.io.File;


public class Alexico {
  
    public static void main(String[] args) {
        String path="C:/Users/arhel/Documents/NetBeansProjects/Proyecto_Compilador/src/mx/ipn/logica/ALexico/Lexer.flex";
        generar(path);
    }
    
    public static void generar(String path){
     
        File file = new File (path);
       JFlex.Main.generate(file);
   
    }
}
