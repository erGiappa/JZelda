package it.zelda.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import it.zelda.model.Player;

public class GamePanel extends JPanel {

    private final Player player;

    public GamePanel(Player player) {
        this.player = player;
        setBackground(Color.BLACK);

        // Associa le frecce alle azioni di movimento.
        bindMovementKey("UP", "moveUp", 0, -10);
        bindMovementKey("DOWN", "moveDown", 0, 10);
        bindMovementKey("LEFT", "moveLeft", -10, 0);
        bindMovementKey("RIGHT", "moveRight", 10, 0);
    }

    private void bindMovementKey(
            String keyStroke,
            String actionKey,
            int deltaX,
            int deltaY) {

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(keyStroke), actionKey);

        getActionMap().put(actionKey, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                movePlayer(deltaX, deltaY);
                repaint();
            }
            private void movePlayer(int deltaX, int deltaY) {
                int playerSize = 32;

                int maxX = Math.max(0, getWidth() - playerSize);
                int maxY = Math.max(0, getHeight() - playerSize);

                int nextX = Math.max(0,
                        Math.min(player.getX() + deltaX, maxX));

                int nextY = Math.max(0,
                        Math.min(player.getY() + deltaY, maxY));

                player.move(
                        nextX - player.getX(),
                        nextY - player.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

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