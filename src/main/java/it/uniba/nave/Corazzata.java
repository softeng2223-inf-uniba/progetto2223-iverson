package nave;


/**
 * Classe che estende la classe Nave definendo la dimensione
 */
public class Corazzata extends Nave{
  	/**
	* Costruttore di Corazzata
	* @param coordinate: elenco di coordinate che occupa che occupa che deve essere di dimensione 2
	*/
    public Corazzata(Coordinata coordinate[]){
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