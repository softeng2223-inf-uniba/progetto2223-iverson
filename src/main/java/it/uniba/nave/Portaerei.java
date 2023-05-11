package nave;


/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Portaerei extends Nave{
  	/**
	* Costruttore di Portaerei
	* @param coordinate: elenco di coordinate che occupa che deve essere di dimensione 5
	*/
    public Portaerei(Coordinata coordinate[]){
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