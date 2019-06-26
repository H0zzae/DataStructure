import java.util.*;

/**
 * Generic version of the MyQueue class.
 * @param <T> the type of the value being queued
 */

class MyQueue <T> {
	private T[] queue;	// array for queue elements
	private int front, // one counterclockwise from front
	            rear, 	// array position of rear element
				capacity;	// capacity of queue array

	/**
	 * Create an empty queue whose initial capacity is cap
	 */
	@SuppressWarnings("unchecked")
	MyQueue(int cap) {
		capacity = cap;
		queue = (T []) new Object [capacity];
		front = rear = 0;
	}

	/**
	 * If number of elements in the queue is 0, return true else return false
	 */
	boolean IsEmpty() {
		return(rear==front)?true:false;
	}
	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception {
		if(((rear+1)%capacity) == front){
			throw new Exception ("Queue is Full");
		}else{
	 		rear = (rear +1)%capacity;
	 		queue[rear] = x;
		}
	}
	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {
		if(front != rear){
			front = (front+1)%capacity;
			if (front == capacity)
			front = 0;
			return queue[front];
		}

		// if queue is empty, throw the following message
			throw new Exception("Queue is empty. Cannot delete.");

}

	public String toString() {
		String a = new String();

		a = "Queue : ";
		for(int i =(front+1)%capacity; i!=(rear+1)%capacity; i =(i+1)%capacity){
				a += queue[i] + " " ;
		}
		a = a + '\n'+"rear="+rear+", "+"front="+front ;
		return a;
	}
};
