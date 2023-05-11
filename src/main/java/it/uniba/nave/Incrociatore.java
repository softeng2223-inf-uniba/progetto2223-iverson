package nave;


/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Incrociatore extends Nave{
  	/**
	* Costruttore di Incrociatore
	* @param coordinate: elenco di coordinate che occupa che deve essere di dimensione 3
	*/
    public Incrociatore(Coordinata coordinate[]){
	  super(3,coordinate,false);
    }
    /**
	* Restituisce lo stato del Cacciatorpediniere
	* @return stato della Cacciatorpediniere
	*/
	public String toString(){
		return super.toString();
	}

}