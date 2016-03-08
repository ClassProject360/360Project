/**
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project.registerInfor;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Register extends JPanel {
	private JPanel infor;
	private JPanel term;
	private JPanel submitPanel;
	
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
	private JButton submit;
	
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
	private JCheckBox agree;
	
	// connect to registerInfor class to pass customer information
	private registerInfor passinfor;

	public Register(int width, int height) {
		setBackground(Color.GRAY);

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
		areaScrollPane.setSize(width, height);
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
				nameTextField.setText("");
				latNameTextField.setText("");
				ageTextField.setText("");
				sexTextField.setText("");
				addressTextField.setText("");
				cityTextField.setText("");
				stateTextField.setText("");
				zipTextField.setText(""); 
				phoneTextField.setText("");
				emailTextField.setText("");
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
		add(infor, BorderLayout.NORTH);
		add(term, BorderLayout.CENTER);
		add(submitPanel, BorderLayout.SOUTH);
	}
}
