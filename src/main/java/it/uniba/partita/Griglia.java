package partita;
import nave.*;

import java.util.ArrayList;

/**
 * Classe che definisce la griglia di gioco e la inizializza
 */
    class Griglia {
    private int righe;
    private int colonne;

    private String griglia[][];
    private ArrayList<ArrayList<Nave>> navi;

    public ArrayList<ArrayList<Nave>> getNavi() {
        return navi;
    }



    /**
     * Inizializza la griglia di gioco
     * @param righe : numero di righe della griglia
     * @param colonne : numero di colonne della griglia
     * 
     */
    public Griglia(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.griglia = new String[this.righe][this.colonne];
        for(int i=0; i < this.griglia.length; i++)
            for ( int j = 0; j < this.griglia.length ; j++)
                this.griglia[i][j] = new String("V");
        
        
    }
         
   

    /**
	 * Restituisce una cella della Griglia
     * @param i : numero di riga della cella della griglia da restituire
     * @param j : numero di colonna della cella della griglia da restituire
	 * @return singola cella della Griglia
	 */
    public String getCella(int i,int j){

        return griglia[i][j];

    }
	/**
	 * Descrive lo stato della Griglia
	 * @return stato di Griglia
	 */
    public String toString() {
        StringBuilder griglia = new StringBuilder("");
        for(int i = 0; i < this.griglia.length; i++) {
            for(int j = 0; j < this.griglia[i].length; j++) {
                griglia.append(this.griglia[i][j] + " ");
            }
            griglia.append("\n");
         }
         return griglia.toString();
    }   


}
