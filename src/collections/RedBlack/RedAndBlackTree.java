package collections.RedBlack;

import java.io.Serializable;
import java.util.ArrayList;


public class RedAndBlackTree<K extends Comparable<K>, V> implements ActionRedAndBlack<K, V>, Serializable {
	private static final long serialVersionUID = 324532;

	//____________________________________

	public RedAndBlackNode<K, V> root;

	public void leftRotate(RedAndBlackNode<K, V> x) { // left rotate x

		RedAndBlackNode<K, V> y = x.right;
		x.right = y.left;
		if(y.left != null)y.left.parent = x;
		y.parent = x.parent;
		if (x.parent == null) {
			assert this.root == x;
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	public void rightRotate(RedAndBlackNode<K, V> y) { // right rotate y



		RedAndBlackNode<K, V> x = y.left;

		y.left = x.right;
		if(x.right != null)x.right.parent = y;
		x.parent = y.parent;
		if (y.parent == null) {
			assert this.root == y;
			this.root = x;
		} else if (y == y.parent.right) {
			y.parent.right = x;
		} else {
			y.parent.left = x;
		}

		x.right = y;
		y.parent = x;
	}

	@Override
	public RedAndBlackNode<K,V> insert(K key, V val) {
		if(key == null) return null;
		RedAndBlackNode<K, V> y = null;
		RedAndBlackNode<K, V> x = this.root;
		while (x != null) {
			y = x;

			if (key.compareTo(x.key) == -1) {
				x = x.left;
			} else if (key.compareTo(x.key) == 1) {
				x = x.right;
			} else {

				return  x;
			}
		}

		RedAndBlackNode<K, V> z = new RedAndBlackNode<>(Color.RED, key, val);
		z.parent = y;

		if (y == null) {
			root = z;
		} else if (z.key.compareTo(y.key) == -1) {
			y.left = z;
		} else {

			y.right = z;
		}
		insertFixup(z);
		return z;
	}

	public void insertFixup(RedAndBlackNode<K, V> z) {
		while (z.parent != null && z.parent.parent != null && z.parent.color == Color.RED) {
			if (z.parent == z.parent.parent.left) {

				RedAndBlackNode<K, V> y = z.parent.parent.right;
				if (y != null && y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {

					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					rightRotate(z.parent.parent);
				}
			} else {

				RedAndBlackNode<K, V> y = z.parent.parent.left;
				if (y != null && y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {

					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					leftRotate(z.parent.parent);
				}
			}
		}

		this.root.color = Color.BLACK;
	}


	public RedAndBlackNode<K, V> find(K key){
		RedAndBlackNode<K, V> x = this.root;
		while(x != null){
			if(key.compareTo(x.key) == 0){

				return x;
			}else if(key.compareTo(x.key) == -1){

				x = x.left;
			}else{

				x = x.right;
			}
		}
		return null;
	}

	public V get(K key){
		RedAndBlackNode<K,V> res = find(key);
		if(res == null) return null;
		return res.val;
	}

	public RedAndBlackNode<K, V> getMinimum(RedAndBlackNode<K, V> x){
		if(x == null) return null;
		while(x.left != null) x = x.left;
		return x;
	}

	public RedAndBlackNode<K, V> getSuccessor(RedAndBlackNode<K, V> x){
		if(x == null) return null;
		if(x.right != null){
			return getMinimum(x.right);
		}
		RedAndBlackNode<K, V> y = x.parent;
		while(y != null && x == y.right){
			x = y;
			y = y.parent;
		}
		return y;
	}

	public V delete(K key){
		if(key == null)return null;

		RedAndBlackNode<K, V> z = this.find(key);
		if(z == null){

			return null;
		}

		V removedVal = z.val;
		RedAndBlackNode<K, V> y = null;
		if(z.left == null || z.right == null){
			y = z;
		}else{
			y = getSuccessor(z);
		}
		RedAndBlackNode<K, V> x = null;
		if(y.left != null){
			x = y.left;
		}else{
			x = y.right;
		}
		if(x != null)x.parent = y.parent;

		if(y.parent == null){
			this.root = x;
		}else if(y == y.parent.left){
			y.parent.left = x;
		}else{
			y.parent.right = x;
		}

		if(y != z){
			z.key = y.key;
			z.val = y.val;
		}

		if(y.color == Color.BLACK){
			deleteFixup(x);
		}
		return removedVal;
	}

	public void deleteFixup(RedAndBlackNode<K, V> x){
		if(x == null) return;
		RedAndBlackNode<K, V> w = null;
		while(x != this.root && x.color == Color.BLACK){
			if(x == x.parent.left){
				w = x.parent.right;
				if(w.color == Color.RED){
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if((w.left == null || w.left.color == Color.BLACK) && (w.right == null || w.right.color == Color.BLACK)){
					w.color = Color.RED;
					x = x.parent;
				}else if(w.right == null || w.right.color == Color.BLACK){
					w.left.color = Color.BLACK;
					w.color = Color.RED;
					rightRotate(w);
					w = x.parent.right;
					x.parent.color = Color.BLACK;
					if(w.right != null)w.right.color = Color.BLACK;
					leftRotate(x.parent);
					x = this.root;
				}
			}else{
				w = x.parent.left;
				if(w.color == Color.RED){
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if((w.right == null ||w.right.color == Color.BLACK) && (w.left == null || w.left.color == Color.BLACK)){
					w.color = Color.RED;
					x = x.parent;
				}else if(w.left == null || w.left.color == Color.BLACK){
					w.right.color = Color.BLACK;
					w.color = Color.RED;
					leftRotate(w);
					w = x.parent.left;
					x.parent.color = Color.BLACK;
					if(w.left != null)w.left.color = Color.BLACK;
					rightRotate(x.parent);
					x = this.root;
				}
			}
		}
		x.color = Color.BLACK;
	}


	@Override
	public ArrayList<V> search(K key) {
		ArrayList<V> result = new ArrayList<>();
		RedAndBlackNode<K,V> head = find(key);

		result = getList(head, result, key);
		return result;
	}

	private ArrayList<V> getList(RedAndBlackNode<K,V> head, ArrayList<V> list, K key){
		while (head != null && head.getKey().equals(key)) {
			list.add(head.getVal());
			head = head.getLeft();
		}
		return list;
	}

	private void search(RedAndBlackNode<K,V> root, ArrayList<V> list, K key) {
		if (root != null) {
			search(root.getLeft(), list, key);
			search(root.getRight(), list, key);
			if(root.getKey().equals(key)) {
				list.add(root.getVal());
			}


		}

	}

}
