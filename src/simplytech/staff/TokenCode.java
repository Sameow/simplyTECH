package simplytech.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import simplytech.components.DesEncryption;
import simplytech.components.TokenCodeGenerator;
import simplytech.entity.Person;


public class TokenCode extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelStaffSignIn = null;
	private JLabel jLabelStaffSignInPict = null;
	private JLabel jLabelCheckmate = null;
	private JLabel jLabelSimplyTech = null;
	private JLabel jLabelRectangular = null;
	private JButton jButtonLogin = null;
	private JLabel jLabelTokenCode = null;
	private JPasswordField jPasswordFieldTokenCode = null;
	private JFrame myFrame=null;
	private JTextPane errorMessage;
	private String tokenCode;
	private JButton jButtonLogout = null;
	/**
	 * This is the default constructor
	 */
	public TokenCode() {
		super();
		initialize();
	}

	public TokenCode(JFrame f, String tokenCode) {
		this();
		myFrame=f;
		this.tokenCode=tokenCode;
	}
	
	
	private void initialize() {
		jLabelTokenCode = new JLabel();
		jLabelTokenCode.setBounds(new Rectangle(63, 253, 207, 46));
		jLabelTokenCode.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelTokenCode.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelTokenCode.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTokenCode.setText("Token Code:");
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setSize(new Dimension(1013, 580));
		this.setLocation(new Point(0, 0));
		getJLabelStaffSignIn();
		this.add(jLabelStaffSignIn, null);
		this.add(jLabelStaffSignInPict, null);
		this.add(jLabelCheckmate, null);
		this.add(jLabelSimplyTech, null);
		this.add(jLabelRectangular, null);
		this.add(getJButtonLogin(), null);
		this.add(jLabelTokenCode, null);
		this.add(getJPasswordFieldTokenCode(), null);
		this.add(getErrorMessage());
		this.add(getJButtonLogout());
	}
	
	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setEditable(false);
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBackground(new Color(227,228,250));
			errorMessage.setBounds(708, 238, 135, 67);
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
			jLabelStaffSignInPict.setBounds(new Rectangle(0, 0, 266, 216));
			jLabelStaffSignInPict.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/StaffSignInImage.png")));
			jLabelStaffSignInPict.setText("");
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
	private JButton getJButtonLogin() {
		if (jButtonLogin == null) {
			jButtonLogin = new JButton();
			jButtonLogin.setBounds(new Rectangle(541, 240, 159, 65));
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
					String userInputTokenCode=new String(jPasswordFieldTokenCode.getPassword());
					boolean login=false;;
					login = checkTokenCode(userInputTokenCode);
					if (login) {
					JPanel panel = new StaffMainPage(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					}
					else
						errorMessage.setText("Invalid token code!");
				}
			});
			
		}
		return jButtonLogin;
	}

	private JButton getJButtonLogout() {
		if (jButtonLogout == null) {
			jButtonLogout = new JButton();
			jButtonLogout.setBounds(new Rectangle(566, 316, 104, 46));
			jButtonLogout.setFont(new Font("Dialog", Font.BOLD, 18));
			jButtonLogout.setText("Logout");
			jButtonLogout.setForeground(Color.white);
			jButtonLogout.setBackground(new Color(91, 155, 213));
			jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainFrame.setPersonWhoLogin(null);
					JPanel panel=new WelcomePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonLogout;
	}
	private JPasswordField getJPasswordFieldTokenCode() {
		if (jPasswordFieldTokenCode == null) {
			jPasswordFieldTokenCode = new JPasswordField();
			jPasswordFieldTokenCode.setBounds(new Rectangle(284, 257, 227, 46));
			jPasswordFieldTokenCode.setToolTipText("Enter token code here!");
			jPasswordFieldTokenCode.setText("");
			jPasswordFieldTokenCode.setEchoChar('*');
		}
		return jPasswordFieldTokenCode;
	}
	
	public boolean checkTokenCode(String userInputTokenCode){
		//Encrypt userInputTokenCode
		DesEncryption encrypter = new DesEncryption("Password");
		String encryptUserInputTokenCode = encrypter.encrypt(userInputTokenCode);
			if (encryptUserInputTokenCode.equals(tokenCode)){
				return true;
			}
			else{
				return false;
			}
	}
}
