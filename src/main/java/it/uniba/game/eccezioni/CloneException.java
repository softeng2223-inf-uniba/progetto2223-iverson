package it.uniba.game.eccezioni;

/**
 * Eccezione da lanciare quando si fallisce la clonazione.
 */
public class CloneException extends CloneNotSupportedException {

    /**
     * Costruttore, non fornisce ulteriori informazion
     * sul motivo del lancio dell'eccezione.
    */
    CloneException() {
        super();
    }

    /**
     * Costruttore, fornisce ulteriori informazioni sul lancio dell'eccezione.
     *
     * @param message messaggio contenente ulteriori informazioni sul lancio
     * dell'eccezione
     */
    public CloneException(final String message) {
        super(message);
    }

    /**
     * Restituisce lo stato di tale eccezione in forma di stringa.
     *
     * @return stato dell'eccezione
     */
    public String toString() {
        return getMessage();
    }
}
