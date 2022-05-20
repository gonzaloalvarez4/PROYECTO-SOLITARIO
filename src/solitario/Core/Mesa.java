/*
* Representa la mesa de juego, donde estarán todas las cartas.
* Tendrá dos partes diferenciadas:
* - la parte interior, donde inicialmente estarán colocadas las cartas correctamente para jugar al solitario
* - los montones exteriores, donde estarán colocadas las cartas por palo ordenadas de menor a mayor
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:
* - Una matriz de Pilas para representar la parte o montón interior 
* - Un array de Pilas para representar los montones exteriores.
* Funcionalidad: colocar las cartas para iniciar el juego, quitar una carta de la parte interior, colocar una carta en el interior,
* colocar una carta en el montón exterior correspondiente, visualizar cartas en la mesa, etc

La Pila es una estructura de datos que existe en Java y que se corresponde con la clase Stack. Por lo tanto debereis hacer uso de dicha
clase para representar la mesa de juego, y en particular de los métodos que se indican a continuación (de ser necesarios):

        public boolean empty();
        // Produce: Si la pila está vacía devuelve true, sino false.
        public Carta peek();
        // Produce: Devuelve la Carta del tope de la pila, sin eliminarla de ella.
        public Carta pop();
        // Produce: Elimina la Carta del tope de la pila y la devuelve.
        public void push(Carta item);
        // Produce: Introduce la Carta en el tope de la pila.
 */

package solitario.Core;

import java.util.Stack;
import static solitario.IU.Solitario.posiblePonerExterior;
import static solitario.IU.Solitario.posiblePonerInterior;

/**
 *
 * @author AEDI
 */
public class Mesa {
    private Stack<Carta> [][] montonInterior;
    private Stack<Carta> [] montonExterior;
    private Baraja baraja;
    private int filaorigen, columnaorigen;
   
    public Mesa(){
        this.montonInterior = new Stack[4][4];
        this.montonExterior = new Stack[4];
        this.baraja = new Baraja();
    }

    public Baraja getBaraja() {
        return baraja;
    }
    
    public void repartirCartas(){
        baraja.barajar();
        for(int i=0; i<4; i++){
            for(int j =0; j<4; j++){
                    montonInterior[i][j] = new Stack<Carta>();            
                    montonInterior[i][j].push(baraja.siguienteCarta());
            }
        }
        for(int h=0; h<4; h++){
                        montonInterior[h][h].push(baraja.siguienteCarta());
                        montonInterior[h][3-h].push(baraja.siguienteCarta());
        }
        for(int i=0; i<4; i++){
            for(int j =0; j<4; j++){
                    montonInterior[i][j].push(baraja.siguienteCarta());
                    getCartaMontonInterior(i, j).setBocaArriba(true);
            }
        }
        for(int i=0;i<4;i++){
        montonExterior[i]=new Stack<Carta>();}
    } 
    
    
    public boolean ponerCartaIN(Carta nueva, int f, int c){
        if (montonInterior[f][c].empty()){
            System.out.println("\n\t Pila vacia. No se puede colocar la carta en un espacio interior vacío.");
            montonInterior[filaorigen][columnaorigen].push(nueva);
            return false;
        }
            
        if (nueva.getPalo() == montonInterior[f][c].peek().getPalo()){
            if((nueva.getNumero()+1 == montonInterior[f][c].peek().getNumero())
                || (nueva.getNumero() == 7 
                    && montonInterior[f][c].peek().getNumero() == 10)){//Condiciones
                montonInterior[f][c].push(nueva);
                return true;
            }
        }
        else{
            System.out.println("\n\t No es posible colocar la carta aquí.");
            montonInterior[filaorigen][columnaorigen].push(nueva);}
        
        
        return false;
        
    }
    public boolean ponerCartaEX(Carta nueva, int c){
            if (montonExterior[c].empty()){
                if(nueva.getNumero()==1){
                   montonExterior[c].push(nueva);
                   return true;
                }
                else{
                        System.out.println("\n\t No es posible colocar la carta aquí. La primera carta de los montones"
                                + " exteriores debe ser un as(uno).");
                    montonInterior[filaorigen][columnaorigen].push(nueva);
                
                    return false;
                }
        }
            
            else if (nueva.getPalo() == montonExterior[c].peek().getPalo()){
            if((nueva.getNumero()-1 == montonExterior[c].peek().getNumero())
                || (nueva.getNumero() == 10 
                    && montonExterior[c].peek().getNumero() == 7)){//Condiciones
                montonExterior[c].push(nueva);
                return true;
            }
            else{
                System.out.println("\n\t No es posible colocar la carta aquí.");
                montonInterior[filaorigen][columnaorigen].push(nueva);
                return false;
            }
        }
        else{
            System.out.println("\n\t No es posible colocar la carta aquí.");
            montonInterior[filaorigen][columnaorigen].push(nueva);
        }
        
        return false;
        
    }

    public boolean montonesExterioresLlenos(){
        for(int i=0;i<4;i++){
            if(esMontonExteriorVacio(i)==true){
            return false;}
            else if(getCartaMontonExterior(i).getNumero()!=11){
           return false;}
                   }
        return true;}
    
    public boolean hayMovimientosPosibles(){
        Carta carta = null;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++){
        carta=getCartaMontonInterior(x, y);
        for (int c=0; c<4; c++){
            for (int f=0; f<4; f++){
            if(esMontonInteriorVacio(f, c)==false){
            if (carta.isBocaArriba()==false){
                 return true;}
            if(posiblePonerInterior(carta,f,c)==true || posiblePonerExterior(carta,c)==true){
                 return true;}
            }}}}}
    return false;}
    
    public boolean esMontonInteriorVacio(int f,int c){
    if(montonInterior[f][c].empty()==true){
        return true;}
    else{
        return false;}
    }
    
    public boolean esMontonExteriorVacio(int c){
    if(montonExterior[c].empty()==true){
        return true;}
    else{
        return false;}
    }
    
    public Carta getCartaMontonExterior(int p){
        if(esMontonExteriorVacio(p)==true){
        return null;}
        else{
    return montonExterior[p].peek();}
    }
    
    public Carta getCartaMontonInterior(int f, int c){
        if(esMontonInteriorVacio(f,c)==true){
        return null;}
        else{
    return montonInterior[f][c].peek();}
}
    
    public Carta sacarCartaMontonInterior(int f, int c){
         if(esMontonInteriorVacio(f,c)==true){
        return null;}
        else{
    filaorigen=f;
    columnaorigen=c;
    return montonInterior[f][c].pop();}
        }  

    
    @Override
    public String toString(){
        StringBuilder toret= new StringBuilder();
        toret.append("\n\t Zona Interior")
        .append("\n\t -------------------------------------------------\n");
        for(int i=0; i<4; i++){
            for(int j= 0; j<4; j++){
                if(montonInterior[i][j].empty()==false){
                    if(getCartaMontonInterior(i,j).isBocaArriba()==false){
                    toret.append("BA").append("   ");}
                    else{toret.append(montonInterior[i][j].peek()).append("   ");}}
                else{toret.append("\t");}
            }
            toret.append("\n");
        }
        toret.append("\n\t Zona Exterior")
        .append("\n\t -------------------------------------------------\n");
        for (int i=0; i<4; i++){
            if(montonExterior[i].empty()==false){
            toret.append(montonExterior[i].peek()).append("   ");}
             else{toret.append("\t");}
        }
        return toret.toString();
    }
}

