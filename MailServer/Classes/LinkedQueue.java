package eg.edu.alexu.csd.datastructure.mailServer;

/**
 * 
 * @author Fares M. Fouad , Marwan Selim
 *
 */
public class LinkedQueue implements IQueue {
	/**
	 * Linked list node class
	 * @author Fares M. Fouad , Marwan Selim
	 *
	 */
public class Node {
	private Object element; private Node next;
	/**
	 * Node constructor 1 with no parameters
	 */
	public Node() {
		this(null,null);
	}
	/**
	 * Node constructor 2
	 * @param e The node element
	 * @param n	The previous Node
	 */
	public Node(Object e,Node n) {
		element=e; next=n;
	}
	/**
	 * This method return the node element
	 * @return Node element
	 */
	public Object getElement() {
		return element;
	}
	/**
	 * This method returns the previous node
	 * @return The previous node
	 */
	public Node getNext() {
		 return next;
	}
	/**
	 * This method sets the element of the node
	 * @param newElement the new element of the node
	 */
	public void setElement(Object newElement) {
		element=newElement;
	}
	/**
	 * This method sets the previous node
	 * @param newPrev the new previous node
	 */
	public void setNext(Node newNext) {
		next=newNext;
	}

}

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

