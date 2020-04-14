package eg.edu.alexu.csd.datastructure.queue.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {



	LinkedQueue queue=new LinkedQueue();
	/**
	 * Testing size method immediately after initializing the queue 
	 */
	@Test
	void testSize() {
		assertEquals(queue.size(),0);
	}
	
	/**
	 * Testing isEmpty method immediately after initializing the queue
	 */
	@Test
	void testIsEmpty() {
		assertEquals(queue.isEmpty(),true);
	}

	/**
	 * Testing enqueue and dequeue as well as the size and isEmpty methods under different situations
	 */
	@Test
	void testDequeueEnqueue() {
		queue.enqueue(1);
		queue.enqueue(1.5);
		queue.enqueue('a');
		queue.enqueue("RandomWord");
		queue.enqueue(new Point(10,11));
		
		assertEquals(false,queue.isEmpty());
		assertEquals(queue.size(),5);
		assertEquals(1,queue.dequeue());
		assertEquals(1.5,queue.dequeue());
		assertEquals('a',queue.dequeue());
		assertEquals("RandomWord",queue.dequeue());
		assertEquals(new Point(10,11),queue.dequeue());
		assertEquals(true,queue.isEmpty());
		assertEquals(queue.size(),0);
	}
	
	/**
	 * Testing queue empty exception 
	 */
	@Test
	public void testDequeueException() {
		try {
			queue.dequeue();
			fail();
		}catch(RuntimeException e) {
			assertEquals("Queue is empty",e.getMessage());
		}
	}
	
}
