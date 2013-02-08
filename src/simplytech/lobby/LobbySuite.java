package simplytech.lobby;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import simplytech.dao.CreditCardDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.CreditCard;
import simplytech.entity.Customer;
import simplytech.entity.Person;

public class LobbySuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButtonLogout = null;
	private Panel panel1 = null;
	private JLabel jLabelHowMayIServeYou = null;
	private JLabel jLabelName = null;
	private JLabel jLabelMembership = null;
	private JLabel jLabelPoints = null;
	private JLabel jLabelCard = null;
	private JButton jButtonOrchid = null;
	private JButton jButtonGold = null;
	private JButton jButtonSands = null;
	private JButton jButtonDeluxe = null;
	private JButton jButtonPresidential = null;
	private JFrame myFrame = null;
	private JButton jButtonMembership1 = null;
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
	/**
	 * This is the default constructor
	 */
	public LobbySuite() {
		super();
		//initialize();
	}
	public LobbySuite(JFrame f) {
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
		card = CreditCardDAO.searchById(MainFrame.getPersonWhoLogin().getId());
		cardNumber = card.getCardNumber()+"";
		cardType = card.getCardType();
		membership = MainFrame.getPersonWhoLogin().getMembership();
		points = MainFrame.getPersonWhoLogin().getPoints();
		jLabelCard = new JLabel();
		jLabelCard.setText("Card:");
		jLabelCard.setPreferredSize(new Dimension(80, 24));
		jLabelCard.setBounds(new Rectangle(30, 190, 80, 24));
		jLabelCard.setFont(new Font("Arial", Font.BOLD, 18));
		jLabelPoints = new JLabel();
		jLabelPoints.setFont(new Font("Arial", Font.BOLD, 18));
		jLabelPoints.setBounds(new Rectangle(30, 280, 120, 24));
		jLabelPoints.setText("Points:");
		jLabelMembership = new JLabel();
		jLabelMembership.setText("Membership:");
		jLabelMembership.setFont(new Font("Arial", Font.BOLD, 18));
		jLabelMembership.setBounds(new Rectangle(30, 370, 160, 23));
		jLabelMembership.setPreferredSize(new Dimension(200, 29));
		jLabelName = new JLabel();
		jLabelName.setFont(new Font("Arial", Font.BOLD, 18));
		jLabelName.setBounds(new Rectangle(30, 100, 80, 20));
		jLabelName.setText("Name:");
		jLabelHowMayIServeYou = new JLabel();
		jLabelHowMayIServeYou.setText("How May I Serve You?");
		jLabelHowMayIServeYou.setFont(new Font("Arial", Font.PLAIN, 18));
		jLabelHowMayIServeYou.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelHowMayIServeYou.setBounds(new Rectangle(98, 45, 280, 32));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setFont(new Font("Dialog", Font.PLAIN, 12));
		this.add(getJButtonLogout(), null);
		this.add(getPanel1(), null);
		this.add(jLabelHowMayIServeYou, null);
		this.add(jLabelName, null);
		this.add(jLabelMembership, null);
		this.add(jLabelPoints, null);
		this.add(jLabelCard, null);
		this.add(getJButtonOrchid(), null);
		this.add(getJButtonGold(), null);
		this.add(getJButtonSands(), null);
		this.add(getJButtonDeluxe(), null);
		this.add(getJButtonPresidential(), null);
		this.add(getJButtonMembership1(), null);
		
		JLabel displayName = new JLabel("");
		displayName.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayName.setBounds(53, 131, 187, 31);
		displayName.setText(MainFrame.getPersonWhoLogin().getName());
		add(displayName);
		
		JLabel displayCard = new JLabel("");
		displayCard.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayCard.setBounds(53, 225, 235, 31);
		displayCard.setText(cardType + " XXX-" + cardNumber.charAt(12)+cardNumber.charAt(13)+cardNumber.charAt(14)+cardNumber.charAt(15));
		add(displayCard);
		add(getDisplayPts());
		add(displayMembership());
	}

	/**
	 * This method initializes jButtonLogout	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLogout() {
		if (jButtonLogout == null) {
			jButtonLogout = new JButton();
			jButtonLogout.setText("Log Out");
			jButtonLogout.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonLogout.setSelected(false);
			jButtonLogout.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonLogout.setComponentOrientation(ComponentOrientation.UNKNOWN);
			jButtonLogout.setBounds(new Rectangle(8, 30, 80, 40));
			jButtonLogout.setForeground(Color.white);
			jButtonLogout.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonLogout.setBackground(new Color(91, 155, 213));
			jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(myFrame,"Do You want to exit?","Confirmation", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION){
						JPanel panel = new LobbyLoginPanel(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
				}
			});
		}
		return jButtonLogout;
	}

	/**
	 * This method initializes panel1	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanel1() {
		if (panel1 == null) {
			panel1 = new Panel();
			panel1.setLayout(null);
			panel1.setFont(new Font("Arial", Font.BOLD, 12));
			panel1.setName("");
			panel1.setBounds(new Rectangle(0, 78, 371, 4));
			panel1.setBackground(new Color(91, 155, 213));
		}
		return panel1;
	}

	/**
	 * This method initializes jButtonOrchid	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOrchid() {
		if (jButtonOrchid == null) {
			jButtonOrchid = new JButton();
			jButtonOrchid.setIcon(new ImageIcon(LobbySuite.class.getResource("/simplytech/image/OrchidSuite.jpg")));
			jButtonOrchid.setSize(new Dimension(161, 151));
			jButtonOrchid.setText("Orchid Suite");
			jButtonOrchid.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonOrchid.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonOrchid.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonOrchid.setBackground(new Color(91, 155, 213));
			jButtonOrchid.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonOrchid.setLocation(new Point(370, 100));
			jButtonOrchid.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new OrchidSuite(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonOrchid;
	}

	/**
	 * This method initializes jButtonGold	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGold() {
		if (jButtonGold == null) {
			jButtonGold = new JButton();
			jButtonGold.setIcon(new ImageIcon(LobbySuite.class.getResource("/simplytech/image/GoldSuite.jpg")));
			jButtonGold.setSize(new Dimension(161, 151));
			jButtonGold.setText("Gold Suite");
			jButtonGold.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonGold.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonGold.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonGold.setBackground(new Color(91, 155, 213));
			jButtonGold.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonGold.setLocation(new Point(370, 270));
			jButtonGold.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new GoldSuite(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonGold;
	}

	/**
	 * This method initializes jButtonSands	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSands() {
		if (jButtonSands == null) {
			jButtonSands = new JButton();
			jButtonSands.setIcon(new ImageIcon(LobbySuite.class.getResource("/simplytech/image/SandsSuite.jpg")));
			jButtonSands.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonSands.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonSands.setText("Sands Suite");
			jButtonSands.setPreferredSize(new Dimension(200, 200));
			jButtonSands.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonSands.setBackground(new Color(91, 155, 213));
			jButtonSands.setBounds(new Rectangle(565, 100, 161, 151));
			jButtonSands.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonSands.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new SandsSuite(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonSands;
	}

	/**
	 * This method initializes jButtonDeluxe	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDeluxe() {
		if (jButtonDeluxe == null) {
			jButtonDeluxe = new JButton();
			jButtonDeluxe.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonDeluxe.setLocation(new Point(800, 100));
			jButtonDeluxe.setSize(new Dimension(161, 151));
			jButtonDeluxe.setText("Deluxe Suite");
			jButtonDeluxe.setIcon(new ImageIcon(LobbySuite.class.getResource("/simplytech/image/Deluxesuite.jpg")));
			jButtonDeluxe.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonDeluxe.setBackground(new Color(91, 155, 213));
			jButtonDeluxe.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonDeluxe.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonDeluxe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new DeluxeSuite(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonDeluxe;
	}

	/**
	 * This method initializes jButtonPresidential	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPresidential() {
		if (jButtonPresidential == null) {
			jButtonPresidential = new JButton();
			jButtonPresidential.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonPresidential.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonPresidential.setLocation(new Point(800, 270));
			jButtonPresidential.setSize(new Dimension(161, 151));
			jButtonPresidential.setIcon(new ImageIcon(LobbySuite.class.getResource("/simplytech/image/PresidentialSuite.jpg")));
			jButtonPresidential.setText("Presidential Suite");
			jButtonPresidential.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonPresidential.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonPresidential.setBackground(new Color(91, 155, 213));
			jButtonPresidential.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new PresidentialSuite(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonPresidential;
	}
	/**
	 * This method initializes jButtonMembership1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMembership1() {
		if (jButtonMembership1 == null) {
			jButtonMembership1 = new JButton();
			jButtonMembership1.setBounds(new Rectangle(110, 460, 150, 80));
			jButtonMembership1.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonMembership1.setText("Membership");
			jButtonMembership1.setFont(new Font("Arial", Font.BOLD, 18));
			jButtonMembership1.setForeground(Color.white);
			jButtonMembership1.setBackground(new Color(91, 155, 213));
			jButtonMembership1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new LobbyMembership(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonMembership1;
	}
	private JLabel getDisplayPts() {
		if (displayPts == null) {
			displayPts = new JLabel("");
			displayPts.setText(MainFrame.getPersonWhoLogin().getPoints()+"");
			displayPts.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayPts.setBounds(53, 315, 187, 31);
		}
		return displayPts;
	}
	private JLabel displayMembership() {
		if (displayMembership == null) {
			displayMembership = new JLabel("");
			displayMembership.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayMembership.setBounds(53, 404, 187, 31);
			displayMembership.setText(MainFrame.getPersonWhoLogin().getMembership());
		}
		return displayMembership;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
