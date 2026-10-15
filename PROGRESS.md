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
Branch corrente: main.
Ultimo commit verificato prima delle modifiche locali: b90ca44 (chore: initialize JZelda project).
Repository remoto configurato come origin.
Modifiche locali presenti in JZelda.java.
Nuove classi presenti nelle directory model e view, non ancora tracciate da Git.
Aggiornamento di questo registro e del README previsto per il checkpoint corrente.
Commit e push delle modifiche correnti ancora da completare.
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
Aggiornare e verificare la documentazione.
Controllare le modifiche e i file da includere nel commit.
Creare un commit descrittivo per il modello del giocatore e la prima interfaccia grafica.
Eseguire il push su GitHub e verificare l'allineamento con origin/main.
Implementare il movimento del personaggio tramite tastiera.
Proseguire con la mappa e le prime meccaniche di gioco.
Regola di aggiornamento

Aggiornare questo file al termine di ogni checkpoint, indicando le funzionalità effettivamente completate, i controlli eseguiti, gli eventuali problemi e le prossime attività. Distinguere sempre le funzionalità implementate da quelle soltanto pianificate.