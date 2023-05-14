package nave;

import eccezioni.NumeroCoordinateException;

/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Portaerei extends Nave
{
  	/**
	* Costruttore di Portaerei
	* @param coordinate: elenco di coordinate che occupa che deve essere di dimensione 5
  	* @throws NumeroCoordinateException se si inseriscono un numero diverso di coordinate
	* rispetto alla sua dimensione
	*/
    public Portaerei(Coordinata coordinate[]) throws NumeroCoordinateException{
	  super(5,coordinate,false);
    }
    /**
	* Restituisce lo stato del Portaerei
	* @return stato della Portaerei
	*/
	public String toString(){
		return super.toString();
	}

}