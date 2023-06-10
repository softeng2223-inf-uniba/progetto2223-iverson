package it.uniba.game.utility;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe di test per la classe enum Difficolta.
 */
class DifficoltaTest {

    private static final int VALORE_FACILE = Difficolta.FACILE.getValue();
    private static final int VALORE_MEDIO = Difficolta.MEDIO.getValue();
    private static final int VALORE_DIFFICILE = Difficolta.DIFFICILE.getValue();

    private static final int VERIFICATORE = 3;

    /**
     * Verifica che il valore restituito da Difficolta.FACILE.getValue() sia corretto.
     */
    @Test
    void testGetValueFacile() {
        Difficolta difficolta = Difficolta.FACILE;
        int actualValue = difficolta.getValue();
        assertEquals("Valore errato per Difficolta.FACILE", VALORE_FACILE, actualValue);
    }

    /**
     * Verifica che il valore restituito da Difficolta.MEDIO.getValue() sia corretto.
     */
    @Test
    void testGetValueMedio() {
        Difficolta difficolta = Difficolta.MEDIO;
        int actualValue = difficolta.getValue();
        assertEquals("Valore errato per Difficolta.MEDIO", VALORE_MEDIO, actualValue);
    }

    /**
     * Verifica che il valore restituito da Difficolta.DIFFICILE.getValue() sia corretto.
     */
    @Test
    void testGetValueDifficile() {
        Difficolta difficolta = Difficolta.DIFFICILE;
        int actualValue = difficolta.getValue();
        assertEquals("Valore errato per Difficolta.DIFFICILE", VALORE_DIFFICILE, actualValue);
    }

    /**
     * Verifica che l'enumerazione Difficolta contenga i valori corretti e nel giusto ordine.
     */
    @Test
    void testEnumValues() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals("Numero di valori errato per l'enumerazione Difficolta", VERIFICATORE, difficolte.length);
    }

    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.FACILE.
     */
    @Test
    void testEnumFACILE() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals("Ordine errato per Difficolta.FACILE", Difficolta.FACILE, difficolte[0]);
    }
    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.MEDIO.
     */
    @Test
    void testEnumMEDIO() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals("Ordine errato per Difficolta.MEDIO", Difficolta.MEDIO, difficolte[1]);
    }
    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.DIFFICILE.
     */
    @Test
    void testEnumDIFFICILE() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals("Ordine errato per Difficolta.DIFFICILE", Difficolta.DIFFICILE, difficolte[2]);
    }
}
