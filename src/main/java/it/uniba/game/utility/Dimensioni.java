package it.uniba.game.utility;

public enum Dimensioni {
    
    CACCIATORPEDINIERE(2),
    CORAZZATA(4),
    INCROCIATORE(3),
    PORTAEREI(5);

    private int value;

     /**
     * Costruttore della classe enum.
     * @param value Puó essere una dimensione valida in base.
     */
    private Dimensioni(int value) {
        this.value = value;
    }

    /**
     * Funzione che restituisce il valore dell'enum.
     * @return value il valore dell'enum
     */
    public int getValue() {
        return value;
    }
}
