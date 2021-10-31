package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;

import com.opencsv.CSVWriter;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import collections.ABB.ABB;
import collections.AVL.AVLTree;
import collections.RedBlack.RedAndBlackTree;

public class App implements Serializable {

    private static final long serialVersionUID = 1241302341;

    private ArrayList<Player> players;

    private ABB<Integer, Player> pointsABB;
    private ABB<Integer, Player> assistsABB;
    private ABB<Integer, Player> reboundsABB;
    private ABB<Integer, Player> stealsABB;

    private RedAndBlackTree<Integer, Player> pointsRB;
    private AVLTree<Integer, Player> assistsAVL;
    private AVLTree<Integer, Player> reboundsAVL;
    private AVLTree<Integer, Player> stealsAVL;

    private boolean added;

    public final static String FILE_NAME = "data/db.fiba";

    public App() {

        added = false;

        players = new ArrayList<>();

        pointsABB = new ABB<>();
        assistsABB = new ABB<>();
        reboundsABB = new ABB<>();
        stealsABB = new ABB<>();

        pointsRB = new RedAndBlackTree<>();
        assistsAVL = new AVLTree<>();
        reboundsAVL = new AVLTree<>();
        stealsAVL = new AVLTree<>();
    }

    public void ABBSearch(int key, ABB<Integer, Player> tree, Query.queryListener listener) {
        Query query = new Query();
        query.setListener(listener);
        query.searchABB(tree, key);
    }

    public void AVLSearch(int key, AVLTree<Integer, Player> tree, Query.queryListener listener) {
        Query query = new Query();
        query.setListener(listener);
        query.searchAVL(tree, key);
    }

    public void RBSearch(int key, RedAndBlackTree<Integer, Player> tree, Query.queryListener listener) {
        Query query = new Query();
        query.setListener(listener);
        query.searchRB(tree, key);
    }

    public void linearSearch(String key, String searchBy, Query.queryListener listener) {
        Query query = new Query();
        query.setListener(listener);
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
    public void importPlayers(String path, Import.listener listener) throws FileNotFoundException, IOException {
        Import im = new Import(this);
        im.setListener(listener);
        im.importPlayer(path, players);
    }

    // ------------------------------------ Serialization

    public void update(File file) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        CSVWriter writer = new CSVWriter(new FileWriter(file), ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, "\n");
       
        for (Player player : players) {
            String[] row = player.toString().split(",");
            writer.writeNext(row);
        }

        writer.close();
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

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public void addPlayer(Player temp) throws IOException {
        players.add(temp);
        pointsABB.insert(temp.getPoints(), temp);
        pointsRB.insert(temp.getPoints(), temp);

        assistsABB.insert(temp.getAssists(), temp);
        assistsAVL.add(temp.getAssists(), temp);

        reboundsABB.insert(temp.getRebounds(), temp);
        reboundsAVL.add(temp.getRebounds(), temp);

        stealsABB.insert(temp.getSteals(), temp);
        stealsAVL.add(temp.getSteals(), temp);

        added = true;

    }

    public void clean() throws IOException {
        added = true;

        players = new ArrayList<>();

        pointsABB = new ABB<>();
        assistsABB = new ABB<>();
        reboundsABB = new ABB<>();
        stealsABB = new ABB<>();

        pointsRB = new RedAndBlackTree<>();
        assistsAVL = new AVLTree<>();
        reboundsAVL = new AVLTree<>();
        stealsAVL = new AVLTree<>();
    }

}
