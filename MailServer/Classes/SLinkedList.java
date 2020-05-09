package eg.edu.alexu.csd.datastructure.mailServer;

/**
 * Singly linked list class
 * @author Fares M. Fouad , Marwan Selim
 *
 */
public class SLinkedList implements ILinkedList,ISLinkedList{
	
	private class SLNode {

		private Object element;
		private SLNode next;
		
		public void setElement(Object newElement) {
			element = newElement;
		}
		public void setNext(SLNode newNext) {
			next = newNext;
		}
		public Object getElement() {
			return element;
		}
		public SLNode getNext() {
			return next;
		}
	}

	private SLNode head=null;
	private int size=0;
	
	
	public void add(int index, Object element) {
		
		if (index < 1 || index > size+1) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		SLNode newNode = new SLNode();
		newNode.setElement(element);
		SLNode P = new SLNode();
		if (index == 1) {
			newNode.setNext(head);
			head = newNode;
		}
		else {
			int i = 1;
			P = head;
			while (i < index-1) {
				P = P.getNext();
				i++;
			}
			newNode.setNext(P.getNext());
			P.setNext(newNode);
		}
		size++;
	}

	
	public void add(Object element) {
		
		SLNode newTail = new SLNode();
		newTail.setNext(null);
		newTail.setElement(element);
		if (head == null) {
			head = newTail;
		}
		else {
			SLNode P = new SLNode();
			if (head.getNext()==null) {
				head.setNext(newTail);
			}
			else {
				P = head.getNext();
				int i = 2;
				while (i < size) {
					P = P.getNext();
					i++;
				}
				P.setNext(newTail);
			}
			
		}
		size++;
		
	}

	
	public Object get(int index) {
		
		if (head == null) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 1 || index > size) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}

		SLNode P = new SLNode();
		int i = 1;
		P = head;
		while (i < index) {
				P = P.getNext();
				i++;
		}
		return P.getElement();
	}

	
	public void set(int index, Object element) {
		
		if (head == null) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 1 || index > size) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		SLNode P = new SLNode();
		int i = 1;
		P = head;
		while (i < index) {
				P = P.getNext();
				i++;
		}
		P.setElement(element);
		
	}

	
	public void clear() {
		head = null;
		size = 0;
		
	}

	
	public boolean isEmpty() {
		
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public void remove(int index) {
		
		if (head == null) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 1 || index > size) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		SLNode targetNode = new SLNode();
		SLNode P = new SLNode();
		if (index == 1) {
			head = head.getNext();	
		}
		else {
			int i = 1;
			P = head;
			while (i < index-1) {
				P = P.getNext();
				i++;
			}
			targetNode = P.getNext();
			P.setNext(targetNode.getNext());
		}
		size--;
		
	}

	
	public int size() {
		return size;
	}

	
	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		if (head == null) {
			throw new NullPointerException ("List is empty.");
		}
		if (fromIndex < 1 || fromIndex > size || toIndex < 1 || toIndex > size) {
			throw new IndexOutOfBoundsException ("Cannot access specified index(es).");
		}
		if (fromIndex > toIndex) {
			throw new  IllegalArgumentException ("Starting index must be less than or equal to final index.");
		}
		
		SLNode P = new SLNode();
		SLinkedList sublist= new SLinkedList();
		int i = 1;
		P = head;
		while (i < fromIndex) {
				P = P.getNext();
				i++;
			}
		sublist.add(P.getElement());
		while (i < toIndex) {
			P = P.getNext();
			sublist.add(P.getElement());
			i++;
		}
		return sublist;
	}

	
	public boolean contains(Object o) {
		
		if (head == null) {
			throw new NullPointerException ("List is empty.");
		}
		
		SLNode P = new SLNode();
			int i = 1;
			P = head;
			while (i < size+1) {
				if (P.getElement() == o) {
					return true;
				}
				else {
				P = P.getNext();
				i++;
				}
			}

		return false;
	}

}

