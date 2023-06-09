package it.uniba.game.partita;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe di Test per la classe di Partita.
 */
class PartitaTest {
    private Partita partita;

    /**
     * Metodo per inizialixxare le istanze di Partita prima di ogni test.
     */
    @BeforeEach
    void setup() {
        partita = new Partita();
    }

    @Test
    @DisplayName("Test getStartTime")
    /**
     * Test per il metodo che fa iniziare il tempo.
     */
    void testGetStartTime() {
        partita.setStartTime(12345);
        long startTime = partita.getStartTime();
        Assertions.assertEquals(12345, startTime);
    }

    @Test
    @DisplayName("Test getErrorePerLivello")
    /**
     * 
     *  Test per il metodo che prende gli eorri per ogni livello.
     */
    void testGetErrorePerLivello() {
        int erroriFacile = partita.getErrorePerLivello("FACILE");
        Assertions.assertEquals(50, erroriFacile);
        int erroriMedio = partita.getErrorePerLivello("MEDIO");
        Assertions.assertEquals(30, erroriMedio);
         int erroriDifficile = partita.getErrorePerLivello("DIFFICILE");
        Assertions.assertEquals(10, erroriDifficile);
    }

    @Test
    @DisplayName("Test setErroriPerLivello")
    /**
     *  Test per il metodo che imposta gli errori per livello.
     */
    void testSetErroriPerLivello() {
        partita.setErroriPerLivello("FACILE", 10);
        int erroriFacile = partita.getErrorePerLivello("FACILE");
        Assertions.assertEquals(10, erroriFacile);
        partita.setErroriPerLivello("MEDIO", 5);
        int erroriMedio = partita.getErrorePerLivello("MEDIO");
        Assertions.assertEquals(5, erroriMedio);
    }

    @Test
    @DisplayName("Test getLivello")
    /**
     *  Test per il metodo che prende il livello.
     */
    void testGetLivello() {
        String livelloFacile = partita.getLivello();
        Assertions.assertEquals("FACILE", livelloFacile);
    }

    @Test
    @DisplayName("Test setLivello")
    /**
     *  Test per il metodo che imposta il livello.
     */
    void testSetLivello() {
        partita.setLivello("FACILE");
        String livelloFacile = partita.getLivello();
        Assertions.assertEquals("FACILE", livelloFacile);
        partita.setLivello("MEDIO");
        String livelloMedio = partita.getLivello();
        Assertions.assertEquals("MEDIO", livelloMedio);
        partita.setLivello("DIFFICILE");
        String livelloDifficile = partita.getLivello();
        Assertions.assertEquals("DIFFICILE", livelloDifficile);
    }

    @Test
    @DisplayName("Test getNumMaxErrori")
    /**
     *  Test per il metodo che prende il numero massimo di errori.
     */
    void testGetNumMaxErrori() {
        int numMaxErrori = partita.getNumMaxErrori();
        Assertions.assertEquals(50, numMaxErrori);
    }

    @Test
    @DisplayName("Test setNumMaxErrori")
    /**
     *  Test per il metodo che imposta il numero massimo di errori.
     */
    void testSetNumMaxErrori() {
        partita.setNumMaxErrori(5);
        int numMaxErrori = partita.getNumMaxErrori();
        Assertions.assertEquals(5, numMaxErrori);
    }

    @Test
    @DisplayName("Test getErroriCorrenti")
    /**
     *  Test per il metodo prende gli errori correnti.
     */
    void testGetErroriCorrenti() {
        int erroriCorrenti = partita.getErroriCorrenti();
        Assertions.assertEquals(0, erroriCorrenti);
    }

    @Test
    @DisplayName("Test setErroriCorrenti")
    /**
     *  Test per il metodo che imposta gli errori correnti.
     */
    void testSetErroriCorrenti() {
        partita.setErroriCorrenti(2);
        int erroriCorrenti = partita.getErroriCorrenti();
        Assertions.assertEquals(2, erroriCorrenti);
    }

    @Test
    @DisplayName("Test getColpiTotali")
    /**
     *  Test per il metodo prende lo stato di colpito.
     */
    void testGetColpiTotali() {
        int colpiTotali = partita.getColpiTotali();
        Assertions.assertEquals(0, colpiTotali);
    }

    @Test
    @DisplayName("Test setColpiTotali")
    /**
     *  Test per il metodo imposta lo stato in colpito.
     */
    void testSetColpiTotali() {
        partita.setColpiTotali(10);
        int colpiTotali = partita.getColpiTotali();
        Assertions.assertEquals(10, colpiTotali);
    }

    @Test
    @DisplayName("Test statoPartita")
    /**
     *  Test per il metodo che mostra lo stato della partita.
     */
    void testStatoPartita() {
        boolean statoPartita = partita.statoPartita();
        Assertions.assertFalse(statoPartita);
    }

    @Test
    @DisplayName("Test setDimMax")
    /**
     *  Test per il metodo che imposta la dimensione massima della griglia di gioco.
     */
    void testSetDimMax() {
        partita.setDimMax(10);
        int dimMax = partita.getDimMax();
        Assertions.assertEquals(10, dimMax);
    }

    @Test
    @DisplayName("Test getDimMax")
    /**
     *  Test per il metodo prende la dimensione massima dimensione massima della griglia di gioco.
     */
    void testGetDimMax() {
        int dimMax = partita.getDimMax();
        Assertions.assertEquals(10, dimMax);
    }

    @Test
    @DisplayName("Test setInCorso")
    /**
     *  Test per il metodo imposta lo stato della partita in in corso.
     */
    void testSetInCorso() {
        partita.setInCorso(true);
        boolean inCorso = partita.statoPartita();
        Assertions.assertTrue(inCorso);
    }

    @Test
    @DisplayName("Test setTempoMax")
    /**
     *  Test per il metodo imposta il tempo al massimo.
     */
    void testSetTempoMax() {
        partita.setTempoMax(60);
        int tempoMax = partita.getTempoMax();
        Assertions.assertEquals(60, tempoMax);
    }

    @Test
    @DisplayName("Test getTempoMax")
    /**
     *  Test per il metodo prende il tempo massimo.
     */
    void testGetTempoMax() {
        int tempoMax = partita.getTempoMax();
        Assertions.assertEquals(0, tempoMax);
    }
}



