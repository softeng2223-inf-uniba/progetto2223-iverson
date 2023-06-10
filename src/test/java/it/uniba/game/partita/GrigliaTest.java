package it.uniba.game.partita;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.nave.Coordinata;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe di test per la classe Griglia.
 */
class GrigliaTest {

    private Griglia griglia;
    private static final int DIECI = 10;
    private static final int QUATTRO = 4;

    /**
     * Inizializza una nuova istanza di Griglia prima di ogni test.
     */
    @BeforeEach
    void setUp() {
        try {
            griglia = new Griglia(DIECI, DIECI);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'inizializzazione della griglia: " + e.getMessage());
        }
    }

    /**
     * Test per il metodo getRighe().
     * Verifica che il numero di righe corrisponda a quello impostato.
     */
    @Test
    @DisplayName("Test per testGetRighe()")
    void testGetRighe() {
        Assertions.assertEquals(DIECI, griglia.getRighe(), "Il numero di righe non corrisponde");
    }

    /**
     * Test per il metodo getColonne().
     * Verifica che il numero di colonne corrisponda a quello impostato.
     */
    @Test
    @DisplayName("Test per testGetColonne()")
    void testGetColonne() {
        Assertions.assertEquals(DIECI, griglia.getColonne(), "Il numero di colonne non corrisponde");
    }

    /**
     * Test per il metodo toString().
     * Verifica che la rappresentazione in stringa della griglia corrisponda a quella attesa.
     */
    @Test
    @DisplayName("Test per testToString()")
    void testToString() {
        String expected = "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n"
                + "V V V V V V V V V V \n";
        Assertions.assertEquals(expected, griglia.toString(), "La rappresentazione in stringa non corrisponde");
    }

    /**
     * Test per il metodo getCella().
     * Verifica che il valore della cella corrisponda a quello atteso.
     */
    @Test
    @DisplayName("Test per testGetCella()")
    void testGetCella() {
        Assertions.assertEquals("V", griglia.getCella(0, 0), "Il valore della cella non corrisponde");
    }

    /**
     * Test per il metodo setCella().
     * Verifica che il valore della cella sia impostato correttamente.
     */
    @Test
    @DisplayName("Test per testSetCella()")
    void testSetCella() {
        griglia.setCella(0, 0, "X");
        Assertions.assertEquals("X", griglia.getCella(0, 0), "Il valore della cella impostato correttamente");
    }

    /**
     * Test per il metodo addNavi().
     * Verifica che la dimensione delle navi corrisponda a quella attesa dopo l'aggiunta di una nave.
     */
    @Test
    @DisplayName("Test per testAddNavi()")
    void testAddNavi() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        Assertions.assertEquals(QUATTRO, griglia.naviSize(), "La dimensione delle navi non corrisponde");
    }

    /**
     * Test per il metodo getSize().
     * Verifica che la dimensione della nave corrisponda a quella attesa.
     */
    @Test
    @DisplayName("Test per testGetSize()")
    void testGetSize() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        Assertions.assertEquals(1, griglia.getSize(0), "La dimensione della nave non corrisponde");
    }

    /**
     * Test per il metodo getDim().
     * Verifica che la dimensione della coordinata corrisponda a quella attesa.
     */
    @Test
    @DisplayName("Test per testGetDim()")
    void testGetDim() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        Assertions.assertEquals(2, griglia.getDim(0, 0), "La dimensione della coordinata non corrisponde");
    }

    /**
     * Test per il metodo getAffondata().
     * Verifica che la nave non sia stata affondata correttamente.
     */
    @Test
    @DisplayName("Test per testGetAffondata()")
    void testGetAffondata() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        Assertions.assertFalse(griglia.getAffondata(0, 0), "La nave non è stata affondata correttamente");
    }

    /**
     * Test per il metodo setAffondata().
     * Verifica che la nave sia stata segnata come affondata correttamente.
     */
    @Test
    @DisplayName("Test per testSetAffondata()")
    void testSetAffondata() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        griglia.setAffondata(0, 0);
        Assertions.assertTrue(griglia.getAffondata(0, 0), "La nave non è stata segnata come affondata correttamente");
    }

    /**
     * Test per il metodo getRiga().
     * Verifica che il valore della riga corrisponda a quello atteso.
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alla coordinata.
     */
    @Test
    @DisplayName("Test per testGetRiga()")
    void testGetRiga() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        try {
            Assertions.assertEquals(0, griglia.getRiga(0, 0, 0), "Il valore della riga non corrisponde");
            Assertions.assertEquals(0, griglia.getRiga(0, 0, 1), "Il valore della riga non corrisponde");
        } catch (PosizioneException e) {
            Assertions.fail("Errore durante l'accesso alla coordinata: " + e.getMessage());
        }
    }

    /**
     * Test per il metodo getColonna().
     * Verifica che il valore della colonna corrisponda a quello atteso.
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alla coordinata.
     */
    @Test
    @DisplayName("Test per testGetColonna()")
    void testGetColonna() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        try {
            Assertions.assertEquals(0, griglia.getColonna(0, 0, 0), "Il valore della colonna non corrisponde");
            Assertions.assertEquals(1, griglia.getColonna(0, 0, 1), "Il valore della colonna non corrisponde");
        } catch (PosizioneException e) {
            Assertions.fail("Errore durante l'accesso alla coordinata: " + e.getMessage());
        }
    }

    /**
     * Test per il metodo getColpito().
     * Verifica che la coordinata non sia stata colpita correttamente.
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alla coordinata.
     */
    @Test
    @DisplayName("Test per testGetColpito()")
    void testGetColpito() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        try {
            Assertions.assertFalse(griglia.getColpito(0, 0, 0), "La coordinata non è stata colpita");
        } catch (PosizioneException e) {
            Assertions.fail("Errore durante l'accesso alla coordinata: " + e.getMessage());
        }
    }

    /**
     * Test per il metodo setColpito().
     * Verifica che la coordinata sia stata segnata come colpita correttamente.
     * @throws PosizioneException se si verifica un'eccezione durante l'accesso alla coordinata.
     */
    @Test
    @DisplayName("Test per testSetColpito()")
    void testSetColpito() {
        try {
            Coordinata[] coordinata = {new Coordinata(0, 0), new Coordinata(0, 1)};
            griglia.addNavi(coordinata, 0);
        } catch (NumeroCoordinateException e) {
            Assertions.fail("Errore durante l'aggiunta della nave: " + e.getMessage());
        }
        try {
            griglia.setColpito(0, 0, 0);
            Assertions.assertTrue(griglia.getColpito(0, 0, 0), "coordinata non segnata come colpita correttamente");
        } catch (PosizioneException e) {
            Assertions.fail("Errore durante l'accesso alla coordinata: " + e.getMessage());
        }
    }
}
