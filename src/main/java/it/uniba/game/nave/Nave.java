package it.uniba.game.nave;

import it.uniba.game.eccezioni.CloneException;
import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

/**
 * <<Entity>> Classe che definisce le proprietà di una Nave, intesa come elemento della mappa di gioco.
 */
public abstract class Nave {
    private final int dim;
    private final Coordinata[] coordinate;
    private boolean affondato;

    /**
     * Costruttore di Nave.
     *
     * @param pDim  dimensione della nave
     * @param pCoordinate  elenco di coordinate che occupa
     * @param pAffondato  identifica se la nave è affondata
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    Nave(final int pDim, final Coordinata[] pCoordinate, final  boolean pAffondato) throws NumeroCoordinateException {
        if (pCoordinate.length == pDim) {
            this.dim = pDim;
            this.coordinate = pCoordinate;
            this.affondato = pAffondato;
        } else {
            throw new NumeroCoordinateException("E' stato inserito un array"
                    + " con un numero diverso di coordinate rispetto alla sua dimensione");
        }

    }

    /**
     * Restituisce la dimensione della nave.
     *
     * @return dimensione della Nave
     */
    public int getdim() {
        return this.dim;
    }

    /**
     * Restituisce la coordinata ad una detarminata posizione.
     *
     * @param pos : posizione della cordinata
     * @return posizione della Nave
     * @throws PosizioneException : in caso in cui la posizione richiesta non è
     * disponibile
     */
    public Coordinata getcoordinate(final int pos) throws PosizioneException {
        if (pos < this.dim && pos >= 0) {
            return this.coordinate[pos];
        } else {
            throw new PosizioneException("Posizione non disponibile");
        }
    }

    /**
     * Imposta la coordinata ad una detarminata posizione.
     *
     * @param pos  : posizione su cui impostare la coordinata
     * @param coor : coordinata da impostare
     * @throws CloneException     : in caso in cui si verifichi un errore nella
     * clonazione della coordinata
     * @throws PosizioneException : in caso in cui la posizione richiesta non è
     * disponibile
     */
    public void setcoordinate(final int pos, final Coordinata coor) throws CloneException, PosizioneException {
        if (pos < this.dim && pos >= 0) {
            try {
                this.coordinate[pos] = (Coordinata) coor.clone();
            } catch (CloneNotSupportedException e) {
                throw new CloneException("Impossibile clonare la coordinata");
            }
        } else {
            throw new PosizioneException("Posizione non disponibile");
        }
    }

    /**
     * Restituisce lo stato della nave,vero se è affondata, falso altrimenti.
     *
     * @return lo stato della Nave
     */
    public boolean getaffondata() {
        return this.affondato;
    }

    /**
     * Imposta lo stato della nave affondata.
     */
    public void setaffondata() {
        this.affondato = true;
    }

    /**
     * Restituisce lo stato della Nave.
     *
     * @return stato della Nave
     */
    public String toString() {
        return String.valueOf(this.affondato);
    }
}
