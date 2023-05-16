package it.uniba.game.eccezioni;

/**
 * Eccezione da lanciare quando si inseriscono un numero diverso di coordinate
 * rispetto alla sua dimensione
 */
public class NumeroCoordinateException extends Exception {
	/**
	 * Costruttore, non fornisce ulteriori informazioni
	 * sul motivo del lancio dell'ecceione
	 */
	NumeroCoordinateException() {
		super();
	}

	/**
	 * Costruttore, fornisce ulteriori informazioni sul lancio dell'eccezione
	 * 
	 * @param message messaggio contenente ulteriori informazioni sul lancio
	 *                dell'eccezione
	 */
	public NumeroCoordinateException(String message) {
		super(message);
	}

	/**
	 * Restituisce lo stato di tale eccezione in forma di stringa
	 * 
	 * @return stato dell'eccezione
	 */
	public String toString() {
		return getMessage();
	}

}
