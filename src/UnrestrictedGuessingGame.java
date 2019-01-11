import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import datastructures.BinaryTreeNode;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;


/**
 * This is the guessing game which is the restricted version. It goes based off 
 * what is put for the JLabel. Creates buttons and places them in it. It then
 * puts the main method in it as well. Creates the game basically and has
 * the view in it as well. 
 * @author sabrinahussaini
 *
 */
public class UnrestrictedGuessingGame extends GuessingGame implements ActionListener{
	// creates a button
	public JButton yes;
	// creates a button 
	public JButton no;
	// creates a button
	private JButton startOver;
	// creates a new panel that uses gridLayout
	public JPanel panel = new JPanel (new GridLayout(3,1));
	// fileReader named gameReader
	private FileReader gameReader;
	// creates a tree
	protected DefaultBinaryTree<String> tree;
	// creates a node
	protected BinaryTreeNode<String> node;

	// a panel for question
	JPanel question;

	// panel for userInput
	JPanel userInput;

	// text fields for questions answer and body
	JTextField question2 , answer, body;
	// panel for question panel
	JPanel questionPanel;

	// button for enter
	JButton enter; 


	/**
	 * The constructor for the restricted game. It adds all of the labels 
	 * and puts it into a label that uses html. It then sets color 
	 * and background. Then adds all of the parts into the specific places.
	 */
	public UnrestrictedGuessingGame(){
		// calls on the file reader to parse it
		super();
		gameReader=new FileReader();
		tree=gameReader.getTree();


		// creates a label that sets the font and then puts it all together
		JLabel answer = new JLabel ();
		answer.setFont(new Font("serif", Font.ROMAN_BASELINE, 20));
		answer.setText("<html>  Pick a Body: " 
				+ " Mars, Venus, Earth, mercury, ceres, jupiter, saturn, uranus, neptune, pluto, haumea, "
				+ "makemake, eris, sedna, titan, "
				+ "europa, sun, ganymede, barnards star, proxima, achernar, mimas, ariel</html>");
		answer.setForeground(Color.GRAY);
		answer.setBackground(Color.PINK);
		answer.setOpaque(true);


		// adds specific things to spots on the board
		add(answer, new BorderLayout().NORTH);
		add(createSettings(), new BorderLayout().SOUTH);
		add(question(), new BorderLayout().CENTER);


		// adds the gif to the center
		gifPan = gif();
		add(gifPan,BorderLayout.CENTER);
		gifPan.setBackground(Color.LIGHT_GRAY);

		// creates a panel for all of the settings
		gamePanel = new JPanel(new GridLayout(2,1));
		gamePanel.add(questionLabel);
		createSettings = createSettings();
		gamePanel.add(createSettings);
		add(gamePanel,BorderLayout.SOUTH);
		gamePanel.setBackground(Color.LIGHT_GRAY);








		refreshDisplay();   
	}	
	/**
	 * 
	 * This method is for the question panel which just consists of the question and where it will be located and stuff
	 * @return
	 */
	public JPanel QPanel() {
		questionPanel = new JPanel(new BorderLayout());
		//questionPanel.add(directions(), BorderLayout.NORTH);

		questionPanel.add(userInput());
		//questionPanel.add(createSettings(), BorderLayout.SOUTH);

		this.add(questionPanel, BorderLayout.EAST);

		return questionPanel;


	}
	/**
	 * this is for how to play the game and it uses string to create a new node then 
	 * set a node to specific thing. It sets new node to one and then the old one to another. 
	 * Creates room for the nodes on the left and right children for the program. 
	 * @param question2
	 * @param body
	 * @param answer
	 */
	public void howToPlay(String question2, String body, String answer) {
		BinaryTreeNode<String> n = new DefaultBinaryTreeNode<String>(null);

		n.setData(node.getData());
		if(answer.equals("yes")) {
			node.setData(body);
			BinaryTreeNode<String> userAnswer = new DefaultBinaryTreeNode<String>(null);

			userAnswer.setData(question2);
			node.setLeftChild(userAnswer);
			node.setRightChild(n);

		} else if (answer.equals("no")){
			node.setData(body);
			BinaryTreeNode<String> userAnswer = new DefaultBinaryTreeNode<String>(null);

			userAnswer.setData(question2);
			node.setRightChild(userAnswer);
			node.setLeftChild(n);
		} else {

			System.out.println("wrong answer");
		}

	}

	/**
	 * This class is for the user input which is what the text field consists of. it puts 
	 * specific directions on it and then adds it to the panel. Then creates a button that is then set 
	 * to program for the east direction. 
	 * @return the panel created
	 */
	public JPanel userInput() {
		// creates text fields
		question2 = new JTextField("Place what you were thinking of?");
		answer = new JTextField("Please give me a yes/no question ");
		body = new JTextField("Is the answer to your question yes or no?");
		// new panel
		userInput = new JPanel();
		userInput.setLayout(new GridLayout(4,1));
		// adds text field names to user input
		userInput.add(question2);
		userInput.add(answer);
		userInput.add(body);

		// creates the enter button
		enter = new JButton ("Enter"); 
		enter.addActionListener(this);
		enter.setBackground(Color.pink);
		enter.setOpaque(true);
		// adds the enter button to the user input panel. sets the background to it as well
		userInput.add(enter); 
		question2.setBackground(Color.PINK);
		question2.setOpaque(true);
		answer.setBackground(Color.PINK);
		answer.setOpaque(true);
		body.setBackground(Color.PINK);
		body.setOpaque(true);




		//userInput.add(comboBoxPanel);
		userInput.setBackground(Color.LIGHT_GRAY);


		return userInput;
	}


	/**
	 * refreshes the display
	 */
	public void refreshDisplay(){
		repaint();




	}
	/**
	 * This uses the buttons and places them on the JPanel created using
	 * a gridLayout. It also sets fonts and background. Paints the border as well.
	 * Then sets the action listener to this. And adds the buttons to the panel.
	 * @return returns the panel created
	 */

	private JPanel createSettings() {
		// creates panel and places in specific places
		JPanel settings = new JPanel(new GridLayout(3,1));                                                                                                                                                                                                                                           
		yes = new JButton("YES");
		no = new JButton("NO");
		startOver= new JButton("start Over");
		// sets the yes button to the background
		yes.setBackground(Color.pink);
		yes.setOpaque(true);
		yes.setBorderPainted(false);
		yes.setFont(new Font("impact", Font.ROMAN_BASELINE, 18));
		// sets the no button to color and font
		no.setBackground(Color.LIGHT_GRAY);
		no.setOpaque(true);
		no.setBorderPainted(false);
		no.setFont(new Font("impact", Font.ROMAN_BASELINE, 18));

		// sets the start over button
		startOver.setBackground(Color.pink);
		startOver.setOpaque(true);
		startOver.setBorderPainted(false);
		startOver.setFont(new Font("impact", Font.ROMAN_BASELINE, 18));

		// sets the buttons to action listener
		yes.addActionListener(this);
		no.addActionListener(this);
		startOver.addActionListener(this);


		// adds the buttons to panels 
		settings.add(yes);
		settings.add(no);
		settings.add(startOver);


		return settings;

	}
	/**
	 * Creates a JLabel for the question. Sets the root to the node. Creates 
	 * a new label.
	 * @return the label created
	 */
	private JLabel question() {
		node =  tree.getRoot();
		String nodeData= node.getData();
		questionLabel=new JLabel(nodeData);
		questionLabel.setFont(new Font("impact", Font.ROMAN_BASELINE, 20));
		questionLabel.setForeground(Color.white);


		return questionLabel;
	}

	/**
	 * this is the action performed. if the yes is pressed on then it does something
	 * then clicks on no button and sets it to something. Uses the left and righ
	 * children. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// yes button
		if (e.getSource()== (yes)) {
			if(node.getLeftChild()!=null) {
				node= node.getLeftChild();
				questionLabel.setText(node.getData());

			} else if (node.getLeftChild() == null) {

				questionLabel.setText("Good job");
			}
			// no button
		} else if (e.getSource() == (no)){
			if(node.getRightChild()!=null) {

				node= node.getRightChild();

				questionLabel.setText(node.getData());
			} else if (node.getRightChild()== null || node.getLeftChild() == null) {
				QPanel();

				questionLabel.setText("try again");


			}

			// sets start over button
		} else if (e.getSource() == startOver) {
			node = tree.getRoot();
			questionLabel.setText(node.getData());
			repaint();
			revalidate();
			if (node.isLeaf()) {
				question = QPanel();
				add(question , BorderLayout.CENTER);
				question.setVisible(true);
				revalidate();

			} else {

			} 
			// fix null pointer check if text exists
//			this.remove(questionPanel);
//			questionPanel.setVisible(false);
//			revalidate();

		} // the enter button for the program
		else if (e.getSource() == enter) {

			String newQuestion = question2.getText(); 
			String newAnswer = answer.getText(); 
			String newBody = body.getText(); 

			howToPlay(newQuestion, newAnswer, newBody); 
			System.out.print("yes");
		}


	}

	/**
	 * this creates the gif for the board. Uses imageIcon and
	 * sets it to name. creates label and panel then adds the panel to the label.
	 * @return the panel created
	 */
	private JPanel gif() {
		ImageIcon gif = new ImageIcon(getClass(). getResource("orig.gif"));
		JLabel labels = new JLabel(gif);
		JPanel pan = new JPanel();
		pan.add(labels);
		return pan;

	}



	/**
	 * a getter for the root. 
	 * @return the tree
	 */
	protected BinaryTreeNode<String> getRoot(){
		return tree.getRoot();
	}
}
