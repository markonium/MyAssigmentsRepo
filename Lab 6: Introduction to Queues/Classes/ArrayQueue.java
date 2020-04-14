package eg.edu.alexu.csd.datastructure.queue.cs54;
/**
 * Array based queue class
 * @author Fares M. Fouad
 *
 */
public class ArrayQueue implements IQueue,IArrayBased{
	int N,f,r;
	Object[] arr;
	/**
	 * Constructor for the array-based queue
	 * @param n the size of the queue
	 */
	public ArrayQueue(int n) {
		N=n+1;
		arr=new Object[N];
		f=0; r=0;
	}public int size() {
		return (N-f+r)%N;
	}public boolean isEmpty() {
		return(f==r);
	}public void enqueue(Object item) {
		if(size()==N-1) {
			throw new RuntimeException("Queue is full");
		}arr[r]=item;
		r=(r+1)%N;
	}public Object dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}Object temp=arr[f];
		arr[f]=null;
		f=(f+1)%N;
		return temp;
	}
}
