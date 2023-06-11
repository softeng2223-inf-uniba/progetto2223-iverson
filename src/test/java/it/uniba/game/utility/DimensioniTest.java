package it.uniba.game.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test per la classe enum Dimensioni.
 */
class DimensioniTest {

    private static final int CACCIATORPEDINIERE_DIM = 2;
    private static final int INCROCIATORE_DIM = 3;
    private static final int CORAZZATA_DIM = 4;
    private static final int PORTAEREI_DIM = 5;

    private static final int CAC_E = 4;
    private static final int INC_E = 3;
    private static final int CORAZZATA_E = 2;
    private static final int PORTAEREI_E = 1;

    /**
     * Test del metodo getDim() per CACCIATORPEDINIERE.
     */
    @Test
    @DisplayName("Test per testGetDimCacciatorpediniere()")
    void testGetDimCacciatorpediniere() {
        Dimensioni cacciatorpediniere = Dimensioni.CACCIATORPEDINIERE;
        assertEquals(CACCIATORPEDINIERE_DIM, cacciatorpediniere.getDim(), "Dimensione errata per CACCIATORPEDINIERE");
    }

    /**
     * Test del metodo getDim() per INCROCIATORE.
     */
    @Test
    @DisplayName("Test per testGetDimIncrociatore()")
    void testGetDimIncrociatore() {
        Dimensioni incrociatore = Dimensioni.INCROCIATORE;
        assertEquals(INCROCIATORE_DIM, incrociatore.getDim(), "Dimensione errata per INCROCIATORE");
    }

    /**
     * Test del metodo getDim() per CORAZZATA.
     */
    @Test
    @DisplayName("Test per testGetDimCorazzata()")
    void testGetDimCorazzata() {
        Dimensioni corazzata = Dimensioni.CORAZZATA;
        assertEquals(CORAZZATA_DIM, corazzata.getDim(), "Dimensione errata per CORAZZATA");
    }

    /**
     * Test del metodo getDim() per PORTAEREI.
     */
    @Test
    @DisplayName("Test per testGetDimPortaerei()")
    void testGetDimPortaerei() {
        Dimensioni portaerei = Dimensioni.PORTAEREI;
        assertEquals(PORTAEREI_DIM, portaerei.getDim(), "Dimensione errata per PORTAEREI");
    }

    /**
     * Test del metodo getEsemplari() per CACCIATORPEDINIERE.
     */
    @Test
    @DisplayName("Test per testGetEsemplariCACCIATORPEDINIERE()")
    void testGetEsemplariCACCIATORPEDINIERE() {
        Dimensioni cacciatorpediniere = Dimensioni.CACCIATORPEDINIERE;
        assertEquals(CAC_E, cacciatorpediniere.getEsemplari(), "Numero di esemplari errato per CACCIATORPEDINIERE");
    }

    /**
     * Test del metodo getEsemplari() per INCROCIATORE.
     */
    @Test
    @DisplayName("Test per testGetEsemplariINCROCIATORE()")
    void testGetEsemplariINCROCIATORE() {

        Dimensioni incrociatore = Dimensioni.INCROCIATORE;
        assertEquals(INC_E, incrociatore.getEsemplari(), "Numero di esemplari errato per INCROCIATORE");
    }

    /**
     * Test del metodo getEsemplari() per CORAZZATA.
     */
    @Test
    @DisplayName("Test per testGetEsemplariCORAZZATA()")
    void testGetEsemplariCORAZZATA() {
        Dimensioni corazzata = Dimensioni.CORAZZATA;
        assertEquals(CORAZZATA_E, corazzata.getEsemplari(), "Numero di esemplari errato per CORAZZATA");
    }

    /**
     * Test del metodo getEsemplari() per PORTAEREI.
     */
    @Test
    @DisplayName("Test per testGetEsemplariPORTAEREI()")
    void testGetEsemplariPORTAEREI() {
        Dimensioni portaerei = Dimensioni.PORTAEREI;
        assertEquals(PORTAEREI_E, portaerei.getEsemplari(), "Numero di esemplari errato per PORTAEREI");
    }

    /**
     * Test del metodo getIndex().
     */
    @Test
    @DisplayName("Test per testGetIndex()")
    void testGetIndex() {
        Dimensioni[] dimensioni = Dimensioni.values();

        for (int i = 0; i < dimensioni.length; i++) {
            Dimensioni dimensione = dimensioni[i];
            assertEquals(i, dimensione.getIndex(), "Indice errato per " + dimensione);
        }
    }
}
