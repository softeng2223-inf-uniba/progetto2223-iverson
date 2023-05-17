package it.uniba.game.utility;

/**
 * Classe enum che contiene i valori di difficolta.
 */
public enum Difficolta {
    FACILE(50),
    MEDIO(30),
    DIFFICILE(10);

    private int value;

    /**
     * Costruttore della classe enum.
     * @param pValue in base 10, 30, 50 viene definito il valore dell'enum
     */
    Difficolta(final int pValue) {
        this.value = pValue;
    }

    /**
     * Funzione che restituisce il valore dell'enum.
     * @return value il valore dell'enum
     */
    public int getValue() {
        return value;
    }
}
