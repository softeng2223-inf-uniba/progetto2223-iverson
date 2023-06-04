package it.uniba.game.partita;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import it.uniba.game.utility.Difficolta;

import it.uniba.game.utility.Tempo;

/**
 * Classe che inizializza una Partita e la sua relativa Griglia di gioco.
 */
public class Partita {
    private int numMaxErrori;
    private int colpiTotali;
    private int erroriCorrenti;
    private boolean inCorso;
    private Griglia griglia;
    private static final int DIMMAX = 10;
    private int tempoMax = 0;
    private long startTime;

    /**
     * Inizializza una Partita.
     */
    public Partita() {
        this.inCorso = false;
        this.erroriCorrenti = 0;
        this.colpiTotali = 0;
        this.numMaxErrori = Difficolta.valueOf("FACILE").getValue();
    }


    /**
     * Inizializza una Partita e la sua relativa griglia di gioco.
     *
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    public void avvia() throws NumeroCoordinateException {
        this.griglia = new Griglia(DIMMAX, DIMMAX);
        this.inCorso = true;
        startTime = System.currentTimeMillis();
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
     * Restituisce la griglia di gioco stampata in Unicode.
     */
    public void svelaGriglia() {
        final char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        final char verticale = '\u2503'; // carattere Unicode della linea verticale
        final char nave = '\u26F4'; // carattere Unicode della nave
        final char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        final char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno
        final int valoreChiocciola = 65;
        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= DIMMAX; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < DIMMAX; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < DIMMAX; i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < DIMMAX; j++) {
                String cella = griglia.getCella(i, j);
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
            for (int j = 0; j < DIMMAX; j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode a differenza si
     * svelaGriglia() non mostra le navi dell'avversario.
     */
    public void stampaGriglia() {
        final char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        final char verticale = '\u2503'; // carattere Unicode della linea verticale
        final char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        final char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno
        final int valoreChiocciola = 65;

        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= DIMMAX; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < DIMMAX; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < DIMMAX; i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < DIMMAX; j++) {
                String cella = griglia.getCella(i, j);
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
            for (int j = 0; j < DIMMAX; j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Descrive lo stato della Partita.
     *
     * @return stato di Partita
     */
    public String toString() {
        return griglia.toString();
    }

    /**
     * Metodo che modifica il tempo massimo del timer.
     * @param num : numero che indica il nuovo tempo massimo del timer
     */
    public void setTempoMax(final int num) {
        tempoMax = num;
    }

    /**
     * Metodo che controlla se il tempo del timer é scaduto.
     */
    private boolean controllaTempoScaduto() {

        if (tempoMax != 0 && tempoMax > tempoAttuale()) {
            System.out.println("Il tempo é scaduto");
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodo che restituisce il tempo massimo del timer e il tempo corrente.
     */
    public void mostraTempo() {
        long secondi = Tempo.valueOf("SECONDI").getValue() -  restoTempoAttuale();
        long minuti = tempoMax - tempoAttuale();
        minuti--;
        System.out.println("Attualmente sono passati: " + tempoAttuale()
        + " minuti e " + restoTempoAttuale() + " secondi");
        if (tempoMax != 0) {
            System.out.println("Tempo massimo del timer: " + tempoMax + " minuti");
            System.out.println("Tempo rimanente: " + minuti + " minuti e " + "secondi " + secondi);
        } else {
            System.out.println("Non avendo scelto un tempo non hai limite!!");
        }

    }
    /**
     * Metodo che restituisce il tempo rimanente in minuti.
     * @return Tempo rimanente in minuti.
     */
    private long tempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds / Tempo.valueOf("SECONDI").getValue();
    }
    /**
     * Metodo che restituisce il tempo rimanente in secondi.
     * @return Tempo rimanente in secondi.
     */
    private long restoTempoAttuale() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedTime / Tempo.valueOf("MILLISECONDI").getValue();
         return elapsedSeconds % Tempo.valueOf("SECONDI").getValue();
    }
    /**
     * Metodo che restituisce i tentativi già effettuati, i tentativi falliti e il numero massimo di tentativi falliti.
     */
    public void mostraTentativi() {
        System.out.println("Il numero di tentativi effettuati è: " + this.colpiTotali);
        System.out.println("Il numero di tentativi falliti è: " + this.erroriCorrenti);
        System.out.println("Il numero massimo di tentativi falliti è: " + this.numMaxErrori);
    }


}
