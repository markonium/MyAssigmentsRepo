package eg.edu.alexu.csd.datastructure.mailServer;

public interface IQueue {
	/**
	 * Inserts an item at the queue front.
	 * Throws exception in case of array-based queue if queue is full
	 * @param item The item to be added to the queue
	 */ 
	public void enqueue(Object item);
	/**
	 * Removes the object at the queue rear and returns it.
	 * @return the front of the queue or throw exception if queue is empty 
	 */ 
	public Object dequeue();
	/**
	 * Tests if this queue is empty.
	 * @return true if queue is empty else return false
	 */ 
	public boolean isEmpty();
	/**
	 * Returns the number of elements in the queue 
	 * @return the size of the queue
	 */ 
	public int size();
}
