package simplytech.room;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class Services extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelServices = null;
	private JButton jButtonBooking = null;
	private JButton jButtonRoomService = null;
	private JButton jButtonAlarmClock = null;
	private JButton jButtonPointRewardSystem = null;
	private JFrame myFrame = null;
	private JLabel jLabelServiceBackground = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;

	/**
	 * This method initializes jLabelServices
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabelServices() {
		if (jLabelServices == null) {
			jLabelServices = new JLabel();
			jLabelServices.setText("Services");
			jLabelServices.setHorizontalAlignment(SwingConstants.LEADING);
			jLabelServices.setHorizontalTextPosition(SwingConstants.LEADING);
			jLabelServices.setLocation(new Point(91, 23));
			jLabelServices.setSize(new Dimension(216, 35));
			jLabelServices.setFont(new Font("Arial", Font.BOLD, 28));
		}
		return jLabelServices;
	}

	/**
	 * This method initializes jButtonBooking
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBooking() {
		if (jButtonBooking == null) {
			jButtonBooking = new JButton();
			jButtonBooking.setBackground(new Color(91, 155, 231));
			jButtonBooking.setLocation(new Point(262, 105));
			jButtonBooking.setSize(new Dimension(200, 200));
			jButtonBooking.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonBooking.setForeground(new Color(0, 0, 0));
			jButtonBooking.setForeground(Color.white);
			jButtonBooking.setText("Booking");
			jButtonBooking
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JPanel panel = new Booking(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonBooking;
	}

	/**
	 * This method initializes jButtonRoomService
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRoomService() {
		if (jButtonRoomService == null) {
			jButtonRoomService = new JButton();
			jButtonRoomService.setBackground(new Color(91, 155, 231));
			jButtonRoomService.setLocation(new Point(545, 107));
			jButtonRoomService.setSize(new Dimension(200, 200));
			jButtonRoomService.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonRoomService.setForeground(Color.white);
			jButtonRoomService.setText("Room Services");
			jButtonRoomService
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JPanel panel = new RoomServices(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}

					});
		}
		return jButtonRoomService;
	}

	/**
	 * This method initializes jButtonAlarmClock
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAlarmClock() {
		if (jButtonAlarmClock == null) {
			jButtonAlarmClock = new JButton();
			jButtonAlarmClock.setBackground(new Color(91, 155, 231));
			jButtonAlarmClock.setLocation(new Point(545, 331));
			jButtonAlarmClock.setSize(new Dimension(200, 200));
			jButtonAlarmClock.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonAlarmClock.setForeground(Color.white);
			jButtonAlarmClock.setText("Alarm Clock");
			jButtonAlarmClock
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JPanel panel = new AlarmClock(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonAlarmClock;
	}

	/**
	 * This method initializes jButtonPointRewardSystem
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonPointRewardSystem() {
		if (jButtonPointRewardSystem == null) {
			jButtonPointRewardSystem = new JButton();
			jButtonPointRewardSystem.setBackground(new Color(91, 155, 231));
			jButtonPointRewardSystem.setLocation(new Point(262, 329));
			jButtonPointRewardSystem.setSize(new Dimension(200, 200));
			jButtonPointRewardSystem.setForeground(Color.white);
			jButtonPointRewardSystem
					.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonPointRewardSystem
					.setHorizontalAlignment(SwingConstants.CENTER);
			jButtonPointRewardSystem.setText("Redemption\r\n");
			jButtonPointRewardSystem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JPanel panel = new PointsRewardSystemPanel2(myFrame, "Services");
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonPointRewardSystem;
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public Services() {
		super();
		initialize();
	}

	public Services(JFrame f) {
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
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(Services.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// System.out.println("mouseClicked()"); // TODO Auto-generated
				// Event stub mouseClicked()
				JPanel panel = new RoomHomePagePanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJButtonRoomService(), null);
		this.add(getJLabelServices(), null);
		this.add(getJButtonBooking(), null);
		this.add(getJButtonAlarmClock(), null);
		this.add(getJButtonPointRewardSystem(), null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);
	}

} // @jve:decl-index=0:visual-constraint="11,16"
