package nave;

import eccezioni.NumeroCoordinateException;

/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Corazzata extends Nave
{
  	/**
	* Costruttore di Corazzata
	* @param coordinate: elenco di coordinate che occupa che occupa che deve essere di dimensione 2
  	* @throws NumeroCoordinateException se si inseriscono un numero diverso di coordinate
	* rispetto alla sua dimensione
	*/
    public Corazzata(Coordinata coordinate[]) throws NumeroCoordinateException{
	  super(4,coordinate,false);
    }
    /**
	* Restituisce lo stato del Corazzata
	* @return stato della Corazzata
	*/
	public String toString(){
		return super.toString();
	}

}