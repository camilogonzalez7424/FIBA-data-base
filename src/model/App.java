package model;

import java.util.ArrayList;

import collections.ABB.ABB;
import collections.AVL.AVLTree;
import collections.RedBlack.RedAndBlackTree;

public class App {

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

    public App() {
    }

    public void ABBSearch(int key, ABB<Integer, Player> tree) {
        query = new Query();
        query.searchABB(tree, key);
    }

    public void AVLSearch(int key, AVLTree<Integer, Player> tree) {
        query = new Query();
        query.searchAVL(tree, key);
    }

    public void linearSearch(String key, String searchBy) {
        query = new Query();

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

    
    
}
