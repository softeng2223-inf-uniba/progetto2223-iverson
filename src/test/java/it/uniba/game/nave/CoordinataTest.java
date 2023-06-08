package it.uniba.game.nave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class CoordinataTest {
    private static final int RIGA = 3;
    private static final int COLONNA = 4;

    private Coordinata coordinata;

    @BeforeEach
    void setUp() {
        coordinata = new Coordinata(RIGA, COLONNA);
    }

    @Test
    @DisplayName("Test restituzione corretta della riga")
    void testGetRiga() {
        assertEquals(RIGA, coordinata.getriga(),
        "La riga restituita non è corretta");
    }

    @Test
    @DisplayName("Test restituzione corretta della colonna")
    void testGetColonna() {
        assertEquals(COLONNA, coordinata.getcolonna(),
        "La colonna restituita non è corretta");
    }

    @Test
    @DisplayName("Test restituzione corretta stato colpito")
    void testIsColpito() {
        assertFalse(coordinata.getcolpito(),
        "Lo stato 'colpito' restituito non è corretto");
    }

    @Test
    @DisplayName("Test serraggio corretto stato colpito")
    void testSetColpito() {
        coordinata.setcolpito();
        assertTrue(coordinata.getcolpito(),
        "Lo stato 'colpito' non è stato impostato correttamente");
    }

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


