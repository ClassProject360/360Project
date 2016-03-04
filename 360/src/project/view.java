package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class view {
	private JFrame mainFrame;

	private JPanel buttonPanel;
	private JPanel downPanel;
	private JPanel regisPanel;
	private JPanel faqPanel;
	private JPanel aboutPanel;
	private JPanel infor;
	private JPanel term;
	private JPanel submitPanel;
	private JPanel loginPanel;
	private JPanel insideLoginPanel;
	private JPanel judgePanel;

	private JButton download;
	private JButton register;
	private JButton about;
	private JButton faq;
	private JButton submit;
	private JButton login;
	private JButton imagedow1;
	private JButton imagedow2;
	private JButton imagedow3;
	private JButton imagedow4;
	private JButton loginButton;
	private JButton logoutButton;

	private JLabel nameLabel;
	private JLabel latNameLabel;
	private JLabel ageLabel;
	private JLabel sexLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel agreeLabel;
	private JLabel passwordLabel;

	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel image4;
	private JLabel namelabel;

	private JTextField nameTextField;
	private JTextField latNameTextField;
	private JTextField ageTextField;
	private JTextField sexTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField zipTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;
	private JTextField userText;
	private JPasswordField passwordText;

	private JCheckBox agree;
	
	private String judgeName1;
	private String judgeName2;
	private String judgeName3;
	private String judgeName4;
	private String judgePassword;

	// width and height of JFrame
	private int high = 600;
	private int width = 800;

	// connect to registerInfor class to pass customer information
	private registerInfor passinfor;

	/**
	 * set up the JFrame and component 
	 */
	public void mainForm() {
		mainFrame = new JFrame("Welcome to B#");
		mainFrame.setSize(width, high);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		buttomset();
		mainFrame.printAll(mainFrame.getGraphics());
		judgeName1 = "judgeone";
		judgeName2 = "judgetwo";
		judgeName3 = "judgethree";
		judgeName4 = "judgefour";
		judgePassword = "1234";
	}

	/**
	 * button set up  at the top of the program
	 */
	public void buttomset() {

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		download = new JButton("Download");
		register = new JButton("Register");
		about = new JButton("About");
		faq = new JButton("FAQ");
		login = new JButton("Log In");

		buttonPanel.add(Box.createVerticalStrut(5));
		buttonPanel.add(download);
		buttonPanel.add(register);
		buttonPanel.add(faq);
		buttonPanel.add(about);
		buttonPanel.add(Box.createVerticalStrut(5));
		buttonPanel.add(login);

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(about(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(register(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});
		download.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(download(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});
		faq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(faq(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(logIn(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});

		mainFrame.add(buttonPanel, BorderLayout.NORTH);
		mainFrame.add(about(), BorderLayout.CENTER);

	}

	/**
	 * about panel that give all the information to the user when they enter to the program
	 * @return about panel
	 */
	public JPanel about() {
		aboutPanel = new JPanel();
		aboutPanel.setBackground(Color.GREEN.brighter());

		return aboutPanel;
	}

	/**
	 *  download panel that provide picture all the picture to user to download
	 * @return download panel
	 */
	public JPanel download() {
		downPanel = new JPanel();
		downPanel.setBackground(Color.BLUE);
		downPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		ImageIcon imageIcon = new ImageIcon("src/image/1.png");
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

		ImageIcon imageIcon2 = new ImageIcon("src/image/2.png");
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

		ImageIcon imageIcon3 = new ImageIcon("src/image/3.png");
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

		ImageIcon imageIcon4 = new ImageIcon("src/image/4.png");
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
		downPanel.add(image1, c);
		c.gridx = 1;
		downPanel.add(image2, c);

		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 0;
		c.ipadx = 0;
		downPanel.add(imagedow1, c);
		c.gridx = 1;
		downPanel.add(imagedow2, c);

		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		c.ipadx = 80;
		downPanel.add(image3, c);
		c.gridx = 1;
		downPanel.add(image4, c);

		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 0;
		c.ipadx = 0;
		downPanel.add(imagedow3, c);
		c.gridx = 1;
		downPanel.add(imagedow4, c);

		return downPanel;
	}

	/**
	 * register panel that correct all user infor and picture.
	 * @return register panel
	 */
	public JPanel register() {
		regisPanel = new JPanel();
		regisPanel.setBackground(Color.GRAY);

		infor = new JPanel(new GridLayout(5, 4));

		Font font1 = new Font("SansSerif", Font.BOLD, 20);

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(font1);
		nameTextField = new JTextField();
		nameTextField.setFont(font1);
		infor.add(nameLabel);
		infor.add(nameTextField);

		latNameLabel = new JLabel("Last Name:");
		latNameLabel.setFont(font1);
		latNameTextField = new JTextField();
		latNameTextField.setFont(font1);
		infor.add(latNameLabel);
		infor.add(latNameTextField);

		ageLabel = new JLabel("Age:");
		ageTextField = new JTextField();
		ageLabel.setFont(font1);
		ageTextField.setFont(font1);
		infor.add(ageLabel);
		infor.add(ageTextField);

		sexLabel = new JLabel("Sex:");
		sexTextField = new JTextField();
		sexLabel.setFont(font1);
		sexTextField.setFont(font1);
		infor.add(sexLabel);
		infor.add(sexTextField);

		addressLabel = new JLabel("Address:");
		addressTextField = new JTextField();
		addressLabel.setFont(font1);
		addressTextField.setFont(font1);
		infor.add(addressLabel);
		infor.add(addressTextField);

		cityLabel = new JLabel("City:");
		cityTextField = new JTextField();
		cityLabel.setFont(font1);
		cityTextField.setFont(font1);
		infor.add(cityLabel);
		infor.add(cityTextField);

		stateLabel = new JLabel("State:");
		stateTextField = new JTextField();
		stateLabel.setFont(font1);
		stateTextField.setFont(font1);
		infor.add(stateLabel);
		infor.add(stateTextField);

		zipLabel = new JLabel("Zip code:");
		zipTextField = new JTextField();
		zipLabel.setFont(font1);
		zipTextField.setFont(font1);
		infor.add(zipLabel);
		infor.add(zipTextField);

		phoneLabel = new JLabel("Phone Number:");
		phoneTextField = new JTextField();
		phoneLabel.setFont(font1);
		phoneTextField.setFont(font1);
		infor.add(phoneLabel);
		infor.add(phoneTextField);

		emailLabel = new JLabel("Email:");
		emailTextField = new JTextField();
		emailLabel.setFont(font1);
		emailTextField.setFont(font1);
		infor.add(emailLabel);
		infor.add(emailTextField);

		// panel for the term agreement
		term = new JPanel();
		JTextArea area = new JTextArea(
				" Agreement Term ..............................\n"
						+ "................................................\n"
						+ " ...............................................\n"
						+ "................................................\n"
						+ "................................................\n"
						+ ".................................................",
				10, 65);
		area.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(area);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setSize(width, high);
		term.add(areaScrollPane, BorderLayout.CENTER);

		// part 3 agree check box and submit button
		agree = new JCheckBox();

		agreeLabel = new JLabel("Agree");

		submit = new JButton("Submit!!");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// all this comment is to check if user enter all the infor and check agree

				// if(!nameTextField.getText().equals("") &&
				// !latNameTextField.getText().equals("")
				// && !ageTextField.getText().equals("") &&
				// !sexTextField.getText().equals("")
				// && !addressTextField.getText().equals("") &&
				// !cityTextField.getText().equals("")
				// && !stateTextField.getText().equals("") &&
				// !zipTextField.getText().equals("")
				// && !phoneTextField.getText().equals("") &&
				// !emailTextField.getText().equals("")){
				// if(agree.isSelected()){
				passinfor = new registerInfor();
				passinfor.cusInfor(nameTextField.getText(),
						latNameTextField.getText(), ageTextField.getText(),
						sexTextField.getText(), addressTextField.getText(),
						cityTextField.getText(), stateTextField.getText(),
						zipTextField.getText(), phoneTextField.getText(),
						emailTextField.getText());
				// } else {
				// JOptionPane.showMessageDialog (null, "Please Check Agree",
				// "Before Move on", JOptionPane.INFORMATION_MESSAGE);
				// }
				//
				// } else {
				// JOptionPane.showMessageDialog (null,
				// "Please Fill out your information",
				// "Before Move on", JOptionPane.INFORMATION_MESSAGE);
				// }
			}
		});

		submitPanel = new JPanel(new GridLayout(1, 3));

		submitPanel.add(agree);
		submitPanel.add(agreeLabel);
		submitPanel.add(submit);
		// you may need to add the upload picture thing in the submitPanel
		//-------------------------------------------------------------------------
		
		//-------------------------------------------------------------------------
		
		// set the size of submitPanel
		submitPanel.setPreferredSize(new Dimension(300, 50));
		// set the size of inforPanel
		infor.setPreferredSize(new Dimension(740, 250));

		// add all 3 part to regisPanel
		regisPanel.add(infor, BorderLayout.NORTH);
		regisPanel.add(term, BorderLayout.CENTER);
		regisPanel.add(submitPanel, BorderLayout.SOUTH);
		return regisPanel;
	}

	/**
	 * FAQ panel 
	 * @return faq panel
	 */
	public JPanel faq() {
		faqPanel = new JPanel();
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
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setSize(width, high);
		faqPanel.setBackground(Color.ORANGE);
		faqPanel.add(areaScrollPane);

		return faqPanel;
	}

	/**
	 * login panel will display after click "log in" button
	 * @return login panel
	 */
	public JPanel logIn() {
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.RED);
		
		Font font2 = new Font("SansSerif", Font.BOLD, 20);
		
		insideLoginPanel = new JPanel();
		insideLoginPanel.setBackground(Color.RED);
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

		namelabel = new JLabel("User ID: ", JLabel.RIGHT);
		namelabel.setFont(font2);
		passwordLabel = new JLabel("Password: ", JLabel.CENTER);
		passwordLabel.setFont(font2);
		userText = new JTextField(6);
		userText.setFont(font2);
		passwordText = new JPasswordField(6);
		passwordText.setFont(font2);

		loginButton = new JButton("Login");
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
					mainFrame.getContentPane().removeAll();
					mainFrame.getContentPane().add(judge(), BorderLayout.CENTER);
					mainFrame.printAll(mainFrame.getGraphics());
					
				} else {
					JOptionPane.showMessageDialog (null, "Incorrect Username or Password",
							 "Warnning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		loginPanel.add(Box.createVerticalStrut(180));
		insideLoginPanel.add(namelabel);
		insideLoginPanel.add(userText);
		insideLoginPanel.add(passwordLabel);
		insideLoginPanel.add(passwordText);
		insideLoginPanel.add(loginButton);

		loginPanel.add(insideLoginPanel, BorderLayout.CENTER);

		return loginPanel;
	}
	
	/**
	 * Judge panel that access after pass the login process. 
	 * @return judge panel
	 */
	public JPanel judge() {
		judgePanel = new JPanel();
		judgePanel.setBackground(Color.PINK);
		
		logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(about(), BorderLayout.CENTER);
				mainFrame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
				mainFrame.printAll(mainFrame.getGraphics());
			}
		});
		
		judgePanel.add(logoutButton);
		
		return judgePanel;
	}

}
