package it.uniba.app;

import it.uniba.game.UI.Comando;
import it.uniba.game.eccezioni.NumeroCoordinateException;

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
        try{

            Comando.avvia();
        }
        catch (NumeroCoordinateException e)
        {
            System.out.println(e.getMessage());
        }
       
    }
}