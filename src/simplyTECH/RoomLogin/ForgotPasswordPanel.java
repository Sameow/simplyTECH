package simplyTECH.RoomLogin;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.sql.SQLException;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Random;

import simplyTECH.Components.DesEncryption;
import simplyTECH.DatabaseStatements.DBController;
import simplyTECH.dao.PersonDAO;
import simplyTECH.entity.Person;

import java.awt.event.KeyEvent;

public class ForgotPasswordPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JEditorPane jEditorPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JTextField jTextFieldFullName = null;
	private JTextField jTextFieldID = null;
	private JTextField jTextFieldUsername = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel3 = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabel4 = null;
	private JButton jButtonDone = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel51 = null;
	private JLabel jLabel511 = null;
	private JLabel jLabelBack = null;
	private JTextPane errorMessage;
	private static final String
    charset = "!@#$%^&*()0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * This is the default constructor
	 */
	public ForgotPasswordPanel() {
		super();
		initialize();
	}

	public ForgotPasswordPanel(JFrame f){
		this();
		myFrame = f;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			//	System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new RoomLoginPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		//errorMessage.setVisible(false);
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(620, 691, 113, 49));
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/simplyTECHBottomRight.PNG")));
		jLabel4.setText("");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(565, 219, 91, 76));
		jLabel3.setFont(new Font("Calibri Light", Font.PLAIN, 36));
		jLabel3.setText("OR");
		jLabel111 = new JLabel();
		jLabel111.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel111.setText("Username:");
		jLabel111.setSize(new Dimension(178, 33));
		jLabel111.setLocation(new Point(123, 417));
		jLabel111.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel11 = new JLabel();
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setText("ID:");
		jLabel11.setLocation(new Point(123, 332));
		jLabel11.setSize(new Dimension(178, 33));
		jLabel11.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(123, 247, 178, 33));
		jLabel1.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setText("Full name:");
		jLabel2 = new JLabel();
		jLabel2.setText("forgot your password?");
		jLabel2.setLocation(new Point(199, 119));
		jLabel2.setSize(new Dimension(377, 67));
		jLabel2.setFont(new Font("Calibri Light", Font.PLAIN, 34));
		jLabel = new JLabel();
		jLabel.setText("");
		jLabel.setSize(new Dimension(384, 135));
		jLabel.setLocation(new Point(508, 26));
		jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/CheckmateBySimplyTECH.png")));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJEditorPane(), null);
		this.add(jLabel, null);
		this.add(jLabel2, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel111, null);
		this.add(getJTextFieldFullName(), null);
		this.add(getJTextFieldID(), null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJTextPane(), null);
		this.add(jLabel3, null);
		this.add(getJTextPane1(), null);
		this.add(jLabel4, null);
		this.add(getJButtonDone(), null);
		this.add(jLabelBack, null);
		add(getErrorMessage());
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setEditable(false);
			jEditorPane.setLocation(new Point(165, 148));
			jEditorPane.setSize(new Dimension(21, 8));
			jEditorPane.setBackground(new Color(237, 125, 49));
		}
		return jEditorPane;
	}

	/**
	 * This method initializes jTextFieldFullName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFullName() {
		if (jTextFieldFullName == null) {
			jTextFieldFullName = new JTextField();
			jTextFieldFullName.setBounds(new Rectangle(318, 248, 196, 32));
		}
		return jTextFieldFullName;
	}

	/**
	 * This method initializes jTextFieldID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldID() {
		if (jTextFieldID == null) {
			jTextFieldID = new JTextField();
			jTextFieldID.setLocation(new Point(318, 333));
			jTextFieldID.setSize(new Dimension(196, 32));
		}
		return jTextFieldID;
	}

	/**
	 * This method initializes jTextFieldUsername	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setLocation(new Point(318, 417));
			jTextFieldUsername.setSize(new Dimension(196, 32));
		}
		return jTextFieldUsername;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setLocation(new Point(554, 231));
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(1, 300));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setEditable(false);
			jTextPane1.setBounds(new Rectangle(591, 302, 253, 167));
			jTextPane1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			jTextPane1.setBackground(new Color(227, 228, 250));
			jTextPane1.setText("Approach one of our friendly staff with your IC or passport to change your password.");
		}
		return jTextPane1;
	}

	/**
	 * This method initializes jButtonDone	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDone() {
		if (jButtonDone == null) {
			jButtonDone = new JButton();
			jButtonDone.setBounds(new Rectangle(286, 496, 142, 57));
			jButtonDone.setFont(new Font("Calibri", Font.BOLD, 36));
			jButtonDone.setForeground(Color.white);
			jButtonDone.setToolTipText("");
			jButtonDone.setText("Done");
			jButtonDone.setBackground(new Color(91, 155, 213));
			jButtonDone.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					errorMessage.setText("");
//					jLabel5.setVisible(true);
//					jLabel51.setVisible(true);
//					jLabel511.setVisible(true);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				String name = jTextFieldFullName.getText();
				String NRIC = jTextFieldID.getText();
			//	int NRIC = Integer.parseInt(getNRIC);
				String username = jTextFieldUsername.getText();
				Person person = PersonDAO.searchByUsername(username);
				boolean checkIdentity = checkIdentity(name,NRIC,username);
				if (checkIdentity == true){
					System.out.print("Correct!");
					String email = person.getEmail();
					errorMessage.setForeground(Color.blue);
					errorMessage.setText(errorMessage.getText() + "A replacement password has been sent to \n" + email);
					String recipientEmail = person.getEmail();
					String recipientName = person.getName();
					String recipientUsername = person.getUsername();
					int recipientID = person.getId();
					String newPassword = "";
					char[] newChar = new char[10];
					for (int i=0 ; i<10; i++){
			            	newChar[i] = getRandomString(10).charAt(i);
			            	newPassword = newPassword + newChar[i];
			            try {
			                // if you generate more than 1 time, you must
			                // put the process to sleep for awhile
			                // otherwise it will return the same random string
			                Thread.sleep(100);
			            } catch (InterruptedException d) {
			                d.printStackTrace();
			            }
			        }
					sendEmail("simplytechcm@gmail.com","oopjpass",recipientEmail, recipientName, newPassword);
					//DBController db = new DBController();
					//String dbQuery;	
					//db.getConnection();
					DesEncryption encryption = new DesEncryption("Password");
					String inputPassword = encryption.encrypt(newPassword);
					//dbQuery = "UPDATE person SET Password='"+newPassword+"' WHERE Username ='"+recipientUsername+"'";
					try {
						//db.updateRequest("UPDATE person SET Password='"+inputPassword+"' WHERE ID ='"+recipientID+"'");
						PersonDAO.updatePersonPassword(inputPassword,username);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					System.out.print("INCORRECT!");
					errorMessage.setForeground(Color.red);
					errorMessage.setText(errorMessage.getText() + "The credentials do not match! \n");
				}
				
				
				}
			});
		}
		return jButtonDone;
	}
	
	private boolean checkIdentity(String name, String NRIC, String username){
		Person person = PersonDAO.searchByUsername(username);
		if (person != null){
			String name1 = person.getName();
			String nric = person.getNRIC();
			if ( nric.equals(NRIC))
				return true;
		}
		return false;
	}

	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 18));
			errorMessage.setBackground(new Color(227,228,250));
			errorMessage.setBounds(601, 454, 243, 88);
		}
		return errorMessage;
	}

	public void sendEmail(String senderEmail, String senderPassword, String recipientEmail,
			String recipientName, String newPassword){
		final String username = senderEmail;
		final String password = senderPassword;
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(recipientEmail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("untoldlies@live.com"));
			message.setSubject("Replacement Password.");
			message.setText("Dear" + recipientName+","
				+ "\n\n Your new password is: " + newPassword);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	 public static String getRandomString(int length) {
	        Random rand = new Random(System.currentTimeMillis());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i <= length; i++ ) {
	            int pos = rand.nextInt(charset.length());
	            sb.append(charset.charAt(pos));
	        }
	        return sb.toString();
	    }
	
	
}
