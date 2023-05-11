package partita;

/**
 * Classe che inizializza una Partita e la sua relativa Griglia di gioco
 */
public class Partita {
    private int numMaxErrori;
    private int colpiTotali;
    private int erroriCorrenti;
    private String inCorso;
    private Griglia griglia;

    /**
     * Inizializza una Partita e la sua relativa griglia di gioco
    
     */
    public Partita() {
        this.griglia = new Griglia(10,10);
        this.inCorso = "Partita avviata";
    }

/**
 * Restituisce il numero massimo di errori
 * @return numero massimo di errori
 */
    public int getNumMaxErrori() {
        return numMaxErrori;
    }

/**
 * Permette di modificare il numero massimo di errori
 * @param numMaxErrori : numero massimo di errori da impostare
 */
    public void setNumMaxErrori(int numMaxErrori) {
        this.numMaxErrori = numMaxErrori;
    }


 /**
  * Restituisce il numero di errori commessi dal giocatore
  * @return numero di errori commessi dal giocatore
  */
    public int getErroriCorrenti() {
        return erroriCorrenti;
    }

/**
 * Permette di modificare il numero di errori commessi dal giocatore
 * @param erroriCorrenti : numero di errori che il giocatore ha commesso
 */
    public void setErroriCorrenti(int erroriCorrenti) {
        this.erroriCorrenti = erroriCorrenti;
    }


/**
 * Restituisce il numero di colpi sparati dal giocatore
 * @return numero di colpi totali che sono stati sparati
 */
    public int getColpiTotali() {
        return colpiTotali;
    }

    /**
     * Permettere di modificare il numero di colpi sparati dal giocatore
     * @param colpiTotali : colpi totali sparati dal giocatore
     */
    public void setColpiTotali(int colpiTotali) {
        this.colpiTotali = colpiTotali;
    }



    
    /**
     * Restituisce lo stato della partita
     * @return stato della partita
     */
    public String statoPartita(){
        return inCorso;
    }

    /**
     * Imposta lo stato della partita in Pausa
     */
  
    public void pausaPartita(){
        inCorso = "Partita in Pausa";
    }

    /**
     * Imposta lo stato della partita in terminata
     */

    public void chiudiPartita(){
        inCorso = "Partita terminata";
    }
    /**
     * Imposta lo stato della partita in avviata
     */
   
    public void continuaPartita(){
        if (inCorso != "Partita terminata"){
            inCorso = "Partita avviata";
        }else{
            System.out.println("La partita è gia Terminata");
        }
            
    }


    	/**
	 * Descrive lo stato della Partita
	 * @return stato di Partita
	 */
    public String toString() {
        return griglia.toString();
    }   

    
}
