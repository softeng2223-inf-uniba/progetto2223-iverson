package it.uniba.game.utility;

/**
 * Classe enum che contiene i valori di difficolta
 */
public enum Difficolta{
    FACILE(50),
    MEDIO(30),
    DIFFICILE(10);
     
    private int value;
    
    /**
     * Costruttore della classe enum
     * @param value in base 10, 30, 50 viene definito il valore dell'enum
     */
    private Difficolta(int value) {
        this.value = value;
    }

    /**
     * Funzione che restituisce il valore dell'enum
     * @return value il valore dell'enum
     */
    public int getValue() {
        return value;
    }
}