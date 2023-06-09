package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.partita.Partita;
import it.uniba.game.utility.Tempo;

/**
 * <<Control>> Classe che permette l'utilizzo dei dati della Partita.
 *  Gestisce l'avvio e la terminazione della partita, l'inserimento dei colpi
 *  e i controlli riguardanti la vittoria/sconfitta del giocatore,
 *  oltre che la manipolazione delle impostazioni della partita.
 */
public class PartitaLogic {
    private Partita partita;
    private GrigliaLogic grigliaLogic;

    /**
     * Costruttore della classe. Inizializza un nuovo oggetto partita
     */
    public PartitaLogic() {
        partita = new Partita();
    }


    /**
     * Inizializza la griglia di gioco della partita
     * e azzera il tempo di gioco e le statistiche di gioco.
     *
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     *
     */
    public void avvia() throws NumeroCoordinateException {

        grigliaLogic = new GrigliaLogic(partita.getDimMax(), partita.getDimMax());
        partita.setInCorso(true);
        partita.setStartTime(System.currentTimeMillis());
        partita.setColpiTotali(0);
        partita.setErroriCorrenti(0);

    }




    /**
     * Consente di colpire una cella della griglia.
     * @param input : stringa contente la coordinata della cella da colpire
     * @return : coppia di stringhe indicanti l'esito del colpo e l'eventuale terminazione della partita
     * @throws PosizioneException nel caso in cui si inserisce una posizione non disponibile
     */
    public String[] colpisci(final String input) throws PosizioneException {
        int riga = 0;
        int colonna = 0;
        final int dim = 2;
        String[] sezioni = input.split("-");
        String[] output = new String[dim];
        riga = Character.toUpperCase(input.charAt(0)) - 'A';
        colonna = Integer.parseInt(sezioni[1]) - 1;


        output[0] = grigliaLogic.inserisciColpo(riga, colonna);

        switch (output[0]) {
            case "C":
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                break;
            case "CA":
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                break;
            case "V":
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                partita.setErroriCorrenti(partita.getErroriCorrenti() + 1);
                break;
            default:
                break;
        }

        if (grigliaLogic.finepartita()) {
            partita.setInCorso(false);
            output[1] = "vittoria";

        } else if (controllaTempoScaduto()) {
            partita.setInCorso(false);
            output[1] = "tempo";
        } else if ((partita.getNumMaxErrori() - partita.getColpiTotali()) == 0) {
            partita.setInCorso(false);
            output[1] = "errori";
        } else {
            output[1] = " ";
        }

        return output;
    }


    /**
     * Restituisce lo stato di una specifica cella della griglia di gioco.
     * @param i : indice di riga della cella
     * @param j : indice della colonna della cella
     * @return stato della cella di riga i e colonna j della griglia
     */
    public String getGrigliaLogicCella(final int i, final int j) {
        return grigliaLogic.getStatoCella(i, j);
    }

    /**
     * Metodo che controlla se il tempo del timer é scaduto.
     */
    public boolean controllaTempoScaduto() {

        if (partita.getTempoMax() != 0 && partita.getTempoMax() <= tempoAttuale()) {
            return true;
        }
            return false;

    }

     /**
     * Metodo che restituisce il tempo rimanente in minuti.
     * @return Tempo rimanente in minuti.
     */
    public long tempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - partita.getStartTime();
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds / Tempo.valueOf("SECONDI").getValue();
    }

    /**
     * Metodo che restituisce il tempo rimanente in secondi.
     * @return Tempo rimanente in secondi.
     */
    public long restoTempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - partita.getStartTime();
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds % Tempo.valueOf("SECONDI").getValue();
    }
/**
 * Restituisce vero se la partita è in corso, falso altrimenti.
 * @return vero se la partita è in corso, falso altrimenti
 */
    public boolean statoPartita() {
        return partita.statoPartita();
    }
/**
 * Restituisce la dimensione della griglia della partita.
 * @return dimensione della griglia di gioco della partita
 */
    public int getDimMax() {
        return partita.getDimMax();
    }
/**
 * Imposta la dimensione della griglia di gioco.
 * @param pDimMax : dimensione della griglia di gioco da impostare
 */
    public void setDimMax(final int pDimMax) {
        partita.setDimMax(pDimMax);
    }
/**
 * Imposta il tempo massimo di gioco.
 * @param pTempoMax : tempo massimo di gioco espresso in minuti
 */
    public void setTempoMax(final int pTempoMax) {
        partita.setTempoMax(pTempoMax);
    }
/**
 * Imposta il numero massimo di errori commettibili nella partita.
 * @param pNumMaxErrori : numero massimo di errori da impostare
 */
    public void setNumMaxErrori(final int pNumMaxErrori) {
        partita.setNumMaxErrori(pNumMaxErrori);
    }
/**
 * Restituisce il numero di errori massimo per un determinato livello di gioco.
 * @param pLivello : livello di gioco dal quale estrarre il numero di errori
 * @return : numero di errori per il livello di gioco dato
 */
    public int getErrorePerLivello(final String pLivello) {
        return partita.getErrorePerLivello(pLivello);
    }

/**
 * Imposta il livello di difficoltà della partita.
 * @param pLivello : livello di difficoltà da impostare
 */
    public void setLivello(final String pLivello) {
        partita.setLivello(pLivello);
    }
/**
 * Imposta il numero di errori massimo per un dato livello di gioco.
 * @param pLivello : livello di cui cambiare gli errori
 * @param pErrori : errori da impostare per quel livello
 */
    public void setErroriPerLivello(final String pLivello, final int pErrori) {
        partita.setErroriPerLivello(pLivello, pErrori);
    }
/**
 * Cambia lo stato della partita inteso come in svolgimento o meno.
 * @param pInCorso : booleano che indica se la partita è in corso o meno
 */
    public void setInCorso(final boolean pInCorso) {
        partita.setInCorso(pInCorso);
    }
/**
 * Restituisce il numero di colpi effettuati durante la partita.
 * @return numero di colpi effettuati durante la partita
 */
   public int getColpiTotali() {
    return partita.getColpiTotali();
    }
/**
 * Restituisce il tempo massimo di gioco (se impostato).
 * @return tempo massimo di gioco in minuti
 */
    public int getTempoMax() {
        return partita.getTempoMax();
    }
/**
 * Restituisce il numero massimo di errori commettibili nella partita.
 * @return numero massimo di errori commettibili nella partita.
 */
    public int getNumMaxErrori() {
        return partita.getNumMaxErrori();
    }
/**
 * Restitisce il numero di colpi mancati effettuati nella partita.
 * @return numero di errori effettuati nella partita
 */
    public int getErroriCorrenti() {
        return partita.getErroriCorrenti();
    }
/**
 * Restituisce il livello di gioco impostato per la partita.
 * @return livello di difficoltà della partita
 */
    public String getLivello() {
        return partita.getLivello();
    }

}
