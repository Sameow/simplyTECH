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

public class RegularMembership extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelRegularMembershipBack = null;
	private JLabel jLabelRegularMembershipHeader = null;
	private Panel panelRegularMembershipLine = null;
	private JLabel jLabelRegularMembershipPicture = null;
	private JLabel jLabelRegularMembershipBullet = null;
	private JLabel jLabelRegularMembershipText = null;
	private JFrame myFrame = null;
	private JButton jButton = null;
	private int points = 1600;
	private int option1;

	/**
	 * This is the default constructor
	 */
	public RegularMembership() {
		super();
		initialize();
	}
	public RegularMembership(JFrame f){
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
		jLabelRegularMembershipText = new JLabel();
		jLabelRegularMembershipText.setIcon(new ImageIcon(RegularMembership.class.getResource("/simplytech/image/regularText2.JPG")));
		jLabelRegularMembershipText.setBounds(new Rectangle(30, 380, 600, 200));
		jLabelRegularMembershipText.setBackground(new Color(227, 228, 250));
		jLabelRegularMembershipText.setText("");
		jLabelRegularMembershipBullet = new JLabel();
		jLabelRegularMembershipBullet.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelRegularMembershipBullet.setVerticalAlignment(SwingConstants.TOP);
		jLabelRegularMembershipBullet.setIcon(new ImageIcon(RegularMembership.class.getResource("/simplytech/image/regularText3.JPG")));
		jLabelRegularMembershipBullet.setBounds(new Rectangle(540, 90, 400, 350));
		jLabelRegularMembershipBullet.setText("");
		jLabelRegularMembershipPicture = new JLabel();
		jLabelRegularMembershipPicture.setIcon(new ImageIcon(RegularMembership.class.getResource("/simplytech/image/regularSnapshot.JPG")));
		jLabelRegularMembershipPicture.setPreferredSize(new Dimension(600, 600));
		jLabelRegularMembershipPicture.setBounds(new Rectangle(30, 100, 400, 350));
		jLabelRegularMembershipPicture.setText("");
		jLabelRegularMembershipHeader = new JLabel();
		jLabelRegularMembershipHeader.setBounds(new Rectangle(91, 23, 183, 35));
		jLabelRegularMembershipHeader.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelRegularMembershipHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelRegularMembershipHeader.setText("Memberships");
		jLabelRegularMembershipHeader.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelRegularMembershipBack = new JLabel();
		jLabelRegularMembershipBack.setText("");
		jLabelRegularMembershipBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelRegularMembershipBack.setIcon(new ImageIcon(PresidentialSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelRegularMembershipBack.addMouseListener(new java.awt.event.MouseListener() {
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
		this.add(jLabelRegularMembershipBack, null);
		this.add(jLabelRegularMembershipHeader, null);
		this.add(getPanelExquisiteMembershipLine(), null);
		this.add(jLabelRegularMembershipPicture, null);
		this.add(jLabelRegularMembershipBullet, null);
		this.add(jLabelRegularMembershipText, null);
		this.add(getJButton(), null);
	}

	/**
	 * This method initializes PanelExquisiteMembershipLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanelExquisiteMembershipLine() {
		if (panelRegularMembershipLine == null) {
			panelRegularMembershipLine = new Panel();
			panelRegularMembershipLine.setLayout(null);
			panelRegularMembershipLine.setBounds(new Rectangle(0, 78, 371, 4));
			panelRegularMembershipLine.setFont(new Font("Arial", Font.BOLD, 12));
			panelRegularMembershipLine.setMinimumSize(new Dimension(300, 4));
			panelRegularMembershipLine.setName("");
			panelRegularMembershipLine.setBackground(new Color(91, 155, 213));
		}
		return panelRegularMembershipLine;
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
						if (MainFrame.getPersonWhoLogin().getMembership().equals("Regular")){
							option1 = JOptionPane.showConfirmDialog(myFrame,
									"Sorry but, you are already a regular member of our hotel already.",
									"Confirmation",
									JOptionPane.PLAIN_MESSAGE);
						}
						else if (MainFrame.getPersonWhoLogin().getMembership().equals("Exquisite")){
							option1 = JOptionPane.showConfirmDialog(myFrame,
									"Sorry but, customers cannot downgrade their membership.",
									"Confirmation",
									JOptionPane.PLAIN_MESSAGE);

						}
						else if (MainFrame.getPersonWhoLogin().getPoints() >= points) {
								int newPoints = MainFrame.getPersonWhoLogin()
										.getPoints() - points;
								try {
									CustomerDAO.updateMembership("Regular",
											MainFrame.getPersonWhoLogin().getId());
									MainFrame.getPersonWhoLogin().setPoints(newPoints);
									MainFrame.getPersonWhoLogin().setMembership("Regular");
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
										"Congratulations! You are now a Regular member of our hotel!",
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
