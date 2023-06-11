package it.uniba.game.nave;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test sulla classe Cacciatorpediniere.
 */
class CacciatorpediniereTest {

    /**
     * Test che verifica se il costruttore è corretto per cacciatorpediniere.
     */
    @Test
    @DisplayName("Test costruttore corretto")
    void testCostruttoreCorretto() {
        Coordinata[] coordinate = {new Coordinata(1, 1), new Coordinata(1, 2)};
        assertDoesNotThrow(() -> new Cacciatorpediniere(coordinate));
    }

    /**
     * Test che verifica se il costruttore ha un numero di coordinate errato per cacciatorpediniere.
     */
    @Test
    @DisplayName("Test costruttore con numero di coordinate errato")
    void testCostruttoreNumeroCoordinateErrato() {
        Coordinata[] coordinate = {new Coordinata(1, 1)};
        assertThrows(NumeroCoordinateException.class, () -> new Cacciatorpediniere(coordinate));
    }

    /**
     * Test che verifica il posizionamento di cacciatorpediniere.
     *
     * @throws NumeroCoordinateException
     */
    @Test
    @DisplayName("Test toString")
    void testToString() throws NumeroCoordinateException {
        Coordinata[] coordinate = {new Coordinata(1, 1), new Coordinata(1, 2)};
        Cacciatorpediniere cacciatorpediniere = new Cacciatorpediniere(coordinate);
        String[] expected = {"[1,1]", "[1,2]"};
        assertArrayEquals(expected, cacciatorpediniere.toString(),
        "La rappresentazione non corrisponde alle aspettative.");
    }

    private void assertArrayEquals(final String[] expected, final String string, final String message) {
    }
}




