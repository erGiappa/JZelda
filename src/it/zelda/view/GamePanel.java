package it.zelda.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import it.zelda.model.Player;

public class GamePanel extends JPanel {

    private final Player player;

    public GamePanel(Player player) {
        this.player = player;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna il personaggio
        g.setColor(Color.GREEN);
        g.fillRect(player.getX(), player.getY(), 32, 32);

        // Disegna le informazioni della partita
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 16));

        g.drawString("Vite: " + player.getLives(), 20, 25);
        g.drawString("Rupie: " + player.getRupees(), 20, 45);
        g.drawString("Punteggio: " + player.getScore(), 20, 65);
    }
}