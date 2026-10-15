package it.zelda;

import javax.swing.SwingUtilities;

import it.zelda.model.Player;
import it.zelda.view.GameFrame;

public class JZelda {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Player player = new Player();

            GameFrame gameFrame = new GameFrame(player);
            gameFrame.setVisible(true);
        });
    }
}
