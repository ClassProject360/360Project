package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import project.registerInfor;

import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial") //Not implementing serialization suppressing warning.
public class Judge extends JPanel 
{
	int numOfLines;
	public Judge(int width, int height, JButton logout) throws IOException 
	{
		setBackground(Color.BLUE);
		
		ButtonGroup buttonGroup = null;
		DefaultListModel listModel;
		
		;
		setLayout(null);	
		
		registerInfor regis = new registerInfor();
		try {
			numOfLines = regis.numofline();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//FileReader file = new FileReader("src\\project\\infor.txt");
        //BufferedReader reader = new BufferedReader(file);
        
        //counts how many lines we have which determinants number if contestants
        //int numOfLines = (int) reader.lines().count();

        listModel = new DefaultListModel();
     
        for(int i = 0; i < numOfLines; i ++)
        {
            listModel.addElement(i+1);
        }
        
		JList list = new JList(listModel);
		
		list.setBounds(22, 140, 215, 350);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(list);
		
		//CODE FOR LIST HERE
	
		
		add(logout, BorderLayout.NORTH);
		
		
		
		JRadioButton ratingOne = new JRadioButton("1");
		ratingOne.setBounds(281, 452, 51, 37);
		add(ratingOne);
		
		JRadioButton ratingTwo = new JRadioButton("2");
		ratingTwo.setBounds(346, 452, 51, 37);
		add(ratingTwo);
		
		JRadioButton ratingThree = new JRadioButton("3");
		ratingThree.setBounds(411, 452, 51, 37);
		add(ratingThree);
		
		JRadioButton ratingFour = new JRadioButton("4");
		ratingFour.setBounds(476, 452, 51, 37);
		add(ratingFour);
		
		JRadioButton ratingFive = new JRadioButton("5");
		ratingFive.setBounds(541, 452, 51, 37);
		add(ratingFive);
		
		
		//ADDING BUTTONS TO GROUP SO WE ONLY CAN SELECT 1 OF THE 5
		buttonGroup = new ButtonGroup();
		
		buttonGroup.add(ratingOne);
		buttonGroup.add(ratingTwo);
		buttonGroup.add(ratingThree);
		buttonGroup.add(ratingFour);
		buttonGroup.add(ratingFive);
		
		ButtonGroup mybutton = buttonGroup;
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(mybutton.isSelected(null))
				{
					submitButton.setEnabled(false);
				}
				else
				{
					//need to fix bug if i forget to select a rating it locks the submit button
					
					submitButton.setEnabled(true);
					Enumeration<AbstractButton> bg = mybutton.getElements();
					while(bg.hasMoreElements())
					{
					JRadioButton jrd = (JRadioButton) bg.nextElement();
						if(jrd.isSelected())
						{
						      JOptionPane.showMessageDialog(null, "You Gave this picture a " + jrd.getText() + "/5");
						}
					}
					int index = list.getSelectedIndex();
				    if (index != -1) 
				    {
				        listModel.remove(index);	
				    }
				}
				
			}
		});
		
		submitButton.setBounds(623, 452, 155, 37);
		add(submitButton);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIdNumber.setBackground(Color.WHITE);
		lblIdNumber.setBounds(64, 87, 155, 29);
		add(lblIdNumber);
		
		JPanel picturePanel = new JPanel();
		picturePanel.setBounds(281, 111, 497, 318);
		add(picturePanel);
		
	}
}
