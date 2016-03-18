/**
 * To get user information and picture
 * Author: Nick Manachaichana, Chris Kubec
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import project.registerInfor;

/**
 * Set up component.
 */
@SuppressWarnings("serial")
// Not implementing serialization suppressing warning.
public class Register extends JPanel {
	private JPanel infor;
	private JPanel term;
	private JPanel submitPanel;
	private JPanel dispicPanel;

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
	private JLabel image1;
	
	private JButton submit;
	private JButton UploadButton;

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
	private File uploadImage;
	
	private boolean isUpload;

	// connect to registerInfor class to pass customer information
	private registerInfor passinfor;

	public Register(int width, int height) {
		setBackground(Color.GRAY);
		isUpload = false;
		
		// information panel
		infor = new JPanel(new GridLayout(10, 2));

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
		JTextArea area = new JTextArea(" Terms and Conditions\n"
				+ " OFFICIAL RULES \n"
				+ " NO PURCHASE NECESSARY TO ENTER OR WIN. The Coloring Contest (the Contest) \n" 
				+ " is sponsored by your local library (Sponsor). Entrants must submit a photo in accordance with these official contest rules \n"
				+ " (Official Rules). ELIGIBILITY: Open only to legal residents of the fifty (50) United States and the District of Columbia who are\n"
				+ " at least 13 years old at the time of entry. Employees of Sponsor, and its and their parent, affiliates, subsidiaries, and \n"
				+ " advertising and promotion agencies involved in this Contest, and their immediate family members (parent, child, spouse, \n"
				+ " sibling and their respective spouses, regardless of where they reside) and/or those living in the same household of each, \n"
				+ " whether or not related, are not eligible to participate in or win the Contest. Void where prohibited by law. All applicable \n"
				+ " federal, state and local laws apply. START/END DATES: Contest begins at 10:00:00 AM Eastern Time (EDT)on Saturday, March 19, 2016\n" 
				+ " and ends at 11:59:59p.m. EDT on Sunday, April 10, 2016 (the Entry Period). \n"
				+ " HOW TO ENTER: Entry does not require a payment or a purchase of any kind. To enter the Contest, submit your completed picture via \n"
				+ " the registraiton page. You must have a valid email account. If you do not agree to such terms of use and privacy policies, you \n"
				+ " cannot create an account or participate in this Contest. If Entrant is using his or her mobile device to enter, charges, including \n"
				+ " message and data rates, may apply. Entrants should consult their wireless service provider regarding its pricing plans. \n"
				+ " To enter the Contest, color the free picture available as a download from this site by April 10, 2016, take a photo of it and \n"
				+ " upload it via the registraiton page of this site during the Entry Period to receive one (1) entry (Entry) into the Contest. Limit \n"
				+ " one (1) entry per unique email account and per person during the Entry Period. By entering the Contest, each Entrant grants Sponsor \n"
				+ " a non-exclusive, royalty-free, irrevocable right to reproduce, copy, publish, display, distribute, perform, translate, adapt, modify, \n"
				+ " feature and otherwise use the Entry, without restriction and without compensation, notification, or additional consent from Entrant or \n"
				+ " any third party. Entrant warrants that it has the sole and exclusive right to grant such rights to Sponsor, and that the Sponsor's \n"
				+ " reproduction, publishing, displaying, and/or other use of the Entry will not infringe on any rights of third parties, including, but not\n"
				+ " limited to, copyright, trademark, privacy, or publicity rights, or create claims for breach of contract, anywhere in the world. Entrant \n"
				+ " agrees that Sponsor shall have no obligation to copy, publish, display, or otherwise exploit the Entry. The Entry must not include \n"
				+ " materials (language, phrases, quotations, artwork, etc.) belonging to or copyrighted by third parties. Any such Entry will be \n"
				+ " disqualified. The Entry must not have been previously published or otherwise exhibited. The Entry must not contain any material that \n"
				+ " infringes upon any personal, proprietary, or any other right of any third party. The Entry must not contain any obscene or otherwise \n"
				+ " objectionable material (as determined by Sponsor within its sole discretion). The Entry must not contain any unsolicited or unauthorized \n"
				+ " advertising, promotional materials, or any other form of solicitation. The Entry must not contain any material that: (a) would give or \n"
				+ " threaten to give rise to criminal or civil liability; (b) encourages conduct that constitutes a criminal offense; (c) encourages or \n "
				+ " provides instructional information about illegal activities or (d) references any brand name products. Entrant acknowledges that Entrant \n"
				+ " will not receive any compensation of any kind for its Entry. Entries generated by script, macro or other automated means are void, as are \n "
				+ " Entries that are illegible, garbled, incomplete or that contain errors. Normal time, toll, connection and usage rates, if any, charged by \n "
				+ " your Internet service provider will apply. \n" 
				+ " VOTING: From April 10-April 15, 2016 (the “Voting Phase”), the five Entrants will be deemed the winners. Subject to the Entrant’s compliance \n"
				+ " with these Official Rules. Sponsor reserves the right, in its sole discretion, to select alternate winners should the voting appear to have \n"
				+ " been tampered with or manipulated in any way. In the event any potential Winner is disqualified for any reason, the Entrant with the next \n"
				+ " highest number of “Likes” in the pool of entrants who have submitted valid Entries will be chosen as the Winner. In the event that no Entries \n"
				+ " are received, no prize will be awarded. Sponsor reserves the right to not select a Winner, or to extend the Entry Period if in its sole \n"
				+ " discretion it does not receive a sufficient number of eligible and qualified Entries. The decision of Sponsor in this matter is final and binding.\n"
				+" WINNER NOTIFICATION/ VALIDATION: Five (5) Winners will be notified via Instagram or Twitter by November 18, 2015, and the potential Winners may \n"
				+ " be required to execute and return an Affidavit of Eligibility/Release of Liability/Publicity form (where legal) within seven (7) days of date of \n"
				+ " attempted notification. Noncompliance within this time period, or with these Official Rules, or the return of any prize/prize notification may \n"
				+ " result in disqualification and, at Sponsor's discretion, time period permitted, an alternate potential Winner may be selected. Prizes will be \n "
				+ " fulfilled approximately 2-3 weeks after winner validation. Any Winner later determined to be ineligible may be required to return his/her prize.\n" 
				+ " PRIZES: Five Winners will each receive a box (one year supply) of Hallmark Cards. The total approximate retail value of prizes is $225 for each \n "
				+ " box of cards.  No transfer, substitution or cash redemption will be awarded, except Sponsor reserves the right to substitute a prize \n"
				+ " (or portion thereof) of comparable or greater value, at its sole discretion, if any advertised item becomes unavailable. All prize details are \n "
				+ " at the sole discretion of the Sponsor. If a Winner cannot accept the prize as stated, prize will be forfeited and at Sponsor's discretion, an \n"
				+ " alternate Winner may be selected. Winners are solely responsible for any and all federal, state, and local taxes or any other expenses in \n "
				+ " connection with the acceptance, receipt and/or use of any prize awarded.\n"
				+ " GENERAL RULES: Acceptance of prize constitutes permission for the Sponsor and its designees to use each Winner's name, city, state, likeness, \n "
				+ " voice, biographical information and statements for purposes of advertising, promotion and publicity in any and all media, now or hereafter known, \n"
				+ " throughout the world in perpetuity without additional compensation, notification or permission, unless prohibited by law. By participating, entrant \n "
				+ "(i) agrees to release and hold Sponsor, its parent, affiliates, subsidiaries, and advertising and promotion agencies, and each of their respective \n "
				+ " directors, officers, employees and assigns (collectively, the Released Parties), harmless against any and all claims and liability arising in whole \n"
				+ " or in part, directly or indirectly, out of participation in the Contest or misuse, nonuse or use of any prize; \n"
				+ " (ii) waives all rights to claim punitive, incidental and consequential damages, attorneys' fees or any damages other than actual out-of-pocket costs \n"
				+ " incurred to enter; and \n"
				+ " (iii) agrees to be bound by these Official Rules. Released Parties are not responsible for incomplete, lost, late, damaged, inaccurate, illegible, \n "
				+ " misdirected, garbled, delayed or undelivered Entries; or for technical hardware or software malfunctions or failures of any kind, lost, unavailable \n "
				+ " network connections, or failed, incomplete, garbled or delayed computer transmission, which may limit an individual's ability to participate. Sponsor \n"
				+ " reserves the right in its sole discretion, to cancel, suspend or modify the Contest, or to disqualify any implicated entrant(s), (and their Entries) \n"
				+ " if any fraud, virus, actions by entrants, technical or other error or problem, or any other occurrence corrupts or affects the administration, integrity,\n"
				+ " security, or proper play of the Contest, as determined by Sponsor in its sole discretion. In the event of cancellation, Sponsor reserves the right, at its \n"
				+ " sole discretion, to award the prize in a random drawing from among all eligible, non-suspect Entries received up to the time of the event or action \n"
				+ " warranting such cancellation. In the event this Contest is cancelled prior to the stated end date, a notice will be posted at \n"
				+ " CAUTION: Any attempt by an entrant to deliberately damage any web site or undermine the legitimate operation of the Contest is a violation of criminal and \n "
				+ " civil laws, and should such an attempt be made, Sponsor reserves the right to seek damages from any such entrant to the fullest extent permitted by law, \n "
				+ " including criminal prosecution. Released Parties are not responsible for any technical, mechanical, printing, typographical, human or other error relating \n"
				+ " to or in connection with the Contest, including, without limitation, errors which may occur in the administration of the Contest, the processing of Entries, \n"
				+ " the announcement of the prize or in any Contest-related materials; or for any liability for damage to any computer system resulting from participating in, or \n "
				+ " accessing or downloading information in connection with this Contest. In the event of a dispute as to any Entry, the authorized Instagram or Twitter account \n"
				+ " holder used to enter the Contest will be deemed to be the entrant and must comply with these Official Rules. The authorized account holder is the natural person \n"
				+ " assigned an Instagram or Twitter account. Each entrant may be required to show proof of being an authorized account holder. \n"
				+ " WINNERS' NAMES: Names of winners (first name/city) will be posted on Sponsor’s @barnesandnoble  Instagram or @BNBuzz Twitter page when available. \n"
				+ " NO WARRANTIES: Sponsor makes no warranties regarding any of the prizes furnished as part of this Contest.  All prizes, and all materials furnished as part of \n"
				+ " or in connection with the Contest are provided as is without warranty of any kind, either express or implied, including without limitation the implied warranties \n"
				+ " of merchantability, fitness for a particular purpose. \n"
				+ " PRIVACY: Any information submitted to Sponsor, including all Entries will be governed by the terms of Barnes & Noble's User Agreement and Privacy Policy.\n"
				+ " GOVERNING LAW: Except where prohibited, entrant agrees that: (1) any and all disputes, claims and causes of action arising out of or connected with this Contest or \n"
				+ " any prize awarded shall be resolved individually, without resort to any form of class action; and (2) any and all claims, judgments and awards shall be limited to \n"
				+ " actual out-of-pocket costs incurred, including costs associated with entering this Contest, but in no event attorneys’ fees.  All issues and questions concerning \n "
				+ " the construction, validity, interpretation and enforceability of these Official Rules or the rights and obligations of any entrant, Sponsor, and/or any of the Released \n"
				+ " Parties shall be governed by and construed in accordance with the laws of the State of New York without giving effect to any choice of law or conflict of law rules or \n"
				+ " provisions which would cause the application of the laws of any jurisdiction other than the State of New York. All actions, proceedings, or litigation relating hereto \n"
				+ " will be instituted and prosecuted solely within the State of New York, County of New York. The parties consent to the jurisdiction of the state and federal courts of New \n"
				+ " York with respect to any action, dispute, or other matter pertaining to or arising out of this Contest.\n"
				+ " NO IMPLIED ENDORSEMENT: The names of individuals, groups, companies, products and services mentioned herein, and any corresponding likenesses, logos and images thereof \n"
				+ " reproduced herein, have been used for identification purposes only and may be the copyrighted properties and trademarks of their respective owners. The mention of any \n"
				+ " individual, group or company, or the inclusion of a product or service as the prize, does not imply any association with or endorsement by such individual, group or \n"
				+ " company or the manufacturer or distributor of such product or service and, except as otherwise indicated, no association or endorsement is intended or should be inferred.\n",
								8, 65);
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
				checkInfor();
			}
		});
		
		// display the upload image
		dispicPanel = new JPanel();
		image1 = new JLabel("Please Upload Picture");
		image1.setPreferredSize(new Dimension(360, 290));
		
		// upload picture
		UploadButton = new JButton("Upload Picture");
		UploadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser myFile = new JFileChooser("src/image");
				myFile.setCurrentDirectory(new File("src/pp"));
				
				final int returnVal = myFile.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = myFile.getSelectedFile();
						uploadImage = myFile.getSelectedFile();
			            BufferedImage bi = ImageIO.read(file);
						ImageIcon imageIcon = new ImageIcon(bi);
						Image image = imageIcon.getImage(); // transform it
						Image newimg = image.getScaledInstance(360, 290,
								java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
						imageIcon = new ImageIcon(newimg); // transform it back
						isUpload = true; // to check if the user upload picture 
						image1.setIcon(imageIcon);
					} catch (IOException ex) {
						ex.printStackTrace();
					}

				}
			}
		});

		// submit Panel
		submitPanel = new JPanel(new GridLayout(1, 3));

		submitPanel.add(agree);
		submitPanel.add(agreeLabel);
		submitPanel.add(UploadButton);
		submitPanel.add(submit);

		// set the size of submitPanel
		submitPanel.setPreferredSize(new Dimension(500, 50));
		// set the size of inforPanel
		infor.setPreferredSize(new Dimension(370, 300));
		
		
		dispicPanel.add(image1);

		// add all 3 part to regisPanel
		add(infor, BorderLayout.WEST);
		add(dispicPanel, BorderLayout.EAST);
		add(term, BorderLayout.CENTER);
		add(submitPanel, BorderLayout.SOUTH);
	}
	
	
	/**
	 * to check if user enter all the information, upload picture and check agree
	 */
	public void checkInfor(){
		if (!nameTextField.getText().equals("")
				&& !latNameTextField.getText().equals("")
				&& !ageTextField.getText().equals("")
				&& !sexTextField.getText().equals("")
				&& !addressTextField.getText().equals("")
				&& !cityTextField.getText().equals("")
				&& !stateTextField.getText().equals("")
				&& !zipTextField.getText().equals("")
				&& !phoneTextField.getText().equals("")
				&& !emailTextField.getText().equals("")
				&& isUpload) {
			if (agree.isSelected()) {
				passinfor = new registerInfor();
				passinfor.cusInfor(nameTextField.getText(),
						latNameTextField.getText(),
						ageTextField.getText(), sexTextField.getText(),
						addressTextField.getText(),
						cityTextField.getText(),
						stateTextField.getText(),
						zipTextField.getText(),
						phoneTextField.getText(),
						emailTextField.getText(), uploadImage);
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
				image1.setIcon(new ImageIcon());
			} else {
				JOptionPane.showMessageDialog(null,
						"Please Check Agree", "Before Move on",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Please Fill out your information",
					"Before Move on", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}