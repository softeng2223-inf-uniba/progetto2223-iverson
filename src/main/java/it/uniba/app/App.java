package it.uniba.app;

import it.uniba.game.UI.Comando;
import it.uniba.game.eccezioni.NumeroCoordinateException;

/**
 * Main class of the application.
 */
public final class App {
    /**
     * Costruttore privato per prevenire inizializzazioni.
     */
    private App() {

    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        Comando comando = new Comando();
        comando.stampaDescrizione();
        for (String string : args) {
            if (string.equals("--help") || string.equals("-h")) {
                comando.stampaHelp();
            }
        }
        try {
            comando.avvia();
        }
        catch (NumeroCoordinateException e) {
            System.out.println(e.getMessage());
        }

    }

}