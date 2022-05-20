/*
* Representa la baraja española, 40 cartas, 4 palos, valores de las cartas de 1 a 12 (excepto 8 y 9). 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package solitario.Core;

public class Baraja {
    
    private Carta cartas[];
    private int posSiguienteCarta;
    
    public static final int LIMITE_CARTA_PALO=12;
    public static final int NUM_CARTAS=40;
    
public Baraja() {
        this.cartas= new Carta[NUM_CARTAS];
        this.posSiguienteCarta=0;
        for(Palos p:Palos.values()){
            
            for(int j=0;j<LIMITE_CARTA_PALO;j++){
                
                if( !( j==7 || j==8 )){
                    if(j>=9){
                        cartas[((p.ordinal()* (LIMITE_CARTA_PALO-2))+(j-2))]= new Carta (j+1, p);
                    }
                    else{
                        cartas[((p.ordinal()* (LIMITE_CARTA_PALO-2))+j)]= new Carta (j+1, p);
                    }
                }   
            }   
        } 
    }


public void barajar (){
    int posAleatoria= 0;
    Carta c=null;
    
    for (int i=0;i<cartas.length;i++){
        posAleatoria= Metodos.generaNumeroEnteroAleatorio(0, NUM_CARTAS-1);
        
        c= cartas[i];
        cartas[i] = cartas [posAleatoria];
        cartas[posAleatoria]= c;
    }
    
    this.posSiguienteCarta= 0; //Con esto la posicion vuelve al principio
}


public Carta siguienteCarta (){ // Devuelve la cartadnd se encuentre "posSiguienteCarta" 
    
    Carta c= null;
    if (posSiguienteCarta == NUM_CARTAS){
        System.out.println("\n\t Ya no hay cartas, debes barajar de nuevo");
    } else {
        c= cartas [posSiguienteCarta];
        posSiguienteCarta++;
    }
 return c;
}


public int cartasDisponible(){//(Nos indica el numero de cartas que hay disponibles)
    return NUM_CARTAS-posSiguienteCarta;
}




private static class Metodos{ // muestra las cartas que aun no han salido

    private static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
        }

    }

}