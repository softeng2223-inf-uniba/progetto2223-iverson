package it.uniba.game.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Test per testGetValueFacile()")
    void testGetValueFacile() {
        Difficolta difficolta = Difficolta.FACILE;
        int actualValue = difficolta.getValue();
        assertEquals(VALORE_FACILE, actualValue, "Valore errato per Difficolta.FACILE");
    }

    /**
     * Verifica che il valore restituito da Difficolta.MEDIO.getValue() sia corretto.
     */
    @Test
    @DisplayName("Test per testGetValueMedio()")
    void testGetValueMedio() {
        Difficolta difficolta = Difficolta.MEDIO;
        int actualValue = difficolta.getValue();
        assertEquals(VALORE_MEDIO, actualValue, "Valore errato per Difficolta.MEDIO");
    }

    /**
     * Verifica che il valore restituito da Difficolta.DIFFICILE.getValue() sia corretto.
     */
    @Test
    @DisplayName("Test per testGetValueDifficile()")
    void testGetValueDifficile() {
        Difficolta difficolta = Difficolta.DIFFICILE;
        int actualValue = difficolta.getValue();
        assertEquals(VALORE_DIFFICILE, actualValue, "Valore errato per Difficolta.DIFFICILE");
    }

    /**
     * Verifica che l'enumerazione Difficolta contenga i valori corretti e nel giusto ordine.
     */
    @Test
    @DisplayName("Test per testEnumValues()")
    void testEnumValues() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals(VERIFICATORE, difficolte.length, "Numero di valori errato per l'enumerazione Difficolta");
    }

    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.FACILE.
     */
    @Test
    @DisplayName("Test per testEnumFACILE()")
    void testEnumFACILE() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals(Difficolta.FACILE, difficolte[0], "Ordine errato per Difficolta.FACILE");
    }
    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.MEDIO.
     */
    @Test
    @DisplayName("Test per testEnumMEDIO()")
    void testEnumMEDIO() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals(Difficolta.MEDIO, difficolte[1], "Ordine errato per Difficolta.MEDIO");
    }
    /**
     * Verifica l'ordine dei valori nell'enumerazione Difficolta.DIFFICILE.
     */
    @Test
    @DisplayName("Test per testEnumDIFFICILE()")
    void testEnumDIFFICILE() {
        Difficolta[] difficolte = Difficolta.values();
        assertEquals(Difficolta.DIFFICILE, difficolte[2], "Ordine errato per Difficolta.DIFFICILE");
    }
}
