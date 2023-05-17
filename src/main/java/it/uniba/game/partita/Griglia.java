package it.uniba.game.partita;

import it.uniba.game.nave.Cacciatorpediniere;
import it.uniba.game.nave.Coordinata;
import it.uniba.game.nave.Corazzata;
import it.uniba.game.nave.Incrociatore;
import it.uniba.game.nave.Nave;
import it.uniba.game.nave.Portaerei;

import it.uniba.game.utility.Dimensioni;

import java.util.ArrayList;
import java.util.Random;

import it.uniba.game.eccezioni.NumeroCoordinateException;

/**
 * Classe che definisce la griglia di gioco e la inizializza.
 */
class Griglia {
    private int righe;
    private int colonne;

    private String[][] griglia;
    private ArrayList<ArrayList<Nave>> navi;

    private int numNavi;

    /**
     * Inizializza la griglia di gioco.
     *
     * @param pRighe   : numero di righe della griglia
     * @param pColonne : numero di colonne della griglia
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    Griglia(final int pRighe, final int pColonne) throws NumeroCoordinateException {
        this.righe = pRighe;
        this.colonne = pColonne;
        this.griglia = new String[this.righe][this.colonne];
        for (int i = 0; i < this.griglia.length; i++) {
            for (int j = 0; j < this.griglia.length; j++) {
                this.griglia[i][j] = new String("V");
            }
        }

        impostaNavi();
        this.numNavi = setnumnavi();

    }

    /**
     * Metodo che restituisce il numero di righe della griglia.
     *
     * @return numero di righe
     */
    int getRighe() {
        return this.righe;
    }

    /**
     * Metodo che restituisce il numero di colonne della griglia.
     *
     * @return numero di colonne
     */
    int getColonne() {
        return this.colonne;
    }

    /**
     * Restituisce un array di coordinate consecutive prendendo
     * in input la dimensione di tale array considerando che le posizioni
     * siano disponibili.
     *
     * @param dimnave : dimensione della nave su cui trovare celle vuote
     * @return un array di coordinate consecutive
     */
    private Coordinata[] trovaCellaVuota(final int dimnave) {
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
                while (i < dimnave && esito) {
                    if (!this.griglia[triga + i][tcolonna].equals("V")) {
                        esito = false;
                    }
                    i++;
                }
                if (esito) {
                    esitoR = true;
                }
            }
            boolean esitoC = false;
            if ((dimnave + tcolonna) < this.colonne && !esitoR) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito) {
                    if (!this.griglia[triga][tcolonna + i].equals("V")) {
                        esito = false;
                    }
                    i++;
                }
                if (esito) {
                    esitoC = true;
                }
            }
            if (esitoR) {
                esitoTrovato = true;
                int i = 0;
                Coordinata[] coordinate = new Coordinata[dimnave];
                while (i < dimnave) {
                    this.griglia[triga + i][tcolonna] = "N";
                    coordinate[i] = new Coordinata(triga + i, tcolonna);
                    i++;
                }
                return coordinate;

            } else if (esitoC) {
                esitoTrovato = true;
                int i = 0;
                Coordinata[] coordinate = new Coordinata[dimnave];
                while (i < dimnave) {
                    this.griglia[triga][tcolonna + i] = "N";
                    coordinate[i] = new Coordinata(triga, tcolonna + i);
                    i++;
                }
                return coordinate;
            }
        } while (!esitoTrovato);
        return null;
    }

    /**
     * Imposta la posizione della navi sulla Griglia casualmente.
     *
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *                                   coordinate
     *                                   rispetto alla sua dimensione
     */
    private void impostaNavi() throws NumeroCoordinateException {
        this.navi = new ArrayList<ArrayList<Nave>>();
        int tipiNavi = Dimensioni.values().length;
        // Istanziamento dei tipi di navi
        for (int i = 0; i < tipiNavi; i++) {
            this.navi.add(i, new ArrayList<Nave>());
        }

        //Istanziamento delle navi di ogni tipo
        for (int i = 0; i < Dimensioni.valueOf("CACCIATORPEDINIERE").getEsemplari(); i++) {
            this.navi.get(Dimensioni.valueOf("CACCIATORPEDINIERE").getIndex()).add(new Cacciatorpediniere(
                trovaCellaVuota(Dimensioni.valueOf("CACCIATORPEDINIERE").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("INCROCIATORE").getEsemplari(); i++) {
            this.navi.get(Dimensioni.valueOf("INCROCIATORE").getIndex()).add(new Incrociatore(
                trovaCellaVuota(Dimensioni.valueOf("INCROCIATORE").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("CORAZZATA").getEsemplari(); i++) {
            this.navi.get(Dimensioni.valueOf("CORAZZATA").getIndex()).add(new Corazzata(
                trovaCellaVuota(Dimensioni.valueOf("CORAZZATA").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("PORTAEREI").getEsemplari(); i++) {
            this.navi.get(Dimensioni.valueOf("PORTAEREI").getIndex()).add(new Portaerei(
                trovaCellaVuota(Dimensioni.valueOf("PORTAEREI").getDim())));
        }

    }

    /**
     * Imposta numero delle navi.
     *
     * @return pNumNavi numero delle navi
     */
    private int setnumnavi() {
        int pNumNavi = 0;
        for (int i = 0; i < this.navi.size(); i++) {
            for (int j = 0; j < this.navi.get(i).size(); j++) {
                pNumNavi = pNumNavi + this.navi.get(j).size();
            }
        }
        return pNumNavi;

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
     * Restituisce vero se tutte le navi sono state abbattute.
     *
     * @return vero se tutte le navi sono state abbattute
     */
    boolean finepartita() {
        return true;
    }

    /**
     * Inserisce il colpo alla posizione inserita in input.
     *
     * @param riga    : riga su cui si inserisce il colpo
     * @param colonna : colonna su cui inserisce il colpo
     */
    void inserisciColpo(final int riga, final int colonna) {
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

}
