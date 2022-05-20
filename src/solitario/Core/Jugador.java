/*
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */
package solitario.Core;

import solitario.IU.ES;

public class Jugador {
	
	private String nombre;
        
        public Jugador(String nombre){
            
            this.nombre = nombre;
        }
        
        public void setNombre(String nombre){
            
            this.nombre = nombre;
        }
        
        public String getNombre(){
            return nombre;
        }
        
        
        public Carta cogerCartaMontonInterior(Mesa mesa){
        System.out.println("\n\tIntroduce la fila y la columna de la carta a seleccionar.");
        int f = -1;
        int c= -1;
     do{
         f=ES.pideNumero("Fila:");   
         c=ES.pideNumero("Columna:");
          if(f<0 && f>3){
              System.out.println("\n\t El número de fila introducido es incorrecto.");
          }  
          if(c<0 && c>3){
              System.out.println("\n\t El número de columna introducido es incorrecto.");
          }
     }
          while(c<0 && c>3 && f<0 && f>3);
     if(mesa.esMontonInteriorVacio(f, c)==true){
         System.out.println("La posición elgida está vacía.");
         return null;}
     else{
     return mesa.sacarCartaMontonInterior(f, c);}
        }
        
        
        public void voltearCarta(Mesa mesa){
            System.out.println("\n\tIntroduce la fila y la columna de la carta a voltear.");
        int f = -1;
        int c = -1;
     do{
         f=ES.pideNumero("Fila:");   
         c=ES.pideNumero("Columna:");
          if(f<0 && f>3){
              System.out.println("\n\t El número de fila introducido es incorrecto.");
          }  
          if(c<0 && c>3){
              System.out.println("\n\t El número de columna introducido es incorrecto.");
          }  
          
       }
          while(c<0 && c>3 && f<0 && f>3);
    if(mesa.esMontonInteriorVacio(f, c)==true){
         System.out.println("La posición elgida está vacía.");}
     else{
         if(mesa.getCartaMontonInterior(f, c).isBocaArriba()){
         System.out.println("La carta ya está boca arriba.");}
         else{
        mesa.getCartaMontonInterior(f, c).setBocaArriba(true);
            }
        }
    }


       public void moverCartaAlInterior(Mesa mesa,Carta carta){
            int f = -1;
            int c = -1;
               f = ES.pideNumero("\n\t Introduce la fila de la posición a la que desea mover la carta: ");
               c = ES.pideNumero("\n\t Introduce la columna de la posición a la que se desea mover la carta: ");
               if(f<0 && f>3){
                      System.out.println("\n\t El número de fila introducido es incorrecto.");
                }  
               else if(c<0 && c>3){
                    System.out.println("\n\t El número de columna introducido es incorrecto.");
                  }  
          
               else if(mesa.ponerCartaIN(carta, f,c)){
                   System.out.println("\n\t Movimiento realizado correctamente ");}
       }
       
            public void moverCartaAlExterior(Mesa mesa,Carta carta){
                int f=-1;
               f= ES.pideNumero("\n\t Introduce la fila de la posición a la que se desea mover la carta: ");
               if(mesa.ponerCartaEX(carta, f)){
                   System.out.println("\n\t Movimiento realizado correctamente ");}   
           }
            }
       
        

