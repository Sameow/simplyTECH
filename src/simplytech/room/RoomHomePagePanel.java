package simplytech.room;

import simplytech.components.MACAddress;
import simplytech.room.RoomLoginPanel;
import simplytech.dao.AccommodationsDAO;
import simplytech.dao.AlarmClockDAO;
import simplytech.dao.AnnouncementDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.CustomerVouchersDAO;
import simplytech.entity.*;

import java.net.SocketException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class RoomHomePagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JTextPane jTextPane = null;
	private JLabel jLabelMyAccount = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel21 = null;
	private JLabel jLabel211 = null;
	private JLabel jLabel2111 = null;
	private JLabel jLabelName = null;
	private JLabel jLabelNameStay = null;
	private JLabel jLabelNameExtraCharges = null;
	private JLabel jLabelName1 = null;
	private JTextPane jTextPaneOff = null;
	private JTextPane jTextPaneDoNotDisturb = null;
	private JLabel jLabelNameMembership = null;
	private JLabel jLabelNameCheckOutDate = null;
	private JLabel jLabelNameCheckOutTime = null;
	private JLabel jLabelNamePoints = null;
	private JLabel jLabelNameAlarm = null;
	private JButton jButtonServices = null;
	private JButton jButtonAttractions = null;
	private JLabel jLabel3 = null;
	private JLabel jLabelFeedback = null;
	private JLabel jLabel31 = null;
	private JLabel jLabelCheckOut = null;
	GregorianCalendar date = new GregorianCalendar();
	private JLabel jLabel4 = null;
	private JLabel jLabel41 = null;
	private JTextPane jTextPaneDnDOff = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private JLabel jLabelMore = null;
	private JLabel jLabel6 = null;
	private JTextPane jTextPaneDate = null;
	// private JTextPane txtpnSaas;
	private JLabel jLabelAnnouncementImage = null;
	private JLabel txtpnAnnouncement;
	private int j = 0;
	private int count = 0;
	private JLabel labelBack;
	private JLabel labelNext;
	private String title;
	private String image = null;
	private String details = null;
	private Timer timer1 = null;
	private String type = null;
	private ActionListener timerListener1 = null;
	private ArrayList<Announcement> announcementArr = new ArrayList<Announcement>();
	boolean doNotDisturb = false;
	JFrame frame = null;
	private String loginUsername;
	private String updateDND;
	private int checkDND;
	private String macAddress;
	private int loginId;
	private String voucherName;
	private int alarmHour;
	private int alarmMinute;
	private double extraCharges = 0;
	private String checkOut = "";
	private int stays;

	/**
	 * This is the default constructor
	 */
	public RoomHomePagePanel() {
		super();
		initialize();
	}

	public RoomHomePagePanel(JFrame f) {
		this();
		myFrame = f;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	private void initialize() {
		Date date = new Date();
		Date currentDate = date;
		CustomerVouchers customerVouchers = CustomerVouchersDAO
				.searchById(MainFrame.getPersonWhoLogin().getId());
		if (customerVouchers != null) {
			voucherName = customerVouchers.getTitle();
			String expiryDateString = customerVouchers.getExpiryDate();
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd MMM yyyy");
			Date expiryDate = null;
			try {
				if (expiryDateString != null) {
					expiryDate = dateFormat.parse(expiryDateString);
					if (currentDate.after(expiryDate)) {
						try {
							CustomerVouchersDAO.deleteVoucher(customerVouchers
									.getExpiryDate());
							int option = JOptionPane.showConfirmDialog(myFrame,
									"Your voucher(s) " + voucherName
											+ " has expired", "Confirmation",
									JOptionPane.PLAIN_MESSAGE);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			} catch (ParseException e3) {
			}

		}
		simplytech.entity.AlarmClock alarm = AlarmClockDAO.searchById(MainFrame
				.getPersonWhoLogin().getId());
		if (alarm != null){
			alarmHour = alarm.getHour();
			alarmMinute = alarm.getMinute();
		}
		extraCharges = MainFrame.getPersonWhoLogin().getExtraCharges();
		int points = MainFrame.getPersonWhoLogin().getPoints();
		String membership = MainFrame.getPersonWhoLogin().getMembership();
		System.out.println(">>>" + membership);
		AccommodationsEntity accommodation = AccommodationsDAO.searchById(MainFrame.getPersonWhoLogin().getId()+"");
		if (accommodation != null){
			checkOut = accommodation.getAccoCheckOut();
			stays = accommodation.getAccoDay();
		}
		checkDND = MainFrame.getPersonWhoLogin().getDoNotDisturb();
		if (checkDND == 1) {
			updateDND = "ON";
		} else {
			updateDND = "OFF";
		}
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(405, 24, 176, 52));
		jLabel6.setFont(new Font("Agency FB", Font.BOLD, 48));
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				jTextPaneDate.setVisible(true);
			}
		});

		add(jLabel6);

		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String time = timeFormat.format(date);
				jLabel6.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		// to make sure it doesn't wait one second at the start
		timer.setInitialDelay(0);
		timer.start();

		jLabelMore = new JLabel();
		jLabelMore.setBounds(new Rectangle(600, 337, 38, 18));
		jLabelMore.setForeground(new Color(15, 85, 255));
		jLabelMore.setText("More...");
		jLabelMore.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new ContactPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel41 = new JLabel();
		jLabel41.setBounds(new Rectangle(589, 285, 436, 38));
		jLabel41.setText("");
		jLabel41.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Hotlines.png")));
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(587, 21, 459, 50));
		jLabel4.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Announcements.png")));
		jLabel4.setText("");
		jLabelCheckOut = new JLabel();
		jLabelCheckOut.setBounds(new Rectangle(12, 7, 71, 33));
		jLabelCheckOut.setFont(new Font("Calibri", Font.BOLD, 14));
		jLabelCheckOut.setForeground(new Color(221, 51, 51));
		jLabelCheckOut.setText("Logout");
		jLabelCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				MainFrame.setPersonWhoLogin(null);
				frame.setVisible(false);
				JPanel panel = new RoomLoginPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new RoomLoginPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		if (frame == null) {
			frame = new JFrame("Do Not Disturb");
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setLocationByPlatform(true);
			frame.setSize(500, 100);
			frame.setVisible(true);
			frame.setLocation(1000, 300);
		}
		frame.getContentPane().setLayout(null);
		if (checkDND == 1) {
			frame.getContentPane().setBackground(Color.RED);
		} else {
			frame.getContentPane().setBackground(Color.WHITE);
		}

		JLabel label = new JLabel("Do Not Disturb");
		label.setBounds(133, 15, 350, 34);
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		label.setBackground(Color.RED);
		frame.getContentPane().add(label);
		jLabel31 = new JLabel();
		jLabel31.setText("so we can serve you better.");
		jLabel31.setLocation(new Point(76, 512));
		jLabel31.setSize(new Dimension(213, 29));
		jLabel31.setFont(new Font("Calibri", Font.PLAIN, 14));
		jLabel31.setVisible(false);
		jLabelFeedback = new JLabel();
		jLabelFeedback.setText("feedback");
		jLabelFeedback.setLocation(new Point(293, 491));
		jLabelFeedback.setSize(new Dimension(213, 29));
		jLabelFeedback.setForeground(new Color(51, 51, 165));
		jLabelFeedback.setFont(new Font("Calibri", Font.PLAIN, 14));
		jLabelFeedback.setVisible(false);
		jLabelFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				frame.setVisible(false);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(77, 491, 217, 29));
		jLabel3.setFont(new Font("Calibri", Font.PLAIN, 14));
		jLabel3.setText("Like our services? Provide us with your");
		jLabel3.setVisible(false);
		jLabelNameAlarm = new JLabel();
		jLabelNameAlarm.setText(alarmHour + ":" + alarmMinute);
		jLabelNameAlarm.setSize(new Dimension(86, 23));
		jLabelNameAlarm.setLocation(new Point(219, 340));
		jLabelNameAlarm.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelNamePoints = new JLabel();
		jLabelNamePoints.setText(points + "");
		jLabelNamePoints.setSize(new Dimension(86, 23));
		jLabelNamePoints.setLocation(new Point(219, 270));
		jLabelNamePoints.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelNameCheckOutTime = new JLabel();
		jLabelNameCheckOutTime.setBounds(new Rectangle(308, 200, 65, 23));
		jLabelNameCheckOutTime.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabelNameCheckOutDate = new JLabel();
		jLabelNameCheckOutDate.setText(checkOut);
		jLabelNameCheckOutDate.setSize(new Dimension(235, 23));
		jLabelNameCheckOutDate.setLocation(new Point(219, 200));
		jLabelNameCheckOutDate.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelNameMembership = new JLabel();
		jLabelNameMembership.setText(membership);
		jLabelNameMembership.setSize(new Dimension(100, 23));
		jLabelNameMembership.setLocation(new Point(219, 130));
		jLabelNameMembership.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelName1 = new JLabel();
		jLabelName1.setText("$");
		jLabelName1.setSize(new Dimension(46, 23));
		jLabelName1.setLocation(new Point(19, 270));
		jLabelName1.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabelNameExtraCharges = new JLabel();
		jLabelNameExtraCharges.setText(extraCharges + "0");
		jLabelNameExtraCharges.setSize(new Dimension(95, 23));
		jLabelNameExtraCharges.setLocation(new Point(61, 270));
		jLabelNameExtraCharges.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelNameStay = new JLabel();
		jLabelNameStay.setText(stays + " days");
		jLabelNameStay.setSize(new Dimension(86, 23));
		jLabelNameStay.setLocation(new Point(19, 200));
		jLabelNameStay.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelName = new JLabel();
		jLabelName.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabelName.setSize(new Dimension(132, 18));
		jLabelName.setLocation(new Point(19, 130));
		jLabelName.setText(MainFrame.getPersonWhoLogin().getName());
		jLabel2111 = new JLabel();
		jLabel2111.setPreferredSize(new Dimension(55, 24));
		jLabel2111.setText("Alarm:");
		jLabel2111.setSize(new Dimension(118, 20));
		jLabel2111.setLocation(new Point(219, 310));
		jLabel2111.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel211 = new JLabel();
		jLabel211.setPreferredSize(new Dimension(55, 24));
		jLabel211.setText("Points:");
		jLabel211.setSize(new Dimension(95, 20));
		jLabel211.setLocation(new Point(219, 240));
		jLabel211.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel21 = new JLabel();
		jLabel21.setPreferredSize(new Dimension(55, 24));
		jLabel21.setText("Check Out:");
		jLabel21.setSize(new Dimension(149, 20));
		jLabel21.setLocation(new Point(219, 170));
		jLabel21.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel2 = new JLabel();
		jLabel2.setPreferredSize(new Dimension(55, 24));
		jLabel2.setText("Membership:");
		jLabel2.setSize(new Dimension(118, 20));
		jLabel2.setLocation(new Point(219, 100));
		jLabel2.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel111 = new JLabel();
		jLabel111.setText("Do Not Disturb:");
		jLabel111.setSize(new Dimension(172, 20));
		jLabel111.setLocation(new Point(19, 310));
		jLabel111.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel11 = new JLabel();
		jLabel11.setText("Extra Charges:");
		jLabel11.setSize(new Dimension(129, 20));
		jLabel11.setLocation(new Point(19, 240));
		jLabel11.setPreferredSize(new Dimension(120, 18));
		jLabel11.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel1 = new JLabel();
		jLabel1.setText("Stay:");
		jLabel1.setSize(new Dimension(55, 20));
		jLabel1.setLocation(new Point(19, 170));
		jLabel1.setPreferredSize(new Dimension(55, 24));
		jLabel1.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel = new JLabel();
		jLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabel.setSize(new Dimension(77, 20));
		jLabel.setLocation(new Point(19, 100));
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Name:");
		jLabelMyAccount = new JLabel();
		jLabelMyAccount.setBounds(new Rectangle(3, 68, 121, 18));
		jLabelMyAccount.setFont(new Font("Calibri", Font.BOLD, 16));
		jLabelMyAccount.setForeground(new Color(51, 51, 162));
		jLabelMyAccount.setText("My Account");
		jLabelMyAccount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				frame.setVisible(false);
				JPanel panel = new MyAccountsPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelAnnouncementImage = new JLabel();
		jLabelAnnouncementImage.setBounds(634, 82, 203, 149);

		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane(), null);
		this.add(jLabelMyAccount, null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel111, null);
		this.add(jLabel2, null);
		this.add(jLabel21, null);
		this.add(jLabel211, null);
		this.add(jLabel2111, null);
		this.add(jLabelName, null);
		this.add(jLabelNameStay, null);
		this.add(jLabelNameExtraCharges, null);
		this.add(jLabelName1, null);
		this.add(getJTextPaneOff(), null);
		this.add(getJTextPaneDoNotDisturb(), null);
		this.add(jLabelNameMembership, null);
		this.add(jLabelNameCheckOutDate, null);
		this.add(jLabelNameCheckOutTime, null);
		this.add(jLabelNamePoints, null);
		this.add(jLabelNameAlarm, null);
		this.add(getJButtonServices(), null);
		this.add(getJButtonAttractions(), null);
		this.add(jLabel3, null);
		this.add(jLabelFeedback, null);
		this.add(jLabel31, null);
		this.add(jLabelCheckOut, null);
		this.add(jLabel4, null);
		this.add(jLabel41, null);
		this.add(getJTextPaneDnDOff(), null);
		this.add(getJScrollPane(), null);
		this.add(jLabelMore, null);
		this.add(getJTextPaneDate(), null);
		this.add(jLabel6, null);
		this.add(jLabelAnnouncementImage);
		try {
			this.add(getTxtpnAnnouncement());
			add(getLabelBack());
			add(getLabelNext());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 54));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPaneOff
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneOff() {
		if (jTextPaneOff == null) {
			jTextPaneOff = new JTextPane();
			jTextPaneOff.setBackground(new Color(237, 125, 49));
			jTextPaneOff.setLocation(new Point(128, 340));
			jTextPaneOff.setSize(new Dimension(17, 24));
			jTextPaneOff.setEditable(false);
			jTextPaneOff.setBounds(new Rectangle(125, 340, 20, 24));
		}
		return jTextPaneOff;
	}

	/**
	 * This method initializes jTextPaneDoNotDisturb
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDoNotDisturb() {
		if (jTextPaneDoNotDisturb == null) {
			jTextPaneDoNotDisturb = new JTextPane();
			jTextPaneDoNotDisturb.setBackground(new Color(91, 155, 213));
			jTextPaneDoNotDisturb.setLocation(new Point(96, 340));
			jTextPaneDoNotDisturb.setEditable(false);
			jTextPaneDoNotDisturb.setSize(new Dimension(49, 24));
			jTextPaneDoNotDisturb
					.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							if (checkDND == 1) {
								jTextPaneDnDOff.setText("ON");
								doNotDisturb = true;
								jTextPaneOff.setLocation(new Point(96, 340));
								checkDND = 0;
							} else {
								jTextPaneDnDOff.setText("OFF");
								jTextPaneOff.setLocation(new Point(128, 340));
								doNotDisturb = false;
								checkDND = 1;
							}
							frame.getContentPane().removeAll();
							frame.getContentPane().validate();
							frame.getContentPane().repaint();
							frame.invalidate();
							frame.validate();
							frame.repaint();
							int dnd;

							if (doNotDisturb == true) {
								frame.getContentPane().setBackground(Color.RED);
								dnd = 1;
							} else {
								frame.getContentPane().setBackground(
										Color.WHITE);
								dnd = 0;
							}
							try {
								CustomerDAO.updateDND(dnd, loginId);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							JLabel label = new JLabel("Do Not Disturb");
							label.setBounds(133, 15, 350, 34);
							label.setFont(new Font("Calibri", Font.BOLD, 30));
							label.setBackground(Color.RED);
							frame.getContentPane().add(label);
						}
					});
		}
		return jTextPaneDoNotDisturb;
	}

	/**
	 * This method initializes jButtonServices
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonServices() {
		if (jButtonServices == null) {
			jButtonServices = new JButton();
			jButtonServices.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonServices.setForeground(Color.white);
			jButtonServices.setText("Services");
			jButtonServices.setLocation(new Point(111, 434));
			jButtonServices.setSize(new Dimension(131, 67));
			jButtonServices.setBackground(new Color(91, 155, 213));
			jButtonServices
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							frame.setVisible(false);
							JPanel panel = new Services(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonServices;
	}

	/**
	 * This method initializes jButtonAttractions
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAttractions() {
		if (jButtonAttractions == null) {
			jButtonAttractions = new JButton();
			jButtonAttractions.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonAttractions.setForeground(Color.white);
			jButtonAttractions.setText("Attractions");
			jButtonAttractions.setLocation(new Point(265, 434));
			jButtonAttractions.setSize(new Dimension(131, 67));
			jButtonAttractions.setBackground(new Color(91, 155, 213));
			jButtonAttractions
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							frame.setVisible(false);
							JPanel panel = new Attractions(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonAttractions;
	}

	/**
	 * This method initializes jTextPaneDnDOff
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDnDOff() {
		if (jTextPaneDnDOff == null) {
			jTextPaneDnDOff = new JTextPane();
			jTextPaneDnDOff.setBounds(new Rectangle(18, 335, 53, 34));
			jTextPaneDnDOff.setName("");
			jTextPaneDnDOff.setText(updateDND);
			jTextPaneDnDOff.setEditable(false);
			jTextPaneDnDOff.setBackground(new Color(227, 228, 250));
			jTextPaneDnDOff.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return jTextPaneDnDOff;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setSize(new Dimension(381, 188));
			jScrollPane.setViewportView(getJTable1());
			jScrollPane.setLocation(new Point(600, 360));
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			Object rowData[][] = { { "Comfort", "6123 4567", "Ms Low" },
					{ "Pime", "6234 5678", "Mr Ong" },
					{ "SMRT", "6457 8962", "Mr Tan" },
					{ "CityCab", "6552 1111", "Mdm Ong" },
					{ "Smart Cab", "6485 7777", "Ms Ng" },
					{ "TransCab", "6555 3333", "Ms Tan" },
					{ "Premier Cab", "6363 6888", "Mdm Tan" }, };
			Object columnNames[] = { "Company", "Number", "Name" };
			jTable1 = new JTable(rowData, columnNames);
			jTable1.setBackground(new Color(91, 155, 213));
			jTable1.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTable1.setIntercellSpacing(new Dimension(1, 1));
			jTable1.setRowHeight(30);
			jTable1.setShowVerticalLines(true);
			jTable1.setShowHorizontalLines(true);
			jTable1.setForeground(Color.white);
		}
		return jTable1;
	}

	/**
	 * This method initializes jTextPaneDate
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDate() {
		if (jTextPaneDate == null) {
			jTextPaneDate = new JTextPane();
			jTextPaneDate.setBounds(new Rectangle(392, 71, 183, 56));
			jTextPaneDate.setBackground(new Color(227, 228, 250));
			jTextPaneDate.setFont(new Font("Calibri", Font.PLAIN, 30));
			jTextPaneDate.setVisible(true);
			add(jTextPaneDate);

			final DateFormat timeFormat = new SimpleDateFormat("dd MMM yyyy");
			ActionListener timerListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date date = new Date();
					String time = timeFormat.format(date);
					jTextPaneDate.setText(time);
				}
			};
			Timer timer = new Timer(1000, timerListener);
			// to make sure it doesn't wait one second at the start
			timer.setInitialDelay(0);
			timer.start();
		}
		return jTextPaneDate;
	}

	private JLabel getTxtpnAnnouncement() throws SQLException {
		txtpnAnnouncement = new JLabel();
		txtpnAnnouncement.setBounds(847, 82, 139, 149);
		count = AnnouncementDAO.getCount("Customer");
		timerListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (j == count) {
					j = 0;
				}

				setAnnouncement(j);
				j++;

			}
		};
		timer1 = new Timer(3000, timerListener1);

		// to make sure it doesn't wait one second at the start
		timer1.setInitialDelay(0);
		timer1.start();
		return txtpnAnnouncement;
	}

	private JLabel getLabelBack() {
		if (labelBack == null) {
			labelBack = new JLabel("< Back");
			labelBack.setBounds(634, 244, 46, 14);
			labelBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					j = j - 1;
					if (j == -1) {
						j = count - 1;
					}
					setAnnouncement(j);
					timer1 = new Timer(3000, timerListener1);
				}
			});

		}
		return labelBack;
	}

	private JLabel getLabelNext() {
		if (labelNext == null) {
			labelNext = new JLabel("Next >");
			labelNext.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					j = j + 1;
					if (j == count) {
						j = 0;
					}
					setAnnouncement(j);
					timer1 = new Timer(3000, timerListener1);
				}
			});
			labelNext.setBounds(940, 244, 46, 14);
		}
		return labelNext;
	}

	public void setAnnouncement(int j) {
		announcementArr = AnnouncementDAO.retrieveAll("Customer");
		type = announcementArr.get(j).getType();
		title = announcementArr.get(j).getTitle();
		image = announcementArr.get(j).getImage();
		details = announcementArr.get(j).getDetails();
		if (type.equals("Customer")) {
			txtpnAnnouncement.setText("<html>\r\n<body>\r\n<h2>" + title
					+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>" + details
					+ "</p>\r\n</body>\r\n</html>");
			jLabelAnnouncementImage.setIcon(new ImageIcon(image));
		}
	}

}
