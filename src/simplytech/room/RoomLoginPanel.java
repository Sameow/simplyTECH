package simplytech.room;

//import RegisterPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import simplytech.components.DesEncryption;
import simplytech.components.MACAddress;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.Customer;
import simplytech.entity.Person;

public class RoomLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLogoForLobby = null;
	private JLabel jSignInText = null;
	private JLabel jLabelUsername = null;
	private JLabel jLabelPassword = null;
	private static JTextField jTextFieldUsername = null;
	private JButton jButtonLogin = null;
	private JLabel jLabelForgotPassword = null;
	private JLabel jLabelSTLogo = null;
	private JFrame myFrame = null;
	Scanner sc = new Scanner(System.in);
	private JPasswordField jPasswordFieldPassword = null;
	private JLabel jLabelBackgroundLL = null;
	private JTextPane jTextPane = null;
	private String username1;
	private JTextPane errorMessage;
	private boolean allowed = false;
	private Customer customer = null;

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	/**
	 * This is the default constructor
	 */

	public RoomLoginPanel() {
		super();
		initialize();
	}

	public RoomLoginPanel(JFrame f) {
		this();
		myFrame = f;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabelBackgroundLL = new JLabel();
		jLabelBackgroundLL.setBounds(new Rectangle(130, -49, 537, 713));
		jLabelBackgroundLL.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/Image/Unnamed QQ Screenshot20121128212242.png")));
		jLabelBackgroundLL.setText("");
		jLabelSTLogo = new JLabel();
		jLabelSTLogo.setBounds(new Rectangle(830, 555, 65, 46));
		jLabelSTLogo.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/Image/simplyTECH(Small)(LightBlue).png")));
		jLabelSTLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelSTLogo.setText("");
		jLabelForgotPassword = new JLabel();
		jLabelForgotPassword.setBounds(new Rectangle(764, 494, 149, 18));
		jLabelForgotPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelForgotPassword.setText("Forgot your password?");
		jLabelForgotPassword
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						JPanel panel = new ForgotPasswordPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
				});
		jLabelPassword = new JLabel();
		jLabelPassword.setBounds(new Rectangle(620, 303, 75, 30));
		jLabelPassword.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelPassword.setText("Password:");
		jLabelUsername = new JLabel();
		jLabelUsername.setBounds(new Rectangle(615, 267, 80, 32));
		jLabelUsername.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelUsername.setText("Username:");
		jSignInText = new JLabel();
		jSignInText.setBounds(new Rectangle(563, 164, 114, 51));
		jSignInText.setFont(new Font("Calibri Light", Font.PLAIN, 36));
		jSignInText.setText("sign in");
		jLogoForLobby = new JLabel();
		jLogoForLobby.setBounds(new Rectangle(545, 51, 322, 81));
		jLogoForLobby.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/Image/CheckMate(LightBlue).PNG")));
		jLogoForLobby.setText("JLabel");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLogoForLobby, null);
		this.add(jSignInText, null);
		this.add(jLabelUsername, null);
		this.add(jLabelPassword, null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJPasswordFieldPassword(), null);
		this.add(getJButtonLogin(), null);
		this.add(jLabelForgotPassword, null);
		this.add(jLabelSTLogo, null);
		this.add(jLabelBackgroundLL, null);
		this.add(getJTextPane(), null);
		this.add(getJPasswordFieldPassword(), null);
		add(getErrorMessage());
	}

	/**
	 * This method initializes jTextFieldUsername
	 * 
	 * @return javax.swing.JTextField
	 */
	private static JTextField getJTextFieldUsername() {

		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setBounds(new Rectangle(705, 272, 123, 26));
			jTextFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		}

		return jTextFieldUsername;
	}

	/**
	 * This method initializes jTextFieldPassword
	 * 
	 * @return javax.swing.JTextField
	 */

	/**
	 * This method initializes jButtonLogin
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLogin() {
		if (jButtonLogin == null) {
			jButtonLogin = new JButton();
			jButtonLogin.setBounds(new Rectangle(686, 387, 96, 40));
			jButtonLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
			jButtonLogin.setBackground(new Color(91, 155, 213));
			jButtonLogin.setForeground(Color.white);
			jButtonLogin.setText("Login");
			jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					errorMessage.setText("");
					String username = jTextFieldUsername.getText();
					String password = new String(jPasswordFieldPassword
							.getPassword());

					Person person = PersonDAO.searchByUsername(username);
					if (person != null) {
						int id = person.getId();
						customer = CustomerDAO.searchById(id);
					}
					if (customer != null) {
						if (customer.getUserType().equals("Customer")) {
							allowed = checkLogin(username, password);
						}
					}
					if (allowed == true) {
						MainFrame.setPersonWhoLogin(customer);
						RoomHomePagePanel rhp = new RoomHomePagePanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(rhp);
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
			DesEncryption encryption = new DesEncryption("Password");
			String decryptPwd = encryption.decrypt(pwd);
			if (decryptPwd.equals(password))
				return true;

		}
		return false;
	}

	/**
	 * This method initializes jPasswordFieldPassword
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getJPasswordFieldPassword() {
		if (jPasswordFieldPassword == null) {
			jPasswordFieldPassword = new JPasswordField();
			jPasswordFieldPassword.setLocation(new Point(705, 306));
			jPasswordFieldPassword.setSize(new Dimension(123, 26));
		}
		return jPasswordFieldPassword;
	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(236, 4));
			jTextPane.setLocation(new Point(669, 481));
		}
		return jTextPane;
	}

	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setEditable(false);
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBackground(new Color(227, 228, 250));
			errorMessage.setBounds(850, 266, 135, 67);
		}
		return errorMessage;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
