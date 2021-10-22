package collections.AVL;

public class AVLTree<K extends Comparable<K>,V> {

    private AVLTreeNode<K,V> root;
    private int size;


	public boolean add(K k, V v) {
		if (root == null){
			root = new AVLTreeNode<>(k, v, this);
			size++;
			return true;
		}else{
			root.add(k, v);
			root.balance();
			size++;
			return true;
		}
		
	}

	
	public boolean remove(K k) {
		if (root == null) 
        return false;
		else{
			if (root.getKey().equals(k)){
				if (size == 1){
					root = null;
					size--;
					return true;
				}else{
					AVLTreeNode<K, V> aux = root.getSuccesor();
					aux.setLeft(root.getLeft());
					aux.setRight(root.getRight());
					
					if (aux.getLeft() != null) {
						aux.getLeft().setParent(aux);
						aux.setLeftHeight(aux.getLeft().getHeight());
					}
					if (aux.getRight() != null) {
						aux.getRight().setParent(aux);
						aux.setRightHeight(aux.getRight().getHeight());
					}
					
					aux.setParent(null);
					aux.setOwner(this);
					root = aux;
					if (aux.getLeftHeight() > aux.getRightHeight()) 
                    aux.setHeight(aux.getLeftHeight()+1);
					else 
                    aux.setHeight(aux.getRightHeight()+1);
					
					root.balance();
					size--;
						
				}
			}else{
				boolean status = root.remove(k);
				size--;
				if (status ) 
                root.balance();
			}
		}
		return false;
	}

	
	public AVLTreeNode<K, V> searchNode(K k) {
		if (root == null) 
        return null;
		else return 
        root.search(k);
	}
	
    /* Probar, igual se puede utilizar el mismo buscar del BTS, Es más podemos heredar
	public LinkedList<V> searchByRange(K kStart, K kEnd){
		if (root == null) return null;
		else return root.searchByRange(kStart,kEnd);
	}*/

	
	public V search(K k) {
		if (root == null){
			return null;
		}else{
			AVLTreeNode<K, V> aux = root.search(k);
			
			if (aux != null)
            return aux.getValue();
			else 
            return null;
		}
		
	}

	
	public boolean isEmpty() {
		return size==0;
	}

	
	public int size() {
		return size;
	}

	
	public boolean keyExists(K k) {
		if (root == null) 
        return false;
		else{
			if (root.search(k) != null) 
            return true;
		}
		return false;
	}










//_______________Getters and Setters_______________

    
	public AVLTreeNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(AVLTreeNode<K, V> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

    

}
