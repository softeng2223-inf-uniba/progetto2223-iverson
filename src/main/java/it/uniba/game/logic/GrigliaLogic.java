package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.nave.Cacciatorpediniere;
import it.uniba.game.nave.Coordinata;
import it.uniba.game.nave.Corazzata;
import it.uniba.game.nave.Incrociatore;
import it.uniba.game.nave.Nave;
import it.uniba.game.nave.Portaerei;
import it.uniba.game.partita.Griglia;
import it.uniba.game.utility.Dimensioni;

import java.util.ArrayList;
import java.util.Random;



/**
 * CONTROL
 * 
 */

public class GrigliaLogic {
    private Griglia griglia;
    private static final Random RAND = new Random();
    /**
     * Costruttore della classe. Inizializza la griglia di gioco e posiziona le navi
     * @param pRighe : numero di righe che la griglia dovra avere
     * @param pColonne : numero di colonne che la griglia dovra avere
     * @throws NumeroCoordinateException
     */
    public GrigliaLogic(final int pRighe, final int pColonne) throws NumeroCoordinateException{
        griglia = new Griglia(pRighe, pColonne);
        impostaNavi();
    }

/**
 * 
 * @return griglia rappresentante la mappa di gioco
 */
    public Griglia getGriglia(){
        return griglia;
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
            } while (!griglia.getCella(triga,tcolonna).equals("V"));
            boolean esitoR = false;
            if ((dimnave + triga) < griglia.getRighe()) {
                boolean esito = true;
                int i = 0;
                while (i < dimnave && esito) {
                    if (!griglia.getCella(triga,tcolonna).equals("V")) {
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
                    if (!griglia.getCella(triga,tcolonna+1).equals("V")) {
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
                    
                    griglia.setCella(triga+1, tcolonna, "N");
                    coordinate[i] = new Coordinata(triga + i, tcolonna);
                    i++;
                }
                return coordinate;

            } else if (esitoC) {
                esitoTrovato = true;
                int i = 0;
                Coordinata[] coordinate = new Coordinata[dimnave];
                while (i < dimnave) {
                    griglia.setCella(triga, tcolonna+1, "N");;
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

        int tipiNavi = Dimensioni.values().length;
        // Istanziamento dei tipi di navi
        for (int i = 0; i < tipiNavi; i++) {
            griglia.getNavi().add(i, new ArrayList<Nave>());
        }

        //Istanziamento delle navi di ogni tipo
        for (int i = 0; i < Dimensioni.valueOf("CACCIATORPEDINIERE").getEsemplari(); i++) {
            griglia.getNavi().get(Dimensioni.valueOf("CACCIATORPEDINIERE").getIndex()).add(new Cacciatorpediniere(
                trovaCellaVuota(Dimensioni.valueOf("CACCIATORPEDINIERE").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("INCROCIATORE").getEsemplari(); i++) {
            griglia.getNavi().get(Dimensioni.valueOf("INCROCIATORE").getIndex()).add(new Incrociatore(
                trovaCellaVuota(Dimensioni.valueOf("INCROCIATORE").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("CORAZZATA").getEsemplari(); i++) {
            griglia.getNavi().get(Dimensioni.valueOf("CORAZZATA").getIndex()).add(new Corazzata(
                trovaCellaVuota(Dimensioni.valueOf("CORAZZATA").getDim())));
        }
        for (int i = 0; i < Dimensioni.valueOf("PORTAEREI").getEsemplari(); i++) {
            griglia.getNavi().get(Dimensioni.valueOf("PORTAEREI").getIndex()).add(new Portaerei(
                trovaCellaVuota(Dimensioni.valueOf("PORTAEREI").getDim())));
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
        for (int i = 0; i <  griglia.getNavi().size(); i++) {
            for (int j = 0; j <  griglia.getNavi().get(i).size(); j++) {
                numNavi++;
                if ( griglia.getNavi().get(i).get(j).getaffondata()) {
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
        for (int i = 0; i < griglia.getNavi().size() && !esitoTrovato; i++) {
            for (int j = 0; j < griglia.getNavi().get(i).size()  && !esitoTrovato; j++) {
                for (int k = 0; k < griglia.getNavi().get(i).get(j).getdim()  && !esitoTrovato; k++) {
                    if (griglia.getNavi().get(i).get(j).getcoordinate(k).getriga() == riga
                            && griglia.getNavi().get(i).get(j).getcoordinate(k).getcolonna() == colonna) {

                        griglia.getNavi().get(i).get(j).getcoordinate(k).setcolpito();
                        griglia.setCella(riga,colonna,"NC");
                        esitoTrovato = true;
                        stato = "C";
                    }
                    if (esitoTrovato) {
                        for (k = 0; k < griglia.getNavi().get(i).get(j).getdim(); k++) {
                            if (griglia.getNavi().get(i).get(j).getcoordinate(k).getcolpito()) {
                                abbattuta++;
                            }
                        }
                    }
                    if (abbattuta == griglia.getNavi().get(i).get(j).getdim()) {
                        griglia.getNavi().get(i).get(j).setaffondata();
                        stato = stato + "A";
                    }
                }
            }
        }


        if (!esitoTrovato) {
            griglia.setCella(riga,colonna,"VC");
            stato = "V";
        }
        return stato;
    }



}