package simplytech.staff;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

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

import simplytech.components.DesEncryption;
import simplytech.dao.AccommodationsDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.AccommodationsEntity;
import simplytech.entity.Customer;
import simplytech.entity.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class EditingGuestAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBarBelowBackButton = null;
	private JLabel jLabelEditingGuestAccount = null;

	private JFrame myFrame = null;
	private JLabel jLabelAccountDetails = null;
	private JButton jButtonSave = null;
	private JLabel jLabelName = null;
	private JTextField jTextFieldName = null;
	private JLabel jLabelAge = null;
	private JTextField jTextFieldUsername = null;
	private JLabel jLabelPassportNo = null;
	private JTextField jTextFieldNRIC = null;
	private JLabel jLabelGender = null;
	private JPasswordField jTextFieldPassword = null;
	private JLabel jLabelNationality = null;
	private JLabel jLabelEmail;
	private JTextField jTextFieldMobile = null;
	private JLabel jLabelBack = null;
	private int customerId;
	private Customer customer;
	private String username;
	private String roomNumber;
	private double extraCharges;
	private int stay;
	private String membership;
	private String checkOut;
	private int points;
	private String name;
	private String gender;
	private String NRIC;
	private String password;
	private String mobile;
	private String address;
	private String email;
	private String userType;
	private int doNotDisturb;
	private double roomPrice;
	private double totalPrice;
	private String alarm;
	private int id;
	private JLabel lblAddress_1;
	private JTextField jTextFieldEmail;
	private JLabel label;
	private JTextField jTextFieldAddress;
	private JLabel lblRoomNumber;
	private JTextField jTextFieldMembership;
	private JTextField jTextFieldRoomNumber;
	private JLabel lblExtracharges;
	private JLabel lblExtracharges_1;
	private JTextField jTextFieldExtraCharges;
	private JTextField jTextFieldPoints;
	private JLabel lblPoints;
	private JLabel lblStay;
	private JTextField jTextFieldStay;
	private JTextField jTextFieldCheckOut;
	private JLabel lblCheckOut;
	private DesEncryption encryption = new DesEncryption("Password");
	private boolean check = false;
	private AccommodationsEntity accommodations = new AccommodationsEntity();

	/**
	 * This is the default constructor
	 */
	public EditingGuestAccount(JFrame f, int customerId) {
		myFrame = f;
		this.customerId = customerId;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		customer = CustomerDAO.searchById(customerId);
		accommodations = AccommodationsDAO.searchById(customerId + "");
		id = customer.getId();
		username = customer.getUsername();
		roomNumber = customer.getRoomNumber();
		extraCharges = customer.getExtraCharges();
		stay = accommodations.getAccoDay();
		membership = customer.getMembership();
		checkOut = customer.getCheckOut();
		points = customer.getPoints();
		name = customer.getName();
		gender = customer.getGender();
		NRIC = customer.getNRIC();
		password = encryption.decrypt(customer.getPassword());
		mobile = customer.getMobile();
		address = customer.getAddress();
		email = customer.getEmail();
		userType = customer.getUserType();
		doNotDisturb = customer.getDoNotDisturb();
		alarm = customer.getAlarm();
		roomPrice = accommodations.getAccoPrice();
		totalPrice = extraCharges + roomPrice;
		jLabelEmail = new JLabel();
		jLabelEmail.setBounds(new Rectangle(30, 373, 163, 61));
		jLabelEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelEmail.setText("Mobile:");
		jLabelGender = new JLabel();
		jLabelGender.setBounds(new Rectangle(30, 313, 166, 59));
		jLabelGender.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelGender.setText("Password:");
		jLabelPassportNo = new JLabel();
		jLabelPassportNo.setBounds(new Rectangle(30, 253, 170, 55));
		jLabelPassportNo.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelPassportNo.setText("Passport Number:");
		jLabelAge = new JLabel();
		jLabelAge.setBounds(new Rectangle(30, 193, 166, 60));
		jLabelAge.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelAge.setText("Username:");
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(30, 133, 163, 61));
		jLabelName.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelName.setText("Name:");
		jLabelAccountDetails = new JLabel();
		jLabelAccountDetails.setBounds(new Rectangle(388, 69, 294, 53));
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
		this.add(getJTextFieldUsername(), null);
		this.add(jLabelPassportNo, null);
		this.add(getJTextFieldNRIC(), null);
		this.add(jLabelGender, null);
		this.add(getJTextFieldPassword(), null);
		this.add(jLabelEmail, null);
		this.add(getJTextFieldMobile(), null);
		this.add(getJLabelBack());
		add(getLblAddress_1());
		add(getJTextFieldEmail());
		add(getLabel());
		add(getJTextFieldAddress());
		add(getLabel_1_1());
		add(getTextField_6());
		add(getTextField_1_1());
		add(getLabel_2_1());
		add(getLabel_3_1());
		add(getTextField_2_1());
		add(getTextField_3_1());
		add(getLabel_4_1());
		add(getLblStay());
		add(getTextField_4_1());
		add(getTextField_6_1());
		add(getLblCheckOut());

		JButton buttonEdit = new JButton();
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTextFieldName.isEditable() == false) {
					jTextFieldName.setEditable(true);
					jTextFieldUsername.setEditable(true);
					jTextFieldPassword.setEditable(true);
					jTextFieldExtraCharges.setEditable(true);
					jTextFieldMembership.setEditable(true);
					jTextFieldPoints.setEditable(true);
					jTextFieldEmail.setEditable(true);
					jTextFieldAddress.setEditable(true);
					jTextFieldMobile.setEditable(true);
					jTextFieldNRIC.setEditable(true);
				} else {
					jTextFieldName.setEditable(false);
					jTextFieldUsername.setEditable(false);
					jTextFieldPassword.setEditable(false);
					jTextFieldExtraCharges.setEditable(false);
					jTextFieldMembership.setEditable(false);
					jTextFieldPoints.setEditable(false);
					jTextFieldEmail.setEditable(false);
					jTextFieldAddress.setEditable(false);
					jTextFieldMobile.setEditable(false);
					jTextFieldNRIC.setEditable(false);
				}
			}
		});
		buttonEdit.setText("Edit");
		buttonEdit.setForeground(Color.WHITE);
		buttonEdit.setFont(new Font("Dialog", Font.BOLD, 24));
		buttonEdit.setBounds(new Rectangle(780, 526, 151, 27));
		buttonEdit.setBackground(new Color(91, 155, 213));
		buttonEdit.setBounds(587, 508, 151, 27);
		add(buttonEdit);
	}

	/**
	 * This method initializes jButtonSave
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Person person = PersonDAO
							.searchByUsername(jTextFieldUsername.getText());
					if (!(jTextFieldUsername.getText().equals(userType))) {
						check = true;
					} else if (person != null) {
						JOptionPane.showConfirmDialog(myFrame,
								"Username is in use.", "Confirmation",
								JOptionPane.ERROR_MESSAGE);
						check = false;
					} else {
						check = true;
					}
					if (check) {
						username = jTextFieldUsername.getText();
						name = jTextFieldName.getText();
						password = encryption.encrypt(jTextFieldPassword
								.getText());
						try {
							extraCharges = Integer
									.parseInt(jTextFieldExtraCharges.getText());
							points = Integer.parseInt(jTextFieldPoints
									.getText());
						} catch (NumberFormatException nFE) {

						}
						membership = jTextFieldMembership.getText();
						email = jTextFieldEmail.getText();
						address = jTextFieldAddress.getText();
						mobile = jTextFieldMobile.getText();
						NRIC = jTextFieldNRIC.getText();

						System.out.println("Panel: " + id);
						Customer newCustomer = new Customer(id, name, gender,
								NRIC, username, password, mobile, email,
								address, userType, extraCharges, stay,
								membership, checkOut, points, doNotDisturb,
								alarm, roomNumber);
						CustomerDAO.updateCustomer(newCustomer);
						JOptionPane.showConfirmDialog(myFrame,
								"Account has been updated.", "Confirmation",
								JOptionPane.ERROR_MESSAGE);
						JPanel panel = new EditingGuestAccount(myFrame,
								customerId);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();

					}
				}
			});
			jButtonSave.setBounds(new Rectangle(780, 508, 151, 27));
			jButtonSave.setFont(new Font("Dialog", Font.BOLD, 24));
			jButtonSave.setForeground(Color.white);
			jButtonSave.setText("Save");
			jButtonSave.setBackground(new Color(91, 155, 213));
			Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2,
					true); // the third parameter - true, says it's round
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
			jTextFieldName.setBounds(new Rectangle(215, 142, 270, 35));
			jTextFieldName.setText(name);
			jTextFieldName.setEditable(false);
		}
		return jTextFieldName;
	}

	/**
	 * This method initializes jTextFieldAge
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setBounds(new Rectangle(215, 202, 270, 35));
			jTextFieldUsername.setText(username);
			jTextFieldUsername.setEditable(false);
		}
		return jTextFieldUsername;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNRIC() {
		if (jTextFieldNRIC == null) {
			jTextFieldNRIC = new JTextField();
			jTextFieldNRIC.setBounds(new Rectangle(215, 262, 270, 35));
			jTextFieldNRIC.setText(NRIC);
			jTextFieldNRIC.setEditable(false);
		}
		return jTextFieldNRIC;
	}

	/**
	 * This method initializes jTextFieldGender
	 * 
	 * @return javax.swing.JTextField
	 */
	private JPasswordField getJTextFieldPassword() {
		if (jTextFieldPassword == null) {
			jTextFieldPassword = new JPasswordField();
			jTextFieldPassword.setBounds(new Rectangle(215, 322, 270, 35));
			jTextFieldPassword.setText(password);
			jTextFieldPassword.setEditable(false);
		}
		return jTextFieldPassword;
	}

	/**
	 * This method initializes jTextField1Nationality
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldMobile() {
		if (jTextFieldMobile == null) {
			jTextFieldMobile = new JTextField();
			jTextFieldMobile.setBounds(new Rectangle(215, 382, 270, 35));
			jTextFieldMobile.setText(mobile);
			jTextFieldMobile.setEditable(false);
		}
		return jTextFieldMobile;
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

	private JLabel getLblAddress_1() {
		if (lblAddress_1 == null) {
			lblAddress_1 = new JLabel();
			lblAddress_1.setText("Email:");
			lblAddress_1.setFont(new Font("Dialog", Font.BOLD, 18));
			lblAddress_1.setBounds(new Rectangle(30, 391, 163, 61));
			lblAddress_1.setBounds(30, 433, 163, 61);
		}
		return lblAddress_1;
	}

	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setBounds(new Rectangle(215, 400, 270, 35));
			jTextFieldEmail.setBounds(215, 442, 270, 35);
			jTextFieldEmail.setText(email);
			jTextFieldEmail.setEditable(false);
		}
		return jTextFieldEmail;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel();
			label.setText("Address:");
			label.setFont(new Font("Dialog", Font.BOLD, 18));
			label.setBounds(new Rectangle(30, 391, 163, 61));
			label.setBounds(30, 493, 163, 61);
		}
		return label;
	}

	private JTextField getJTextFieldAddress() {
		if (jTextFieldAddress == null) {
			jTextFieldAddress = new JTextField();
			jTextFieldAddress.setBounds(new Rectangle(215, 400, 270, 35));
			jTextFieldAddress.setBounds(215, 502, 270, 35);
			jTextFieldAddress.setText(address);
			jTextFieldAddress.setEditable(false);
		}
		return jTextFieldAddress;
	}

	private JLabel getLabel_1_1() {
		if (lblRoomNumber == null) {
			lblRoomNumber = new JLabel();
			lblRoomNumber.setText("Membership:");
			lblRoomNumber.setFont(new Font("Dialog", Font.BOLD, 18));
			lblRoomNumber.setBounds(new Rectangle(30, 151, 163, 61));
			lblRoomNumber.setBounds(534, 133, 163, 61);
		}
		return lblRoomNumber;
	}

	private JTextField getTextField_6() {
		if (jTextFieldMembership == null) {
			jTextFieldMembership = new JTextField();
			jTextFieldMembership.setBounds(new Rectangle(215, 160, 270, 35));
			jTextFieldMembership.setBounds(719, 142, 270, 35);
			jTextFieldMembership.setText(membership);
			jTextFieldMembership.setEditable(false);
		}
		return jTextFieldMembership;
	}

	private JTextField getTextField_1_1() {
		if (jTextFieldRoomNumber == null) {
			jTextFieldRoomNumber = new JTextField();
			jTextFieldRoomNumber.setBounds(new Rectangle(215, 220, 270, 35));
			jTextFieldRoomNumber.setBounds(719, 202, 270, 35);
			jTextFieldRoomNumber.setText(roomNumber);
			jTextFieldRoomNumber.setEditable(false);
		}
		return jTextFieldRoomNumber;
	}

	private JLabel getLabel_2_1() {
		if (lblExtracharges == null) {
			lblExtracharges = new JLabel();
			lblExtracharges.setText("Room Number:");
			lblExtracharges.setFont(new Font("Dialog", Font.BOLD, 18));
			lblExtracharges.setBounds(new Rectangle(30, 211, 166, 60));
			lblExtracharges.setBounds(534, 193, 166, 60);
		}
		return lblExtracharges;
	}

	private JLabel getLabel_3_1() {
		if (lblExtracharges_1 == null) {
			lblExtracharges_1 = new JLabel();
			lblExtracharges_1.setText("Total Charges:");
			lblExtracharges_1.setFont(new Font("Dialog", Font.BOLD, 18));
			lblExtracharges_1.setBounds(new Rectangle(30, 271, 170, 55));
			lblExtracharges_1.setBounds(534, 253, 170, 55);
		}
		return lblExtracharges_1;
	}

	private JTextField getTextField_2_1() {
		if (jTextFieldExtraCharges == null) {
			jTextFieldExtraCharges = new JTextField();
			jTextFieldExtraCharges.setBounds(new Rectangle(215, 280, 270, 35));
			jTextFieldExtraCharges.setBounds(719, 262, 270, 35);
			jTextFieldExtraCharges.setText(totalPrice + "0");
			jTextFieldExtraCharges.setEditable(false);
		}
		return jTextFieldExtraCharges;
	}

	private JTextField getTextField_3_1() {
		if (jTextFieldPoints == null) {
			jTextFieldPoints = new JTextField();
			jTextFieldPoints.setBounds(new Rectangle(215, 340, 270, 35));
			jTextFieldPoints.setBounds(719, 322, 270, 35);
			jTextFieldPoints.setText(points + "");
			jTextFieldPoints.setEditable(false);
		}
		return jTextFieldPoints;
	}

	private JLabel getLabel_4_1() {
		if (lblPoints == null) {
			lblPoints = new JLabel();
			lblPoints.setText("Points:");
			lblPoints.setFont(new Font("Dialog", Font.BOLD, 18));
			lblPoints.setBounds(new Rectangle(30, 331, 166, 59));
			lblPoints.setBounds(534, 313, 166, 59);
		}
		return lblPoints;
	}

	private JLabel getLblStay() {
		if (lblStay == null) {
			lblStay = new JLabel();
			lblStay.setText("Stay:");
			lblStay.setFont(new Font("Dialog", Font.BOLD, 18));
			lblStay.setBounds(new Rectangle(30, 391, 163, 61));
			lblStay.setBounds(534, 373, 163, 61);
		}
		return lblStay;
	}

	private JTextField getTextField_4_1() {
		if (jTextFieldStay == null) {
			jTextFieldStay = new JTextField();
			jTextFieldStay.setBounds(new Rectangle(215, 400, 270, 35));
			jTextFieldStay.setBounds(719, 382, 270, 35);
			jTextFieldStay.setText(stay + "");
			jTextFieldStay.setEditable(false);
		}
		return jTextFieldStay;
	}

	private JTextField getTextField_6_1() {
		if (jTextFieldCheckOut == null) {
			jTextFieldCheckOut = new JTextField();
			jTextFieldCheckOut.setBounds(new Rectangle(215, 400, 270, 35));
			jTextFieldCheckOut.setBounds(719, 442, 270, 35);
			jTextFieldCheckOut.setText(checkOut);
			jTextFieldCheckOut.setEditable(false);
		}
		return jTextFieldCheckOut;
	}

	private JLabel getLblCheckOut() {
		if (lblCheckOut == null) {
			lblCheckOut = new JLabel();
			lblCheckOut.setText("Check Out:\r\n");
			lblCheckOut.setFont(new Font("Dialog", Font.BOLD, 18));
			lblCheckOut.setBounds(new Rectangle(30, 391, 163, 61));
			lblCheckOut.setBounds(534, 433, 163, 61);
		}
		return lblCheckOut;
	}
}
