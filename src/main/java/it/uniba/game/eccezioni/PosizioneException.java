package it.uniba.game.eccezioni;

/**
 * {@literal <<Boundary>>} Eccezione da lanciare quando la posizione inserita è sbagliata.
 */
public class PosizioneException extends Exception {

    /**
     * Costruttore, fornisce ulteriori informazioni sul lancio dell'eccezione.
     * @param message messaggio contenente ulteriori informazioni sul lancio
     * dell'eccezione
     */
    public PosizioneException(final String message) {
        super(message);
    }

    /**
     * Restituisce lo stato di tale eccezione in forma di stringa.
     * @return stato dell'eccezione
     */
    public String toString() {
        return getMessage();
    }
}
