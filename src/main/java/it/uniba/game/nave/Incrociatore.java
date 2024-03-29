package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.utility.Dimensioni;
/**
 * {@literal <<Entity>>} Classe che estende la classe Nave e rappresenta un particolare
 * tipo di nave caratterizzato dalla dimensione di 3 caselle nella mappa di gioco.
 */
public class Incrociatore extends Nave {
    /**
     * Costruttore di Incrociatore.
     *
     * @param coordinate elenco di coordinate che occupa che deve essere di
     * dimensione 3
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    public Incrociatore(final Coordinata[] coordinate) throws NumeroCoordinateException {
        super(Dimensioni.valueOf("INCROCIATORE").getDim(), coordinate, false);
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
