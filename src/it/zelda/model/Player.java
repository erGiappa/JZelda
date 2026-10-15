package it.zelda.model;

public class Player {

    private int x;
    private int y;
    private int lives;
    private int rupees;
    private int score;

    public Player() {
        x = 100;
        y = 100;
        lives = 3;
        rupees = 0;
        score = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLives() {
        return lives;
    }

    public int getRupees() {
        return rupees;
    }

    public int getScore() {
        return score;
    }

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public void addRupees(int amount) {
        if (amount > 0) {
            rupees += amount;
        }
    }

    public void addScore(int points) {
        if (points > 0) {
            score += points;
        }
    }
}
