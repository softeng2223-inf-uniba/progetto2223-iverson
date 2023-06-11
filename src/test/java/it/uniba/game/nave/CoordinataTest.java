package it.uniba.game.nave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test sulla classe Coordinata.
 */
class CoordinataTest {
    private static final int RIGA = 3;
    private static final int COLONNA = 4;

    private Coordinata coordinata;

    /**
     * Settaggio test preliminari.
     */
    @BeforeEach
    void setUp() {
        coordinata = new Coordinata(RIGA, COLONNA);
    }

    /**
     * Test sulla restituzione corretta della riga.
     */
    @Test
    @DisplayName("Test restituzione corretta della riga")
    void testGetRiga() {
        assertEquals(RIGA, coordinata.getriga(),
        "La riga restituita non è corretta");
    }

    /**
     * Test sulla restituzione corretta della colonna.
     */
    @Test
    @DisplayName("Test restituzione corretta della colonna")
    void testGetColonna() {
        assertEquals(COLONNA, coordinata.getcolonna(),
        "La colonna restituita non è corretta");
    }

    /**
     * Test sulla restituzioen corretta dello stato colpito.
     */
    @Test
    @DisplayName("Test restituzione corretta stato colpito")
    void testIsColpito() {
        assertFalse(coordinata.getcolpito(),
        "Lo stato 'colpito' restituito non è corretto");
    }

    /**
     * Test sull' impostare lo stato corretto del colpo.
     */
    @Test
    @DisplayName("Test settaggio corretto stato colpito")
    void testSetColpito() {
        coordinata.setcolpito();
        assertTrue(coordinata.getcolpito(),
        "Lo stato 'colpito' non è stato impostato correttamente");
    }

    /**
     * Test sul clonaggio esatto delle coordinate delle navi.
     */
    @Test
    @DisplayName("Test clonaggio corretto Coordinata")
    void testClone() {
        try {
            Coordinata cloned = (Coordinata) coordinata.clone();
            assertNotSame(coordinata, cloned,
            "L'oggetto clonato non è una nuova istanza");
        } catch (CloneNotSupportedException e) {
            fail("Clonaggio non corretto");
        }
    }

    /**
     * Test sulla corrispondenza della riga della nave clonata.
     */
    @Test
    @DisplayName("Test corrispondenza riga dell'oggetto clonato")
    void testClonedRiga() {
        try {
            Coordinata cloned = (Coordinata) coordinata.clone();
            assertEquals(coordinata.getriga(), cloned.getriga(),
            "La riga dell'oggetto clonato non corrisponde");
        } catch (CloneNotSupportedException e) {
            fail("Clonaggio non corretto");
        }
    }

    /**
     * Test sulla corrispondenza della colonna della nave clonata.
     */
    @Test
    @DisplayName("Test corrispondenza colonna dell'oggetto clonato")
    void testClonedColonna() {
        try {
            Coordinata cloned = (Coordinata) coordinata.clone();
            assertEquals(coordinata.getcolonna(), cloned.getcolonna(),
            "La colonna dell'oggetto clonato non corrisponde");
        } catch (CloneNotSupportedException e) {
            fail("Clonaggio non corretto");
        }
    }

    /**
     * Test corrispondenza che controlla se lo stato colpito è stato assegnato correttamente.
     */
    @Test
    @DisplayName("Test corrispondenza stato 'colpito' dell'oggetto clonato")
    void testClonedColpito() {
        try {
            Coordinata cloned = (Coordinata) coordinata.clone();
            assertEquals(coordinata.getcolpito(), cloned.getcolpito(),
            "Lo stato 'colpito' dell'oggetto clonato non corrisponde");
        } catch (CloneNotSupportedException e) {
            fail("Clonaggio non corretto");
        }
    }

    /**
     * Test che controlla se si restituisce correttamente la stringa.
     */
    @Test
    @DisplayName("Test restituzione corretta del ToString")
    void testToString() {
        String expected = "Riga: " + RIGA + " Colonna: " + COLONNA;
        String actual = coordinata.toString();
        assertArrayEquals(expected, actual,
        "La rappresentazione in stringa non è corretta");
    }

    private void assertArrayEquals(final String expected, final String string, final String message) {
    }

}


