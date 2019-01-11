import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;




/**
 * This is the guessing game which is the restricted version. It goes based off 
 * what is put for the JLabel. Creates buttons and places them in it. It then
 * puts the main method in it as well. Creates the game basically and has
 * the view in it as well. 
 * @author sabrinahussaini
 *
 */
public class GuessingGame extends JPanel implements ActionListener{
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

	JPanel gamePanel, createSettings;
	// creates a JLabel
	JLabel instructions;
	// creates a text area
	JTextArea question;
	// creates a JLabel
	JLabel questionLabel;
	// creates a gif panel
	JPanel gifPan;
	/**
	 * The constructor for the restricted game. It adds all of the labels 
	 * and puts it into a label that uses html. It then sets color 
	 * and background. Then adds all of the parts into the specific places.
	 */
	public GuessingGame(){
		// calls on the file reader to parse it
		super(new BorderLayout());
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


		gamePanel = new JPanel(new GridLayout(2,2));
		gamePanel.add(questionLabel);
		createSettings = createSettings();
		gamePanel.add(createSettings);
		add(gamePanel,BorderLayout.SOUTH);
		gamePanel.setBackground(Color.LIGHT_GRAY);




		refreshDisplay();   
	}	


	/**
	 * This is the main method for the restricted portion of the program. It creates the new JFrame and
	 * it sets its size. It then adds the guessing game to the JFrame created. Sets it visible
	 * and then sets the default operation. 
	 * @param args the string argument used
	 */
	public static void main(String[] args) {
		// new JFrame for the program called question board
		JFrame questionBoard = new JFrame ("Twenty Question Game");

		questionBoard.setSize(600,500);

		questionBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		questionBoard.add(new GuessingGame());

		questionBoard.setVisible(true);

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
		if (e.getSource().equals(yes)) {
			if(node.getLeftChild()!=null) {
				node= node.getLeftChild();

				questionLabel.setText(node.getData());
			} else if (node.getLeftChild() == null) {

				questionLabel.setText("Good job");
				System.out.print(node.getData());
			}
			// no button
		} else if (e.getSource().equals(no)){
			if(node.getRightChild()!=null) {

				node= node.getRightChild();

				questionLabel.setText(node.getData());
			} else if (node.getRightChild()== null || node.getLeftChild() == null) {


				questionLabel.setText("try again");

				System.out.print(node.getData());



			}


			// sets start over button
		} else if (e.getSource().equals(startOver)){
			node = tree.getRoot();
			questionLabel.setText(node.getData());
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
