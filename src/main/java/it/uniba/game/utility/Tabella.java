package it.uniba.game.utility;

/**
 * Classe enum che contiene i valori delle dimensioni della tabella.
 */
public enum Tabella {
    STANDARD(10), // dimensione standard
    LARGE(18), // dimensione large
    EXTRALARGE(26); // dimensione extralarge

    private int value;

    /**
     * Costruttore della classe enum.
     * @param pValue in base 10, 18, 26 viene definito il valore dell'enum
     */
    Tabella(final int pValue) {
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
