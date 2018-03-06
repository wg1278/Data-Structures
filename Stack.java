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
	
	public void sort(){
		Stack<T> tmp = new Stack<T>();
		T var;
		
		if(!isEmpty())
			tmp.push(pop());
		else{
			System.out.println("Nothing to sort!");
			return;
		}
		
		while(!isEmpty()){
			if(tmp.peek().compareTo(peek()) < 0)
				tmp.push(pop());
			else{
				var = pop();
				while(!tmp.isEmpty() && tmp.peek().compareTo(var) > 0)
					push(tmp.pop());
				tmp.push(var);
			}
		}
		
		while(!tmp.isEmpty())
			push(tmp.pop());
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
		int[] vals = {4, 6, 0, 1, 7, 3, 8, 2, 9, 5};
		Stack<Integer> s = new Stack<Integer>();
		for(int val : vals)
			s.push(val);
		System.out.println(s.toString());
		s.sort();
		System.out.println(s.toString());
	}
}
