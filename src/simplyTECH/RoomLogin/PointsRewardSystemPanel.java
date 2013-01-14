package simplyTECH.RoomLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.SocketException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JList;


import simplyTECH.Components.MACAddress;
import simplyTECH.dao.CheckLoginDAO;
import simplyTECH.dao.CustomerDetailsDAO;
import simplyTECH.entity.CheckLogin;
import simplyTECH.entity.CustomerDetails;

public class PointsRewardSystemPanel extends JPanel {


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
	private JLabel jLabel5 = null;
	private JLabel jLabelTitle5 = null;
	private JTextPane jTextPaneDescription5 = null;
	private JLabel jLabelButton5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabelTitle6 = null;
	private JTextPane jTextPaneDescription6 = null;
	private JLabel jLabelButton6 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane2 = null;
	private JTextPane jTextPane21 = null;
	private JTextPane jTextPane211 = null;
	private JLabel jLabel61 = null;
	private JLabel jLabelTitle61 = null;
	private JTextPane jTextPaneDescription61 = null;
	private JLabel jLabel611 = null;
	private JLabel jLabelTitle611 = null;
	private JTextPane jTextPaneDescription611 = null;
	/**
	 * This is the default constructor
	 */
	public PointsRewardSystemPanel() {
		super();
		initialize();
	}
	
	public PointsRewardSystemPanel(JFrame f){
		this();
		myFrame = f;
//		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
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
		CheckLogin CL = new CheckLogin();
		CL = CheckLoginDAO.searchByIdTi(macAddress);
		String loginName = CL.getUsername();
		CustomerDetails CD = new CustomerDetails();
		CD = CustomerDetailsDAO.searchByUsername(loginName);
		int points = CD.getPoints();
		
		jLabelTitle611 = new JLabel();
		jLabelTitle611.setBounds(new Rectangle(704, 177, 125, 37));
		jLabelTitle611.setText("Singapore Zoo");
		jLabelTitle611.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabelTitle611.setVisible(false);
		jLabel611 = new JLabel();
		jLabel611.setBounds(new Rectangle(575, 174, 111, 106));
		jLabel611.setText("");
		jLabel611.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/zoo.png")));
		jLabel611.setVisible(false);
		jLabelTitle61 = new JLabel();
		jLabelTitle61.setBounds(new Rectangle(697, 185, 232, 37));
		jLabelTitle61.setText("G2000 Voucher");
		jLabelTitle61.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabel61 = new JLabel();
		jLabel61.setBounds(new Rectangle(572, 174, 111, 106));
		jLabel61.setText("");
		jLabel61.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/bags.png")));
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new MyAccountsPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelButton6 = new JLabel();
		jLabelButton6.setText("");
		jLabelButton6.setLocation(new Point(570, 314));
		jLabelButton6.setSize(new Dimension(317, 123));
		jLabelButton6.setBackground(new Color(227, 228, 250));
		jLabelTitle6 = new JLabel();
		jLabelTitle6.setText("Free Stays");
		jLabelTitle6.setSize(new Dimension(184, 37));
		jLabelTitle6.setLocation(new Point(695, 325));
		jLabelTitle6.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabel6 = new JLabel();
		jLabel6.setText("");
		jLabel6.setSize(new Dimension(110, 105));
		jLabel6.setLocation(new Point(574, 320));
		jLabel6.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Pic6.png")));
		jLabelButton5 = new JLabel();
		jLabelButton5.setBounds(new Rectangle(570, 171, 317, 123));
		jLabelButton5.setBackground(new Color(227, 228, 250));
		jLabelButton5.setText("");
		jLabelButton5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new RedemptionPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelTitle5 = new JLabel();
		jLabelTitle5.setBounds(new Rectangle(695, 175, 187, 44));
		jLabelTitle5.setText("Food Vouchers");
		jLabelTitle5.setFont(new Font("Calibri", Font.PLAIN, 30));
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(574, 175, 107, 101));
		jLabel5.setText("");
		jLabel5.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/FoodVoucherLunchBig.png")));
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(34, 99, 228, 40));
		jLabel4.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabel4.setText("Your points: " + points);
		jLabel3 = new JLabel();
		jLabel3.setText("");
		jLabel3.setSize(new Dimension(79, 79));
		jLabel3.setLocation(new Point(150, 435));
		jLabel3.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Pic3.png")));
		jLabel2 = new JLabel();
		jLabel2.setText("");
		jLabel2.setSize(new Dimension(79, 79));
		jLabel2.setLocation(new Point(149, 300));
		jLabel2.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Pic2.png")));
		jLabel1 = new JLabel();
		jLabel1.setText("");
		jLabel1.setSize(new Dimension(82, 80));
		jLabel1.setLocation(new Point(149, 165));
		jLabel1.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Pic1.png")));
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Points Reward System");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(345, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		jLabel61.setVisible(false);
		jLabelTitle61.setVisible(false);
		//jTextPaneDescription61.setVisible(false);
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
		this.add(jLabel5, null);
		this.add(jLabelTitle5, null);
		this.add(getJTextPaneDescription5(), null);
		this.add(jLabelButton5, null);
		this.add(jLabel6, null);
		this.add(jLabelTitle6, null);
		this.add(getJTextPaneDescription6(), null);
		this.add(jLabelButton6, null);
		this.add(jLabelBack, null);
		this.add(getJTextPane2(), null);
		this.add(getJTextPane21(), null);
		this.add(getJTextPane211(), null);
		this.add(jLabel61, null);
		this.add(jLabelTitle61, null);
		this.add(getJTextPaneDescription61(), null);
		this.add(jLabel611, null);
		this.add(jLabelTitle611, null);
		this.add(getJTextPaneDescription611(), null);
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
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTextPaneShopping.setBackground(new Color(91, 155, 213));
					jTextPaneHotel.setBackground(new Color(31, 78, 121));
					jTextPaneTravel.setBackground(new Color(91,155,213));
					jLabel5.setVisible(true);
					jLabelTitle5.setVisible(true);
					jTextPaneDescription5.setVisible(true);
					jLabel6.setVisible(true);
					jLabelTitle6.setVisible(true);
					jTextPaneDescription6.setVisible(true);
					jLabel61.setVisible(false);
					jLabelTitle61.setVisible(false);
					jTextPaneDescription61.setVisible(false);
					jTextPane21.setVisible(false);
					jLabel611.setVisible(false);
					jLabelTitle611.setVisible(false);
					jTextPaneDescription611.setVisible(false);

				}
			});
			jTextPaneHotel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jLabel5.setVisible(true);
					jLabelTitle5.setVisible(true);
					jTextPaneDescription5.setVisible(true);
					jLabel6.setVisible(true);
					jLabelTitle6.setVisible(true);
					jTextPaneDescription6.setVisible(true);
					jTextPane2.setVisible(true);
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
			jTextPaneShopping.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jLabel5.setVisible(false);
					jLabelTitle5.setVisible(false);
					jTextPaneDescription5.setVisible(false);
					jLabel6.setVisible(false);
					jLabelTitle6.setVisible(false);
					jTextPaneDescription6.setVisible(false);
					jTextPaneHotel.setBackground(new Color(91, 155, 213));
					jTextPaneShopping.setBackground(new Color(31, 78, 121));
					jTextPaneTravel.setBackground(new Color(91,155,213));

					jTextPane21.setVisible(true);
				}
			});
			jTextPaneShopping.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jLabel5.setVisible(false);
					jLabelTitle5.setVisible(false);
					jTextPaneDescription5.setVisible(false);
					jLabel6.setVisible(false);
					jLabelTitle6.setVisible(false);
					jTextPaneDescription6.setVisible(false);
					jTextPane2.setVisible(false);
					jTextPane2.setVisible(false);
					jLabel61.setVisible(true);
					jLabelTitle61.setVisible(true);
					jTextPaneDescription61.setVisible(true);
					jLabel611.setVisible(false);
					jLabelTitle611.setVisible(false);
					jTextPaneDescription611.setVisible(false);
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
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTextPaneHotel.setBackground(new Color(91, 155, 213));
					jTextPaneTravel.setBackground(new Color(31, 78, 121));
					jTextPaneShopping.setBackground(new Color(91,155,213));
					jTextPane21.setVisible(false);
					jTextPane211.setVisible(true);
					jTextPane2.setVisible(false);
					jLabel61.setVisible(false);
					jLabelTitle61.setVisible(false);
					jTextPaneDescription61.setVisible(false);
					jLabel611.setVisible(true);
					jLabelTitle611.setVisible(true);
					jTextPaneDescription611.setVisible(true);

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
	 * This method initializes jTextPaneDescription5	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescription5() {
		if (jTextPaneDescription5 == null) {
			jTextPaneDescription5 = new JTextPane();
			jTextPaneDescription5.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription5.setBackground(new Color(227, 228, 250));
			jTextPaneDescription5.setSize(new Dimension(190, 63));
			jTextPaneDescription5.setLocation(new Point(695, 230));
			jTextPaneDescription5.setText("Enjoy up to 50% off dining Vouchers!");
		}
		return jTextPaneDescription5;
	}

	/**
	 * This method initializes jTextPaneDescription6	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescription6() {
		if (jTextPaneDescription6 == null) {
			jTextPaneDescription6 = new JTextPane();
			jTextPaneDescription6.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription6.setText("Enjoy up to 3 days of free stays!");
			jTextPaneDescription6.setLocation(new Point(695, 380));
			jTextPaneDescription6.setSize(new Dimension(190, 63));
			jTextPaneDescription6.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneDescription6;
	}

	/**
	 * This method initializes jTextPane2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane2() {
		if (jTextPane2 == null) {
			jTextPane2 = new JTextPane();
			jTextPane2.setBounds(new Rectangle(572, 116, 113, 41));
			jTextPane2.setText("Hotel");
			jTextPane2.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPane2.setEditable(false);
			jTextPane2.setBackground(new Color(227, 228, 255));
		}
		return jTextPane2;
	}

	/**
	 * This method initializes jTextPane21	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane21() {
		if (jTextPane21 == null) {
			jTextPane21 = new JTextPane();
			jTextPane21.setBounds(new Rectangle(570, 117, 134, 43));
			jTextPane21.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPane21.setText("Shopping");
			jTextPane21.setEditable(false);
			jTextPane21.setBackground(new Color(227, 228, 255));
			jTextPane21.setVisible(false);
		}
		return jTextPane21;
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
	private JTextPane getJTextPaneDescription61() {
		if (jTextPaneDescription61 == null) {
			jTextPaneDescription61 = new JTextPane();
			jTextPaneDescription61.setBounds(new Rectangle(700, 236, 176, 45));
			jTextPaneDescription61.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription61.setText("Enjoy additional 5% off your purchase");
			jTextPaneDescription61.setBackground(new Color(227, 228, 250));

		}
		return jTextPaneDescription61;
	}

	/**
	 * This method initializes jTextPaneDescription611	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescription611() {
		if (jTextPaneDescription611 == null) {
			jTextPaneDescription611 = new JTextPane();
			jTextPaneDescription611.setBounds(new Rectangle(703, 221, 176, 69));
			jTextPaneDescription611.setFont(new Font("Calibri", Font.PLAIN, 12));
			jTextPaneDescription611.setText("Enjoy a additional free ticket when you purchase 2 tickets");
			jTextPaneDescription611.setBackground(new Color(227, 228, 250));
			jTextPaneDescription611.setVisible(false);
		}
		return jTextPaneDescription611;
	}

}
