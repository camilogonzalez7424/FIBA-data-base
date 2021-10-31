package model;

import java.io.Serializable;
import java.util.ArrayList;

import collections.ABB.ABB;
import collections.AVL.AVLTree;
import collections.RedBlack.RedAndBlackTree;

public class Query implements Serializable {

    private static final long serialVersionUID = 43564389;
    
    private queryListener listener;

    public Query(){}

    public void searchABB(ABB<Integer,Player> tree, int key ){
       ArrayList<Player> result = new ArrayList<>();
       result = tree.search(key);
       listener.onResult(result);
    }

    public void searchAVL(AVLTree<Integer, Player> tree, int key) {
        ArrayList<Player> result = new ArrayList<>();
        result = tree.search(key);
        listener.onResult(result);
    }

    public void searchRB(RedAndBlackTree<Integer, Player> tree, int key) {
        ArrayList<Player> result = tree.search(key);
        listener.onResult(result);
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
        public void onResult(ArrayList<Player> result);
    }

    public queryListener getListener() {
        return listener;
    }

    public void setListener(queryListener listener) {
        this.listener = listener;
    }

   

}
