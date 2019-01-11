import javax.swing.JFrame;
/**
 * this is the unrestricted application for the program. Sets the frame
 * and size then adds the unrestricted guessing game to the board. Consists
 * of the main method. 
 * @author sabrinahussaini
 *
 */
public class UnrestrictedApplication {

	protected FileReader fileReader;
	/**
	 * this is constructor for the application and it sets the board and whatnot
	 */
	public UnrestrictedApplication(){
		//fileReader = new FileReader();
		JFrame questionBoard = new JFrame ("Twenty Question Game Unrestricted");
		questionBoard.setSize(600,600);
		questionBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		questionBoard.add(new UnrestrictedGuessingGame());
		questionBoard.setVisible(true);

	}
	/**
	 * the main method for the unrestricted portion of the game. 
	 * @param args the string
	 */
	public static void main(String[] args) {

		new UnrestrictedApplication();

	}



}


