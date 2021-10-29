package collections.RedBlack;

import java.util.ArrayList;

public interface ActionRedAndBlack<K extends Comparable<K>, V> {
    public void insert(K k, V v);
	public void insertRepair(RedAndBlackNode<K,V> a);
	public boolean remove(K k);
	public void removeRepair(RedAndBlackNode<K,V> a);
    public void rightRotate(RedAndBlackNode<K,V> a);
	public void rightRotateRepair(RedAndBlackNode<K,V> a);
    public void leftRotate(RedAndBlackNode<K,V> a);
	public void leftRotateRepair(RedAndBlackNode<K,V> a);
	public void fixNodeData(RedAndBlackNode<K,V> a, RedAndBlackNode<K,V> b);
	//public RedAndBlackNode<K,V> search(K key); //Return ArrayList
	public ArrayList<V> search(K key); //Return ArrayList
}

