package it.uniba.game.nave;

/**
 * Classe di una Coordinata
 */
public class Coordinata implements Cloneable {
	private int riga;
	private int colonna;
	private boolean colpito;

	/**
	 * Costruttore di Coordinata
	 * 
	 * @param riga    : riga della coordinata
	 * @param colonna : colonna della coordinata
	 */
	public Coordinata(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
		this.colpito = false;
	}

	/**
	 * Restituisce la riga della coordinata
	 * 
	 * @return riga della coordinata
	 */
	public int getriga() {
		return this.riga;
	}

	/**
	 * Restituisce la colonna della coordinata
	 * 
	 * @return colonna della coordinata
	 */
	public int getcolonna() {
		return this.colonna;
	}

	/**
	 * Restituisce vero se tale coordinata è stata colpita,
	 * falso altrimenti
	 * 
	 * @return colonna della coordinata
	 */
	public boolean getcolpito() {
		return this.colpito;
	}

	/**
	 * Imposta la coordinata come colpita
	 */
	public void setcolpito() {
		this.colpito = true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Restituisce lo stato della coordinata
	 * 
	 * @return stato della coordinata
	 */
	public String toString() {
		return "Riga: " + String.valueOf(this.riga) +
				" Colonna " + String.valueOf(this.colonna);
	}
}