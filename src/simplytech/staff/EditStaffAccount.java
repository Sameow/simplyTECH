package simplytech.staff;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;

import simplytech.dao.StaffManagementDAO;
import simplytech.entity.Staff;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class EditStaffAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JLabel jLabelBar = null;
	private JLabel jLabelEditStaffAccount = null;
	private JLabel jLabelAccountDetails;
	private JLabel jLabelName;
	private JLabel jLabelUsername;
	private JLabel jLabelMobile;
	private JLabel jLabelGender;
	private JLabel jLabelPosition;
	private JTextField jTextFieldStaffName = null;
	private JTextField jTextFieldStaffUsername = null;
	private JTextField jTextFieldStaffMobile = null;
	private JTextField jTextFieldStaffGender = null;
	private JTextField jTextFieldStaffPosition = null;
	private JLabel jLabelSave;
	private  ArrayList<Staff> staffArray;
	private String selectedTextPaneName;
	private String selectedTextPaneUsername;
	private String selectedTextPaneMobile; 	
	private String selectedTextPaneGender; 
	private String selectedTextPanePosition;
	private JScrollPane ScrollPaneContainingStaffTextPanes;
	private JPanel panelWithStaffTextPanes;
	private JLabel checkMobile = null;
	private JLabel checkUsername=null;
	private JLabel checkGender=null;
	private JLabel checkPosition=null;
	private JLabel jLabelBack = null;
	
	ArrayList<JTextPane> staffTextPanes=new ArrayList<JTextPane>();
	private JLabel lblNewLabel;

	public EditStaffAccount() {
		super();
		initialize();
	}

	public EditStaffAccount(JFrame f) {
		super();
		myFrame = f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws SQLException 
	 */
	private void initialize(){
		jLabelSave = new JLabel();
		jLabelSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Get Id of person who you are trying to change
				int idOfPersonUpdated=0;
				if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager")) {//Manager can change anyone's details
					JTextPane selectedTextPane = null;
					//Get selected staff and get his name
					for (int i=0; i<staffTextPanes.size(); i++){
						if (staffTextPanes.get(i).getBackground().equals(new Color(31, 78, 121)))
							selectedTextPane = staffTextPanes.get(i);
					}
					String nameOfPersonUpdated=selectedTextPane.getName();
					//Loop through every staff and compare name
					for (int i=0; i<staffArray.size(); i++) {
						if (staffArray.get(i).getName().equals(nameOfPersonUpdated)){
							//if matching staff is found, get his ID
							idOfPersonUpdated=staffArray.get(i).getId();
						}
					}
						
				}
				else {//Login-ed person can change his own details
					idOfPersonUpdated=MainFrame.getPersonWhoLogin().getId();
				}
				System.out.println("Id of person updated = "+idOfPersonUpdated);
				//Get user input
				String changedUsername = jTextFieldStaffUsername.getText();
				String changedMobile=jTextFieldStaffMobile.getText();
				String changedGender=jTextFieldStaffGender.getText();
				String changedPosition=jTextFieldStaffPosition.getText();
				//Get error messages
				String usernameErrorMsg = checkUsername.getText();
				String mobileErrorMsg = checkMobile.getText();
				String genderErrorMsg = checkGender.getText();
				String positionErrorMsg = checkPosition.getText();

				if (usernameErrorMsg.equals("Please enter your username.") || 
					mobileErrorMsg.equals("Invalid mobile number") || 
					mobileErrorMsg.equals("Please enter your mobile no.") ||
					genderErrorMsg.equals("Please enter your gender.") || 
					genderErrorMsg.equals("Invalid gender") ||
					positionErrorMsg.equals("Please enter the position.")) {
					JOptionPane.showMessageDialog(null,
							"Please check your details", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} 
				else {
					if (StaffManagementDAO.updateStaff(idOfPersonUpdated, changedUsername, changedMobile, changedGender, changedPosition)) {
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
				
			}
		});
		jLabelSave.setBounds(new Rectangle(675, 494, 176, 43));
		jLabelSave.setBackground(new Color(91, 155, 213));
		jLabelSave.setForeground(Color.white);
		jLabelSave.setText("Save");
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
		jLabelPosition = new JLabel();
		jLabelPosition.setBounds(new Rectangle(420, 432, 125, 37));
		jLabelPosition.setText("Position:");
		jLabelPosition.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(429, 361, 130, 50));
		jLabelGender.setText("Gender:");
		jLabelGender.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelMobile = new JLabel();	
		jLabelMobile.setBounds(new Rectangle(434, 289, 125, 50));
		jLabelMobile.setText("Mobile:");
		jLabelMobile.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelUsername = new JLabel();
		jLabelUsername.setBounds(new Rectangle(397, 221, 148, 50));
		jLabelUsername.setText("Username:");
		jLabelUsername.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(456, 145, 138, 50));
		jLabelName.setFont(new Font("Calibri", Font.BOLD, 30));
		jLabelName.setText("Name:");
		jLabelAccountDetails = new JLabel();
		jLabelAccountDetails.setBounds(new Rectangle(546, 82, 290, 40));
		jLabelAccountDetails.setFont(new Font("Calibri", Font.BOLD, 36));
		jLabelAccountDetails.setText("Account Details");	
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelEditStaffAccount, null);
		this.add(getJLabelBack());
		
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
		this.add(jLabelAccountDetails, null);
		this.add(jLabelName, null);
		this.add(jLabelUsername, null);
		this.add(jLabelMobile, null);
		this.add(jLabelGender, null);
		this.add(jLabelPosition, null);
		this.add(getJTextFieldStaffName(), null);
		this.add(getJTextFieldStaffUsername(), null);
		this.add(getJTextFieldStaffMobile(), null);
		this.add(getJTextFieldStaffGender(), null);
		this.add(getJTextFieldStaffPosition(), null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBar, null);
		this.add(jLabelSave, null);
		add(getScrollPaneContainingStaffTextPanes());
		
		checkUsername = new JLabel("");
		checkUsername.setBounds(833, 224, 189, 47);
		add(checkUsername);
		
		checkMobile = new JLabel("");
		checkMobile.setBounds(833, 292, 189, 47);
		add(checkMobile);
		
		checkGender = new JLabel("");
		checkGender.setBounds(833, 364, 189, 47);
		add(checkGender);
		
		checkPosition = new JLabel("");
		checkPosition.setBounds(833, 422, 189, 47);
		add(checkPosition);
		
		lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(577, 291, 28, 40);
		add(lblNewLabel);
		
		JLabel lblCreateStaff = new JLabel();
		lblCreateStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
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
		lblCreateStaff.setBounds(34, 119, 176, 43);
		add(lblCreateStaff);
		
		JLabel labelDeleteStaff = new JLabel();
		labelDeleteStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		labelDeleteStaff.setText("Delete Staff");
		labelDeleteStaff.setOpaque(true);
		labelDeleteStaff.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteStaff.setForeground(Color.WHITE);
		labelDeleteStaff.setBounds(new Rectangle(675, 494, 176, 43));
		labelDeleteStaff.setBackground(new Color(91, 155, 213));
		labelDeleteStaff.setBounds(34, 190, 176, 43);
		add(labelDeleteStaff);
		
		createStaffTextPanes();
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

	private JTextField getJTextFieldStaffName() {
		if (jTextFieldStaffName == null) {
			jTextFieldStaffName = new JTextField();
			jTextFieldStaffName.setBounds(new Rectangle(607, 145, 216, 50));
			jTextFieldStaffName.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffName.setBackground(Color.WHITE);
			jTextFieldStaffName.setText("");
			jTextFieldStaffName.setEditable(false);
		}
		return jTextFieldStaffName;
	}

	//All the validation for every text field should have a parent class containing 
	//standard validating, child class should have all other validation unique to whatever it is validating, but no time to do.
		
	private JTextField getJTextFieldStaffUsername() {
		if (jTextFieldStaffUsername == null) {
			jTextFieldStaffUsername = new JTextField();
			jTextFieldStaffUsername.setEditable(true);
			//Only account holder or manager should be able to change
//			System.out.println("jTextFieldStaffUsername.getText() = "+jTextFieldStaffUsername.getText());
//			if (MainFrame.getPersonWhoLogin().getUsername().equals(jTextFieldStaffUsername.getText())
//					&& MainFrame.getPersonWhoLogin().getUsername().equals("Manager")
//					)	 {
//				jTextFieldStaffUsername.setEditable(true);
//			}
			jTextFieldStaffUsername.setBounds(new Rectangle(607, 221, 216, 50));
			jTextFieldStaffUsername.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffUsername.setText("");
			jTextFieldStaffUsername.setBackground(Color.WHITE);
			jTextFieldStaffUsername.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String username = jTextFieldStaffUsername.getText();
					//For empty spaces
					if (username.length() == 0) {
						checkUsername.setText("Please enter your username.");
						checkUsername.setForeground(Color.red);
						checkUsername.setVisible(true);
					} 
					 else {
						checkUsername.setVisible(false); 
					}
				}
			});
		}
		return jTextFieldStaffUsername;
	}

	private JTextField getJTextFieldStaffMobile() {
		if (jTextFieldStaffMobile == null) {
			jTextFieldStaffMobile = new JTextField();
			jTextFieldStaffMobile.setEditable(true);
			//Only account holder or manager should be able to change
//			if (!MainFrame.getPersonWhoLogin().getUsername().equals(jTextFieldStaffUsername.getText())
//					&& !MainFrame.getPersonWhoLogin().getUsername().equals("Manager")
//					)	 {
//				jTextFieldStaffMobile.setEditable(false);
//			}
			jTextFieldStaffMobile.setBounds(new Rectangle(607, 289, 216, 50));
			jTextFieldStaffMobile.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldStaffMobile.setText("");
			jTextFieldStaffMobile.setBackground(Color.WHITE);
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
					} else {
						validStaffMobile = false;
					}
					// For empty spaces
					if (mobile.length() == 0) {
						validStaffMobile = false;
						checkMobile.setText("Please enter your mobile no.");
						checkMobile.setForeground(Color.red);
						checkMobile.setVisible(true);
					} else if (validStaffMobile == true) {
						checkMobile.setText("");
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
			jTextFieldStaffGender.setBounds(new Rectangle(607, 361, 216, 50));
			jTextFieldStaffGender.setEditable(true);
			//Only account holder or manager should be able to change
//			if (!MainFrame.getPersonWhoLogin().getUsername().equals(jTextFieldStaffUsername.getText())
//					&& !MainFrame.getPersonWhoLogin().getUsername().equals("Manager")
//					)	 {
//				jTextFieldStaffGender.setEditable(false);
//			}
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
							char gender = checkForNoInput.toUpperCase().charAt(0);
							if (gender=='M' || gender=='F')	 {
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

	private JTextField getJTextFieldStaffPosition() {
		if (jTextFieldStaffPosition == null) {
			jTextFieldStaffPosition = new JTextField();
			jTextFieldStaffPosition.setEditable(false);
			//Only manager should be able to change
			if (MainFrame.getPersonWhoLogin().getPosition().equals("Manager"))	 {
				jTextFieldStaffPosition.setEditable(true);
			}
			jTextFieldStaffPosition.setBounds(new Rectangle(607, 432, 216, 37));
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
			ScrollPaneContainingStaffTextPanes.setBounds(232, 119, 138, 422);
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
	
	private ArrayList<JTextPane> createStaffTextPanes() {
		//Gather all staff details
		try {
			staffArray=StaffManagementDAO.retrieveAll();
		} catch (SQLException e) {
			System.err.println("Unable to retrieve staff details");
		}
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
					staffTextPanes.get(0).setBackground(new Color(31, 78, 121));
					jTextFieldStaffName.setText((staffArray.get(0).getName()));
					jTextFieldStaffUsername.setText(staffArray.get(0).getUsername());
					jTextFieldStaffMobile.setText(staffArray.get(0).getMobile());
					jTextFieldStaffGender.setText(staffArray.get(0).getGender());
					jTextFieldStaffPosition.setText(staffArray.get(0).getPosition());
					
					//Stuff that happens when a TextPane is clicked
					staffTextPane.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent arg0) {
							//Change bg color when clicked
							for (int i = 0; i < staffTextPanes.size(); i++) {
								staffTextPanes.get(i).setBackground(
										new Color(91, 155, 213));
							}
							//Extract info for selected TextPane
							JTextPane selectedTextPane = (JTextPane) (arg0.getSource());
							String stringID = selectedTextPane.getName();
							int id = Integer.parseInt(stringID);
							selectedTextPaneName = staffArray.get(id).getName();
							selectedTextPaneUsername = staffArray.get(id).getUsername();
							selectedTextPaneMobile = staffArray.get(id).getMobile();
							selectedTextPaneGender = staffArray.get(id).getGender();
							selectedTextPanePosition = staffArray.get(id).getPosition();
							//Set info for selected textPane
							jTextFieldStaffName.setText(selectedTextPaneName);
							jTextFieldStaffUsername.setText(selectedTextPaneUsername);
							jTextFieldStaffMobile.setText(selectedTextPaneMobile);
							jTextFieldStaffGender.setText(selectedTextPaneGender);
							jTextFieldStaffPosition.setText(selectedTextPanePosition);
							staffTextPanes.get(id).setBackground(
									new Color(31, 78, 121));
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
}
