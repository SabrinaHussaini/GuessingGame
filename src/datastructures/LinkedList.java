package datastructures;

/**
 * This class focuses on the entire linked list which goes through the list and adds nodes to the list. It also will then create a new node that then becomes the head.
 * This class also deletes a node at a specific node. Then uses size to check through to see how long the node is for example.
 * @author Sabrina Hussaini
 *
 * @param <T> which uses the diff functions like int double and so on so forth
 */

public class LinkedList<T> implements List<T> {
	// var used for linked list head
	public LinkedListNode head;


	/**
	 * Helper method to access the node at index.
	 * If the index is invalid (negative or >= size of list), return null pointer.
	 * @param index which is index for the getnode
	 * @return the temp which is the temp header avr
	 **/
	private LinkedListNode <T> getNode( int index ){
		// create temp node
		LinkedListNode<T> temp = head;
		// creates a counter
		int counter = 0;
		// while loop where index is greater than the counter
		while (counter < index  ){
			if (counter <= size()){
				counter++;
				temp = temp.getNext();
			}


		}
		return temp;
	}

	/**
	 * this class adds the node to the new header. So like it will create a new node and then that node is part of the data and that then turns into the head.
	 * @param index for where you are at
	 * @param data which is the data at which you add
	 */
	public void add(int index, T data) {
		if (index >= 0 && index <= size()){
			// creates a new node
			LinkedListNode node = new LinkedListNode();
			node.setData(data);
			// if the index at is zero then set next to head and node is now the head
			if (index == 0){
				node.setNext(head);
				// setting the new node to the head for the linked list
				head = node;
			} else {
				LinkedListNode previousNode = getNode(index-1);
				//node = getNode(index);
				node.setNext(previousNode.getNext());
				previousNode.setNext(node);


			}


		}
	}

	/**
	 * This class is the getter at which the data is stored in at a certain index
	 * @@param index which is the index at the get
	 */
	public T get(int index) {
		// if the temp is null then it returns null else gets the data
		LinkedListNode<T> temp = getNode(index);
		if (temp == null){
			return null;
		}else{
			return temp.getData();
		}
	}

	/**
	 * This deletes the data at a specfic place in the linked list
	 * @param index which is the index for the delete
	 */
	public void delete(int index) {
		if (index == 0){
			head = head.getNext();

		} 
		else {
			LinkedListNode <T> previousNode = getNode(index - 1);
			LinkedListNode currentNode = getNode(index + 1);
			previousNode.setNext(currentNode);
		}

	}
	/**
	 * this method is for the size of the linked list and goes all the way through the list
	 * @return size: the size of the entire list
	 */
	public int size() {
		// size is set to zero
		int size = 1;
		// node is the head
		LinkedListNode node = head;

		if(head == null){
			return 0;
		} else {
			// while loop to go through to see where it is not null and then increments and keeps on going until you reach the end
			while (node.getNext() != null ){
				size++;
				node = node.getNext();
			}

		}
		// returns the size
		return size;
	}
	/**
	 *  if the list is empty then the head is equaled to null
	 *  @return head is equal to null
	 */
	public boolean isEmpty() {
		if(head==null){
			return true;
		}
		return false;
	}
	/**
	 * This method deals w the to string which uses a while loop to go through and put the
	 * arrow thing.
	 * @return list which is the string used
	 */
	public String toString(){
		String list = new String();
		// if the head is null then return null
		if (head == null){
			
			
			return "isEmpty";
		}
		LinkedListNode currentNode = head;
		// if the node is not  null then it should put the arrow thing
		while (currentNode != null){
			list += currentNode.toString();
			currentNode = currentNode.getNext();
			if (currentNode != null){
				list+= "->";
			}
		}


		return list;
	}
public LinkedListNode<Integer> getFirstNode(){
	return head;
}
	
}