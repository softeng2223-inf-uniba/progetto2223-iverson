# Report
---

## 1)INTRODUZIONE
Il gioco realizzato è quello della battaglia navale, con una versione a giocatore singolo contro la CPU. Di seguito le regole del gioco:
* Il sistema posiziona casualmente le navi su una griglia 10x10. Le navi posizionate sono molteplici: 
    * Cacciatorpediniere (4 esemplari,2 caselle);
    * Incrociatore (3 esemplari, 3 caselle);
    * Corazzata (2 esemplari, 4 caselle);
    * Portaerei (1 esemplari, 5 caselle).
* Il giocatore cerca di indovinare la posizione delle navi e affondarle 
* Il giocatore vince se affonda tutte le navi prima di esaurire le mosse 
* Il numero di mosse disponibili dipende dalla modalità di gioco (facile/media/difficile/…)

---

## 2)MODELLO DI DOMINIO
Il modello di dominio è un diagramma delle classi con prospettive concettuali, esso è una visuale di concetti caratteristici del dominio studiato
![Schema_Star_Uml](./img/Schema_Star_Uml.png)

---
## 3)REQUISITI SPECIFICI
Di seguito si riporta l'elenco dei requisiti che l'applicazione soddisfa, divisi in requisiti funzionali (le funzionalità che devono essere fruibili dall'utente) e requisiti non funzionali (le caratteristiche che l'applicazione dovrà avere in merito alla sua esecuzione):
#### 3.1 REQUISITI FUNZIONALI
Attori/utenti del sistema: giocatore della partita.
* **RF1**: Come giocatore voglio mostrare l’help con elenco comandi
* **RF2**: Come giocatore voglio chiudere il gioco
* **RF3**:Come giocatore voglio impostare il livello di gioco per variare il numero massimo di tentativi sbagliati
* **RF4**: Come giocatore voglio mostrare il livello di gioco e il numero massimo di tentativi falliti
* **RF5**: Come giocatore voglio mostrare i tipi di nave e il numero di esemplari per ogni tipo
* **RF6**: Come giocatore voglio iniziare una nuova partita
* **RF7**: Come giocatore voglio svelare la griglia con le navi posizionate


#### 3.2 REQUISITI NON FUNZIONALI
**RNF1**: il container docker dell’app deve essere eseguito da terminali che supportano Unicode con encoding UTF-8 o UTF-16. Alcuni dei terminali supportati sono:
*	Terminal di Linux
*	Powershell Windows
*	Git Bash (in questo caso il comando Docker ha come prefisso winpty; es: winpty docker -it ....)

----

## 7)MANUALE UTENTE
Nel caso l'utente avvii il programma senza inserire nessun parametro verrà mostrato questo:
![Descrizione](./img/Descrizione.jpg)
Nel caso l'utente avvii il programma inserendo il parametro "<span style="color:red">--help</span>" oppure "<span style="color:red">-help</span>" verrà mostrato questo:
![helpconparametro](./img/Helpconparametro.jpg)
Nel caso l'utente inserisca <span style="color:red">/help</span> per avere piu' informazioni verrà stampato questo:
![helpbase](./img/helpbase.jpg)
Nel caso l'utente inserisca il comando <span style="color:red">/gioca</span> verrà iniziata una nuova partita:
![gioca](./img/gioca.jpg)
Nel caso l'utente inserisca il comando <span style="color:red">/mostranavi</span> verrà stampata una legende delle navi disponibili:
![Mostranavi](./img/MostraNavi.jpg)
Nel caso l'utente (a partita in corso) inserisca il comando <span style="color:red">/svelagriglia</span> verrà mostrata la griglia con le navi posizionate:
![StampaGriglia](./img/StampaGriglia.jpg)
Nel caso l'utente inserisca il comando <span style="color:red">/mostralivello</span> verrà visualizzato il livello al quale l'utente sta giocando, il livello è impostabile quando la partita inizia (tramite i comandi "<span style="color:red">/facile</span>", "<span style="color:red">/medio</span>", "<span style="color:red">/difficile</span>") e non è modificabile a partita in corso:
![mostralivello](./img/mostralivello.jpg)
Nel caso l'utente inserisca il comando "<span style="color:red">/esci</span>" prima gli verrà chiesta conferma di uscita e in seguito ad un risposta affermativa l'applicazione si chiuderà:
![esci](./img/esci.jpg)


---

## 9)RETROSPETTIVA
Di seguito la retrospettiva degli sprint precedenti. Sono state raccolte le 
osservazioni e le opinioni dei membri del team riguardo al lavoro svolto in
un modello di retrospettiva "sad,mad,glad".
### 9.1) SPRINT 0

![Retrospettiva](./img/Retrospettiva.png)
