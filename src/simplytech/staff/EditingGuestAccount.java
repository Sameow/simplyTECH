package simplytech.staff;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class EditingGuestAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBarBelowBackButton = null;
	private JLabel jLabelEditingGuestAccount = null;

	private JFrame myFrame=null;
	private JLabel jLabelAccountDetails = null;
	private JButton jButtonSave = null;
	private JLabel jLabelName = null;
	private JTextField jTextFieldName = null;
	private JLabel jLabelAge = null;
	private JTextField jTextFieldAge = null;
	private JLabel jLabelPassportNo = null;
	private JTextField jTextField = null;
	private JLabel jLabelGender = null;
	private JTextField jTextFieldGender = null;
	private JLabel jLabelNationality = null;
	private JTextField jTextField1Nationality = null;
	private JLabel jLabelBack = null;
	/**
	 * This is the default constructor
	 */
	public EditingGuestAccount() {
		super();
		initialize();
	}

	public EditingGuestAccount (JFrame f) {
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
		jLabelNationality = new JLabel();
		jLabelNationality.setBounds(new Rectangle(30, 451, 207, 61));
		jLabelNationality.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelNationality.setText("Nationality:");
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(30, 376, 166, 59));
		jLabelGender.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelGender.setText("Gender:");
		jLabelPassportNo = new JLabel();
		jLabelPassportNo.setBounds(new Rectangle(30, 302, 170, 55));
		jLabelPassportNo.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPassportNo.setText("Passport Number:");
		jLabelAge = new JLabel();
		jLabelAge.setBounds(new Rectangle(30, 226, 166, 60));
		jLabelAge.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelAge.setText("Age:");
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(30, 151, 163, 61));
		jLabelName.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelName.setText("Name:");
		jLabelAccountDetails = new JLabel();
		jLabelAccountDetails.setBounds(new Rectangle(388, 87, 294, 53));
		jLabelAccountDetails.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelAccountDetails.setFont(new Font("Dialog", Font.BOLD, 36));
		jLabelAccountDetails.setText("Account Details");
		jLabelEditingGuestAccount = new JLabel();
		jLabelEditingGuestAccount.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelEditingGuestAccount.setLocation(new Point(91, 23));
		jLabelEditingGuestAccount.setSize(new Dimension(317, 35));
		jLabelEditingGuestAccount.setText("Editing Guest Account");
		jLabelBarBelowBackButton = new JLabel();
		jLabelBarBelowBackButton.setText("");
		jLabelBarBelowBackButton.setLocation(new Point(0, 78));
		jLabelBarBelowBackButton.setBackground(new Color(91, 155, 213));
		jLabelBarBelowBackButton.setSize(new Dimension(371, 4));
		jLabelBarBelowBackButton.setOpaque(true);
		
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelEditingGuestAccount, null);
		this.add(jLabelBarBelowBackButton, null);
		this.add(jLabelAccountDetails, null);
		this.add(getJButtonSave(), null);
		this.add(jLabelName, null);
		this.add(getJTextFieldName(), null);
		this.add(jLabelAge, null);
		this.add(getJTextFieldAge(), null);
		this.add(jLabelPassportNo, null);
		this.add(getJTextField(), null);
		this.add(jLabelGender, null);
		this.add(getJTextFieldGender(), null);
		this.add(jLabelNationality, null);
		this.add(getJTextField1Nationality(), null);
		this.add(getJLabelBack());
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
			jTextFieldName.setBounds(new Rectangle(241, 151, 433, 59));
		}
		return jTextFieldName;
	}

	/**
	 * This method initializes jTextFieldAge	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAge() {
		if (jTextFieldAge == null) {
			jTextFieldAge = new JTextField();
			jTextFieldAge.setBounds(new Rectangle(240, 227, 436, 57));
		}
		return jTextFieldAge;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(240, 302, 436, 56));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextFieldGender	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldGender() {
		if (jTextFieldGender == null) {
			jTextFieldGender = new JTextField();
			jTextFieldGender.setBounds(new Rectangle(242, 377, 433, 57));
		}
		return jTextFieldGender;
	}

	/**
	 * This method initializes jTextField1Nationality	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1Nationality() {
		if (jTextField1Nationality == null) {
			jTextField1Nationality = new JTextField();
			jTextField1Nationality.setBounds(new Rectangle(240, 450, 435, 62));
		}
		return jTextField1Nationality;
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
					JPanel panel = new StaffMainPage(myFrame);
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
