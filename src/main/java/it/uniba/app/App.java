package it.uniba.app;

import it.uniba.game.UI.Comando;
import it.uniba.game.UI.Stampa;
import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

/**
 * Main class of the application.
 */
public final class App {
    private static final Stampa STAMPA = new Stampa();
    private static final Comando  COMANDO = new Comando();
    /**
     * Costruttore privato per prevenire inizializzazioni.
     */
    private App() {

    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *         coordinate rispetto alla sua dimensione
     * @throws PosizioneException nel caso in cui si inserisce una posizione non disponibile
     */
    public static void main(final String[] args) {
        STAMPA.stampaDescrizione();

        if (args != null) {
            help(args);
        }

        try {
            COMANDO.menu();
        } catch (NumeroCoordinateException | PosizioneException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Metodo che esegue solo la stampa dell'help.
     * @param args command line arguments
     */
     static void help(final String[] args) {
        for (String string : args) {
            if (string.equals("--help") || string.equals("-h")) {
                STAMPA.stampaHelp();
            }
        }
    }
}
