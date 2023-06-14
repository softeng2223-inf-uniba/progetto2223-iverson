package it.uniba.game.UI;

import it.uniba.game.eccezioni.PosizioneException;
import it.uniba.game.logic.PartitaLogic;


import java.util.Scanner;

import it.uniba.game.eccezioni.NumeroCoordinateException;

import it.uniba.game.utility.Tabella;

import it.uniba.game.logic.Controlli;


/**
 * <<Boundary>> Classe che ha la la funzione di menu
 * e permette all'utente di inserire i vari comandi e interagire con l'applicazione.
 *
 */
public class Comando {
    private String comando;
    private String[] cStrings;
    private static final Scanner KEYBOARD = new Scanner(System.in, "UTF-8");
    private PartitaLogic partitaLogic;
    private Controlli controlli;
    private Stampa stampa;
    /**
     * Construttore della classe Comando.
     */
    public Comando() {
        partitaLogic = PartitaLogic.getInstance();
        controlli = Controlli.getInstance();
        stampa = new Stampa();
    }

    /**
     * Funzione che ha la funzione di "menu" e permette all'utente di inserire i
     * vari comandi.
     * @throws NumeroCoordinateException se si inseriscono un numero diverso di
     * coordinate rispetto alla sua dimensione.
     */
    public void menu() throws NumeroCoordinateException, PosizioneException {
        do {
            cStrings = getComando();
            if (!cStrings[0].equals("")) {
                if (partitaLogic.statoPartita()) {
                    switch (cStrings[0]) {
                        case "/svelagriglia":
                            stampa.svelaGriglia(partitaLogic);
                            break;
                        case "/mostratempo":
                            stampa.mostraTempo(partitaLogic);
                            break;
                        case "/mostragriglia":
                            stampa.stampaGriglia(partitaLogic);
                            break;
                        case "/help":
                            stampa.stampaHelp();
                            break;
                        case "/mostralivello":
                            stampa.mostraLivello(partitaLogic);
                            break;
                        case "/mostranavi":
                            stampa.mostraNavi();
                            break;
                        case "/mostratentativi":
                            stampa.mostraTentativi(partitaLogic);
                            break;
                        case "/esci":
                            esci();
                            break;
                        case "/abbandona":
                            abbandona();
                            break;
                        default:
                        if (controlli.isCoordinata(cStrings[0], partitaLogic)) {
                                String[] output = partitaLogic.colpisci(cStrings[0]);
                                stampa.stampaRisultatoColpo(output[0], partitaLogic);
                                stampa.stampaFinePartita(output[1]);
                            } else {
                                System.out.println("Comando non riconosciuto o partita giá avviata");
                            }
                            break;
                    }
                } else {
                    switch (cStrings[0]) {
                        case "/gioca":
                            partitaLogic.avvia();
                            stampa.stampaGriglia(partitaLogic);
                            System.out.println("La partita è stata avviata");
                            break;
                        case "/tempo":
                            if (cStrings.length == 1) {
                                System.out.println("Non hai inserito nessun tempo");
                            } else if (controlli.isInteger(cStrings[1])) {
                                partitaLogic.setTempoMax(Integer.parseInt(cStrings[1]));
                                System.out.println("OK!");
                            } else {
                                System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                            }
                            break;
                        case "/mostralivello":
                            stampa.mostraLivello(partitaLogic);
                            break;
                        case "/mostranavi":
                            stampa.mostraNavi();
                            break;
                        case "/help":
                            stampa.stampaHelp();
                            break;
                        case "/facile":
                            if (cStrings.length == 1) {
                                partitaLogic.setNumMaxErrori(
                                    partitaLogic.getErrorePerLivello("FACILE"));
                                partitaLogic.setLivello("FACILE");
                                System.out.println("OK \n difficoltà impostata a facile");
                            } else if (controlli.isInteger(cStrings[1])) {
                                partitaLogic.setErroriPerLivello("FACILE", Integer.parseInt(cStrings[1]));
                                System.out.println("OK \n numero massimo di errori per il livello FACILE impostato a: "
                                + Integer.parseInt(cStrings[1]));
                            } else {
                                System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                            }
                            break;
                        case "/medio":
                            if (cStrings.length == 1) {
                                partitaLogic.setNumMaxErrori(
                                    partitaLogic.getErrorePerLivello("MEDIO"));
                                partitaLogic.setLivello("MEDIO");
                                System.out.println("OK \n difficoltà impostata a medio");
                            } else if (controlli.isInteger(cStrings[1])) {
                                partitaLogic.setErroriPerLivello("MEDIO", Integer.parseInt(cStrings[1]));
                                System.out.println("OK \n numero massimo di errori per il livello MEDIO impostato a: "
                                + Integer.parseInt(cStrings[1]));
                            } else {
                                System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                            }
                            break;
                        case "/difficile":
                            if (cStrings.length == 1) {
                                partitaLogic.setNumMaxErrori(
                                    partitaLogic.getErrorePerLivello("DIFFICILE"));
                                partitaLogic.setLivello("DIFFICILE");
                                System.out.println("OK \n difficoltà impostata a difficile");
                            } else if (controlli.isInteger(cStrings[1])) {
                                partitaLogic.setErroriPerLivello("DIFFICILE", Integer.parseInt(cStrings[1]));
                                System.out.println("OK\nnumero massimo di errori per il livello DIFFICILE impostato a: "
                                + Integer.parseInt(cStrings[1]));
                            } else {
                                System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                            }
                            break;
                        case "/tentativi":
                            if (cStrings.length == 1) {
                                System.out.println("Non hai inserito nessun numero di tentativi");
                            } else if (controlli.isInteger(cStrings[1])) {
                                partitaLogic.setNumMaxErrori(Integer.parseInt(cStrings[1]));
                                System.out.println("OK!");
                                System.out.println("Numero dei tentativi impostato direttamente a "
                                + Integer.parseInt(cStrings[1]));
                            } else {
                                System.out.println("Non hai inserito un numero corretto o il comando è sbagliato");
                            }
                            break;
                        case "/standard":
                            partitaLogic.setDimMax(Tabella.valueOf("STANDARD").getValue());
                            System.out.println("OK!");
                            break;
                        case "/large":
                            partitaLogic.setDimMax(Tabella.valueOf("LARGE").getValue());
                            System.out.println("OK!");
                            break;
                        case "/extralarge":
                            partitaLogic.setDimMax(Tabella.valueOf("EXTRALARGE").getValue());
                            System.out.println("OK!");
                            break;
                        case "/esci":
                            esci();
                            break;
                        default:
                            System.out.println("Comando non riconosciuto o partita non avviata");
                            break;
                    }
                }

            } else {
                System.out.println("Non hai inserito alcun comando");
            }
        } while (true);
    }



    /**
     * La funzione permette di chiudere il gioco, dopo aver richiesto un input da tastiera allo studente.
     */
    private static void esci() {
        System.out.print("Sei sicuro di voler chiudere il gioco? Se si digitare 'y' "
        + "altrimenti scrivi qualsiasi altra cosa: ");
        String conferma = KEYBOARD.nextLine();
        if (conferma.equals("y")) {
            System.exit(0);
        }
    }



    /**
     * La funzione permette di abbandonare la partita in corso.
     */
    private void abbandona() {
        System.out.print("Sei sicuro di voler abbandonare la partita? Se si digitare 'y' "
        + "altrimenti scrivi qualsiasi altra cosa: ");
        String conferma = KEYBOARD.nextLine();
        if (conferma.equals("y")) {
            stampa.svelaGriglia(partitaLogic);
            partitaLogic.setInCorso(false);
            partitaLogic.resetGrigliaInstance();
            System.out.println("Partita abbandonata!");
        }
    }

    /**
     * Funzione che permettette di prendere il comando in input da tastiera.
     * @return una string contenente le varie "parole del comando"
     */
    private String[] getComando() {

        System.out.print("\nInserisci un comando: ");
        comando = KEYBOARD.nextLine();
        return comando.split(" ");

    }


}
