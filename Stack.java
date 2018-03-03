public class Stack<T extends Comparable<T>> {

	private class Node<T extends Comparable<T>>{
		
		public Node(T data){
			this.data = data;
		}
		
		private T data;
		private Node<T> next;
	}
	
	private int size;
	private Node<T> top;
	
	public Stack(){
		
	}
	
	public Stack(T data){
		top = new Node<T>(data);
		size = 1;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void push(T data){	
		Node<T> tmp = new Node<T>(data);
		tmp.next = top;
		top = tmp;
		size++;
	}
	
	public T peek(){
		return top.data;
	}
	
	public T pop(){
		if(size == 0){
			System.out.println("Error: Attempting to remove from empty stack!");
			return null;
		}
		
		T tmp = top.data;
		top = top.next;
		size--;
		return tmp;
	}
	
	public void clear(){
		size = 0;
		top = null;
	}
	
	public String toString(){
		Stack<T> tmp = new Stack<T>();
		StringBuilder sb = new StringBuilder();
		
		while(!isEmpty()){
			sb.append("[" + top.data + "]-->");
			tmp.push(this.pop());
		}
		
		while(!tmp.isEmpty())
			push(tmp.pop());
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.toString());
	}
}
