package collections.ABB;

import java.io.Serializable;
import java.util.ArrayList;

public class ABB<K extends Comparable<K>, V> implements ActionABB<K,V>, Serializable{
    private static final long serialVersionUID = 456543;
    
    private NodeABB<K, V> root;

    public void BTS() {
        root = null;
    }

    @Override
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private NodeABB<K, V> insert(NodeABB<K, V> root, K key, V value) {

        if (root == null) {
            root = new NodeABB<>(key, value);
            return root;
        }

        if (key.compareTo(root.getKey()) < 0)
            root.setLeft(insert(root.getLeft(), key, value));
        else if (key.compareTo(root.getKey()) > 0)
            root.setRight(insert(root.getRight(), key, value));

        return root;
    }

    @Override
    /* public V search(K key){
        return search(root, key).getValue();
    }

    public NodeABB<K, V> search(NodeABB<K, V> root, K key) {

        if (root == null || root.getKey().equals(key))
            return root;

        if (root.getKey().compareTo(key) < 0)
            return search(root.getRight(), key);

        return search(root.getLeft(), key);
    } */
    public ArrayList<V> search(K key){
        ArrayList<V> result = new ArrayList<>();
        search(root, result, key);
        return result;
    }

    private void search(NodeABB<K, V> root,ArrayList<V> list, K key ){
        if (root != null) {
            search(root.getLeft(), list, key);
            if(root.getKey().equals(key)){
                list.add(root.getValue());
            }
            search(root.getRight(), list, key);
        }
    }

    @Override
    public void inOrderPrint()
    {
         inOrderRec(root);
    }
 
    private void inOrderRec(NodeABB<K, V> root)
    {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.println(root.getValue());
            inOrderRec(root.getRight());
        }
    }

    @Override
    public void delete(K key) {
        root = deleteRec(root, key);
    }

    NodeABB<K, V> deleteRec(NodeABB<K, V> root, K key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key.compareTo(root.getKey()) < 0)
            root.setLeft(deleteRec(root.getLeft(), key));
        else if (key.compareTo(root.getKey()) > 0)
            root.setRight(deleteRec(root.getRight(), key));
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            K tempK = minValue(root.getRight()).getKey();
            V tempV = minValue(root.getRight()).getValue();
            root.setKey(tempK);
            root.setValue(tempV);
 
            // Delete the inorder successor
            root.setRight(deleteRec(root.getRight(), root.getKey()));
        }
 
        return root;
    }

    private NodeABB<K, V>  minValue(NodeABB<K, V> root)
    {
        NodeABB<K, V>  min = root;
        while (root.getLeft() != null)
        {
            min = root.getLeft();
            root = root.getLeft();
        }
        return min;
    }
}
