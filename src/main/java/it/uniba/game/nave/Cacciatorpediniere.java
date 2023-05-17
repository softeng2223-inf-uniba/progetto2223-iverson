package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.utility.Dimensioni;
/**
 * Classe che estende la classe Nave definendo la dimensione.
 */
public class Cacciatorpediniere extends Nave {
    /**
     * Costruttore di Cacciatorpediniere.
     *
     * @param coordinate elenco di coordinate che occupa che deve essere di
     * dimensione 2
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    public Cacciatorpediniere(final Coordinata[] coordinate) throws NumeroCoordinateException {
        super(Dimensioni.valueOf("CACCIATORPEDINIERE").getDim(), coordinate, false);
    }

    /**
     * Restituisce lo stato del Cacciatorpediniere.
     *
     * @return stato della Cacciatorpediniere
     */
    public String toString() {
        return super.toString();
    }

}
