package simplytech.room;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import simplytech.components.MACAddress;
import simplytech.dao.PersonDAO;
import simplytech.entity.Person;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.SocketException;
import java.util.Calendar;

public class PointsRewardSystemPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JTextPane jTextPaneHotel = null;
	private JLabel jLabel1 = null;
	private JTextPane jTextPaneShopping = null;
	private JLabel jLabel2 = null;
	private JTextPane jTextPaneTravel = null;
	private JLabel jLabel3 = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelImage;
	private JLabel jLabelTitle;
	private JLabel jLabelImage2;
	private JLabel jLabelTitle2;
	private JTextPane jTextPaneDescription2 = null;
	private JLabel jTextPane_1;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPaneType = null;
	private JTextPane jTextPane211 = null;
	private JTextPane jTextPaneDescription = null;
	private String voucherType = null;
	private Calendar calendar;
	private long start;
	private long stop;
	private String previousPanel;

	/**
	 * This is the default constructor
	 */
	public PointsRewardSystemPanel2() {
		super();
		initialize();
	}

	public PointsRewardSystemPanel2(JFrame f, String previousPanel) {
		this.previousPanel = previousPanel;
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
		jLabelBack.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start = calendar.getInstance().getTimeInMillis();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				stop = calendar.getInstance().getTimeInMillis();
				if (stop - start < 500) {
					if (previousPanel.equals("Services")) {
						JPanel panel = new Services(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					} else {
						JPanel panel = new MyAccountsPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}

				} else {
					JPanel panel = new RoomHomePagePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			}
		});

		jTextPane_1 = new JLabel();
		jTextPane_1.setText("");
		jTextPane_1.setLocation(new Point(570, 314));
		jTextPane_1.setSize(new Dimension(317, 123));
		jTextPane_1.setBackground(new Color(227, 228, 250));
		jTextPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				voucherType = jLabelTitle2.getText();
				JPanel panel = new RedemptionPanel(myFrame, voucherType);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelTitle2 = new JLabel();
		jLabelTitle2.setText("Free Stays");
		jLabelTitle2.setSize(new Dimension(184, 37));
		jLabelTitle2.setLocation(new Point(695, 325));
		jLabelTitle2.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabelImage2 = new JLabel();
		jLabelImage2.setText("");
		jLabelImage2.setSize(new Dimension(110, 105));
		jLabelImage2.setLocation(new Point(574, 320));
		jLabelImage2.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Pic6.png")));
		jLabelTitle = new JLabel();
		jLabelTitle.setBounds(new Rectangle(689, 181, 293, 44));
		jLabelTitle.setText("Food Vouchers");
		jLabelTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabelImage = new JLabel();
		jLabelImage.setBounds(new Rectangle(574, 180, 107, 101));
		jLabelImage.setText("");
		jLabelImage.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/FoodVoucherLunchBig.png")));
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(34, 99, 228, 40));
		jLabel4.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel4.setText("Your points: "
				+ MainFrame.getPersonWhoLogin().getPoints());
		jLabel3 = new JLabel();
		jLabel3.setText("");
		jLabel3.setSize(new Dimension(79, 79));
		jLabel3.setLocation(new Point(150, 435));
		jLabel3.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Pic3.png")));
		jLabel2 = new JLabel();
		jLabel2.setText("");
		jLabel2.setSize(new Dimension(79, 79));
		jLabel2.setLocation(new Point(149, 300));
		jLabel2.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Pic2.png")));
		jLabel1 = new JLabel();
		jLabel1.setText("");
		jLabel1.setSize(new Dimension(82, 80));
		jLabel1.setLocation(new Point(149, 165));
		jLabel1.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Pic1.png")));
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Points Reward System");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(345, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane(), null);
		this.add(jLabel, null);
		this.add(getJTextPaneHotel(), null);
		this.add(jLabel1, null);
		this.add(getJTextPaneShopping(), null);
		this.add(jLabel2, null);
		this.add(getJTextPaneTravel(), null);
		this.add(jLabel3, null);
		this.add(getJTextPane1(), null);
		this.add(jLabel4, null);
		this.add(jLabelImage, null);
		this.add(jLabelTitle, null);
		this.add(jLabelImage2, null);
		this.add(jLabelTitle2, null);
		this.add(getJTextPaneDescription2(), null);
		this.add(jTextPane_1, null);
		this.add(jLabelBack, null);
		this.add(getJTextPaneType(), null);
		this.add(getJTextPane211(), null);
		this.add(getJTextPaneDescription(), null);
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				voucherType = jLabelTitle.getText();
				JPanel panel = new RedemptionPanel(myFrame, voucherType);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		textPane.setBackground(new Color(227, 228, 250));
		textPane.setBounds(557, 163, 330, 128);
		// this.add(textPane);
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
			jTextPane.setLocation(new Point(0, 78));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPaneHotel
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneHotel() {
		if (jTextPaneHotel == null) {
			jTextPaneHotel = new JTextPane();
			jTextPaneHotel.setFont(new Font("Calibri", Font.PLAIN, 20));
			jTextPaneHotel.setForeground(Color.white);
			jTextPaneHotel.setText("Hotel");
			jTextPaneHotel.setEditable(false);
			jTextPaneHotel.setSize(new Dimension(159, 79));
			jTextPaneHotel.setLocation(new Point(228, 166));
			jTextPaneHotel.setBackground(new Color(31, 78, 121));
			jTextPaneHotel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextPaneShopping.setBackground(new Color(91, 155, 213));
					jTextPaneHotel.setBackground(new Color(31, 78, 121));
					jTextPaneTravel.setBackground(new Color(91, 155, 213));
					jTextPaneType.setText("Hotel");
					jLabelTitle.setText("Food vouchers");
					jTextPaneDescription
							.setText("Enjoy up to 50% off dining Vouchers!");
					jLabelImage.setIcon(new ImageIcon(getClass().getResource(
							"/simplyTECH/image/FoodVoucherLunchBig.png")));

					jLabelTitle2.setText("Free stays");
					jTextPaneDescription2
							.setText("Enjoy up to 3 days of free stays!");
					jLabelImage2.setIcon(new ImageIcon(getClass().getResource(
							"/simplyTECH/image/Pic6.png")));

				}
			});
			jTextPaneHotel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jTextPaneHotel;
	}

	/**
	 * This method initializes jTextPaneShopping
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneShopping() {
		if (jTextPaneShopping == null) {
			jTextPaneShopping = new JTextPane();
			jTextPaneShopping.setFont(new Font("Calibri", Font.PLAIN, 20));
			jTextPaneShopping.setForeground(Color.white);
			jTextPaneShopping.setText("Shopping");
			jTextPaneShopping.setEditable(false);
			jTextPaneShopping.setLocation(new Point(228, 300));
			jTextPaneShopping.setSize(new Dimension(159, 79));
			jTextPaneShopping.setBackground(new Color(91, 155, 213));
			jTextPaneShopping
					.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextPaneHotel
									.setBackground(new Color(91, 155, 213));
							jTextPaneShopping.setBackground(new Color(31, 78,
									121));
							jTextPaneTravel.setBackground(new Color(91, 155,
									213));

							jTextPaneType.setText("Shopping");
							jLabelTitle.setText("Shopping Vouchers");
							jTextPaneDescription
									.setText("Enjoy additional 5% off your purchase!");
							jLabelImage
									.setIcon(new ImageIcon(
											getClass()
													.getResource(
															"/simplyTECH/image/bags.png")));

							jLabelTitle2.setText("");
							jTextPaneDescription2.setText("");
							jLabelImage2.setIcon(new ImageIcon(getClass()
									.getResource("")));

						}
					});
			jTextPaneShopping
					.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
						}
					});
		}
		return jTextPaneShopping;
	}

	/**
	 * This method initializes jTextPaneTravel
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneTravel() {
		if (jTextPaneTravel == null) {
			jTextPaneTravel = new JTextPane();
			jTextPaneTravel.setFont(new Font("Calibri", Font.PLAIN, 20));
			jTextPaneTravel.setForeground(Color.white);
			jTextPaneTravel.setText("Recreation");
			jTextPaneTravel.setEditable(false);
			jTextPaneTravel.setLocation(new Point(228, 435));
			jTextPaneTravel.setSize(new Dimension(159, 79));
			jTextPaneTravel.setBackground(new Color(91, 155, 213));
			jTextPaneTravel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextPaneHotel.setBackground(new Color(91, 155, 213));
					jTextPaneTravel.setBackground(new Color(31, 78, 121));
					jTextPaneShopping.setBackground(new Color(91, 155, 213));
					jTextPaneType.setText("Travel");
					jLabelTitle.setText("Recreation");
					jTextPaneDescription
							.setText("Enjoy an additional free ticket when you purchase 2 tickets");
					jLabelImage.setIcon(new ImageIcon(getClass().getResource(
							"/simplyTECH/image/zoo.png")));
					jLabelTitle2.setText("");
					jTextPaneDescription2.setText("");
					jLabelImage2.setIcon(new ImageIcon(getClass().getResource(
							"")));

				}
			});
		}
		return jTextPaneTravel;
	}

	/**
	 * This method initializes jTextPane1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setBackground(new Color(91, 155, 213));
			jTextPane1.setSize(new Dimension(4, 351));
			jTextPane1.setLocation(new Point(458, 155));
		}
		return jTextPane1;
	}

	/**
	 * This method initializes jTextPaneDescription6
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDescription2() {
		if (jTextPaneDescription2 == null) {
			jTextPaneDescription2 = new JTextPane();
			jTextPaneDescription2.setEditable(false);
			jTextPaneDescription2.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription2.setText("Enjoy up to 3 days of free stays!");
			jTextPaneDescription2.setLocation(new Point(695, 380));
			jTextPaneDescription2.setSize(new Dimension(190, 63));
			jTextPaneDescription2.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneDescription2;
	}

	/**
	 * This method initializes jTextPane2
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneType() {
		if (jTextPaneType == null) {
			jTextPaneType = new JTextPane();
			jTextPaneType.setBounds(new Rectangle(572, 116, 261, 41));
			jTextPaneType.setText("Hotel");
			jTextPaneType.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPaneType.setEditable(false);
			jTextPaneType.setBackground(new Color(227, 228, 255));
		}
		return jTextPaneType;
	}

	/**
	 * This method initializes jTextPane211
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane211() {
		if (jTextPane211 == null) {
			jTextPane211 = new JTextPane();
			jTextPane211.setBounds(new Rectangle(570, 120, 121, 43));
			jTextPane211.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPane211.setText("Travel");
			jTextPane211.setEditable(false);
			jTextPane211.setBackground(new Color(227, 228, 255));
			jTextPane211.setVisible(false);
		}
		return jTextPane211;
	}

	/**
	 * This method initializes jTextPaneDescription61
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDescription() {
		if (jTextPaneDescription == null) {
			jTextPaneDescription = new JTextPane();
			jTextPaneDescription.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					voucherType = jLabelTitle.getText();
					JPanel panel = new RedemptionPanel(myFrame, voucherType);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jTextPaneDescription.setEditable(false);
			jTextPaneDescription.setBounds(new Rectangle(691, 236, 176, 45));
			jTextPaneDescription.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription
					.setText("Enjoy additional 5% off your purchase");
			jTextPaneDescription.setBackground(new Color(227, 228, 250));

		}
		return jTextPaneDescription;
	}
}
