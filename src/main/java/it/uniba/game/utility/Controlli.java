package it.uniba.game.utility;

import it.uniba.game.partita.Partita;

/**
 * Classe controlli utilizzata per effettura controlli su int e delle coordinate.
 */
public class Controlli {


    /**
     * Construttore vuoto in quanto svolge solo funzioni logiche.
     */
    public Controlli() {

    }
    /**
     *Funzione che permette di controllare se una stringa contiene un valore numerico.
     * @param str la stringa da controllare
     * @return ritorna true se é un numero
     */
    public boolean isInteger(final String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     *Funzione che permette di controllare se una stringa contiene un valore numerico.
     * @param input la stringa da controllare
     * @param partita un oggetto contenente la partita dalla quale ricaviamo la dimensione massima
     * @return ritorna true se é una coordinata
     */
    public boolean isCoordinata(final String input, final Partita partita) {
        final int[] dimMaxString = {3, 4};
        final int startNumString = 2;

        // Verifica che la stringa abbia un formato valido
        if ((input.length() != dimMaxString[0] || input.length() != dimMaxString[1]) && (input.charAt(1) != '-')) {
            return false;
        }

        // Verifica che il carattere prima del trattino sia una lettera maiuscola
        char colonna = input.charAt(0);
        if (Character.toUpperCase(colonna) > ('A' + partita.getDimMax() - 1)) {
            System.out.println('A' + partita.getDimMax() - 1);
            return false;
        }

        // Verifica che il carattere dopo il trattino sia un numero compreso tra 1 e 9
        if (input.length() == dimMaxString[0]) {
            char riga = input.charAt(startNumString);
            if (riga < '1' || riga > '9') {
                return false;
            }
        } else {
            String str = input.substring(2, dimMaxString[1]);
            if (isInteger(str)) {

                int numeroInt = Integer.parseInt(str);

                if (numeroInt < 0 || numeroInt > partita.getDimMax()) {
                    return false;
                }

             }
        }

        // Se tutti i controlli sono passati, la stringa ha un formato valido
        return true;
    }
}
