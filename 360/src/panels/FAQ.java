/**
 * 
 */
package panels;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class FAQ extends JPanel {
	
	/**
	 * Constructor for the FAQ Panel which takes a width and Height for the Panel size.
	 * 
	 * @param width Given a Integer Param fitting the width of the Panel.
	 * @param height Given a Integer Parameter fitting the height of the Panel.
	 */
	public FAQ(int width, int height){
		JTextArea area = new JTextArea(
				"Frequently Asked Questions\n\n"
						+ "How do I get a picture to color?\n"
						+ "From the main page, select the Download button. You can then select the picture you want to color based on your age.\n\n"
						+ "What do I do when I'm done coloring my picture?\n"
						+ "You can take a picture of the finished coloring or use a color scanner and email it to yourself so you can save it to your computer. From the main page, select the Register button. You will be asked some questions so we can contact you if you are a winner. From the registration page, select the Upload button and locate the image where you stored it on your computer.\n\n" 
+ "Who has access to my registration information?\n"
+ "Your registration information will be kept private. It is needed to identify your submission and notify you if you have one. The library administrator will be the only one that has access to this information."\n\n,
				30, 65);
		area.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(area);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setSize(width, height);
		setBackground(Color.ORANGE);
		add(areaScrollPane);
	}
}
