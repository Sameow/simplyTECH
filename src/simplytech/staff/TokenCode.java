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
	private boolean creatingTokenCode;
	private JLabel jLabelBack = null;
	private static String tokenCode="";

	/**
	 * This is the default constructor
	 */
	public TokenCode() {
		super();
		tokenCode=createTokenCode();
		initialize();
	}

	public TokenCode(JFrame f) {
		this();
		myFrame=f;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
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
		this.add(getJLabelBack());
	}
	
	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setEditable(false);
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBackground(new Color(227,228,250));
			errorMessage.setBounds(708, 238, 135, 67);
			System.out.println("creatingTokenCode = "+creatingTokenCode);
			if (tokenCode=="") {
				errorMessage.setForeground(Color.BLACK);
				errorMessage.setText("Sending token code to email...");
			}
			else {
				errorMessage.setText("Check email for token code.");
			}
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

	/**
	 * This method initializes jPasswordFieldTokenCode	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
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
					JPanel panel = new WelcomePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jLabelBack;
	}
	
	public static String createTokenCode(){
		//Generate token code
		String newTokenCodeToBeInsertedToDB=Integer.toString(TokenCodeGenerator.newTokenCode());
		System.out.println("String newTokenCodeToBeInsertedToDB = "+newTokenCodeToBeInsertedToDB);
		//Encrypt it.
		DesEncryption encrypter = new DesEncryption("Password");
		String encrypted = encrypter.encrypt(newTokenCodeToBeInsertedToDB);
		//Send email
		boolean emailSent = sendEmail(MainFrame.getPersonWhoLogin().getEmail(), MainFrame.getPersonWhoLogin().getName(), newTokenCodeToBeInsertedToDB);
		if (emailSent)
			System.err.println("Email sent");
		else
			System.err.println("Email not sent");
		return encrypted;
	}
	
	public static boolean sendEmail(String recipientEmail, String recipientName, String newTokenCode) {
		System.out.println("recipient Email = "+recipientEmail);
		final String username = "simplytechcm@gmail.com";
		final String password = "oopjpass";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(recipientEmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipientEmail));
			message.setSubject("Token Code");
			message.setText("Dear " + recipientName + ","
					+ "\n\nYour token code is: " + newTokenCode
					+ "\n\nRegards, \nSamuel Ong, \nHead of Security Department");
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
	
	public static boolean checkTokenCode(String userInputTokenCode){
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
