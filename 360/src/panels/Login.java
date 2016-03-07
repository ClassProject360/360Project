/**
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Login extends JPanel {
	private String judgeName1 = "judgeone";
	private String judgeName2 = "judgetwo";
	private String judgeName3 = "judgethree";
	private String judgeName4 = "judgefour";
	private String judgePassword = "1234";
	private int myWidth;
	private int myHeight;
	private JButton myLogout;
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Login(int width, int height, JButton logout) {
		myWidth = width;
		myHeight = height;
		myLogout = logout;
		setBackground(Color.RED);
		
		Font font2 = new Font("SansSerif", Font.BOLD, 20);
		
		JPanel insideLoginPanel = new JPanel();
		insideLoginPanel.setBackground(Color.RED);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel namelabel = new JLabel("User ID: ", JLabel.RIGHT);
		namelabel.setFont(font2);
		JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
		passwordLabel.setFont(font2);
		JTextField userText = new JTextField(6);
		userText.setFont(font2);
		JPasswordField passwordText = new JPasswordField(6);
		passwordText.setFont(font2);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(font2);
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// check the user name and password
				if(userText.getText().equals(judgeName1)
						||userText.getText().equals(judgeName2)
						|| userText.getText().equals(judgeName3) 
						|| userText.getText().equals(judgeName4) 
						&& passwordText.getPassword().equals(judgePassword)){
					
					// switch to the judge panel
					removeAll();
					add(judge(),BorderLayout.CENTER);
					updateUI();
				} else {
					JOptionPane.showMessageDialog (null, "Incorrect Username or Password",
							 "Warnning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		add(Box.createVerticalStrut(180));
		insideLoginPanel.add(namelabel);
		insideLoginPanel.add(userText);
		insideLoginPanel.add(passwordLabel);
		insideLoginPanel.add(passwordText);
		insideLoginPanel.add(loginButton);

		add(insideLoginPanel, BorderLayout.CENTER);
	}

	/**
	 * Judge panel that access after pass the login process. 
	 * @return judge panel
	 */
	private JPanel judge() {
		Judge judgePanel = new Judge(myWidth, myHeight, myLogout);
		return judgePanel;
	}
}
