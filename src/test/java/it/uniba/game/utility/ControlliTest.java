package it.uniba.game.utility;

import it.uniba.game.logic.PartitaLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        Assertions.assertTrue(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa contiene un numero non valido.
     */
    @Test
    @DisplayName("Test per testIsIntegerConNumeroNonValido()")
    void testIsIntegerConNumeroNonValido() {
        boolean result = controlli.isInteger("123a");
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa è null.
     */
    @Test
    @DisplayName("Test per testIsIntegerConStringaNull()")
    void testIsIntegerConStringaNull() {
        boolean result = controlli.isInteger(null);
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa è vuota.
     */
    @Test
    @DisplayName("Test per testIsIntegerConStringaVuota()")
    void testIsIntegerConStringaVuota() {
        boolean result = controlli.isInteger("");
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata è valida.
     */
    @Test
    @DisplayName("Test per testIsCoordinataConCoordinataValida()")
    void testIsCoordinataConCoordinataValida() {
        boolean result = controlli.isCoordinata("A-1", partita);
        Assertions.assertTrue(result);
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata non è valida.
     */
    @Test
    @DisplayName("Test per testIsCoordinataConCoordinataNonValida()")
    void testIsCoordinataConCoordinataNonValida() {
        boolean result = controlli.isCoordinata("A-11", partita);
        Assertions.assertFalse(result);
    }

}
