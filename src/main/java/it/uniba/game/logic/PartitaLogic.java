package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.partita.Partita;
import it.uniba.game.utility.Tempo;

/**
 * CONTROL
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
     * Inizializza la griglia di gioco della partita.
     *
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     * 
     */
    public void avvia() throws NumeroCoordinateException {
        grigliaLogic = new GrigliaLogic(partita.getDimMax(), partita.getDimMax());
        partita.setInCorso(true);
        partita.setStartTime(System.currentTimeMillis());

    }

    /**
     * Restituisce l'oggetto partita della classe.
     * @return oggetto contenente le informazioni sulla partita
     */
    public Partita getPartita() {
        return partita;
    }


    /**
     * Consente di colpire una cella della griglia.
     * @param input : stringa contente la riga e la colonna
     * @throws PosizioneException nel caso in cui si inserisce una posizione non disponibile
     */
    public String[] colpisci(final String input) throws PosizioneException {
        int riga = 0;
        int colonna = 0;
        final int DIM = 2;
        String[] sezioni = input.split("-");
        String[] output = new String[DIM];
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
        } else{
            output[1] = " ";
        }

           
        return output;
    }


    /**
     * @return
     */
    public GrigliaLogic getGrigliaLogic() {
        return grigliaLogic;
    }

    /**
     * Metodo che controlla se il tempo del timer é scaduto.
     */
    public boolean controllaTempoScaduto() {

        if (getPartita().getTempoMax() != 0 && getPartita().getTempoMax() > tempoAttuale()) {
            System.out.println("Il tempo é scaduto");
            return true;
        } else {
            return false;
        }

    }

     /**
     * Metodo che restituisce il tempo rimanente in minuti.
     * @return Tempo rimanente in minuti.
     */
    public long tempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - getPartita().getStartTime();
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds / Tempo.valueOf("SECONDI").getValue();
    }
    
    /**
     * Metodo che restituisce il tempo rimanente in secondi.
     * @return Tempo rimanente in secondi.
     */
    public long restoTempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - getPartita().getStartTime();
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds % Tempo.valueOf("SECONDI").getValue();
    }

}

    

