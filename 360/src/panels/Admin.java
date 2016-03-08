/* 
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
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
	
	int line;
	
	private JList<String> idList;
	private JScrollPane listPane;
	private DefaultListModel<String> fruitsName;
	/**
	 * Constructor that creates the About main panel seen upon logging into the program.
	 * 
	 * @param width
	 * @param height
	 */
	public Admin(int width, int height, JButton logout){
		setBackground(Color.BLUE.brighter().brighter());
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		
		
		JSplitPane splitPane = new JSplitPane();
		//splitPane.setResizeWeight(10.0);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		
		
		
		registerInfor regis = new registerInfor();
		try {
			line = regis.numofline()+1;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("num of line = " + line);
		fruitsName = new DefaultListModel<String>();
		
		
		for(int i=0; i <= line; i++){
			fruitsName.addElement(" ID: " + i + " ");
		}
		
		idList = new JList<String>(fruitsName);
		idList.setFont(font1);
		idList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		idList.setSelectedIndex(0);
		idList.addListSelectionListener(this);
		
		
		listPane = new JScrollPane(idList);
		
		
		add(logout, BorderLayout.SOUTH);
		add(listPane, BorderLayout.WEST);

		
		//add(splitPane, BorderLayout.WEST);
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
