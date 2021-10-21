package model;

//import java.util.LinkedList;

public class AVLTreeNode<K extends Comparable<K>,V>{

    private AVLTree<K,V> owner;
    private K   key;
    private V   value;
    private int height;
    private int leftHeight;
    private int rightHeight;
    private int balanceFactor;

    private AVLTreeNode<K,V> left;
    private AVLTreeNode<K,V> right;
    private AVLTreeNode<K,V> parent;

    public AVLTreeNode(K k,V v, AVLTree<K,V> owner){
        key   = k;
        value = v;

        height  = 1;
        leftHeight = 0;
        rightHeight = 0;
        balanceFactor = 0;
    
        this.owner = owner;
    
    }   


    public boolean add(K k,V v){
        if(key.compareTo(k)<0){
            if(right == null){
                right = new AVLTreeNode<K,V>(k,v,null);
                right.setParent(this);
                if(right.height+1 > height)
                    height = right.height+1;
                    rightHeight = right.height;
                    return true;    
                
            }else {
                boolean status = right.add(k, v);
                if(right.height+1 > height)
                    height = right.height+1;
                    rightHeight = right.height;
                    return status;
                
            }
        }else{
            if(left == null){
                left = new AVLTreeNode<K,V>(k,v,null);
                left.setParent(this);
                if(left.height+1 > height)
                    height = left.height+1;
                    leftHeight = left.height;
                    return true;  
                
        }else{
            boolean status = left.add(k, v);
            if(left.height+1 > height)
                height = left.height+1;
                leftHeight = left.height;
                return status;        
            }
        }
    }




    public boolean remove(K k){
		if (key.compareTo(k) > 0){
			if (left != null){
				if (left.key.equals(k)){
					boolean status = removeLeft();
					if (left != null)
                    leftHeight = left.height;
					else leftHeight = 0;
					
					if (leftHeight+1 > rightHeight+1) 
                    height = leftHeight+1;
					else height = rightHeight+1;
					return status;
				}
				else{
					boolean status = left.remove(k);
					if (left != null)
                    leftHeight = left.height;
					else leftHeight = 0;
					if (leftHeight+1 > rightHeight+1) 
                    height = leftHeight+1;
					else height = rightHeight+1;
					return status;
						
				}
			}else{
				return false;
			}
		}else if (key.compareTo(k)< 0){
			
			if (right != null){
				if (right.key.equals(k)){
					boolean status = removeRight();
					if (right != null)
                    rightHeight = right.height;
					else rightHeight = 0;
					
					if (leftHeight+1 > rightHeight+1) 
                    height = leftHeight+1;
					else height = rightHeight+1;
					return status;
				}
				else{
					boolean status = right.remove(k);
					if (right != null) 
                    rightHeight = right.height;
					
					if (leftHeight+1 > rightHeight+1) 
                    height = leftHeight+1;
					else height = rightHeight+1;
					return status;
				}
			}else{
				return false;
			}
		}
		return false;
	}
	
	
	public AVLTreeNode<K,V> getSuccesor(){
		if (right != null){
			AVLTreeNode<K, V>  a = right.catchMinSon();
			if (left == null) leftHeight = 0;
			else leftHeight = left.height;
			if (right == null) rightHeight = 0;
			else rightHeight = right.height;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else height = rightHeight+1;
			
			return a;
			
		}else{
			return left;
		}
	}


    public AVLTreeNode<K,V> minSon(){
		if (left == null) 
        return this;
		else return left.minSon();
	}
	
	public AVLTreeNode<K,V> catchMinSon(){
		if (left == null){
			AVLTreeNode<K,V> a = this;
			if (parent.left == this) {
				if (right != null) {
					parent.left = right;
					right = null;
				}
				else parent.left = null;
			}
			else{
				if (right != null){
					parent.right = right;
					right = null;
				}else{
					parent.right = right;
				}
			}
			
			return a;
		}else{
			AVLTreeNode<K,V> a =  left.catchMinSon();
			if (left == null) 
            leftHeight = 0;
			else 
            leftHeight = left.height;
			if (right == null) 
            rightHeight = 0;
			else 
            rightHeight = right.height;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else 
            height = rightHeight+1;
			
			return a;
		}
	}





	
	private boolean removeLeft(){
		if (left.right == null && left.left == null){
			left = null;
			leftHeight = 0;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else height = rightHeight+1;
		}else{
			AVLTreeNode<K,V> aux = left.getSuccesor();
			if (aux.parent.left == aux) 
            parent.left = null;
			else 
            aux.parent.right = null;
			
			aux.left = left.left;
			if (left.left != null)
            left.left.parent = aux;
			
			aux.right = left.right;
			if (left.right != null) 
            left.right.parent = aux;
			
			aux.parent = this;
			left = aux;
			
			leftHeight = left.height;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else height = rightHeight+1;
		}
		
		return true;
		
	}
	
	public boolean removeRight(){
		if (right.right == null && right.left == null){
			right = null;
			rightHeight = 0;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else 
            height = rightHeight+1;
			
		}else{
			AVLTreeNode<K,V> aux = right.getSuccesor();
			if (aux.parent.left == aux) 
            parent.left = null;
			else 
            aux.parent.right = null;
			
			aux.left = right.left;
			if (right.left != null) 
            right.left.parent = aux;
			
			aux.right = right.right;
			if (right.right != null) 
            right.right.parent = aux;
			
			aux.parent = this;
			right = aux;
			
			rightHeight = right.height;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else 
            height = rightHeight+1;
		}
		return true;
	}


    public AVLTreeNode<K,V> search(K k){
		if (key.equals(k)){
			return this;
			
		}else{
			if (key.compareTo(k)<0){
				if (right == null){
					return null;
				}else{
					return right.search(k);
				}
			}else{
				if (left == null){
					return null;
				}else{
					return left.search(k);
				}
			}
		}
	}
	
/*public LinkedList<V> searchByRange(K kStart, K kEnd){
		LinkedList<V> temp = new LinkedList<>();
		
		if(kStart.compareTo(key)<0){
			if (left != null){
				temp.addAll(left.searchByRange(kStart,kEnd));
			}
		}
		
		if(kStart.compareTo(key)<=0&&kEnd.compareTo(key)>=0){
			temp.add(value);
		}
		
		if (kEnd.compareTo(key)>0){
			if (right != null){
				temp.addAll(right.searchByRange(kStart,kEnd));
			}
		}
		
		return temp;
	}
*/

	
	public void leftRotate(){
		AVLTreeNode<K, V> aux = right;
		right = null;
		rightHeight = 0;
		
		if (aux.left != null){
			right = aux.left;
			aux.left.setParent(this);
			aux.left = null;
			rightHeight = right.height;
		}
		
		aux.left = this;
		
		if (owner != null)
		{
			parent = aux;
			owner.setRoot(aux);
			aux.owner = owner;
			owner = null;
		}else
		{
			if (parent.left == this)
			{
				parent.left = aux;
				aux.parent = parent;
			}else
			{
				parent.right = aux;
				aux.parent = parent;
			}
		}
		
		parent = aux;
		
		if (leftHeight+1 > rightHeight+1) 
        height = leftHeight+1;
		else 
        height = rightHeight+1;
		
		aux.leftHeight = height;
		
		if (aux.leftHeight> aux.rightHeight) 
        aux.height = aux.leftHeight+1;
		else 
        aux.height = aux.rightHeight+1;
	}
	
	
	public void rightRotate(){
		AVLTreeNode<K, V> aux = left;
		left = null;
		leftHeight = 0;
		if (aux.right != null){
			left = aux.right;
			aux.right.parent = this;
			aux.right = null;
			leftHeight = left.height;
		}
		
		aux.right = this;
		if (owner != null){
			owner.setRoot(aux);
			aux.parent = null;
			aux.owner = owner;
			owner = null;
			
		}else{
			if (parent.left == this){
				parent.left = aux;
				aux.parent = parent;
			}
			else{
				parent.right = aux;
				aux.parent = parent;
			}
		}
		
		parent = aux;
		
		if (leftHeight+1 > rightHeight+1) 
        height = leftHeight+1;
		else 
        height = rightHeight+1;
		
		aux.rightHeight = height;
		
		if (aux.leftHeight> aux.rightHeight) 
        aux.height = aux.leftHeight+1;
		else 
        aux.height = aux.rightHeight+1;
	}








    public void calculateBalanceFactor(){
            balanceFactor = rightHeight - leftHeight;
        }
	

	public boolean verifySpecialCase(int x){
		switch (x){
		case 1: 
			if (left.left == null && left.right != null){
				return true;
			}else{
				return false;
			}
			
		case 2: 
			if (right.right == null && right.left != null){
				return true;
			}else{
				return false;
			}
			default: return true;
		}	
	}
	

	public boolean balance(){
		if (isBalanced()){
			return true;
		}else{
			if(left != null && !left.isBalanced()){
			    left.balance();
			}
			if (right != null && !right.isBalanced()){
				right.balance();
			}
			
			if (left != null) 
            leftHeight = left.height;
			else leftHeight = 0;
			
			if (right != null) 
            rightHeight = right.height;
			else rightHeight = 0;
			
			if (leftHeight+1 > rightHeight+1) 
            height = leftHeight+1;
			else height = rightHeight+1;
			
			if (isBalanced()){
				return true;
			}else{
				if (balanceFactor > 1){
					if (verifySpecialCase(2)){
						right.rightRotate();
						leftRotate();
					}else{
						leftRotate();
					}
				}else{
					if (verifySpecialCase(1)){
						left.leftRotate();
						rightRotate();
					}else{
						rightRotate();
					}
				}
				
				return true;
			}
				
		}
		
	}
	
	
	public boolean isBalanced()
	{
		calculateBalanceFactor();
		if (balanceFactor < -1 || balanceFactor > 1){
			return false;
		}else{
			return true;
		}
	}





//_______________Getters and Setters_______________

    public K getKey(){
        return key;
    }
    
    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getLeftHeight() {
		return leftHeight;
	}

	public void setLeftHeight(int leftHeight) {
		this.leftHeight = leftHeight;
	}

	public int getRightHeight() {
		return rightHeight;
	}

	public void setRightHeight(int rightHeight) {
		this.rightHeight = rightHeight;
	}

    public int getBalanceFactor(){
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor){
        this.balanceFactor = balanceFactor;
    }

    public AVLTreeNode<K,V> getLeft(){
        return left;
    }

    public void setLeft(AVLTreeNode<K,V> left){
        this.left = left;
    }

    public AVLTreeNode<K,V> getRight(){
        return right;
    }

    public void setRight(AVLTreeNode<K,V> right){
        this.right = right;
    }

    public AVLTreeNode<K,V> getParent(){
        return parent;
    }

    public void setParent(AVLTreeNode<K,V> parent){
        this.parent = parent;
    }

    public AVLTree<K, V> getOwner() {
		return owner;
	}

	public void setOwner(AVLTree<K, V> owner) {
		this.owner = owner;
	}

}