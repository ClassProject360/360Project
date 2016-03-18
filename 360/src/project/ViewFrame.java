/**
 * 
 */

package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import panels.About;
import panels.Download;
import panels.FAQ;
import panels.Login;
import panels.Register;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame {

	private JPanel buttonPanel;
	private JButton download;
	private JButton register;
	private JButton about;
	private JButton faq;
	private JButton login;
	private JButton logout;

	// width and height of JFrame
	private int height = 600;
	private int width = 800;
	
	/**
	 * Constructor Class creates the overall Frame of the Program.
	 */
	public ViewFrame(){
		super("Welcome to B#'s Coloring Contest", null);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		buttomset();
		printAll(getGraphics());
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
		logout = new JButton("Log out");

		buttonPanel.add(Box.createVerticalStrut(5));
		buttonPanel.add(download);
		buttonPanel.add(register);
		buttonPanel.add(faq);
		buttonPanel.add(about);
		buttonPanel.add(Box.createVerticalStrut(5));
		buttonPanel.add(login);

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(about(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(register(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});
		download.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(download(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});
		faq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(faq(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(logIn(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(logIn(), BorderLayout.CENTER);
				getContentPane().add(buttonPanel, BorderLayout.NORTH);
				printAll(getGraphics());
			}
		});

		add(buttonPanel, BorderLayout.NORTH);
		add(about(), BorderLayout.CENTER);
	}

	/**
	 * About panel that give all the information to the user when they enter to the program
	 * @return about panel
	 */
	private JPanel about() {
		About aboutPanel = new About(width, height);
		return aboutPanel;
	}

	/**
	 *  download panel that provide picture all the picture to user to download
	 * @return download panel
	 */
	protected JPanel download() {
		Download downPanel = new Download(width, height);
		return downPanel;
	}

	/**
	 * register panel that correct all user infor and picture.
	 * @return register panel
	 */
	protected JPanel register() {
		Register regisPanel = new Register(width, height);
		return regisPanel;
	}

	/**
	 * FAQ panel that dispalys Frequently Asked Questions.
	 * 
	 * @return FAQ panel information.
	 */
	private JPanel faq() {
		FAQ faqPanel = new FAQ(width,height);
		return faqPanel;
	}

	/**
	 * login panel will display after click "log in" button
	 * @return login panel
	 */
	private JPanel logIn() {
		Login loginPanel = new Login(width, height, logout, this);
		return loginPanel;
	}
	
	public void removeButtonMenu(){
			remove(buttonPanel);
	}
	
}
