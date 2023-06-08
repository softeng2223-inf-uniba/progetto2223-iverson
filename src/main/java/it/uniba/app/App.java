package it.uniba.app;

import it.uniba.game.UI.Comando;
import it.uniba.game.UI.Stampa;
import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

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
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     *         coordinate rispetto alla sua dimensione
     * @throws PosizioneException nel caso in cui si inserisce una posizione non disponibile
     */
    public static void main(final String[] args) {
        Comando comando = new Comando();
        Stampa stampa = new Stampa();
        stampa.stampaDescrizione();
        for (String string : args) {
            if (string.equals("--help") || string.equals("-h")) {
                stampa.stampaHelp();
            }
        }
        try {
            comando.menu();
        } catch (NumeroCoordinateException | PosizioneException e) {
            System.out.println(e.getMessage());
        }

    }

}
