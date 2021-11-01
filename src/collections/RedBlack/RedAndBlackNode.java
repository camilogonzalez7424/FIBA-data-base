package collections.RedBlack;

import model.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class RedAndBlackNode <K extends Comparable<K>, V> implements Serializable {

	private static final long serialVersionUID = 400003;
/*
    private static final int BLACK = 0; // The colors are constant
	private static final int RED = 1;
	
	//Crear un enum para los colores, investigar más 

	
	private K key;
	private V value;
	private int color;
	
	private RedAndBlackNode<K, V> parent;
	private RedAndBlackNode<K, V> left;
	private RedAndBlackNode<K, V> right;
	
	private int numLeft;
	private int numRight;
	
	RedAndBlackNode(){
        color = BLACK; //El arbol siempre tiene raiz negra
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }
	
	RedAndBlackNode(K key,V value){
        this();
        this.key = key;
        this.value = value;
	}

//_______________Getters and Setters_______________

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public RedAndBlackNode<K, V> getParent() {
		return parent;
	}

	public void setParent(RedAndBlackNode<K, V> parent) {
		this.parent = parent;
	}

	public RedAndBlackNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(RedAndBlackNode<K, V> left) {
		this.left = left;
	}

	public RedAndBlackNode<K, V> getRight() {
		return right;
	}

	public void setRight(RedAndBlackNode<K, V> right) {
		this.right = right;
	}

	public int getNumLeft() {
		return numLeft;
	}

	public void setNumLeft(int numLeft) {
		this.numLeft = numLeft;
	}

	public int getNumRight() {
		return numRight;
	}

	public void setNumRight(int numRight) {
		this.numRight = numRight;
	}

	//Jamás se usa pero evita Warnings XD
	public int getColorRed(){
		return RED;
	}*/

	public Color color;
	public K key;
	public V val;
	public RedAndBlackNode<K, V> parent;
	public RedAndBlackNode<K, V> left;
	public RedAndBlackNode<K, V> right;
	private ArrayList<Player> samePlayers;

	public RedAndBlackNode(){
		// set RED as default
		this.color = Color.RED;
		this.key = null;
		this.val = null;
		this.left = null;
		this.right = null;
		this.samePlayers = new ArrayList<Player>();
	}
	public RedAndBlackNode(Color color, K key, V val) {
		this.color = color;
		this.key = key;
		this.val = val;
		this.left = null;
		this.right = null;
		this.samePlayers = new ArrayList<Player>();
	}

	public ArrayList<Player> getPlayers(){
		return samePlayers;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}

	public RedAndBlackNode<K, V> getParent() {
		return parent;
	}

	public void setParent(RedAndBlackNode<K, V> parent) {
		this.parent = parent;
	}

	public RedAndBlackNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(RedAndBlackNode<K, V> left) {
		this.left = left;
	}

	public RedAndBlackNode<K, V> getRight() {
		return right;
	}

	public void setRight(RedAndBlackNode<K, V> right) {
		this.right = right;
	}
}



