package collections.AVL;

import java.util.ArrayList;

public interface ActionAVL<K extends Comparable<K>,V> {
	public boolean add(K k, V v);
	public boolean remove(K k);
	public ArrayList<V> search(K key);
	public boolean isEmpty();
	public int size();
	public boolean keyExists(K k);
}