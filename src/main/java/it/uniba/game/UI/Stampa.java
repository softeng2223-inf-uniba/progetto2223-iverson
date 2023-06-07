package it.uniba.game.UI;

import it.uniba.game.logic.PartitaLogic;
import it.uniba.game.utility.Tempo;

/**
 *
 * blabla.
 */
public class Stampa {

    /**
     * Construct.
     */
    public Stampa() {
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode.
     * @param partitaLogic
     *
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
        for (int i = 1; i <= partitaLogic.getDimMax(); i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < partitaLogic.getDimMax(); j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < partitaLogic.getDimMax(); i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < partitaLogic.getDimMax(); j++) {
                String cella = partitaLogic.getGrigliaLogicCella(i, j);

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
            for (int j = 0; j < partitaLogic.getDimMax(); j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode a differenza si
     * svelaGriglia() non mostra le navi dell'avversario.
     *
     * @param partitaLogic
     */
    public void stampaGriglia(final PartitaLogic partitaLogic) {
        final char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        final char verticale = '\u2503'; // carattere Unicode della linea verticale
        final char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        final char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno
        final int valoreChiocciola = 65;

        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= partitaLogic.getDimMax(); i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < partitaLogic.getDimMax(); j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < partitaLogic.getDimMax(); i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < partitaLogic.getDimMax(); j++) {
                String cella = partitaLogic.getGrigliaLogicCella(i, j);
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
            for (int j = 0; j < partitaLogic.getDimMax(); j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Metodo che restituisce il tempo massimo del timer e il tempo corrente.
     * @param partitaLogic
     */
    public void mostraTempo(final PartitaLogic partitaLogic) {
        long secondi = Tempo.valueOf("SECONDI").getValue() -  partitaLogic.restoTempoAttuale();
        long minuti = partitaLogic.getTempoMax() - partitaLogic.tempoAttuale();
        minuti--;
        System.out.println("Attualmente sono passati: " + partitaLogic.tempoAttuale()
        + " minuti e " + partitaLogic.restoTempoAttuale() + " secondi");
        if (partitaLogic.getTempoMax() != 0) {
            System.out.println("Tempo massimo del timer: " + partitaLogic.getTempoMax() + " minuti");
            System.out.println("Tempo rimanente: " + minuti + " minuti e " + "secondi " + secondi);
        } else {
            System.out.println("Non avendo scelto un tempo non hai limite!!");
        }

    }

    /**
     * Metodo che restituisce i tentativi già effettuati, i tentativi falliti e il numero massimo di tentativi falliti.
     * @param partitaLogic
     */
    public void mostraTentativi(final PartitaLogic partitaLogic) {
        System.out.println("Il numero di tentativi effettuati è: " + partitaLogic.getColpiTotali());
        System.out.println("Il numero di tentativi falliti è: " + partitaLogic.getErroriCorrenti());
        System.out.println("Il numero massimo di tentativi falliti è: " + partitaLogic.getNumMaxErrori());
    }


     /**
     * La funzione stampa la descrizione del gioco all'avvio.
     */
    public void stampaDescrizione() {
        System.out.println("Benvenuto in battaglia navale \n"
        + "l'obbiettivo del gioco e' distruggere tutte le navi dell'avversario entro un tot di mosse, "
        + "ricorda che di default non avrai un tempo limite \n"
        + "scrivi /help per ulteriori informazioni");
    }

    /**
     * La funzione mostra al giocatore il livello di difficoltà della partita.
     * @param partitaLogic
     */
    public void mostraLivello(final PartitaLogic partitaLogic) {
        System.out.println("La difficoltà è impostata a: " + partitaLogic.getLivello());
        System.out.println("Il numero massimo di tentativi falliti è: " + partitaLogic.getNumMaxErrori());

    }

        /**
     * La funzione mostra il numero di esemplari e le dimensioni delle navi.
     */
    public void mostraNavi() {
        System.out.println("Le navi disponibili sono: \n");
        System.out.println("Cacciatorpediniere \u26F4 \u26F4  esemplari: 4 \n");
        System.out.println("Incrociatore \u26F4 \u26F4 \u26F4  esemplari: 3 \n");
        System.out.println("Corazzata \u26F4 \u26F4 \u26F4 \u26F4  esemplari: 2 \n");
        System.out.println("Portaerei \u26F4 \u26F4 \u26F4 \u26F4 \u26F4  esemplari: 1 \n");
    }

    /**
     * La funzione stampa il comando il /help che descrive i vari comandi disponibili.
     */
    public void stampaHelp() {
        System.out.print("Comandi applicabili: \n"
        + "/gioca (Comando che inizializza una nuova partita)\n"
        + "/svelagriglia (Comando eseguibile solo a partita in corso, mostra la griglia con le navi posizionate)\n"
        + "/help (Comando che mostra la lista dei comandi)\n"
        + "/mostranavi (Comando che mostra una legenda delle navi disponibili nel gioco)\n"
        + "/mostralivello (Comando che mostra il livello al quale si sta giocando fra facile, medio e difficile)\n"
        + "/esci (Comando che fa uscire dalla partita)\n"
        + "/facile (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n"
        + "/medio (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n"
        + "/difficile (Comando chiamabile solamente prima di iniziare la partita,"
        + "imposta il livello di difficolta')\n");
    }


    /**
     * ok.
     * @param esito
     * @param partitaLogic
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
        System.out.printf("Colpi effettuati : " + partitaLogic.getColpiTotali());
    }

    /**
     * @param esito
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
