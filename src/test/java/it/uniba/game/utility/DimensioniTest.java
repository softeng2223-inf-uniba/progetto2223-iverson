package it.uniba.game.utility;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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
    void testGetDimCacciatorpediniere() {
        Dimensioni cacciatorpediniere = Dimensioni.CACCIATORPEDINIERE;
        assertEquals("Dimensione errata per CACCIATORPEDINIERE", CACCIATORPEDINIERE_DIM, cacciatorpediniere.getDim());
    }

    /**
     * Test del metodo getDim() per INCROCIATORE.
     */
    @Test
    void testGetDimIncrociatore() {
        Dimensioni incrociatore = Dimensioni.INCROCIATORE;
        assertEquals("Dimensione errata per INCROCIATORE", INCROCIATORE_DIM, incrociatore.getDim());
    }

    /**
     * Test del metodo getDim() per CORAZZATA.
     */
    @Test
    void testGetDimCorazzata() {
        Dimensioni corazzata = Dimensioni.CORAZZATA;
        assertEquals("Dimensione errata per CORAZZATA", CORAZZATA_DIM, corazzata.getDim());
    }

    /**
     * Test del metodo getDim() per PORTAEREI.
     */
    @Test
    void testGetDimPortaerei() {
        Dimensioni portaerei = Dimensioni.PORTAEREI;
        assertEquals("Dimensione errata per PORTAEREI", PORTAEREI_DIM, portaerei.getDim());
    }

    /**
     * Test del metodo getEsemplari() per CACCIATORPEDINIERE.
     */
    @Test
    void testGetEsemplariCACCIATORPEDINIERE() {
        Dimensioni cacciatorpediniere = Dimensioni.CACCIATORPEDINIERE;
        assertEquals("Numero di esemplari errato per CACCIATORPEDINIERE", CAC_E, cacciatorpediniere.getEsemplari());
    }

    /**
     * Test del metodo getEsemplari() per INCROCIATORE.
     */
    @Test
    void testGetEsemplariINCROCIATORE() {

        Dimensioni incrociatore = Dimensioni.INCROCIATORE;
        assertEquals("Numero di esemplari errato per INCROCIATORE", INC_E, incrociatore.getEsemplari());
    }

    /**
     * Test del metodo getEsemplari() per CORAZZATA.
     */
    @Test
    void testGetEsemplariCORAZZATA() {
        Dimensioni corazzata = Dimensioni.CORAZZATA;
        assertEquals("Numero di esemplari errato per CORAZZATA", CORAZZATA_E, corazzata.getEsemplari());
    }

    /**
     * Test del metodo getEsemplari() per PORTAEREI.
     */
    @Test
    void testGetEsemplariPORTAEREI() {
        Dimensioni portaerei = Dimensioni.PORTAEREI;
        assertEquals("Numero di esemplari errato per PORTAEREI", PORTAEREI_E, portaerei.getEsemplari());
    }

    /**
     * Test del metodo getIndex().
     */
    @Test
    void testGetIndex() {
        Dimensioni[] dimensioni = Dimensioni.values();

        for (int i = 0; i < dimensioni.length; i++) {
            Dimensioni dimensione = dimensioni[i];
            assertEquals("Indice errato per " + dimensione, i, dimensione.getIndex());
        }
    }
}
