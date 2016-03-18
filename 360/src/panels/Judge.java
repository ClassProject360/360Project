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
import java.io.FileNotFoundException;
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
	private String imgPath = "../360/submissions/ID_";
	private StringBuilder data = new StringBuilder();

	public Judge(int width, int height, JButton logout) {
		setBackground(Color.PINK.darker().darker());
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		
		// check the number of user
		regis = new registerInfor();
		try {
			String temp = regis.getFile();
			data.append(temp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			line = regis.numofline();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// List of User id
		userId = new DefaultListModel<String>();
		
		// Add user id to the list
		for(int i=0; i < line; i++){
			if(-1 != data.indexOf("Score" + (i+1) + ": 0"))
				userId.addElement(" ID: " + (i+1) + " ");
		}
		if (userId.isEmpty()){
			userId.addElement("");
			JLabel graded = new JLabel("Nothing to Grade either the contest is done or no one has submitted any images.");
			userPictureLabel = graded;
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
		ImageIcon imageIcon;
		if(userId.firstElement() == ""){
			imageIcon = new ImageIcon(imgPath+ "1.png");
		} else
			imageIcon = new ImageIcon(imgPath + idList.getSelectedValue().charAt(5)+ ".png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(600, 400,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		userPictureLabel = new JLabel(imageIcon);
		

		
		idList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				ImageIcon temp1 = new ImageIcon(imgPath + idList.getSelectedValue().charAt(5)+ ".png");
				Image temp2 = temp1.getImage(); // transform it
				Image temp3 = temp2.getScaledInstance(600, 400,
						java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				temp1.setImage(temp3);
				userPictureLabel.setIcon(temp1);
				userPictureLabel.updateUI();
			}
		});
		
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
				if(!scoreTextField.getText().equals("")){
					int tempNumb = scoreTextField.getText().charAt(0);
					if(scoreTextField.getText().equals("") || tempNumb > 57 || tempNumb < 49){
						JOptionPane.showMessageDialog (null,
								 "Please select a score between 1 and 10",
								 "Before Move on", JOptionPane.INFORMATION_MESSAGE);
					}else{
						int temp = data.indexOf("Score"+ idList.getSelectedValue().charAt(5)+ ": 0");
						if(temp != -1){
						data.replace(temp, temp+9, "Score" + idList.getSelectedValue().charAt(5) + ": " + scoreTextField.getText());
						try {
							regis.updateData(data.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
						scoreTextField.setText("");
						} else
							JOptionPane.showMessageDialog (null,
									 "Apparently you have already graded this image, these aren't the droids you're looking for move along. "
									 + "When done grading log out the next time logging in graded entries will be removed.",
									 "Double Grading Move Along", JOptionPane.INFORMATION_MESSAGE);
					}
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
        	updateLabel(userId.elementAt(idList.getSelectedIndex()));
        }
        
		if (userId.firstElement() == ""){
			JLabel graded = new JLabel("Nothing to Grade either the contest is done or no one has submitted projects.");
			userPictureLabel = graded;
			userInforPane.removeAll();
			userInforPane.add(graded, BorderLayout.CENTER);
			userPictureLabel.repaint();
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
