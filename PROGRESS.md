JZelda - Registro dei progressi
Stato attuale

Fase 1 - Struttura iniziale del gioco e prototipo grafico Swing.

Ambiente di sviluppo
Sistema operativo: macOS, Apple Silicon.
IDE: Eclipse.
JDK: Eclipse Temurin 21.0.12.1.
Linguaggio: Java 21.
Libreria grafica: Java Swing.
Repository GitHub: https://github.com/erGiappa/JZelda.
Branch di lavoro: main.
Classe principale: it.zelda.JZelda.
Funzionalità completate
Configurazione del progetto
Creazione del progetto Java in Eclipse.
Configurazione dell'ambiente Java 21.
Inizializzazione del repository Git locale.
Configurazione del repository remoto GitHub.
Verifica iniziale della finestra Swing.
Modello del giocatore

È stata creata la classe it.zelda.model.Player, che gestisce:

Posizione del personaggio tramite coordinate x e y.
Numero iniziale di vite pari a 3.
Rupie iniziali pari a 0.
Punteggio iniziale pari a 0.
Movimento tramite aggiornamento delle coordinate.
Perdita di una vita, senza scendere sotto zero.
Incremento di rupie e punteggio con valori positivi.

È presente la classe PlayerTest, utilizzabile per verificare manualmente il comportamento del modello tramite output sul terminale.

Interfaccia grafica

Sono state create le seguenti classi:

it.zelda.view.GameFrame: finestra principale del gioco, con dimensioni di 800 × 600 pixel.
it.zelda.view.GamePanel: pannello grafico con sfondo nero, personaggio rappresentato da un rettangolo verde e visualizzazione di vite, rupie e punteggio.
it.zelda.JZelda: classe principale che inizializza il modello del giocatore e apre la finestra Swing sul thread dedicato all'interfaccia grafica.
Architettura

Il codice è stato organizzato nelle directory model e view, con la classe principale nel package it.zelda.

Questa organizzazione costituisce una prima separazione tra dati del giocatore e presentazione grafica. L'architettura MVC dovrà essere completata e verificata con l'introduzione delle ulteriori responsabilità necessarie.

Stato del repository

Branch corrente: main. Ultimo commit verificato: abd51a8 (feat: add player model and initial game interface). Repository remoto configurato come origin. Il branch locale main risulta allineato con origin/main, secondo la verifica eseguita tramite git status -sb. Al momento della verifica, Git non segnalava modifiche locali pendenti. Il commit corrente contiene il modello del giocatore e la prima interfaccia grafica Swing. Il movimento tramite tastiera e le successive meccaniche di gioco devono ancora essere implementati e verificati.
Funzionalità non ancora implementate o da verificare
Movimento del personaggio tramite tastiera.
Aggiornamento e ridisegno automatico della scena durante il gioco.
Collisioni con muri, ostacoli e nemici.
Mappa di gioco e gestione delle aree.
Nemici, combattimento, oggetti e interazioni.
Gestione completa delle regole di gioco.
Test automatizzati e configurazione di un framework di test.
Completamento dell'architettura MVC.
Prossime attività

    Verificare e consolidare la documentazione del progetto.
    Analizzare il codice attuale prima di introdurre nuove modifiche.
    Implementare il movimento del giocatore tramite tastiera.
    Verificare il movimento e il ridisegno della scena.
    Proseguire con la mappa e le prime meccaniche di gioco.
    Aggiornare questo registro al termine di ogni checkpoint, riportando modifiche effettive, verifiche eseguite, eventuali problemi e prossime attività.
Regola di aggiornamento

Aggiornare questo file al termine di ogni checkpoint, indicando le funzionalità effettivamente completate, i controlli eseguiti, gli eventuali problemi e le prossime attività. Distinguere sempre le funzionalità implementate da quelle soltanto pianificate.