JZelda — Registro dei progressi
1. Stato attuale del progetto

Fase: 1 — Struttura iniziale del gioco e prototipo grafico Swing.

Il progetto consiste nello sviluppo di un prototipo ispirato a Zelda, realizzato in Java. In questa fase si stanno costruendo le basi del gioco: modello del giocatore, interfaccia grafica, gestione degli input e organizzazione del codice.

Ambiente di sviluppo
Sistema operativo: macOS, Apple Silicon.
IDE: Eclipse.
JDK: Eclipse Temurin 21.0.12.1.
Linguaggio: Java 21.
Libreria grafica: Java Swing.
Repository GitHub: https://github.com/erGiappa/JZelda
Branch di lavoro: main.
Classe principale: it.zelda.JZelda.
2. Funzionalità implementate
2.1 Configurazione del progetto
Creazione del progetto Java in Eclipse.
Configurazione dell'ambiente Java 21.
Inizializzazione del repository Git locale.
Configurazione del repository remoto GitHub.
Verifica iniziale dell'apertura della finestra Swing.
2.2 Modello del giocatore

È stata creata la classe it.zelda.model.Player, responsabile della gestione dei dati principali del giocatore.

Il modello gestisce:

Posizione del personaggio tramite le coordinate x e y.
Numero iniziale di vite pari a 3.
Numero iniziale di rupie pari a 0.
Punteggio iniziale pari a 0.
Aggiornamento delle coordinate tramite il metodo move(int deltaX, int deltaY).
Perdita di una vita, senza scendere sotto zero.
Incremento di rupie e punteggio tramite valori positivi.

È inoltre presente la classe PlayerTest, utilizzabile per verificare manualmente il comportamento del modello tramite output sul terminale.

2.3 Interfaccia grafica

Sono state create le seguenti classi:

it.zelda.view.GameFrame — finestra principale del gioco, con dimensioni di 800 × 600 pixel.
it.zelda.view.GamePanel — pannello grafico con sfondo nero, personaggio rappresentato da un rettangolo verde e visualizzazione di vite, rupie e punteggio.
it.zelda.JZelda — classe principale che inizializza il modello del giocatore e apre la finestra Swing sul thread dedicato all'interfaccia grafica.
2.4 Movimento tramite tastiera

È stato implementato il movimento del giocatore tramite i quattro tasti freccia, intervenendo sulla classe GamePanel.

La gestione degli input utilizza le key bindings di Swing:

InputMap associa i tasti alle rispettive azioni.
ActionMap definisce le azioni da eseguire.
JComponent.WHEN_IN_FOCUSED_WINDOW permette di attivare i comandi quando la finestra del gioco è attiva.
Ogni pressione di una freccia sposta il personaggio di 10 pixel nella direzione corrispondente.
Il metodo player.move(...) aggiorna le coordinate del modello.
Il metodo repaint() richiede il ridisegno del pannello.

Il metodo paintComponent(Graphics g) continua a disegnare il personaggio e le statistiche della partita.

3. Verifiche eseguite
3.1 Modello e interfaccia iniziale
Verifica iniziale della finestra Swing.
Presenza del modello del giocatore e delle statistiche.
Presenza della struttura iniziale dei package model e view.
3.2 Movimento del giocatore

Il movimento tramite tastiera è stato verificato manualmente avviando l'applicazione da Eclipse.

Controlli superati:

Avvio dell'applicazione senza errori.
Movimento verso destra.
Movimento verso sinistra.
Movimento verso l'alto.
Movimento verso il basso.
Aggiornamento visivo della posizione del personaggio.
Persistenza della visualizzazione di vite, rupie e punteggio.
Assenza di errori nella Console di Eclipse durante le prove.

Il movimento tramite tastiera è quindi considerato implementato e verificato nel prototipo attuale.

Limiti ancora presenti:

Il personaggio può uscire dall'area visibile.
Non sono ancora presenti collisioni.
Il movimento avviene a scatti di 10 pixel per pressione del tasto.
Non è stato implementato il movimento continuo.
4. Organizzazione del codice e architettura

Il codice è stato organizzato nei seguenti package:

it.zelda — classe principale.
it.zelda.model — modello e dati del giocatore.
it.zelda.view — finestra e pannello grafico.

Questa organizzazione costituisce una prima separazione tra dati e presentazione grafica.

L'architettura MVC non è ancora completa: la separazione delle responsabilità e l'eventuale introduzione di un controller dedicato dovranno essere valutate e verificate durante lo sviluppo.

5. Stato del repository Git

Branch di lavoro: main.

Ultimo commit verificato dall'utente: a56aafd — feat: add keyboard movement to player.

Repository remoto: origin.

Stato Git riportato dall'utente:

    Branch locale main allineato con origin/main.
    Nessuna modifica locale rilevata da git diff --stat.
    Nessun file nuovo non tracciato rilevato da git ls-files --others --exclude-standard.

Il movimento tramite tastiera è stato verificato manualmente dall'utente in Eclipse. Le verifiche hanno avuto esito positivo.

Ultima verifica Git eseguita dall'utente: dopo il commit a56aafd. Lo stato dovrà essere ricontrollato dopo le prossime modifiche.

6. Funzionalità non ancora implementate o da verificare
Limiti dell'area di gioco.
Movimento continuo del personaggio.
Aggiornamento automatico della scena durante il movimento continuo.
Collisioni con muri, ostacoli e nemici.
Mappa di gioco e gestione delle aree.
Nemici, combattimento, oggetti e interazioni.
Gestione completa delle regole di gioco.
Test automatizzati e configurazione di un framework di test.
Completamento e verifica dell'architettura MVC.
7. Prossime attività

    Analizzare l'implementazione attuale di GamePanel.java e individuare come vengono gestite le coordinate del giocatore e le dimensioni dell'area di gioco.
    Progettare una modifica circoscritta per impedire al personaggio di oltrepassare i bordi dell'area visibile.
    Implementare i limiti senza alterare il comportamento del movimento già verificato.
    Verificare manualmente tutti e quattro i bordi, il movimento verso l'interno e la persistenza delle statistiche.
    Aggiornare questo registro con le modifiche effettive, le verifiche eseguite, gli eventuali problemi e lo stato Git.
    Proseguire con il prossimo obiettivo soltanto dopo aver verificato il checkpoint.

8. Regola di aggiornamento del registro

Aggiornare questo file al termine di ogni checkpoint, riportando:

Modifiche effettivamente realizzate.
Verifiche e test eseguiti, con i relativi risultati.
Problemi incontrati e soluzioni adottate.
Stato del repository Git, incluso il branch, il commit e le modifiche locali.
Prossima attività concreta.

Distinguere sempre le funzionalità implementate e verificate da quelle soltanto pianificate o ancora da verificare.

Il registro deve descrivere lo stato reale del progetto, senza considerare completata una funzionalità prima di averne verificato il comportamento.

Checkpoint — Limiti del movimento del giocatore
Modifiche effettuate

File modificato: src/it/zelda/view/GamePanel.java.

Introdotto il metodo movePlayer(int deltaX, int deltaY) per controllare la posizione successiva del giocatore.
Calcolati i limiti del movimento usando le dimensioni effettive di GamePanel e la dimensione del personaggio (32 × 32 pixel).
Impedito alle coordinate di superare i limiti dell'area di gioco.
Gestiti gli spostamenti parziali necessari per raggiungere esattamente i bordi.
Aggiornate le azioni della tastiera per utilizzare movePlayer(...) prima di richiedere il ridisegno con repaint().
Lasciati invariati Player.java, GameFrame.java e il sistema di statistiche.
Verifiche eseguite

Verifica manuale eseguita dall'utente in Eclipse: esito positivo.

Avvio del progetto senza errori segnalati.
Movimento nelle quattro direzioni.
Arresto del movimento ai bordi dell'area di gioco.
Possibilità di tornare verso l'interno dopo aver raggiunto un bordo.
Persistenza delle statistiche e corretto aggiornamento grafico.

Nota: i risultati derivano dalla verifica manuale dell'utente; non sono stati eseguiti test automatici documentati in questo checkpoint.

Stato Git

Commit precedente: a56aafd — feat: add keyboard movement to player.

Il codice di GamePanel.java è stato modificato dopo questo commit. Stato Git successivo alla modifica: da verificare.

Prossimo passo

Controllare le modifiche con Git, aggiornare il registro e individuare il prossimo obiettivo in base al codice e alle attività ancora da completare.