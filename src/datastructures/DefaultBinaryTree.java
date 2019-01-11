package datastructures;


import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;


/**
 * This class is the default binary tree where it implements the binary tree of type T. this class 
 * contains the main method which creates each type of tree node and then the tree itself. 
 * Then deals with the three types of traversals for this program in which it orders them correctly
 * and prints them then. It also has the getters and setters. 
 * @author sabrinahussaini
 *
 * @param <T>
 */

public class DefaultBinaryTree<T> implements BinaryTree <T>{
	// variable for default binary tree node which is called root
	public  DefaultBinaryTreeNode<T> root;


	/**
	 * This is the main method for the class where it first creates a tree and then creates a bunch
	 * of tree nodes for the tree that are the children of it. These names are the seven dwarves and it uses string 
	 * to print them all out. It then sets happy to the main tree which will then be the root for the tree. Then 
	 * it sets doc to happy as a left child. Then sets bashful to the left child of doc. Then sets grumpy to the right 
	 * child of doc. Dopey is set to the right child of grumpy. Then sets sleepy to the right child of happy. 
	 * And sneezy to the right child of sleepy. 
	 * @param args
	 */
	public static void main(String [] args) {
		// the tree called main tree
		DefaultBinaryTree<String> mainTree = new DefaultBinaryTree<String> ();
		// these are all nodes/children for the tree
		DefaultBinaryTreeNode<String> Happy = new DefaultBinaryTreeNode<String> ("happy");
		DefaultBinaryTreeNode<String>  Doc = new DefaultBinaryTreeNode<String> ("doc");
		DefaultBinaryTreeNode<String>  Bashful = new DefaultBinaryTreeNode<String> ("bashful");
		DefaultBinaryTreeNode<String>  Grumpy = new DefaultBinaryTreeNode<String> ("grumpy");
		DefaultBinaryTreeNode<String>  Dopey = new DefaultBinaryTreeNode <String> ("dopey");
		DefaultBinaryTreeNode <String> Sleepy = new DefaultBinaryTreeNode<String>  ("sleepy");
		DefaultBinaryTreeNode <String> Sneezy = new DefaultBinaryTreeNode<String> ("sneezy"); 
		// set happy to root
		mainTree.setRoot(Happy);
		// set doc to happy
		Happy.setLeftChild(Doc);
		// set bashful to left child
		Doc.setLeftChild(Bashful);
		// set grumpy to doc
		Doc.setRightChild(Grumpy);
		// set dopey to grumpy
		Grumpy.setRightChild(Dopey);
		// set sleepy to happy
		Happy.setRightChild(Sleepy);
		// set sneezy to sleepy
		Sleepy.setRightChild(Sneezy);

		// calling the traversals to the tree
		mainTree.inorderTraversal();
		mainTree.preorderTraversal();
		mainTree.postorderTraversal();


	}
	/**
	 * This is the constructor for binary tree where the root is set to null
	 */
	public DefaultBinaryTree() {
		root = null;
	} 
	/**
	 * a getter for the root
	 * @return just the root
	 */
	@Override
	public BinaryTreeNode getRoot() {
		return root;
	}
	/**
	 * This is a setter for the root which just calls the root i create to the root of the binary tree node
	 * @param root which is the binary tree node
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		// set the root to the root of tree node
		this.root = (DefaultBinaryTreeNode<T>) root;
	}
	/**
	 * This is the is empty method where it just returns if the root is null so if it is then it is null
	 * @return if the tree is null then it is empty 
	 */
	public boolean isEmpty() {

		// set the root to null
		return root == null;


	}
	/**
	 * This is the in order traversal where it is just creating a linked list called traversal that
	 * then prints out the traversal. 
	 * @return the traversal linked list created
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		// create a linked list called traversal
		LinkedList<T> traversal = new LinkedList<T>();
		// set it to root 
		inorderTraversal(root,traversal);
		// print out the traversal
		System.out.print(traversal);
		// creates the line break
		System.out.println();
		// return the traversal 
		return traversal;
	}
	/**
	 * This is the in order traversal where it is actually setting the node to left child and adding it to the size
	 * and then setting them to the right child. This basically adds it to where each dwarf is in the specific
	 * node it is supposed to be like left, root, right. 
	 * 
	 * @param node this is the binary tree node
	 * @param traversal for each type
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		// (left root right) 
		// bashful, doc, grumpy, dopey, happy, sleepy, sneezy

		// this is a checker so it goes all the way to the left
		if (node != null) {
			// creating the order
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.add(traversal.size(), node.getData());
			inorderTraversal(node.getRightChild(), traversal);
		}
	}
	/**
	 * This is the pre order traversal that just sets it and prints out the traversals from below method
	 * @return traversal of linked list
	 */
	public LinkedList <T>preorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		preorderTraversal(root,traversal);
		System.out.print(traversal);
		System.out.println();
		return traversal;

	}
	/**
	 * This is the in preorder traversal where it is just creating a linked list called traversal that
	 * then prints out the traversal.
	 * @param node this is the node of bin tree
	 * @param traversal the linked list type
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		// root, left, right
		// happy, doc, bashful, grumpy, dopey, sleepy, sneezy 

		// a checker where if it is not null
		if (node != null) {
			// adds it to size, gets left child, and right child
			traversal.add(traversal.size(), node.getData());
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(), traversal);
		}

	}
	/**
	 * This is the post over traversal where it creates a list traversal and then adds it to the root
	 * @return the traversal type of linked list
	 */
	public LinkedList <T>postorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		postorderTraversal(root,traversal);
		System.out.print(traversal );
		System.out.println();
		return traversal;
	}
	/**
	 * This is the post order traversal where it adds it to a specific order of left right and root. This 
	 * for gets the left child the right child then adds it. 
	 * @param node this is binary tree node
	 * @param traversal type of linked list
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		// left, right root
		// bashful, dopey, grumpy, doc, sneezy, sleepy, happy 

		// a checker where if the node is not null
		if (node != null) {
			// get left child, right child, and adds it
			postorderTraversal(node.getLeftChild(), traversal);

			postorderTraversal(node.getRightChild(), traversal);

			traversal.add(traversal.size(), node.getData());





		}
	}
}