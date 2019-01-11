package datastructures;
import datastructures.BinaryTreeNode;

/**
 * This class focuses on the default binary tree node. This uses binary tree node where it will set the data,
 * and get the data for the left and right child's. 
 * @author sabrina hussaini
 *
 */
public class DefaultBinaryTreeNode <T> implements BinaryTreeNode <T> {
	// instance variables for 
	private T data;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	/**
	 * this is the constructor for the data 
	 * @param string 
	 * @return the data 
	 */
	public DefaultBinaryTreeNode(String string) {
		data = (T) string;

	}
	/**
	 * getter for the data
	 * @return the type data
	 */
	public T getData() {
		// return the data
		return data;
	}
	/**
	 * this sets the data to data T
	 * @param data type t 
	 */
	public void setData(T data) {
		// sets data to data
		this.data = data;

	}
	/**
	 * this method gets the left child 
	 * @return the left child node
	 */
	public BinaryTreeNode<T> getLeftChild() {
		// return the left child
		return leftChild;
	}
	/**
	 * This gets the right child 
	 * @return the right child node
	 */
	public BinaryTreeNode<T> getRightChild() {
		//return the right child
				return rightChild;
	}

	/**
	 * this sets the left child to left 
	 * @param the left side
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		// the left child node is set to left from the parameter above
		this.leftChild = left;	
	}
	/**
	 * this sets the right to right child to right 
	 * @param the right child 
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		// the right child node is set to the right paramater from above
		this.rightChild = right;
	}

	/** 
	 * This method is for if there is no child then it is a leaf and it is a null
	 * if it is null. 
	 * @return will return left and right as null if it is a leaf 
	 */
	public boolean isLeaf() {
		// the left child is null meaning it has no child and right also has no child so it is null then it is a leaf
		return leftChild == null && rightChild == null;
	}

}
