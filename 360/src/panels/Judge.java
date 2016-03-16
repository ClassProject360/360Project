/*
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.registerInfor;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Judge extends JPanel implements ListSelectionListener {
	private int line;	
	private JList<String> idList;
	private JPanel userInforPane;
	private DefaultListModel<String> userId;
	private JScrollPane idScrollPane;
	private JSplitPane splitPane;
	private registerInfor regis;
	private JLabel userPictureLabel;
	private JPanel scorePanel;
	private JTextField scoreTextField;
	private JButton submitButton;

	public Judge(int width, int height, JButton logout) {
		setBackground(Color.PINK.darker().darker());
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		
		// check the number of user
		regis = new registerInfor();
		try {
			line = regis.numofline();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// List of User id
		userId = new DefaultListModel<String>();
		
		// Add user id to the list
		for(int i=0; i < line; i++){
			userId.addElement(" ID: " + (i+1) + " ");
		}
		
		//add id data to the list--------------------------------------------------
		idList = new JList<String>(userId);
		idList.setFont(font1);
		idList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		idList.setSelectedIndex(0);
		idList.addListSelectionListener(this);
		
		// add JList to the ScrollPane
		idScrollPane = new JScrollPane(idList);
		
		
		// user information and picture
		userInforPane = new JPanel();
		
		// display picture -------------------------------------
		ImageIcon imageIcon = new ImageIcon("src/image/1.png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(600, 400,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		userPictureLabel = new JLabel(imageIcon);		
		
		// add component to userInforPane panel----------------------------------------------
		userInforPane.add(userPictureLabel, BorderLayout.CENTER);
		userInforPane.setBackground(Color.GRAY);
		
		// display score information----------------------------------
		scorePanel = new JPanel();
		scoreTextField = new JTextField();
		scoreTextField.setPreferredSize(new Dimension(100, 35));
		scoreTextField.setFont(font1);
		scorePanel.add(scoreTextField, BorderLayout.SOUTH);
			
		submitButton = new JButton("Submit");

		submitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(scoreTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog (null,
							 "Please select the score!! ",
							 "Before Move on", JOptionPane.INFORMATION_MESSAGE);
				}else{
					scoreTextField.setText("");
					System.out.println("Score: " + scoreTextField.getText() );
				}
				
			}
		});

		scorePanel.add(submitButton);
		userInforPane.add(scorePanel, BorderLayout.SOUTH);
		
		//split Panel--------------------------------------------------------------------------
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, idScrollPane,
				userInforPane);
		splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        splitPane.setPreferredSize(new Dimension(800, 480));
       
        //Check if there is a data or not -------------------------------------------
        if (line == 0){
        	submitButton.setEnabled(false);
        	scoreTextField.setEnabled(false);
        }else {
        	//useerInforAea.setText(regis.readfromLine(0));
        	updateLabel(userId.elementAt(idList.getSelectedIndex()));
        }
        
		add(splitPane);
		add(logout, BorderLayout.SOUTH);
	}
	private void updateLabel(String elementAt) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * change the user information in the JTextArea when judge click select on id
	 */
	public void valueChanged(ListSelectionEvent e) {     
		//useerInforAea.setText(regis.readfromLine(idList.getSelectedIndex()));
	}
}
