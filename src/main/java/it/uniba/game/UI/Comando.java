package it.uniba.game.UI;

import it.uniba.game.partita.Partita;


import java.util.Scanner;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import it.uniba.game.utility.Difficolta;

/**
 * Classe che ha la la funzione di menu e permette all'utente di inserire i vari comandi
 * tramite la funzione avvia()
 */
public class Comando {
    public static String comando; 
    private static final Scanner keyboard = new Scanner(System.in);
    public static Partita partita;

    /**
     * Construttore della classe Comando
     */
    public Comando() {

        comando = new String("");
        partita = new Partita();

    }
    /**
     * Funzione che ha la funzione di "menu" e permette all'utente di inserire i
     * vari comandi.
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione.
     */
    public void avvia () throws NumeroCoordinateException{
        
        do {
            System.out.print("\nInserisci un comando: ");
            comando = keyboard.nextLine();
            switch (comando) {

                case "/gioca":
                    if (!partita.statoPartita()){
                        partita.avvia();
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
                        partita.setNumMaxErrori(Difficolta.valueOf("MEDIA").getValue());
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
     * La funzione mostra il numero di esemplari e le dimensioni delle navi
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
        System.out.print( "Comandi applicabili: \n"
        +"/gioca (Comando che inizializza una nuova partita)\n"
        +"/svelagriglia (Comando eseguibile solo a partita in corso, mostra la griglia con le navi posizionate)\n"
        +"/help (Comando che mostra la lista dei comandi)\n"
        +"/mostranavi (Comando che mostra una legenda delle navi disponibili nel gioco)\n"
        +"/mostralivello (Comando che mostra il livello al quale si sta giocando fra facile, medio e difficile)\n"
        +"/esci (Comando che fa uscire dalla partita)\n"
        +"/facile (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n"
        +"/medio (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n"
        +"/difficile (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n");
    }

    /**
     * La funzione stampa la descrizione del gioco all'avvio.
     */
    public void stampaDescrizione() {
        System.out.print("Benvenuto in battaglia navale \n"
        +"l'obbiettivo del gioco e' distruggere tutte le navi dell'avversario entro un tot di mosse \n"
        +"scrivi /help per ulteriori informazioni");
    }

    /**
     * La funzione permette di chiudere il gioco, dopo aver richiesto un input da tastiera allo studente.
     */
    private static void esci() {
        System.out.print( "Sei sicuro di voler chiudere il gioco? Se si scrivi: 'y' "
        +"altrimenti scrivi qualsiasi altra cosa");
        String conferma = keyboard.nextLine();
        if (conferma.equals("y")) {
            System.exit(0);
        }
    }

    /**
     * La funzione mostra al giocatore il livello di difficoltà della partita.
     * @param partita Oggetto di tipo Partita dalla quale prendiamo la funzione NumMaxErrori.
     */
    private static void mostraLivello() {
        if (partita.getNumMaxErrori() == Difficolta.valueOf("FACILE").getValue()) {
            System.out.println("La difficoltà è impostata su 'FACILE' con Max Errori = 50");
        } else if (partita.getNumMaxErrori() == Difficolta.valueOf("MEDIO").getValue()) {
            System.out.println("La difficoltà è impostata su 'MEDIA' con Max Errori = 30");
        } else if (partita.getNumMaxErrori() == Difficolta.valueOf("DIFFICILE").getValue()) {
            System.out.println("La difficoltà è impostata su 'DIFFICILE' con Max Errori = 10");
        }
    }
}
