package it.uniba.game.UI;

import it.uniba.game.partita.Partita;
import it.uniba.game.utility.Keyboard;
import it.uniba.game.eccezioni.NumeroCoordinateException;

public class Comando {
    /**
     * Funzione che ha la funzione di "menu" e permette all'utente di inserire i
     * vari comandi
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *                                   coordinate
     *                                   rispetto alla sua dimensione
     */
    public static void avvia () throws NumeroCoordinateException{
        String comando = new String("");
        Partita partita = new Partita();

        do {
            comando = Keyboard.readString();
            switch (comando) {

                case "/gioca":
                    partita.avvia();

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
                    StampaHelp();
                    break;

                case "/facile":
               
                if(!partita.StatoPartita()){
                    partita.setNumMaxErrori(50);
                    System.out.println("OK \n difficolta' impostata a facile");
                }
                else{
                    System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                }
                    break;


                case "/medio":
                if(!partita.StatoPartita()){
                    partita.setNumMaxErrori(30);
                    System.out.println("OK \n difficolta' impostata a facile");
                }
                else{
                    System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                }
                    break;

                case "/difficile":
                if(!partita.StatoPartita()){
                partita.setNumMaxErrori(10);
                System.out.println("OK \n difficolta' impostata a facile");
                }
                else{
                    System.out.println("Impossibile modificare la difficoltà, la partita è gia in corso");

                }
                
                 break;

                case "/mostranavi":
                    MostraNavi();
                    break;

                case "/mostralivello":

                    break;

                case "/esci":

                    break;

                default:
                    System.out.println("Comando non riconosciuto");
                    break;

            }

        } while (true);

    }
    
    public static void MostraNavi(){
        System.out.println("Le navi disponibili sono: \n"); 
        System.out.println("Cacciatorpediniere \u26F4 \u26F4  esemplari: 4 \n");
        System.out.println("Incrociatore \u26F4 \u26F4 \u26F4  esemplari: 3 \n");
        System.out.println("Corazzata \u26F4 \u26F4 \u26F4 \u26F4  esemplari: 2 \n");
        System.out.println("Portaerei \u26F4 \u26F4 \u26F4 \u26F4 \u26F4  esemplari: 1 \n");
    }
    
    public static void StampaHelp(){
        System.out.print( "Comandi applicabili: \n" + 
        "/gioca (Comando che inizializza una nuova partita)\n" + 
        "/svelagriglia (Comando eseguibile solo a partita in corso, mostra la griglia con le navi posizionate)\n" + 
        "/help (Comando che mostra la lista dei comandi)\n" + 
        "/mostranavi (Comando che mostra una legenda delle navi disponibili nel gioco)\n" + 
        "/mostralivello (Comando che mostra il livello al quale si sta giocando fra facile, medio e difficile)\n" + 
        "/esci (Comando che fa uscire dalla partita)\n" +
        "/facile (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n" +
        "/medio (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n" +
        "/difficile (Comando chiamabile solamente prima di iniziare la partita, imposta il livello di difficolta')\n");
    }
    
    public static void StampaDescrizione(){
        System.out.print("Benvenuto in battaglia navale \n" + 
            "l'obbiettivo del gioco e' distruggere tutte le navi dell'avversario entro un tot di mosse \n" + 
            "scrivi /help per ulteriori informazioni");
    }
        
}

