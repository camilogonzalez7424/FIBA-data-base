package collections.RedBlack;

import java.io.Serializable;
import java.util.ArrayList;

public class RedAndBlackTree<K extends Comparable<K>, V> implements ActionRedAndBlack<K, V>, Serializable {
	private static final long serialVersionUID = 324532;

	private RedAndBlackNode<K, V> redBlack = new RedAndBlackNode<>();

	private RedAndBlackNode<K, V> root = redBlack;

	// Constructor
	public RedAndBlackTree() {
		root.setParent(redBlack);
		root.setRight(redBlack);
		root.setLeft(redBlack);
	}

	@Override
	public void insert(K k, V v) {
		insert(new RedAndBlackNode<K, V>(k, v));

	}

	private void insert(RedAndBlackNode<K, V> z) {

		RedAndBlackNode<K, V> y = redBlack;
		RedAndBlackNode<K, V> x = root;

		while (!isRedBlack(x)) {
			y = x;

			if (z.getKey().compareTo(x.getKey()) < 0) {

				x.setNumLeft(x.getNumLeft() + 1);
				x = x.getLeft();
			}

			else {

				x.setNumRight(x.getNumRight() + 1);
				x = x.getRight();
			}
		}

		z.setParent(y);

		if (isRedBlack(y))
			root = z;
		else if (z.getKey().compareTo(y.getKey()) < 0)
			y.setLeft(z);
		else
			y.setRight(z);

		z.setLeft(redBlack);
		z.setRight(redBlack);
		z.setColor(1);

		insertRepair(z);
	}

	@Override
	public void insertRepair(RedAndBlackNode<K, V> a) {

		RedAndBlackNode<K, V> y = redBlack;

		while (a.getParent().getColor() == 1) {

			if (a.getParent() == a.getParent().getParent().getLeft()) {

				y = a.getParent().getParent().getRight();

				if (y.getColor() == 1) {
					a.getParent().setColor(0);
					y.setColor(0);
					a.getParent().getParent().setColor(1);
					a = a.getParent().getParent();
				}

				else if (a == a.getParent().getParent().getRight()) {
					a = a.getParent();
					leftRotate(a);
				}

				else {
					a.getParent().setColor(0);
					a.getParent().getParent().setColor(1);
					rightRotate(a.getParent().getParent());
				}
			}

			else {

				y = a.getParent().getParent().getLeft();

				if (y.getColor() == 1) {

					a.getParent().setColor(0);
					y.setColor(0);
					a.getParent().getParent().setColor(1);
					a = a.getParent().getParent();
				}

				else if (a == a.getParent().getLeft()) {

					a = a.getParent();
					rightRotate(a);
				}

				else {

					a.getParent().setColor(0);

					a.getParent().getParent().setColor(1);
					leftRotate(a.getParent().getParent());
				}
			}
		}

		root.setColor(0);

	}

	@Override
	public boolean remove(K k) {
		RedAndBlackNode<K, V> a = searchNode(k);
		if (a == null) {
			return false;
		} else {
			remove(a);
			return true;
		}
	}

	public void remove(RedAndBlackNode<K, V> v) {

		RedAndBlackNode<K, V> z = searchNode(v.getKey());

		RedAndBlackNode<K, V> x = redBlack;
		RedAndBlackNode<K, V> y = redBlack;

		if (isRedBlack(z.getLeft()) || isRedBlack(z.getRight()))
			y = z;

		else
			y = treeSuccessor(z);

		if (!isRedBlack(y.getLeft()))
			x = y.getLeft();
		else
			x = y.getRight();

		x.setParent(y.getParent());

		if (isRedBlack(y.getParent()))
			root = x;

		else if (!isRedBlack(y.getParent().getLeft()) && y.getParent().getLeft() == y)
			y.getParent().setLeft(x);

		else if (!isRedBlack(y.getParent().getRight()) && y.getParent().getRight() == y)
			y.getParent().setRight(x);

		if (y != z) {
			z.setKey(y.getKey());
		}

		fixNodeData(x, y);

		if (y.getColor() == 0)
			removeRepair(x);
	}

	@Override
	public void removeRepair(RedAndBlackNode<K, V> a) {

		RedAndBlackNode<K, V> temp;

		while (a != root && a.getColor() == 0) {

			if (a == a.getParent().getLeft()) {

				temp = a.getParent().getRight();

				if (temp.getColor() == 1) {
					temp.setColor(0);
					a.getParent().setColor(1);
					leftRotate(a.getParent());
					temp = a.getParent().getRight();
				}

				if (temp.getLeft().getColor() == 0 && temp.getRight().getColor() == 0) {
					temp.setColor(1);
					a = a.getParent();
				}

				else {

					if (temp.getRight().getColor() == 0) {
						temp.getLeft().setColor(0);
						temp.setColor(1);
						rightRotate(temp);
						temp = a.getParent().getRight();
					}

					temp.setColor(a.getParent().getColor());
					a.getParent().setColor(0);
					temp.getRight().setColor(0);
					leftRotate(a.getParent());
					a = root;
				}
			}

			else {
				temp = a.getParent().getLeft();

				if (temp.getColor() == 1) {
					temp.setColor(0);
					a.getParent().setColor(1);
					rightRotate(a.getParent());
					temp = a.getParent().getLeft();
				}

				if (temp.getRight().getColor() == 0 && temp.getLeft().getColor() == 0) {
					temp.setColor(1);
					a = a.getParent();
				}

				else {

					if (temp.getLeft().getColor() == 0) {
						temp.getRight().setColor(0);
						temp.setColor(1);
						leftRotate(temp);
						temp = a.getParent().getLeft();
					}

					temp.setColor(a.getParent().getColor());
					a.getParent().setColor(0);
					temp.getLeft().setColor(0);
					rightRotate(a.getParent());
					a = root;
				}
			}
		}
		a.setColor(0);

	}

	@Override
	public void rightRotate(RedAndBlackNode<K, V> a) {

		rightRotateRepair(a);

		RedAndBlackNode<K, V> x = a.getLeft();
		a.setLeft(x.getRight());

		if (!isRedBlack(x.getRight()))
			a.getRight().setParent(a);

		x.setParent(a.getParent());

		if (isRedBlack(a.getParent()))
			root = x;

		else if (a.getParent().getRight() == a)
			a.getParent().setRight(x);

		else
			a.getParent().setLeft(x);
		x.setRight(a);

		a.setParent(x);

	}

	@Override
	public void rightRotateRepair(RedAndBlackNode<K, V> a) {

		if (isRedBlack(a.getRight()) && isRedBlack(a.getLeft().getRight())) {
			a.setNumRight(0);
			a.setNumLeft(0);
			a.getLeft().setNumRight(1);
		}

		else if (isRedBlack(a.getRight()) && !isRedBlack(a.getLeft().getRight())) {
			a.setNumRight(0);

			a.setNumLeft(1 + a.getLeft().getRight().getNumRight() + a.getLeft().getRight().getNumLeft());

			a.getLeft().setNumRight(2 + a.getLeft().getRight().getNumRight() + a.getLeft().getRight().getNumLeft());
		}

		else if (!isRedBlack(a.getRight()) && isRedBlack(a.getLeft().getRight())) {

			a.setNumLeft(0);

			a.getLeft().setNumRight(2 + a.getRight().getNumRight() + a.getRight().getNumLeft());

		}

		else {

			a.setNumLeft(1 + a.getLeft().getRight().getNumRight() + a.getLeft().getRight().getNumLeft());

			a.getLeft().setNumRight(3 + a.getRight().getNumRight() + a.getRight().getNumLeft()
					+ a.getLeft().getRight().getNumRight() + a.getLeft().getRight().getNumLeft());
		}

	}

	@Override
	public void leftRotate(RedAndBlackNode<K, V> a) {

		leftRotateRepair(a);

		RedAndBlackNode<K, V> b;
		b = a.getRight();
		a.setRight(b.getLeft());

		if (isRedBlack(a.getParent()))
			root = b;

		else if (a.getParent().getLeft() == a)
			a.getParent().setLeft(b);

		else
			a.getParent().setRight(b);

		b.setLeft(a);
		a.setParent(b);

	}

	@Override
	public void leftRotateRepair(RedAndBlackNode<K, V> a) {

		if (isRedBlack(a.getLeft()) && isRedBlack(a.getRight().getLeft())) {

			a.setNumLeft(0);
			a.setNumRight(0);
			a.getRight().setNumLeft(1);
		}

		else if (isRedBlack(a.getLeft()) && !isRedBlack(a.getRight().getLeft())) {

			a.setNumLeft(0);
			a.setNumRight(1 + a.getRight().getLeft().getNumLeft() + a.getRight().getLeft().getNumRight());
			a.getRight().setNumLeft(2 + a.getRight().getLeft().getNumLeft() + a.getRight().getLeft().getNumRight());

		}

		else if (!isRedBlack(a.getLeft()) && isRedBlack(a.getRight().getLeft())) {

			a.setNumRight(0);
			a.getRight().setNumLeft(2 + a.getLeft().getNumLeft() + a.getLeft().getNumRight());

		}

		else {
			a.setNumRight(1 + a.getRight().getLeft().getNumLeft() + a.getRight().getLeft().getNumRight());
			a.getRight().setNumLeft(3 + a.getLeft().getNumLeft() + a.getLeft().getNumRight()
					+ a.getRight().getLeft().getNumLeft() + a.getRight().getLeft().getNumRight());

		}
	}

	@Override
	public void fixNodeData(RedAndBlackNode<K, V> a, RedAndBlackNode<K, V> b) {
		RedAndBlackNode<K, V> current = redBlack;
		RedAndBlackNode<K, V> track = redBlack;

		if (isRedBlack(a)) {
			current = b.getParent();
			track = b;
		}

		else {
			current = a.getParent();
			track = a;
		}

		while (!isRedBlack(current)) {

			if (b.getKey() != current.getKey()) {

				if (b.getKey().compareTo(current.getKey()) > 0)
					current.setNumRight(current.getNumRight() - 1);

				if (b.getKey().compareTo(current.getKey()) < 0)
					current.setNumLeft(current.getNumLeft() - 1);
			}

			else {

				if (isRedBlack(current.getLeft()))
					current.setNumLeft(current.getNumLeft() - 1);
				else if (isRedBlack(current.getRight()))
					current.setNumRight(current.getNumRight() - 1);

				else if (track == current.getRight())
					current.setNumRight(current.getNumRight() - 1);
				else if (track == current.getLeft())
					current.setNumLeft(current.getNumLeft() - 1);
			}

			track = current;
			current = current.getParent();

		}

	}

	public RedAndBlackNode<K, V> searchNode(K key) {
		RedAndBlackNode<K, V> current = root;

		while (!isRedBlack(current)) {

			if (current.getKey().equals(key))

				return current;

			else if (current.getKey().compareTo(key) < 0)
				current = current.getRight();

			else
				current = current.getLeft();
		}

		return null;

	}

	public V searchValue(K key) {
		RedAndBlackNode<K, V> a = searchNode(key);
		if (a == null) {
			return null;
		} else {
			return a.getValue();
		}
	}


	@Override
	public ArrayList<V> search(K key) {
		ArrayList<V> result = new ArrayList<>();
		search(root, result, key);
		//result.add(searchValue(key));

		return result;

		
	}

	private void search(RedAndBlackNode<K, V> root, ArrayList<V> list, K key) {
		if(root != null) {
			search(root.getLeft(), list, key);
			if(root.getKey() == key){
				list.add(root.getValue());
			}
			search(root.getRight(), list, key);
		}


	}



/*
	public void inOrderPrint() {
		inOrderRec(root);
	}

	private void inOrderRec(RedAndBlackNode<K, V> root) {
		if (root != null) {
			inOrderRec(root.getLeft());
			System.out.println(root.getValue());
			inOrderRec(root.getRight());
		}
	}*/

	public RedAndBlackNode<K, V> treeMinimum(RedAndBlackNode<K, V> node) {

		while (!isRedBlack(node.getLeft()))
			node = node.getLeft();
		return node;
	}

	public RedAndBlackNode<K, V> treeSuccessor(RedAndBlackNode<K, V> x) {

		if (!isRedBlack(x.getLeft()))
			return treeMinimum(x.getRight());

		RedAndBlackNode<K, V> y = x.getParent();

		while (!isRedBlack(y) && x == y.getRight()) {

			x = y;
			y = y.getParent();
		}

		return y;
	}

	public int numGreater(K key) {
		return findNumGreater(root, key);
	}

	public int numSmaller(K key) {
		return findNumSmaller(root, key);
	}

	public int findNumGreater(RedAndBlackNode<K, V> node, K key) {
		if (isRedBlack(node)) {
			return 0;
		} else if (key.compareTo(node.getKey()) < 0) {
			return 1 + node.getNumRight() + findNumGreater(node.getLeft(), key);
		} else {
			return findNumGreater(node.getRight(), key);
		}
	}

	public int findNumSmaller(RedAndBlackNode<K, V> node, K key) {
		if (isRedBlack(node)) {
			return 0;
		} else if (key.compareTo(node.getKey()) <= 0) {
			return findNumSmaller(node.getLeft(), key);
		} else {
			return 1 + node.getNumLeft() + findNumSmaller(node.getRight(), key);
		}
	}

	private boolean isRedBlack(RedAndBlackNode<K, V> node) {
		return node == redBlack;
	}

	public boolean keyExists(K k) {
		if (search(k) == null) {
			return false;
		} else {
			return true;
		}
	}

	public int size() {
		if (!isRedBlack(root)) {
			return root.getNumLeft() + root.getNumRight() + 1;
		} else {
			return 0;
		}
	}

	// _______________Getters and Setters_______________

	public RedAndBlackNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(RedAndBlackNode<K, V> root) {
		this.root = root;
	}

}
