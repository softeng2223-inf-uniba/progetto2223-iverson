package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.utility.Dimensioni;
/**
 * <<<Entity>> Classe che estende la classe Nave e rappresenta un particolare tipo di nave
 * caratterizzato dalla dimensione di 5 caselle nella mappa di gioco.
 */
public class Portaerei extends Nave {
    /**
     * Costruttore di Portaerei.
     *
     * @param coordinate elenco di coordinate che occupa che deve essere di
     * dimensione 5
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione
     */
    public Portaerei(final Coordinata[] coordinate) throws NumeroCoordinateException {
        super(Dimensioni.valueOf("PORTAEREI").getDim(), coordinate, false);
    }

    /**
     * Restituisce lo stato del Portaerei.
     *
     * @return stato della Portaerei
     */
    public String toString() {
        return super.toString();
    }

}
