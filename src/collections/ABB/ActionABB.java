package collections.ABB;

import java.util.ArrayList;

public interface ActionABB<K,V> {
    public ArrayList<V> search(K key);
    public void insert(K key, V value);
    public void delete(K key);
    public void inOrderPrint();
    
}
