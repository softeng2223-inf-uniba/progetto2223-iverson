package it.uniba.game.utility;
/**
 * Classe enum che rappresenta i valori di dimensioni.
 */
public enum Dimensioni {
    CACCIATORPEDINIERE(2),
    CORAZZATA(4),
    INCROCIATORE(3),
    PORTAEREI(5);

    private int value;

     /**
     * Costruttore della classe enum.
     * @param pValue Puó essere una dimensione valida in base.
     */
    private Dimensioni(final int pValue) {
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
