package br.com.game.match;

public class Player {
    private int score;
    private String name;

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
