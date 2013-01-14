package simplyTECH.KzAndNigel;
import java.awt.GridBagLayout;

import simplyTECH.Components.DesEncryption;
import simplyTECH.dao.CustomerDetailsDAO;
import simplyTECH.dao.PersonDAO;
import simplyTECH.entity.CustomerDetails;
import simplyTECH.entity.Person;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.sql.SQLException;
import java.text.ParseException;


import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;


public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JEditorPane jEditorPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JLabel jLabel112 = null;
	private JLabel jLabel113 = null;
	private JTextField jTextFieldFullName = null;
	private JTextField jTextFieldID = null;
	private JPasswordField jPasswordFieldPassword = null;
	private JTextField jTextFieldUsername = null;
	private JPasswordField jPasswordFieldRetypePassword = null;
	private JLabel jLabel114 = null;
	private JLabel jLabel1141 = null;
	private JLabel jLabel11411 = null;
	private JTextField jTextFieldAddress1 = null;
	private JTextField jTextFieldAddress2 = null;
	private JTextField jTextFieldEmail = null;
	private JTextPane jTextPane = null;
	private JButton jButtonNext = null;
	private JLabel jLabelBack = null;
	private JRadioButton jRadioButtonMr = null;
	private JRadioButton jRadioButtonMs = null;
	private JRadioButton jRadioButtonMrs = null;
	private JRadioButton jRadioButtonMdm = null;
	private JRadioButton jRadioButtonYes = null;
	private JRadioButton jRadioButtonNo = null;
	private ButtonGroup group2 = null;
	private ButtonGroup group1 = null;
	private JTextPane errorMessage;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextFieldMobilePhone;
	private int count = 0;
	//private CustomerDetailsDAO cdDAO = null;
	
	/**
	 * This is the default constructor
	 * @param myFrame 
	 */
	public RegisterPanel() {
		super();
		initialize();
	}

	public RegisterPanel(JFrame f){
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
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new LobbyLoginPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel11411 = new JLabel();
		jLabel11411.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel11411.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel11411.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11411.setText("Email:");
		jLabel11411.setLocation(new Point(406, 381));
		jLabel11411.setSize(new Dimension(127, 18));
		jLabel11411.setEnabled(true);
		jLabel1141 = new JLabel();
		jLabel1141.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel1141.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel1141.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1141.setText("Address:");
		jLabel1141.setLocation(new Point(430, 263));
		jLabel1141.setSize(new Dimension(127, 18));
		jLabel1141.setEnabled(true);
		jLabel114 = new JLabel();
		jLabel114.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel114.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel114.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel114.setText("Mobile Phone:");
		jLabel114.setLocation(new Point(436, 213));
		jLabel114.setSize(new Dimension(177, 18));
		jLabel114.setEnabled(true);
		jLabel113 = new JLabel();
		jLabel113.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel113.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel113.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel113.setText("Password:");
		jLabel113.setLocation(new Point(114, 398));
		jLabel113.setSize(new Dimension(177, 18));
		jLabel113.setEnabled(true);
		jLabel112 = new JLabel();
		jLabel112.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel112.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel112.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel112.setText("Retype Password:");
		jLabel112.setLocation(new Point(114, 448));
		jLabel112.setSize(new Dimension(177, 18));
		jLabel112.setEnabled(true);
		jLabel111 = new JLabel();
		jLabel111.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel111.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel111.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel111.setText("Username:");
		jLabel111.setLocation(new Point(114, 348));
		jLabel111.setSize(new Dimension(177, 18));
		jLabel111.setEnabled(true);
		jLabel11 = new JLabel();
		jLabel11.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel11.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setText("ID:");
		jLabel11.setLocation(new Point(114, 298));
		jLabel11.setSize(new Dimension(177, 18));
		jLabel11.setEnabled(true);
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(222, 126, 183, 67));
		jLabel2.setFont(new Font("Calibri Light", Font.PLAIN, 34));
		jLabel2.setText("registration");
		jLabel1 = new JLabel();
		jLabel1.setEnabled(true);
		jLabel1.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setFont(new Font("Calibri", Font.PLAIN, 22));
		jLabel1.setSize(new Dimension(177, 18));
		jLabel1.setLocation(new Point(114, 213));
		jLabel1.setText("Full Name:");
		jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/CheckmateBySimplyTECH.png")));
		jLabel.setSize(new Dimension(384, 135));
		jLabel.setLocation(new Point(508, 26));
		jLabel.setText("");
		this.setSize(1024, 600);

		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJEditorPane(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel11, null);
		this.add(jLabel111, null);
		this.add(jLabel112, null);
		this.add(jLabel113, null);
		this.add(getJTextFieldFullName(), null);
		this.add(getJTextFieldID(), null);
		this.add(getJPasswordFieldPassword(), null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJPasswordFieldRetypePassword(), null);
		this.add(jLabel114, null);
		this.add(jLabel1141, null);
		this.add(jLabel11411, null);
		this.add(getJTextFieldAddress1(), null);
		this.add(getJTextFieldAddress2(), null);
		this.add(getJTextFieldEmail(), null);
		this.add(getJTextPane(), null);
		this.add(getJButtonNext(), null);
		this.add(jLabelBack, null);
		this.add(getJRadioButtonMr(), null);
		this.add(getJRadioButtonMs(), null);
		this.add(getJRadioButtonMrs(), null);
		this.add(getJRadioButtonMdm(), null);
		this.add(getJRadioButtonYes(), null);
		this.add(getJRadioButtonNo(), null);
		group2 = new ButtonGroup();
        group2.add(jRadioButtonMr);
        group2.add(jRadioButtonMs);
        group2.add(jRadioButtonMrs);
        group2.add(jRadioButtonMdm);
		group1 = new ButtonGroup();
        group1.add(jRadioButtonYes);
        group1.add(jRadioButtonNo);
        add(getErrorMessage());
        add(getFormattedTextField());
        try {
			add(getFormattedTextFieldMobilePhone());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setBounds(new Rectangle(197, 155, 21, 8));
			jEditorPane.setEditable(false);
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
			jTextFieldFullName.setSize(new Dimension(117, 22));
			jTextFieldFullName.setLocation(new Point(321, 213));
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
			jTextFieldID.setLocation(new Point(321, 298));
			jTextFieldID.setSize(new Dimension(117, 22));
		}
		return jTextFieldID;
	}

	/**
	 * This method initializes jPasswordFieldPassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPassword() {
		if (jPasswordFieldPassword == null) {
			jPasswordFieldPassword = new JPasswordField();
			jPasswordFieldPassword.setLocation(new Point(321, 398));
			jPasswordFieldPassword.setSize(new Dimension(117, 22));
		}
		return jPasswordFieldPassword;
	}

	/**
	 * This method initializes jTextFieldUsername	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setLocation(new Point(321, 348));
			jTextFieldUsername.setSize(new Dimension(117, 22));
		}
		return jTextFieldUsername;
	}

	/**
	 * This method initializes jPasswordFieldRetypePassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldRetypePassword() {
		if (jPasswordFieldRetypePassword == null) {
			jPasswordFieldRetypePassword = new JPasswordField();
			jPasswordFieldRetypePassword.setLocation(new Point(321, 448));
			jPasswordFieldRetypePassword.setSize(new Dimension(117, 22));
		}
		return jPasswordFieldRetypePassword;
	}

	/**
	 * This method initializes jTextFieldAddress1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAddress1() {
		if (jTextFieldAddress1 == null) {
			jTextFieldAddress1 = new JTextField();
			jTextFieldAddress1.setBounds(new Rectangle(478, 295, 282, 22));
		}
		return jTextFieldAddress1;
	}

	/**
	 * This method initializes jTextFieldAddress2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAddress2() {
		if (jTextFieldAddress2 == null) {
			jTextFieldAddress2 = new JTextField();
			jTextFieldAddress2.setLocation(new Point(478, 332));
			jTextFieldAddress2.setSize(new Dimension(282, 22));
		}
		return jTextFieldAddress2;
	}

	/**
	 * This method initializes jTextFieldEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setLocation(new Point(478, 414));
			jTextFieldEmail.setSize(new Dimension(282, 22));
		}
		return jTextFieldEmail;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(new Rectangle(476, 447, 169, 49));
			jTextPane.setBackground(new Color(227, 228, 250));
			jTextPane.setText("Update me about the latest news and promotions.");
		}
		return jTextPane;
	}

	/**
	 * This method initializes jButtonNext	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNext() {
		if (jButtonNext == null) {
			jButtonNext = new JButton();
			jButtonNext.setBounds(new Rectangle(784, 480, 127, 43));
			jButtonNext.setFont(new Font("Calibri", Font.BOLD, 36));
			jButtonNext.setBackground(new Color(91, 155, 213));
			jButtonNext.setForeground(Color.white);
			jButtonNext.setToolTipText("");
			jButtonNext.setText("Next");
			jButtonNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					errorMessage.setText("");
					String name = jTextFieldFullName.getText();
					boolean checkName = false;
					if (jTextFieldFullName.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Name must not be left blank. \n");
						checkName = false;
					}
					else{
						checkName = true;
					}
					
					String NRIC = jTextFieldID.getText();
					boolean checkNRIC = false;
					if (jTextFieldID.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*NRIC must not be left blank. \n");
						checkNRIC = false;
					}
					else{
						checkNRIC = true;
					}
					String username = jTextFieldUsername.getText();
					boolean checkUsername1 = false;
					boolean checkUsername2 = true;
					boolean checkUsername = false;
					if (jTextFieldUsername.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Username must not be left blank. \n");
						checkUsername1 = false;
					}
					else{
						checkUsername1 = true;
					}
					Person person = PersonDAO.searchByUsername(username);
						
					if (person != null){
						checkUsername2 = false;
						errorMessage.setText(errorMessage.getText() + "*Username is in use. \n");
					}
					else {
						System.out.print("failed");
						checkUsername2 = true;
					}
					if (checkUsername1 == true && checkUsername2 == true){
						checkUsername = true;
					}
					else {
						System.out.print("failed2");
						checkUsername = false;
					}
					
					String pass1 = new String(jPasswordFieldPassword.getPassword());
					String pass2 = new String(jPasswordFieldRetypePassword.getPassword());
					String password = null;
					boolean checkPass1 = false;
					boolean checkPass2 = false;
					boolean checkPassword = false;
					boolean checkPasswordLength = false;
					boolean passMatch = false;
					if (jPasswordFieldPassword.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Password must not be left blank. \n");
						System.out.print("failed3");
						checkPass1 = false;
					}
					else{
						checkPass1 = true;
					}
					if (jPasswordFieldRetypePassword.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Retype password must not be left blank.\n ");
						System.out.print("failed4");	
						checkPass2= false;
					}
					else{
						checkPass2 = true;
					}
					
					if (pass1.equals(pass2)){
						passMatch = true;	
					}
					else {
						errorMessage.setText(errorMessage.getText() + "*First and second password do not match.\n");
						System.out.print("failed5");
						passMatch = false;
					}
					if (pass1.length() < 8){
						errorMessage.setText(errorMessage.getText() + "*Password should be at least 8 characters long.\n");
						checkPasswordLength = false;
					}
					else {
						checkPasswordLength = true;
					}
					
					if (checkPass1 == true && checkPass2 == true && passMatch == true && checkPasswordLength == true){
						checkPassword = true;
						DesEncryption encryption = new DesEncryption("Password");
						password = encryption.encrypt(pass1);
					}
					
					String address = jTextFieldAddress1.getText() + " " + jTextFieldAddress2.getText();
					boolean checkAddress = false;
					if (jTextFieldAddress1.getText().equals("") && jTextFieldAddress2.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Address must not be left blank.\n");
						checkAddress = false;
					}
					else{
						checkAddress = true;
					}
					String email = jTextFieldEmail.getText();
					boolean checkEmail = false;
					if (jTextFieldEmail.getText().equals("")){
						errorMessage.setText(errorMessage.getText() + "*Email must not be left blank.\n");
						checkEmail = false;
					}
					else{
						checkEmail = true;
					}
				
					String mobile = formattedTextFieldMobilePhone.getText();
					boolean checkMobile = false;
					
					String gender = null;
					if (jRadioButtonMr.isSelected() == true){
						gender = "Mr";
					}
					else if(jRadioButtonMs.isSelected() == true){
						gender = "Ms";
					}
					else if(jRadioButtonMrs.isSelected() == true){
						gender = "Mrs";
					}
					else if(jRadioButtonMdm.isSelected() == true){
						gender = "Mdm";
					}	
					
					Person p1 = null;
					CustomerDetails cd = null;
					String membership = "Guest";
					double extraCharges = 0;
					int stay = 0;
					String checkout = "";
					int points = 0;
					int doNotDisturb = 0;
					String alarm = "";
					
					if (checkPassword == true && checkName == true && checkNRIC == true && checkUsername == true
							&& checkAddress == true  && checkEmail == true){
						CreditCardPanel ccp = new CreditCardPanel();
						ccp.setInformation(name,password,mobile);
						JPanel panel = new CreditCardPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
						System.out.println("Entered");
						
						p1 = new Person(name,gender,NRIC,username,password,mobile,address,email,"Customer");
						cd = new CustomerDetails(extraCharges,stay,membership,checkout,points,doNotDisturb,alarm);
												
						try {
							PersonDAO.createPerson(p1);
							CustomerDetailsDAO.createCustomer(cd);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {
						jPasswordFieldRetypePassword.requestFocus();
					System.out.println("Invalid Password~~~");
					}
				}
			});
		}
		return jButtonNext;
	}

	
	
	
	/**
	 * This method initializes jRadioButtonMr	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMr() {
		if (jRadioButtonMr == null) {
			jRadioButtonMr = new JRadioButton();
			jRadioButtonMr.setBounds(new Rectangle(230, 251, 47, 21));
			jRadioButtonMr.setBackground(new Color(227, 228, 250));
			jRadioButtonMr.setFont(new Font("Calibri", Font.BOLD, 14));
			jRadioButtonMr.setText("Mr.");
		}
		return jRadioButtonMr;
	}

	/**
	 * This method initializes jRadioButtonMs	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMs() {
		if (jRadioButtonMs == null) {
			jRadioButtonMs = new JRadioButton();
			jRadioButtonMs.setBounds(new Rectangle(276, 252, 49, 21));
			jRadioButtonMs.setBackground(new Color(227, 228, 250));
			jRadioButtonMs.setFont(new Font("Calibri", Font.BOLD, 14));
			jRadioButtonMs.setText("Ms.");
		}
		return jRadioButtonMs;
	}

	/**
	 * This method initializes jRadioButtonMrs	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMrs() {
		if (jRadioButtonMrs == null) {
			jRadioButtonMrs = new JRadioButton();
			jRadioButtonMrs.setBounds(new Rectangle(323, 253, 58, 21));
			jRadioButtonMrs.setBackground(new Color(227, 228, 250));
			jRadioButtonMrs.setText("Mrs.");
			jRadioButtonMrs.setFont(new Font("Calibri", Font.BOLD, 14));
		}
		return jRadioButtonMrs;
	}

	/**
	 * This method initializes jRadioButtonMdm	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMdm() {
		if (jRadioButtonMdm == null) {
			jRadioButtonMdm = new JRadioButton();
			jRadioButtonMdm.setBounds(new Rectangle(377, 253, 94, 21));
			jRadioButtonMdm.setBackground(new Color(227, 228, 250));
			jRadioButtonMdm.setText("Mdm.");
			jRadioButtonMdm.setFont(new Font("Calibri", Font.BOLD, 14));
		}
		return jRadioButtonMdm;
	}

	/**
	 * This method initializes jRadioButtonYes	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonYes() {
		if (jRadioButtonYes == null) {
			jRadioButtonYes = new JRadioButton();
			jRadioButtonYes.setBounds(new Rectangle(641, 457, 53, 21));
			jRadioButtonYes.setText("Yes");
			jRadioButtonYes.setBackground(new Color(227, 228, 250));
			jRadioButtonYes.setFont(new Font("Calibri", Font.BOLD, 14));
			
		}
		return jRadioButtonYes;
	}

	/**
	 * This method initializes jRadioButtonNo	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonNo() {
		if (jRadioButtonNo == null) {
			jRadioButtonNo = new JRadioButton();
			jRadioButtonNo.setBounds(new Rectangle(691, 457, 58, 21));
			jRadioButtonNo.setText("No");
			jRadioButtonNo.setBackground(new Color(227, 228, 250));
			jRadioButtonNo.setFont(new Font("Calibri", Font.BOLD, 14));
			
		}
		return jRadioButtonNo;
	}

	private JTextPane getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JTextPane();
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setForeground(Color.RED);
			errorMessage.setEditable(false);
			errorMessage.setBackground(new Color(227, 228, 250));
			errorMessage.setBounds(787, 172, 154, 289);
		}
		return errorMessage;
	}
	private JFormattedTextField getFormattedTextField() {
		if (formattedTextField == null) {
			formattedTextField = new JFormattedTextField();
		}
		return formattedTextField;
	}
	private JFormattedTextField getFormattedTextFieldMobilePhone() throws ParseException {
		if (formattedTextFieldMobilePhone == null) {
			MaskFormatter formatter = new MaskFormatter("##########");
		//	formattedTextFieldMobilePhone = new JFormattedTextField(formatter);
			formattedTextFieldMobilePhone = new JFormattedTextField();
			formattedTextFieldMobilePhone.setBounds(653, 246, 127, 20);
			formattedTextFieldMobilePhone.setLocation(new Point(643, 213));
			formattedTextFieldMobilePhone.setSize(new Dimension(117, 22));
		}
		return formattedTextFieldMobilePhone;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
