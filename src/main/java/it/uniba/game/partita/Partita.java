package it.uniba.game.partita;

import java.util.HashMap;
import java.util.Map;


import it.uniba.game.utility.Difficolta;
import it.uniba.game.utility.Tabella;

/**
 * Classe che inizializza una Partita e la sua relativa Griglia di gioco.
 */
public class Partita {
    private int numMaxErrori;
    private int colpiTotali;
    private int erroriCorrenti;
    private boolean inCorso;
    private String livello;
    private Map<String, Integer> erroriPerLivello;
    private int dimMax;
    private int tempoMax = 0;
    private long startTime;

    /**
     * Inizializza una Partita.
     */
    public Partita() {
        this.inCorso = false;
        this.erroriCorrenti = 0;
        this.colpiTotali = 0;
        this.livello = "FACILE";
        this.erroriPerLivello = new HashMap<String, Integer>();
        this.erroriPerLivello.put("FACILE", Difficolta.valueOf("FACILE").getValue());
        this.erroriPerLivello.put("MEDIO", Difficolta.valueOf("MEDIO").getValue());
        this.erroriPerLivello.put("DIFFICILE", Difficolta.valueOf("DIFFICILE").getValue());
        this.numMaxErrori = erroriPerLivello.get("FACILE");
        this.dimMax = Tabella.valueOf("STANDARD").getValue();
    }


    /**
     * Restituisce il tempo di inizio della partita.
     * @return tempo di inizio della partita
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Imposta il tempo di inizio della partita ad un dato valore.
     * @param pStartTime : valore a cui impostare il tempo di inizio
     */
    public void setStartTime(final long pStartTime) {
        this.startTime = pStartTime;
    }

    /**
     * Restituisce il numero di errori concessi per il livello dato in input.
     * @param pLivello : nome del livello del quale si vogliono sapere gli errori concessi
     * @return corrispondenza livello / errori concessi
     */
    public int getErrorePerLivello(final String pLivello) {
        return erroriPerLivello.get(pLivello);
    }
    /**
     * Modifica una corrispondenza livello/numero di errori nel dizionario.
     * @param pLivello : nome del livello di difficoltà
     * @param pErrori : numero di errori da impostare per quel livello
     */
    public void setErroriPerLivello(final String pLivello, final int pErrori) {
        this.erroriPerLivello.put(pLivello, pErrori);
    }

    /**
     * Restituisce il livelllo di difficoltà impostato.
     * @return livello di difficoltà
     */
    public String getLivello() {
        return this.livello;
    }
  /**
  * Imposta il livello di difficoltà.
  * @param pLivello
  */
    public void setLivello(final String pLivello) {
        this.livello = pLivello;
    }

    /**
     * Restituisce il numero massimo di errori.
     *
     * @return numero massimo di errori
     */
    public int getNumMaxErrori() {
        return numMaxErrori;
    }

    /**
     * Permette di modificare il numero massimo di errori.
     * @param pNumMaxErrori : numero massimo di errori da impostare
     */
    public void setNumMaxErrori(final int pNumMaxErrori) {
        this.numMaxErrori = pNumMaxErrori;
    }

    /**
     * Restituisce il numero di errori commessi dal giocatore.
     * @return numero di errori commessi dal giocatore
     */
    public int getErroriCorrenti() {
        return erroriCorrenti;
    }

    /**
     * Permette di modificare il numero di errori commessi dal giocatore.
     * @param pErroriCorrenti : numero di errori che il giocatore ha commesso
     */
    public void setErroriCorrenti(final int pErroriCorrenti) {
        this.erroriCorrenti = pErroriCorrenti;
    }

    /**
     * Restituisce il numero di colpi sparati dal giocatore.
     * @return numero di colpi totali che sono stati sparati
     */
    public int getColpiTotali() {
        return colpiTotali;
    }

    /**
     * Permettere di modificare il numero di colpi sparati dal giocatore.
     * @param pColpiTotali  colpi totali sparati dal giocatore
     */
    public void setColpiTotali(final int pColpiTotali) {
        this.colpiTotali = pColpiTotali;
    }

    /**
     * Restituisce lo stato della partita.
     * @return stato della partita
     */
    public boolean statoPartita() {
        return inCorso;
    }

    /**
     * Imposta la dimensione massima della griglia di gioco.
     * @param pDimMax un intero che permette di settare le dimensioni della mappa di gioco
     */
    public void setDimMax(final int pDimMax) {
        this.dimMax = pDimMax;
    }

    /**
     * Ritorna la dimensione massima della griglia di gioco.
     * @return dimMax un intero che restituisce le dimensioni della mappa di gioco
     */
    public int getDimMax() {
        return dimMax;
    }
    /**
     * Imposta lo stato della partita in inCorso.
     * @param pInCorso un booleano che permette di modificare lo stato della partita in inCorso
     */
    public void setInCorso(final boolean pInCorso) {
        this.inCorso = pInCorso;
    }


    /**
     * Metodo che modifica il tempo massimo del timer.
     * @param num : numero che indica il nuovo tempo massimo del timer
     */
    public void setTempoMax(final int num) {
        tempoMax = num;
    }

    /**
     * restituisce il tempo massimo di gioco.
     * @return tempo massimo di svolgimento della partita
     */
    public int getTempoMax() {
        return tempoMax;
    }

    /**
     * Descrive lo stato della Partita.
     *
     * @return stato di Partita
     */
   // public String toString() {
       // return grigliaLogic.getGriglia().toString();
   // }


}
