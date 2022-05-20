/**
 * Representa el juego del solitario, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package solitario.IU;

import solitario.Core.Baraja;
import solitario.Core.Carta;
import solitario.Core.Jugador;
import solitario.Core.Mesa;
import solitario.Core.Palos;


/**
 *
 * @author AEDI
 */
public class Solitario {
   private static final Mesa mesa=new Mesa();
   private static final Jugador jugador=new Jugador("Jugador");
  
   
   
public static void inicioPartida(){
    System.out.println("ANOTACIÓNES:\n");
    System.out.println("TANTO LAS FILAS COMO LAS COLUMNAS SE NUMERAN DEL 0 AL 3.\n");
    System.out.println("CUANDO UNA CARTA SE ENCUENTRA BOCA ABAJO, SE MUESTRA EN PANTALLA COMO BA.\n");
     nombreJugador();
     menuInicial();
     do{
     switch (menuJuego()){
        case 1:
            moverCartaIn();
            break;
        case 2:
            moverCartaEx();
            break;
        case 3:
            voltearCarta();
            break;}
     }
     while(finJuego()==false);
     System.out.println(finJuego());
} 


    public static void menuInicial(){
     int i = 0;
     do{
         System.out.println("\n\t Elige opción(1 o 2):");
         System.out.println("\n\t 1.Repartir cartas e iniciar partida.");
         System.out.println("\n\t 2.Salir.");
         i=ES.pideNumero(" ");
          if(i!=1&&i!=2){
              System.out.println("\n\t El número introducido es incorrecto.");
          }  
       }
          while(i!=1&&i!=2);
     if(i==2){
          System.exit(-1);}
     else{
     mesa.getBaraja();
     mesa.repartirCartas();
     
     }
     }
    
    public static void nombreJugador(){
        jugador.setNombre(ES.pideCadena("\n\t Introduce el nombre del jugador:"));}

    
    public static int menuJuego(){
     int i = 0;
        System.out.println(mesa.toString());
     do{
         System.out.println("Elige opción(1,2,3):");
         System.out.println("\n\t 1.Mover carta al montón interior.");
         System.out.println("\n\t 2.Mover cara al montón exterior.");
         System.out.println("\n\t 3.Darle la vuelta a una carta.");
         i=ES.pideNumero(" ");
          if(i!=1 && i!=2 && i!=3){
              System.out.println("\n\t El número introducido es incorrecto.");
          }}
          while(i!=1 && i!=2 && i!=3);
    return i;
    }
    
    
    public static void moverCartaIn(){
        Carta c=jugador.cogerCartaMontonInterior(mesa);
        jugador.moverCartaAlInterior(mesa,c);
    }
    
    public static void moverCartaEx(){
     Carta c=jugador.cogerCartaMontonInterior(mesa);
     jugador.moverCartaAlExterior(mesa,c);}
    
    public static void voltearCarta(){
       jugador.voltearCarta(mesa);
    }
 
    public static boolean posiblePonerInterior(Carta nueva, int f, int c){
        if (mesa.esMontonInteriorVacio(f,c)){
                   return false;}
        
        if (nueva.getPalo() == mesa.getCartaMontonInterior(f,c).getPalo()){
            if((nueva.getNumero()+1 == mesa.getCartaMontonInterior(f,c).getNumero())
                || (nueva.getNumero() == 7 
                    && mesa.getCartaMontonInterior(f,c).getNumero() == 10)){
                return true; }
        }
        return false;
    }
    
     public static boolean posiblePonerExterior(Carta nueva, int c){
            if (mesa.esMontonExteriorVacio(c)){
                if(nueva.getNumero()==1){
                   return true;}
                   else{return false;}
                }
        if (nueva.getPalo() == mesa.getCartaMontonExterior(c).getPalo()){
            if((nueva.getNumero()-1 == mesa.getCartaMontonExterior(c).getNumero())
                || (nueva.getNumero() == 10 
                    && mesa.getCartaMontonExterior(c).getNumero() == 7)){
                return true;    
        }}
        return false;
    }
    
    public static boolean finJuego(){
        boolean finJuego=false;
        if(mesa.montonesExterioresLlenos()==true){
        finJuego=true ;
            System.out.println("\n\t Felicidades!! You win!!");
           }
        if(mesa.hayMovimientosPosibles()==false){
        finJuego=true;
            System.out.println("\n\t Game over. No hay más movimientos posibles.");}
        return finJuego;}
    
    }
    

