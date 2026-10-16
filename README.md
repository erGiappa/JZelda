#JZelda

JZelda è un progetto universitario sviluppato in Java, ispirato al gameplay della serie The Legend of Zelda.

Il progetto viene sviluppato progressivamente, partendo dalla struttura di base dell'applicazione e introducendo le meccaniche di gioco nelle fasi successive.

Tecnologie
Java 21
Eclipse IDE
Java Swing
Git e GitHub
Struttura del progetto
JZelda/
src/
it/
zelda/
JZelda.java
model/
Player.java
PlayerTest.java
view/
GameFrame.java
GamePanel.java
README.md
PROGRESS.md

Funzionalità attualmente implementate
Modello del giocatore

La classe Player gestisce:

Posizione del personaggio.
Vite disponibili.
Rupie raccolte.
Punteggio.
Operazioni di movimento e aggiornamento delle statistiche.
Interfaccia grafica

L'interfaccia Swing comprende:

Una finestra principale di 800 × 600 pixel.
Uno sfondo nero.
Un personaggio rappresentato da un rettangolo verde.
La visualizzazione delle vite, delle rupie e del punteggio.

La classe PlayerTest consente di eseguire una verifica manuale delle principali operazioni del modello.

Avvio
Importare il progetto in Eclipse.
Verificare che il progetto utilizzi Java 21.
Individuare la classe it.zelda.JZelda.
Eseguire il metodo main.

L'applicazione inizializza il giocatore e apre la finestra del gioco.

Stato dello sviluppo

Il progetto si trova nella fase iniziale di realizzazione del prototipo grafico.

La separazione tra modello e interfaccia è stata avviata. Il movimento tramite tastiera, la mappa, le collisioni, i nemici e le altre meccaniche di gioco sono attività previste per le fasi successive.

Per conoscere lo stato aggiornato delle attività, consultare PROGRESS.md.

Repository

Codice sorgente disponibile su GitHub:

https://github.com/erGiappa/JZelda

Documentazione
PROGRESS.md: registro dei checkpoint, delle funzionalità completate e delle attività successive.
docs/DEVELOPMENT_NOTES.md: destinazione prevista per le decisioni tecniche, se e quando il documento verrà creato.
