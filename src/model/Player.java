package model;

public class Player {

    private long storePos;

    private String name;
    private String team;

    private int age;
    private int assists;
    private int steals;
    private int rebounds;
    private int points;
    private int block;

    public Player(long storePos, String name, String team, int age, int assists, int steals, int rebounds, int points, int block) {
        
        this.storePos   = storePos;
        this.name       = name;
        this.team       = team;
        this.age        = age;
        this.assists    = assists;
        this.steals     = steals;
        this.rebounds   = rebounds;
        this.points     = points;
        this.block      = block;
    }

    public long getStorePos() {
        return storePos;
    }

    public void setStorePos(long storePos) {
        this.storePos = storePos;
    }

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

    public int getBlock(){
        return block;
    }

    public void setBlock(int block){
        this.block = block;
    }
    
}
