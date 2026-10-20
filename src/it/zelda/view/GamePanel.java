
package it.zelda.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import it.zelda.model.Player;
import java.awt.Rectangle;

public class GamePanel extends JPanel {

    private final Player player;
    private final Rectangle obstacle =
            new Rectangle(300, 200, 80, 80);

    // Direzioni attualmente premute.
    private final Set<String> pressedDirections = new HashSet<>();

    // Timer che aggiorna il movimento ogni 50 millisecondi.
    private final Timer movementTimer;

    public GamePanel(Player player) {
        this.player = player;
        setBackground(Color.BLACK);

        // Timer che aggiorna il movimento ogni 50 millisecondi.
        movementTimer = new Timer(50, e -> updateMovement());
        movementTimer.start();

        // Associa le frecce alle azioni di movimento.
        bindMovementKey("UP", "moveUp");
        bindMovementKey("DOWN", "moveDown");
        bindMovementKey("LEFT", "moveLeft");
        bindMovementKey("RIGHT", "moveRight");
        }

    private void bindMovementKey(
            String keyStroke,
            String actionKey) {

        String direction = actionKey.substring(4).toUpperCase();

        // Registra la pressione del tasto.
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("pressed " + keyStroke), actionKey);

        getActionMap().put(actionKey, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pressedDirections.add(direction);
            }
        });

        // Registra il rilascio del tasto.
        String releaseKey = actionKey + "Released";

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released " + keyStroke), releaseKey);

        getActionMap().put(releaseKey, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pressedDirections.remove(direction);
            }
        });
    }

    private void updateMovement() {
        if (pressedDirections.contains("UP")) {
            movePlayer(0, -10);
        }

        if (pressedDirections.contains("DOWN")) {
            movePlayer(0, 10);
        }

        if (pressedDirections.contains("LEFT")) {
            movePlayer(-10, 0);
        }

        if (pressedDirections.contains("RIGHT")) {
            movePlayer(10, 0);
        }

        if (!pressedDirections.isEmpty()) {
            repaint();
        }
    }



private void movePlayer(int deltaX, int deltaY) {
    int playerSize = 32;

    int maxX = Math.max(0, getWidth() - playerSize);
    int maxY = Math.max(0, getHeight() - playerSize);

    int nextX = Math.max(0,
            Math.min(player.getX() + deltaX, maxX));

    int nextY = Math.max(0,
            Math.min(player.getY() + deltaY, maxY));

    // Rettangolo della posizione candidata.
    Rectangle nextPlayerBounds =
            new Rectangle(nextX, nextY, playerSize, playerSize);

    // Se c'è una collisione, prova a scorrere lungo l'asse libero.
    if (nextPlayerBounds.intersects(obstacle)) {

        // Movimento orizzontale: mantieni la coordinata Y.
        if (deltaX != 0) {
            nextX = Math.max(0,
                    Math.min(player.getX() + deltaX, maxX));

            Rectangle horizontalBounds =
                    new Rectangle(nextX, player.getY(),
                            playerSize, playerSize);

            if (horizontalBounds.intersects(obstacle)) {
                nextX = player.getX();

                // Avanza fino al bordo dell'ostacolo, se possibile.
                if (deltaX > 0) {
                    nextX = obstacle.x - playerSize;
                } else {
                    nextX = obstacle.x + obstacle.width;
                }
            }

            nextX = Math.max(0, Math.min(nextX, maxX));
        }

        // Movimento verticale: mantieni la coordinata X.
        if (deltaY != 0) {
            nextY = Math.max(0,
                    Math.min(player.getY() + deltaY, maxY));

            Rectangle verticalBounds =
                    new Rectangle(player.getX(), nextY,
                            playerSize, playerSize);

            if (verticalBounds.intersects(obstacle)) {
                nextY = player.getY();

                // Avanza fino al bordo dell'ostacolo, se possibile.
                if (deltaY > 0) {
                    nextY = obstacle.y - playerSize;
                } else {
                    nextY = obstacle.y + obstacle.height;
                }
            }

            nextY = Math.max(0, Math.min(nextY, maxY));
        }
    }

    // Verifica finale: non applicare mai una posizione in collisione.
    Rectangle finalBounds =
            new Rectangle(nextX, nextY, playerSize, playerSize);

    if (finalBounds.intersects(obstacle)) {
        return;
    }

    player.move(
            nextX - player.getX(),
            nextY - player.getY());
}



@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Disegna l'ostacolo statico.
    g.setColor(Color.GRAY);
    g.fillRect(
            obstacle.x,
            obstacle.y,
            obstacle.width,
            obstacle.height);

    // Disegna il personaggio.
    g.setColor(Color.GREEN);
    g.fillRect(player.getX(), player.getY(), 32, 32);

    // Disegna le informazioni della partita.
    g.setColor(Color.WHITE);
    g.setFont(new Font("SansSerif", Font.BOLD, 16));

    g.drawString("Vite: " + player.getLives(), 20, 25);
    g.drawString("Rupie: " + player.getRupees(), 20, 45);
    g.drawString("Punteggio: " + player.getScore(), 20, 65);
}
}
