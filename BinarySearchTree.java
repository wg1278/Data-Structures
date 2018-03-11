public class BinarySearchTree<T extends Comparable<T>> {
	private class Node<T extends Comparable<T>>{
		T data;
		Node<T> left;
		Node<T> right;
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> root;
	private int size;
	
	public BinarySearchTree(){
		
	}
	
	public BinarySearchTree(T data){
		root = new Node(data);
		size = 1;
	}
	
	public boolean search(T data){
		boolean result = false;
		Node<T> ptr = root;
		
		while(ptr != null){
			if(ptr.data.compareTo(data) == 0){
				result = true;
				break;
			}
			else{
				if(ptr.data.compareTo(data) > 0)
					ptr = ptr.left;
				else
					ptr = ptr.right;
			}
		}
		return result;
	}

	
	public void insert(T data){
		root = insertHelper(root, data);
	}
	
	private Node<T> insertHelper(Node<T> root, T data){
		if(root == null){
			size++;
			return new Node(data);
		}
		
		if(data.compareTo(root.data) < 0)
			root.left = insertHelper(root.left, data);
		if(data.compareTo(root.data) > 0)
			root.right = insertHelper(root.right, data);
		
		return root;
	}
	
	public void delete(T data){
		root = deleteHelper(root, data);
	}
	
	private Node<T> deleteHelper(Node<T> root, T data){
		if(root == null)
			return root;
		
		if(root.data.compareTo(data) > 0)
			root.left = deleteHelper(root.left, data);
		else{
			if(root.data.compareTo(data) < 0)
				root.right = deleteHelper(root.right, data);
			else{
				if(root.left == null){
					// 0 children
					if(root.right == null){
						root = null;
						return root;
					}
					else // 1 child
						return root.right;
				}
				else{
					if(root.left == null) // 1 child
						return root.left;
					else{
						root.data = this.findMin(root.right);
						root.right = deleteHelper(root.right, root.data);
					}
				}
			}
		}
		return root;
	}
		
		
	
	public T findMin(Node<T> root){
		T min = root.data;
		while(root.left != null){
			root = root.left;
			min = root.data;
		}
		return min;
	}

	public void printTree(){
		printTreeHelper(root);
	}
	
	private void printTreeHelper(Node<T> root){
		if(root != null){
			printTreeHelper(root.left);
			System.out.println(root.data);
			printTreeHelper(root.right);
		}
	}
	
	public static void main(String[] args){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		//bst.printTree();
		bst.delete(4);
		bst.printTree();
	}
}
