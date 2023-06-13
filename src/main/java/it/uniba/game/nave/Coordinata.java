package it.uniba.game.nave;

/**
 * {@literal <<Entity>>} Classe che rappresenta una posizione della mappa occupata da una nave.
 */
public class Coordinata implements Cloneable {
    private int riga;
    private int colonna;
    private boolean colpito;

    /**
     * Costruttore di Coordinata.
     *
     * @param pRiga    : riga della coordinata
     * @param pColonna : colonna della coordinata
     */
    public Coordinata(final int pRiga, final int pColonna) {
        this.riga = pRiga;
        this.colonna = pColonna;
        this.colpito = false;
    }

    /**
     * Restituisce la riga della coordinata.
     *
     * @return riga della coordinata
     */
    public int getriga() {
        return this.riga;
    }

    /**
     * Restituisce la colonna della coordinata.
     *
     * @return colonna della coordinata
     */
    public int getcolonna() {
        return this.colonna;
    }

    /**
     * Restituisce vero se tale coordinata è stata colpita,
     * falso altrimenti.
     *
     * @return colonna della coordinata
     */
    public boolean getcolpito() {
        return this.colpito;
    }

    /**
     * Imposta la coordinata come colpita.
     */
    public void setcolpito() {
        this.colpito = true;
    }

    /**
     * Clona l'oggetto.
     * r@return un nuovo oggetto di Coordinata.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Restituisce lo stato della coordinata.
     *
     * @return stato della coordinata
     */
    public String toString() {
        return "Riga: "
                + String.valueOf(this.riga)
                + " Colonna "
                + String.valueOf(this.colonna);
    }
}
