package it.uniba.game.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test per la classe Tabella.
 */
class TabellaTest {
    private static final int VALORE_STANDARD = 10;
    private static final int VALORE_LARGE = 18;
    private static final int VALORE_EXTRALARGE = 26;

    /**
     * Verifica che il metodo getValue() restituisca il valore corretto per l'enum STANDARD.
     */
    @Test
    void testGetValueStandard() {
        Tabella tabella = Tabella.STANDARD;
        int expectedValue = VALORE_STANDARD;
        int actualValue = tabella.getValue();
        assertEquals(expectedValue, actualValue, "Il valore restituito per STANDARD deve essere " + expectedValue);
    }

    /**
     * Verifica che il metodo getValue() restituisca il valore corretto per l'enum LARGE.
     */
    @Test
    void testGetValueLarge() {
        Tabella tabella = Tabella.LARGE;
        int expectedValue = VALORE_LARGE;
        int actualValue = tabella.getValue();
        assertEquals(expectedValue, actualValue, "Il valore restituito per LARGE deve essere " + expectedValue);
    }

    /**
     * Verifica che il metodo getValue() restituisca il valore corretto per l'enum EXTRALARGE.
     */
    @Test
    void testGetValueExtraLarge() {
        Tabella tabella = Tabella.EXTRALARGE;
        int expectedValue = VALORE_EXTRALARGE;
        int actualValue = tabella.getValue();
        assertEquals(expectedValue, actualValue, "Il valore restituito per EXTRALARGE deve essere " + expectedValue);
    }
}
