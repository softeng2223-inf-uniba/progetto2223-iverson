package it.uniba.game.partita;

import it.uniba.game.eccezioni.NumeroCoordinateException;

/**
 * Classe che inizializza una Partita e la sua relativa Griglia di gioco
 */
public class Partita {
    private int numMaxErrori;
    private int colpiTotali;
    private int erroriCorrenti;
    private boolean inCorso;
    private Griglia griglia;

    /**
     * Inizializza una Partita
     */
    public Partita() {
        this.inCorso = false;
        this.erroriCorrenti = 0;
        this.colpiTotali = 0;
        this.numMaxErrori = 50;
    }

    /**
     * Inizializza una Partita e la sua relativa griglia di gioco
     * 
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *                                   coordinate
     *                                   rispetto alla sua dimensione
     */
    public void avvia() throws NumeroCoordinateException {
        this.griglia = new Griglia(10, 10);
        this.inCorso = true;
    }

    /**
     * Restituisce il numero massimo di errori
     * 
     * @return numero massimo di errori
     */
    public int getNumMaxErrori() {
        return numMaxErrori;
    }

    /**
     * Permette di modificare il numero massimo di errori
     * 
     * @param numMaxErrori : numero massimo di errori da impostare
     */
    public void setNumMaxErrori(int numMaxErrori) {
        this.numMaxErrori = numMaxErrori;
    }

    /**
     * Restituisce il numero di errori commessi dal giocatore
     * 
     * @return numero di errori commessi dal giocatore
     */
    public int getErroriCorrenti() {
        return erroriCorrenti;
    }

    /**
     * Permette di modificare il numero di errori commessi dal giocatore
     * 
     * @param erroriCorrenti : numero di errori che il giocatore ha commesso
     */
    public void setErroriCorrenti(int erroriCorrenti) {
        this.erroriCorrenti = erroriCorrenti;
    }

    /**
     * Restituisce il numero di colpi sparati dal giocatore
     * 
     * @return numero di colpi totali che sono stati sparati
     */
    public int getColpiTotali() {
        return colpiTotali;
    }

    /**
     * Permettere di modificare il numero di colpi sparati dal giocatore
     * 
     * @param colpiTotali : colpi totali sparati dal giocatore
     */
    public void setColpiTotali(int colpiTotali) {
        this.colpiTotali = colpiTotali;
    }

    /**
     * Restituisce lo stato della partita
     * 
     * @return stato della partita
     */
    public boolean statoPartita() {
        return inCorso;
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode
     */
    public void svelaGriglia() {
        char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        char verticale = '\u2503'; // carattere Unicode della linea verticale
        char nave = '\u26F4'; // carattere Unicode della nave
        char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno

        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < 10; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65) + " " + verticale);

            for (int j = 0; j < 10; j++) {
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
            for (int j = 0; j < 10; j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Restituisce la griglia di gioco stampata in Unicode a differenza si
     * svelaGriglia() non mostra le navi dell'avversario
     */
    public void stampaGriglia() {
        char orizzontale = '\u2501'; // carattere Unicode della linea orizzontale
        char verticale = '\u2503'; // carattere Unicode della linea verticale
        char mancato = '\u25BD'; // carattere Unicode che rappresenta il mancato con un triangolino vuoto
        char colpito = '\u25BC'; // carattere Unicode che rappresenta il colpito con un triangolino pieno

        // Stampa delle righe superiori della griglia
        System.out.print("   ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < 10; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65) + " " + verticale);

            for (int j = 0; j < 10; j++) {
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
            for (int j = 0; j < 10; j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

    /**
     * Descrive lo stato della Partita
     * 
     * @return stato di Partita
     */
    public String toString() {
        return griglia.toString();
    }

}
