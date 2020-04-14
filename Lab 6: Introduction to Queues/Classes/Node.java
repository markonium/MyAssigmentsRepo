package eg.edu.alexu.csd.datastructure.queue.cs54;

	/**
	 * Linked list node class
	 * @author Fares M. Fouad
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
