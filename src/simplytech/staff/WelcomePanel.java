package simplytech.staff;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import simplytech.components.DesEncryption;
import simplytech.dao.PersonDAO;
import simplytech.dao.StaffDAO;
import simplytech.entity.Person;
import simplytech.entity.Staff;


import java.awt.event.KeyEvent;
import java.net.SocketException;
import java.sql.SQLException;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelStaffSignIn = null;
	private JLabel jLabelStaffID = null;
	private JLabel jLabelPassword = null;
	private JLabel jLabelStaffSignInPict = null;
	private JLabel jLabelCheckmate = null;
	private JLabel jLabelSimplyTech = null;
	private JLabel jLabelRectangular = null;
	private JTextField jTextFieldStaffID = null;
	private JPasswordField jPasswordFieldPassword = null;
	private JButton jButtonLogin = null;
	private JFrame myFrame=null;
	private JLabel jLabelForgotPassword = null;
	private JTextPane errorMessage;
	/**
	 * This is the default constructor
	 */
	public WelcomePanel() {
		super();
	}

	public WelcomePanel(JFrame f) {
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

		jLabelForgotPassword = new JLabel();
		jLabelForgotPassword.setBounds(new Rectangle(735, 492, 168, 18));
		jLabelForgotPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelForgotPassword.setText("Forgot your password?");
		
		jLabelForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {   
			public void mouseExited(java.awt.event.MouseEvent e) {    
				jLabelForgotPassword.setForeground(new Color(51, 51, 51));
			}
			public void mouseEntered(java.awt.event.MouseEvent e) {
				jLabelForgotPassword.setForeground(new Color(99, 96, 97));
			}
			public void mouseClicked(java.awt.event.MouseEvent e) {    
				JPanel panel = new ForgotPasswordPanelStaff(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}   
		
		}
		
		);
		
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		getJLabelStaffSignIn();
		this.add(jLabelStaffSignIn, null);
		this.add(jLabelStaffID, null);
		this.add(jLabelPassword, null);
		this.add(jLabelStaffSignInPict, null);
		this.add(jLabelCheckmate, null);
		this.add(jLabelSimplyTech, null);
		this.add(jLabelRectangular, null);
		this.add(getJTextFieldStaffID(), null);
		this.add(getJPasswordFieldPassword(), null);
		this.add(getJButtonLogin(), null);
		this.add(jLabelForgotPassword, null);
		add(getErrorMessage());
	}

	/**
	 * This method initializes jLabelStaffSignIn	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	
	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setEditable(false);
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBackground(new Color(227,228,250));
			errorMessage.setBounds(572, 249, 135, 67);
		}
		return errorMessage;
	}
	
	private JLabel getJLabelStaffSignIn() {
		if (jLabelStaffSignIn == null) {
			jLabelRectangular = new JLabel();
			jLabelRectangular.setBounds(new Rectangle(360, 469, 651, 11));
			jLabelRectangular.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/Rectangle.png")));
			jLabelRectangular.setText("JLabel");
			jLabelSimplyTech = new JLabel();
			jLabelSimplyTech.setBounds(new Rectangle(780, 134, 198, 36));
			jLabelSimplyTech.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/by simplytech.png")));
			jLabelSimplyTech.setText("");
			jLabelCheckmate = new JLabel();
			jLabelCheckmate.setBounds(new Rectangle(646, 30, 331, 94));
			jLabelCheckmate.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/Checkmate.png")));
			jLabelCheckmate.setText("");
			jLabelStaffSignInPict = new JLabel();
			jLabelStaffSignInPict.setBounds(new Rectangle(3, 1, 266, 216));
			jLabelStaffSignInPict.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/StaffSignInImage.png")));
			jLabelStaffSignInPict.setText("");
			jLabelPassword = new JLabel();
			jLabelPassword.setBounds(new Rectangle(166, 286, 180, 30));
			jLabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelPassword.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelPassword.setText("Password:");
			jLabelPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
			jLabelStaffID = new JLabel();
			jLabelStaffID.setBounds(new Rectangle(167, 239, 175, 29));
			jLabelStaffID.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelStaffID.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelStaffID.setText("Staff ID:");
			jLabelStaffID.setFont(new Font("Calibri", Font.PLAIN, 14));
			jLabelStaffSignIn = new JLabel();
			jLabelStaffSignIn.setBounds(new Rectangle(376, 150, 179, 63));
			jLabelStaffSignIn.setFont(new Font("Arial", Font.BOLD, 18));
			jLabelStaffSignIn.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelStaffSignIn.setHorizontalAlignment(SwingConstants.LEADING);
			jLabelStaffSignIn.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/RedThingy.png")));
			jLabelStaffSignIn.setText("Staff Sign In");
		}
		return jLabelStaffSignIn;
	}

	/**
	 * This method initializes jTextFieldStaffID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldStaffID() {
		if (jTextFieldStaffID == null) {
			jTextFieldStaffID = new JTextField();
			jTextFieldStaffID.setBounds(new Rectangle(376, 239, 181, 33));
			jTextFieldStaffID.setText("");
			jTextFieldStaffID.setToolTipText("Enter your staff ID here");
			jTextFieldStaffID.setColumns(0);
		}
		return jTextFieldStaffID;
	}

	/**
	 * This method initializes jPasswordFieldPassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPassword() {
		if (jPasswordFieldPassword == null) {
			jPasswordFieldPassword = new JPasswordField();
			jPasswordFieldPassword.setBounds(new Rectangle(377, 285, 180, 30));
			jPasswordFieldPassword.setText("");
			jPasswordFieldPassword.setToolTipText("Enter your password here");
			jPasswordFieldPassword.setEnabled(true);
			jPasswordFieldPassword.setEchoChar('*');
		}
		return jPasswordFieldPassword;
	}

	/**
	 * This method initializes jButtonLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLogin() {
		if (jButtonLogin == null) {
			jButtonLogin = new JButton();
			jButtonLogin.setBounds(new Rectangle(376, 343, 166, 65));
			jButtonLogin.setFont(new Font("Dialog", Font.BOLD, 18));
			jButtonLogin.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonLogin.setToolTipText("Click to login!");
			jButtonLogin.setText("");
			jButtonLogin.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/Login.png")));
			jButtonLogin.setPreferredSize(new Dimension(289, 100));
			jButtonLogin.setRolloverEnabled(true);
			jButtonLogin.setBackground(new Color(219, 250, 255));
			 Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2, true); // the third parameter - true, says it's round
			    jButtonLogin.setBorder(roundedBorder);
			jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					errorMessage.setText("Creating token code....");
					//Check credentials
					String username = jTextFieldStaffID.getText();
					String password = new String(jPasswordFieldPassword.getPassword());
					//Create the Staff
					Person person=PersonDAO.searchByUsername(username);
					errorMessage.setText("");
					if (person == null){
						errorMessage.setText("Username does not exist.");
					}
					Staff staff = StaffDAO.createById(person.getId());
					//Exceptions
					if (jTextFieldStaffID.getText().equals("")){
						errorMessage.setText("Please enter your username.");
					}
					
					if (staff.getUserType().equals("Customer")){
						errorMessage.setText("Only Staff can login here.");
					}
					boolean allowed = checkLogin(staff,password);
					
					if (allowed == true){
						
						MainFrame.setPersonWhoLogin(staff);
						JPanel panel=new TokenCode(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();	
					}
					else {
						errorMessage.setText("Invalid username or password");
					}
					
				}
			});
		}
		return jButtonLogin;
	}
	private boolean checkLogin(Person person, String password){
		if (person != null) {
			String pwd = person.getPassword();
			DesEncryption encryption = new DesEncryption("Password");
			String encrypted = encryption.encrypt(pwd);
			String decryptPwd = encryption.decrypt(encrypted);
			if (decryptPwd.equals(pwd)) 
				return true;
		} 
		return false;
	}				

}
