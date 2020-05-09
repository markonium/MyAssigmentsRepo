package eg.edu.alexu.csd.datastructure.mailServer;
/**
 * Doubly linked List Class
 * @author Fares M. Fouad , Marwan Selim
 *
 */
public class DLinkedList implements ILinkedList,IDLinkedList{
	

	//---------------------------------------Node class
	public class DNode {
	private Object element; private DNode next,prev;

	public DNode(Object e,DNode n,DNode p) {
		element=e; prev=n; next=p;
	}

	public Object getElement() {
		return element;
	}
	public DNode getNext() {
		 return next;
	}
	public DNode getPrev() {
		 return prev;
	}
	public void setElement(Object newElement) {
		element=newElement;
	}
	public void setNext(DNode newNext) {
		next=newNext;
	}
	public void setPrev(DNode newPrev) {
		prev=newPrev;
	}

	}
	//-----------------------Node class End
	public DNode header,trailer;
	public DLinkedList() {  //tested
	header = new DNode(null, null, null);
	trailer = new DNode(null, header, null);
	header.setNext(trailer);
	}

	public void add(int index, Object element){ //tested
		
		int size = size();
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		DNode p=header; int count=-1;
			while(count<index-1) {
				p=p.getNext(); count++;
			}
				DNode q=new DNode(element,p,p.getNext());
				DNode temp=p.getNext(); p.setNext(q); temp.setPrev(q);
	}

	public void add(Object element) { //tested
		DNode u=trailer.getPrev();
		DNode q=new DNode(element, u,trailer);
		u.setNext(q);
		trailer.setPrev(q);
	}

	public Object get(int index){ //tested
		
		int size = size();
		if (header.getNext() == trailer) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		DNode p=header.getNext(); int count=0;
		while(count<index) {
			p=p.getNext(); count++;
		}return p.getElement();
	}

	public void set(int index, Object element){ //tested
		
		int size = size();
		if (header.getNext() == trailer) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
			DNode p=header.getNext(); int count=0;
			while(count<index) {
				p=p.getNext(); count++;
			}p.setElement(element);
	}

	public void clear() { //tested
		if(header.getNext()!=trailer) {
			DNode p = header.getNext(); DNode q=p.getNext();
			while(p!=trailer) {
				p.setNext(null); p.setPrev(null); p.setElement(null);
				p=q;
				q=p.getNext();
			}trailer.setPrev(header); header.setNext(trailer);
		}
	}

	public boolean isEmpty() { //tested
		return header.getNext()==trailer;
	}

	public void remove(int index){ //tested
		
		int size = size();
		if (header.getNext() == trailer) {
			throw new NullPointerException ("List is empty.");
		}
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException ("Cannot access specified index.");
		}
		
		DNode p=header; int count=-1;
			while(count<index-1) {
				p=p.getNext(); count++;
			}DNode q=p.getNext(); DNode u=q.getNext();
			p.setNext(u); u.setPrev(p);
			q.setElement(null); q.setNext(null); q.setPrev(null);
	}

	public int size() { //tested
		int count=0; DNode p=header.getNext();
		while(p!=trailer) {
			p=p.getNext(); count++;
		}return count;
	}

	public ILinkedList sublist(int fromIndex, int toIndex){ //tested
		
		int size = size();
		if (header.getNext() == trailer) {
			throw new NullPointerException ("List is empty.");
		}
		if (fromIndex < 0 || fromIndex > size-1 || toIndex < 0 || toIndex > size-1) {
			throw new IndexOutOfBoundsException ("Cannot access specified index(es).");
		}
		if (fromIndex > toIndex) {
			throw new  IllegalArgumentException ("Starting index must be less than or equal to final index.");
		}
		
		DLinkedList x=new DLinkedList();
	    	int count=0; DNode p=header.getNext();
	    	while(count<fromIndex) {
	    		count++; p=p.getNext();
	    	}
	    	while(count<=toIndex) {
	    		x.add(p.getElement());
	    	    p=p.getNext(); count++;
	    	}
	    return(x);
	}

	public boolean contains(Object o) {  //tested
		
		
		if (header.getNext() == trailer) {
			throw new NullPointerException ("List is empty.");
		}
		else {
	    	DNode p=header.getNext();
	    	while(p!=trailer) {
	    		if(p.getElement().equals(o)) {
	    			return true;
	    		}p=p.getNext();
	    	}return false;
	    }
	}

	}

