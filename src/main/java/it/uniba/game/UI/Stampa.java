package it.uniba.game.UI;

import it.uniba.game.logic.PartitaLogic;
import it.uniba.game.utility.Tempo;

public class Stampa {
    
    public Stampa() {
        
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode.
     * 
     * CLASSE <STAMPA>
     */
    public void svelaGriglia(final PartitaLogic partitaLogic) {
        final char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        final char verticale = '\u2503'; // carattere Unicode della linea verticale
        final char nave = '\u26F4'; // carattere Unicode della nave
        final char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        final char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno
        final int valoreChiocciola = 65;
        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= partitaLogic.getPartita().getDimMax(); i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < partitaLogic.getPartita().getDimMax(); i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
                String cella = partitaLogic.getGrigliaLogic().getGriglia().getCella(i, j);
                switch (cella) {
                    case "N":
                        System.out.print(" " + nave + " " + verticale);
                        break;
                    case "V":
                        System.out.print("   " + verticale);
                        break;
                    case "NC":
                        System.out.print(" " + colpito + " " + verticale);
                        break;
                    case "VC":
                        System.out.print(" " + mancato + " " + verticale);
                        break;
                    default:
                        System.out.print("   " + verticale);
                        break;

                }

            }

            System.out.println();

            // Stampa della prima linea verticale della griglia
            System.out.print("  " + verticale);
            // Stampa delle linee orizzontali della griglia
            for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode a differenza si
     * svelaGriglia() non mostra le navi dell'avversario.
     * 
     * CLASSE <STAMPA>
     */
    public void stampaGriglia(final PartitaLogic partitaLogic) {
        final char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        final char verticale = '\u2503'; // carattere Unicode della linea verticale
        final char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        final char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno
        final int valoreChiocciola = 65;

        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= partitaLogic.getPartita().getDimMax(); i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < partitaLogic.getPartita().getDimMax(); i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
                String cella = partitaLogic.getGrigliaLogic().getGriglia().getCella(i, j);
                switch (cella) {
                    case "V":
                        System.out.print("   " + verticale);
                        break;
                    case "NC":
                        System.out.print(" " + colpito + " " + verticale);
                        break;
                    case "VC":
                        System.out.print(" " + mancato + " " + verticale);
                        break;
                    default:
                        System.out.print("   " + verticale);
                        break;

                }

            }

            System.out.println();

            // Stampa della prima linea verticale della griglia
            System.out.print("  " + verticale);
            // Stampa delle linee orizzontali della griglia
            for (int j = 0; j < partitaLogic.getPartita().getDimMax(); j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Metodo che restituisce il tempo massimo del timer e il tempo corrente.
     * <STAMPA>
     */
    public void mostraTempo(final PartitaLogic partitaLogic) {
        long secondi = Tempo.valueOf("SECONDI").getValue() -  partitaLogic.restoTempoAttuale();
        long minuti = partitaLogic.getPartita().getTempoMax() - partitaLogic.tempoAttuale();
        minuti--;
        System.out.println("Attualmente sono passati: " + partitaLogic.tempoAttuale()
        + " minuti e " + partitaLogic.restoTempoAttuale() + " secondi");
        if (partitaLogic.getPartita().getTempoMax() != 0) {
            System.out.println("Tempo massimo del timer: " + partitaLogic.getPartita().getTempoMax() + " minuti");
            System.out.println("Tempo rimanente: " + minuti + " minuti e " + "secondi " + secondi);
        } else {
            System.out.println("Non avendo scelto un tempo non hai limite!!");
        }

    }

    /**
     * Metodo che restituisce i tentativi già effettuati, i tentativi falliti e il numero massimo di tentativi falliti.
     *
     */
    public void mostraTentativi(final PartitaLogic partitaLogic) {
        System.out.println("Il numero di tentativi effettuati è: " + partitaLogic.getPartita().getColpiTotali());
        System.out.println("Il numero di tentativi falliti è: " + partitaLogic.getPartita().getErroriCorrenti());
        System.out.println("Il numero massimo di tentativi falliti è: " + partitaLogic.getPartita().getNumMaxErrori());
    }


    /**
     * 
     */
    public void stampaRisultatoColpo(final String esito, final PartitaLogic partitaLogic) {
        
        stampaGriglia(partitaLogic);

        switch (esito) {
            case "C":
                System.out.print("Colpito!\n");
                break;
            case "CA":
                System.out.print("Colpito e affondato!!!\n");
                break;
            case "V":
                System.out.print("Acqua :c\n");
                break;
            default:
                System.out.print("Si è verificato un errore nell'inserimento del colpo\n");
                break;
        }
        mostraTempo(partitaLogic);
        System.out.printf("Colpi effettuati : " + partitaLogic.getPartita().getColpiTotali());
    }

    /**
     * 
     */
    public void stampaFinePartita(final String esito) {
        switch (esito) {
            case "vittoria":
                System.out.println("Hai affondato tutte le navi. Hai vinto la partita!");
                break;
            case "tempo":
                System.out.println("Tempo esaurito, hai perso :c");
                break;
            case "errori":
                System.out.println("La partita è finita perché hai finito il numero di tentativi , hai perso :c");
                break;
            default:
                break;
        }
    }
}
