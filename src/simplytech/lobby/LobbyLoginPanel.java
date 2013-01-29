package simplytech.lobby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.net.SocketException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import simplytech.components.DesEncryption;
import simplytech.components.MACAddress;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.Person;
import simplytech.entity.Customer;

public class LobbyLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButtonRegister = null;
	private JFrame myFrame = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel31 = null;
	private JTextField jTextFieldUsername = null;
	private JButton jButtonLogin = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabelForgotPassword = null;
	private JPasswordField passwordField;
	private JLabel errorMessage;
	@SuppressWarnings("unused")
	private DesEncryption encryption = null;
	private boolean allowed = false;

	/**
	 * This is the default constructor
	 */
	public LobbyLoginPanel() {
		super();
		// initialize();
	}

	public LobbyLoginPanel(JFrame f) {
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
		jLabelForgotPassword = new JLabel();
		jLabelForgotPassword.setBounds(new Rectangle(701, 531, 168, 18));
		jLabelForgotPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelForgotPassword.setText("Forgot your password?");
		jLabelForgotPassword
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseExited(java.awt.event.MouseEvent e) {
						jLabelForgotPassword
								.setForeground(new Color(51, 51, 51));
					}

					public void mouseEntered(java.awt.event.MouseEvent e) {
						jLabelForgotPassword
								.setForeground(new Color(99, 96, 97));
					}

					public void mouseClicked(java.awt.event.MouseEvent e) {
						JPanel panel = new ForgotPasswordPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}

				});
		jLabel31 = new JLabel();
		jLabel31.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel31.setText("Password:");
		jLabel31.setLocation(new Point(230, 369));
		jLabel31.setSize(new Dimension(259, 30));
		jLabel31.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(231, 326, 259, 30));
		jLabel3.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel3.setText("Username:");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(268, 195, 230, 95));
		jLabel2.setFont(new Font("Calibri Light", Font.PLAIN, 48));
		jLabel2.setText("sign in");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(133, 37, 417, 156));
		jLabel1.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/CheckmateBySimplyTECH.png")));
		jLabel1.setText("");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(469, -5, 504, 317));
		jLabel.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Capture2.PNG")));
		jLabel.setText("");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJButtonRegister(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getJTextPane(), null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(jLabel31, null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJButtonLogin(), null);
		this.add(getJTextPane1(), null);
		this.add(jLabelForgotPassword, null);
		this.add(getPasswordField());
		this.add(getErrorMessage());
	}

	/**
	 * This method initializes jButtonRegister
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRegister() {
		if (jButtonRegister == null) {
			jButtonRegister = new JButton();
			jButtonRegister.setLocation(new Point(539, 441));
			jButtonRegister.setText("Register");
			jButtonRegister.setFont(new Font("Calibri", Font.PLAIN, 24));
			jButtonRegister.setBackground(new Color(91, 155, 213));
			jButtonRegister.setForeground(Color.white);
			jButtonRegister.setSize(new Dimension(113, 49));
			jButtonRegister
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JPanel panel = new RegisterPanel(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonRegister;
	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(new Rectangle(240, 237, 21, 9));
			jTextPane.setBackground(new Color(237, 125, 49));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextFieldUsername
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setLocation(new Point(520, 326));
			jTextFieldUsername.setSize(new Dimension(171, 30));
		}
		return jTextFieldUsername;
	}

	/**
	 * This method initializes jButtonLogin
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLogin() {
		if (jButtonLogin == null) {
			jButtonLogin = new JButton();
			jButtonLogin.setFont(new Font("Calibri", Font.PLAIN, 24));
			jButtonLogin.setForeground(Color.white);
			jButtonLogin.setText("Login");
			jButtonLogin.setSize(new Dimension(113, 49));
			jButtonLogin.setLocation(new Point(390, 441));
			jButtonLogin.setBackground(new Color(91, 155, 213));
			jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String username = jTextFieldUsername.getText();
					String password = new String(passwordField.getPassword());
					Person personToGetId = PersonDAO.searchByUsername(username);
					Customer customer = null;
					if (personToGetId != null) {
						int id = personToGetId.getId();
						customer = CustomerDAO.searchById(id);
					}
					if (customer != null) {
						if (customer.getUserType().equals("Customer")) {
							allowed = checkLogin(username, password);
						}
					}
					if (allowed) {
						MainFrame.setPersonWhoLogin(customer);
						JPanel panel = new LobbySuite(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					} else {
						errorMessage.setText("Invalid username or password");
					}
					
				}
			});
		}
		return jButtonLogin;
	}

	private boolean checkLogin(String username, String password) {
		Person person = PersonDAO.searchByUsername(username);
		if (person != null) {
			String pwd = person.getPassword();
			DesEncryption de = new DesEncryption("Password");
			String decryptPwd = de.decrypt(pwd);
			if (decryptPwd.equals(password))
				return true;
		}
		return false;
	}

	/**
	 * This method initializes jTextPane1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setLocation(new Point(488, 519));
			jTextPane1.setBackground(new Color(91, 155, 213));
			jTextPane1.setSize(new Dimension(384, 4));
		}
		return jTextPane1;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(597, 393, 153, 37);
			passwordField.setSize(new Dimension(171, 30));
			passwordField.setLocation(new Point(519, 369));
		}
		return passwordField;
	}

	private JLabel getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JLabel("");
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBounds(724, 338, 168, 14);
		}
		return errorMessage;
	}
} // @jve:decl-index=0:visual-constraint="9,6"