package eg.edu.alexu.csd.datastructure.queue.cs54;

public class LinkedQueue implements IQueue, ILinkedBased {
	Node header;
	Node tail;
	int size;
	/**
	 * Constructor for the linked-based queue 
	 */
	public LinkedQueue() {
		header=new Node();
		tail=header;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		if(size()==0) {
			return true;
		}return false;
	}public void enqueue(Object item) {
		Node temp=new Node(item,null);
		tail.setNext(temp);
		tail=temp;
		size++;
	}public Object dequeue() {
		if(size==0) {
			throw new RuntimeException("Queue is empty");
		}
		Node first=header.getNext();
		header.setNext(first.getNext());
		first.setNext(null);
		size--;
		if(size==0) {
			tail=header;
		}
		return first.getElement();
	}
}
