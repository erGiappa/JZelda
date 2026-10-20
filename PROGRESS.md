JZelda — Registro dei progressi
1. Stato attuale del progetto

Fase: 1 — Struttura iniziale del gioco e prototipo grafico Swing.

JZelda è un progetto universitario sviluppato in Java, ispirato alla serie Zelda. In questa fase si stanno costruendo le basi del gioco: modello del giocatore, interfaccia grafica, gestione degli input e organizzazione del codice.
Ambiente di sviluppo

    Sistema operativo: macOS, Apple Silicon.
    IDE: Eclipse.
    JDK: Eclipse Temurin 21.0.12.1.
    Linguaggio: Java 21.
    Libreria grafica: Java Swing.
    Repository GitHub: https://github.com/erGiappa/JZelda
    Branch di lavoro: main.
    Classe principale: it.zelda.JZelda.

2. Struttura del progetto e funzionalità implementate
2.1 Configurazione del progetto

    Progetto Java configurato in Eclipse.
    Ambiente Java 21 configurato.
    Repository Git locale e repository remoto GitHub configurati.
    Finestra Swing iniziale implementata.

2.2 Modello del giocatore

La classe it.zelda.model.Player gestisce i dati principali del giocatore:

    Coordinate x e y.
    Vite iniziali: 3.
    Rupie iniziali: 0.
    Punteggio iniziale: 0.
    Movimento tramite move(int deltaX, int deltaY).
    Perdita di una vita, senza scendere sotto zero.
    Incremento di rupie e punteggio tramite valori positivi.

È presente anche PlayerTest, utilizzabile per verifiche manuali del modello tramite output sul terminale.
2.3 Interfaccia grafica

Sono presenti le seguenti classi:

    it.zelda.JZelda: inizializza il modello del giocatore e avvia la finestra Swing sul thread dell'interfaccia grafica.
    it.zelda.view.GameFrame: finestra principale del gioco, configurata con dimensioni esterne di 800 × 600 pixel e non ridimensionabile.
    it.zelda.view.GamePanel: pannello con sfondo nero, giocatore rappresentato da un rettangolo verde di 32 × 32 pixel e visualizzazione delle statistiche.

Le statistiche visualizzate sono vite, rupie e punteggio.
2.4 Movimento tramite tastiera

In GamePanel è stato implementato il movimento tramite i quattro tasti freccia.

La gestione degli input utilizza le key bindings di Swing:

    InputMap associa i tasti alle rispettive azioni.
    ActionMap definisce il comportamento delle azioni.
    JComponent.WHEN_IN_FOCUSED_WINDOW permette di ricevere i comandi quando la finestra del gioco è attiva.

Il movimento iniziale utilizzava uno spostamento di 10 pixel per ogni attivazione di una freccia.

Il metodo player.move(...) aggiorna le coordinate del modello, mentre repaint() richiede il ridisegno del pannello.
2.5 Limiti dell'area di gioco

È stato implementato il controllo dei limiti del movimento in it.zelda.view.GamePanel.

Il metodo movePlayer(int deltaX, int deltaY):

    Calcola le coordinate successive del giocatore.
    Usa le dimensioni effettive del pannello.
    Tiene conto delle dimensioni del personaggio, pari a 32 × 32 pixel.
    Impedisce alle coordinate di diventare negative o di superare i limiti consentiti.
    Permette di raggiungere esattamente un bordo anche quando lo spostamento richiesto di 10 pixel lo oltrepasserebbe.
    Aggiorna il modello riutilizzando player.move(...).

Le azioni associate alle frecce utilizzano il metodo di movimento, mantenendo attivo il controllo dei confini.

Il controllo dei limiti è stato verificato manualmente dall'utente in Eclipse.
2.6 Movimento continuo del personaggio

Il movimento continuo è stato implementato in it.zelda.view.GamePanel utilizzando javax.swing.Timer e le key bindings di Swing.

Il timer viene inizializzato con un intervallo di 50 millisecondi e richiama periodicamente il metodo updateMovement().

La classe mantiene un insieme di direzioni attive, pressedDirections, dichiarato come Set<String> e inizializzato con HashSet.

La gestione dei tasti funziona nel seguente modo:

    Alla pressione di una freccia, la direzione corrispondente viene aggiunta a pressedDirections.
    Al rilascio della freccia, la direzione viene rimossa dall'insieme.
    Durante ogni aggiornamento del timer, updateMovement() controlla le direzioni attive.
    Per ogni direzione attiva viene richiamato movePlayer(...).
    Se è attivo almeno un movimento, viene richiesto il ridisegno tramite repaint().

Lo spostamento è di 10 pixel per aggiornamento su ciascun asse attivo. La pressione contemporanea di due frecce permette il movimento diagonale.

Il metodo movePlayer(...) conserva il controllo dei limiti dell'area di gioco. Il movimento continuo riutilizza quindi la logica dei confini già implementata, senza introdurre un secondo sistema di controllo delle coordinate.

L'intervallo di 50 millisecondi corrisponde a una frequenza teorica di 20 aggiornamenti al secondo. La frequenza effettiva può variare in base al funzionamento del timer Swing e al carico del sistema.

Verifiche manuali eseguite in Eclipse:

    Movimento continuo mantenendo premute le frecce.
    Arresto del movimento al rilascio dei tasti.
    Movimento verso l'alto, il basso, destra e sinistra.
    Arresto del personaggio ai quattro bordi dell'area di gioco.
    Possibilità di tornare verso l'interno dopo aver raggiunto un bordo.
    Persistenza della visualizzazione delle statistiche.

L'utente ha confermato che tutte le prove hanno avuto esito positivo.

Le verifiche descritte sono manuali. Non sono ancora documentati test automatici specifici per il movimento continuo.
3. Verifiche eseguite
3.1 Avvio e interfaccia

È stata verificata manualmente l'apertura dell'applicazione da Eclipse.

Il pannello visualizza il personaggio e le statistiche della partita.
3.2 Movimento e limiti

L'utente ha confermato l'esito positivo delle verifiche manuali in Eclipse.

Sono stati verificati:

    Movimento nelle quattro direzioni.
    Aggiornamento visivo della posizione del personaggio.
    Arresto del movimento ai bordi dell'area di gioco.
    Possibilità di tornare verso l'interno dopo aver raggiunto un bordo.
    Persistenza delle statistiche e corretto aggiornamento grafico.

3.3 Movimento continuo

L'utente ha confermato che il movimento continuo funziona correttamente in Eclipse.

Sono stati verificati:

    Movimento ripetuto mentre una freccia rimane premuta.
    Arresto del movimento al rilascio del tasto.
    Funzionamento delle quattro direzioni.
    Rispetto dei limiti durante il movimento continuo.
    Possibilità di invertire la direzione dopo aver raggiunto un bordo.
    Persistenza della visualizzazione delle statistiche.

3.4 Controlli Git

Durante il checkpoint è stato eseguito git diff --check, senza segnalazioni.

Il controllo verifica la presenza di problemi di whitespace nel diff, ma non sostituisce la compilazione Java né le prove funzionali.

L'utente ha inoltre verificato manualmente il funzionamento dell'applicazione in Eclipse.

Non sono documentati test automatici per il movimento, i confini o il movimento continuo.
4. Organizzazione del codice e architettura

Il codice è organizzato nei seguenti package:

    it.zelda: classe principale.
    it.zelda.model: modello e dati del giocatore.
    it.zelda.view: finestra e pannello grafico.

Questa organizzazione costituisce una prima separazione tra dati e presentazione.

L'architettura MVC non è ancora completa. L'eventuale introduzione di un controller dedicato e un'ulteriore separazione delle responsabilità dovranno essere valutate durante lo sviluppo.

La gestione del movimento e degli input è attualmente concentrata in GamePanel. Un'eventuale riorganizzazione potrà essere valutata quando le funzionalità di gioco diventeranno più articolate.
5. Funzionalità non ancora implementate o da verificare

Le seguenti funzionalità non devono essere considerate implementate senza averne verificato il codice e il comportamento:

- Collisioni con ostacoli statici: implementata una prima collisione
  rettangolare in GamePanel. La collisione è stata verificata
  manualmente in Eclipse. La gestione di più ostacoli e delle
  collisioni con muri e nemici resta da implementare.

Il movimento a scatti, i limiti dell'area di gioco e il movimento continuo sono invece implementati e verificati manualmente nel prototipo attuale.
6. Stato Git

Branch locale: main.
Branch remoto: origin/main.
Ultimo commit registrato prima del checkpoint: 2770adc.
La modifica alle collisioni in GamePanel.java è locale e non
ancora registrata in un commit.
git diff --check è stato eseguito senza segnalazioni.
La compilazione di tutti i file Java con javac è riuscita.
PlayerTest è stato eseguito e ha prodotto i risultati attesi.

7. Prossime attività

Il movimento continuo del personaggio è stato implementato e verificato manualmente in Eclipse.

Il prossimo obiettivo proposto è introdurre una prima gestione delle collisioni con muri e ostacoli.

Prima di iniziare:

    Esaminare il codice esistente e la struttura dei package.
    Verificare se esistono già componenti utili alla rappresentazione della mappa.
    Individuare una soluzione circoscritta, coerente con l'architettura attuale.
    Concordare una sola modifica alla volta.
    Implementare la modifica senza compromettere il movimento e i limiti già esistenti.
    Verificare il comportamento in Eclipse.
    Aggiornare questo registro al termine del checkpoint.

Le collisioni e la mappa di gioco sono un obiettivo pianificato, non funzionalità già implementate.
8. Regola di aggiornamento del registro

Al termine di ogni checkpoint, aggiornare questo documento riportando:

    Modifiche effettivamente realizzate.
    File modificati.
    Verifiche e test eseguiti, con i relativi risultati.
    Problemi incontrati e soluzioni adottate.
    Stato del repository Git, branch, commit e modifiche locali.
    Prossima attività concreta.

Distinguere sempre le funzionalità implementate e verificate da quelle soltanto pianificate o ancora da verificare.

Il registro deve descrivere lo stato reale del progetto e non deve considerare completata una funzionalità prima di averne verificato il comportamento.
9. Ultimo checkpoint completato — Limiti del movimento
Modifiche effettuate

File funzionale modificato: src/it/zelda/view/GamePanel.java.

    Aggiunto movePlayer(int deltaX, int deltaY).
    Calcolati i limiti usando le dimensioni effettive del pannello e la dimensione del personaggio.
    Impedita l'uscita del personaggio dall'area di gioco.
    Mantenuto il movimento tramite le quattro frecce.
    Conservata la visualizzazione delle statistiche.

Verifiche eseguite

L'utente ha confermato che il movimento e i limiti funzionano correttamente in Eclipse.

Il controllo git diff --check è stato eseguito senza segnalazioni prima della creazione del commit.
Stato del checkpoint

Commit creato:

87daa44 — feat: constrain player movement to game area

L'utente ha successivamente eseguito il push del commit su GitHub.
10. Ultimo checkpoint funzionale — Movimento continuo

Modifiche e stato

Il movimento continuo è implementato in GamePanel.java mediante javax.swing.Timer, pressedDirections e updateMovement(). Il movimento riutilizza movePlayer(...), che mantiene il controllo dei bordi dell'area di gioco.

Verifiche manuali eseguite in Eclipse

Tutte le verifiche seguenti hanno avuto esito positivo:

    Avvio dell'applicazione senza errori.
    Movimento continuo mantenendo premuta una freccia.
    Arresto del movimento al rilascio del tasto.
    Funzionamento delle quattro direzioni.
    Rispetto dei bordi dell'area di gioco.
    Possibilità di tornare verso l'interno dopo aver raggiunto un bordo.
    Persistenza della visualizzazione delle statistiche.

Non sono documentati test automatici specifici per il movimento continuo o le collisioni.

Modifica locale successiva al commit

È stato riordinato il gruppo degli import in src/it/zelda/view/GamePanel.java. Il diff esaminato non mostra modifiche alla logica del movimento. La modifica locale non è ancora registrata in un nuovo commit.

## 11. Checkpoint — Prima collisione con ostacolo statico

### Modifiche effettuate

File modificato: src/it/zelda/view/GamePanel.java.

- Aggiunto un ostacolo rettangolare statico di 80 × 80 pixel,
  posizionato alle coordinate (300, 200).
- Aggiunto il controllo delle collisioni tramite
  java.awt.Rectangle e intersects(...).
- Modificato movePlayer(...) per impedire l'attraversamento
  dell'ostacolo e consentire il contatto con il bordo.
- Aggiunto il disegno dell'ostacolo grigio in paintComponent(...).

### Verifiche eseguite

- L'utente ha confermato manualmente in Eclipse che l'ostacolo
  è visibile e non può essere attraversato.
- L'utente ha confermato che la correzione permette al personaggio
  di raggiungere il bordo dell'ostacolo.
- git diff --check è terminato senza segnalazioni.
- La compilazione con javac di tutti i file Java è terminata
  senza errori.
- PlayerTest è stato eseguito e ha prodotto i valori attesi.

Le verifiche delle collisioni sono manuali.
Non sono ancora presenti test automatici specifici per le collisioni.

### Stato Git

La modifica a GamePanel.java è locale e deve essere verificata
prima di creare il commit.
Il commit precedente è 2770adc.
Nessun nuovo commit è stato ancora creato.

### Prossimo obiettivo

Valutare come rappresentare più ostacoli statici senza duplicare
la logica di collisione, mantenendo il movimento continuo e
il controllo dei confini già implementati.
