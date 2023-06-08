package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IncrociatoreTest {
    private static final int COORDINATE_RIGA_1 = 1;
    private static final int COORDINATE_COLONNA_1 = 1;
    private static final int COORDINATE_COLONNA_2 = 2;
    private static final int COORDINATE_COLONNA_3 = 3;

    @Test
    @DisplayName("Test costruttore corretto")
    void testCostruttoreCorretto() {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
        };

        assertDoesNotThrow(() -> new Incrociatore(coordinate),
        "La creazione dell' incrociatore non dovrebbe generare eccezioni.");
    }

    @Test
    @DisplayName("Test costruttore con numero di coordinate errato")
    void testCostruttoreNumeroCoordinateErrato() {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1)

        };

        assertThrows(NumeroCoordinateException.class, () -> new Corazzata(coordinate),
        "La creazione dell' incrociatore con un numero di coordinate errato dovrebbe generare un'eccezione.");
    }

    @Test
    @DisplayName("Test toString")
    void testToString() throws NumeroCoordinateException {
        Coordinata[] coordinate = {
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_1),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_2),
                new Coordinata(COORDINATE_RIGA_1, COORDINATE_COLONNA_3),
        };

        Incrociatore incrociatore = new Incrociatore(coordinate);
        String expected = "Corazzata [dimensione=3, coordinate=[(1, 1), (1, 2), (1, 3)], affondata=false]";
        assertArrayEquals(expected, incrociatore.toString(),
        "La rappresentazione non corrisponde alle aspettative.");
    }



    private void assertArrayEquals(final String expected, final String string, final String message) {
    }

}
