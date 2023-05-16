package it.uniba.game.partita;

import it.uniba.game.nave.*;

import java.util.ArrayList;
import java.util.Random;

import it.uniba.game.eccezioni.NumeroCoordinateException;

/**
 * Classe che definisce la griglia di gioco e la inizializza
 */
class Griglia {
    private int righe;
    private int colonne;

    private String griglia[][];
    private ArrayList<ArrayList<Nave>> navi;

    private int numNavi;

    /**
     * Inizializza la griglia di gioco
     * 
     * @param righe   : numero di righe della griglia
     * @param colonne : numero di colonne della griglia
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *                                   coordinate
     *                                   rispetto alla sua dimensione
     */
    public Griglia(int righe, int colonne) throws NumeroCoordinateException {
        this.righe = righe;
        this.colonne = colonne;
        this.griglia = new String[this.righe][this.colonne];
        for (int i = 0; i < this.griglia.length; i++)
            for (int j = 0; j < this.griglia.length; j++)
                this.griglia[i][j] = new String("V");

        impostaNavi();
        this.numNavi = setnumnavi();

    }

    /**
     * Metodo che restituisce il numero di righe della griglia
     * 
     * @return numero di righe
     */
    int getRighe() {
        return this.righe;
    }

    /**
     * Metodo che restituisce il numero di colonne della griglia
     * 
     * @return numero di colonne
     */
    int getColonne() {
        return this.colonne;
    }

    /**
     * Restituisce un array di coordinate consecutive prendendo
     * in input la dimensione di tale array considerando che le posizioni
     * siano disponibili
     * 
     * @param dimnave : dimensione della nave su cui trovare celle vuote
     * @return un array di coordinate consecutive
     */
    private Coordinata[] trovaCellaVuota(int dimnave) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int triga;
        int tcolonna;
        boolean esitoTrovato = false;

        do {
            do {
                triga = rand.nextInt(this.righe);
                tcolonna = rand.nextInt(this.colonne);

            } while (!this.griglia[triga][tcolonna].equals("V"));
            boolean esitoR = false;
            if ((dimnave + triga) < this.righe) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito == true) {
                    if (!this.griglia[triga + i][tcolonna].equals("V")) {
                        esito = false;
                    }
                    i++;
                }
                if (esito == true) {
                    esitoR = true;
                }
            }
            boolean esitoC = false;
            if ((dimnave + tcolonna) < this.colonne && esitoR == false) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito == true) {
                    if (!this.griglia[triga][tcolonna + i].equals("V")) {
                        esito = false;
                    }
                    i++;
                }
                if (esito == true) {
                    esitoC = true;
                }
            }
            if (esitoR == true) {
                esitoTrovato = true;
                int i = 0;
                Coordinata coordinate[] = new Coordinata[dimnave];
                while (i < dimnave) {
                    this.griglia[triga + i][tcolonna] = "N";
                    coordinate[i] = new Coordinata(triga + i, tcolonna);
                    i++;
                }
                return coordinate;

            } else if (esitoC == true) {
                esitoTrovato = true;
                int i = 0;
                Coordinata coordinate[] = new Coordinata[dimnave];
                while (i < dimnave) {
                    this.griglia[triga][tcolonna + i] = "N";
                    coordinate[i] = new Coordinata(triga, tcolonna + i);
                    i++;
                }
                return coordinate;
            }
        } while (esitoTrovato == false);
        return null;
    }

    /**
     * Imposta la posizione della navi sulla Griglia casualmente
     * 
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *                                   coordinate
     *                                   rispetto alla sua dimensione
     */
    private void impostaNavi() throws NumeroCoordinateException {
        this.navi = new ArrayList<ArrayList<Nave>>();
        for (int i = 0; i < 4; i++)
            this.navi.add(i, new ArrayList<Nave>());

        for (int i = 0; i < 2; i++)
            this.navi.get(0).add(new Cacciatorpediniere(trovaCellaVuota(2)));

        for (int i = 0; i < 3; i++)
            this.navi.get(1).add(new Incrociatore(trovaCellaVuota(3)));

        for (int i = 0; i < 2; i++)
            this.navi.get(2).add(new Corazzata(trovaCellaVuota(4)));

        for (int i = 0; i < 1; i++)
            this.navi.get(3).add(new Portaerei(trovaCellaVuota(5)));

    }

    /**
     * Imposta numero delle navi
     * 
     * @return numero delle navi
     */
    private int setnumnavi() {
        int numNavi = 0;
        for (int i = 0; i < this.navi.size(); i++)
            for (int j = 0; j < this.navi.get(i).size(); j++)
                numNavi = numNavi + this.navi.get(j).size();
        return numNavi;

    }

    /**
     * Descrive lo stato della Griglia
     * 
     * @return stato di Griglia
     */
    public String toString() {
        StringBuilder griglia = new StringBuilder("");
        for (int i = 0; i < this.griglia.length; i++) {
            for (int j = 0; j < this.griglia[i].length; j++) {
                griglia.append(this.griglia[i][j] + " ");
            }
            griglia.append("\n");
        }
        return griglia.toString();
    }

    /**
     * Restituisce vero se tutte le navi sono state abbattute
     * 
     * @return vero se tutte le navi sono state abbattute
     */
    boolean finepartita() {
        return false;
    }

    /**
     * Inserisce il colpo alla posizione inserita in input
     * 
     * @param riga    : riga su cui si inserisce il colpo
     * @param colonna : colonna su cui inserisce il colpo
     */
    void inserisciColpo(int riga, int colonna) {
    }

    /**
     * Restituisce una cella della Griglia
     * 
     * @param i : numero di riga della cella della griglia da restituire
     * @param j : numero di colonna della cella della griglia da restituire
     * @return singola cella della Griglia
     */
    public String getCella(int i, int j) {
        return griglia[i][j];
    }

}
