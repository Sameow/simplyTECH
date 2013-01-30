package simplytech.staff;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import simplytech.dao.AnnouncementDAO;
import simplytech.entity.Announcement;
import simplytech.entity.Person;


import java.awt.Point;
import java.awt.GridBagConstraints;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StaffMainPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButtonLogout = null;
	private JLabel jLabelHowMayIServeYou = null;
	private JLabel jLabelStaffMainPageBar = null;
	private JLabel jLabelAnnouncements = null;
	private JLabel jLabelBackGround = null;
	private JLabel jLabelGuests = null;
	private JScrollPane jScrollPaneGuests = null;
	private JLabel jLabelName = null;
	private JLabel jLabelName2 = null;
	private JLabel jLabelWorkingSince = null;
	private JLabel jLabelWorkingSince1 = null;
	private JLabel jLabelWorkingSince2;
	private JLabel jLabelPosition = null;
	private JLabel jLabelPosition2 = null;
	private JFrame myFrame=null;
	private JButton jButtonEditStaffAccount = null;
	private JPanel jPanelGuests = null;
	private JButton jButtonRow1 = null;
	private JButton jButtonRow2 = null;
	private JButton jButtonRow3 = null;
	private JLabel jLabel6 = null;
	private JTextPane jTextPaneDate = null;
	private JLabel jLabelDate = null;
	private JLabel jLabelTimeDate = null;
	private JButton jBtnRedemption;
	private JButton jBtnEditAnnouncements;
	private JLabel jLabelAnnouncementImage = null;
	private JLabel txtpnAnnouncement = null;
	private JLabel labelNext = null;
	private JLabel labelBack = null;
	private int count = 0;
	private ActionListener timerListener1 = null;
	private ArrayList<Announcement> announcementArr = new ArrayList<Announcement>();
	private int j = 0;
	private Timer timer1 = null;
	private String title;
	private String image;
	private String details;
	private String type;
	private JButton jBtnEditVouchers;


	public StaffMainPage(JFrame f) {
		myFrame=f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	private void initialize() {
		
		jLabelTimeDate = new JLabel();
		jLabelTimeDate.setBounds(new Rectangle(240, 90, 68, 38));
		jLabelTimeDate.setText("Time/Date:");
		jLabelDate = new JLabel();
		jLabelDate.setSize(new Dimension(125, 25));
		jLabelDate.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelDate.setLocation(new Point(422, 95));
	
		add(jLabelDate);
		
		final DateFormat timeFormat1 = new SimpleDateFormat("dd MMM yyyy"); 
		ActionListener timerListener1 = new ActionListener() 
		{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		Date date = new Date(); 
		String time = timeFormat1.format(date); 
		jLabelDate.setText(time); 
		} 
		}; 
		Timer timer1 = new Timer(1000, timerListener1); 
		// to make sure it doesn't wait one second at the start 
		timer1.setInitialDelay(0); 
		timer1.start(); 
		
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(314, 95, 98, 27));
		//jLabel6.setText("JLabel");
		jLabel6.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabel6.setText("");
		add(jLabel6); 

		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
		ActionListener timerListener = new ActionListener() 
		{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		Date date = new Date(); 
		String time = timeFormat.format(date); 
		jLabel6.setText(time); 
		} 
		}; 
		Timer timer = new Timer(1000, timerListener); 
		// to make sure it doesn't wait one second at the start 
		timer.setInitialDelay(0); 
		timer.start(); 
		
		jLabelPosition2 = new JLabel();
		jLabelPosition2.setBounds(new Rectangle(30, 317, 212, 34));
		jLabelPosition2.setFont(new Font("Dialog", Font.PLAIN, 24));
		jLabelPosition2.setText(MainFrame.getPersonWhoLogin().getPosition());
		jLabelPosition = new JLabel();
		jLabelPosition.setBounds(new Rectangle(31, 271, 209, 31));
		jLabelPosition.setFont(new Font("Dialog", Font.BOLD, 24));
		jLabelPosition.setText("Position:");
		jLabelWorkingSince2 = new JLabel();
		jLabelWorkingSince2.setBounds(new Rectangle(31, 226, 210, 29));
		jLabelWorkingSince2.setFont(new Font("Dialog", Font.PLAIN, 24));
		jLabelWorkingSince2.setText(MainFrame.getPersonWhoLogin().getWorkingSince());
		jLabelWorkingSince = new JLabel();
		jLabelWorkingSince.setBounds(new Rectangle(30, 181, 211, 29));
		jLabelWorkingSince.setFont(new Font("Dialog", Font.BOLD, 24));
		jLabelWorkingSince.setText("Working Since:");
		jLabelName2 = new JLabel();
		jLabelName2.setBounds(new Rectangle(32, 137, 210, 28));
		jLabelName2.setFont(new Font("Dialog", Font.PLAIN, 24));
		jLabelName2.setText(MainFrame.getPersonWhoLogin().getName());
		jLabelName = new JLabel();
		jLabelName.setBounds(new Rectangle(31, 92, 85, 28));
		jLabelName.setFont(new Font("Dialog", Font.BOLD, 24));
		jLabelName.setText("Name:");
		jLabelGuests = new JLabel();
		jLabelGuests.setBounds(new Rectangle(481, 319, 533, 38));
		jLabelGuests.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelGuests.setBackground(new Color(91, 155, 213));
		jLabelGuests.setText("Guests");
		jLabelGuests.setOpaque(true);
		jLabelAnnouncementImage = new JLabel();
		jLabelAnnouncementImage.setBounds(608, 83, 203, 149);
		jLabelAnnouncements = new JLabel();
		jLabelAnnouncements.setBounds(new Rectangle(482, 15, 524, 32));
		jLabelAnnouncements.setBackground(new Color(91, 155, 213));
		jLabelAnnouncements.setFont(new Font("Dialog", Font.BOLD, 18));
		jLabelAnnouncements.setForeground(Color.black);
		jLabelAnnouncements.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabelAnnouncements.setText("ANNOUNCEMENTS");
		jLabelAnnouncements.setOpaque(true);
		jLabelStaffMainPageBar = new JLabel();
		jLabelStaffMainPageBar.setBounds(new Rectangle(9, 58, 309, 13));
		jLabelStaffMainPageBar.setIcon(new ImageIcon(getClass().getResource("/simplytech/image/Rectangle.png")));
		jLabelStaffMainPageBar.setText("JLabel");
		jLabelHowMayIServeYou = new JLabel();
		jLabelHowMayIServeYou.setBounds(new Rectangle(121, 16, 196, 31));
		jLabelHowMayIServeYou.setText("How may I serve you?");
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		this.add(getJButtonLogout(), null);
		this.add(jLabelHowMayIServeYou, null);
		this.add(jLabelStaffMainPageBar, null);
		this.add(jLabelAnnouncements, null);
		this.add(jLabelGuests, null);
		this.add(getJScrollPaneGuests(), null);
		this.add(jLabelName, null);
		this.add(jLabelName2, null);
		this.add(jLabelWorkingSince, null);
		this.add(jLabelWorkingSince2, null);
		this.add(jLabelPosition, null);
		this.add(jLabelPosition2, null);
		this.add(getJButtonEditStaffAccount(), null);
		this.add(jLabelTimeDate, null);
		this.add(jLabelDate, null);
		this.add(jLabel6, null);
		this.add(getLabelBack());
		this.add(jLabelAnnouncementImage, null);
		this.add(getLabelNext());
		try {
			this.add(getTxtpnAnnouncement());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.add(getJBtnRedemption());
		this.add(getJBtnEditAnnouncements());
		this.add(getJBtnEditVouchers());
		
	}

	/**
	 * This method initializes jButtonLogout	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLogout() {
		if (jButtonLogout == null) {
			jButtonLogout = new JButton();
			jButtonLogout.setBounds(new Rectangle(0, 3, 104, 46));
			jButtonLogout.setFont(new Font("Dialog", Font.BOLD, 18));
			jButtonLogout.setText("Logout");
			jButtonLogout.setForeground(Color.white);
			jButtonLogout.setBackground(new Color(91, 155, 213));
			jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainFrame.setPersonWhoLogin(null);
					JPanel panel=new WelcomePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonLogout;
	}

	/**
	 * This method initializes jScrollPaneGuests	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneGuests() {
		if (jScrollPaneGuests == null) {
			jScrollPaneGuests = new JScrollPane();
			jScrollPaneGuests.setBounds(new Rectangle(512, 366, 489, 179));
			jScrollPaneGuests.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPaneGuests.setViewportView(getJPanelGuests());
			jScrollPaneGuests.setViewportBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jScrollPaneGuests.setOpaque(true);
		}
		return jScrollPaneGuests;
	}

	
	/**
	 * This method initializes jButtonEditStaffAccount	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEditStaffAccount() {
		if (jButtonEditStaffAccount == null) {
			jButtonEditStaffAccount = new JButton();
			jButtonEditStaffAccount.setFont(new Font("Dialog", Font.BOLD, 12));
			jButtonEditStaffAccount.setForeground(Color.white);
			jButtonEditStaffAccount.setText("Edit Staff Account");
			jButtonEditStaffAccount.setLocation(new Point(87, 421));
			jButtonEditStaffAccount.setSize(new Dimension(138, 53));
			jButtonEditStaffAccount.setActionCommand("");
			jButtonEditStaffAccount.setBackground(new Color(91, 155, 213));
			jButtonEditStaffAccount
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JPanel panel = new EditStaffAccount(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonEditStaffAccount;
	}
	/**
	 * This method initializes jPanelGuests	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelGuests() {
		if (jPanelGuests == null) {
			jPanelGuests = new JPanel();
			jPanelGuests.setLayout(null);
			jPanelGuests.setPreferredSize(new Dimension(460, 240));
			jPanelGuests.add(getJButtonRow1(), null);
			jPanelGuests.add(getJButtonRow2(), null);
			jPanelGuests.add(getJButtonRow3(), null);
		}
		return jPanelGuests;
	}

	/**
	 * This method initializes jButtonRow1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRow1() {
		if (jButtonRow1 == null) {
			jButtonRow1 = new JButton();
			jButtonRow1.setLocation(new Point(5, 5));
			jButtonRow1.setBackground(new Color(210, 222, 239));
			jButtonRow1.setText("Room 1 Mr Ong");
			jButtonRow1.setFont(new Font("Dialog", Font.BOLD, 36));
			jButtonRow1.setSize(new Dimension(460, 80));
			jButtonRow1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel=new EditingGuestAccount(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonRow1;
	}

	/**
	 * This method initializes jButtonRow2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRow2() {
		if (jButtonRow2 == null) {
			jButtonRow2 = new JButton();
			jButtonRow2.setLocation(new Point(5, 82));
			jButtonRow2.setText("Room 2 Mr Li");
			jButtonRow2.setBackground(new Color(210, 222, 239));
			jButtonRow2.setFont(new Font("Dialog", Font.BOLD, 36));
			jButtonRow2.setSize(new Dimension(460, 80));
		}
		return jButtonRow2;
	}

	/**
	 * This method initializes jButtonRow3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRow3() {
		if (jButtonRow3 == null) {
			jButtonRow3 = new JButton();
			jButtonRow3.setLocation(new Point(5, 162));
			jButtonRow3.setBackground(new Color(210, 222, 239));
			jButtonRow3.setFont(new Font("Dialog", Font.BOLD, 36));
			jButtonRow3.setText("Room 3 Mr Lim");
			jButtonRow3.setSize(new Dimension(460, 80));
		}
		return jButtonRow3;
	}

	public void setAnnouncement(int j) {
		announcementArr = AnnouncementDAO.retrieveAll("Staff");
		type = announcementArr.get(j).getType();
		title = announcementArr.get(j).getTitle();
		image = announcementArr.get(j).getImage();
		details = announcementArr.get(j).getDetails();
		if (type.equals("Staff")) {
			txtpnAnnouncement.setText("<html>\r\n<body>\r\n<h2>" + title
					+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>" + details
					+ "</p>\r\n</body>\r\n</html>");
			jLabelAnnouncementImage.setIcon(new ImageIcon(image));
		}
	}

	private JButton getJBtnEditVouchers() {
		if (jBtnEditVouchers == null) {
			jBtnEditVouchers = new JButton("Edit Vouchers");
			jBtnEditVouchers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JPanel panel = new EditVouchers(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();

				}
			});
			jBtnEditVouchers.setForeground(Color.WHITE);
			jBtnEditVouchers.setFont(new Font("Dialog", Font.BOLD, 14));
			jBtnEditVouchers.setBackground(new Color(91, 155, 213));
			jBtnEditVouchers.setBounds(87, 487, 138, 55);
		}
		return jBtnEditVouchers;
	}
	
	private JLabel getLabelBack() {
		if (labelBack == null) {
			labelBack = new JLabel("< Back");
			labelBack.setBounds(608, 245, 46, 14);
			labelBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					j = j - 1;
					if (j == -1) {
						j = count - 1;
					}
					setAnnouncement(j);
					// System.out.println(j + "Pressed");
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
			labelNext.setBounds(914, 245, 46, 14);
		}
		return labelNext;
	}
	
	private JLabel getTxtpnAnnouncement() throws SQLException {
		txtpnAnnouncement = new JLabel();
		txtpnAnnouncement.setBounds(821, 83, 139, 149);
		count = AnnouncementDAO.getCount("Staff");
		System.out.println("Count is " + count);
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
	
	private JButton getJBtnEditAnnouncements() {
		if (jBtnEditAnnouncements == null) {
			jBtnEditAnnouncements = new JButton("Edit Anncmnt");
			jBtnEditAnnouncements.setFont(new Font("Dialog", Font.BOLD, 14));
			jBtnEditAnnouncements.setForeground(Color.white);
			jBtnEditAnnouncements.setBackground(new Color(91, 155, 213));
			jBtnEditAnnouncements.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String personType = "";
					String[] options = new String[] { "Customer", "Staff",
							"Cancel" };
					int choice = JOptionPane.showOptionDialog(null,
							"Who's announcement to edit?",
							"Who's announcement to edit?",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options,
							options[0]);
					if (choice == JOptionPane.YES_OPTION) {
						personType = "Customer";
					}
					// else if (choice == JOptionPane.CANCEL_OPTION){
					else if (choice == JOptionPane.NO_OPTION) {
						personType = "Staff";
					}
					if (!(personType.equals(""))) {
						JPanel announcementPanel = new EditAnnouncementPanel(
								myFrame, personType);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(announcementPanel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}

				}
			});
			jBtnEditAnnouncements.setBounds(240, 487, 138, 53);
		}
		return jBtnEditAnnouncements;
	}
	
	private JButton getJBtnRedemption() {
		if (jBtnRedemption == null) {
			jBtnRedemption = new JButton("Redemption");
			jBtnRedemption.setBounds(240, 419, 138, 55);
			jBtnRedemption.setFont(new Font("Dialog", Font.BOLD, 14));
			jBtnRedemption.setForeground(Color.white);
			jBtnRedemption.setBackground(new Color(91, 155, 213));
			jBtnRedemption
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String str = JOptionPane.showInputDialog(null,
									"Enter the cutomer ID: ", 1);
							int customerId = 0;
							try {
								customerId = Integer.parseInt(str);
								JPanel panel = new UseVouchers(myFrame,
										customerId);
								myFrame.getContentPane().removeAll();
								myFrame.getContentPane().add(panel);
								myFrame.getContentPane().validate();
								myFrame.getContentPane().repaint();
							} catch (NumberFormatException nFE) {
								int option = JOptionPane.showConfirmDialog(
										myFrame, "Please enter integer!",
										"Confirmation",
										JOptionPane.PLAIN_MESSAGE);
							}
						}
					});
		}
		return jBtnRedemption;
	}
	
	}
	
