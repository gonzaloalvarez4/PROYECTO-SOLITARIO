
package solitario.IU;

import java.util.Scanner;

/**
 *
 * @author AEDI
 */
public class ES
{
    public static Scanner leer = new Scanner(System.in);
    
    public static String pideCadena(String mensaje)
    {
         // Poner el mensaje
            System.out.print(mensaje);
               
             // Pedir
            return leer.nextLine().trim();
               
    }
    
    
        
    public static int pideNumero(String mensaje)
    {
        int i=-1;
        try{
            System.out.print(mensaje);
            i=Integer.parseInt(leer.nextLine().trim());}
        catch(NumberFormatException e){
     System.err.println("\n\t Formato de número incorrecto");}
    
            // Pedir
            return i;
       
    }
}
