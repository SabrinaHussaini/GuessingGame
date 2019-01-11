import javax.print.Doc;
import javax.xml.parsers.*;

import org.xml.sax.SAXException;

import datastructures.BinaryTreeNode;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;



import org.w3c.dom.*;

import java.io.*;
/**
 * this class basically helps print out the whole question and answer thing for the colleges. 
 * It uses the founders thing that was already created and then prints out each one by using
 * S.O.P's throughout to show each one. 
 * @author Sabrina Hussaini
 * 
 *
 */
public class FileReader {
	// creates a tree
	private static  DefaultBinaryTree<String> binaryTree;
	/**
	 * This is the main method for the program and it uses the whole try and catch thing
	 * that was presented to us so it catches the errors. 
	 * 
	 * @param args the argument for string
	 */
	public FileReader(){
		//Setup XML Document and catches specific things to help run it

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("office.xml" );
			Document document = builder.parse( xmlFile );
			parseFounderFile(document); 
			//code that may cause an exception
		} catch (ParserConfigurationException pce) {
			//what to do if this exception happens
			System.out.println(pce);

		} catch (SAXException saxe) {				
			System.out.println(saxe);

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	/**
	 * This is the parse founder file, but i did not change it because this was givent to us so
	 * it is not my work. 
	 * @param the document name doc
	 */
	private static void parseFounderFile( Document doc ){
		// new tree called binaryTree
		binaryTree = new DefaultBinaryTree<String>();
		// gets the doc root
		Element root = doc.getDocumentElement();
		// sets the root
		binaryTree.setRoot(questionNode(root));

	}
	/**
	 * This method point prints out the elements and uses print statements and if statements
	 * to help do it. It uses elements that was presented to us, and then the whole has attribute which
	 * was also given to us. 
	 * 
	 * @param n this is just the node 
	 * @return the question node
	 */
	private static DefaultBinaryTreeNode<String> questionNode(Element node){
		// the question string is equaled to the tag name
		if( node.getTagName().equals("question")){
			// creates the tree node
			DefaultBinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>(null);
			// gets attribute id
			questionNode.setData(node.getAttribute("Q"));
			// if it has a child then 
			if (node.hasChildNodes()){
				NodeList childs =  node.getChildNodes();
				// goes through the entire node list and calls parse node on it 
				for (int i = 0; i < childs.getLength(); i++){
					if (childs.item(i) instanceof Element) {
						Element childElt = (Element) childs.item(i);
						if ( childElt.getAttribute("input").equals("yes")) {
							questionNode.setLeftChild(answerNode((Element) childElt));

						}

						else {
							questionNode.setRightChild(answerNode((Element) childElt));
						}
					}
				}
			}
			return questionNode;
		}

		return null;

	}
	/**
	 * The answer node for the file reader. It gets the yes or no strings used
	 * and then if it has a child then it gets it. Goes through all of the
	 * children and then gets the tag names. 
	 * @param node the element 
	 * @return the binary tree node
	 */
	private static BinaryTreeNode<String> answerNode(Element node) {
		// creates the tree node called questionNode
		DefaultBinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>(null);
		// if yes or no tag names exist then it gets the child node
		if(node.getTagName().equals("yes")|| node.getTagName().equals("no")){
			// child nodes has the node 
			if(node.hasChildNodes()){
				//the list of children nodes
				NodeList child = node.getChildNodes();
				//run a for loop through the list 
				for(int i=0; i<child.getLength(); i++){
					if( child.item(i) instanceof Element){

						Element currentElt = (Element)child.item(i);

						if(currentElt.getTagName().equals("guess")){
							questionNode.setData(currentElt.getAttribute("text"));
						}
						else{
							questionNode= questionNode(currentElt);
						}
					}
				}
			}
		}
		return questionNode;
	}
	/**
	 * A getter for the tree which returns the tree after
	 * @return the tree created
	 */
	public DefaultBinaryTree<String> getTree(){
		return binaryTree;
	}

}
