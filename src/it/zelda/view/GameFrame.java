package it.zelda.view;

import javax.swing.JFrame;

import it.zelda.model.Player;

public class GameFrame extends JFrame {

    public GameFrame(Player player) {
        setTitle("JZelda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(new GamePanel(player));
    }
}