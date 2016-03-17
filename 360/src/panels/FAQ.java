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
		JTextArea area = new JTextArea("Frequently Asked Questions\n\n"
				+ "How do I get a picture to color?\n"
				+ "Click DOWNLOAD button above. You can then select the picture you want "
				+ "to color based on your age. The picture will open in your\nInternet browser"
				+ "window. Use the appropriate print option from your Internet browser in "
				+ "order to print a copy of the picture to color.\n\n"
				+ "What can I use to color my picture?\n"
				+ "Many people prefer to use colored pencils. Other populare optins are "
				+ "colored markers or gel pens. Feel free to go crazy and mix\nyour mediums!\n\n"
				+ "How creative can I be when coloring outside the lines?\n"
				+ "That's up to you. However, we will be reviewing all images for appropriateness.\n\n"
				+ "What do I do when I'm done coloring my picture?\n"
				+ "You can take a picture of the finished coloring or use a color scanner "
				+ "and email it to yourself so you can save it to your computer.\nTo submit your"
				+ "completed coloring for the contest, select the REGISTER button above. You will be "
				+ "asked some questions so we\ncan contact you if you are a winner. From the registration "
				+ "page, select the UPLOAD PICTURE button and locate the image where\nyou stored it on "
				+ "your computer. Be sure to read the Terms and Conditions and click the Agree box before"
				+ "you submit your\nregistration. Once you have completed your personal informtion, click "
				+ "the Agree button and uploaded your picture, don't forget\nto click the Submit button. "
				+ "You are then entered intot he contest.\n\n" 
				+ "Who has access to my registration information?\n"
				+ "Your registration information will be kept private. It is needed to "
				+ "identify your submission and notify you if you have one. The library\n"
				+ "administrator will be the only one that has access to this information.\n\n"
				+ "What are the terms and conditions of this contest?\n"
				+ "The terms and conditions are available on the Registration page. You must check that you "
				+ "agree to these terms and conditions\nbefore you will be able to submit your picture.\n\n"
				+ "When will I know if I won?\n"
				+ "Winners will be notified on April 15th. Don't get too excited, the prizes are nominal, so "
				+ "you won't win enough to pay your taxes.\n\n", 30, 65);
		
		area.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(area);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setSize(width, height);
		setBackground(Color.ORANGE);
		add(areaScrollPane);
	}
}
