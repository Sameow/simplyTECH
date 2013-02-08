package simplytech.lobby;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import simplytech.dao.AccommodationsDAO;
import simplytech.dao.CreditCardDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.AccommodationsEntity;
import simplytech.entity.CreditCard;
import simplytech.entity.Customer;
import simplytech.entity.Person;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Accommodations extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel accommodationsPanel1 = null;
	private JLabel jLabelAccoBack = null;
	private JLabel jLabelAccoHeader = null;
	private JLabel jLabelAccoName = null;
	private JLabel jLabelAccoCard = null;
	private JLabel jLabelAccoMembership = null;
	private JTextPane jTextPaneAccoRoom = null;
	private JTextPane jTextPaneAccoRooms = null;
	private JTextPane jTextPaneAccoFrom = null;
	private JTextPane jTextPaneAccoPreference = null;
	private JTextPane jTextPaneAccoConRoom = null;
	private JTextPane jTextPaneAccoSeaView = null;
	private JFrame myFrame = null;
	private JButton jButtonGridView = null;
	private JButton jButtonDone1 = null;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox comboBox_Day;
	private JComboBox comboBox_Room;
	private JLabel jLabelPrice;
	private JTextPane txtpnRoomNo;
	private JComboBox comboBox_RoomNumber;
	private int getSuite;
	private Person person = null;
	private String name;
	private CreditCard card = null;
	private JLabel displayPts;
	private JLabel displayMembership;
	private String cardNumber;
	private String cardType;
	private Customer cd = null;
	private String membership;
	private int points;
	private double suitePrice;
	private String suite;
	private double getSuitePrice = 0;
	private double totalPrice;
	private String checkOut;
	private int day;
	private int getDay;
	private int getRoom;
	private int room;
	private JComboBox comboBox_Suite;
	private JDateChooser dateChooser_From = null;
	private JDateChooser dateChooser_To = null;
	private Calendar from;
	private Calendar to;
	private Calendar c;
	private int totalDate;
	private boolean checkDate = false;
	private SimpleDateFormat timeFormat = new SimpleDateFormat(
			"HH:mm:ss dd MMM yyyy");
	private int noOfDays = 0;
	private JSpinner spinner = null;

	/**
	 * This is the default constructor
	 */
	public Accommodations() {
		super();
		initialize();
	}

	public Accommodations(JFrame f) {
		this();
		myFrame = f;
		// initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		card = CreditCardDAO.searchById(MainFrame.getPersonWhoLogin().getId());
		cardNumber = card.getCardNumber() + "";
		cardType = card.getCardType();
		membership = MainFrame.getPersonWhoLogin().getMembership();
		points = MainFrame.getPersonWhoLogin().getPoints();
		jLabelAccoMembership = new JLabel();
		jLabelAccoMembership.setPreferredSize(new Dimension(150, 29));
		jLabelAccoMembership.setText("Membership:");
		jLabelAccoMembership.setLocation(new Point(30, 440));
		jLabelAccoMembership.setSize(new Dimension(150, 29));
		jLabelAccoMembership.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelAccoCard = new JLabel();
		jLabelAccoCard.setPreferredSize(new Dimension(80, 24));
		jLabelAccoCard.setText("Card:");
		jLabelAccoCard.setSize(new Dimension(80, 24));
		jLabelAccoCard.setLocation(new Point(30, 210));
		jLabelAccoCard.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelAccoName = new JLabel();
		jLabelAccoName.setText("Name:");
		jLabelAccoName.setLocation(new Point(30, 120));
		jLabelAccoName.setSize(new Dimension(85, 22));
		jLabelAccoName.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelAccoHeader = new JLabel();
		jLabelAccoHeader.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelAccoHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelAccoHeader.setText("Accommodations");
		jLabelAccoHeader.setBounds(new Rectangle(91, 23, 250, 35));
		jLabelAccoHeader.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelAccoBack = new JLabel();
		jLabelAccoBack.setText("");
		jLabelAccoBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelAccoBack.setIcon(new ImageIcon(Accommodations.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelAccoBack.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new LobbySuite(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
			}

			public void mouseEntered(java.awt.event.MouseEvent e) {
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
			}
		});

		JLabel displayName = new JLabel("");
		displayName.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayName.setBounds(40, 150, 187, 31);
		displayName.setText(MainFrame.getPersonWhoLogin().getName());
		add(displayName);

		spinner = new JSpinner();
//		spinner.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				room = (int) spinner.getValue();
//			}
//		});
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));
		spinner.setBounds(440, 355, 50, 23);
		add(spinner);

		JLabel displayCard = new JLabel("");
		displayCard.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayCard.setBounds(40, 240, 235, 31);
		displayCard.setText(cardType + " XXX-" + cardNumber.charAt(12)
				+ cardNumber.charAt(13) + cardNumber.charAt(14)
				+ cardNumber.charAt(15));
		add(displayCard);
		add(getDisplayPts());
		add(displayMembership());

		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setBackground(new Color(227, 228, 250));
		this.add(getAccommodationsPanel1(), null);
		this.add(jLabelAccoBack, null);
		this.add(jLabelAccoHeader, null);
		this.add(jLabelAccoName, null);
		this.add(jLabelAccoCard, null);
		this.add(jLabelAccoMembership, null);
		this.add(getJTextPaneAccoRoom(), null);
		this.add(getJTextPaneAccoRooms(), null);
		this.add(getJTextPaneAccoFrom(), null);
		this.add(getJTextPaneAccoPreference(), null);
		this.add(getJTextPaneAccoConRoom(), null);
		this.add(getJTextPaneAccoSeaView(), null);
		this.add(getJButtonGridView(), null);
		this.add(getJButtonDone1(), null);

		JRadioButton YesRB = new JRadioButton("Yes");
		YesRB.setFont(new Font("Arial", Font.PLAIN, 14));
		YesRB.setBounds(757, 230, 55, 28);
		YesRB.setBackground(new Color(227, 228, 250));
		add(YesRB);

		JRadioButton NoRB = new JRadioButton("No");
		NoRB.setFont(new Font("Arial", Font.PLAIN, 14));
		NoRB.setBounds(830, 230, 55, 28);
		NoRB.setBackground(new Color(227, 228, 250));
		add(NoRB);

		JRadioButton YesRBCon = new JRadioButton("Yes");
		YesRBCon.setFont(new Font("Arial", Font.PLAIN, 14));
		YesRBCon.setBounds(757, 171, 55, 28);
		YesRBCon.setBackground(new Color(227, 228, 250));
		add(YesRBCon);

		JRadioButton NoRBCon = new JRadioButton("No");
		NoRBCon.setFont(new Font("Arial", Font.PLAIN, 14));
		NoRBCon.setBounds(830, 171, 55, 28);
		NoRBCon.setBackground(new Color(227, 228, 250));
		add(NoRBCon);

		ButtonGroup SeaView = new ButtonGroup();
		SeaView.add(YesRB);
		SeaView.add(NoRB);

		ButtonGroup ConRoom = new ButtonGroup();
		ConRoom.add(YesRBCon);
		ConRoom.add(NoRBCon);
		// add(getComboBox_Day());
		add(getComboBox_Room());

		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setText("Price :");
		txtpnPrice.setSize(new Dimension(80, 30));
		txtpnPrice.setPreferredSize(new Dimension(100, 28));
		txtpnPrice.setLocation(new Point(350, 320));
		txtpnPrice.setFont(new Font("Arial", Font.PLAIN, 18));
		txtpnPrice.setEditable(false);
		txtpnPrice.setBackground(new Color(227, 228, 250));
		txtpnPrice.setBounds(650, 325, 80, 30);
		add(txtpnPrice);
		add(getJLabelPrice());
		// add(getTxtpnRoomNo());
		// add(getComboBox_RoomNumber());

		JLabel label = new JLabel();
		label.setText("Points:");
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setBounds(new Rectangle(30, 280, 120, 24));
		label.setBounds(30, 325, 120, 30);
		add(label);
		add(getComboBox_Suite());

		dateChooser_From = new JDateChooser();
		dateChooser_From.setBounds(435, 215, 120, 23);
		add(dateChooser_From);

		JTextPane txtpnTo = new JTextPane();
		txtpnTo.setText("To :");
		txtpnTo.setSize(new Dimension(65, 28));
		txtpnTo.setLocation(new Point(360, 210));
		txtpnTo.setFont(new Font("Arial", Font.PLAIN, 18));
		txtpnTo.setEditable(false);
		txtpnTo.setBackground(new Color(227, 228, 250));
		txtpnTo.setBounds(380, 280, 50, 28);
		add(txtpnTo);

		dateChooser_To = new JDateChooser();
		dateChooser_To.setBounds(435, 285, 120, 23);
		add(dateChooser_To);
	}

	private JLabel getDisplayPts() {
		if (displayPts == null) {
			displayPts = new JLabel("");
			displayPts.setText(MainFrame.getPersonWhoLogin().getPoints() + "");
			displayPts.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayPts.setBounds(40, 360, 127, 31);
		}
		return displayPts;
	}

	private JLabel displayMembership() {
		if (displayMembership == null) {
			displayMembership = new JLabel("");
			displayMembership.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayMembership.setBounds(40, 470, 187, 31);
			displayMembership.setText(MainFrame.getPersonWhoLogin()
					.getMembership());
		}
		return displayMembership;
	}

	/**
	 * This method initializes accommodationsPanel1
	 * 
	 * @return java.awt.Panel
	 */
	private Panel getAccommodationsPanel1() {
		if (accommodationsPanel1 == null) {
			accommodationsPanel1 = new Panel();
			accommodationsPanel1.setLayout(null);
			accommodationsPanel1.setFont(new Font("Arial", Font.BOLD, 12));
			accommodationsPanel1.setMinimumSize(new Dimension(300, 4));
			accommodationsPanel1.setName("");
			accommodationsPanel1.setBounds(new Rectangle(0, 78, 371, 4));
			accommodationsPanel1.setBackground(new Color(91, 155, 213));
		}
		return accommodationsPanel1;
	}

	/**
	 * This method initializes jTextPaneAccoRoom
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoRoom() {
		if (jTextPaneAccoRoom == null) {
			jTextPaneAccoRoom = new JTextPane();
			jTextPaneAccoRoom.setFont(new Font("Arial", Font.PLAIN, 18));
			jTextPaneAccoRoom.setSize(new Dimension(80, 25));
			jTextPaneAccoRoom.setText("Suite(s):");
			jTextPaneAccoRoom.setBackground(new Color(227, 228, 250));
			jTextPaneAccoRoom.setEditable(false);
			jTextPaneAccoRoom.setLocation(new Point(350, 140));
		}
		return jTextPaneAccoRoom;
	}

	/**
	 * This method initializes jTextPaneAccoRooms
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoRooms() {
		if (jTextPaneAccoRooms == null) {
			jTextPaneAccoRooms = new JTextPane();
			jTextPaneAccoRooms.setFont(new Font("Arial", Font.PLAIN, 18));
			jTextPaneAccoRooms.setText("Rooms :");
			jTextPaneAccoRooms.setPreferredSize(new Dimension(100, 28));
			jTextPaneAccoRooms.setLocation(new Point(350, 350));
			jTextPaneAccoRooms.setSize(new Dimension(80, 30));
			jTextPaneAccoRooms.setEditable(false);
			jTextPaneAccoRooms.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneAccoRooms;
	}

	/**
	 * This method initializes jTextPaneAccoDays
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoFrom() {
		if (jTextPaneAccoFrom == null) {
			jTextPaneAccoFrom = new JTextPane();
			jTextPaneAccoFrom.setFont(new Font("Arial", Font.PLAIN, 18));
			jTextPaneAccoFrom.setText("From :");
			jTextPaneAccoFrom.setEditable(false);
			jTextPaneAccoFrom.setSize(new Dimension(65, 28));
			jTextPaneAccoFrom.setLocation(new Point(362, 210));
			jTextPaneAccoFrom.setBackground(new Color(227, 228, 250));

		}
		return jTextPaneAccoFrom;
	}

	/**
	 * This method initializes jTextPaneAccoPreference
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoPreference() {
		if (jTextPaneAccoPreference == null) {
			jTextPaneAccoPreference = new JTextPane();
			jTextPaneAccoPreference.setFont(new Font("Arial", Font.BOLD, 24));
			jTextPaneAccoPreference.setText("Preference");
			jTextPaneAccoPreference.setLocation(new Point(650, 90));
			jTextPaneAccoPreference.setSize(new Dimension(150, 30));
			jTextPaneAccoPreference.setEditable(false);
			jTextPaneAccoPreference.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneAccoPreference;
	}

	/**
	 * This method initializes jTextPaneAccoConRoom
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoConRoom() {
		if (jTextPaneAccoConRoom == null) {
			jTextPaneAccoConRoom = new JTextPane();
			jTextPaneAccoConRoom.setFont(new Font("Arial", Font.PLAIN, 18));
			jTextPaneAccoConRoom.setText("Consecutive Rooms:");
			jTextPaneAccoConRoom.setEditable(false);
			jTextPaneAccoConRoom.setLocation(new Point(650, 140));
			jTextPaneAccoConRoom.setSize(new Dimension(109, 54));
			jTextPaneAccoConRoom.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneAccoConRoom;
	}

	/**
	 * This method initializes jTextPaneAccoSeaView
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneAccoSeaView() {
		if (jTextPaneAccoSeaView == null) {
			jTextPaneAccoSeaView = new JTextPane();
			jTextPaneAccoSeaView.setFont(new Font("Arial", Font.PLAIN, 18));
			jTextPaneAccoSeaView.setText("Sea View:");
			jTextPaneAccoSeaView.setEditable(false);
			jTextPaneAccoSeaView.setLocation(new Point(650, 230));
			jTextPaneAccoSeaView.setSize(new Dimension(100, 28));
			jTextPaneAccoSeaView.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneAccoSeaView;
	}

	/**
	 * This method initializes jComboBoxSuite
	 * 
	 * @return javax.swing.JComboBox
	 */
	/*
	 * private JComboBox getJComboBoxSuite() {
	 * 
	 * if (jComboBoxSuite == null) { jComboBoxSuite = new JComboBox();
	 * jComboBoxSuite.setLocation(new Point(430, 125));
	 * jComboBoxSuite.setFont(new Font("Arial", Font.BOLD, 18));
	 * jComboBoxSuite.setName(""); jComboBoxSuite.setBackground(new Color(91,
	 * 155, 213)); jComboBoxSuite.setActionMap(new ActionMap());
	 * jComboBoxSuite.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	 * jComboBoxSuite.setSize(new Dimension(130, 20));
	 * 
	 * } return jComboBoxSuite; }
	 */
	/**
	 * This method initializes jButtonGridView
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGridView() {
		if (jButtonGridView == null) {
			jButtonGridView = new JButton();
			jButtonGridView.setBackground(new Color(91, 155, 213));
			jButtonGridView.setBounds(new Rectangle(650, 380, 95, 30));
			jButtonGridView.setForeground(Color.white);
			jButtonGridView.setText("Grid View");
			jButtonGridView.setVisible(false);
			jButtonGridView
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JPanel panel = new GridView(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonGridView;
	}

	/**
	 * This method initializes jButtonDone1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonDone1() {
		if (jButtonDone1 == null) {
			jButtonDone1 = new JButton();
			jButtonDone1.setBounds(new Rectangle(770, 440, 150, 80));
			jButtonDone1.setFont(new Font("Arial", Font.BOLD, 18));
			jButtonDone1.setText("Done");
			jButtonDone1.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonDone1.setForeground(Color.white);
			jButtonDone1.setBackground(new Color(91, 155, 213));
			jButtonDone1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					noOfDays = 0;
					room = (int) spinner.getValue();
					if (suite != null) {
						if (suite.equals("Orchid Suite")) {
							getSuitePrice = 100;
						} else if (suite.equals("Gold Suite")) {
							getSuitePrice = 200;
						} else if (suite.equals("Sands Suite")) {
							getSuitePrice = 300;
						} else if (suite.equals("Deluxe Suite")) {
							getSuitePrice = 400;
						} else if (suite.equals("Presidential Suite")) {
							getSuitePrice = 500;
						}
					}
					from = dateChooser_From.getCalendar();
					to = dateChooser_To.getCalendar();

					if (to != null && from != null) {
						if (to.before(from) == true) {
							checkDate = false;
							int option = JOptionPane.showConfirmDialog(myFrame,
									"Please pick the correct date!",
									"Confirmation", JOptionPane.PLAIN_MESSAGE);
						}

						else if (to.before(from) == false) {

							c = from;
							while (c.before(to)) {
								noOfDays++;
								c.add(Calendar.DATE, 1);
							}
							System.out.println("No of days" + noOfDays);
							checkDate = true;
							totalDate = (to.getTime().getDate() + 2)
									- (from.getTime().getDate() + 1);
						}
					}
					// Calculate price 1st
					if (checkDate) {
						totalPrice = calculatePrice(getSuitePrice, noOfDays,
								comboBox_Room.getSelectedIndex() + 1);
						// Price then will show on the confirmation dialog
						int option = JOptionPane.showConfirmDialog(myFrame,
								"Are you sure you want to book "
										+ (String) suite + "\n" + "Days: "
										+ noOfDays + "\n" + "Rooms: " + room
										+ "\n" + "Price: $" + totalPrice + "?",
								"Confirmation", JOptionPane.YES_NO_OPTION);

						Date date = new Date();
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						c.add(Calendar.DATE, day);
						// checkOut = timeFormat.format(c.getTime());
						checkOut = dateChooser_To.getDate().toString();
						if (option == JOptionPane.YES_OPTION) {
							AccommodationsEntity accommodation = new AccommodationsEntity(
									MainFrame.getPersonWhoLogin().getId(),
									suite, noOfDays, room, totalPrice,
									checkOut, "A1");
							try {
								AccommodationsDAO
										.createAccommodation(accommodation);
								int finalPoints = MainFrame.getPersonWhoLogin()
										.getPoints() + (int) totalPrice;
								MainFrame.getPersonWhoLogin().setPoints(
										finalPoints);
								CustomerDAO.updatePoints(finalPoints,
										finalPoints);
								JPanel panel = new LobbySuite(myFrame);
								myFrame.getContentPane().removeAll();
								myFrame.getContentPane().add(panel);
								myFrame.getContentPane().validate();
								myFrame.getContentPane().repaint();

								int option1 = JOptionPane.showConfirmDialog(
										myFrame,
										"Thank you for booking with us!",
										"Confirmation",
										JOptionPane.PLAIN_MESSAGE);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
					;
				}
			});
		}
		return jButtonDone1;
	}

	private double calculatePrice(double suitePrice, int comboBox_Day,
			int comboBox_Room) {
		double totalPrice;
		totalPrice = suitePrice * comboBox_Day * comboBox_Room;
		return totalPrice;
	}

	/*
	 * private int checkOut(int checkOut) {
	 * 
	 * checkOut = comboBox_Day.getSelectedIndex() + 1 + 1; return checkOut; }
	 * 
	 * private JComboBox getComboBox_Day() { if (comboBox_Day == null) {
	 * comboBox_Day = new JComboBox(); comboBox_Day.addMouseListener(new
	 * MouseAdapter() { public void mouseClicked(MouseEvent e) { getDay =
	 * comboBox_Day.getSelectedIndex(); switch (getDay) { case 0: day = 1;
	 * break; case 1: day = 2; break; case 2: day = 3; break; case 3: day = 4;
	 * break; case 4: day = 5; break; default: day = 1; break; } } });
	 * comboBox_Day.setFont(new Font("Arial", Font.PLAIN, 14));
	 * comboBox_Day.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
	 * "3", "4", "5" })); comboBox_Day.setBounds(291, 245, 50, 23); } return
	 * comboBox_Day; }
	 */

	private JComboBox getComboBox_Room() {
		if (comboBox_Room == null) {
			comboBox_Room = new JComboBox();
			comboBox_Room.setVisible(false);
			comboBox_Room.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					getRoom = comboBox_Room.getSelectedIndex();
					switch (getRoom) {
					case 0:
						room = 1;
						break;
					case 1:
						room = 2;
						break;
					case 2:
						room = 3;
						break;
					case 3:
						room = 4;
						break;
					case 4:
						room = 5;
						break;
					case 5:
						room = 6;
						break;
					case 6:
						room = 7;
						break;
					case 7:
						room = 8;
						break;
					default:
						room = 1;
						break;
					}

				}
			});
			comboBox_Room.setModel(new DefaultComboBoxModel(new String[] { "1",
					"2", "3", "4", "5", "6", "7", "8" }));
			comboBox_Room.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBox_Room.setBounds(440, 355, 50, 23);
		}
		return comboBox_Room;
	}

	private JLabel getJLabelPrice() {
		if (jLabelPrice == null) {
			jLabelPrice = new JLabel("");
			jLabelPrice.setFont(new Font("Calibri", Font.BOLD, 34));
			jLabelPrice.setBounds(732, 327, 80, 28);
			jLabelPrice.setVisible(true);
		}
		return jLabelPrice;
	}

	private JComboBox getComboBox_Suite() {
		if (comboBox_Suite == null) {
			comboBox_Suite = new JComboBox();
			comboBox_Suite.setFont(new Font("Calibri", Font.PLAIN, 18));
			comboBox_Suite.setModel(new DefaultComboBoxModel(new String[] {
					"Orchid Suite", "Gold Suite", "Sands Suite",
					"Deluxe Suite", "Presidential Suite" }));
			comboBox_Suite.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					getSuite = comboBox_Suite.getSelectedIndex();
					System.err.println(getSuite);
					switch (getSuite) {
					case 0:
						suite = "Orchid Suite";
						jLabelPrice.setText("$100");
						break;
					case 1:
						suite = "Gold Suite";
						jLabelPrice.setText("$200");
						break;
					case 2:
						suite = "Sands Suite";
						jLabelPrice.setText("$300");
						break;
					case 3:
						suite = "Deluxe Suite";
						jLabelPrice.setText("$400");
						break;

					case 4:
						suite = "Presidential Suite";
						jLabelPrice.setText("$500");
						break;

					default:
						jLabelPrice.setText("$0");
						break;
					}
				}
			});
			comboBox_Suite.setBounds(440, 145, 170, 23);
		}
		return comboBox_Suite;
	}
} // @jve:decl-index=0:visual-constraint="9,16"
