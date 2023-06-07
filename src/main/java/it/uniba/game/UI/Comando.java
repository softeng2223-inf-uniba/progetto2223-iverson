package it.uniba.game.UI;

import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.partita.Partita;


import java.util.Scanner;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import it.uniba.game.utility.Tabella;

import it.uniba.game.utility.Controlli;


/**
 * Classe che ha la la funzione di menu e permette all'utente di inserire i vari comandi
 * tramite la funzione avvia().
 */
public class Comando {
    private String comando;
    private String[] cStrings;
    private static final Scanner KEYBOARD = new Scanner(System.in, "UTF-8");
    private Partita partita;
    private Controlli controlli;

    /**
     * Construttore della classe Comando.
     */
    public Comando() {
        partita = new Partita();
        controlli = new Controlli();
    }

    /**
     * Funzione che ha la funzione di "menu" e permette all'utente di inserire i
     * vari comandi.
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione.
     */
    public void avvia() throws NumeroCoordinateException, PosizioneException {
        do {
            cStrings = getComando();
            if (partita.statoPartita()) {
                switch (cStrings[0]) {
                    case "/svelagriglia":
                        partita.svelaGriglia();
                        break;
                    case "/mostratempo":
                        partita.mostraTempo();
                        break;
                    case "/mostragriglia":
                        partita.stampaGriglia();
                        break;
                    case "/mostranavi":
                        mostraNavi();
                        break;
                    case "/help":
                        stampaHelp();
                        break;
                    case "/mostralivello":
                        mostraLivello();
                        break;
                    case "/mostratentativi":
                        partita.mostraTentativi();
                        break;
                    case "/esci":
                        esci();
                        break;
                    case "/abbandona":
                        abbandona();
                        break;
                    default:
                    if (controlli.isCoordinata(cStrings[0], partita)) {
                            partita.colpisci(cStrings[0]);
                        } else {
                            System.out.println("Comando non riconosciuto o partita giá avviata");
                        }
                        break;
                }
            } else {
                switch (cStrings[0]) {
                    case "/gioca":
                        partita.avvia();
                        partita.stampaGriglia();
                        System.out.println("La partita è stata avviata");
                        break;
                    case "/tempo":
                        if (cStrings.length == 1) {
                            System.out.println("Non hai inserito nessun tempo");
                        } else if (controlli.isInteger(cStrings[1])) {
                            partita.setTempoMax(Integer.parseInt(cStrings[1]));
                            System.out.println("OK!");
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                        }
                        break;
                    case "/help":
                        stampaHelp();
                        break;
                    case "/facile":
                        if (cStrings.length == 1) {
                            partita.setNumMaxErrori(partita.getErrorePerLivello("FACILE"));
                            partita.setLivello("FACILE");
                            System.out.println("OK \n difficoltà impostata a facile");
                        } else if (controlli.isInteger(cStrings[1])) {
                            partita.setErroriPerLivello("FACILE", Integer.parseInt(cStrings[1]));
                            System.out.println("OK \n numero massimo di errori per il livello FACILE impostato a: "
                            + Integer.parseInt(cStrings[1]));
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                        }
                        break;
                    case "/medio":
                        if (cStrings.length == 1) {
                            partita.setNumMaxErrori(partita.getErrorePerLivello("MEDIO"));
                            partita.setLivello("MEDIO");
                            System.out.println("OK \n difficoltà impostata a medio");
                        } else if (controlli.isInteger(cStrings[1])) {
                            partita.setErroriPerLivello("MEDIO", Integer.parseInt(cStrings[1]));
                            System.out.println("OK \n numero massimo di errori per il livello MEDIO impostato a: "
                            + Integer.parseInt(cStrings[1]));
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                        }
                        break;
                    case "/difficile":
                        if (cStrings.length == 1) {
                            partita.setNumMaxErrori(partita.getErrorePerLivello("DIFFICILE"));
                            partita.setLivello("DIFFICILE");
                            System.out.println("OK \n difficoltà impostata a difficile");
                        } else if (controlli.isInteger(cStrings[1])) {
                            partita.setErroriPerLivello("DIFFICILE", Integer.parseInt(cStrings[1]));
                            System.out.println("OK \n numero massimo di errori per il livello DIFFICILE impostato a: "
                            + Integer.parseInt(cStrings[1]));
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                        }
                        break;
                    case "/tentativi":
                        if (cStrings.length == 1) {
                            System.out.println("Non hai inserito nessun numero di tentativi");
                        } else if (controlli.isInteger(cStrings[1])) {
                            partita.setNumMaxErrori(Integer.parseInt(cStrings[1]));
                            System.out.println("OK!");
                            System.out.println("Numero dei tentativi impostato direttamente a "
                            + Integer.parseInt(cStrings[1]));
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                        }
                        break;
                    case "/standard":
                        partita.setDimMax(Tabella.valueOf("STANDARD").getValue());
                        System.out.println("OK!");
                        break;
                    case "/large":
                        partita.setDimMax(Tabella.valueOf("LARGE").getValue());
                        System.out.println("OK!");
                        break;
                    case "/extralarge":
                        partita.setDimMax(Tabella.valueOf("EXTRALARGE").getValue());
                        System.out.println("OK!");
                        break;
                    case "/esci":
                        esci();
                        break;
                    default:
                        System.out.println("Comando non riconosciuto o partita non avviata");
                        break;
                }
            }
        } while (true);
    }

    /**
     * La funzione mostra il numero di esemplari e le dimensioni delle navi.
     */
    private static void mostraNavi() {
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
     * La funzione stampa la descrizione del gioco all'avvio.
     */
    public void stampaDescrizione() {
        System.out.println("Benvenuto in battaglia navale \n"
        + "l'obbiettivo del gioco e' distruggere tutte le navi dell'avversario entro un tot di mosse, "
        + "ricorda che di default non avrai un tempo limite \n"
        + "scrivi /help per ulteriori informazioni");
    }

    /**
     * La funzione permette di chiudere il gioco, dopo aver richiesto un input da tastiera allo studente.
     */
    private static void esci() {
        System.out.print("Sei sicuro di voler chiudere il gioco? Se si digitare 'y' "
        + "altrimenti scrivi qualsiasi altra cosa: ");
        String conferma = KEYBOARD.nextLine();
        if (conferma.equals("y")) {
            System.exit(0);
        }
    }

    /**
     * La funzione mostra al giocatore il livello di difficoltà della partita.
     */
    private void mostraLivello() {
        System.out.println("La difficoltà è impostata a: " + partita.getLivello());
        System.out.println("Il numero massimo di tentativi falliti è: " + partita.getNumMaxErrori());

    }

    /**
     * La funzione permette di abbandonare la partita in corso.
     */
    private void abbandona() {
        System.out.print("Sei sicuro di voler abbandonare la partita? Se si digitare 'y' "
        + "altrimenti scrivi qualsiasi altra cosa: ");
        String conferma = KEYBOARD.nextLine();
        if (conferma.equals("y")) {
            partita.svelaGriglia();
            partita.setInCorso(false);
            System.out.println("Partita abbandonata!");
        }
    }

    /**
     * Funzione che permettette di prendere il comando in input da tastiera.
     * @return una string contenente le varie "parole del comando"
     */
    private String[] getComando() {

        System.out.print("\nInserisci un comando: ");
        comando = KEYBOARD.nextLine();
        return comando.split(" ");

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
        for (int i = 1; i <= dimMax; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < dimMax; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < dimMax; i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < dimMax; j++) {
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
            for (int j = 0; j < dimMax; j++) {
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
        for (int i = 1; i <= dimMax; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // Stampa della prima linea verticale della griglia
        System.out.print("  " + verticale);
        // Stampa delle linee orizzontali della griglia
        for (int j = 0; j < dimMax; j++) {
            System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
        }
        System.out.println();
        // Stampa delle linee orizzontali e verticali della griglia
        for (int i = 0; i < dimMax; i++) {
            System.out.print((char) (i + valoreChiocciola) + " " + verticale);

            for (int j = 0; j < dimMax; j++) {
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
            for (int j = 0; j < dimMax; j++) {
                System.out.print(orizzontale + "" + orizzontale + "" + orizzontale + verticale);
            }
            System.out.println();
        }
    }

}
