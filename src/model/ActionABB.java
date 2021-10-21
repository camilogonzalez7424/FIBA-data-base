package model;

public interface ActionABB<K,V> {
    public V search(K key);
    public void insert(K key, V value);
    public void delete(K key);
    public void inOrderPrint();
    
}
