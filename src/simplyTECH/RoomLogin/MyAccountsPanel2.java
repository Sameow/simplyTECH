package simplyTECH.RoomLogin;

//import LobbyLoginPanel;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import simplyTECH.Components.MACAddress;
import simplyTECH.dao.CheckLoginDAO;
import simplyTECH.dao.CreditCardDAO;
import simplyTECH.dao.PersonDAO;
import simplyTECH.entity.*;
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
import javax.swing.JTextArea;

public class MyAccountsPanel2 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
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
	private JLabel jLabelBtnChangePassword = null;
	private JLabel jLabelBtnCard = null;
	private JLabel jLabelBtnMobile = null;
	private JLabel jLabelBtnUsername = null;
	private JLabel jLabelBack = null;
	private JPasswordField passwordFieldOldPassword;
	private JPasswordField passwordFieldNewPassword;
	private JPasswordField passwordFieldRetypeNewPassword;
	private JPasswordField passwordFieldPassword;
	private JPasswordField passwordFieldRetypePassword;
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
	/**
	 * This is the default constructor
	 */
	public MyAccountsPanel2() {
		super();
		initialize();
	}

	public MyAccountsPanel2(JFrame f){
		this();
		myFrame = f;
//		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private Person person = new Person();
	private CreditCard CC = new CreditCard();
	private CustomerDetails CD = new CustomerDetails();
	private CheckLogin CL = new CheckLogin();
	private String name;
	private String cardType;
	private int loginID;
	private String loginIDString;
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
	private boolean checkMobile = false;
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
	private int newExpiryYear;
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
	//String newCardType;
	private MaskFormatter formatter;
	private MaskFormatter formatter1;
	private boolean checkNewMonth = false;
	private boolean checkNewYear = false;
	private boolean checkCardNumber = false;
	private boolean checkExpiryMonth = false;
	private boolean checkExpiryYear = false;
	private boolean checkCardholderName = false;
	private boolean checkCountry = false;
	private boolean checkCVC = false;
	private boolean changeEmail = false;
	private String newEmail;
	private JTextPane errorMessageMail;
	private JLabel label_1;
	private JLabel lblNextPage;
	private JTextPane textPaneAddress;
	private JTextPane errorMessageAddress;
	private JLabel lblNewLabel;
	private JTextArea textAreaAddress;
	private boolean changeAddress = false;
	private String address;
	private String newAddress;
	
	private void initialize() {
		String macAddress = null;
		MACAddress mac = new MACAddress();
		try {
			macAddress = mac.getMAC();
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("MacAddress: "+macAddress);
		CheckLogin CL = CheckLoginDAO.searchByIdTi(macAddress);
		loginID = CL.getId();
		loginIDString = loginID + "";
		person = PersonDAO.searchById(loginID);
		username = person.getUsername();
		mobile = person.getMobile();
		name = person.getName();
		email = person.getEmail();
		address = person.getAddress();
		mobileString = mobile + "";
		CreditCard CC = CreditCardDAO.searchById(loginID);
		cardType = CC.getCardType();
		cardNumber = CC.getCardNumber();
		
		jLabelBack = new JLabel();
		jLabelBack.setBounds(new Rectangle(-13, -3, 130, 82));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.setText("");
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new RoomHomePagePanel(myFrame);
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
		jLabel2.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Background.png")));
		jLabel2.setText("");
		jLabel1 = new JLabel();
		jLabel1.setPreferredSize(new Dimension(55, 24));
		jLabel1.setText("Address:");
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
		this.add(getJButtonDone(), null);
		this.add(getJButtonAccountSummary(), null);
		this.add(getJButtonMyVouchers(), null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(jLabel4, null);
		this.add(jLabelBack, null);
		//add(getPasswordFieldPassword());
		//add(getPasswordFieldRetypePassword());
	
			add(getTextPane_1_1());
			add(getLabel_1());
			add(getLblNextPage());
			add(getTextPane_2());
			add(getTextPane_3());
			
			textAreaAddress = new JTextArea();
			textAreaAddress.setBounds(210, 120, 192, 78);
			add(textAreaAddress);
			add(getLblNewLabel());
			
			
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
					
					if (changeAddress == true){
						newAddress = textAreaAddress.getText();
						if (textPaneAddress.getText().equals("")){
							errorMessageAddress.setText("Address should not be left empty.");
						}
						else {
							try {
								PersonDAO.updateAddress(newAddress, loginIDString);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					int option = JOptionPane.showConfirmDialog(myFrame,
							"Your account have been successfully updated!",
							"Confirmation", JOptionPane.PLAIN_MESSAGE);
					
					if (option == JOptionPane.OK_OPTION){
						JPanel panel = new MyAccountsPanel2(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}	
			}
					
					
				}
			);
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
			jButtonAccountSummary.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonAccountSummary.setForeground(Color.white);
			jButtonAccountSummary.setText("Account Summary");
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
			jButtonMyVouchers.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					JPanel panel = new MyVouchersPanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonMyVouchers;
	}
	private JTextPane getTextPane_1_1() {
		if (errorMessageMail == null) {
			errorMessageMail = new JTextPane();
			errorMessageMail.setForeground(Color.RED);
			errorMessageMail.setFont(new Font("Calibri", Font.PLAIN, 16));
			errorMessageMail.setBackground(new Color(227, 228, 250));
			errorMessageMail.setBounds(440, 424, 168, 19);
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
			lblNextPage = new JLabel("< Previous Page");
			lblNextPage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel panel = new MyAccountsPanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			lblNextPage.setFont(new Font("Calibri", Font.BOLD, 13));
			lblNextPage.setBounds(391, 454, 86, 26);
		}
		return lblNextPage;
	}
	private JTextPane getTextPane_2() {
		if (textPaneAddress == null) {
			textPaneAddress = new JTextPane();
			textPaneAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
			textPaneAddress.setBackground(new Color(227,228,250));
			textPaneAddress.setBounds(210, 116, 192, 82);
			textPaneAddress.setText(address);
		}
		return textPaneAddress;
	}
	private JTextPane getTextPane_3() {
		if (errorMessageAddress == null) {
			errorMessageAddress = new JTextPane();
			errorMessageAddress.setBackground(new Color(227,228,250));
			errorMessageAddress.setFont(new Font("Calibri", Font.PLAIN, 13));
			errorMessageAddress.setBounds(210, 209, 130, 82);
		}
		return errorMessageAddress;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("edit");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textPaneAddress.setVisible(false);
					textAreaAddress.setVisible(true);
					changeAddress = true;
				}
			});
			lblNewLabel.setForeground(new Color(58,115,255));
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 12));
			lblNewLabel.setBounds(445, 187, 46, 14);
		}
		return lblNewLabel;
	}
}
