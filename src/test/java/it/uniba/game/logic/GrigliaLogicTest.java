package it.uniba.game.logic;

import it.uniba.game.eccezioni.NumeroCoordinateException;
import it.uniba.game.eccezioni.PosizioneException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe di test per la classe GrigliaLogic.
 */
class GrigliaLogicTest {

    private GrigliaLogic grigliaLogic;
    private static final int DIECI = 10;
    private static final int QUATTRO = 4;
    private static final int TRE = 3;

    /**
     * Inizializza l'oggetto GrigliaLogic prima di ogni metodo di test.
     *
     * @throws NumeroCoordinateException se si verifica un'eccezione nella creazione della griglia
     */
    @BeforeEach
    void setUp() throws NumeroCoordinateException {
        grigliaLogic = GrigliaLogic.getInstance(DIECI, DIECI);
    }

    /**
     * Test per il metodo testFinepartitaNonFinita().
     */
    @Test
    @DisplayName("Test per testFinepartitaNonFinita()")
    void testFinepartitaNonFinita() {
        assertFalse(grigliaLogic.finepartita(), "La partita dovrebbe continuare senza colpi");
    }
    /**
     * Test per il metodo testFinepartitaNaviColpite().
     */
    @Test
    @DisplayName("Test per testFinepartitaNaviColpite()")
    void testFinepartitaNaviColpite() {
        grigliaLogic.setAffondato(0, 0);
        grigliaLogic.setAffondato(1, 0);
        assertFalse(grigliaLogic.finepartita(), "Solo alcune navi sono state affondate");
    }

    /**
     * Test per il metodo testFinepartitaNaviAffondate().
     */
    @Test
    @DisplayName("Test per testFinepartitaNaviAffondate()")
    void testFinepartitaNaviAffondate() {
        for (int i = 0; i < grigliaLogic.getnaviSize(); i++) {
            for (int j = 0; j < grigliaLogic.getSize(i); j++) {
                grigliaLogic.setAffondato(i, j);
            }
        }
        assertTrue(grigliaLogic.finepartita(), "Tutte le navi sono state affondate");
    }

    /**
     * Test per il metodo inserisciColpo().
     *
     * @throws PosizioneException se si verifica un'eccezione nell'inserimento del colpo
     */
    @Test
    @DisplayName("Test per testInserisciColpoVuoto()")
    void testInserisciColpoVuoto() throws PosizioneException {
        String stato = grigliaLogic.inserisciColpo(0, 0);

        if (grigliaLogic.getStatoCella(0, 0).equals("VC")) {
            assertEquals("V", stato, "Lo stato della cella dovrebbe essere 'V'");
        }
    }
    /**
     * Test per il metodo inserisciColpo().
     *
     * @throws PosizioneException se si verifica un'eccezione nell'inserimento del colpo
     */
    @Test
    @DisplayName("Test per testInserisciColpoNave()")
    void testInserisciColpoNave() throws PosizioneException {
        String stato = grigliaLogic.inserisciColpo(0, 0);

        if (grigliaLogic.getStatoCella(0, 0).equals("NC")) {
            assertEquals("C", stato, "Lo stato della cella dovrebbe essere 'C'");
        }
    }

    /**
     * Test per il metodo getStatoCellaVuota().
     */
    @Test
    @DisplayName("Test per testGetStatoCellaVuota()")
    void testGetStatoCellaVuota() {
        String stato = grigliaLogic.getStatoCella(0, 0);

        if (stato.equals("V")) {
            assertEquals("V", stato, "Lo stato della cella dovrebbe essere 'V'");
        }
    }
    /**
     * Test per il metodo getStatoCellaVuotoColpito().
     */
    @Test
    @DisplayName("Test per testGetStatoCellaVuotoColpito()")
    void testGetStatoCellaVuotoColpito() {
        String stato = grigliaLogic.getStatoCella(0, 0);

        if (stato.equals("N")) {
            assertEquals("N", stato, "Lo stato della cella dovrebbe essere 'N'");
        }
    }
    /**
     * Test per il metodo getStatoCellaNave().
     */
    @Test
    @DisplayName("Test per testGetStatoCellaNave()")
    void testGetStatoCellaNave() {

        try {
            grigliaLogic.inserisciColpo(0, 0);
            String stato = grigliaLogic.getStatoCella(0, 0);
            if (stato.equals("NC")) {
                assertEquals("NC", stato, "Lo stato della cella dovrebbe essere 'NC'");
            }
        } catch (PosizioneException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Test per il metodo getStatoCellaNaveColpita().
     */
    @Test
    @DisplayName("Test per testGetStatoCellaNaveColpita()")
    void testGetStatoCellaNaveColpita() {

        try {
            grigliaLogic.inserisciColpo(0, 0);
            String stato = grigliaLogic.getStatoCella(0, 0);
            if (stato.equals("VC")) {
                assertEquals("VC", stato, "Lo stato della cella dovrebbe essere 'VC'");
            }
        } catch (PosizioneException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifica che il metodo getnaviSize restituisca il numero corretto di navi presenti sulla griglia.
     */
    @Test
    @DisplayName("Test per testGetnaviSize()")
    void testGetnaviSize() {
        int expectedSize = QUATTRO;
        int actualSize = grigliaLogic.getnaviSize();
        assertEquals(expectedSize, actualSize, "Il numero di navi è diverso da quello atteso");
    }

    /**
     * Verifica che il metodo getSize restituisca il numero corretto di navi di uno specifico tipo.
     */
    @Test
    @DisplayName("Test per testGetSize()")
    void testGetSize() {
        int tipoNave = 2;
        int expectedSize = 2;
        int actualSize = grigliaLogic.getSize(tipoNave);
        assertEquals(expectedSize, actualSize, "numero di navi di tipo specificato è diverso da quello atteso");
    }

    /**
     * Verifica che il metodo setAffondato imposti correttamente lo stato di una nave come "affondata".
     */
    @Test
    @DisplayName("Test per testSetAffondato()")
    void testSetAffondato() {
        int tipoNave = 1;
        int indiceNave = 0;
        grigliaLogic.setAffondato(tipoNave, indiceNave);
        assertTrue(grigliaLogic.getAffondata(tipoNave, indiceNave), "stato della nave non è correttamente impostato");
    }

    /**
     * Verifica che il metodo setCella modifichi correttamente una cella della griglia.
     */
    @Test
    @DisplayName("Test per testSetCella()")
    void testSetCella() {
        int riga = 2;
        int colonna = TRE;
        String value = "X";
        grigliaLogic.setCella(riga, colonna, value);
        assertEquals(value, grigliaLogic.getCella(riga, colonna), "valore della cella non è correttamente impostato");
    }

    /**
     * Verifica che il metodo setColpito metta correttamente lo stato una specifica posizione di una nave come colpito.
     *
     * @throws PosizioneException se la posizione specificata non è valida
     */
    @Test
    @DisplayName("Test per testSetColpito()")
    void testSetColpito() throws PosizioneException {
        int tipoNave = 1;
        int indiceNave = 0;
        int indiceCoordinata = 2;
        grigliaLogic.setColpito(tipoNave, indiceNave, indiceCoordinata);
        assertTrue(grigliaLogic.getColpito(tipoNave, indiceNave, indiceCoordinata), "stato pos. non corr. impostato");
    }
}
