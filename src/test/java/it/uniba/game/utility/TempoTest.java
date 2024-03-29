package it.uniba.game.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test per la classe Tempo.
 */

class TempoTest {
    private static final int VALORE_MILLISECONDI = 1000;
    private static final int VALORE_SECONDI = 60;


    /**
    * Verifica che il metodo getValue() restituisca il valore corretto per l'enum MILLISECONDI.
    */
    @Test
    @DisplayName("Test per testGetValueMillisecondi()")
    void testGetValueMillisecondi() {
        Tempo tempo = Tempo.MILLISECONDI;
        int expectedValue = VALORE_MILLISECONDI;
        int actualValue = tempo.getValue();
        assertEquals(expectedValue, actualValue, "Il valore restituito per MILLISECONDI deve essere " + expectedValue);
    }

    /**
    * Verifica che il metodo getValue() restituisca il valore corretto per l'enum SECONDI.
    */
    @Test
    @DisplayName("Test per testGetValueSecondi()")
    void testGetValueSecondi() {
        Tempo tempo = Tempo.SECONDI;
        int expectedValue = VALORE_SECONDI;
        int actualValue = tempo.getValue();
        assertEquals(expectedValue, actualValue, "Il valore restituito per SECONDI deve essere " + expectedValue);
    }
}
