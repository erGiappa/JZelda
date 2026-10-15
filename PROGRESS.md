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
Branch corrente: main.
Ultimo commit verificato: c4a25a9 — docs: update project progress checkpoint.
Repository remoto: origin.
Ultimo stato Git verificato: branch locale main allineato con origin/main.
Modifiche locali pendenti: nessuna al momento dell'ultima verifica effettuata prima dell'implementazione del movimento.

Il commit c4a25a9 è stato pubblicato su GitHub. Le modifiche al movimento tramite tastiera sono state successivamente implementate e verificate in Eclipse, ma il loro stato Git deve ancora essere controllato.

Non è quindi ancora confermato se le modifiche più recenti siano state registrate in un commit o pubblicate su GitHub.

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
Verificare lo stato Git dopo l'implementazione del movimento tramite tastiera.
Controllare le modifiche a GamePanel.java e PROGRESS.md.
Registrare il checkpoint corrente e aggiornare la documentazione.
Analizzare come impedire al personaggio di uscire dall'area di gioco.
Implementare e verificare i limiti di movimento con una modifica alla volta.
Proseguire successivamente con la mappa e le prime meccaniche di gioco.

Il prossimo intervento sul codice non deve iniziare prima di aver verificato lo stato Git e confermato il punto di ripartenza.

8. Regola di aggiornamento del registro

Aggiornare questo file al termine di ogni checkpoint, riportando:

Modifiche effettivamente realizzate.
Verifiche e test eseguiti, con i relativi risultati.
Problemi incontrati e soluzioni adottate.
Stato del repository Git, incluso il branch, il commit e le modifiche locali.
Prossima attività concreta.

Distinguere sempre le funzionalità implementate e verificate da quelle soltanto pianificate o ancora da verificare.

Il registro deve descrivere lo stato reale del progetto, senza considerare completata una funzionalità prima di averne verificato il comportamento.