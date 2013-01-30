package simplytech.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class createNewStaff extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBarBelowBackButton = null;
	private JLabel jLabelCreatingStaffAccount = null;

	private JFrame myFrame=null;
	private JLabel jLabelAccountDetails = null;
	private JButton jButtonSave = null;
	private JLabel jLabelName = null;
	private JTextField jTextFieldName = null;
	private JLabel jLabelGender = null;
	private JLabel jLabelNRIC = null;
	private JTextField jTextFieldNRIC = null;
	private JTextField jTextFieldGender;
	private JTextField jTextFieldUsername;
	private JTextField jTextFieldWorkingSince;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldPosition;
	private JTextField jTextFieldEmail;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel jLabelBack = null;
	/**
	 * This is the default constructor
	 */
	public createNewStaff() {
		super();
		initialize();
	}

	public createNewStaff (JFrame f) {
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
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(16, 146, 140, 27));
		jLabelGender.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelGender.setText("Gender:");
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(16, 94, 140, 27));
		jLabelName.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelName.setText("Name:");
		jLabelCreatingStaffAccount = new JLabel();
		jLabelCreatingStaffAccount.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelCreatingStaffAccount.setLocation(new Point(91, 23));
		jLabelCreatingStaffAccount.setSize(new Dimension(317, 35));
		jLabelCreatingStaffAccount.setText("Creating Staff Account");
		jLabelBarBelowBackButton = new JLabel();
		jLabelBarBelowBackButton.setText("");
		jLabelBarBelowBackButton.setLocation(new Point(0, 78));
		jLabelBarBelowBackButton.setBackground(new Color(91, 155, 213));
		jLabelBarBelowBackButton.setSize(new Dimension(371, 4));
		jLabelBarBelowBackButton.setOpaque(true);
		
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelCreatingStaffAccount, null);
		this.add(jLabelBarBelowBackButton, null);
		this.add(getJButtonSave(), null);
		this.add(jLabelName, null);
		this.add(getJTextFieldName(), null);
		this.add(jLabelGender, null);
		this.add(getJLabelBack());
		
		jTextFieldGender = new JTextField();
		jTextFieldGender.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldGender.setBounds(166, 145, 219, 35);
		add(jTextFieldGender);
		
		jTextFieldUsername = new JTextField();
		jTextFieldUsername.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldUsername.setBounds(166, 191, 219, 35);
		add(jTextFieldUsername);
		
		JLabel jLabelUsername = new JLabel();
		jLabelUsername.setText("Username:");
		jLabelUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelUsername.setBounds(new Rectangle(24, 223, 81, 59));
		jLabelUsername.setBounds(16, 198, 140, 27);
		add(jLabelUsername);
		
		JLabel jLabelPassword = new JLabel();
		jLabelPassword.setText("Password:");
		jLabelPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPassword.setBounds(new Rectangle(24, 223, 140, 59));
		jLabelPassword.setBounds(16, 249, 140, 27);
		add(jLabelPassword);
		
		JLabel jLabelMobile = new JLabel();
		jLabelMobile.setText("Mobile:");
		jLabelMobile.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelMobile.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelMobile.setBounds(16, 341, 140, 27);
		add(jLabelMobile);
		
		JLabel jLabelEmail = new JLabel();
		jLabelEmail.setText("Email:");
		jLabelEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelEmail.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelEmail.setBounds(16, 438, 140, 27);
		add(jLabelEmail);
		
		JLabel jLabelWorkingsince = new JLabel();
		jLabelWorkingsince.setText("Working Since:");
		jLabelWorkingsince.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelWorkingsince.setBounds(new Rectangle(24, 223, 81, 59));
		jLabelWorkingsince.setBounds(16, 293, 140, 27);
		add(jLabelWorkingsince);
		
		JLabel jLabelPosition = new JLabel();
		jLabelPosition.setText("Position:");
		jLabelPosition.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPosition.setBounds(new Rectangle(24, 223, 140, 27));
		jLabelPosition.setBounds(16, 389, 140, 27);
		add(jLabelPosition);
		
		jTextFieldWorkingSince = new JTextField();
		jTextFieldWorkingSince.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldWorkingSince.setBounds(166, 291, 219, 35);
		add(jTextFieldWorkingSince);
		
		jTextFieldMobile = new JTextField();
		jTextFieldMobile.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldMobile.setBounds(166, 339, 219, 35);
		add(jTextFieldMobile);
		
		jTextFieldPosition = new JTextField();
		jTextFieldPosition.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldPosition.setBounds(166, 387, 219, 35);
		add(jTextFieldPosition);
		
		jTextFieldEmail = new JTextField();
		jTextFieldEmail.setBounds(new Rectangle(108, 167, 433, 35));
		jTextFieldEmail.setBounds(166, 436, 219, 35);
		add(jTextFieldEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 237, 219, 35);
		add(passwordField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(395, 94, 219, 35);
		add(lblNewLabel);
		
		label = new JLabel("");
		label.setBounds(395, 146, 219, 35);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(395, 191, 219, 35);
		add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(395, 293, 219, 35);
		add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(395, 339, 219, 35);
		add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(395, 389, 219, 35);
		add(label_4);
		
		label_5 = new JLabel("");
		label_5.setBounds(395, 438, 219, 35);
		add(label_5);
	}

	/**
	 * This method initializes jButtonSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.setBounds(new Rectangle(780, 526, 151, 27));
			jButtonSave.setFont(new Font("Dialog", Font.BOLD, 24));
			jButtonSave.setForeground(Color.white);
			jButtonSave.setText("Save");
			jButtonSave.setBackground(new Color(91, 155, 213));
			Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2, true); // the third parameter - true, says it's round
		    jButtonSave.setBorder(roundedBorder);
		}
		return jButtonSave;
	}

	/**
	 * This method initializes jTextFieldName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldName() {
		if (jTextFieldName == null) {
			jTextFieldName = new JTextField();
			jTextFieldName.setBounds(new Rectangle(166, 93, 219, 35));
		}
		return jTextFieldName;
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
					JPanel panel = new EditStaffAccount(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jLabelBack;
	}
}
