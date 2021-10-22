package model;

public class Player {

    private String name;
    private String team;
    private int age;
   
    private int assists;
    private int steals;
    private int rebounds;
    private int points;
    private int games;
   

    public Player(String name, String team, int age, int assists, int steals, int rebounds, int points, int games) {
        
        this.name       = name;
        this.team       = team;
        this.age        = age;
        this.assists    = assists;
        this.steals     = steals;
        this.rebounds   = rebounds;
        this.points     = points;
        this.games      = games;
    }

//_______________Getters and Setters_______________

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

    public int getGames(){
        return games;
    }

    public void setBlock(int games){
        this.games = games;
    }
    
}
