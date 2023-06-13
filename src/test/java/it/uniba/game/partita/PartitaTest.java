package it.uniba.game.partita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Classe di Test per la classe di Partita.
 */
class PartitaTest {
    private static final int TEMPO = 10;
    private static final int FACILE = 50;
    private static final int MEDIO = 30;
    private static final int DIFFICILE = 10;
    private static final int NEW_ERRORI_F = 10;
    private static final int NEW_ERRORI_M = 5;
    private static final int NEW_ERRORI_D = 1;
    private static final int NUM_MAX_ERR = 10;
    private static final int COLPI_TOTALI = 10;
    private static final int DIM_MAX = 10;
    private static final int TEMPO_MAX = 60;




    private Partita partita;

    /**
     * Metodo per inizializzare le istanze di Partita prima di ogni test.
     */
    @BeforeEach
    void setup() {
        partita = new Partita();
    }

    /**
     * Test per il metodo che fa iniziare il tempo.
     */
    @Test
    @DisplayName("Test getStartTime")
    void testGetStartTime() {
        partita.setStartTime(TEMPO);
        long startTime = partita.getStartTime();
        assertEquals(TEMPO, startTime,
        "Errore il tempo non è iniziato");
    }

    /**
     *  Test per il metodo che prende gli erorri del livello FACILE.
     */
    @Test
    @DisplayName("Test getErrorePerLivelloFacile")
    void testGetErrorePerLivelloFacile() {
        int erroriFacile = partita.getErrorePerLivello("FACILE");
        assertEquals(FACILE, erroriFacile,
        "Errore gli errori non corrispondo al livello FACILE");
    }

    /**
     *  Test per il metodo che prende gli erorri del livello MEDIO.
     */
    @Test
    @DisplayName("Test getErrorePerLivelloMedio")
    void testGetErrorePerLivelloMedio() {
        int erroriMedio = partita.getErrorePerLivello("MEDIO");
        assertEquals(MEDIO, erroriMedio,
        "Errore gli errori non corrispondo al livello MEDIO");
    }

    /**
     *  Test per il metodo che prende gli erorri del livello DIFFICILE.
     */
    @Test
    @DisplayName("Test getErrorePerLivelloDifficile")
    void testGetErrorePerLivelloDifficile() {
         int erroriDifficile = partita.getErrorePerLivello("DIFFICILE");
        assertEquals(DIFFICILE, erroriDifficile,
        "Errore gli errori non corrispondo al livello DIFFICILE");
    }

    /**
     *  Test per il metodo che reimposta gli errori per il livello FACILE.
     */
    @Test
    @DisplayName("Test setErroriPerLivelloFACILE")
    void testSetErroriPerLivelloFacile() {
        partita.setErroriPerLivello("FACILE", NEW_ERRORI_F);
        int erroriFacile = partita.getErrorePerLivello("FACILE");
        assertEquals(NEW_ERRORI_F, erroriFacile,
        "Errore gli errori non sono stati reimpostati per il livello FACILE");
    }

    /**
     *  Test per il metodo che reimposta gli errori per il livello MEDIO.
     */
    @Test
    @DisplayName("Test setErroriPerLivelloMEDIO")
    void testSetErroriPerLivelloMedio() {
        partita.setErroriPerLivello("MEDIO", NEW_ERRORI_M);
        int erroriMedio = partita.getErrorePerLivello("MEDIO");
        assertEquals(NEW_ERRORI_M, erroriMedio,
        "Errore gli errori non sono stati reimpostati per il livello MEDIO");
    }

    /**
     *  Test per il metodo che reimposta gli errori per il livello DIFFICILE.
     */
    @Test
    @DisplayName("Test setErroriPerLivelloDIFFICILE")
    void testSetErroriPerLivelloDifficile() {
        partita.setErroriPerLivello("DIFFICILE", NEW_ERRORI_D);
        int erroriDifficile = partita.getErrorePerLivello("DIFFICILE");
        assertEquals(NEW_ERRORI_D, erroriDifficile,
        "Errore gli errori non sono stati reimpostati per il livello DIFFICILE");
    }

    /**
     *  Test per il metodo che prende il livello FACILE.
     */
    @Test
    @DisplayName("Test getLivelloFacile")
    void testGetLivelloFacile() {
        String livelloFacile = partita.getLivello();
        assertEquals("FACILE", livelloFacile,
        "Errore non è stato preso il livello FACILE");
    }

    /**
     *  Test per il metodo che imposta il livello FACILE.
     */
    @Test
    @DisplayName("Test setLivelloFacile")
    void testSetLivelloFacile() {
        partita.setLivello("FACILE");
        String livelloFacile = partita.getLivello();
        assertEquals("FACILE", livelloFacile,
        "Errore non è stato impostato il livello FACILE");
    }

     /**
     *  Test per il metodo che imposta il livello MEDIO.
     */
    @Test
    @DisplayName("Test setLivelloMedio")
    void testSetLivelloMedio() {
        partita.setLivello("MEDIO");
        String livelloMedio = partita.getLivello();
        assertEquals("MEDIO", livelloMedio,
        "Errore non è stato impostato il livello MEDIO");
    }

     /**
     *  Test per il metodo che imposta il livello DIFFICILE.
     */
    @Test
    @DisplayName("Test setLivelloDifficile")
    void testSetLivelloDifficile() {
        partita.setLivello("DIFFICILE");
        String livelloDifficile = partita.getLivello();
        assertEquals("DIFFICILE", livelloDifficile,
        "Errore non è stato impostato il livello DIFFICILE");
    }


    /**
     *  Test per il metodo che prende il numero massimo di errori.
     */
    @Test
    @DisplayName("Test getNumMaxErrori")
    void testGetNumMaxErrori() {
        int numMaxErrori = partita.getNumMaxErrori();
        assertEquals(FACILE, numMaxErrori,
        "Errore non è stato preso il valore degli errori massimi");
    }

    /**
     *  Test per il metodo che imposta il numero massimo di errori.
     */
    @Test
    @DisplayName("Test setNumMaxErrori")
    void testSetNumMaxErrori() {
        partita.setNumMaxErrori(NUM_MAX_ERR);
        int numMaxErrori = partita.getNumMaxErrori();
        assertEquals(NUM_MAX_ERR, numMaxErrori,
        "Errore non è stato impostato il valore degli errori massimi");
    }

    /**
     *  Test per il metodo prende gli errori correnti.
     */
    @Test
    @DisplayName("Test getErroriCorrenti")
    void testGetErroriCorrenti() {
        int erroriCorrenti = partita.getErroriCorrenti();
        assertEquals(0, erroriCorrenti,
        "Errore non è stato preso il valore degli errori correnti");
    }

    /**
     *  Test per il metodo che imposta gli errori correnti.
     */
    @Test
    @DisplayName("Test setErroriCorrenti")
    void testSetErroriCorrenti() {
        partita.setErroriCorrenti(2);
        int erroriCorrenti = partita.getErroriCorrenti();
        assertEquals(2, erroriCorrenti,
        "Errore non è stato imposato il valore degli errori correnti");
    }

    /**
     *  Test per il metodo prende lo stato di colpito.
     */
    @Test
    @DisplayName("Test getColpiTotali")
    void testGetColpiTotali() {
        int colpiTotali = partita.getColpiTotali();
        assertEquals(0, colpiTotali,
        "Errore non è stato preso il valore dei colpi totali");
    }

    /**
     *  Test per il metodo imposta lo stato in colpito.
     */
    @Test
    @DisplayName("Test setColpiTotali")
    void testSetColpiTotali() {
        partita.setColpiTotali(COLPI_TOTALI);
        int colpiTotali = partita.getColpiTotali();
        assertEquals(COLPI_TOTALI, colpiTotali,
        "Errore non è stato impostato il valore dei colpi totali");
    }

    /**
     *  Test per il metodo che mostra lo stato della partita.
     */
    @Test
    @DisplayName("Test statoPartita")
    void testStatoPartita() {
        boolean statoPartita = partita.statoPartita();
        assertFalse(statoPartita,
        "Errore non è stato impostato lo stato della partita");
    }

    /**
     *  Test per il metodo che imposta la dimensione massima della griglia di gioco.
     */
    @Test
    @DisplayName("Test setDimMax")
    void testSetDimMax() {
        partita.setDimMax(DIM_MAX);
        int dimMax = partita.getDimMax();
        assertEquals(DIM_MAX, dimMax,
        "Errore non è stata impostata la dimensione massima della griglia di gioco");
    }

    /**
     *  Test per il metodo prende la dimensione massima della griglia di gioco.
     */
    @Test
    @DisplayName("Test getDimMax")
    void testGetDimMax() {
        int dimMax = partita.getDimMax();
        assertEquals(DIM_MAX, dimMax,
        "Errore non è stata preso il valore della dimensione massima della griglia di gioco");
    }

    /**
     *  Test per il metodo imposta lo stato della partita in in corso.
     */
    @Test
    @DisplayName("Test setInCorso")
    void testSetInCorso() {
        partita.setInCorso(true);
        boolean inCorso = partita.statoPartita();
        assertTrue(inCorso,
        "Errore non è stato impostato lo stato in corso");
    }

    /**
     *  Test per il metodo imposta il tempo al massimo.
     */
    @Test
    @DisplayName("Test setTempoMax")
    void testSetTempoMax() {
        partita.setTempoMax(TEMPO_MAX);
        int tempoMax = partita.getTempoMax();
        assertEquals(TEMPO_MAX, tempoMax,
        "Non è stato impostato il valore del tempo massimo");
    }

    /**
     *  Test per il metodo prende il tempo massimo.
     */
    @Test
    @DisplayName("Test getTempoMax")
    void testGetTempoMax() {
        int tempoMax = partita.getTempoMax();
        assertEquals(0, tempoMax,
        "Errore non è stato preso il valore del tempo massimo");
    }
}



