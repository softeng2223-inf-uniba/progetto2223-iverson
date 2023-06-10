package it.uniba.utility;

import it.uniba.game.logic.PartitaLogic;
import it.uniba.game.utility.Controlli;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
        // Inizializza oggetto PartitaLogic secondo le tue esigenze
    }

    /**
     * Test per il metodo isInteger quando la stringa contiene un numero valido.
     */
    @Test
    void testIsIntegerConNumeroValido() {
        boolean result = controlli.isInteger("123");
        Assertions.assertTrue(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa contiene un numero non valido.
     */
    @Test
    void testIsIntegerConNumeroNonValido() {
        boolean result = controlli.isInteger("123a");
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa è null.
     */
    @Test
    void testIsIntegerConStringaNull() {
        boolean result = controlli.isInteger(null);
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isInteger quando la stringa è vuota.
     */
    @Test
    void testIsIntegerConStringaVuota() {
        boolean result = controlli.isInteger("");
        Assertions.assertFalse(result);
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata è valida.
     */
    @Test
    void testIsCoordinataConCoordinataValida() {
        boolean result = controlli.isCoordinata("A-1", partita);
        Assertions.assertTrue(result);
    }

    /**
     * Test per il metodo isCoordinata quando la coordinata non è valida.
     */
    @Test
    void testIsCoordinataConCoordinataNonValida() {
        boolean result = controlli.isCoordinata("A-11", partita);
        Assertions.assertFalse(result);
    }

    // Altri test per i diversi casi possibili

}
