package it.uniba.game.eccezioni;

/**
 * {@literal <<Boundary>>} Eccezione da lanciare quando si inseriscono un numero diverso di coordinate
 * rispetto alla sua dimensione.
 */
public class NumeroCoordinateException extends Exception {


    /**
     * Costruttore, fornisce ulteriori informazioni sul lancio dell'eccezione.
     *
     * @param message messaggio contenente ulteriori informazioni sul lancio
     * dell'eccezione
     */
    public NumeroCoordinateException(final String message) {
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
