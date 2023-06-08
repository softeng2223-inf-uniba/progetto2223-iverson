package it.uniba.game.partita;


import it.uniba.game.nave.Cacciatorpediniere;
import it.uniba.game.nave.Coordinata;
import it.uniba.game.nave.Corazzata;
import it.uniba.game.nave.Incrociatore;
import it.uniba.game.nave.Nave;
import it.uniba.game.nave.Portaerei;
import it.uniba.game.utility.Dimensioni;

import java.util.ArrayList;


import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

/**
 * <<Entity>> Classe che definisce la griglia di gioco e tutte le navi posizionate su di essa.
 */
public class Griglia {
    private int righe;
    private int colonne;
    private String[][] griglia;
    private ArrayList<ArrayList<Nave>> navi;



    /**
     * Inizializza la griglia di gioco.
     *
     * @param pRighe   : numero di righe della griglia
     * @param pColonne : numero di colonne della griglia
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    public Griglia(final int pRighe, final int pColonne) throws NumeroCoordinateException {

        this.righe = pRighe;
        this.colonne = pColonne;
        this.griglia = new String[this.righe][this.colonne];
        for (int i = 0; i < this.griglia.length; i++) {
            for (int j = 0; j < this.griglia.length; j++) {
                this.griglia[i][j] = "V";
            }
        }

        this.navi = new ArrayList<ArrayList<Nave>>();
        int tipiNavi = Dimensioni.values().length;
        // Istanziamento dei tipi di navi
        for (int i = 0; i < tipiNavi; i++) {
           this.navi.add(i, new ArrayList<Nave>());
        }

    }

    /**
     * Metodo che restituisce il numero di righe della griglia.
     *
     * @return numero di righe
     */
    public int getRighe() {
        return this.righe;
    }

    /**
     * Metodo che restituisce il numero di colonne della griglia.
     *
     * @return numero di colonne
     */
    public int getColonne() {
        return this.colonne;
    }


    /**
     * Descrive lo stato della Griglia.
     *
     * @return stato di Griglia
     */
    public String toString() {
        StringBuilder strGriglia = new StringBuilder("");
        for (int i = 0; i < this.griglia.length; i++) {
            for (int j = 0; j < this.griglia[i].length; j++) {
                strGriglia.append(this.griglia[i][j] + " ");
            }
            strGriglia.append("\n");
        }
        return strGriglia.toString();
    }


    /**
     * Restituisce una cella della Griglia.
     *
     * @param i : numero di riga della cella della griglia da restituire
     * @param j : numero di colonna della cella della griglia da restituire
     * @return singola cella della Griglia
     */
    public String getCella(final int i, final int j) {
        return griglia[i][j];
    }

       /**
     * Restituisce l'oggetto nave.
     *
     * @return singola cella della Griglia
     * @throws NumeroCoordinateException
     */
    public void addNavi(final Coordinata[] coordinata, final int index) throws NumeroCoordinateException {
        switch (index) {
            case 0:
                this.navi.get(index).add(new Cacciatorpediniere(coordinata));

                break;
            case 1:
                this.navi.get(index).add(new Incrociatore(coordinata));

                break;
            case 2:
                this.navi.get(index).add(new Corazzata(coordinata));

                break;
            default:
                this.navi.get(index).add(new Portaerei(coordinata));
                
                break;
        }
    }

    /**
     * Modifica una cella della Griglia.
     * @param i : numero di riga della cella da modificare
     * @param j : numero di collona della cella da modificare
     * @param str : stringa da inserire nella cella
     */
    public void setCella(final int i, final int j, final String str) {
        this.griglia[i][j] = str;
    }

    public int naviSize() {
        return navi.size();
    }

    public int getSize(final int i) {
        return this.navi.get(i).size();
    }

    public int getDim(final int i, final int j) {
        return this.navi.get(i).get(j).getdim();
    }

    public void setAffondata(final int i, final int j) {
        this.navi.get(i).get(j).setaffondata();
    }

     public boolean getAffondata(final int i, final int j) {
        return this.navi.get(i).get(j).getaffondata();
    }

    public int getRiga(final int i, final int j, final int k) throws PosizioneException {
        return this.navi.get(i).get(j).getcoordinate(k).getriga();
    }

    public int getColonna(final int i, final int j, final int k) throws PosizioneException {
        return this.navi.get(i).get(j).getcoordinate(k).getcolonna();
    }

    public boolean getColpito(final int i, final int j, final int k) throws PosizioneException {
        return this.navi.get(i).get(j).getcoordinate(k).getcolpito();
    }

    public void setColpito(final int i, final int j, final int k) throws PosizioneException {
        this.navi.get(i).get(j).getcoordinate(k).setcolpito();
    }
}
