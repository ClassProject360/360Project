/* 
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.registerInfor;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Admin extends JPanel implements ListSelectionListener {
	
	private int line;	
	private JList<String> idList;
	private JPanel userInforPane;
	private DefaultListModel<String> userId;
	private JScrollPane idScrollPane;
	private JSplitPane splitPane;
	private registerInfor regis;
	private JLabel userPictureLabel;
	private JTextArea useerInforAea;
	private String imgPath = "../360/submissions/ID_";
	/**
	 * Constructor that creates the About main panel seen upon logging into the program.
	 * 
	 * @param width
	 * @param height
	 */
	public Admin(int width, int height, JButton logout){
		setBackground(Color.BLUE.brighter().brighter());
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
		
		// display user information----------------------------------
		useerInforAea = new JTextArea(6, 6);
		useerInforAea.setFont(font1);
		useerInforAea.setPreferredSize(new Dimension(570, 70));
		useerInforAea.setEditable(false);
		useerInforAea.setLineWrap(true);
		
		// display picture -------------------------------------
		ImageIcon imageIcon = new ImageIcon(imgPath + (idList.getSelectedIndex()+1)+ ".png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(450, 300,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		userPictureLabel = new JLabel(imageIcon);	
		
		idList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				ImageIcon temp1 = new ImageIcon(imgPath + (idList.getSelectedIndex()+1)+ ".png");
				Image temp2 = temp1.getImage(); // transform it
				Image temp3 = temp2.getScaledInstance(450, 300,
						java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				temp1.setImage(temp3);
				userPictureLabel.setIcon(temp1);
				userPictureLabel.updateUI();
			}
		});
		
		// add component to userInforPane panel----------------------------------------------
		userInforPane.add(userPictureLabel, BorderLayout.CENTER);
		userInforPane.add(useerInforAea, BorderLayout.SOUTH);
		userInforPane.setBackground(Color.GRAY);

		//split Panel--------------------------------------------------------------------------
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, idScrollPane,
				userInforPane);
		splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        splitPane.setPreferredSize(new Dimension(800, 480));
       
        //Check if there is a data or not -------------------------------------------
        if (line == 0){
        	useerInforAea.setText("No Data");
        }else {
        	useerInforAea.setText(regis.readfromLine(0));
        	updateLabel(userId.elementAt(idList.getSelectedIndex()));
        }
        
		add(splitPane);
		add(logout, BorderLayout.SOUTH);
	}
	private void updateLabel(String elementAt) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * change the user information in the JTextArea when admin click select on id
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {     
		useerInforAea.setText(regis.readfromLine(idList.getSelectedIndex()));
	}
}
