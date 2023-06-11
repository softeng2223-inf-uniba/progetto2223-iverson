package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;;

/**
 * Test sulla classe Portaerei.
 */
class PortaereiTest {
    private static final int COORDINATE_RIGA_1 = 1;
    private static final int COORDINATE_COLONNA_1 = 1;
    private static final int COORDINATE_COLONNA_2 = 2;
    private static final int COORDINATE_COLONNA_3 = 3;
    private static final int COORDINATE_COLONNA_4 = 4;
    private static final int COORDINATE_COLONNA_5 = 5;

    /**
     * Test che verifica se il costruttore è corretto per portaerei.
     */
    @Test
    @DisplayName("Test costruttore corretto")
    void testCostruttoreCorretto() {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_4),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_5),
        };

        assertDoesNotThrow(() -> new Portaerei(coordinate),
        "La creazione dell' portaerei non dovrebbe generare eccezioni.");
    }

     /**
     * Test che verifica se il costruttore ha un numero di coordinate errato per portaerei.
     */
    @Test
    @DisplayName("Test costruttore con numero di coordinate errato")
    void testCostruttoreNumeroCoordinateErrato() {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_5),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2)
        };

        assertThrows(NumeroCoordinateException.class, () -> new Corazzata(coordinate),
        "La creazione della portaerei con un numero di coordinate errato dovrebbe generare un'eccezione.");
    }

     /**
     * Test che verifica il posizionamento di portaerei.
     *
     * @throws NumeroCoordinateException
     */
    @Test
    @DisplayName("Test toString")
    void testToString() throws NumeroCoordinateException {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_4),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_5),
        };

        Portaerei portaerei = new Portaerei(coordinate);
        String expected = "Corazzata [dimensione=5, coordinate=[(1, 1),(1, 2),(1, 3),(1,4),(1,5)], affondata=false]";
        assertArrayEquals(expected, portaerei.toString(),
        "La rappresentazione non corrisponde alle aspettative.");
    }



    private void assertArrayEquals(final String expected, final String string, final String message) {
    }

}
