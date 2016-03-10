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
				" Question ask ..........................................................."
						+ ".............................................................."
						+ "................................................................\n"
						+ ".................................................................."
						+ "................................................................\n"
						+ "....................................................................",
				30, 65);
		area.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(area);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setSize(width, height);
		setBackground(Color.ORANGE);
		add(areaScrollPane);
	}
}
