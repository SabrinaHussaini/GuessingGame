package datastructures;
/**
 * This class is for the specific node in the class that uses data and next throughout
 * @author Sabrina Hussaini
 *
 * @param <T>
 */
public class LinkedListNode <T> {
	// var used fir type t which is data and then the linked list node which is next
	private T data;
	private LinkedListNode<T> next;


	/**
	 * Set the data stored at this node.
	 * @param t data
	 */
	public void setData( T data ) {
		// this is set to data basically data is data
		this.data = data;

	}
	/**
	 * Get the data stored at this node.
	 * @return the getter for the data
	 */
	public T getData() {
		// returns data
		return data;

	}
	/**
	 * Set the next pointer to passed node.
	 * @param node which is the node for the class
	 */
	public void setNext( LinkedListNode<T> node ){
		// linked list node t is node
		this.next  = node;
	}
	/**
	 * Get (pointer to) next node.
	 * @return next which is the getter for next
	 */
	public LinkedListNode<T> getNext(){
		// returns next
		return next;

	}


	/**
	 * Returns a String representation of this node.
	 * @return the data to string
	 */
	public String toString(){
		// returns the data to string
		return data.toString();




	}
}