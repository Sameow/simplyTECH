package simplytech.room;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import simplytech.dao.RoomServiceDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoomServices extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelRoomServices = null;
	private JButton jButtonLaundry = null;
	private JButton jButtonMaintenance = null;
	private JButton jButtonFnB = null;
	private JButton jButtonCleaning = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private String service;
	private int cleaning;
	private int maintenance;
	private int laundry;
	private String s;
	private String username;
	private int id;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public JFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(JFrame myFrame) {
		this.myFrame = myFrame;
	}

	/**
	 * This method initializes jButtonLaundry
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLaundry() {
		if (jButtonLaundry == null) {
			jButtonLaundry = new JButton();
			jButtonLaundry.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

				}
			});
			jButtonLaundry.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					laundry = JOptionPane.showConfirmDialog(myFrame,
							"You have called for Laundry Service.",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (laundry == JOptionPane.YES_OPTION) {
						s = "Laundry";
						setService(s);
					}

					simplytech.entity.RoomServices r = new simplytech.entity.RoomServices();
					r.setService(s);
					r.setUsername(username);
					r.setId(id);
					RoomServiceDAO.save(r);
				}

			});
			jButtonLaundry.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonLaundry.setText("Laundry");
			jButtonLaundry.setForeground(Color.black);
			jButtonLaundry.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonLaundry.setBackground(Color.white);
			jButtonLaundry.setIcon(new ImageIcon(RoomServices.class
					.getResource("/simplytech/image/Laundry.png")));
			jButtonLaundry.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonLaundry.setActionCommand("");
			jButtonLaundry.setLocation(new Point(177, 144));
			jButtonLaundry.setSize(new Dimension(181, 91));
			jButtonLaundry.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return jButtonLaundry;
	}

	/**
	 * This method initializes jButtonMaintenance
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMaintenance() {
		if (jButtonMaintenance == null) {
			jButtonMaintenance = new JButton();
			jButtonMaintenance.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
			jButtonMaintenance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maintenance = JOptionPane.showConfirmDialog(myFrame,
							"You have called for Maintenance Service.",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (maintenance == JOptionPane.YES_OPTION) {
						s = "Maintenance";
						setService(s);
					}
					simplytech.entity.RoomServices r = new simplytech.entity.RoomServices();
					r.setService(s);
					r.setUsername(username);
					r.setId(id);
					RoomServiceDAO.save(r);
				}
			});
			jButtonMaintenance.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonMaintenance.setForeground(Color.black);
			jButtonMaintenance.setText("Maintenance");
			jButtonMaintenance.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonMaintenance.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonMaintenance.setActionCommand("");
			jButtonMaintenance.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonMaintenance.setIcon(new ImageIcon(RoomServices.class
					.getResource("/simplytech/image/Maintenance.png")));
			jButtonMaintenance.setLocation(new Point(598, 145));
			jButtonMaintenance.setSize(new Dimension(181, 91));
			jButtonMaintenance.setBackground(Color.white);
		}
		return jButtonMaintenance;
	}

	/**
	 * This method initializes jButtonFnB
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFnB() {
		if (jButtonFnB == null) {
			jButtonFnB = new JButton();
			jButtonFnB.setBounds(new Rectangle(173, 344, 181, 91));
			jButtonFnB.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonFnB.setForeground(Color.black);
			jButtonFnB.setActionCommand("");
			jButtonFnB.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonFnB.setText("Menu");
			jButtonFnB.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonFnB.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonFnB.setIcon(new ImageIcon(RoomServices.class
					.getResource("/simplytech/image/FnB.png")));
			jButtonFnB.setBackground(Color.white);
			jButtonFnB.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()

					JPanel panel = new Menu(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonFnB;
	}

	/**
	 * This method initializes jButtonCleaning
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCleaning() {
		if (jButtonCleaning == null) {
			jButtonCleaning = new JButton();
			jButtonCleaning.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
			jButtonCleaning.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cleaning = JOptionPane.showConfirmDialog(myFrame,
							"You have called for Room Cleaning Service.",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (cleaning == JOptionPane.YES_OPTION) {
						s = "Cleaning";
						setService(s);
					}

					simplytech.entity.RoomServices r = new simplytech.entity.RoomServices();
					r.setService(s);
					r.setUsername(username);
					r.setId(id);
					RoomServiceDAO.save(r);
				}

			});
			jButtonCleaning.setBounds(new Rectangle(601, 342, 181, 91));
			jButtonCleaning.setForeground(Color.black);
			jButtonCleaning.setBackground(Color.white);
			jButtonCleaning.setText("Cleaning");
			jButtonCleaning.setVerticalAlignment(SwingConstants.BOTTOM);
			jButtonCleaning.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonCleaning.setIcon(new ImageIcon(RoomServices.class
					.getResource("/simplytech/image/broom.png")));
			jButtonCleaning.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonCleaning.setFont(new Font("Calibri", Font.BOLD, 24));
		}
		return jButtonCleaning;
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

	public void getRoomServices() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public RoomServices() {
		super();
		initialize();
	}

	public RoomServices(JFrame f) {
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

		username = MainFrame.getPersonWhoLogin().getUsername();
		id = MainFrame.getPersonWhoLogin().getId();
		
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(RoomServices.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// System.out.println("mouseClicked()"); // TODO Auto-generated
				// Event stub mouseClicked()
				JPanel panel = new Services(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelRoomServices = new JLabel();
		jLabelRoomServices.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelRoomServices.setLocation(new Point(60, 4));
		jLabelRoomServices.setSize(new Dimension(216, 35));
		jLabelRoomServices.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelRoomServices.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelRoomServices.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelRoomServices.setText("Room Services");
		jLabelRoomServices.setLocation(new Point(91, 23));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setAutoscrolls(false);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelRoomServices, null);
		this.add(getJButtonLaundry(), null);
		this.add(getJButtonMaintenance(), null);
		this.add(getJButtonFnB(), null);
		this.add(getJButtonCleaning(), null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);
		// add(getBtnCheck());
	}

	/**
	 * private JButton getBtnCheck() { if (btnCheck == null) { btnCheck = new
	 * JButton("Booked Services"); btnCheck.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
	 * 
	 * ArrayList<String> rs = new ArrayList<>(); String booked = null;
	 * 
	 * if (cleaning == JOptionPane.YES_OPTION) { rs.add("Cleaning"); } if
	 * (laundry == JOptionPane.YES_OPTION) { rs.add("Laundry"); } if
	 * (maintenance == JOptionPane.YES_OPTION) { rs.add("Maintenance"); }
	 * 
	 * for (int i = 0; i < rs.size(); i++) { booked = rs.get(i); } if (booked !=
	 * null) { JOptionPane.showMessageDialog(myFrame,
	 * "You've booked for the following services: \n" + booked,
	 * "Booked Services", JOptionPane.INFORMATION_MESSAGE); } else if (booked ==
	 * null) { JOptionPane.showMessageDialog(myFrame,
	 * "You've not call for any services."); }
	 * 
	 * } }); btnCheck.setFont(new Font("Calibri", Font.BOLD, 18));
	 * btnCheck.setBounds(400, 499, 162, 43); } return btnCheck; }
	 **/
} // @jve:decl-index=0:visual-constraint="4,-64"
