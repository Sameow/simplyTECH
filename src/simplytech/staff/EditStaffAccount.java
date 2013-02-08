package simplytech.staff;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;

import simplytech.components.DesEncryption;
import simplytech.dao.PersonDAO;
import simplytech.dao.StaffDAO;
import simplytech.dao.StaffManagementDAO;
import simplytech.entity.Person;
import simplytech.entity.Staff;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class EditStaffAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JLabel jLabelBar = null;
	private JLabel jLabelEditStaffAccount = null;
	private JLabel jLabelAccountDetails;
	private JLabel jLabelEmail;
	private JLabel jLabelUsername;
	private JLabel jLabelMobile;
	private JLabel jLabelGender;
	private JLabel jLabelPosition;
	private JLabel jlabelPassword;
	private JLabel jlabelConfirmPassword;
	
	private JTextField jTextFieldStaffEmail = null;
	private JTextField jTextFieldStaffUsername = null;
	private JTextField jTextFieldStaffMobile = null;
	private JTextField jTextFieldStaffGender = null;
	private JTextField jTextFieldStaffPosition = null;
	private JPasswordField jPasswordField = null;
	private JPasswordField jPasswordFieldConfirmPassword = null;
	
	private JLabel jLabelSave;
	private JLabel jLabelBack = null;
	private JLabel lblCreateStaff;
	private JLabel labelDeleteStaff;
	private JTextField jTextFieldStaffSearch = null;
	
	private String selectedTextPaneUsername; 
	private String selectedTextPaneEmail; 
	private String selectedTextPaneMobile;	
	private String selectedTextPaneGender; 
	private String selectedTextPanePosition;
	
	private JScrollPane ScrollPaneContainingStaffTextPanes;
	private JPanel panelWithStaffTextPanes;
	
	private JLabel checkStaffSearch=null;
	private JLabel checkPassword = null;
	private JLabel checkConfirmPassword = null;
	private JLabel checkMobile=null;
	private JLabel checkGender=null;
	private JLabel checkPosition=null;
	private JLabel checkEmail=null;
	
	private JTextPane selectedTextPane;
	private Staff selectedStaff;
	
	ArrayList<JTextPane> staffTextPanes=new ArrayList<JTextPane>();
	private  ArrayList<Staff> staffArray;
	private JProgressBar jProgressBar = null;

	public EditStaffAccount(JFrame f) {
		super();
		myFrame = f;
		initialize();
		System.out.println(" UI Initialised.");
		if(MainFrame.getPersonWhoLogin().getPosition().equals("Manager")){
			lblCreateStaff.setVisible(true);
			labelDeleteStaff.setVisible(true);
			}
			else{
				lblCreateStaff.setVisible(false);
				labelDeleteStaff.setVisible(false);
			}
	}

	private void initialize(){
		//Gather staff
		try {
			staffArray=StaffManagementDAO.retrieveAll();
		} catch (SQLException e) {
			System.err.println("Unable to retrieve staff details" +e);
		}
		selectedStaff=staffArray.get(0);
		jLabelSave = new JLabel();
		jLabelSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				//Get error messages	
				String emailErrorMsg = checkEmail.getText();
				String mobileErrorMsg = checkMobile.getText();
				String genderErrorMsg = checkGender.getText();
				String positionErrorMsg = checkPosition.getText();
				String passwordErrorMsg = checkPassword.getText();
				
				//Get user input
				String changedEmail=jTextFieldStaffEmail.getText();
				String changedMobile=jTextFieldStaffMobile.getText();
				String changedGender=jTextFieldStaffGender.getText().toUpperCase();
				String changedPosition=jTextFieldStaffPosition.getText();
				String changedPassword;
				//Encrypt password if there is changes
				if (passwordErrorMsg.equals("Valid password change")) {
				DesEncryption encrypter = new DesEncryption("Password");
				changedPassword=encrypter.encrypt(new String(jPasswordField.getPassword()));
				}
				else
					changedPassword=selectedStaff.getPassword();
				
				if (emailErrorMsg.equals("Please enter your email address.") ||
					emailErrorMsg.equals("Email already exists.") ||
					emailErrorMsg.equals("Invalid email address") ||
					mobileErrorMsg.equals("Invalid mobile number") || 
					mobileErrorMsg.equals("Please enter your mobile no.") ||
					mobileErrorMsg.equals("Number already exists.") ||
					genderErrorMsg.equals("Please enter your gender.") || 
					genderErrorMsg.equals("Invalid gender") ||
					positionErrorMsg.equals("Please enter the position.") ||
					passwordErrorMsg.equals("Weak Password") ||
					passwordErrorMsg.equals("Password not match")
					) {
					JOptionPane.showMessageDialog(null,
							"Please check your details", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} 
				else {
					int confirmingUpdate = JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to update?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (confirmingUpdate == JOptionPane.YES_OPTION) {
					if (StaffManagementDAO.updateStaff(selectedStaff.getId(), changedEmail, changedMobile, changedGender, changedPosition, changedPassword)) {
					JOptionPane.showMessageDialog(null,
							"Staff updated!", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					//refresh page
					JPanel panel = new EditStaffAccount(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();       
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Unable to update staff", "Error in if loop!",
								JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JPanel panel = new EditStaffAccount(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();  
					}
				}
				
			}
		});
		jLabelSave.setBounds(new Rectangle(46, 119, 176, 43));
		jLabelSave.setBackground(new Color(91, 155, 213));
		jLabelSave.setForeground(Color.white);
		jLabelSave.setText("Save changes");
		jLabelSave.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelSave.setOpaque(true);
		jLabelEditStaffAccount = new JLabel();
		jLabelEditStaffAccount.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelEditStaffAccount.setLocation(new Point(91, 23));
		jLabelEditStaffAccount.setSize(new Dimension(310, 35));
		jLabelEditStaffAccount.setText("Edit Staff Account");
		jLabelBar = new JLabel();
		jLabelBar.setText("");
		jLabelBar.setLocation(new Point(0, 78));
		jLabelBar.setSize(new Dimension(371, 4));
		jLabelBar.setBackground(new Color(91, 155, 213));
		jLabelBar.setOpaque(true);
		
		jLabelPosition = new JLabel();
		jLabelPosition.setBounds(new Rectangle(422, 358, 125, 37));
		jLabelPosition.setText("Position:");
		jLabelPosition.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(431, 287, 130, 50));
		jLabelGender.setText("Gender:");
		jLabelGender.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelMobile = new JLabel();	
		jLabelMobile.setBounds(new Rectangle(436, 215, 160, 50));
		jLabelMobile.setText("Mobile:       +");
		jLabelMobile.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelUsername = new JLabel();
		jLabelUsername.setBounds(new Rectangle(399, 69, 148, 50));
		jLabelUsername.setText("Username:");
		jLabelUsername.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelEmail = new JLabel();
		jLabelEmail.setBounds(new Rectangle(458, 145, 138, 50));
		jLabelEmail.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelEmail.setText("Email:");
		jLabelAccountDetails = new JLabel();
		jLabelAccountDetails.setBounds(new Rectangle(549, 21, 290, 40));
		jLabelAccountDetails.setFont(new Font("Calibri", Font.BOLD, 36));
		jLabelAccountDetails.setText("Account Details");	
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelEditStaffAccount, null);
		this.add(getJLabelBack());
		this.add(jLabelAccountDetails, null);
		this.add(jLabelEmail, null);
		this.add(jLabelUsername, null);
		this.add(jLabelMobile, null);
		this.add(jLabelGender, null);
		this.add(jLabelPosition, null);
		this.add(getJTextFieldStaffEmail(), null);
		this.add(getJTextFieldStaffUsername(), null);
		this.add(getJTextFieldStaffMobile(), null);
		this.add(getJTextFieldStaffGender(), null);
		this.add(getJTextFieldStaffPosition(), null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBar, null);
		this.add(jLabelSave, null);
		this.add(getJProgressBar(), null);
		add(getJPasswordFieldConfirmPassword());
		add(getScrollPaneContainingStaffTextPanes());
		createStaffTextPanes();
		
		checkStaffSearch = new JLabel("");
		checkStaffSearch.setHorizontalAlignment(SwingConstants.CENTER);
		checkStaffSearch.setBounds(26, 215, 189, 47);
		add(checkStaffSearch);
		
		checkEmail = new JLabel("");
		checkEmail.setBounds(832, 148, 189, 47);
		add(checkEmail);
		
		checkMobile = new JLabel("");
		checkMobile.setBounds(835, 218, 189, 47);
		add(checkMobile);
		
		checkGender = new JLabel("");
		checkGender.setBounds(835, 290, 189, 47);
		add(checkGender);
		
		checkPosition = new JLabel("");
		checkPosition.setBounds(835, 348, 189, 47);
		add(checkPosition);
		
		
		checkPassword = new JLabel("");
		checkPassword.setBounds(835, 406, 189, 47);
		add(checkPassword);
		checkPassword.setText("");
		
		checkConfirmPassword = new JLabel();
		checkConfirmPassword.setBounds(new Rectangle(487, 201, 219, 32));
		checkConfirmPassword.setText("");
		add(checkConfirmPassword);
		
		lblCreateStaff = new JLabel();
		lblCreateStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Checking position seems pointless, since nobody other than Manager can see label, but just to be safe
				if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager")){
				JPanel panel = new createNewStaff(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				}
				else
					JOptionPane.showMessageDialog(null,
							"Only Managers are allowed to create new staff.", "Access denied.",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		lblCreateStaff.setText("Create Staff");
		lblCreateStaff.setOpaque(true);
		lblCreateStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateStaff.setForeground(Color.WHITE);
		lblCreateStaff.setBounds(new Rectangle(675, 494, 176, 43));
		lblCreateStaff.setBackground(new Color(91, 155, 213));
		lblCreateStaff.setBounds(34, 489, 176, 43);
		add(lblCreateStaff);
		
		labelDeleteStaff = new JLabel();
		labelDeleteStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager")){
					int confirmingDelete = JOptionPane.showConfirmDialog(myFrame, "Delete selected staff??", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (confirmingDelete == JOptionPane.YES_OPTION) {
					if (StaffManagementDAO.deleteStaff(selectedStaff.getId())) {
					JOptionPane.showMessageDialog(null,
							"Staff deleted!", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					//refresh page
					JPanel panel = new EditStaffAccount(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();       
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Unable to delete staff", "Error in if loop!",
								JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JPanel panel = new EditStaffAccount(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();  
					}
			}
			else
			JOptionPane.showMessageDialog(null,
				"Only Managers are allowed to delete staff.", "Access denied.",
			JOptionPane.ERROR_MESSAGE);
			}
		});
		labelDeleteStaff.setText("Delete Staff");
		labelDeleteStaff.setOpaque(true);
		labelDeleteStaff.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteStaff.setForeground(Color.WHITE);
		labelDeleteStaff.setBounds(new Rectangle(675, 494, 176, 43));
		labelDeleteStaff.setBackground(new Color(91, 155, 213));
		labelDeleteStaff.setBounds(34, 435, 176, 43);
		add(labelDeleteStaff);
		
		jlabelPassword = new JLabel();
		jlabelPassword.setText("Change Password:");
		jlabelPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		jlabelPassword.setBounds(new Rectangle(456, 145, 138, 50));
		jlabelPassword.setBounds(372, 406, 235, 50);
		add(jlabelPassword);
		
		this.add(getJTextFieldStaffSearch(), null);
		add(getJPasswordField());
		add(getJlabelConfirmPassword());
		
		
		//Dont know why this doesnt work, will review after exams
//		//Gather all staff details
//		try {
//			staffArray=StaffManagementDAO.retrieveAll();
//			System.out.println("staffArray.size()= "+ staffArray.size());
//		} catch (SQLException e) {
//			System.out.println("Unable to create staff array");
//		}
//		//Generate text panes based on no. of Staff
//		int noOfStaffTextPanesCreated=0;
//		int yCoordinate=0;
//		for (int i=0; i<staffArray.size(); i++) {
//			System.out.println("noOfStaffTextPanesCreated = "+noOfStaffTextPanesCreated);
//			System.out.println("yCoordinate = "+yCoordinate);
//			//1st textpane y coordinate is 136
//		this.add(getJTextPaneNameOnTheLeft((136+yCoordinate), staffArray.get(noOfStaffTextPanesCreated)));
//		noOfStaffTextPanesCreated++;
//		yCoordinate+=50;
//		}	
	}

	//Doesnt work, see above
//	private JTextPane getJTextPaneNameOnTheLeft(int Yvalue,  Staff staff) {
//		if (jTextPaneNameOnTheLeft == null) {
//			System.out.println("Y value to be initialised = "+Yvalue);
//			staffToBeDisplayed = staff;
//			jTextPaneNameOnTheLeft = new JTextPane();
//			System.out.println(staffToBeDisplayed.getName()+"'s JTextPane initialised with "+Yvalue);
//			jTextPaneNameOnTheLeft.setBounds(new Rectangle(141, Yvalue, 212, 36));
//			System.out.println("setBounds with "+Yvalue);
//			jTextPaneNameOnTheLeft.setFont(new Font("Calibri", Font.BOLD, 18));
//			jTextPaneNameOnTheLeft.setEditable(false);
//			jTextPaneNameOnTheLeft.setBackground(new Color(91, 155, 213));
//			jTextPaneNameOnTheLeft.setForeground(Color.white);
//			jTextPaneNameOnTheLeft.setText(staff.getName());
//			jTextPaneNameOnTheLeft.setBackground(new Color(31,78,121));
//			
//			jTextPaneNameOnTheLeft.addMouseListener(new java.awt.event.MouseAdapter() {
//				public void mouseClicked(java.awt.event.MouseEvent e) {
//					jTextPaneNameOnTheLeft.setBackground(new Color(31,78,121));
//					jTextFieldStaffName.setText(staffToBeDisplayed.getName());
//					jTextFieldStaffGender.setText(staffToBeDisplayed.getGender());
//					jTextFieldStaffUsername.setText(staffToBeDisplayed.getUsername());
//					jTextFieldStaffMobile.setText(staffToBeDisplayed.getMobile());
//					jTextFieldStaffPosition.setText(staffToBeDisplayed.getPosition());
//				}
//			});
//		}
//		System.out.println("JTextPane returned");
//		return jTextPaneNameOnTheLeft;
//		
//	}

private boolean authorised() { //To check whether user is of authority to edit
		if (MainFrame.getPersonWhoLogin().getId()==selectedStaff.getId())
			return true;
		else if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager"))
			return true;
		else
			return false;
	}

private JTextField getJTextFieldStaffSearch() {
	if (jTextFieldStaffSearch == null) {
		jTextFieldStaffSearch = new JTextField();
		jTextFieldStaffSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTextFieldStaffSearch.setText("");
			}
		});
		jTextFieldStaffSearch.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldStaffSearch.setText("Search staff by name here!");
		jTextFieldStaffSearch.setBounds(new Rectangle(16, 173, 206, 35));
		jTextFieldStaffSearch.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				String staffName=jTextFieldStaffSearch.getText();
				//For empty inputs			
				for (int i=0; i<staffTextPanes.size(); i++) {
					if (staffTextPanes.get(i).getText().equals(staffName)) {					
						//For later methods
						String selectedStaffUsername = null;
						//Reset all error msg
						checkPassword.setText("");
						checkConfirmPassword.setText("");
						checkMobile.setText("");
						checkGender.setText("");
						checkPosition.setText("");
						checkEmail.setText("");
						//Change bg color when clicked
						for (int k = 0; k < staffTextPanes.size(); k++) {
							staffTextPanes.get(k).setBackground(
									new Color(91, 155, 213));
						}
						
						//Extract info for selected TextPane
						selectedTextPane = staffTextPanes.get(i);
						//Look for name in staffArray and find his username
						for (int k=0; k<staffArray.size(); k++) {
							if (staffArray.get(k).getName().equals(selectedTextPane.getText())) {
								selectedStaffUsername=staffArray.get(k).getUsername();
							}
						}
						//Create the Staff of selectedTextPane
						Person selectedPerson=PersonDAO.searchByUsername(selectedStaffUsername);
						selectedStaff = StaffDAO.createById(selectedPerson.getId());
						//Reset authorised
						jTextFieldStaffEmail.setEditable(authorised());
						jTextFieldStaffMobile.setEditable(authorised());
						jTextFieldStaffGender.setEditable(authorised());
						jPasswordField.setEditable(authorised());
						jPasswordFieldConfirmPassword.setEditable(authorised());
						
						selectedTextPaneUsername = selectedStaff.getUsername();
						selectedTextPaneEmail = selectedStaff.getEmail();
						selectedTextPaneMobile = selectedStaff.getMobile();
						selectedTextPaneGender = selectedStaff.getGender();
						selectedTextPanePosition = selectedStaff.getPosition();
						
						//Set info for selected textPane
						jTextFieldStaffUsername.setText(selectedTextPaneUsername);
						jTextFieldStaffEmail.setText(selectedTextPaneEmail);
						jTextFieldStaffMobile.setText(selectedTextPaneMobile);
						jTextFieldStaffGender.setText(selectedTextPaneGender);
						jTextFieldStaffPosition.setText(selectedTextPanePosition);
						
						int indexOfStaffTextPanesWhoHasSelectedStaffName=-1;
						for(int a=0; a<staffTextPanes.size(); a++) {
							if (staffTextPanes.get(a).getText().equals(selectedTextPane.getText())) {//Find index of text pane who has same text as the selected textpane
								indexOfStaffTextPanesWhoHasSelectedStaffName=a;
							}
						}
						if (indexOfStaffTextPanesWhoHasSelectedStaffName==-1)
							System.out.println("Error");
						else
						staffTextPanes.get(indexOfStaffTextPanesWhoHasSelectedStaffName).setBackground(new Color(31, 78, 121));//set bg color of selected textpane to indicate selection

						checkStaffSearch.setText("");
						break;
					}
					else {
						if (staffName.length() == 0) {
							checkStaffSearch.setText("");
						}
						else {
						checkStaffSearch.setText("Staff doesnt exist.");
						checkStaffSearch.setForeground(Color.red);
						}
					}
					

				
		}}});
	}
	return jTextFieldStaffSearch;
}

//All the validation for every text field should have a parent class containing 
	//standard validating, child class should have all other validation unique to whatever it is validating, but no time to do.

	private JTextField getJTextFieldStaffEmail() {
		if (jTextFieldStaffEmail == null) {
			jTextFieldStaffEmail = new JTextField();
			jTextFieldStaffEmail.setBounds(new Rectangle(606, 145, 216, 50));
			jTextFieldStaffEmail.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffEmail.setBackground(Color.WHITE);
			jTextFieldStaffEmail.setEditable(authorised());			
			jTextFieldStaffEmail.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {					
					// make sure email contains @ symbol , domain name, ".com"
					boolean validInput = true;
					String email = jTextFieldStaffEmail.getText();
					Pattern validEmailFormat = Pattern.compile(".+@.+\\.[a-z]+");
					Matcher matchEmail = validEmailFormat.matcher(email);
					boolean matchFound = matchEmail.matches();

					if (matchFound) {
						validInput = true;
						checkEmail
						.setText("");
					} else {
						validInput = false;
					}
					//For empty emails
					if (email.length() == 0) {
						validInput = false;
						checkEmail.setText("Enter your email address.");
						checkEmail.setForeground(Color.red);
					} else if (validInput == true) {
						//Check for duplicate input in DB
						for (int i=0; i<staffArray.size(); i++) {
							if (staffArray.get(i).getEmail().equals(email)) {
								checkEmail.setText("Email already exists.");
								checkEmail.setForeground(Color.red);
								System.out.println("When email match");
								break;
							}
							else {
								checkEmail.setText("");
								System.out.println("When email doesnt match");
							}
						}
						// Invalid email addresses
					} else if (validInput == false) {
						checkEmail.setText("Invalid email address");
						checkEmail.setForeground(Color.red);
					} else
						checkEmail.setVisible(false); // 
				}
			});
		}
		return jTextFieldStaffEmail;
	}
	
	private JTextField getJTextFieldStaffUsername() {
		if (jTextFieldStaffUsername == null) {
			jTextFieldStaffUsername = new JTextField();
			jTextFieldStaffUsername.setEditable(false);
			jTextFieldStaffUsername.setBounds(new Rectangle(606, 74, 216, 50));
			jTextFieldStaffUsername.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffUsername.setText("");
			jTextFieldStaffUsername.setBackground(Color.WHITE);
		}
		return jTextFieldStaffUsername;
	}


	private JTextField getJTextFieldStaffMobile() {
		if (jTextFieldStaffMobile == null) {
			jTextFieldStaffMobile = new JTextField();
			jTextFieldStaffMobile.setBounds(new Rectangle(609, 215, 216, 50));
			jTextFieldStaffMobile.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffMobile.setBackground(Color.WHITE);
			jTextFieldStaffMobile.setEditable(authorised());
			jTextFieldStaffMobile.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					boolean validStaffMobile = true;
					String mobile = jTextFieldStaffMobile.getText();
					//Pattern to check for mobile phone numbers, all mobile numbers should be 10 digits
					Pattern mobileFormat = Pattern.compile("^\\d{10}$");
					Matcher checkMobileFormat = mobileFormat.matcher(mobile);
					boolean match = checkMobileFormat.matches();
					if (match) {
						validStaffMobile = true;
						checkMobile
						.setText("");
					} else {
						validStaffMobile = false;
					}
					// For empty spaces
					if (mobile.length() == 0) {
						validStaffMobile = false;
						checkMobile.setText("Please enter your mobile no.");
						checkMobile.setForeground(Color.red);
					} else if (validStaffMobile == true) {
						//Check for duplicate input in DB
						for (int i=0; i<staffArray.size(); i++) {
							if (staffArray.get(i).getMobile().equals(mobile)) {
								checkMobile.setText("Number already exists.");
								checkMobile.setForeground(Color.red);
								System.out.println("checkMobile error message doesnt show.");
								break;
							}
							else {
								checkMobile.setText("");
								System.out.println("When mobile doesnt match");
							}
						}
						// for invalid Mobile numbers
					} else if (validStaffMobile == false) {
						checkMobile.setText("Invalid mobile number");
						checkMobile.setForeground(Color.red);
					} else
						checkMobile.setVisible(false); // 
				}
			});
		}
		return jTextFieldStaffMobile;
	}

	private JTextField getJTextFieldStaffGender() {
		if (jTextFieldStaffGender == null) {
			jTextFieldStaffGender = new JTextField();
			jTextFieldStaffGender.setBounds(new Rectangle(609, 287, 216, 50));
			jTextFieldStaffGender.setEditable(authorised());
			jTextFieldStaffGender.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffGender.setText("");
			jTextFieldStaffGender.setBackground(Color.WHITE);
			jTextFieldStaffGender.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String checkForNoInput=jTextFieldStaffGender.getText();

					if (checkForNoInput.length()==0) {
						checkGender.setText("Please enter your gender.");
						checkGender.setForeground(Color.red);
						checkGender.setVisible(true);
					}
					else {	
							if (checkForNoInput.toUpperCase().charAt(0)=='M' || checkForNoInput.toUpperCase().charAt(0)=='F')	 {
								checkGender.setText("");
							} else {
								checkGender.setText("Invalid gender");
								checkGender.setForeground(Color.red);
							}
					}
					
			}});

		}
		return jTextFieldStaffGender;
	}

	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new Rectangle(832, 478, 147, 32));
			jProgressBar.setVisible(false);
		}
		return jProgressBar;
	}
	
	private JTextField getJTextFieldStaffPosition() {
		if (jTextFieldStaffPosition == null) {
			jTextFieldStaffPosition = new JTextField();
			//Only manager should be able to change
			if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager"))	 
				jTextFieldStaffPosition.setEditable(true);
			else
				jTextFieldStaffPosition.setEditable(false);
			jTextFieldStaffPosition.setBounds(new Rectangle(609, 358, 216, 37));
			jTextFieldStaffPosition.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffPosition.setBackground(Color.WHITE);
			jTextFieldStaffPosition.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					boolean validStaffPosition = true;
					String position=jTextFieldStaffPosition.getText();
					// For empty spaces
					if (position.length()==0) {
						validStaffPosition = false;
						checkPosition.setText("Please enter the position.");
						checkPosition.setForeground(Color.red);
						checkPosition.setVisible(true);
					} else if (validStaffPosition == true) {
						checkPosition.setText("");
					} else
						checkGender.setVisible(false); // 
				}
			});

		}
		return jTextFieldStaffPosition;
	}
	
	private JScrollPane getScrollPaneContainingStaffTextPanes() {
		if (ScrollPaneContainingStaffTextPanes == null) {
			ScrollPaneContainingStaffTextPanes = new JScrollPane();
			ScrollPaneContainingStaffTextPanes.setBounds(232, 119, 138, 413);
			ScrollPaneContainingStaffTextPanes.setViewportBorder(null);
			ScrollPaneContainingStaffTextPanes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			ScrollPaneContainingStaffTextPanes.setBackground(new Color(227, 228, 250));
			panelWithStaffTextPanes = new JPanel();
			ScrollPaneContainingStaffTextPanes.setViewportView(panelWithStaffTextPanes);
			panelWithStaffTextPanes.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelWithStaffTextPanes.setBackground(new Color(227,228,250));
			panelWithStaffTextPanes.setLayout(null);
		}
		return ScrollPaneContainingStaffTextPanes;
	}
	
	private JLabel getJLabelBack() {
		if (jLabelBack == null) {
			jLabelBack = new JLabel();
			jLabelBack.setText("");
			jLabelBack.setSize(new Dimension(128, 128));
			jLabelBack.setLocation(new Point(-13, -25));
			jLabelBack.setIcon(new ImageIcon(getClass().getResource(
					"/simplyTECH/image/Swap Left.png")));
			jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					JPanel panel = new StaffMainPage(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jLabelBack;
	}

private JPasswordField getJPasswordField() {
	if (jPasswordField == null) {
		jPasswordField = new JPasswordField();
		jPasswordField.setEditable(authorised());
		jPasswordField.setBounds(new Rectangle(608, 419, 216, 32));
		
		jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				String inputedPassword = new String(jPasswordField.getPassword());
				jProgressBar.setValue(0);
				jProgressBar.setVisible(true);

				boolean lengthSatisfied = false;
				boolean strongPassword = false;
				// password minimum 8 chars		
				// jprogress bar shows password strength
				if (inputedPassword.length() < 8) {
					checkPassword.setText("Weak Password");
					checkPassword.setForeground(Color.red);
					jProgressBar.setValue(33);
				}
				// medium strength password must contain numbers,
				// strong password must contain special characters
				if (inputedPassword.length() >= 8) {
					lengthSatisfied = true;
					jProgressBar.setValue(33);
					//Count letters, digits, and other char
					int letter = 0, digit = 0, other = 0;
					for (int i = 0; i < inputedPassword.length(); i++) {
						char c = inputedPassword.charAt(i);
						if (Character.isLetter(c)) 
							letter++;
						else if (Character.isDigit(c))
							digit++;
						else
							other++;

					}
					if ((letter > 0) && (digit > 0) && (other > 0)) {
						strongPassword = true;

					}
					if ((letter > 0) && (digit > 0) && (other == 0)) {

						checkPassword.setText("Medium Password");
						checkPassword.setForeground(Color.red);
						jProgressBar.setValue(66);
					}

				}
				if (strongPassword && lengthSatisfied) {

					checkPassword.setText("Strong Password");
					checkPassword.setForeground(Color.red);
					jProgressBar.setValue(100);
				}
			}
		});

	}
	return jPasswordField;
}
private JPasswordField getJPasswordFieldConfirmPassword() {
	if (jPasswordFieldConfirmPassword == null) {
		jPasswordFieldConfirmPassword = new JPasswordField();
		jPasswordFieldConfirmPassword.setEditable(authorised());

		jPasswordFieldConfirmPassword.setBounds(new Rectangle(606, 478, 216, 32));
		jPasswordFieldConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				String InputedPassword = new String(jPasswordField.getPassword());
				String confirmPassword = new String(jPasswordFieldConfirmPassword.getPassword());
				// password confirmation = password?
				if (!InputedPassword.equals(confirmPassword)) {
					checkPassword.setText("Password not match");
					checkPassword.setForeground(Color.red);
				} else
					checkPassword.setText("Valid password change");
			}
		});
	}
	return jPasswordFieldConfirmPassword;
}
	private JLabel getJlabelConfirmPassword() {
		if (jlabelConfirmPassword == null) {
			jlabelConfirmPassword = new JLabel();
			jlabelConfirmPassword.setText("Confirm password:");
			jlabelConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 30));
			jlabelConfirmPassword.setBounds(new Rectangle(456, 145, 138, 50));
			jlabelConfirmPassword.setBounds(372, 465, 235, 50);
		}
		return jlabelConfirmPassword;
	}
	
	private ArrayList<JTextPane> createStaffTextPanes() {
		//1st textpane y coordinate is 136
		int yValue = 30;
		int loopCount=1;
		
		for (int i = 0; i < staffArray.size(); i++) {
				if (staffArray!=null) {
					String name = staffArray.get(i).getName();
					
					JTextPane staffTextPane = new JTextPane();
					staffTextPane.setBounds(new Rectangle(0, yValue, 150, 36));
					//Prepare y value for next pane
					yValue+=50;
					
					staffTextPane.setBackground(new Color(91, 155, 213));
					staffTextPane.setFont(new Font("Calibri", Font.BOLD, 18));
					staffTextPane.setForeground(Color.white);
					staffTextPane.setEditable(false);
					staffTextPane.setText(name);
					staffTextPane.setName(i + "");
					staffTextPanes.add(staffTextPane);
					//Set for 1st textPane's info to show initially
					selectedStaff=staffArray.get(0);
					staffTextPanes.get(0).setBackground(new Color(31, 78, 121));
					jTextFieldStaffUsername.setText(selectedStaff.getUsername());
					jTextFieldStaffEmail.setText(selectedStaff.getEmail());			
					jTextFieldStaffMobile.setText(selectedStaff.getMobile());
					jTextFieldStaffGender.setText(selectedStaff.getGender());
					jTextFieldStaffPosition.setText(selectedStaff.getPosition());
					
					//Stuff that happens when a TextPane is clicked
					staffTextPane.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent arg0) {
							//For later methods
							String selectedStaffUsername = null;
							//Reset all error msg
							checkPassword.setText("");
							checkConfirmPassword.setText("");
							checkMobile.setText("");
							checkGender.setText("");
							checkPosition.setText("");
							checkEmail.setText("");
							//Change bg color when clicked
							for (int i = 0; i < staffTextPanes.size(); i++) {
								staffTextPanes.get(i).setBackground(
										new Color(91, 155, 213));
							}
							//Extract info for selected TextPane
							selectedTextPane = (JTextPane) (arg0.getSource());
							//Look for name in staffArray and find his username
							for (int i=0; i<staffArray.size(); i++) {
								if (staffArray.get(i).getName().equals(selectedTextPane.getText())) {
									selectedStaffUsername=staffArray.get(i).getUsername();
									System.out.println("selectedStaffUsername = "+ selectedStaffUsername);
								}
							}
							//Create the Staff of selectedTextPane
							Person selectedPerson=PersonDAO.searchByUsername(selectedStaffUsername);
							selectedStaff = StaffDAO.createById(selectedPerson.getId());
							//Reset authorised
							jTextFieldStaffEmail.setEditable(authorised());
							jTextFieldStaffMobile.setEditable(authorised());
							jTextFieldStaffGender.setEditable(authorised());
							jPasswordField.setEditable(authorised());
							jPasswordFieldConfirmPassword.setEditable(authorised());
							
							selectedTextPaneUsername = selectedStaff.getUsername();
							selectedTextPaneEmail = selectedStaff.getEmail();
							selectedTextPaneMobile = selectedStaff.getMobile();
							selectedTextPaneGender = selectedStaff.getGender();
							selectedTextPanePosition = selectedStaff.getPosition();
							
							//Set info for selected textPane
							jTextFieldStaffUsername.setText(selectedTextPaneUsername);
							jTextFieldStaffEmail.setText(selectedTextPaneEmail);
							jTextFieldStaffMobile.setText(selectedTextPaneMobile);
							jTextFieldStaffGender.setText(selectedTextPaneGender);
							jTextFieldStaffPosition.setText(selectedTextPanePosition);
							
							int indexOfStaffTextPanesWhoHasSelectedStaffName=-1;
							for(int i=0; i<staffTextPanes.size(); i++) {
								if (staffTextPanes.get(i).getText().equals(selectedTextPane.getText())) {//Find index of text pane who has same text as the selected textpane
									indexOfStaffTextPanesWhoHasSelectedStaffName=i;
								}
							}
							if (indexOfStaffTextPanesWhoHasSelectedStaffName==-1)
								System.out.println("Error");
							else
							staffTextPanes.get(indexOfStaffTextPanesWhoHasSelectedStaffName).setBackground(new Color(31, 78, 121));//set bg color of selected textpane to indicate selection
						}
					});
					//Adding non-selected text pane (Other non selected text panes added when this for loop finishes)
					panelWithStaffTextPanes.add(staffTextPanes.get(loopCount-1));
					panelWithStaffTextPanes.setSize(200, staffTextPanes.size() * 100);
					panelWithStaffTextPanes.setPreferredSize(panelWithStaffTextPanes.getSize());
					loopCount++;
				}
			}
		return staffTextPanes;
	}
}