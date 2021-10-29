package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import collections.ABB.ABB;
import collections.AVL.AVLTree;
import collections.RedBlack.RedAndBlackTree;

public class App implements Serializable {

    private static final long serialVersionUID = 1241302341;

    private Query query;
    private ArrayList<Player> players;

    private ABB<Integer, Player> pointsABB;
    private ABB<Integer, Player> assistsABB;
    private ABB<Integer, Player> reboundsABB;
    private ABB<Integer, Player> stealsABB;

    private RedAndBlackTree<Integer, Player> pointsRB;
    private AVLTree<Integer, Player> assistsAVL;
    private AVLTree<Integer, Player> reboundsAVL;
    private AVLTree<Integer, Player> stealsAVL;

    private Import im;

    public final static String FILE_NAME = "data/db.fiba";

    public App() {
        players = new ArrayList<>();

        query = new Query();

        pointsABB = new ABB<>();
        assistsABB = new ABB<>();
        reboundsABB = new ABB<>();
        stealsABB = new ABB<>();

        pointsRB = new RedAndBlackTree<>();
        assistsAVL = new AVLTree<>();
        reboundsAVL = new AVLTree<>();
        stealsAVL = new AVLTree<>();

        im = new Import(this);
    }

    public void ABBSearch(int key, ABB<Integer, Player> tree) {
        query.searchABB(tree, key);
    }

    public void AVLSearch(int key, AVLTree<Integer, Player> tree) {
        query.searchAVL(tree, key);
    }

    public void linearSearch(String key, String searchBy) {

        switch (searchBy) {
        case "by name":
            query.searchByName(key, players);
            break;
        case "by age":
            query.searchByAge(Integer.parseInt(key), players);
            break;
        case "by team":
            query.searchByTeam(key, players);
            break;
        case "by games":
            query.searchByGames(Integer.parseInt(key), players);
            break;
        }
    }

    // Import
    public void importPlayers(String path) throws FileNotFoundException, IOException {
        im.importPlayer(path, players);
    }

    // ------------------------------------ Serialization

    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(this);
        oos.close();
    }

    public boolean loadData(App app) throws IOException, ClassNotFoundException {
        File f = new File(FILE_NAME);
        boolean loaded = false;
        if (f.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            app = (App) ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
    }

    // ------------------------------------ Getter and Setters

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ABB<Integer, Player> getPointsABB() {
        return pointsABB;
    }

    public ABB<Integer, Player> getAssistsABB() {
        return assistsABB;
    }

    public ABB<Integer, Player> getReboundsABB() {
        return reboundsABB;
    }

    public ABB<Integer, Player> getStealsABB() {
        return stealsABB;
    }

    public RedAndBlackTree<Integer, Player> getPointsRB() {
        return pointsRB;
    }

    public AVLTree<Integer, Player> getAssistsAVL() {
        return assistsAVL;
    }

    public AVLTree<Integer, Player> getReboundsAVL() {
        return reboundsAVL;
    }

    public AVLTree<Integer, Player> getStealsAVL() {
        return stealsAVL;
    }

    public Query getQuery() {
        return query;
    }

    public void addPlayer(Player temp) {
        players.add(temp);
        pointsABB.insert(temp.getPoints(), temp);
        // pointsRB.insert(temp.getPoints(), temp);

        assistsABB.insert(temp.getAssists(), temp);
        assistsAVL.add(temp.getAssists(), temp);

        reboundsABB.insert(temp.getRebounds(), temp);
        reboundsAVL.add(temp.getRebounds(), temp);

        stealsABB.insert(temp.getSteals(), temp);
        stealsAVL.add(temp.getSteals(), temp);
    }

}
