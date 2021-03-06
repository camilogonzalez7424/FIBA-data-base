package model;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

public class Player implements Serializable {

    private static final long serialVersionUID = 00003;

    @CsvBindByName
    private String name;
    @CsvBindByName
    private String team;
    @CsvBindByName
    private int age;

    @CsvBindByName
    private int assists;
    @CsvBindByName
    private int steals;
    @CsvBindByName
    private int rebounds;
    @CsvBindByName
    private int points;
    @CsvBindByName
    private int games;

    public Player(String name, int age, String team, int points, int rebounds, int assists, int steals, int games) {

        this.name = name;
        this.team = team;
        this.age = age;
        this.assists = assists;
        this.steals = steals;
        this.rebounds = rebounds;
        this.points = points;
        this.games = games;
    }

    // _______________Getters and Setters_______________

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGames() {
        return games;
    }

    public void setBlock(int games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + team + "," + points + ","
                + rebounds + "," + assists + "," + steals + "," + games;
    }

    // String name, int age, String team, int points, int rebounds, int assists, int
    // steals, int games

}
