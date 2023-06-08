package it.uniba.game.nave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.game.eccezioni.CloneException;
import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;

/**
 * Test per la classe Nave.
 */
class NaveTest {
    private static final int COORDINATE_RIGA_1 = 1;
    private static final int COORDINATE_COLONNA_1 = 1;
    private static final int COORDINATE_COLONNA_2 = 2;
    private static final int COORDINATE_COLONNA_3 = 3;
    private static final int COORDINATE_COLONNA_4 = 4;
    private static final int COORDINATE_COLONNA_5 = 5;

    private Portaerei portaerei;

    /**
     * Inizializzazione prima di ogni test.
     *
     * @throws NumeroCoordinateException se si verifica un'eccezione durante la creazione delle coordinate.
     */
    @BeforeEach
    void setUp() throws NumeroCoordinateException {
        Coordinata[] coordinate = {
            new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
            new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
            new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
            new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_4),
            new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_5) };
        portaerei = new Portaerei(coordinate);
    }

    /**
     * Test per il metodo getDim.
     */
    @Test
    @DisplayName("Test restituzione corretta della dimensione")
    void testGetDim() {
        int dim = portaerei.getdim();
        Assertions.assertEquals(COORDINATE_COLONNA_5, dim);
    }

    /**
     * Test per il metodo getCoordinate.
     *
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alle coordinate.
     */
    @Test
    @DisplayName("Test restituzione corretta della coordinata")
    void testGetCoordinate() throws PosizioneException {
        Coordinata coordinata = portaerei.getcoordinate(2);
        Assertions.assertEquals(1, coordinata.getriga());
        Assertions.assertEquals(COORDINATE_COLONNA_3, coordinata.getcolonna());
    }

    /**
     * Test per il metodo setCoordinate.
     *
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alle coordinate.
     * @throws CloneException se si verifica un'eccezione durante la clonazione della coordinata.
     */
    @Test
    @DisplayName("Test impostazione corretta della coordinata")
    void testSetCoordinate() throws PosizioneException, CloneException {
        Coordinata nuovaCoordinata = new Coordinata(2, 2);
        portaerei.setcoordinate(1, nuovaCoordinata);
        Coordinata coordinata = portaerei.getcoordinate(1);
        Assertions.assertEquals(2, coordinata.getriga());
        Assertions.assertEquals(2, coordinata.getcolonna());
    }

    /**
     * Test per il metodo setAffondata.
     */
    @Test
    @DisplayName("Test impostazione corretta della nave affondata")
    void testSetAffondata() {
        portaerei.setaffondata();
        boolean affondata = portaerei.getaffondata();
        Assertions.assertTrue(affondata);
    }

    /**
     * Test per il metodo toString.
     */
    @Test
    @DisplayName("Test restituzione corretta dello stato")
    void testToString() {
        String stato = portaerei.toString();
        Assertions.assertEquals("false", stato);
    }
}




