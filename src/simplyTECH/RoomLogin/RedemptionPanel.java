package simplyTECH.RoomLogin;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;


import simplyTECH.Components.MACAddress;
import simplyTECH.DatabaseStatements.DBController;
import simplyTECH.dao.CheckLoginDAO;
import simplyTECH.dao.CustomerDetailsDAO;
import simplyTECH.dao.PersonDAO;
import simplyTECH.entity.CheckLogin;
import simplyTECH.entity.CustomerDetails;
import simplyTECH.entity.Person;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.SocketException;
import java.sql.SQLException;

public class RedemptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabelImage;
	private JLabel jLabelTitle5 = null;
	private JTextPane jTextPaneTitle = null;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JTextPane jTextPane1 = null;
	private JButton jButtonRedeem = null;
	private JLabel jLabel41 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextPane jTextPane11 = null;
	private JTextPane jTextPane2 = null;
	private JTextPane jTextPane3 = null;
	private JLabel jLabelMyVouchers = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private String imagePath;

	/**
	 * This is the default constructor
	 */
	public RedemptionPanel() {
		super();
		initialize();
	}

	public RedemptionPanel(JFrame f){
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
		System.out.println("SAASASASSs");
		System.err.println("TESTING GITHUB");
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
		Person person = PersonDAO.searchByUsername(loginName);
		int id = person.getId();
		CD = CustomerDetailsDAO.searchById(id);
		//CD = CustomerDetailsDAO.searchByUsername(loginName);
		int points = CD.getPoints();
		imagePath = "/simplyTECH/image/FoodVoucherLunchBig.png";
		
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new PointsRewardSystemPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelMyVouchers = new JLabel();
		jLabelMyVouchers.setBounds(new Rectangle(813, 28, 193, 34));
		jLabelMyVouchers.setText("My Vouchers");
		jLabelMyVouchers.setForeground(new Color(58, 115, 255));
		jLabelMyVouchers.setFont(new Font("Calibri", Font.PLAIN, 24));
		jLabelMyVouchers.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new MyVouchersPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(659, 393, 91, 91));
		jLabel3.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/R3.png")));
		jLabel3.setText("");
		jLabel3.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(659, 279, 91, 91));
		jLabel2.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/R2.png")));
		jLabel2.setText("");
		jLabel2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(658, 171, 92, 92));
		jLabel1.setText("");
		jLabel1.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel1.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/R1.png")));
		jLabel41 = new JLabel();
		jLabel41.setBounds(new Rectangle(511, 103, 131, 23));
		jLabel41.setText("More");
		jLabel41.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelTitle5 = new JLabel();
		jLabelTitle5.setBounds(new Rectangle(216, 282, 184, 37));
		jLabelTitle5.setText( minusPoints + " points");
		jLabelTitle5.setFont(new Font("Calibri", Font.PLAIN, 14));
		jLabelImage = new JLabel();
		jLabelImage.setBounds(new Rectangle(79, 210, 110, 105));
		jLabelImage.setText("");
		jLabelImage.setIcon(new ImageIcon(getClass().getResource(imagePath)));
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(55, 103, 320, 69));
		jLabel4.setText("Your points: " + points);
		jLabel4.setFont(new Font("Calibri", Font.PLAIN, 27));
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Points Reward System");
		jLabel.setSize(new Dimension(345, 35));
		jLabel.setLocation(new Point(91, 23));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setEnabled(true);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabel, null);
		this.add(getJTextPane(), null);
		this.add(jLabel4, null);
		this.add(jLabelImage, null);
		this.add(jLabelTitle5, null);
		this.add(getJTextPaneTitle(), null);
		this.add(getJTextPaneSubtitle(), null);
		this.add(getJTextPaneDetails(), null);
		this.add(getJTextPane1(), null);
		this.add(getJButtonRedeem(), null);
		this.add(jLabel41, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(getJTextPane11(), null);
		this.add(getJTextPane2(), null);
		this.add(getJTextPane3(), null);
		this.add(jLabelMyVouchers, null);
		this.add(jLabelBack, null);
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setPreferredSize(new Dimension(371, 4));
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 78));
			jTextPane.setBackground(new Color(91, 155, 213));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPaneTitle2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTitle() {
		if (jTextPaneTitle == null) {
			jTextPaneTitle = new JTextPane();
			jTextPaneTitle.setBounds(new Rectangle(215, 210, 152, 60));
			jTextPaneTitle.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle.setBackground(new Color(227, 228, 250));
			jTextPaneTitle.setText("Food Voucher (For 1) - Lunch");
			jTextPaneTitle.setVisible(true);
		}
		return jTextPaneTitle;
	}

	/**
	 * This method initializes jTextPaneDescription1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneSubtitle() {
		if (jTextPaneSubtitle == null) {
			jTextPaneSubtitle = new JTextPane();
			jTextPaneSubtitle.setBounds(new Rectangle(66, 331, 315, 60));
			jTextPaneSubtitle.setBackground(new Color(227, 228, 250));
			jTextPaneSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneSubtitle.setText("Redeem this voucher to redeem 50% off the second person you bring.");
		}
		return jTextPaneSubtitle;
	}

	/**
	 * This method initializes jTextPaneDetails1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDetails() {
		if (jTextPaneDetails == null) {
			jTextPaneDetails = new JTextPane();
			jTextPaneDetails.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDetails.setBackground(new Color(227, 228, 250));
			jTextPaneDetails.setText("Voucher is only valid for 7 days upon purchase. 50% is only applicable to the second or subsequent person you bring. 1 time use only.  Voucher is non transferable and non-refundable. Voucher is only valid from 12pm to 3pm daily.");
			jTextPaneDetails.setLocation(new Point(63, 400));
			jTextPaneDetails.setSize(new Dimension(315, 500));
			jTextPaneDetails.setVisible(true);
		}
		return jTextPaneDetails;
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
	 * This method initializes jButtonRedeem	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private int minusPoints = 750;
	private int finalPoints = 0;
	private String loginName;
	private DBController db;
	private String username;
	private String image;
	private String title;
	private String subtitle;
	private String details;
	private String macAddress = null;
	private int loginID;
	
	private JButton getJButtonRedeem() {
		if (jButtonRedeem == null) {
			MACAddress mac = new MACAddress();
			try {
				macAddress = mac.getMAC();
			} catch (SocketException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			System.out.println("MacAddress: "+macAddress);
			jButtonRedeem = new JButton();
			CheckLogin CL = new CheckLogin();
			CL = CheckLoginDAO.searchByIdTi(macAddress);
			loginName = CL.getUsername();
			loginID = CL.getId();
			CustomerDetails cd = new CustomerDetails();
			//cd = cd.searchByUsername(loginName);
			cd = CustomerDetailsDAO.searchById(loginID);
			final int points = cd.getPoints();
			db = new DBController();
			username = loginName;
			title = jTextPaneTitle.getText();
			subtitle = jTextPaneSubtitle.getText();
			details = jTextPaneDetails.getText();
			image = imagePath;
			
			
			jButtonRedeem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int option = JOptionPane.showConfirmDialog(myFrame,"Are you sure you want to redeem?","Confirmation", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION){
						minusPoints = 750;
						System.out.println("ASAS" + points);
						finalPoints = points - minusPoints;
						System.out.println(finalPoints);
						if (finalPoints < 0){
							int option1 = JOptionPane.showConfirmDialog(myFrame,
									"Not enough points!",
									"Confirmation", JOptionPane.PLAIN_MESSAGE);
						}
						else {
						String query = "UPDATE customerdetails SET Points = '"+finalPoints+"' WHERE loginName = '"+loginName+"'";
						String query2 = "INSERT INTO vouchers (ID,Username, Image, Title, Subtitle, Details) values ('"+loginID+"','"+username+"','"+image+"','"+title+"','"+subtitle+"','"+details+"')";
						try {
							db.updateRequest(query);
							db.updateRequest(query2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JPanel panel = new RedemptionPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
						}
					}
				}
			});
			jButtonRedeem.setBounds(new Rectangle(298, 115, 107, 47));
			jButtonRedeem.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonRedeem.setForeground(Color.white);
			jButtonRedeem.setText("Redeem");
			jButtonRedeem.setBackground(new Color(91, 155, 213));
		}
		return jButtonRedeem;
	}

	/**
	 * This method initializes jTextPane11	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane11() {
		if (jTextPane11 == null) {
			jTextPane11 = new JTextPane();
			jTextPane11.setBounds(new Rectangle(751, 171, 184, 97));
			jTextPane11.setFont(new Font("Calibri", Font.BOLD, 18));
			jTextPane11.setBackground(new Color(227, 228, 250));
			jTextPane11.setText("Food Voucher (For 2) - Dinner");
		}
		return jTextPane11;
	}

	/**
	 * This method initializes jTextPane2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane2() {
		if (jTextPane2 == null) {
			jTextPane2 = new JTextPane();
			jTextPane2.setBounds(new Rectangle(750, 278, 171, 68));
			jTextPane2.setFont(new Font("Calibri", Font.BOLD, 18));
			jTextPane2.setText("Food Voucher (For 1) - Breakfast");
			jTextPane2.setBackground(new Color(227, 228, 250));
		}
		return jTextPane2;
	}

	/**
	 * This method initializes jTextPane3	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane3() {
		if (jTextPane3 == null) {
			jTextPane3 = new JTextPane();
			jTextPane3.setFont(new Font("Calibri", Font.BOLD, 18));
			jTextPane3.setText("Food Voucher (For 2) - Lunch");
			jTextPane3.setBounds(new Rectangle(749, 393, 186, 91));
			jTextPane3.setBackground(new Color(227, 228, 250));
		}
		return jTextPane3;
	}

}  //  @jve:decl-index=0:visual-constraint="21,16"
