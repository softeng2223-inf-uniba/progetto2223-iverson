package it.uniba.game.utility;

import it.uniba.game.logic.PartitaLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di test per la classe Controlli.
 */
class ControlliTest {

    private Controlli controlli;
    private PartitaLogic partita;

    /**
     * Preparazione delle istanze necessarie per i test.
     */
    @BeforeEach
    void setUp() {
        controlli = new Controlli();
        partita = new PartitaLogic();
    }

    /**
     * Test per il metodo isInteger quando la stringa contiene un numero valido.
     */
    @Test
    @DisplayName("Test per testIsIntegerConNumeroValido()")
     void testIsIntegerConNumeroValido() {
        boolean result = controlli.isInteger("123");
        assertTrue(result, "Stringa con numero non valido");
    }

    /**
     * Test per il metodo isInteger quando la stringa contiene un numero non valido.
     */
    @Test
    @DisplayName("Test per testIsIntegerConNumeroNonValido()")
    void testIsIntegerConNumeroNonValido() {
        boolean result = controlli.isInteger("123a");
        assertFalse(result, "Stringa con numero valido");
    }

    /**
     * Test per il metodo isInteger quando la stringa è null.
     */
    @Test
    @DisplayName("Test per testIsIntegerConStringaNull()")
    void testIsIntegerConStringaNull() {
        boolean result = controlli.isInteger(null);
        assertFalse(result, "Stringa non null");
    }

    /**
     * Test per il metodo isInteger quando la stringa è vuota.
     */
    @Test
    @DisplayName("Test per testIsIntegerConStringaVuota()")
    void testIsIntegerConStringaVuota() {
        boolean result = controlli.isInteger("");
        assertFalse(result, "Stringa non vuota");
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata è valida.
     */
    @Test
    @DisplayName("Test per testIsCoordinataConCoordinataValida()")
    void testIsCoordinataConCoordinataValida() {
        boolean result = controlli.isCoordinata("A-1", partita);
        assertTrue(result, "Coordinata non valida");
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata non è valida.
     */
    @Test
    @DisplayName("Test per testIsCoordinataConCoordinataNonValida()")
    void testIsCoordinataConCoordinataNonValida() {
        boolean result = controlli.isCoordinata("A-11", partita);
        assertFalse(result, "Coordinata valida");
    }

}
