package collections.ABB;

import java.io.Serializable;
import java.util.ArrayList;

public class ABB<K extends Comparable<K>, V> implements ActionABB<K, V>, Serializable {
    private static final long serialVersionUID = 456543;

    private NodeABB<K, V> root;

    public void BTS() {
        root = null;
    }

    @Override
    public void insert(K key, V value) {
        
        root = insert(root, key, value);
    }

    private NodeABB<K, V> insert(NodeABB<K, V> current, K key, V value) {

        if (current == null) {
            current = new NodeABB<>(key, value);
            return current;
        }

        if (key.compareTo(current.getKey()) <= 0) {
            current.setLeft(insert(current.getLeft(), key, value));

        } else if (key.compareTo(current.getKey()) > 0) {
            current.setRight(insert(current.getRight(), key, value));
        }

        return current;
    }

    /* private NodeABB<K, V> add(NodeABB<K, V> newNode) {
        NodeABB<K, V> aux = null;
        NodeABB<K, V> temp = root;

        while (temp != null) {
            // Ancestor
            aux = temp;
            if (newNode.getKey().compareTo(temp.getKey()) <= 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        if (aux == null) {
            root = newNode;
        } else if (newNode.getKey().compareTo(aux.getKey()) <= 0) {
            aux.setLeft(newNode);
        } else {
            aux.setRight(newNode);
        }
        return aux;
    } */

    @Override
    public ArrayList<V> search(K key) {
        ArrayList<V> result = new ArrayList<>();
        
        search(root, result, key);
        return result;
    }

    private void search(NodeABB<K, V> current, ArrayList<V> list, K key) {
        if (current != null) {
            search(current.getLeft(), list, key);
            if (current.getKey().equals(key)) {
                list.add(current.getValue());
            }
            search(current.getRight(), list, key);
        }
    }

    @Override
    public void inOrderPrint() {
        inOrderRec(root);
    }

    private void inOrderRec(NodeABB<K, V> root) {
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

    NodeABB<K, V> deleteRec(NodeABB<K, V> root, K key) {
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

    private NodeABB<K, V> minValue(NodeABB<K, V> root) {
        NodeABB<K, V> min = root;
        while (root.getLeft() != null) {
            min = root.getLeft();
            root = root.getLeft();
        }
        return min;
    }
}
