package collections.RedBlack;

import java.util.ArrayList;

public interface ActionRedAndBlack<K extends Comparable<K>, V> {
	public RedAndBlackNode<K,V> insert(K k, V v);
	public ArrayList<V> search(K key); //Return ArrayList*/
}

