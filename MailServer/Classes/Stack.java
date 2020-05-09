package eg.edu.alexu.csd.datastructure.mailServer;

import java.util.EmptyStackException;


/**
 * Stack class
 * @author Marwan Selim, Fares M. Fouad
 *
 */
public class Stack implements IStack{
	/**
	 * Linked list node class
	 * @author Fares M. Fouad, Marwan Selim
	 *
	 */
	public class Node {
	private Object element; private Node prev;
	/**
	 * Node constructor
	 * @param e The node element
	 * @param n	The previous Node
	 */
	public Node(Object e,Node n) {
		element=e; prev=n;
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
	public Node getPrev() {
		 return prev;
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
	public void setPrev(Node newPrev) {
		prev=newPrev;
	}

	}

	private int size;
	private Node top;
	public Stack() {  //constructor
		top=new Node(null,null);
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}return false;
	}
	public void push(Object newElem) {
		Node newTop = new Node(newElem, top);
		top=newTop;
		size++;
	}
	public Object pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}size--;
		Node tempNode=top;
		top=top.getPrev();
		tempNode.setPrev(null);
		return tempNode.getElement();
	}
	public Object peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}return top.getElement();
	}
}

