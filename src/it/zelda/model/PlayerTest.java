package it.zelda.model;

public class PlayerTest {

    public static void main(String[] args) {
        Player player = new Player();

        System.out.println("Vite iniziali: " + player.getLives());
        System.out.println("Rupie iniziali: " + player.getRupees());
        System.out.println("Punteggio iniziale: " + player.getScore());

        player.move(10, 5);
        player.loseLife();
        player.addRupees(3);
        player.addScore(100);

        System.out.println("Posizione: " + player.getX()
                + ", " + player.getY());
        System.out.println("Vite dopo il danno: " + player.getLives());
        System.out.println("Rupie raccolte: " + player.getRupees());
        System.out.println("Punteggio finale: " + player.getScore());
    }
}
