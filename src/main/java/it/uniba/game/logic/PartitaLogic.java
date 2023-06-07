package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.partita.Partita;

/**
 * CONTROL
 */
public class PartitaLogic {
    private Partita partita;
    private GrigliaLogic grigliaLogic;

    public PartitaLogic() {
        partita = new Partita();
    }

    public void avvia() throws NumeroCoordinateException {
        grigliaLogic = new GrigliaLogic(partita.getDimMax(), partita.getDimMax());
        partita.setInCorso(true);
        partita.setStartTime(System.currentTimeMillis());

    }

    public Partita getPartita() {
        return partita;
    }
    
    /**
     * Consente di colpire una cella della griglia.
     * @param input : stringa contente la riga e la colonna
     * @throws PosizioneException nel caso in cui si inserisce una posizione non disponibile
     */
    public void colpisci(final String input) throws PosizioneException {
        int riga = 0;
        int colonna = 0;
        String[] sezioni = input.split("-");

        if (sezioni.length == 2 && sezioni[0].length() == 1 && sezioni[1].matches("\\d+")) {
            riga = Character.toUpperCase(input.charAt(0)) - 'A';
            colonna = Integer.parseInt(sezioni[1]) - 1;

            if (!(riga < partita.getDimMax() && riga >= 0)) {
                System.out.printf("La riga inserita è fuori range,"
                        + " la prego di reinserirla.%n");
                return;
            }
            if (!(colonna < partita.getDimMax() && colonna >= 0)) {
                System.out.printf("La colonna inserita è fuori range,"
                        + " la prego di reinserirla.%n");
                return;
            }

        } else {
            System.out.println("Input non valido.%n");
            return;
        }

        String stato = grigliaLogic.inserisciColpo(riga, colonna);

        partita.stampaGriglia();
        switch (stato) {
            case "C":
                System.out.print("Colpito!\n");
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                break;
            case "CA":
                System.out.print("Colpito e affondato!!!\n");
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                break;
            case "V":
                System.out.print("Acqua :c\n");
                partita.setColpiTotali(partita.getColpiTotali() + 1);
                partita.setErroriCorrenti(partita.getErroriCorrenti() + 1);
                break;
            default:
                System.out.print("Si è verificato un errore nell'inserimento del colpo\n");
                break;
        }
       partita.mostraTempo();
        System.out.printf("Colpi effettuati : " + partita.getColpiTotali());
        if (grigliaLogic.finepartita()) {
            partita.setInCorso(false); 
            System.out.printf("La partita è finita");
        } else if (partita.controllaTempoScaduto()) {
            partita.setInCorso(false); 
            System.out.printf("La partita è finita perché il tempo è finito");
        } else if ((partita.getNumMaxErrori() - partita.getColpiTotali()) == 0) {
            partita.setInCorso(false); 
            System.out.printf("La partita è finita perché hai finito il numero di tentativi");
        }
    }

    

}

    

