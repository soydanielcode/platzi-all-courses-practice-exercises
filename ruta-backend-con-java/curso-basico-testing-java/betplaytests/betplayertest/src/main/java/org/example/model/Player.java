package org.example.model;

public class Player {

    private int id;
    private String name;
    private Double credits;

    public Player(int id, String name, Double credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public void updateCredits(Double betCredits, Double creditsWins){
        credits = (credits - betCredits) + creditsWins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
