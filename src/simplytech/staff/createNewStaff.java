package simplytech.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

import simplytech.components.DesEncryption;
import simplytech.dao.StaffManagementDAO;
import simplytech.entity.Staff;

public class createNewStaff extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBarBelowBackButton = null;
	private JLabel jLabelCreatingStaffAccount = null;

	private JFrame myFrame=null;
	private JButton jButtonSave = null;
	private JLabel jLabelName = null;
	private JLabel jLabelGender = null;
	private JTextField jTextFieldName = null;
	private JTextField jTextFieldGender = null;
	private JTextField jTextFieldUsername = null;
	private JTextField jTextFieldWorkingSince = null;
	private JTextField jTextFieldMobile = null;
	private JTextField jTextFieldPosition = null;
	private JTextField jTextFieldEmail = null;
	private JPasswordField passwordField = null;
	private JPasswordField confirmPasswordField = null;
	private JLabel checkName;
	private JLabel checkGender;
	private JLabel checkUsername;
	private JLabel checkWorkingSince;
	private JLabel checkMobile;
	private JLabel checkPosition;
	private JLabel checkEmail;
	private JLabel jLabelBack = null;
	private JLabel checkPassword;
	
	private JLabel jLabelSave;
	private  ArrayList<Staff> staffArray;
	private JProgressBar jProgressBar = null;
	private JLabel jLabelConfirmPassword;
	/**
	 * This is the default constructor
	 */
	public createNewStaff() {
		super();
		initialize();
	}

	public createNewStaff (JFrame f) {
		this();
		myFrame=f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//Gather staff
				try {
					staffArray=StaffManagementDAO.retrieveAll();
				} catch (SQLException e) {
					System.err.println("Unable to retrieve staff details" +e);
				}
				
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(16, 146, 140, 27));
		jLabelGender.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelGender.setText("Gender:");
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(16, 94, 140, 27));
		jLabelName.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelName.setText("Name:");
		jLabelCreatingStaffAccount = new JLabel();
		jLabelCreatingStaffAccount.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelCreatingStaffAccount.setLocation(new Point(91, 23));
		jLabelCreatingStaffAccount.setSize(new Dimension(317, 35));
		jLabelCreatingStaffAccount.setText("Creating Staff Account");
		jLabelBarBelowBackButton = new JLabel();
		jLabelBarBelowBackButton.setText("");
		jLabelBarBelowBackButton.setLocation(new Point(0, 78));
		jLabelBarBelowBackButton.setBackground(new Color(91, 155, 213));
		jLabelBarBelowBackButton.setSize(new Dimension(371, 4));
		jLabelBarBelowBackButton.setOpaque(true);
		
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelCreatingStaffAccount, null);
		this.add(jLabelBarBelowBackButton, null);
		this.add(getJLabelSave(), null);
		this.add(jLabelName, null);
		this.add(getJTextFieldName(), null);
		this.add(getJTextFieldGender(), null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJTextFieldWorkingSince(), null);
		this.add(getJTextFieldMobile(), null);
		this.add(getJTextFieldPosition(), null);
		this.add(getJTextFieldEmail(), null);
		add(getJPasswordField());
		add(getJPasswordFieldConfirmPassword());
		
		this.add(jLabelGender, null);
		this.add(getJLabelBack());
		
		JLabel jLabelUsername = new JLabel();
		jLabelUsername.setText("Username:");
		jLabelUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelUsername.setBounds(new Rectangle(24, 223, 81, 59));
		jLabelUsername.setBounds(16, 198, 140, 27);
		add(jLabelUsername);
		
		JLabel jLabelPassword = new JLabel();
		jLabelPassword.setText("Password:");
		jLabelPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPassword.setBounds(new Rectangle(24, 223, 140, 59));
		jLabelPassword.setBounds(16, 249, 140, 27);
		add(jLabelPassword);
		
		JLabel jLabelMobile = new JLabel();
		jLabelMobile.setText("Mobile:");
		jLabelMobile.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelMobile.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelMobile.setBounds(16, 287, 140, 27);
		add(jLabelMobile);
		
		JLabel jLabelEmail = new JLabel();
		jLabelEmail.setText("Email:");
		jLabelEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelEmail.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelEmail.setBounds(16, 341, 140, 27);
		add(jLabelEmail);
		
		JLabel jLabelWorkingsince = new JLabel();
		jLabelWorkingsince.setText("Working Since:");
		jLabelWorkingsince.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelWorkingsince.setBounds(new Rectangle(24, 223, 81, 59));
		jLabelWorkingsince.setBounds(16, 389, 140, 27);
		add(jLabelWorkingsince);
		
		JLabel jLabelPosition = new JLabel();
		jLabelPosition.setText("Position:");
		jLabelPosition.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPosition.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelPosition.setBounds(16, 446, 140, 27);
		add(jLabelPosition);
		
		checkName = new JLabel("");
		checkName.setBounds(395, 94, 219, 35);
		add(checkName);
		
		checkGender = new JLabel("");
		checkGender.setBounds(395, 146, 219, 35);
		add(checkGender);
		
		checkUsername = new JLabel("");
		checkUsername.setBounds(395, 191, 219, 35);
		add(checkUsername);
		
		checkWorkingSince = new JLabel("");
		checkWorkingSince.setBounds(395, 389, 219, 35);
		add(checkWorkingSince);
		
		checkMobile = new JLabel("");
		checkMobile.setBounds(395, 287, 219, 35);
		add(checkMobile);
		
		checkPosition = new JLabel("");
		checkPosition.setBounds(395, 438, 219, 35);
		add(checkPosition);
		
		checkEmail = new JLabel("");
		checkEmail.setBounds(395, 341, 219, 35);
		add(checkEmail);
		
		checkPassword = new JLabel("");
		checkPassword.setBounds(395, 237, 185, 35);
		add(checkPassword);
		
		jLabelConfirmPassword = new JLabel();
		jLabelConfirmPassword.setText("Confirm Password:");
		jLabelConfirmPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelConfirmPassword.setBounds(new Rectangle(24, 223, 140, 59));
		jLabelConfirmPassword.setBounds(590, 241, 175, 27);
		add(jLabelConfirmPassword);
		
		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(new Rectangle(832, 478, 147, 32));
		jProgressBar.setVisible(false);
	}

	/**
	 * This method initializes jButtonSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JLabel getJLabelSave() {
		if (jLabelSave == null) {
			jLabelSave = new JLabel();
			jLabelSave.setBounds(new Rectangle(779, 440, 151, 27));
			jLabelSave.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabelSave.setForeground(Color.white);
			jLabelSave.setText("Save");
			jLabelSave.setBackground(new Color(91, 155, 213));
			jLabelSave.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSave.setOpaque(true);
//			Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2, true); // the third parameter - true, says it's round
//		    jLabelSave.setBorder(roundedBorder);
		    jLabelSave.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					
					//Get error messages	
					String emailErrorMsg = checkEmail.getText();
					String mobileErrorMsg = checkMobile.getText();
					String genderErrorMsg = checkGender.getText();
					String positionErrorMsg = checkPosition.getText();
					String passwordErrorMsg = checkPassword.getText();
					String nameErrorMsg = checkName.getText();
					String userNameErrorMsg = checkUsername.getText();
					String workingSinceErrorMsg = checkWorkingSince.getText();
						
					//Get user input
					String newEmail=jTextFieldEmail.getText();
					String newMobile=jTextFieldMobile.getText();
					String newGender=jTextFieldGender.getText().toUpperCase();
					String newPosition=jTextFieldPosition.getText();
					String newName=jTextFieldName.getText();
					String newUsername=jTextFieldUsername.getText();
					String newWorkingSince=jTextFieldWorkingSince.getText();
					//get new password
					DesEncryption encrypter = new DesEncryption("Password");
					String newPassword=encrypter.encrypt(new String(passwordField.getPassword()));
					
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
						passwordErrorMsg.equals("Password not match") ||
						//Put in rest of error msg!!!
						newEmail.equals("") ||
						newMobile.equals("") ||
						newGender.equals("") ||
						newPosition.equals("") ||
						newName.equals("") ||
						newUsername.equals("") ||
						newWorkingSince.equals("")
						) {
						JOptionPane.showMessageDialog(null,
								"Please check the details", "Error!",
								JOptionPane.ERROR_MESSAGE);
					} 
					else {
						int confirmingCreate = JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to create?", "Confirmation", JOptionPane.YES_NO_OPTION);
						if (confirmingCreate == JOptionPane.YES_OPTION) {
						if (StaffManagementDAO.createStaff(newName, newGender, newUsername, newPassword, newMobile, newEmail, newPosition,  newWorkingSince)) {
						JOptionPane.showMessageDialog(null,
								"Staff created!", "Success!",
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
									"Unable to create staff", "Error in if loop!",
									JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}
					
				}
			});
		}
		return jLabelSave;
	}

	/**
	 * This method initializes jTextFieldName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldName() {
		if (jTextFieldName == null) {
			jTextFieldName = new JTextField();
			jTextFieldName.setBounds(new Rectangle(166, 93, 219, 35));
			jTextFieldName.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldName.setBackground(Color.WHITE);
			jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String name=jTextFieldName.getText();
					if (name.length()==0) {
						checkName.setText("Enter name.");
						checkName.setForeground(Color.red);
						checkName.setVisible(true);
					}
					else {	
								checkName.setText("");
							}
					}
					
			});
		}
		return jTextFieldName;
	}
	
	private JTextField getJTextFieldGender() {
		if (jTextFieldGender == null) {
	jTextFieldGender = new JTextField();
	jTextFieldGender.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldGender.setBounds(166, 145, 219, 35);
	jTextFieldGender.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldGender.setBackground(Color.WHITE);
	jTextFieldGender.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {
			String checkForNoInput=jTextFieldGender.getText();
			if (checkForNoInput.length()==0) {
				checkGender.setText("Enter gender.");
				checkGender.setForeground(Color.red);
				checkGender.setVisible(true);
			}
			else {	
					if (checkForNoInput.toUpperCase().charAt(0)=='M' || checkForNoInput.toUpperCase().charAt(0)=='F')	 {
						checkGender.setText("");
					} else {
						checkGender.setText("Invalid gender");
						checkGender.setForeground(Color.red);
						checkGender.setVisible(true);
					}
			}
			
	}});
		}
	return jTextFieldGender;
	}
	
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
	jTextFieldUsername = new JTextField();
	jTextFieldUsername.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldUsername.setBounds(166, 191, 219, 35);
	jTextFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldUsername.setBackground(Color.WHITE);
	jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {
			String username = jTextFieldUsername.getText();
			// For empty spaces
			if (username.length() == 0) {
				checkUsername.setText("Enter username.");
				checkUsername.setForeground(Color.red);
				checkUsername.setVisible(true);
			} 
			else {	//Check for duplicate input in DB
				for (int i=0; i<staffArray.size(); i++) {
					if (staffArray.get(i).getUsername().equals(username)) {
						checkUsername.setText("Username already exists.");
						checkUsername.setForeground(Color.red);
						break;
					}
					else {
						checkUsername.setText("");
					}
				}
			}
			
			} 
		});
		}
	return jTextFieldUsername;
	}
	
	private JTextField getJTextFieldWorkingSince() {
		if (jTextFieldWorkingSince == null) {
	jTextFieldWorkingSince = new JTextField();
	jTextFieldWorkingSince.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldWorkingSince.setBounds(166, 388, 219, 35);
	jTextFieldWorkingSince.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldWorkingSince.setBackground(Color.WHITE);
	jTextFieldWorkingSince.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {
			boolean validDate = true;
			String date = jTextFieldWorkingSince.getText();
			//Check for date format
			Pattern dateFormat = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
//			(			#start of group #1
//					 0?[1-9]		#  01-09 or 1-9
//					 |                  	#  ..or
//					 [12][0-9]		#  10-19 or 20-29
//					 |			#  ..or
//					 3[01]			#  30, 31
//					) 			#end of group #1
//					  /			#  follow by a "/"
//					   (			#    start of group #2
//					    0?[1-9]		#	01-09 or 1-9
//					    |			#	..or
//					    1[012]		#	10,11,12
//					    )			#    end of group #2
//					     /			#	follow by a "/"
//					      (			#	  start of group #3
//					       (19|20)\\d\\d	#	    19[0-9][0-9] or 20[0-9][0-9]
//					       )		#	  end of group #3
			Matcher checkDateFormat = dateFormat.matcher(date);
			boolean match = checkDateFormat.matches();
			if (match) {
				validDate=true;
				checkWorkingSince
				.setText("");
			} else {
				validDate=false;
			}
			// For empty spaces
			if (date.length() == 0) {
				checkWorkingSince.setText("Enter date.");
				checkWorkingSince.setForeground(Color.red);
				checkWorkingSince.setVisible(true);
			} 
			else if (validDate==false){	
				checkWorkingSince.setText("Enter date in dd/mm/yyyy format.");
				checkWorkingSince.setForeground(Color.red);
				checkWorkingSince.setVisible(true);
			} 
			else
				checkWorkingSince.setVisible(false);
		}
		});
		}
		return jTextFieldWorkingSince;
	}
	
	private JTextField getJTextFieldMobile() {
		if (jTextFieldMobile == null) {
	jTextFieldMobile = new JTextField();
	jTextFieldMobile.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldMobile.setBounds(166, 286, 219, 35);
	jTextFieldMobile.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldMobile.setBackground(Color.WHITE);
	jTextFieldMobile.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {
			boolean validStaffMobile = true;
			String mobile = jTextFieldMobile.getText();
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
				checkMobile.setText("Enter mobile no.");
				checkMobile.setForeground(Color.red);
			} else if (validStaffMobile == true) {
				//Check for duplicate input in DB
				for (int i=0; i<staffArray.size(); i++) {
					if (staffArray.get(i).getMobile().equals(mobile)) {
						checkMobile.setText("Number already exists.");
						checkMobile.setForeground(Color.red);
						break;
					}
					else {
						checkMobile.setText("");
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
	return jTextFieldMobile;
	}
	
	private JTextField getJTextFieldPosition() {
		if (jTextFieldPosition == null) {
	jTextFieldPosition = new JTextField();
	jTextFieldPosition.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldPosition.setBounds(166, 438, 219, 35);
	jTextFieldPosition.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldPosition.setBackground(Color.WHITE);
	jTextFieldPosition.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {
			boolean validStaffPosition = true;
			String position=jTextFieldPosition.getText();
			// For empty spaces
			if (position.length()==0) {
				validStaffPosition = false;
				checkPosition.setText("Enter position.");
				checkPosition.setForeground(Color.red);
				checkPosition.setVisible(true);
			} else if (validStaffPosition == true) {
				checkPosition.setText("");
			} else
				checkPosition.setVisible(false); // 
		}
	});
		}
		return jTextFieldPosition;
		}
	
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
	jTextFieldEmail = new JTextField();
	jTextFieldEmail.setBounds(new Rectangle(108, 167, 433, 35));
	jTextFieldEmail.setBounds(166, 340, 219, 35);
	jTextFieldEmail.setFont(new Font("Calibri", Font.PLAIN, 24));
	jTextFieldEmail.setBackground(Color.WHITE);			
	jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent e) {					
			// make sure email contains @ symbol , domain name, ".com"
			boolean validInput = true;
			String email = jTextFieldEmail.getText();
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
				checkEmail.setText("Enter email address.");
				checkEmail.setForeground(Color.red);
			} else if (validInput == true) {
				//Check for duplicate input in DB
				for (int i=0; i<staffArray.size(); i++) {
					if (staffArray.get(i).getEmail().equals(email)) {
						checkEmail.setText("Email already exists.");
						checkEmail.setForeground(Color.red);
						break;
					}
					else {
						checkEmail.setText("");
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
		return jTextFieldEmail;
	}
	
	private JPasswordField getJPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(166, 237, 219, 35);
			passwordField.setFont(new Font("Calibri", Font.PLAIN, 24));
			passwordField.setBackground(Color.WHITE);	
			passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String inputedPassword = new String(passwordField.getPassword());
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
		return passwordField;
	}
	
	private JPasswordField getJPasswordFieldConfirmPassword() {
		if (confirmPasswordField == null) {
			confirmPasswordField = new JPasswordField();
			confirmPasswordField.setBounds(new Rectangle(761, 241, 216, 32));
			confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String InputedPassword = new String(passwordField.getPassword());
					String confirmPassword = new String(confirmPasswordField.getPassword());
					// password confirmation = password?
					if (!InputedPassword.equals(confirmPassword)) {
						checkPassword.setText("Password not matched");
						checkPassword.setForeground(Color.red);
					} else
						checkPassword.setText("");
				}
			});
		}
		return confirmPasswordField;
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
					int confirmingBack = JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (confirmingBack == JOptionPane.YES_OPTION) {
					JPanel panel = new EditStaffAccount(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					}
				}
			});
		}
		return jLabelBack;
	}
}
