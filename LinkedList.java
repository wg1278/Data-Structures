public class LinkedList<T extends Comparable<T>> {
	
	private class Node<T extends Comparable<T>>{
		T data;
		Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	Node<T> head;
	int size;
	
	public int size(){
		return size;
	}
	
	public void add(T data){
		Node<T> tmp = new Node(data);
		
		if(head == null){
			head = tmp;
			size++;
			return;
		}
		
		Node<T> ptr = head;
		
		while(ptr.next != null)
			ptr = ptr.next;
		
		ptr.next = tmp;
		size++;
	}
	
	public boolean contains(T data){
		if(head == null)
			return false;
		
		Node<T> ptr = head;
		
		while(ptr != null){
			if(ptr.data.equals(data))
				return true;
			ptr = ptr.next;
		}
		
		return false;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void add(T data, int index){
		if(index > size)
			index = size;
		
		if(index < 0)
			index = 0;
		
		Node<T> tmp = new Node<T>(data);
		if(index == 0){
			tmp.next = head;
			head = tmp;
			size++;
			return;
		}
		
		int count = 0;
		Node<T> ptr = head;
		while(count < index - 1){
			ptr = ptr.next;
			count++;
		}
		tmp.next = ptr.next;
		ptr.next = tmp;
		size++;
	}
	
	public T get(int index){
		if(index >= size)
			index = size - 1;
		
		if(index < 0)
			index = 0;
		
		int count = 0;
		Node<T> ptr = head;
		while(count < index){
			ptr = ptr.next;
			count++;
		}
		
		return ptr.data;
	}
	
	public T remove(int index){
		if(index >= size)
			index = size - 1;
		
		if(index < 0)
			index = 0;
		
		Node<T> ptr = new Node(Integer.MIN_VALUE); // dummy node
		ptr.next = head;
		
		int count = 0;
		while(count < index){
			ptr = ptr.next;
			count++;
		}
		
		T data = ptr.next.data;
		if(count == 0)
			head = head.next;
		else
			ptr.next = ptr.next.next;
		return ptr.data;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node<T> ptr = head;
		while(ptr != null){
			sb.append("[" + ptr.data + "]-->");
			ptr = ptr.next;
		}
	
		return sb.toString();
	}

	public static void main(String[] args){
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3, -1);
		System.out.println(l.toString());
		l.remove(2);
		System.out.println(l.toString());
	}
}
