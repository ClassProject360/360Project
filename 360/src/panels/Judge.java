/*
 * 
 */
package panels;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Judge extends JPanel {

	public Judge(int width, int height) {
		setBackground(Color.PINK);
		JButton logoutButton = new JButton("Log Out");
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getContentPane().removeAll();
				//getContentPane().add(about(), BorderLayout.CENTER);
				//getContentPane().add(buttonPanel, BorderLayout.NORTH);
				//printAll(getGraphics());
			}
		});
		
		add(logoutButton);
	}
}
