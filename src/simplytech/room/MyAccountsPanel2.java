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

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import simplytech.components.MACAddress;
import simplytech.dao.CreditCardDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.SocketException;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class MyAccountsPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonDone = null;
	private JButton jButtonAccountSummary = null;
	private JButton jButtonMyVouchers = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelBack = null;
	private Person person = new Person();
	private CreditCard CC = new CreditCard();
	private Customer CD = new Customer();
	private String name;
	private String cardType;
	private String username;
	private String cardNumber;
	private String mobile;
	private String email;
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
	private int id;
	private String gender;
	private String NRIC;
	private String userType;
	private String password;

	/**
	 * This is the default constructor
	 */
	public MyAccountsPanel2() {
		super();
		initialize();
	}

	public MyAccountsPanel2(JFrame f) {
		this();
		myFrame = f;
		// initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	private void initialize() {
		id = MainFrame.getPersonWhoLogin().getId();
		username = MainFrame.getPersonWhoLogin().getUsername();
		mobile = MainFrame.getPersonWhoLogin().getMobile();
		name = MainFrame.getPersonWhoLogin().getName();
		gender = MainFrame.getPersonWhoLogin().getGender();
		NRIC = MainFrame.getPersonWhoLogin().getNRIC();
		email = MainFrame.getPersonWhoLogin().getEmail();
		address = MainFrame.getPersonWhoLogin().getAddress();
		userType = MainFrame.getPersonWhoLogin().getUserType();
		password = MainFrame.getPersonWhoLogin().getPassword();
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

					if (changeAddress == true) {
						address = textAreaAddress.getText();
						if (textPaneAddress.getText().equals("")) {
							errorMessageAddress
									.setText("Address should not be left empty.");
						} else {
							try {
								Person person = new Person(id, name, gender,
										NRIC, username, password, mobile,
										email, address, userType);
								PersonDAO.updatePerson(person, MainFrame
										.getPersonWhoLogin().getId() + "");
								MainFrame.setPersonWhoLogin(person);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}

					}
					int option = JOptionPane.showConfirmDialog(myFrame,
							"Your account have been successfully updated!",
							"Confirmation", JOptionPane.PLAIN_MESSAGE);

					if (option == JOptionPane.OK_OPTION) {
						JPanel panel = new MyAccountsPanel2(myFrame);
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
									"MyAccountsPane2", "");
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
			textPaneAddress.setBackground(new Color(227, 228, 250));
			textPaneAddress.setBounds(210, 116, 192, 82);
			textPaneAddress.setText(address);
		}
		return textPaneAddress;
	}

	private JTextPane getTextPane_3() {
		if (errorMessageAddress == null) {
			errorMessageAddress = new JTextPane();
			errorMessageAddress.setBackground(new Color(227, 228, 250));
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
			lblNewLabel.setForeground(new Color(58, 115, 255));
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 12));
			lblNewLabel.setBounds(445, 187, 46, 14);
		}
		return lblNewLabel;
	}
}
