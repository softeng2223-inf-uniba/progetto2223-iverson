package it.uniba.game.utility;
/**
 * Classe enum che rappresenta i valori di dimensioni.
 */
public enum Dimensioni {
    CACCIATORPEDINIERE(0, 2, 4),
    INCROCIATORE(1, 3, 3),
    CORAZZATA(2, 4, 2),
    PORTAEREI(3, 5, 1);

    private int dim;
    private int esemplari;
    private int index;
     /**
     * Costruttore della classe enum.
     * @param pIndex Indica un indice con la quale si riferisce al numero che contraddistringue
     * la nave in fase di inserimento
     * @param pDim Puó essere una dimensione valida.
     * @param pEsemplari Può essere un numero di esemplari.
     */
    Dimensioni(final int pIndex, final int pDim, final int pEsemplari) {
        this.dim = pDim;
        this.esemplari = pEsemplari;
        this.index = pIndex;
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

    /**
     * Funzione che restituisce l'indice della nave.
     * @return index il valore dell'indice della nave.
     */
    public int getIndex() {
        return index;
    }
}
