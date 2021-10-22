package collections.AVL;

public interface ActionAVL<K extends Comparable<K>,V> {
	public boolean add(K k, V v);
	public boolean remove(K k);
	public AVLTreeNode<K,V> searchNode(K k);
	public V search(K k);
	public boolean isEmpty();
	public int size();
	public boolean keyExists(K k);
}