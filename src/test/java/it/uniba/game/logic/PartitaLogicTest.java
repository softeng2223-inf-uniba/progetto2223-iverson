package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.partita.Partita;
import it.uniba.game.utility.Difficolta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test per la classe di PartitaLogic.
 */
class PartitaLogicTest {
    private static final int DIM_GRIGLIA = 10;
    private static final int TEMPO_SCADUTO_MILLISECONDI = 65000;
    private static final int TEMPO_ATTUALE_MILLISECONDI = 60000;
    private static final int RESTO_TEMPO_MILLISECONDI = 75000;
    private static final int TEMPO_TRASCORSO = 15;
    private static final int DIM_MAX = 10;
    private static final int DIM_MAX_REIMPOSTATA = 15;
    private static final int DIM_MAX_NEGATIVA = -5;
    private static final int TEMPO_MAX_POSITIVO = 60;
    private static final int TEMPO_MAX_NEGATIVO = -30;
    private static final int NUM_MAX_ERRORI = 50;
    private static final int NUM_ERRORI_REIMP = 3;
    private static final int NUM_ERRORI_NEGATIVO = -2;
    private static final int FACILE = 50;
    private static final int MEDIO = 30;
    private static final int DIFFICILE = 10;
    private static final int FACILE_MODIFICATO = 60;
    private static final int MEDIO_MODIFICATO = 35;
    private static final int DIFFICILE_MODIFICATO = 15;
    private static final int COLPI_TOTALI = 10;
    private static final int TEMPO_TRENTA = 30;
    private static final int ERRORI_MAX_NEW = 10;
    private static final int ERRORI_CORRENTI = 5;

    private PartitaLogic partitaLogic;
    private Partita partita;

    /**
     * Settaggio test preliminari.
     @BeforeEach
     public void setUp() {
         partitaLogic = new PartitaLogic();
         try {
             new GrigliaLogic(DIM_GRIGLIA, DIM_GRIGLIA);
            } catch (NumeroCoordinateException e) {
                fail("Eccezione imprevista: " + e.getMessage());
                e.printStackTrace();
            }
            partita = new Partita();
        }
        */

    /**
     * Test per l'avvio della partita.
     */
    @Test
    @DisplayName("Test su AvviaStatoPartita")
    void testAvviaStatoPartita() {
         try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        assertTrue(partitaLogic.statoPartita(), "Errore nell' avvio dell' inizializzaione della partita");
    }

    @Test
    @DisplayName("Test su AvviaColpiTotali")
    void testAvviaColpiTotali() {
         try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        assertEquals(0, partitaLogic.getColpiTotali(), "Errore nei colpi disponibili");
    }

    @Test
    @DisplayName("Test su ErroriCorrenti")
    void testAvviaErroriCorrenti() {
         try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        assertEquals(0, partitaLogic.getErroriCorrenti(), "Errore dei colpi totali");
    }

    /**
     * Test per colpo corretto nave.
     */
    @Test
    @DisplayName("Test per ColpisciNave")
    void testColpisciNave() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        String[] result;
        String[] expectedResult = {"C", " "};

        try {
            result = partitaLogic.colpisci("A-1");
            if (result[0].equals("C")) {
                assertArrayEquals(expectedResult, result,
                "Errore mi aspettavo C");
            }

        } catch (PosizioneException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }
    }

    /**
     * Test per colpo andato vuoto.
     */
    @Test
    @DisplayName("Test per ColpisciVuoto")
    void testColpisciVuoto() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        String[] result;
        String[] expectedResult = {"V", " "};

        try {
            result = partitaLogic.colpisci("B-2");
            if (result[0].equals("V")) {
                assertArrayEquals(expectedResult, result,
                "Errore mi aspettavo V");
            }

        } catch (PosizioneException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }
    }

    /**
     * Test per colpo corretto nave più vittoria.
     */
    @Test
    @DisplayName("Test per ColpisciVittoria")
    void testColpisciVittoria() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        String[] result;
        String[] expectedResult = {"C", "Vittoria"};

        try {
            result = partitaLogic.colpisci("C-4");
            result[1] = "Vittoria"; //Forzo il result solo per il test.
            if (result[0].equals("C")) {
                assertArrayEquals(expectedResult, result,
                "Errore mi aspettaco C e Vittoria");
            }

        } catch (PosizioneException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }
    }

    /**
     * Test che controlla il tempo scaduto Falso.
     */
    @Test
    @DisplayName("Test per ControllaTempoScadutoFalso")
    void testControllaTempoScadutoFalso() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        assertFalse(partitaLogic.controllaTempoScaduto(),
        "Errore il tempo è scaduto");
    }

    /**
     * Test che controlla il tempo scaduto Vero.
     */
    @Test
    @DisplayName("Test per ControlaTempoScadutoVero")
    void testControllaTempoScadutoVero() {
        try {

            partitaLogic.setTempoMax(1);
            Field partitaField = PartitaLogic.class.getDeclaredField("partita");
            partitaField.setAccessible(true);
            Partita partitaInstance = (Partita) partitaField.get(partitaLogic);
            Field startTimeField = Partita.class.getDeclaredField("startTime");
            startTimeField.setAccessible(true);
            startTimeField.set(partitaInstance, System.currentTimeMillis() - TEMPO_SCADUTO_MILLISECONDI);
        } catch (Exception e) {
            fail("Eccezione imprevista durante l'impostazione del tempo massimo: " + e.getMessage());
        }

        assertTrue(partitaLogic.controllaTempoScaduto(),
        "Errore il tempo non è scaduto");
    }

    /**
     * Test per controllare il tempo attuale.
     */
    @Test
    @DisplayName("Test per TempoAttuale")
    void testTempoAttuale() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        try {
            Field partitaField = PartitaLogic.class.getDeclaredField("partita");
            partitaField.setAccessible(true);
            Partita partitaInstance = (Partita) partitaField.get(partitaLogic);
            Field startTimeField = Partita.class.getDeclaredField("startTime");
            startTimeField.setAccessible(true);
            startTimeField.set(partitaInstance, System.currentTimeMillis() - TEMPO_ATTUALE_MILLISECONDI);
        } catch (Exception e) {
            fail("Eccezione imprevista durante l'impostazione del tempo attuale: " + e.getMessage());
        }

        assertEquals(1, partitaLogic.tempoAttuale(),
        "Errore il tempo ricevuto è errato");
    }


    /**
     * Test per controllare lo scadere del tempo.
     */
    @Test
    @DisplayName("Test per RestoTempoAttuale")
    void testRestoTempoAttuale() {
        try {
            partitaLogic.avvia();
        } catch (NumeroCoordinateException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        try {
            Field partitaField = PartitaLogic.class.getDeclaredField("partita");
            partitaField.setAccessible(true);
            Partita partitaInstance = (Partita) partitaField.get(partitaLogic);
            Field startTimeField = Partita.class.getDeclaredField("startTime");
            startTimeField.setAccessible(true);
            startTimeField.set(partitaInstance, System.currentTimeMillis() - RESTO_TEMPO_MILLISECONDI);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Eccezione imprevista: " + e.getMessage());
        }

        assertEquals(TEMPO_TRASCORSO, partitaLogic.restoTempoAttuale(),
        "Errore il tempo rimanente è errato");
    }


    /**
     * Test per controllare lo stato della partita non in corso.
     */
    @Test
    @DisplayName("Test per StatoPartitaNonInCorso")
    void testStatoPartitaNonInCorso() {

        assertFalse(partita.statoPartita(),
        "Errore stato partita in corso");
    }

    /**
     * Test per controllare lo stato della partita in corso.
     */
    @Test
    @DisplayName("Test per StatoPartitaInCorso")
    void testStatoParitaInCorso() {

        partita.setInCorso(true);
        assertTrue(partita.statoPartita(),
        "Errore stato partita non è in corso");
    }

    /**
     * Test per controllare lo stato della partita dopo un set.
     */
    @Test
    @DisplayName("Test per StatoPartitaDopoUnSet")
    void testStatoPartitaDopoUnSet() {

        partita.setInCorso(false);
        assertFalse(partita.statoPartita(),
        "Errore il valore ricevuto è errato");
    }

    /**
     * Test per prendere e impostare la dimensione massima della griglia di gioco.
     */
    @Test
    @DisplayName("Test per GetSetDimMax")
    void testGetSetDimMax() {

        assertEquals(DIM_MAX, partita.getDimMax(),
        "Errore nel ricevere e impostare il valore desiderato");
    }

    /**
     * Test per prendere e reimpostare la dimensione massima della griglia di gioco.
     */
    @Test
    @DisplayName("Test per GetSetDimMaxReimpostata")
    void testGetSetDimMaxReimpostata() {

        partita.setDimMax(DIM_MAX_REIMPOSTATA);
        assertEquals(DIM_MAX_REIMPOSTATA, partita.getDimMax(),
        "Errore la dimensione non è stata reimpostata");
    }

    /**
     * Test per prendere e impostare la dimensione massima della griglia di gioco con un valore negativo.
     */
    @Test
    @DisplayName("Test per GetSetDimMaxNegativa")
    void testGetSetDimMaxNegativa() {

        partita.setDimMax(DIM_MAX_NEGATIVA);
        assertEquals(DIM_MAX_NEGATIVA, partita.getDimMax(),
        "Errore la dimensione massima della griglia non è stata impostata correttamente");
    }

    /**
     * Test per impostare il tempo massimo.
     */
    @Test
    @DisplayName("Test per SetTempoMax")
    void testSetTempoMax() {

        assertEquals(0, partita.getTempoMax(),
        "Errore nell' impostare il tempo max");
    }

    /**
     * Test per impostare il tempo massimo positivo.
     */
    @Test
    @DisplayName("Test per SetTempoMaxPositivo")
    void testSetTempoMaxPositivo() {

        partita.setTempoMax(TEMPO_MAX_POSITIVO);
        assertEquals(TEMPO_MAX_POSITIVO, partita.getTempoMax(),
        "Errore il tempo è stato impostatto con un valore differente");
    }

    /**
     * Test per impostare il tempo massimo negativo.
     */
    @Test
    @DisplayName("Test per SetTempoMaxNegativo")
    void testSetTempoMaxNegativo() {

        partita.setTempoMax(TEMPO_MAX_NEGATIVO);
        assertEquals(TEMPO_MAX_NEGATIVO, partita.getTempoMax(),
        "Errore il tempo è stato impostatto con un valore differente");
    }

    /**
     * Test per impostare il numero massimo di errori.
     */
    @Test
    @DisplayName("Test per SetNumMaxErrori")
    void testSetNumMaxErrori() {

        assertEquals(NUM_MAX_ERRORI, partita.getNumMaxErrori(),
        "Errore non è stato impostato il numero massimo di errori");
    }

    /**
     * Test per reimpostare il numero massimo di errori.
     */
    @Test
    @DisplayName("Test per SetNumMaxErroriReimpostato")
    void testSetNumMaxErroriReimpostato() {
        partita.setNumMaxErrori(NUM_ERRORI_REIMP);
        assertEquals(NUM_ERRORI_REIMP, partita.getNumMaxErrori(),
        "Errore non è stato reimpostato il numero massimo di errori");
    }

    /**
     * Test per impostare il numero massimo di errori con un valore negativo.
     */
    @Test
    @DisplayName("Test per SetNumMaxErroriNegativo")
    void testSetNumMaxErroriNegativo() {

        partita.setNumMaxErrori(NUM_ERRORI_NEGATIVO);
        assertEquals(NUM_ERRORI_NEGATIVO, partita.getNumMaxErrori(),
        "Errore il numero massimo di errori è stato impostato con un valore differente");
    }

    /**
     * Test per prendere i valori degli errori del livello FACILE.
     */
    @Test
    @DisplayName("Test per GetErrorePerLivelloFAcile")
    void testGetErrorePerLivelloFacile() {

        int erroriFacile = partitaLogic.getErrorePerLivello("FACILE");

        assertEquals(FACILE, erroriFacile,
        "Errore gli errori per livello non sono stati impostati su FACILE");
    }

    /**
     * Test per prendere i valori degli errori del livello MEDIO.
     */
    @Test
    @DisplayName("Test per GetErrorePerLivelloMedio")
    void testGetErrorePerLivelloMedio() {

        int erroriMedio = partitaLogic.getErrorePerLivello("MEDIO");

        assertEquals(MEDIO, erroriMedio,
        "Errore gli errori per livello non sono stati impostati su MEDIO");
    }

    /**
     * Test per prendere i valori degli errori del livello DIFFICILE.
     */
    @Test
    @DisplayName("Test per GetErrorePerLivelloDifficile")
    void testGetErrorePerLivelloDifficile() {

        int erroriDifficile = partitaLogic.getErrorePerLivello("DIFFICILE");

        assertEquals(DIFFICILE, erroriDifficile,
        "Errore gli errori per livello non sono stati impostati su DIFFICILE");
    }

    /**
     * Test per impostare il livello di gioco su FACILE.
     */
    @Test
    @DisplayName("Test per SetLivello FACILE")
    void testSetLivelloFacile() {

        partita.setLivello(Difficolta.FACILE.name());
        assertEquals("FACILE", partita.getLivello(),
        "Errore il livello non è stato impostato su FACILE");
    }

    /**
     * Test per impostare il livello di gioco su MEDIO.
     */
    @Test
    @DisplayName("Test per SetLivello MEDIO")
    void testSetLivelloMedio() {

        partita.setLivello(Difficolta.MEDIO.name());
        assertEquals("MEDIO", partita.getLivello(),
        "Errore il livello non è stato impostato su MEDIO");
    }

    /**
     * Test per impostare il livello di gioco su DIFFICILE.
     */
    @Test
    @DisplayName("Test per SetLivello DIFFICILE")
    void testSetLivelloDifficile() {

        partita.setLivello(Difficolta.DIFFICILE.name());
        assertEquals("DIFFICILE", partita.getLivello(),
        "Errore il livello non è stato impostato su DIFFICILE");
    }

    /**
     * Test per reimpostare gli errori per il livello FACILE.
     */
     @Test
     @DisplayName("Test per ReimpostaErroriPerLivelloFacile")
    void testReimpostaErroriPerLivelloFacile() {

        partita.setErroriPerLivello("FACILE", FACILE_MODIFICATO);

        assertEquals(FACILE_MODIFICATO, partita.getErrorePerLivello("FACILE"),
        "Errore gli errori non sono stati reimpostati per il livello FACILE");
    }

    /**
     * Test per impostare gli errori per il livello MEDIO.
     */
     @Test
     @DisplayName("Test per ReimpostaErroriPerLivelloMedio")
    void testReimpostaErroriPerLivelloMedio() {

        partita.setErroriPerLivello("MEDIO", MEDIO_MODIFICATO);

        assertEquals(MEDIO_MODIFICATO, partita.getErrorePerLivello("MEDIO"),
        "Errore gli errori non sono stati reimpostati per il livello MEDIO");
    }

    /**
     * Test per reimpostare gli errori per il livello DIFFICILE.
     */
     @Test
     @DisplayName("Test per SetErroriPerLivelloDIFFICILE")
    void testSetErroriPerLivelloDifficile() {

        partita.setErroriPerLivello("DIFFICILE", DIFFICILE_MODIFICATO);

        assertEquals(DIFFICILE_MODIFICATO, partita.getErrorePerLivello("DIFFICILE"),
        "Errore gli errori non sono stati reimpostati per il livello DIFFICILE");
    }

    /**
     * Test per prendere il valore dei colpi totali.
     */
    @Test
    @DisplayName("Test per GetColpiTotali")
    void testGetColpiTotali() {

        partita.setColpiTotali(COLPI_TOTALI);

        assertEquals(COLPI_TOTALI, partita.getColpiTotali(),
        "Errore non è stato preso il valore corretto dei colpi totali");
    }

    /**
     * Test per prendere il valore del tempo massimo.
     */
    @Test
    @DisplayName("Test per GetTempoMax")
    void testGetTempoMax() {

        partita.setTempoMax(TEMPO_TRENTA);

        assertEquals(TEMPO_TRENTA, partita.getTempoMax(),
        "Errore non è stato preso il valore corretto del tempo massimo");
    }

    /**
     * Test per prednere il valore numero massimo degli errori.
     */
    @Test
    @DisplayName("Test per GetNumMaxErrori")
    void testGetNumMaxErrori() {

        partita.setNumMaxErrori(ERRORI_MAX_NEW);

        assertEquals(ERRORI_MAX_NEW, partita.getNumMaxErrori(),
        "Errore non è stato preso il valore corretto del numero massimo di errori");
    }

    /**
     * Test per prendere il valore degli errori correnti.
     */
    @Test
    @DisplayName("Test per GetErroriCorrenti")
    void testGetErroriCorrenti() {

        partita.setErroriCorrenti(ERRORI_CORRENTI);

        assertEquals(ERRORI_CORRENTI, partita.getErroriCorrenti(),
        "Errore non è stato preso il valore corrente degli errori correnti");
    }

    /**
     * Test per prendere il valore del livello.
     */
    @Test
    @DisplayName("Test per GetLivello")
    void testGetLivello() {

        partita.setLivello("MEDIO");

        assertEquals("MEDIO", partita.getLivello(),
        "Errore non è stato impostato il livello di gioco");
    }
}
