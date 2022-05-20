/*
 * Representa una carta, formada por un número y su palo correspondiente
 */

package solitario.Core;


public class Carta {
    
    private int numero;
    private Palos palo;
    private boolean bocaArriba;
    
    
    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba=false;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

     public boolean isBocaArriba() {
        return bocaArriba;
    }

    public void setBocaArriba(boolean bocaArriba) {
        this.bocaArriba = bocaArriba;
    }
    
    
    @Override
    public String toString() {
        StringBuilder toret= new StringBuilder();
        toret.append(getNumero()).append(" ").append(getPalo());
        return toret.toString() ;
    }
}

