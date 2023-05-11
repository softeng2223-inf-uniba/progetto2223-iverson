package nave;



/**
 * Classe astratta per definire un nave
 */
public abstract class Nave{
    public final int dim;
	private final Coordinata coordinate[];
    private boolean affondato;

  	/**
	* Costruttore di Nave
	* @param dim : dimensione della nave
	* @param coordinate: elenco di coordinate che occupa
    * @param affondato: identifica se la nave è affondata
  	* 
	*/
	Nave(int dim,Coordinata coordinate[],boolean affondato) {
			this.dim = dim;
			this.coordinate = coordinate;
			this.affondato = affondato;
		
	}

	/**
	* Restituisce la dimensione della nave
	* @return dimensione della Nave
	*/
	public int getdim(){
		return this.dim;
	}
	/**
	* Restituisce la coordinata ad una detarminata posizione
	* @param pos : posizione della cordinata
	* @return posizione della Nave
	*/
	public Coordinata getcoordinate(int pos){
			return this.coordinate[pos];
		
	}
	
	
	/**
	* Restituisce lo stato della nave,vero se è affondata, falso altrimenti
	* @return lo stato della Nave
	*/
	public boolean getaffondata(){
		return this.affondato;
	}
	/**
	* Imposta lo stato della nave affondata
	*/
	public void setaffondata(){
		this.affondato = true;
	}
	/**
	* Restituisce lo stato della Nave
	* @return stato della Nave
	*/
	public String toString(){
		return String.valueOf(this.affondato);
	}
}