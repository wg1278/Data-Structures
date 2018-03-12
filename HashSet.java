import java.util.Iterator;
public class HashSet<T extends Comparable<T>>{
	private class Node<T>{
		T data;
		Node<T> next;
		
		private Node(T data){
			this.data = data;
		}
	}
	private int size = 0; // number of objects stored
	private int capacity = 16; // maximum allowable objects
	private Object[] set;
	
	public HashSet(){
		set = new Object[capacity];
	}
	
	public boolean contains(T data){
		int index = data.hashCode() % (capacity);
		if(set[index] == null)
			return false;
		else{
			Node<T> ptr = (Node<T>) set[index];
			
			while(ptr != null){
				if(ptr.data.equals(data))
					return true;
				else
					ptr = ptr.next;
			}
			return false;
		}
	}
	
	public boolean add(T data){
		if(!contains(data)){
			int hashIndex = data.hashCode() % (capacity);
			Node<T> val = new Node<T>(data);
			if(set[hashIndex] == null)
				set[hashIndex] = val;
			else{
				Node<T> ptr = (Node<T>) set[hashIndex];
				while(ptr.next != null)
					ptr = ptr.next;
				ptr.next = val;
			}
			size++;
			
			if(2*size > capacity)
				resize("grow");
			
			return true;
		}
		return false;
	}
	
	public boolean remove(T data){
		if(contains(data)){
			int hashIndex = data.hashCode() % capacity;
			Node<T> ptr = (Node<T>)set[hashIndex];
			if(ptr.data.equals(data)){
				set[hashIndex] = ptr.next;
				ptr = null;
			}
			else{
				while(ptr.next != null){
					if(ptr.next.data.equals(data)){
						ptr.next = ptr.next.next;
					}
				}
			}
			size--;
			
			if(size*4 < capacity)
				resize("shrink");
			
			return true;
		}
		return false;
	}
	
	private boolean resize(String action){
		Object[] oldSet = set;
		int oldCapacity = capacity;
		size = 0;
		
		if(action.equals("grow"))
			capacity = 2 * capacity;
		else {
			if(action.equals("shrink"))
				capacity = capacity / 2;
			else{
				System.out.println("Invalid action!");
				return false;
			}
		}
		
		set = new Object[capacity];
		
		for(int i = 0; i < oldCapacity; i++){
			Node<T> ptr;
			if(oldSet[i] != null){
				ptr = (Node<T>) oldSet[i];
				while(ptr != null){
					add(ptr.data);
					ptr = ptr.next;
				}
			}
		}
		return true;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		if(size == 0){
			System.out.println("Empty set!");
			return;
		}
		
		Node<T> ptr;
		for(int i = 0; i < capacity; i++){
			if(set[i] != null){
				ptr = (Node<T>) set[i];
				while(ptr != null){
					System.out.println(ptr.data.toString());
					ptr = ptr.next;
				}
			}
		}
	}
	
	public T get(T data){
		if(contains(data)){
			int hashIndex = data.hashCode() % capacity;
			Node<T> ptr = (Node<T>) set[hashIndex];
			while(ptr != null){
				if(ptr.data.equals(data))
					return ptr.data;
				ptr = ptr.next;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < 16; i++)
			hs.add(i);
		
		hs.print();
		System.out.println(hs.size());
		System.out.println(hs.get(3));
		System.out.print(hs.get(18));
	}
}
