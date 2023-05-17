package it.uniba.game.utility;
/**
 * Classe enum che rappresenta i valori di dimensioni.
 */
public enum Dimensioni {
    CACCIATORPEDINIERE(2,4),
    CORAZZATA(4,3),
    INCROCIATORE(3,2),
    PORTAEREI(5,1);

    private int dim;
    private int esemplari;
     /**
     * Costruttore della classe enum.
     * @param pValue Puó essere una dimensione valida.
     */
    Dimensioni(final int pDim, final int pEsemplari) {
        this.dim = pDim;
        this.esemplari = pEsemplari;
    }

    /**
     * Funzione che restituisce la dimensione delle navi.
     * @return dim il valore della dimensione delle navi.
     */
    public int getDim() {
        return dim;
    }

    /**
     * Funzione che restituisce il numero di esemplari di navi.
     * @return esemplari il numero di esemplari di navi.
     */
    public int getEsemplari() {
            return esemplari;
        }
}
