package it.uniba.game.utility;

/**
 * Classe enum che contiene i valori delle dimensioni della tabella.
 */
public enum Tabella {
    STANDARD(10),
    LARGE(18),
    EXTRALARGE(26);

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
