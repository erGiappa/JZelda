package it.zelda.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import it.zelda.model.GameMap;
import it.zelda.model.Player;

public class GamePanel extends JPanel {

    private final Player player;
    private final GameMap gameMap;

    // Direzioni attualmente premute.
    private final Set<String> pressedDirections = new HashSet<>();

    // Timer che aggiorna il movimento ogni 50 millisecondi.
    private final Timer movementTimer;

    private boolean collidesWithObstacle(Rectangle bounds) {
        for (Rectangle obstacle : gameMap.getObstacles()) {
            if (bounds.intersects(obstacle)) {
                return true;
            }
        }

        return false;
    }

    public GamePanel(Player player) {
        this.player = player;
        this.gameMap = new GameMap();

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

        int currentX = player.getX();
        int currentY = player.getY();

        // Movimento orizzontale, un pixel alla volta.
        int stepX = Integer.compare(deltaX, 0);

        for (int i = 0; i < Math.abs(deltaX); i++) {
            int nextX = Math.max(0,
                    Math.min(currentX + stepX, maxX));

            if (nextX == currentX) {
                break;
            }

            Rectangle nextBounds =
                    new Rectangle(nextX, currentY, playerSize, playerSize);

            if (collidesWithObstacle(nextBounds)) {
                break;
            }

            currentX = nextX;
        }

        // Movimento verticale, un pixel alla volta.
        int stepY = Integer.compare(deltaY, 0);

        for (int i = 0; i < Math.abs(deltaY); i++) {
            int nextY = Math.max(0,
                    Math.min(currentY + stepY, maxY));

            if (nextY == currentY) {
                break;
            }

            Rectangle nextBounds =
                    new Rectangle(currentX, nextY, playerSize, playerSize);

            if (collidesWithObstacle(nextBounds)) {
                break;
            }

            currentY = nextY;
        }

        player.move(
                currentX - player.getX(),
                currentY - player.getY());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna tutti gli ostacoli definiti nella mappa.
        g.setColor(Color.GRAY);

        for (Rectangle obstacle : gameMap.getObstacles()) {
            g.fillRect(
                    obstacle.x,
                    obstacle.y,
                    obstacle.width,
                    obstacle.height
            );
        }

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
