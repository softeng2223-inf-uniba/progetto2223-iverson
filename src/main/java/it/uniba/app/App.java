package it.uniba.app;

import it.uniba.game.UI.Comando;

/**
 * Main class of the application.
 */
public final class App {
    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        Comando.StampaDescrizione();
        for (String string : args) {
            if (string.equals("--help") || string.equals("-h")){
                Comando.StampaHelp();
            }
        }
       
    }
}