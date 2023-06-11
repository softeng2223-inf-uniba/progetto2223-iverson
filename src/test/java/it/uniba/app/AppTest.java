package it.uniba.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;


class AppTest {

    /**
     * Test che manda in esecuzione il metodo Help con il comando --help.
     */
    @Test
    @DisplayName("Test su HelpComandoHelp")
    void testHelpComandoHelp() {
        String[] args = {"--help"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, Charset.forName("UTF-8"));

        System.setOut(printStream);

        App.help(args);

        String output = outputStream.toString(Charset.forName("UTF-8")).trim();
        assertNotNull(output, "La stringa che mi aspettavo é errata");
        }

     /**
     * Test che manda in esecuzione il metodo Help con il comando -h.
     */
    @Test
    @DisplayName("Test su HelpComandoH")
    void testHelpComandoH() {
        String[] args = {"-h"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, Charset.forName("UTF-8"));

        System.setOut(printStream);

        App.help(args);

        String output = outputStream.toString(Charset.forName("UTF-8")).trim();
        assertNotNull(output, "La stringa che mi aspettavo é errata");
        }

    /**
     * Test che controlla in cui gli argomenti che si passano all'Help non sono validi.
     */
    @Test
    @DisplayName("Test su HelpVuoto")
    void testHelpVuoto() {
        String[] args = {"arg1", "arg2"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, Charset.forName("UTF-8"));

        System.setOut(printStream);

        App.help(args);

        String output = outputStream.toString(Charset.forName("UTF-8")).trim();
        assertEquals("", output, "La stringa non é vuota");
    }

}
