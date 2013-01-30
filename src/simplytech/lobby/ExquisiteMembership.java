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
import java.sql.SQLException;

import javax.swing.JButton;

import simplytech.dao.CustomerDAO;

public class ExquisiteMembership extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelExquisiteMembershipBack = null;
	private JLabel jLabelExquisiteMembershipHeader = null;
	private Panel PanelExquisiteMembershipLine = null;
	private JLabel jLabelExquisiteMembershipPicture = null;
	private JLabel jLabelExquisiteMembershipBullet = null;
	private JLabel jLabelExquisiteMembershipText = null;
	private JFrame myFrame = null;
	private JButton jButton = null;
	private int points = 3200;
	private int option1;

	/**
	 * This is the default constructor
	 */
	public ExquisiteMembership() {
		super();
		initialize();
	}

	public ExquisiteMembership(JFrame f) {
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
		jLabelExquisiteMembershipText = new JLabel();
		jLabelExquisiteMembershipText.setIcon(new ImageIcon(
				ExquisiteMembership.class
						.getResource("/simplytech/image/membership2Text.JPG")));
		jLabelExquisiteMembershipText
				.setBounds(new Rectangle(30, 380, 600, 200));
		jLabelExquisiteMembershipText.setBackground(new Color(227, 228, 250));
		jLabelExquisiteMembershipText.setText("");
		jLabelExquisiteMembershipBullet = new JLabel();
		jLabelExquisiteMembershipBullet
				.setIcon(new ImageIcon(ExquisiteMembership.class.getResource("/simplytech/image/exquisiteText3.JPG")));
		jLabelExquisiteMembershipBullet.setBounds(new Rectangle(540, 90, 445, 350));
		jLabelExquisiteMembershipBullet.setText("");
		jLabelExquisiteMembershipPicture = new JLabel();
		jLabelExquisiteMembershipPicture
				.setIcon(new ImageIcon(ExquisiteMembership.class
						.getResource("/simplytech/image/exquisitePicture.JPG")));
		jLabelExquisiteMembershipPicture.setPreferredSize(new Dimension(600,
				600));
		jLabelExquisiteMembershipPicture.setBounds(new Rectangle(30, 100, 400,
				350));
		jLabelExquisiteMembershipPicture.setText("");
		jLabelExquisiteMembershipHeader = new JLabel();
		jLabelExquisiteMembershipHeader
				.setBounds(new Rectangle(91, 23, 183, 35));
		jLabelExquisiteMembershipHeader
				.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelExquisiteMembershipHeader
				.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelExquisiteMembershipHeader.setText("Memberships");
		jLabelExquisiteMembershipHeader
				.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelExquisiteMembershipBack = new JLabel();
		jLabelExquisiteMembershipBack.setText("");
		jLabelExquisiteMembershipBack
				.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelExquisiteMembershipBack.setIcon(new ImageIcon(
				ExquisiteMembership.class
						.getResource("/simplytech/image/Swap Left.png")));
		jLabelExquisiteMembershipBack
				.addMouseListener(new java.awt.event.MouseListener() {
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
		this.add(jLabelExquisiteMembershipBack, null);
		this.add(jLabelExquisiteMembershipHeader, null);
		this.add(getPanelExquisiteMembershipLine(), null);
		this.add(jLabelExquisiteMembershipPicture, null);
		this.add(jLabelExquisiteMembershipBullet, null);
		this.add(jLabelExquisiteMembershipText, null);
		this.add(getJButton(), null);
	}

	/**
	 * This method initializes PanelExquisiteMembershipLine
	 * 
	 * @return java.awt.Panel
	 */
	private Panel getPanelExquisiteMembershipLine() {
		if (PanelExquisiteMembershipLine == null) {
			PanelExquisiteMembershipLine = new Panel();
			PanelExquisiteMembershipLine.setLayout(null);
			PanelExquisiteMembershipLine
					.setBounds(new Rectangle(0, 78, 371, 4));
			PanelExquisiteMembershipLine.setFont(new Font("Arial", Font.BOLD,
					12));
			PanelExquisiteMembershipLine.setMinimumSize(new Dimension(300, 4));
			PanelExquisiteMembershipLine.setName("");
			PanelExquisiteMembershipLine.setBackground(new Color(91, 155, 213));
		}
		return PanelExquisiteMembershipLine;
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
					int option = JOptionPane.showConfirmDialog(myFrame,
							"Are you sure you want to redeem now?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						if (MainFrame.getPersonWhoLogin().getPoints() >= points) {
							int newPoints = MainFrame.getPersonWhoLogin()
									.getPoints() - points;
							try {
								CustomerDAO.updateMembership("Exquisite",
										MainFrame.getPersonWhoLogin().getId());
								MainFrame.getPersonWhoLogin().setPoints(newPoints);
								MainFrame.getPersonWhoLogin().setMembership("Exquisite");
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								CustomerDAO.updatePoints(newPoints, MainFrame
										.getPersonWhoLogin().getId());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							int option2 = JOptionPane.showConfirmDialog(myFrame,
									"Congratulations! You are now an Exquisite member of our hotel!",
									"Confirmation",
									JOptionPane.PLAIN_MESSAGE);
						}
						else
							 		option1 = JOptionPane.showConfirmDialog(myFrame,
									"Sorry but, you do not have enough points to redeem.",
									"Confirmation",
									JOptionPane.PLAIN_MESSAGE);


					}
				}
			});
		}
		return jButton;
	}

}
