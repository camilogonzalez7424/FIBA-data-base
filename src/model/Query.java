package model;

import java.util.ArrayList;

import collections.ABB.ABB;
import collections.AVL.AVLTree;
import collections.RedBlack.RedAndBlackTree;

public class Query {

    private queryListener listener;

    public Query(){}

    public void searchABB(ABB<Integer,Player> tree, int key ){
       ArrayList<Player> result = tree.search(key);
        listener.onResult(result);
    }

    public void searchAVL(AVLTree<Integer, Player> tree, int key) {
        ArrayList<Player> result = tree.search(key);
        listener.onResult(result);
    }

    public void searchRB(RedAndBlackTree<Integer, Player> tree, int key) {
    }

    public void searchByName(String key, ArrayList<Player> list){
        ArrayList<Player> result = new ArrayList<>();
        for (Player player : list) {
            if(player.getName().equals(key)){
                result.add(player);
            }
        }
        listener.onResult(result);
    }

    public void searchByTeam(String key, ArrayList<Player> list){
        ArrayList<Player> result = new ArrayList<>();
        for (Player player : list) {
            if(player.getTeam().equals(key)){
                result.add(player);
            }
        }
        listener.onResult(result);
    }

    public void searchByAge(int key, ArrayList<Player> list){
        ArrayList<Player> result = new ArrayList<>();
        for (Player player : list) {
            if(player.getAge() == key){
                result.add(player);
            }
        }
        listener.onResult(result);
    }

    public void searchByGames(int key, ArrayList<Player> list){
        ArrayList<Player> result = new ArrayList<>();
        for (Player player : list) {
            if(player.getGames() == key){
                result.add(player);
            }
        }
        listener.onResult(result);
    }
    
    

    public interface queryListener  {
        public <K extends Comparable<K>,V> void onResult(ArrayList<V> result);
    }

}
