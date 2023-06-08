package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

import it.uniba.game.nave.Coordinata;

import it.uniba.game.partita.Griglia;
import it.uniba.game.utility.Dimensioni;

import java.util.Random;



/**
 * CONTROL.
 *
 */

public class GrigliaLogic {
    private Griglia griglia;
    private static final Random RAND = new Random();
    /**
     * Costruttore della classe. Inizializza la griglia di gioco e posiziona le navi.
     * @param pRighe : numero di righe che la griglia dovra avere
     * @param pColonne : numero di colonne che la griglia dovra avere
     * @throws NumeroCoordinateException
     */
    public GrigliaLogic(final int pRighe, final int pColonne) throws NumeroCoordinateException {
        griglia = new Griglia(pRighe, pColonne);
        impostaNavi();
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
        RAND.setSeed(System.currentTimeMillis());
        int triga;
        int tcolonna;
        boolean esitoTrovato = false;

        do {
            do {
                triga = RAND.nextInt(griglia.getRighe());
                tcolonna = RAND.nextInt(griglia.getColonne());
            } while (!griglia.getCella(triga, tcolonna).equals("V"));
            boolean esitoR = false;
            if ((dimnave + triga) < griglia.getRighe()) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito) {
                    if (!griglia.getCella(triga, tcolonna).equals("V")) {
                        esito = false;
                    }
                    i++;
                }
                if (esito) {
                    esitoR = true;
                }
            }
            boolean esitoC = false;
            if ((dimnave + tcolonna) < griglia.getColonne() && !esitoR) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito) {
                    if (!griglia.getCella(triga, tcolonna + 1).equals("V")) {
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
                    griglia.setCella(triga + i, tcolonna, "N");
                    coordinate[i] = new Coordinata(triga + i, tcolonna);

                    i++;
                }
                return coordinate;

            } else if (esitoC) {
                esitoTrovato = true;
                int i = 0;
                Coordinata[] coordinate = new Coordinata[dimnave];
                while (i < dimnave) {
                    griglia.setCella(triga, tcolonna + i, "N");
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
     * coordinate rispetto alla sua dimensione
     */
    public void impostaNavi() throws NumeroCoordinateException {


        //Istanziamento delle navi di ogni tipo
        for (int i = 0; i < Dimensioni.valueOf("CACCIATORPEDINIERE").getEsemplari(); i++) {
            griglia.addNavi(trovaCellaVuota(Dimensioni.valueOf("CACCIATORPEDINIERE").getDim()),
                Dimensioni.valueOf("CACCIATORPEDINIERE").getIndex());
        }

        for (int i = 0; i < Dimensioni.valueOf("INCROCIATORE").getEsemplari(); i++) {
            griglia.addNavi(trovaCellaVuota(Dimensioni.valueOf("INCROCIATORE").getDim()),
            Dimensioni.valueOf("INCROCIATORE").getIndex());
        }

        for (int i = 0; i < Dimensioni.valueOf("CORAZZATA").getEsemplari(); i++) {
            griglia.addNavi(trovaCellaVuota(Dimensioni.valueOf("CORAZZATA").getDim()),
                Dimensioni.valueOf("CORAZZATA").getIndex());
        }

        for (int i = 0; i < Dimensioni.valueOf("PORTAEREI").getEsemplari(); i++) {
            griglia.addNavi(trovaCellaVuota(Dimensioni.valueOf("PORTAEREI").getDim()),
                Dimensioni.valueOf("PORTAEREI").getIndex());
        }

    }



    /**
     * Restituisce vero se tutte le navi sono state abbattute.
     *
     * @return vero se tutte le navi sono state abbattute
     */
    public boolean finepartita() {
        int numNavi = 0;
        int affondate = 0;
        for (int i = 0; i <  griglia.naviSize(); i++) {
            for (int j = 0; j <  griglia.getSize(i); j++) {
                numNavi++;
                if (griglia.getAffondata(i, j)) {
                    affondate++;
                }
            }
        }

        if (affondate == numNavi) {
            return true;
        }
        return false;
    }

    /**
     * Inserisce il colpo alla posizione inserita in input.
     *
     * @param riga : riga su cui si inserisce il colpo
     * @param colonna : colonna su cui inserisce il colpo
     * @return stato del colpo
     * @throws PosizioneException quando la posizione inserita è sbagliata
     */
    public String inserisciColpo(final int riga, final int colonna) throws PosizioneException {
        String stato = "";
        boolean esitoTrovato = false;
        int abbattuta = 0;
        for (int i = 0; i < griglia.naviSize() && !esitoTrovato; i++) {
            for (int j = 0; j < griglia.getSize(i)  && !esitoTrovato; j++) {
                for (int k = 0; k < griglia.getDim(i, j)  && !esitoTrovato; k++) {
                    if (griglia.getRiga(i, j, k) == riga && griglia.getColonna(i, j, k) == colonna) {

                        griglia.setColpito(i, j, k);
                        griglia.setCella(riga, colonna, "NC");
                        esitoTrovato = true;
                        stato = "C";
                    }
                    if (esitoTrovato) {
                        for (k = 0; k < griglia.getDim(i, j); k++) {
                            if (griglia.getColpito(i, j, k)) {
                                abbattuta++;
                            }
                        }
                    }
                    if (abbattuta == griglia.getDim(i, j)) {
                        griglia.setAffondata(i, j);
                        stato = stato + "A";
                    }
                }
            }
        }


        if (!esitoTrovato) {
            griglia.setCella(riga, colonna, "VC");
            stato = "V";
        }
        return stato;
    }

    public String getStatoCella(final int i, final int j) {
        return griglia.getCella(i, j);
    }

}
