package simplytech.lobby;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Dimension;
import javax.swing.JButton;

public class GuestMembership extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelGuestMembershipBack = null;
	private JLabel jLabelGuestMembershipHeader = null;
	private Panel panelGuestMembershipLine = null;
	private JLabel jLabelGuestMembershipPicture = null;
	private JLabel jLabelGuestMembershipBullet = null;
	private JLabel jLabelGuestMembershipText = null;
	private JFrame myFrame = null;
	private JButton jButton = null;
	private int option1;

	/**
	 * This is the default constructor
	 */
	public GuestMembership() {
		super();
		initialize();
	}
	public GuestMembership(JFrame f){
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
		jLabelGuestMembershipText = new JLabel();
		jLabelGuestMembershipText.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/guestText2.JPG")));
		jLabelGuestMembershipText.setBounds(new Rectangle(30, 380, 600, 200));
		jLabelGuestMembershipText.setBackground(new Color(227, 228, 250));
		jLabelGuestMembershipText.setText("");
		jLabelGuestMembershipBullet = new JLabel();
		jLabelGuestMembershipBullet.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/guestText.JPG")));
		jLabelGuestMembershipBullet.setBounds(new Rectangle(540, 90, 400, 350));
		jLabelGuestMembershipBullet.setText("");
		jLabelGuestMembershipPicture = new JLabel();
		jLabelGuestMembershipPicture.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/guestSnapshot.JPG")));
		jLabelGuestMembershipPicture.setPreferredSize(new Dimension(600, 600));
		jLabelGuestMembershipPicture.setBounds(new Rectangle(30, 100, 400, 350));
		jLabelGuestMembershipPicture.setText("");
		jLabelGuestMembershipHeader = new JLabel();
		jLabelGuestMembershipHeader.setBounds(new Rectangle(91, 23, 183, 35));
		jLabelGuestMembershipHeader.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelGuestMembershipHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelGuestMembershipHeader.setText("Memberships");
		jLabelGuestMembershipHeader.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelGuestMembershipBack = new JLabel();
		jLabelGuestMembershipBack.setText("");
		jLabelGuestMembershipBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelGuestMembershipBack.setIcon(new ImageIcon(GuestMembership.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelGuestMembershipBack.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new LobbyMembership(myFrame);
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
		this.add(jLabelGuestMembershipBack, null);
		this.add(jLabelGuestMembershipHeader, null);
		this.add(getPanelExquisiteMembershipLine(), null);
		this.add(jLabelGuestMembershipPicture, null);
		this.add(jLabelGuestMembershipBullet, null);
		this.add(jLabelGuestMembershipText, null);
		this.add(getJButton(), null);
	}

	/**
	 * This method initializes PanelExquisiteMembershipLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanelExquisiteMembershipLine() {
		if (panelGuestMembershipLine == null) {
			panelGuestMembershipLine = new Panel();
			panelGuestMembershipLine.setLayout(null);
			panelGuestMembershipLine.setBounds(new Rectangle(0, 78, 371, 4));
			panelGuestMembershipLine.setFont(new Font("Arial", Font.BOLD, 12));
			panelGuestMembershipLine.setMinimumSize(new Dimension(300, 4));
			panelGuestMembershipLine.setName("");
			panelGuestMembershipLine.setBackground(new Color(91, 155, 213));
		}
		return panelGuestMembershipLine;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(770, 440, 168, 88));
			jButton.setFont(new Font("Arial", Font.BOLD, 18));
			jButton.setForeground(Color.white);
			jButton.setText("Redeem Now");
			jButton.setHorizontalTextPosition(SwingConstants.CENTER);
			jButton.setBackground(new Color(91, 155, 213));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(myFrame,"Are you sure you want to redeem now?","Confirmation", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION){
						option1 = JOptionPane.showConfirmDialog(myFrame,
								"Sorry but by default, users are assigned guest memberships.",
								"Confirmation",
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
		}
		return jButton;
	}

}
