package simplytech.lobby;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JButton;

public class LobbyMembership extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelMembershipBack = null;
	private JLabel jLabelMembershipHeader = null;
	private Panel PanelMembershipLine = null;
	private JButton jButtonGuest = null;
	private JButton jButtonExquisite = null;
	private JButton jButtonRegular = null;
	private JFrame myFrame = null;
	/**
	 * This is the default constructor
	 */
	public LobbyMembership() {
		super();
		initialize();
	}
	public LobbyMembership(JFrame f){
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
		jLabelMembershipHeader = new JLabel();
		jLabelMembershipHeader.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelMembershipHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelMembershipHeader.setText("Memberships");
		jLabelMembershipHeader.setBounds(new Rectangle(91, 23, 200, 35));
		jLabelMembershipHeader.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelMembershipBack = new JLabel();
		jLabelMembershipBack.setText("");
		jLabelMembershipBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelMembershipBack.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelMembershipBack.addMouseListener(new java.awt.event.MouseListener() {
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
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setBounds(new Rectangle(0, 0, 1024, 600));
		this.add(jLabelMembershipBack, null);
		this.add(jLabelMembershipHeader, null);
		this.add(getPanelMembershipLine(), null);
		this.add(getJButtonGuestUser(), null);
		this.add(getJButtonExquisite(), null);
		this.add(getJButtonRegular(), null);
	}

	/**
	 * This method initializes PanelMembershipLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanelMembershipLine() {
		if (PanelMembershipLine == null) {
			PanelMembershipLine = new Panel();
			PanelMembershipLine.setLayout(null);
			PanelMembershipLine.setFont(new Font("Arial", Font.BOLD, 12));
			PanelMembershipLine.setMinimumSize(new Dimension(371, 4));
			PanelMembershipLine.setName("");
			PanelMembershipLine.setLocation(new Point(0, 78));
			PanelMembershipLine.setSize(new Dimension(371, 4));
			PanelMembershipLine.setPreferredSize(new Dimension(371, 4));
			PanelMembershipLine.setBackground(new Color(91, 155, 213));
		}
		return PanelMembershipLine;
	}

	/**
	 * This method initializes jButtonGuestUser	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuestUser() {
		if (jButtonGuest == null) {
			jButtonGuest = new JButton();
			jButtonGuest.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonGuest.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonGuest.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/guestUserMembership.JPG")));
			jButtonGuest.setText("Guest Membership");
			jButtonGuest.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonGuest.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonGuest.setBounds(new Rectangle(170, 130, 171, 161));
			jButtonGuest.setBackground(new Color(91, 155, 213));
			jButtonGuest.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new GuestMembership(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonGuest;
	}

	/**
	 * This method initializes jButtonExquisite	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExquisite() {
		if (jButtonExquisite == null) {
			jButtonExquisite = new JButton();
			jButtonExquisite.setBackground(new Color(91, 155, 213));
			jButtonExquisite.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonExquisite.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/exquisiteMembership.JPG")));
			jButtonExquisite.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonExquisite.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonExquisite.setBounds(new Rectangle(370, 130, 171, 161));
			jButtonExquisite.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonExquisite.setText("Exquisite Membership");
			jButtonExquisite.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new ExquisiteMembership(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonExquisite;
	}

	/**
	 * This method initializes jButtonRegular	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRegular() {
		if (jButtonRegular == null) {
			jButtonRegular = new JButton();
			jButtonRegular.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/regularMembership.JPG")));
			jButtonRegular.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonRegular.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonRegular.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonRegular.setText("Regular Membership");
			jButtonRegular.setBounds(new Rectangle(170, 310, 171, 161));
			jButtonRegular.setFont(new Font("Arial", Font.BOLD, 12));
			jButtonRegular.setBackground(new Color(91, 155, 213));
			jButtonRegular.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new RegularMembership(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonRegular;
	}

}  //  @jve:decl-index=0:visual-constraint="-56,12"
