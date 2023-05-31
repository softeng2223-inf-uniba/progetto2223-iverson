package it.uniba.game.utility;

/**
 * Classe enum che contiene i valori del tempo.
 */
public enum Tempo {
    MILLISECONDI(1000),
    SECONDI(60);


    private int tempo;

    /**
     * Costruttore della classe enum.
     * @param pTempo in base 60,1000 viene definito il valore dell'enum
     */
    Tempo(final int pTempo) {
        this.tempo = pTempo;
    }

    /**
     * Funzione che restituisce il valore dell'enum.
     * @return tempo il valore dell'enum
     */
    public int getValue() {
        return tempo;
    }
}
