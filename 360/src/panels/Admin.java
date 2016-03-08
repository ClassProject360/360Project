/* 
 * 
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.registerInfor;

/**
 * 
 *
 */
@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Admin extends JPanel {
	
	int line;
	
	private JList categoryList;
	private JScrollPane listPane;
	/**
	 * Constructor that creates the About main panel seen upon logging into the program.
	 * 
	 * @param width
	 * @param height
	 */
	public Admin(int width, int height, JButton logout){
		setBackground(Color.BLUE.brighter().brighter());
		
		registerInfor regis = new registerInfor();
		try {
			line = regis.numofline();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("num of line = " + line);
		
		String[] listData2 = { "one", "two", "three", "four",
                "five", "six", "seven" };
		
		categoryList = new JList(listData2);
		
		
		listPane = new JScrollPane(categoryList);
		
		add(logout, BorderLayout.SOUTH);
		add(listPane, BorderLayout.WEST);
	}
}
