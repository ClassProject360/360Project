/** 
 * Main page that display information of this program
 * Author: Richard Ung.
 */
package panels;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class About extends JPanel {
	
	private JLabel imageLabel;
	/**
	 * Constructor that creates the About main panel seen upon logging into the program.
	 * 
	 * @param width
	 * @param height
	 */
	public About(int width, int height){
		setBackground(Color.GREEN.brighter());
		
		ImageIcon imageIcon = new ImageIcon("src/image/about.png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(780, 525,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		imageLabel = new JLabel(imageIcon);
		
		add(imageLabel);
	}
}
