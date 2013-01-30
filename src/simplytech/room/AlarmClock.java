package simplytech.room;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import simplytech.dao.AlarmClockDAO;
import javax.swing.JCheckBox;

public class AlarmClock extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelAlarmClock = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JLabel lblHourField = null;
	private JLabel lblMinField = null;
	JCheckBox off = null;
	int hour;
	int minute;
	private String username;
	private int id;

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
	 * This is the default constructor
	 */
	public AlarmClock() {
		super();
		initialize();
	}

	public AlarmClock(JFrame f) {
		this();
		myFrame = f;
		initialize();
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getHour() {

		return hour;
	}

	public void setMinute(int minute) {

		this.minute = minute;
	}

	public int getMinute() {

		return minute;
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
		jLabelBack.setIcon(new ImageIcon(AlarmClock.class
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
		jLabelAlarmClock = new JLabel();
		jLabelAlarmClock.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelAlarmClock.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelAlarmClock.setText("Alarm Clock");
		jLabelAlarmClock.setLocation(new Point(91, 23));
		jLabelAlarmClock.setSize(new Dimension(216, 35));
		jLabelAlarmClock.setBackground(new Color(227, 228, 250));
		jLabelAlarmClock.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelAlarmClock.setOpaque(true);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelAlarmClock, null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);

		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (off.isSelected() == false) {

					do {
						hour = Integer.parseInt(JOptionPane.showInputDialog(
								myFrame, "Enter hour(00-23):",
								"Set Alarm - Hour", JOptionPane.YES_NO_OPTION));
					} while (hour < 00 || hour > 23);
					setHour(hour);
					String hourstr = "" + hour;
					lblHourField.setText(hourstr);

					do {
						minute = Integer.parseInt(JOptionPane
								.showInputDialog(myFrame,
										"Enter minute(00-59):",
										"Set Alarm - Minute",
										JOptionPane.YES_NO_OPTION));
					} while (minute < 00 || minute > 59);
					setMinute(minute);
					String minstr = "" + minute;
					lblMinField.setText(minstr);

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								// myFrame.setVisible(true);
								lblMinField.repaint();
								lblHourField.repaint();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

					// lblHourField.paintImmediately(lblHourField.getVisibleRect());
					// .paintImmediately(lblMinField.getVisibleRect());
					// lblHourField.validate();
					// lblMinField.validate();
					// lblMinField.repaint();
					// lblHourField.repaint();

					simplytech.entity.AlarmClock alarm = new simplytech.entity.AlarmClock();
					alarm.setUsername(username);
					alarm.setHour(hour);
					alarm.setMinute(minute);
					alarm.setId(id);
					AlarmClockDAO.save(alarm);
				} else
					AlarmClockDAO.removeByUserName(username);
			}
		});

		btnSetAlarm.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSetAlarm.setBounds(426, 451, 233, 51);
		add(btnSetAlarm);

		JPanel panelToggle = new JPanel();
		panelToggle.setBounds(379, 144, 304, 81);
		panelToggle.setOpaque(true);
		panelToggle.setBackground(new Color(227, 228, 250));
		add(panelToggle);
		panelToggle.setLayout(null);

		off = new JCheckBox("OFF");
		off.setBounds(115, 34, 69, 40);
		panelToggle.add(off);
		off.setHorizontalAlignment(SwingConstants.CENTER);
		off.setFont(new Font("Calibri", Font.BOLD, 18));
		off.setOpaque(true);
		off.setBackground(new Color(227, 228, 250));

		JLabel lblToggleAlarm = new JLabel("Toggle Alarm");
		lblToggleAlarm.setFont(new Font("Calibri", Font.BOLD, 24));
		lblToggleAlarm.setHorizontalAlignment(SwingConstants.CENTER);
		lblToggleAlarm.setBounds(57, 0, 190, 40);
		panelToggle.add(lblToggleAlarm);

		JPanel panelAlarm = new JPanel();
		panelAlarm.setBounds(320, 258, 422, 162);
		panelAlarm.setOpaque(true);
		panelAlarm.setBackground(new Color(227, 228, 250));
		add(panelAlarm);
		panelAlarm.setLayout(null);

		JLabel lblHour = new JLabel("Hour");
		lblHour.setBounds(73, 5, 83, 35);
		panelAlarm.add(lblHour);
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel lblMinute = new JLabel("Minutes");
		lblMinute.setBounds(272, 5, 83, 35);
		panelAlarm.add(lblMinute);
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinute.setFont(new Font("Calibri", Font.BOLD, 18));

		lblHourField = new JLabel("" + getHour());
		lblHourField.setBounds(83, 51, 73, 71);
		panelAlarm.add(lblHourField);
		lblHourField.setForeground(SystemColor.text);
		lblHourField.setFont(new Font("Calibri", Font.BOLD, 20));
		lblHourField.setHorizontalAlignment(SwingConstants.CENTER);
		lblHourField.setOpaque(true);
		lblHourField.setBackground(new Color(91, 155, 213));
		lblHourField.setLabelFor(lblHour);

		lblMinField = new JLabel("" + getMinute());
		lblMinField.setBounds(282, 51, 73, 71);
		panelAlarm.add(lblMinField);
		lblMinField.setForeground(SystemColor.text);
		lblMinField.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinField.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMinField.setOpaque(true);
		lblMinField.setBackground(new Color(91, 155, 213));
		lblMinField.setLabelFor(lblMinute);
	}
} // @jve:decl-index=0:visual-constraint="-7,12"
