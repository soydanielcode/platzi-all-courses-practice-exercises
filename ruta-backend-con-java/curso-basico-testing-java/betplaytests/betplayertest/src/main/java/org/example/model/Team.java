package org.example.model;

public class Team {
    private int id;
    private String name;
    private int victories;
    private int defeat;
    private int equals;
    private double avgGames;
    private double avgGoals;
    private int goalsWins;
    private int goalsDefeat;

    public void updateGames(ResultGame result){
        if(result.equals(ResultGame.WIN)) victories++;
        if(result.equals(ResultGame.LOSS)) defeat++;
        if(result.equals(ResultGame.EQUALS)) equals++;
    }

    public void updateGoals(int goalsWins, int goalsDefeat){
        this.goalsWins += goalsWins;
        this.goalsDefeat += goalsDefeat;
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

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public int getEquals() {
        return equals;
    }

    public void setEquals(int equals) {
        this.equals = equals;
    }

    public double getAvgGames() {
        return avgGames;
    }

    public void setAvgGames(double avgGames) {
        this.avgGames = avgGames;
    }

    public double getAvgGoals() {
        return avgGoals;
    }

    public void setAvgGoals(double avgGoals) {
        this.avgGoals = avgGoals;
    }

    public int getGoalsWins() {
        return goalsWins;
    }

    public void setGoalsWins(int goalsWins) {
        this.goalsWins = goalsWins;
    }

    public int getGoalsDefeat() {
        return goalsDefeat;
    }

    public void setGoalsDefeat(int goalsDefeat) {
        this.goalsDefeat = goalsDefeat;
    }
}
