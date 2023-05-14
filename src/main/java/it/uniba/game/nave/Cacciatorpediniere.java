package it.uniba.game.nave;

/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Cacciatorpediniere extends Nave{
  	/**
	* Costruttore di Cacciatorpediniere
	* @param coordinate: elenco di coordinate che occupa che deve essere di dimensione 2
	*/
    public Cacciatorpediniere(Coordinata coordinate[]) {
	  super(2,coordinate,false);
    }
    /**
	* Restituisce lo stato del Cacciatorpediniere
	* @return stato della Cacciatorpediniere
	*/
	public String toString(){
		return super.toString();
	}

}