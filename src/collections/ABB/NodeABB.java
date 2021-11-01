package collections.ABB;

import java.io.Serializable;

public class NodeABB<K, V> implements Serializable {
    private static final long serialVersionUID = 56716007;
    private K key;
    private V value;
    private NodeABB<K, V> left, right, parent;

    public NodeABB(K key, V value) {
        this.key = key;
        this.value = value;
        left = right = null;
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

    public NodeABB<K, V> getLeft() {
        return left;
    }

    public void setLeft(NodeABB<K, V> left) {
        this.left = left;
    }

    public NodeABB<K, V> getRight() {
        return right;
    }

    public void setRight(NodeABB<K, V> right) {
        this.right = right;
    }

    public NodeABB<K, V> getParent() {
        return parent;
    }

    public void setParent(NodeABB<K, V> parent) {
        this.parent = parent;
    }

}
