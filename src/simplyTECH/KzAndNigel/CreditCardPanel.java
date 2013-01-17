package simplyTECH.KzAndNigel;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import simplyTECH.Components.DocumentSizeFilter;
import simplyTECH.DatabaseStatements.DBController;
import simplyTECH.RoomLogin.MyAccountsPanel;
import simplyTECH.dao.CreditCardDAO;
import simplyTECH.dao.CustomerDetailsDAO;
import simplyTECH.dao.PersonDAO;
import simplyTECH.entity.CreditCard;
import simplyTECH.entity.CustomerDetails;
import simplyTECH.entity.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;

import javax.swing.JFormattedTextField;

public class CreditCardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel = null;
	private JFrame myFrame = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabelCVC = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel121 = null;
	private JLabel jLabel1211 = null;
	private JButton jButtonDone = null;
	private JLabel jLabelBack = null;
	private JComboBox comboBoxYear;
	private JComboBox comboBoxMonth;
	private JTextField textFieldCardholderName;
	private JTextField textFieldCountry;
	private JTextField textFieldStreetAddress;
	private JFormattedTextField formattedCVC;
	private JFormattedTextField formattedCardNumber1;
	private JLabel label;
	private JFormattedTextField formattedCardNumber2;
	private JLabel label_1;
	private JFormattedTextField formattedCardNumber3;
	private JLabel label_5;
	private JFormattedTextField formattedCardNumber4;
	private JTextPane errorMessage;
	private String loginName;
	private String loginGender;
	private String loginNRIC;
	private String loginUsername;
	private String loginPassword;
	private String loginMobile;
	private String loginAddress;
	private String loginEmail;
	private Person p1 = null;
	private CustomerDetails cd = null;
	private String membership = "Guest";
	private double extraCharges = 0;
	private int stay = 0;
	private String checkout = "";
	private int points = 0;
	private int doNotDisturb = 0;
	private String alarm = "";
	
	/**
	 * This is the default constructor
	 */
	public CreditCardPanel() {
		super();
		//initialize();
	}

	public CreditCardPanel(JFrame f, String loginName, String loginGender, String loginNRIC, String loginUsername,
			String loginPassword, String loginMobile, String loginAddress, String loginEmail){
		this();
		this.loginName = loginName;
		this.loginGender = loginGender;
		this.loginNRIC = loginNRIC;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.loginMobile = loginMobile;
		this.loginAddress = loginAddress;
		this.loginEmail = loginEmail;
		System.out.println("This is printing from setInformation method!");
		System.out.println("Name is: " + name);
		myFrame = f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	int count;
	private String name;
	private String password;
	private String mobile;
	
	void setInformation(String name, String password, String mobile){
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		System.out.println("This is printing from setInformation method!");
		System.out.println("Name is: " + name);
	}
	
	private void initialize() {
		
		System.out.println("Name from registerPanel is: " + name);
		jLabelBack = new JLabel();
		jLabelBack.setBounds(-13, -25, 170, 128);
		jLabelBack.setText("");
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new RegisterPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				try {
					PersonDAO.deleteLatest();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		jLabel1211 = new JLabel();
		jLabel1211.setBounds(148, 438, 284, 23);
		jLabel1211.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1211.setText("Street Address:");
		jLabel1211.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel121 = new JLabel();
		jLabel121.setBounds(149, 393, 284, 23);
		jLabel121.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel121.setText("Country:");
		jLabel121.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel12 = new JLabel();
		jLabel12.setBounds(148, 347, 283, 23);
		jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel12.setText("Cardholder Name:");
		jLabel12.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel4 = new JLabel();
		jLabel4.setBounds(673, 262, 92, 50);
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/CVC.png")));
		jLabel4.setText("");
		jLabelCVC = new JLabel();
		jLabelCVC.setBounds(528, 278, 85, 23);
		jLabelCVC.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelCVC.setText("CVC:");
		jLabelCVC.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel3 = new JLabel();
		jLabel3.setBounds(436, 269, 13, 43);
		jLabel3.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabel3.setText("/");
		jLabel11 = new JLabel();
		jLabel11.setBounds(216, 280, 120, 23);
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setText("Expiry Date:");
		jLabel11.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel1 = new JLabel();
		jLabel1.setBounds(147, 226, 281, 18);
		jLabel1.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setText("Card Number:");
		jLabel = new JLabel();
		jLabel.setBounds(508, 26, 384, 135);
		jLabel.setText("");
		jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/CheckmateBySimplyTECH.png")));
		jLabel2 = new JLabel();
		jLabel2.setBounds(225, 131, 183, 67);
		jLabel2.setText("registration");
		jLabel2.setFont(new Font("Calibri Light", Font.PLAIN, 34));
		this.setSize(1024, 600);
		this.setBackground(new Color(227, 228, 250));
		setLayout(null);
		this.add(getJTextPane1());
		this.add(jLabel2);
		this.add(jLabel);
		this.add(jLabel1);
		this.add(jLabel11);
		this.add(jLabel3);
		this.add(jLabelCVC);
		this.add(jLabel4);
		this.add(jLabel12);
		this.add(jLabel121);
		this.add(jLabel1211);
		this.add(getJButtonDone());
		this.add(jLabelBack);
		
		add(getComboBoxMonth());
		add(getComboBoxYear());
		add(getTextFieldCardholderName());
		add(getTextFieldCountry());
		add(getTextFieldStreetAddress());
		try {
			add(getFormattedCVC());
			add(getFormattedTextField_1());
			add(getLabel());
			add(getFormattedTextField_2());
			add(getLabel_1());
			add(getFormattedTextField_1_1());
			add(getLabel_5());
			add(getFormattedTextField_2_1());
			add(getErrorMessage());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
			}
	

	/**
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setBounds(200, 160, 21, 8);
			jTextPane1.setPreferredSize(new Dimension(21, 24));
			jTextPane1.setBackground(new Color(237, 125, 49));
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
			jButtonDone.setBounds(428, 497, 100, 55);
			jButtonDone.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					errorMessage.setText("");
					String cardNumber = formattedCardNumber1.getText() + formattedCardNumber2.getText() + formattedCardNumber3.getText() + formattedCardNumber4.getText();
					String cardType = null;
					String verifyCard;
					String StringfirstInt;
					int firstInt;
					verifyCard = formattedCardNumber1.getText();
					StringfirstInt = verifyCard.charAt(0) + "";
					//System.out.println("AAAAA"+verifyCard+"AAAAA");
					//System.out.println("AAAAAA" + StringfirstInt + "AAAAA");
				
					boolean checkCardNumber = false;
					if (formattedCardNumber1.getText().equals("    ") || formattedCardNumber2.getText().equals("    ") ||
							formattedCardNumber3.getText().equals("    ") || formattedCardNumber4.getText().equals("    ")){
						checkCardNumber = false;
						errorMessage.setText(errorMessage.getText() + "*Card Number must not be left empty.\n");
					}
					else {
						checkCardNumber = true;
					}
					//	String expiryDate =jTextPaneMonth.getText() + "/" + jTextPaneYear.getText();
				
					int getMonth = comboBoxMonth.getSelectedIndex();
					int getYear = comboBoxYear.getSelectedIndex();
					int year;
					int month;
					boolean checkMonth = false;
					boolean checkYear = false;
					String expiryDate = null;
					
					switch(getMonth){
						case 1: month = 1;
							break;
						case 2: month = 2;
							break;
						case 3: month = 3;
							break;
						case 4: month = 4;
							break;
						case 5: month = 5;
							break;
						case 6: month = 6;
							break;
						case 7: month = 7;
							break;
						case 8: month = 8;
							break;
						case 9: month = 9;
							break;
						case 10: month = 10;
							break;
						case 11: month = 11;
							break;
						case 12: month = 12;
							break;
						default: month = 0;
					}
					switch(getYear){
						case 1: year = 12;
							break;
						case 2: year = 13;
							break;
						case 3: year = 14;
							break;
						case 4: year = 15;
							break;
						case 5: year = 16;
							break;
						case 6: year = 17;
							break;
						case 7: year = 18;
							break;
						case 8: year = 19;
							break;
						case 9: year = 20;
							break;
						case 10: year = 21;
							break;
						case 11: year = 22;
							break;
						case 12: year = 23;
							break;
						case 13: year = 24;
							break;
						case 14: year = 25;
							break;
						case 15: year = 26;
							break;
						case 16: year = 27;
							break;
						case 17: year = 28;
							break;
						case 18: year = 29;
							break;
						case 19: year = 30;
						break;
						default: year = 0;
					}
					if (month == 0){
						checkMonth = false;
						errorMessage.setText(errorMessage.getText() + " *Month must not be empty. \n ");
					}
					else {
						checkMonth = true;
					}
					if (year == 0){
						checkYear = false;
						errorMessage.setText(errorMessage.getText() + "*Year must not be empty.\n ");
					}
					else {
						checkYear = true;
					}
					expiryDate = month + " " + year;
					
					String getCVC = formattedCVC.getText();
					boolean checkCVC = false;
					if (getCVC.toString().equals("   ")){
						checkCVC = false;
						errorMessage.setText(errorMessage.getText() + "*CVC name must not be empty.\n ");
					}
					else {
						checkCVC = true;
					}
					
					String cardHolderName = textFieldCardholderName.getText();
					boolean checkCardHolderName = false;
					if (textFieldCardholderName.getText().equals("")){
						checkCardHolderName = false;
						errorMessage.setText(errorMessage.getText() + "*Cardholder name must not be empty.\n ");
					}
					else {
						checkCardHolderName = true;
					}
					String country = textFieldCountry.getText();
					boolean checkCountry = false;
					if (textFieldCountry.getText().equals("")){
						checkCountry = false;
						errorMessage.setText(errorMessage.getText() + "*Country name must not be empty.\n ");
					}
					else {
						checkCountry = true;
					}
					String streetAddress = textFieldStreetAddress.getText();
					boolean checkStreetAddress = false;
					if (textFieldStreetAddress.getText().equals("")){
						checkStreetAddress = false;
						errorMessage.setText(errorMessage.getText() + "*Street address name must not be empty.\n ");
					}
					else {
						checkStreetAddress = true;
					}

					int CVC = Integer.parseInt(getCVC);
					firstInt = Integer.parseInt(StringfirstInt);
					if (firstInt == 3){
						cardType = "AMEX";
					}
					else if (firstInt == 4){
						cardType = "VISA";
					}
					else if (firstInt == 5){
						cardType = "MASTERCARD";
					}
					else {
						cardType = "OTHERS";
					}
					
					CreditCard cc1 = null;
					if (checkCardNumber == true && checkMonth ==  true && checkYear == true && checkCardHolderName == true
							&& checkCountry == true && checkCVC == true && checkStreetAddress == true){
					try {
						cc1 = new CreditCard(cardNumber,month,year,expiryDate,cardHolderName,country,CVC,streetAddress, cardType);
						p1 = new Person(loginName,loginGender,loginNRIC,loginUsername,loginPassword,loginMobile,loginAddress,loginEmail,"Customer");
						cd = new CustomerDetails(extraCharges,stay,membership,checkout,points,doNotDisturb,alarm);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					try {
						PersonDAO.createPerson(p1);
						CreditCardDAO.createCreditCard(cc1);
						CustomerDetailsDAO.createCustomer(cd);
						int option = JOptionPane.showConfirmDialog(myFrame,
								"Your account have been successfully updated!",
								"Confirmation", JOptionPane.PLAIN_MESSAGE);
						
						if (option == JOptionPane.OK_OPTION){
							JPanel panel = new LobbyLoginPanel(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					else{
						System.out.print("FAILED!!!");
					}
					
				}
			});
			jButtonDone.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonDone.setForeground(Color.white);
			jButtonDone.setText("Done");
			jButtonDone.setBackground(new Color(91, 155, 213));
		}
		return jButtonDone;
	}
	private JComboBox getComboBoxYear() {
		if (comboBoxYear == null) {
			comboBoxYear = new JComboBox();
			comboBoxYear.setBounds(459, 280, 62, 20);
			comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2010", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		}
		return comboBoxYear;
	}
	
	private JComboBox getComboBoxMonth(){
		if (comboBoxMonth == null){
			comboBoxMonth = new JComboBox();
			comboBoxMonth.setBounds(346, 280, 77, 20);
			comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		}
		return comboBoxMonth;
	}
	private JTextField getTextFieldCardholderName() {
		if (textFieldCardholderName == null) {
			textFieldCardholderName = new JTextField();
			textFieldCardholderName.setBounds(444, 349, 183, 20);
			textFieldCardholderName.setColumns(10);
		}
		return textFieldCardholderName;
	}
	private JTextField getTextFieldCountry() {
		if (textFieldCountry == null) {
			textFieldCountry = new JTextField();
			textFieldCountry.setColumns(10);
			textFieldCountry.setBounds(444, 395, 183, 20);
		}
		return textFieldCountry;
	}
	private JTextField getTextFieldStreetAddress() {
		if (textFieldStreetAddress == null) {
			textFieldStreetAddress = new JTextField();
			textFieldStreetAddress.setColumns(10);
			textFieldStreetAddress.setBounds(444, 440, 183, 20);
		}
		return textFieldStreetAddress;
	}
	private JFormattedTextField getFormattedCVC() throws ParseException {
		if (formattedCVC == null) {
			MaskFormatter formatter = new MaskFormatter("###");	
			formattedCVC = new JFormattedTextField(formatter);
			formattedCVC.setBounds(633, 311, 21, 20);
			formattedCVC.setFont(new Font("Calibri", Font.PLAIN, 13));
			formattedCVC.setColumns(10);
			formattedCVC.setBounds(623, 280, 34, 20);
		/*	int maxChars = 3;
			AbstractDocument pDoc=(AbstractDocument)textFieldCVC.getDocument();
			pDoc.setDocumentFilter(new DocumentSizeFilter(maxChars));*/
		}
		return formattedCVC;
	}
	
	private JFormattedTextField getFormattedTextField_1() throws ParseException {
		if (formattedCardNumber1 == null) {
			MaskFormatter formatter = new MaskFormatter("####");	
			formattedCardNumber1 = new JFormattedTextField(formatter);
			formattedCardNumber1.setFont(new Font("Calibri", Font.PLAIN, 13));
			formattedCardNumber1.setColumns(10);
			formattedCardNumber1.setBounds(438, 224, 34, 20);
		}
		return formattedCardNumber1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("-");
			label.setBounds(477, 227, 13, 14);
		}
		return label;
	}
	private JFormattedTextField getFormattedTextField_2() throws ParseException {
		if (formattedCardNumber2 == null) {
			MaskFormatter formatter = new MaskFormatter("####");	
			formattedCardNumber2 = new JFormattedTextField(formatter);
			formattedCardNumber2.setFont(new Font("Calibri", Font.PLAIN, 13));
			formattedCardNumber2.setColumns(10);
			formattedCardNumber2.setBounds(489, 224, 34, 20);
		}
		return formattedCardNumber2;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("-");
			label_1.setBounds(528, 227, 13, 14);
		}
		return label_1;
	}
	private JFormattedTextField getFormattedTextField_1_1() throws ParseException {
		if (formattedCardNumber3 == null) {
			MaskFormatter formatter = new MaskFormatter("####");	
			formattedCardNumber3 = new JFormattedTextField(formatter);
			formattedCardNumber3.setFont(new Font("Calibri", Font.PLAIN, 13));
			formattedCardNumber3.setColumns(10);
			formattedCardNumber3.setBounds(542, 224, 34, 20);
		}
		return formattedCardNumber3;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("-");
			label_5.setBounds(581, 227, 13, 14);
		}
		return label_5;
	}
	private JFormattedTextField getFormattedTextField_2_1() throws ParseException {
		if (formattedCardNumber4 == null) {
			MaskFormatter formatter = new MaskFormatter("####");	
			formattedCardNumber4 = new JFormattedTextField(formatter);
			formattedCardNumber4.setFont(new Font("Calibri", Font.PLAIN, 13));
			formattedCardNumber4.setColumns(10);
			formattedCardNumber4.setBounds(593, 224, 34, 20);
		}
		return formattedCardNumber4;
	}
	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setEditable(false);
			errorMessage.setForeground(Color.RED);
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBounds(761, 244, 253, 217);
			errorMessage.setBackground(new Color(227,228,250));
		}
		return errorMessage;
	}
}  //  @jve:decl-index=0:visual-constraint="16,10"
