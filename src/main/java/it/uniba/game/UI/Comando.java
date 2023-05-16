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

                    break;

                case "/facile":

                    break;

                case "/medio":

                    break;

                case "/difficile":

                    break;

                case "/mostranavi":

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

}
