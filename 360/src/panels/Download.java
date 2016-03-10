/**
 * 
 */
package panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Download extends JPanel {
	private JButton imagedow1;
	private JButton imagedow2;
	private JButton imagedow3;
	private JButton imagedow4;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel image4;
	
	public Download(int width, int height) {
		setBackground(Color.BLUE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();

		ImageIcon imageIcon = new ImageIcon("src/image/1image.png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(300, 200,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		image1 = new JLabel(imageIcon);

		imagedow1 = new JButton("Download for age under 7 yesrs old");
		imagedow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://coloradocranes.net/wp-content/uploads/coloring-contest-2015.pdf";
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon imageIcon2 = new ImageIcon("src/image/2image.png");
		Image image22 = imageIcon2.getImage(); // transform it
		Image newimg2 = image22.getScaledInstance(300, 200,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon2 = new ImageIcon(newimg2); // transform it back

		image2 = new JLabel(imageIcon2);
		imagedow2 = new JButton("Download for ages from 8 to 15 years old");
		imagedow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://www.cisdem.com/temp/blog-files/secret-garden-5.pdf";
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon imageIcon3 = new ImageIcon("src/image/3image.png");
		Image image23 = imageIcon3.getImage(); // transform it
		Image newimg3 = image23.getScaledInstance(300, 200,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon3 = new ImageIcon(newimg3); // transform it back

		image3 = new JLabel(imageIcon3);
		imagedow3 = new JButton("Download for age 16 to 30 years old");
		imagedow3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://www.cisdem.com/temp/blog-files/secret-garden-4.pdf";
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon imageIcon4 = new ImageIcon("src/image/4image.png");
		Image image24 = imageIcon4.getImage(); // transform it
		Image newimg4 = image24.getScaledInstance(300, 200,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon4 = new ImageIcon(newimg4); // transform it back

		image4 = new JLabel(imageIcon4);
		imagedow4 = new JButton("Download for age 31 years old and up");
		imagedow4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://www.cisdem.com/temp/blog-files/secret-garden-2.pdf";
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// set up the layout on gridLayout
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;
		c.ipadx = 80;
		add(image1, c);
		c.gridx = 1;
		add(image2, c);

		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 0;
		c.ipadx = 0;
		add(imagedow1, c);
		c.gridx = 1;
		add(imagedow2, c);

		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		c.ipadx = 80;
		add(image3, c);
		c.gridx = 1;
		add(image4, c);

		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 0;
		c.ipadx = 0;
		add(imagedow3, c);
		c.gridx = 1;
		add(imagedow4, c);
	}
}
