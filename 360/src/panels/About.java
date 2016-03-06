/* 
 * 
 */
package panels;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class About extends JPanel {
	/**
	 * Constructor that creates the About main panel seen upon logging into the program.
	 * 
	 * @param width
	 * @param height
	 */
	public About(int width, int height){
		setBackground(Color.GREEN.brighter());
	}
}
