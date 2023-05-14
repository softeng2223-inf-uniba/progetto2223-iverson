package it.uniba.game.UI;

import it.uniba.game.partita.Partita;
import it.uniba.game.utility.Keyboard;

public class Comando {
    /**
     * 
     * @throws PosizioneException
     * @throws NumeroCoordinateException
     */
    public static void avvia(){
        String comando = new String("");
        Partita partita = new Partita();

        do{
            comando = Keyboard.readString();
            switch(comando){

                case "/gioca":
                    
                    break;

                case "/svelagriglia":
                    
                    break;
                
                case "/colpisci":
                    
                    break;

                case "/help":
                    
                    break;
                    
                case "/facile":

                    break;

                case "/medio":

                    break;

                case "/difficile":

                    break;

                case "/mostranavi":
                    
                    break;

                case "/mostralivello":

                    break;

                case "/esci":
                    
                    break;

                default:
                    System.out.println("Comando non riconosciuto");
                    break;    




            }
            
           
        }while(true);

    } 

    
}
