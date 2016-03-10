/*
 * 
 */
package panels;

//import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Judge extends JPanel {

	public Judge(int width, int height, JButton logout) {
		setBackground(Color.PINK);
		
		add(logout);
	}
}
