package it.uniba.game.UI;

import it.uniba.game.partita.Partita;


import java.util.Scanner;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import it.uniba.game.utility.Difficolta;

/**
 * Classe che ha la la funzione di menu e permette all'utente di inserire i vari comandi
 * tramite la funzione avvia().
 */
public class Comando {
    private String comando;
    private String[] cStrings;
    private static final Scanner KEYBOARD = new Scanner(System.in, "UTF-8");
    private  Partita partita;
    private boolean tentativiDiretti = false;
    /**
     * Construttore della classe Comando.
     */
    public Comando() {
        partita = new Partita();
    }

    /**
     * Funzione che ha la funzione di "menu" e permette all'utente di inserire i
     * vari comandi.
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione.
     */
    public void avvia() throws NumeroCoordinateException {
        do {
            System.out.print("\nInserisci un comando: ");
            comando = KEYBOARD.nextLine();
            cStrings = comando.split(" ");



            switch (cStrings[0]) {

                case "/gioca":
                    if (!partita.statoPartita()) {
                        partita.avvia();
                        partita.stampaGriglia();
                        System.out.println("La partita è stata avviata");
                    } else {
                        System.out.println("La partita è già in corso");
                    }
                    break;

                case "/svelagriglia":
                    if (partita.statoPartita()) {
                            partita.svelaGriglia();
                    } else {
                        System.out.println("La partita non è stata inizializzata");
                    }
                    break;

                case "/colpisci":

                    break;

                case "/tempo":

                    if (!partita.statoPartita()) {
                        if (cStrings.length == 1) {
                            System.out.println("Non hai inserito nessun tempo");
                        } else if (isInteger(cStrings[1])) {

                            partita.setTempoMax(Integer.parseInt(cStrings[1]));
                            System.out.println("OK!");
                        } else {
                            System.out.println("Non hai inserito un numero corretto o il comando é sbagliato");
                        }

                    } else {
                        System.out.println("La partita è già in corso, non puoi modificare il timer");
                    }

                    break;

                case "/mostratempo":

                    if (partita.statoPartita()) {
                        partita.mostraTempo();
                    } else {
                        System.out.println("La partita non è stata inizializzata, non puoi visualizzare il timer");
                    }

                    break;

                case "/mostragriglia":
                    if (partita.statoPartita()) {
                        partita.stampaGriglia();
                    } else {
                        System.out.println("La partita non è stata inizializzata");
                    }
                    break;

                case "/help":
                    stampaHelp();
                    break;

                case "/facile":
                    if (!partita.statoPartita()) {
                        partita.setNumMaxErrori(Difficolta.valueOf("FACILE").getValue());
                        System.out.println("OK \n difficolta' impostata a facile");
                    } else {
                        System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                    }
                break;


                case "/medio":
                    if (!partita.statoPartita()) {
                        partita.setNumMaxErrori(Difficolta.valueOf("MEDIO").getValue());
                        System.out.println("OK \n difficolta' impostata a medio");
                    } else {
                        System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                    }
                    break;

                case "/difficile":
                    if (!partita.statoPartita()) {
                    partita.setNumMaxErrori(Difficolta.valueOf("DIFFICILE").getValue());
                    System.out.println("OK \n difficolta' impostata a difficile");
                    } else {
                        System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                    }
                    break;

                case "/mostranavi":
                    mostraNavi();
                    break;

                case "/mostralivello":
                    mostraLivello();
                    break;

                case "/tentativi":
                if (!partita.statoPartita()) {
                    if (cStrings.length == 1) {
                        System.out.println("Non hai inserito nessun numero di tentativi");
                    } else if (isInteger(cStrings[1])) {

                        partita.setNumMaxErrori(Integer.parseInt(cStrings[1]));
                        System.out.println("OK!");
                        System.out.println("Numero dei tentativi impostato direttamente a "
                         + Integer.parseInt(cStrings[1]));
                        tentativiDiretti = true;
                    } else {
                        System.out.println("Non hai inserito un numero corretto o il comando é sbagliato");
                    }

                } else {
                    System.out.println("La partita è già in corso, non puoi modificare i tentativi disponibili");
                }


                break;
                case "/esci":
                    esci();
                    break;

                default:
                    System.out.println("Comando non riconosciuto");
                    break;

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
        if (!tentativiDiretti) {

            if (partita.getNumMaxErrori() == Difficolta.valueOf("FACILE").getValue()) {
                System.out.println("La difficoltà è impostata su 'FACILE' con Max Errori = 50");
            } else if (partita.getNumMaxErrori() == Difficolta.valueOf("MEDIO").getValue()) {
                System.out.println("La difficoltà è impostata su 'MEDIA' con Max Errori = 30");
            } else if (partita.getNumMaxErrori() == Difficolta.valueOf("DIFFICILE").getValue()) {
                System.out.println("La difficoltà è impostata su 'DIFFICILE' con Max Errori = 10");
            }

        } else {
            System.out.println("Il numero massimo di errori è stato impostato in modo diretto a "
             + partita.getNumMaxErrori());
        }

    }

    /**
     *Funzione che permette di controllare se una stringa contiene un valore numerico.
     * @param str la stringa da controllare
     * @return ritorna true se é un numero
     */
    public static boolean isInteger(final String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
