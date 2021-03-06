package simplytech.room;

//import LobbyLoginPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import simplytech.components.DesEncryption;
import simplytech.components.MACAddress;
import simplytech.dao.CreditCardDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.*;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.SocketException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyAccountsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabelName = null;
	private JLabel jLabelPoints = null;
	private JLabel jLabelCard = null;
	private JButton jButtonDone = null;
	private JButton jButtonAccountSummary = null;
	private JButton jButtonMyVouchers = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelBtnPoints = null;
	private JLabel jLabelBtnPassword = null;
	private JLabel jLabelBtnCard = null;
	private JLabel jLabelBtnMobile = null;
	private JLabel jLabelBtnUsername = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPaneUsername = null;
	private JTextPane jTextPanePassword = null;
	private JTextPane jTextPaneMobile = null;
	private JTextField textFieldUsername;
	private JFormattedTextField formattedTextFieldMobile;
	private JPasswordField passwordFieldOldPassword;
	private JPasswordField passwordFieldNewPassword;
	private JPasswordField passwordFieldRetypeNewPassword;
	private JTextPane errorMessaegMobile;
	private JTextPane errorMessagePW;
	private JFrame frame = null;
	private JFrame frame2 = null;
	private JFormattedTextField formattedTextFieldCardNumber1;
	private JFormattedTextField formattedTextFieldCardNumber2;
	private JFormattedTextField formattedTextFieldCardNumber3;
	private JFormattedTextField formattedTextFieldCardNumber4;
	private JFormattedTextField formattedTextFieldCVC;
	private JTextPane errorMessageCC;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JTextField textFieldCardholderName;
	private JTextField textFieldCountry;
	private JTextField textFieldStreetAddress;
	private CreditCard CC = new CreditCard();
	private Customer CD = new Customer();
	private String name;
	private String cardType;
	private String username;
	private String newUsername;
	private String cardNumber;
	private boolean checkUsername1 = false;
	private boolean checkUsername2 = false;
	private boolean changeUsername = false;
	private String mobile;
	private String newMobile;
	private String newMobileString;
	private String mobileString;
	private JTextPane errorMessageUsername;
	private boolean changeMobile = false;
	private boolean changePassword = false;
	private String oldPassword;
	private String newPassword;
	private String password;
	private String retypeNewPassword;
	private String email;
	private boolean checkPassword1 = false;
	private boolean checkPassword2 = false;
	private boolean checkPassword3 = false;
	private boolean checkPassword4 = false;
	private boolean checkPassword5 = false;
	private boolean changeCreditCard = false;
	private String newCardNumber;
	private int newExpiryMonth;
	private String newExpiryYear;
	private String newExpiryDate;
	private String newCardHolderName;
	private String newCountry;
	private String newCardType;
	private int newCVC;
	private String newStreetAddress;
	private String updateCardNumber;
	private int updateExpiryMonth;
	private int updateExpiryYear;
	private String updateExpiryDate;
	private String updateCardholderName;
	private String updateCountry;
	private String updateCardType;
	private int updateCVC;
	private String updateStreetAddress;
	// String newCardType;
	private MaskFormatter formatter;
	private MaskFormatter formatter1;
	private boolean checkNewMonth = false;
	private boolean checkNewYear = false;
	private boolean checkCardNumber = false;
	private boolean checkCardholderName = false;
	private boolean checkCountry = false;
	private boolean checkCVC = false;
	private JLabel lblAddress;
	private JTextPane textPaneEmail;
	private JFormattedTextField formattedTextFieldEmail;
	private JLabel label;
	private boolean changeEmail = false;
	private String newEmail;
	private JTextPane errorMessageMail;
	private JLabel label_1;
	private JLabel lblNextPage;
	private Customer customer;
	private String address;
	private String gender;
	private String NRIC;
	private int id;
	private double extraCharges;
	private int stay;
	private String membership;
	private String checkOut;
	private int points;
	private int doNotDisturb;
	String alarm;
	String roomNumber;
	private String userType;
	private String newPwd;
	private boolean checkEmail = false;
	private boolean checkUsernameFinal = false;

	/**
	 * This is the default constructor
	 */
	public MyAccountsPanel() {
		super();
		initialize();
	}

	public MyAccountsPanel(JFrame f) {
		this();
		myFrame = f;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	private void initialize() {

		id = MainFrame.getPersonWhoLogin().getId();
		username = MainFrame.getPersonWhoLogin().getUsername();
		password = MainFrame.getPersonWhoLogin().getPassword();
		mobile = MainFrame.getPersonWhoLogin().getMobile();
		name = MainFrame.getPersonWhoLogin().getName();
		gender = MainFrame.getPersonWhoLogin().getGender();
		NRIC = MainFrame.getPersonWhoLogin().getNRIC();
		email = MainFrame.getPersonWhoLogin().getEmail();
		address = MainFrame.getPersonWhoLogin().getAddress();
		userType = MainFrame.getPersonWhoLogin().getUserType();
		extraCharges = MainFrame.getPersonWhoLogin().getExtraCharges();
		stay = MainFrame.getPersonWhoLogin().getStay();
		membership = MainFrame.getPersonWhoLogin().getMembership();
		checkOut = MainFrame.getPersonWhoLogin().getMembership();
		points = MainFrame.getPersonWhoLogin().getPoints();
		doNotDisturb = MainFrame.getPersonWhoLogin().getDoNotDisturb();
		alarm = MainFrame.getPersonWhoLogin().getAlarm();
		roomNumber = MainFrame.getPersonWhoLogin().getRoomNumber();
		mobileString = mobile + "";

		CreditCard CC = CreditCardDAO.searchById(MainFrame.getPersonWhoLogin()
				.getId());
		cardType = CC.getCardType();
		cardNumber = CC.getCardNumber();
		jLabelBack = new JLabel();
		jLabelBack.setBounds(new Rectangle(-13, -3, 130, 82));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Swap Left.png")));
		jLabelBack.setText("");
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new RoomHomePagePanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});

		jLabelBtnMobile = new JLabel();
		jLabelBtnMobile.setBounds(new Rectangle(361, 371, 41, 16));
		jLabelBtnMobile.setForeground(new Color(58, 115, 255));
		jLabelBtnMobile.setText("edit");
		jLabelBtnMobile.setFont(new Font("Calibri", Font.BOLD, 12));
		jLabelBtnMobile.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jTextPaneMobile.setVisible(false);
				formattedTextFieldMobile.setVisible(true);
				changeMobile = true;
			}
		});
		jLabelBtnCard = new JLabel();
		jLabelBtnCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame2 = new JFrame("Change CreditCard");
				frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame2.setLocationByPlatform(true);
				frame2.setSize(700, 500);
				frame2.setVisible(true);
				frame2.getContentPane().setLayout(null);

				JLabel lblNewLabel = new JLabel("CardNumber:");
				lblNewLabel.setBounds(73, 35, 150, 14);
				lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("Expiry Date:");
				lblNewLabel_1.setBounds(78, 85, 150, 14);
				lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Cardholder Name:");
				lblNewLabel_2.setBounds(43, 185, 150, 14);
				lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Country:");
				lblNewLabel_3.setBounds(95, 235, 150, 14);
				lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Street Address:");
				lblNewLabel_4.setBounds(57, 285, 150, 14);
				lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel_4);

				JLabel lblNewLabel_5 = new JLabel("CVC:");
				lblNewLabel_5.setBounds(120, 135, 46, 14);
				lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
				frame2.getContentPane().add(lblNewLabel_5);

				try {
					formatter = new MaskFormatter("####");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				formattedTextFieldCardNumber1 = new JFormattedTextField(
						formatter);
				formattedTextFieldCardNumber1.setBounds(171, 33, 34, 20);
				formattedTextFieldCardNumber1.setFont(new Font("Calibri",
						Font.PLAIN, 13));
				formattedTextFieldCardNumber1.setColumns(10);
				frame2.getContentPane().add(formattedTextFieldCardNumber1);

				formattedTextFieldCardNumber2 = new JFormattedTextField(
						formatter);
				formattedTextFieldCardNumber2.setBounds(211, 33, 34, 20);
				formattedTextFieldCardNumber2.setFont(new Font("Calibri",
						Font.PLAIN, 13));
				formattedTextFieldCardNumber2.setColumns(10);
				frame2.getContentPane().add(formattedTextFieldCardNumber2);

				formattedTextFieldCardNumber3 = new JFormattedTextField(
						formatter);
				formattedTextFieldCardNumber3.setBounds(251, 33, 34, 20);
				formattedTextFieldCardNumber3.setFont(new Font("Calibri",
						Font.PLAIN, 13));
				formattedTextFieldCardNumber3.setColumns(10);
				frame2.getContentPane().add(formattedTextFieldCardNumber3);

				formattedTextFieldCardNumber4 = new JFormattedTextField(
						formatter);
				formattedTextFieldCardNumber4.setBounds(291, 33, 34, 20);
				formattedTextFieldCardNumber4.setFont(new Font("Calibri",
						Font.PLAIN, 13));
				formattedTextFieldCardNumber4.setColumns(10);
				frame2.getContentPane().add(formattedTextFieldCardNumber4);

				comboBoxMonth = new JComboBox();
				comboBoxMonth.setBounds(171, 82, 77, 20);
				comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {
						"Month", "January", "February", "March", "April",
						"May", "June", "July", "August", "September",
						"October", "November", "December" }));
				frame2.getContentPane().add(comboBoxMonth);

				comboBoxYear = new JComboBox();
				comboBoxYear.setBounds(259, 82, 62, 20);
				comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {
						"Year", "2013", "2014", "2015", "2016", "2017", "2018",
						"2010", "2021", "2022", "2023", "2024", "2025", "2026",
						"2027", "2028", "2029", "2030" }));
				frame2.getContentPane().add(comboBoxYear);

				try {
					formatter1 = new MaskFormatter("###");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				formattedTextFieldCVC = new JFormattedTextField(formatter1);
				formattedTextFieldCVC.setBounds(171, 132, 46, 20);
				formattedTextFieldCVC.setFont(new Font("Calibri", Font.PLAIN,
						13));
				frame2.getContentPane().add(formattedTextFieldCVC);

				textFieldCardholderName = new JTextField();
				textFieldCardholderName.setBounds(171, 182, 150, 20);
				frame2.getContentPane().add(textFieldCardholderName);
				textFieldCardholderName.setColumns(10);

				textFieldCountry = new JTextField();
				textFieldCountry.setColumns(10);
				textFieldCountry.setBounds(171, 232, 150, 20);
				frame2.getContentPane().add(textFieldCountry);

				textFieldStreetAddress = new JTextField();
				textFieldStreetAddress.setColumns(10);
				textFieldStreetAddress.setBounds(171, 282, 150, 20);
				frame2.getContentPane().add(textFieldStreetAddress);

				errorMessageCC = new JTextPane();
				errorMessageCC.setForeground(Color.RED);
				errorMessageCC.setFont(new Font("Calibri", Font.PLAIN, 14));
				errorMessageCC.setBackground(new Color(238, 238, 238));
				errorMessageCC.setBounds(400, 40, 515, 566);
				// errorMessageCC.setText("ASDHIDOASDAS");
				frame2.getContentPane().add(errorMessageCC);

				JButton btnNewButton = new JButton("Done");
				btnNewButton.setBounds(80, 400, 89, 35);
				btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
				btnNewButton.setForeground(Color.white);
				btnNewButton.setBackground(new Color(91, 155, 213));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						errorMessageCC.setText("");
						if (formattedTextFieldCardNumber1.getText().equals(
								"    ")
								|| formattedTextFieldCardNumber2.getText()
										.equals("    ")
								|| formattedTextFieldCardNumber3.getText()
										.equals("    ")
								|| formattedTextFieldCardNumber4.getText()
										.equals("    ")) {
							checkCardNumber = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ "*Card number must not be left blank. \n");
						} else {
							newCardNumber = formattedTextFieldCardNumber1
									.getText()
									+ formattedTextFieldCardNumber2.getText()
									+ formattedTextFieldCardNumber3.getText()
									+ formattedTextFieldCardNumber4.getText();
							checkCardNumber = true;
						}
						String verifyCard = formattedTextFieldCardNumber1
								.getText();
						String stringfirstInt = verifyCard.charAt(0) + "";
						int firstInt = 0;
						try {
							firstInt = Integer.parseInt(stringfirstInt);
						} catch (NumberFormatException nFE) {

						}
						if (firstInt == 3) {
							newCardType = "AMEX";
						} else if (firstInt == 4) {
							newCardType = "VISA";
						} else if (firstInt == 5) {
							newCardType = "MASTERCARD";
						} else {
							newCardType = "OTHERS";
						}
						newExpiryMonth = comboBoxMonth.getSelectedIndex();
						try {
							newExpiryYear = comboBoxYear.getSelectedItem()
									.toString();
						} catch (NumberFormatException nFE) {

						}
						int month;

						switch (newExpiryMonth) {
						case 1:
							month = 1;
							break;
						case 2:
							month = 2;
							break;
						case 3:
							month = 3;
							break;
						case 4:
							month = 4;
							break;
						case 5:
							month = 5;
							break;
						case 6:
							month = 6;
							break;
						case 7:
							month = 7;
							break;
						case 8:
							month = 8;
							break;
						case 9:
							month = 9;
							break;
						case 10:
							month = 10;
							break;
						case 11:
							month = 11;
							break;
						case 12:
							month = 12;
							break;
						default:
							month = 0;
						}
						if (month == 0) {
							checkNewMonth = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ " *Month must not be empty. \n ");
						} else {
							checkNewMonth = true;
						}
						if (newExpiryYear.equals("Year")) {
							checkNewYear = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ "*Year must not be empty.\n ");
						} else {
							checkNewYear = true;
						}
						newExpiryDate = month + " " + newExpiryYear;

						if (formattedTextFieldCVC.getText().equals("   ")) {
							checkCVC = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ "*CVC name must not be empty.\n ");
						} else {
							checkCVC = true;
							newCVC = Integer.parseInt(formattedTextFieldCVC
									.getText());
						}
						if (textFieldCardholderName.getText().equals("")) {
							checkCardholderName = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ "*Cardholder name must not be empty.\n ");
						} else {
							checkCardholderName = true;
							newCardHolderName = textFieldCardholderName
									.getText();
						}
						if (textFieldCountry.getText().equals("")) {
							checkCountry = false;
							errorMessageCC.setText(errorMessageCC.getText()
									+ "*Country name must not be empty.\n ");
						} else {
							checkCountry = true;
							newCountry = textFieldCountry.getText();
						}
						newStreetAddress = textFieldStreetAddress.getText();

						if (checkNewMonth == true && checkNewYear == true
								&& checkCardNumber == true
								&& checkCardholderName && checkCountry == true
								&& checkCVC == true) {

							updateCardNumber = newCardNumber;
							updateExpiryMonth = newExpiryMonth;
							updateExpiryYear = Integer.parseInt(newExpiryYear);
							updateExpiryDate = newExpiryDate;
							updateCardholderName = newCardHolderName;
							updateCountry = newCountry;
							updateCardType = newCardType;
							updateCVC = newCVC;

							updateStreetAddress = newStreetAddress;
							changeCreditCard = true;
							frame2.setVisible(false);

						}

					}
				});
				frame2.getContentPane().add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Cancel");
				btnNewButton_1.setBounds(220, 400, 89, 35);
				btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 20));
				btnNewButton_1.setForeground(Color.white);
				btnNewButton_1.setBackground(new Color(91, 155, 213));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
					}
				});
				frame2.getContentPane().add(btnNewButton_1);

			}
		});
		if (cardType.equals("MASTERCARD")) {
			jLabelBtnCard.setBounds(new Rectangle(411, 321, 41, 16));
		} else {
			jLabelBtnCard.setBounds(new Rectangle(361, 321, 41, 16));
		}
		jLabelBtnCard.setForeground(new Color(58, 115, 255));
		jLabelBtnCard.setText("change");
		jLabelBtnCard.setFont(new Font("Calibri", Font.BOLD, 12));
		jLabelBtnPassword = new JLabel();
		jLabelBtnPassword.setBounds(new Rectangle(361, 275, 41, 16));
		jLabelBtnPassword.setForeground(new Color(58, 115, 255));
		jLabelBtnPassword.setText("edit");
		jLabelBtnPassword.setFont(new Font("Calibri", Font.BOLD, 12));
		jLabelBtnPassword.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				changePassword = true;
				frame = new JFrame("Change Password");
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setSize(350, 350);
				frame.setVisible(true);
				frame.getContentPane().setLayout(null);

				JLabel lblNewLabel = new JLabel("Old Password:");
				lblNewLabel.setBounds(37, 45, 106, 14);
				frame.getContentPane().add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("New password:");
				lblNewLabel_1.setBounds(32, 90, 106, 14);
				frame.getContentPane().add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Retype password:");
				lblNewLabel_2.setBounds(18, 135, 150, 14);
				frame.getContentPane().add(lblNewLabel_2);

				errorMessagePW = new JTextPane();
				errorMessagePW.setBackground(new Color(238, 238, 238));
				errorMessagePW.setForeground(Color.RED);
				errorMessagePW.setFont(new Font("Calibri", Font.PLAIN, 13));
				errorMessagePW.setBounds(40, 160, 230, 75);
				errorMessagePW.setText("");
				frame.getContentPane().add(errorMessagePW);

				passwordFieldOldPassword = new JPasswordField();
				passwordFieldOldPassword.setBounds(150, 45, 100, 20);
				frame.getContentPane().add(passwordFieldOldPassword);

				passwordFieldNewPassword = new JPasswordField();
				passwordFieldNewPassword.setBounds(150, 90, 100, 20);
				frame.getContentPane().add(passwordFieldNewPassword);

				passwordFieldRetypeNewPassword = new JPasswordField();
				passwordFieldRetypeNewPassword.setBounds(150, 135, 100, 20);
				frame.getContentPane().add(passwordFieldRetypeNewPassword);

				JButton btnNewButton = new JButton("Done");
				btnNewButton.setBounds(40, 250, 89, 35);
				btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
				btnNewButton.setForeground(Color.white);
				btnNewButton.setBackground(new Color(91, 155, 213));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						errorMessagePW.setText("");
						oldPassword = passwordFieldOldPassword.getText();
						String passwordCheck1;
						DesEncryption encryption = new DesEncryption("Password");
						passwordCheck1 = encryption.decrypt(MainFrame
								.getPersonWhoLogin().getPassword());
						if (passwordFieldOldPassword.getText().equals("")) {
							errorMessagePW.setText(errorMessagePW.getText()
									+ "*Old password must not be left blank. \n");
						} else {
							checkPassword1 = true;
							if (passwordCheck1.equals(oldPassword)) {
								checkPassword2 = true;
							} else {
								errorMessagePW.setText(errorMessagePW.getText()
										+ "*The password is incorrect. \n");
							}
						}
						newPassword = passwordFieldNewPassword.getText();
						retypeNewPassword = passwordFieldRetypeNewPassword
								.getText();
						if (passwordFieldNewPassword.getText().equals("")) {
							errorMessagePW.setText(errorMessagePW.getText()
									+ "*New password must not be left blank. \n");
						} else {
							checkPassword3 = true;
							if (newPassword.length() < 8) {
								errorMessagePW.setText(errorMessagePW.getText()
										+ "*Password should be at least 8 characters long. \n");
							} else {
								checkPassword4 = true;
							}
						}

						if (newPassword.equals(retypeNewPassword)) {
							checkPassword5 = true;
						} else {
							errorMessagePW.setText(errorMessagePW.getText()
									+ "*The passwords do not match");
						}
						if (checkPassword1 == true && checkPassword2 == true
								&& checkPassword3 == true
								&& checkPassword4 == true
								&& checkPassword5 == true) {
							frame.setVisible(false);
							newPwd = newPassword;
						}

					}
				});
				frame.getContentPane().add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Cancel");
				btnNewButton_1.setBounds(160, 250, 89, 35);
				btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 20));
				btnNewButton_1.setForeground(Color.white);
				btnNewButton_1.setBackground(new Color(91, 155, 213));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// frame.setVisible(false);
						changePassword = false;
						errorMessagePW.setText("");
						frame.setVisible(false);
					}
				});
				frame.getContentPane().add(btnNewButton_1);
			}
		});
		jLabelBtnPoints = new JLabel();
		jLabelBtnPoints.setBounds(new Rectangle(301, 173, 66, 18));
		jLabelBtnPoints.setFont(new Font("Calibri", Font.BOLD, 12));
		jLabelBtnPoints.setForeground(new Color(58, 115, 255));
		jLabelBtnPoints.setText("Redeem");
		jLabelBtnPoints.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new PointsRewardSystemPanel2(myFrame, "MyAccountsPanel");
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(284, 513, 187, 18));
		jLabel4.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabel4.setText("Please call 91234567");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(283, 491, 119, 19));
		jLabel3.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel3.setText("For assistance,");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(562, 109, 433, 246));
		jLabel2.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Background.png")));
		jLabel2.setText("");
		jLabelCard = new JLabel();
		jLabelCard.setText(cardType + " XXX-" + cardNumber.charAt(12)
				+ cardNumber.charAt(13) + cardNumber.charAt(14)

				+ cardNumber.charAt(15));
		jLabelCard.setSize(new Dimension(202, 23));
		jLabelCard.setLocation(new Point(210, 315));
		jLabelCard.setForeground(new Color(120, 120, 120));
		jLabelCard.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelPoints = new JLabel();
		jLabelPoints.setText(points + "");
		jLabelPoints.setSize(new Dimension(67, 23));
		jLabelPoints.setLocation(new Point(210, 169));
		jLabelPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelPoints.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelName = new JLabel();
		jLabelName.setText(name);
		jLabelName.setSize(new Dimension(180, 23));
		jLabelName.setLocation(new Point(210, 119));
		jLabelName.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabel16 = new JLabel();
		jLabel16.setPreferredSize(new Dimension(55, 24));
		jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel16.setText("Card:");
		jLabel16.setLocation(new Point(-27, 315));
		jLabel16.setSize(new Dimension(210, 24));
		jLabel16.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel15 = new JLabel();
		jLabel15.setPreferredSize(new Dimension(55, 24));
		jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel15.setText("Mobile:");
		jLabel15.setLocation(new Point(-27, 365));
		jLabel15.setSize(new Dimension(210, 24));
		jLabel15.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel14 = new JLabel();
		jLabel14.setPreferredSize(new Dimension(55, 24));
		jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel14.setText("Points:");
		jLabel14.setLocation(new Point(-27, 169));
		jLabel14.setSize(new Dimension(210, 24));
		jLabel14.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel13 = new JLabel();
		jLabel13.setPreferredSize(new Dimension(55, 24));
		jLabel13.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel13.setText("Username:");
		jLabel13.setLocation(new Point(-27, 219));
		jLabel13.setSize(new Dimension(210, 24));
		jLabel13.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel11 = new JLabel();
		jLabel11.setPreferredSize(new Dimension(55, 24));
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setText("Password:");
		jLabel11.setLocation(new Point(-27, 269));
		jLabel11.setSize(new Dimension(210, 24));
		jLabel11.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel1 = new JLabel();
		jLabel1.setPreferredSize(new Dimension(55, 24));
		jLabel1.setText("Name:");
		jLabel1.setSize(new Dimension(210, 24));
		jLabel1.setLocation(new Point(-27, 119));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(91, 23, 180, 35));
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("My Account");
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel13, null);
		this.add(jLabel14, null);
		this.add(jLabel15, null);
		this.add(jLabel16, null);
		this.add(jLabelName, null);
		this.add(jLabelPoints, null);
		this.add(jLabelCard, null);
		this.add(getJButtonDone(), null);
		this.add(getJButtonAccountSummary(), null);
		this.add(getJButtonMyVouchers(), null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(jLabel4, null);
		this.add(jLabelBtnPoints, null);
		this.add(jLabelBtnPassword, null);
		this.add(jLabelBtnCard, null);
		this.add(jLabelBtnMobile, null);
		this.add(getJLabelBtnUsername());
		this.add(jLabelBack, null);
		this.add(getJTextPaneUsername(), null);
		this.add(getJTextPanePassword(), null);
		this.add(getJTextPaneMobile(), null);
		this.add(getTextFieldUsername());
		this.add(getTextPane_1());
		try {
			this.add(getFormattedTextFieldMobile());
			this.add(getErrorMessaegMobile());
			this.add(getLblAddress());
			this.add(getTextPaneEmail());
			this.add(getFormattedTextFieldEmail());
			this.add(getLabel());
			this.add(getTextPane_1_1());
			this.add(getLabel_1());
			this.add(getLblNextPage());

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 * @throws ParseException
	 */

	private JFormattedTextField getFormattedTextFieldMobile()
			throws ParseException {
		if (formattedTextFieldMobile == null) {
			MaskFormatter formatter = new MaskFormatter("########");
			formattedTextFieldMobile = new JFormattedTextField(formatter);
			formattedTextFieldMobile
					.setFont(new Font("Calibri", Font.PLAIN, 18));
			formattedTextFieldMobile.setBackground(Color.WHITE);
			formattedTextFieldMobile.setBounds(210, 366, 86, 23);
			formattedTextFieldMobile.setVisible(false);
		}
		return formattedTextFieldMobile;
	}

	private JLabel getJLabelBtnUsername() {
		jLabelBtnUsername = new JLabel();
		jLabelBtnUsername.setBounds(new Rectangle(361, 225, 41, 16));
		jLabelBtnUsername.setForeground(new Color(58, 115, 255));
		jLabelBtnUsername.setText("edit");
		jLabelBtnUsername.setFont(new Font("Calibri", Font.BOLD, 12));
		jLabelBtnUsername.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				changeUsername = true;
				textFieldUsername.setVisible(true);
				jTextPaneUsername.setVisible(false);
			}
		});
		return jLabelBtnUsername;
	}

	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 18));
			textFieldUsername.setBackground(Color.WHITE);
			textFieldUsername.setBounds(210, 219, 86, 23);
			textFieldUsername.setColumns(10);
			textFieldUsername.setVisible(false);
		}
		return textFieldUsername;
	}

	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 78));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jButtonDone
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonDone() {
		if (jButtonDone == null) {
			jButtonDone = new JButton();
			jButtonDone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (changeUsername == true) {
						newUsername = textFieldUsername.getText();
						if (textFieldUsername.getText().equals("")) {
							errorMessageUsername.setText(errorMessageUsername
									.getText()
									+ "*Username must not be left blank. \n");
							checkUsername1 = false;
						} else {
							checkUsername1 = true;
						}
						Person person = PersonDAO
								.searchByUsername(textFieldUsername.getText());
						if (person != null) {
							checkUsername2 = false;
							errorMessageUsername.setText(errorMessageUsername
									.getText() + "*Username is in use. \n");
						} else {
							checkUsername2 = true;
						}

						if (checkUsername1 == true && checkUsername2 == true) {
							checkUsernameFinal = true;
							username = newUsername;
						}
					}

					if (changePassword == true) {
						DesEncryption des = new DesEncryption("Password");
						String finalPassword1 = des.encrypt(newPwd);
						password = finalPassword1;
					}

					if (changeCreditCard == true) {
						CreditCard cc = null;
						cc = new CreditCard(updateCardNumber,
								updateExpiryMonth, updateExpiryYear,
								updateExpiryDate, updateCardholderName,
								updateCountry, updateCVC, updateStreetAddress,
								updateCardType);
						try {
							CreditCardDAO.updateCreditCard(cc, MainFrame
									.getPersonWhoLogin().getId());
							JPanel panel = new MyAccountsPanel(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

					if (changeMobile == true) {
						newMobileString = formattedTextFieldMobile.getText();
						mobile = newMobileString;
					}

					if (changeEmail == true) {
						newEmail = formattedTextFieldEmail.getText();
						if (formattedTextFieldEmail.getText().equals("")) {
							errorMessageMail.setText(errorMessageMail.getText()
									+ "Email must be not left blank.");
						} else {
							email = newEmail;
							checkEmail = true;
						}

					}
					int option = 0;
					if (changeUsername == true || changePassword == true
							|| changeCreditCard == true || changeMobile == true
							|| changeEmail == true) {
						/*
						 * if (changeUsername == true || changeEmail == true){
						 * if (checkUsername1 == false || checkUsername2 ==
						 * false || changeEmail == false) { option =
						 * JOptionPane.showConfirmDialog(myFrame,
						 * errorMessageUsername.getText() +
						 * errorMessageMail.getText(), "Confirmation",
						 * JOptionPane.PLAIN_MESSAGE); } } else {
						 */
						if (changeUsername == true
								&& checkUsernameFinal == false
								&& changeEmail == true && checkEmail == false) {
							option = JOptionPane
									.showConfirmDialog(
											myFrame,
											"Your password and email did not meet the requirement.",
											"Confirmation",
											JOptionPane.PLAIN_MESSAGE);
						} else if (changeUsername == true
								&& checkUsername1 == false) {
							option = JOptionPane.showConfirmDialog(myFrame,
									"Your username must not be left empty.",
									"Confirmation", JOptionPane.PLAIN_MESSAGE);
						} else if (changeUsername == true
								&& checkUsername2 == false) {
							option = JOptionPane.showConfirmDialog(myFrame,
									"Username is in use.", "Confirmation",
									JOptionPane.PLAIN_MESSAGE);
						} else if (changeEmail == true && checkEmail == false) {
							option = JOptionPane.showConfirmDialog(myFrame,
									"Your email must not be left empty.",
									"Confirmation", JOptionPane.PLAIN_MESSAGE);
						} else {
							option = JOptionPane
									.showConfirmDialog(
											myFrame,
											"Your account have been successfully updated!",
											"Confirmation",
											JOptionPane.PLAIN_MESSAGE);
							Customer newCustomer = new Customer(id, name,
									gender, NRIC, username, password, mobile,
									email, address, userType, extraCharges,
									stay, membership, checkOut, points,
									doNotDisturb, alarm, roomNumber);
							CustomerDAO.updateCustomer(newCustomer);
							MainFrame.setPersonWhoLogin(newCustomer);

						}
					} else {
						option = JOptionPane.showConfirmDialog(myFrame,
								"No changes were made.", "Confirmation",
								JOptionPane.PLAIN_MESSAGE);
					}

					if (option == JOptionPane.OK_OPTION) {
						JPanel panel = new MyAccountsPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
				}
			});
			jButtonDone.setBounds(new Rectangle(139, 488, 118, 50));
			jButtonDone.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonDone.setForeground(Color.white);
			jButtonDone.setText("Done");
			jButtonDone.setBackground(new Color(91, 155, 213));
		}
		return jButtonDone;
	}

	/**
	 * This method initializes jButtonAccountSummary
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAccountSummary() {
		if (jButtonAccountSummary == null) {
			jButtonAccountSummary = new JButton();
			jButtonAccountSummary.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JPanel panel = new Summary(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonAccountSummary.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonAccountSummary.setForeground(Color.white);
			jButtonAccountSummary.setText("Summary");
			jButtonAccountSummary.setSize(new Dimension(121, 60));
			jButtonAccountSummary.setLocation(new Point(678, 420));
			jButtonAccountSummary.setBackground(new Color(91, 155, 213));
		}
		return jButtonAccountSummary;
	}

	/**
	 * This method initializes jButtonMyVouchers
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMyVouchers() {
		if (jButtonMyVouchers == null) {
			jButtonMyVouchers = new JButton();
			jButtonMyVouchers.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonMyVouchers.setForeground(Color.white);
			jButtonMyVouchers.setText("Vouchers");
			jButtonMyVouchers.setLocation(new Point(828, 420));
			jButtonMyVouchers.setSize(new Dimension(121, 60));
			jButtonMyVouchers.setBackground(new Color(91, 155, 213));
			jButtonMyVouchers
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JPanel panel = new MyVouchersPanel2(myFrame,
									"MyAccountsPanel", "");
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonMyVouchers;
	}

	/**
	 * This method initializes jTextPaneUsername
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneUsername() {
		if (jTextPaneUsername == null) {
			jTextPaneUsername = new JTextPane();
			jTextPaneUsername.setBounds(new Rectangle(210, 212, 137, 31));
			jTextPaneUsername.setText(username);
			jTextPaneUsername.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneUsername.setForeground(new Color(120, 120, 120));
			jTextPaneUsername.setEditable(false);
			jTextPaneUsername.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneUsername;
	}

	/**
	 * This method initializes jTextPanePassword
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPanePassword() {
		if (jTextPanePassword == null) {
			jTextPanePassword = new JTextPane();
			jTextPanePassword.setBounds(new Rectangle(210, 265, 86, 29));
			jTextPanePassword.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPanePassword.setForeground(new Color(120, 120, 120));
			jTextPanePassword.setText("********");
			jTextPanePassword.setEditable(false);
			jTextPanePassword.setBackground(new Color(227, 228, 250));
		}
		return jTextPanePassword;
	}

	/**
	 * This method initializes jTextPaneMobile
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneMobile() {
		if (jTextPaneMobile == null) {
			jTextPaneMobile = new JTextPane();
			jTextPaneMobile.setBounds(new Rectangle(210, 359, 86, 30));
			jTextPaneMobile.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneMobile.setForeground(new Color(120, 120, 120));
			jTextPaneMobile.setText(mobileString);
			jTextPaneMobile.setEditable(false);
			jTextPaneMobile.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneMobile;
	}

	private JTextPane getTextPane_1() {
		if (errorMessageUsername == null) {
			errorMessageUsername = new JTextPane();
			errorMessageUsername.setForeground(Color.RED);
			errorMessageUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
			errorMessageUsername.setBackground(new Color(227, 228, 250));
			errorMessageUsername.setBounds(401, 223, 118, 41);
		}
		return errorMessageUsername;
	}

	private JTextPane getErrorMessaegMobile() {
		if (errorMessaegMobile == null) {
			errorMessaegMobile = new JTextPane();
			errorMessaegMobile.setFont(new Font("Calibri", Font.PLAIN, 16));
			errorMessaegMobile.setForeground(Color.RED);
			errorMessaegMobile.setBackground(new Color(227, 228, 250));
			errorMessaegMobile.setBounds(412, 365, 168, 19);
		}
		return errorMessaegMobile;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel();
			lblAddress.setText("Email:");
			lblAddress.setSize(new Dimension(210, 24));
			lblAddress.setPreferredSize(new Dimension(55, 24));
			lblAddress.setLocation(new Point(-27, 365));
			lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAddress.setFont(new Font("Calibri", Font.BOLD, 20));
			lblAddress.setBounds(60, 419, 123, 24);
		}
		return lblAddress;
	}

	private JTextPane getTextPaneEmail() {
		if (textPaneEmail == null) {
			textPaneEmail = new JTextPane();
			textPaneEmail.setText(email);
			textPaneEmail.setForeground(new Color(120, 120, 120));
			textPaneEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
			textPaneEmail.setEditable(false);
			textPaneEmail.setBounds(new Rectangle(210, 359, 86, 30));
			textPaneEmail.setBackground(new Color(227, 228, 250));
			textPaneEmail.setBounds(210, 413, 180, 30);
		}
		return textPaneEmail;
	}

	private JFormattedTextField getFormattedTextFieldEmail() {
		if (formattedTextFieldEmail == null) {
			formattedTextFieldEmail = new JFormattedTextField();
			formattedTextFieldEmail
					.setFont(new Font("Calibri", Font.PLAIN, 18));
			formattedTextFieldEmail.setBounds(210, 420, 161, 22);
			formattedTextFieldEmail.setVisible(false);
		}
		return formattedTextFieldEmail;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel();
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changeEmail = true;
					formattedTextFieldEmail.setVisible(true);
					textPaneEmail.setVisible(false);
				}
			});
			label.setText("edit");
			label.setForeground(new Color(58, 115, 255));
			label.setFont(new Font("Calibri", Font.BOLD, 12));
			label.setBounds(new Rectangle(361, 371, 41, 16));
			label.setBounds(416, 425, 41, 16);
		}
		return label;
	}

	private JTextPane getTextPane_1_1() {
		if (errorMessageMail == null) {
			errorMessageMail = new JTextPane();
			errorMessageMail.setForeground(Color.RED);
			errorMessageMail.setFont(new Font("Calibri", Font.PLAIN, 16));
			errorMessageMail.setBackground(new Color(227, 228, 250));
			errorMessageMail.setBounds(440, 420, 228, 24);
		}
		return errorMessageMail;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("New label");
			label_1.setBounds(484, 425, 46, 14);
		}
		return label_1;
	}

	private JLabel getLblNextPage() {
		if (lblNextPage == null) {
			lblNextPage = new JLabel("Next Page >");
			lblNextPage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel panel = new MyAccountsPanel2(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			lblNextPage.setFont(new Font("Calibri", Font.BOLD, 13));
			lblNextPage.setBounds(401, 454, 76, 26);
		}
		return lblNextPage;
	}
}
