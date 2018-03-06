public class Queue<T extends Comparable<T>> {

	private class Node<T extends Comparable<T>>{
		
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private int size;
	private Node<T> front;
	private Node<T> back;
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void enqueue(T data){
		
		Node<T> tmp = new Node<T>(data);
		
		if(size == 0){
			front = tmp;
			back = front;
		}
		else{
			back.next = tmp;
			back = tmp;
		}
		
		size++;
	}
	
	public T dequeue(){
		T tmp;
		if(size == 0){
			System.out.println("Error: Attempting to remove from empty queue!");
			return null;
		}
		else{
			if(size == 1){
				tmp = front.data;
				front = null;
				back = null;
			}
			else{
				tmp = front.data;
				front = front.next;
			}
		}
		size--;
		return tmp;
	}
	
	public T peek(){
		return front.data;
	}
	
	public String toString(){
		if(size == 0)
			return "Empty Queue!";
		
		Node<T> tmp = front;
		StringBuilder sb = new StringBuilder();
		
		while(tmp != null){
			sb.append("[" + tmp.data + "]-->");
			tmp = tmp.next;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();
		System.out.println(q.toString());
		System.out.println(q.size());
	}
}
