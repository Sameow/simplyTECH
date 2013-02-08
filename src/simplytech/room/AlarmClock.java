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
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
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
	private int displayHr = 0;
	private int displayMin = 0;
	private int totalMin;
	private final Timer timer = new Timer();
	private Calendar calendar;
	private long start;
	private long stop;

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

	public AlarmClock(int totalMin) {
		this.totalMin = totalMin;
	}

	public void start() {
		timer.schedule(new TimerTask() {
			public void run() {
				timeUp();
				timer.cancel();
			}

			private void timeUp() {
				JOptionPane.showMessageDialog(myFrame, "Time's Up!!");
			}
		}, totalMin * 60 * 1000);
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
		if (AlarmClockDAO.searchById(id) != null) {
			displayHr = AlarmClockDAO.searchById(id).getHour();
			displayMin = AlarmClockDAO.searchById(id).getMinute();
		}
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(AlarmClock.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start = calendar.getInstance().getTimeInMillis();
			}
			public void mouseReleased(MouseEvent arg0) {
				stop = calendar.getInstance().getTimeInMillis();
				if (stop - start < 500) {
					JPanel panel = new RoomServices(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				} else {
					JPanel panel = new RoomHomePagePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
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

					totalMin = (hour * 60) + minute;
					AlarmClock alarmClock = new AlarmClock(totalMin);
					alarmClock.start();

				} else
					AlarmClockDAO.removeByUserName(username);
			}
		});

		btnSetAlarm.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSetAlarm.setBounds(359, 459, 233, 51);
		add(btnSetAlarm);

		JPanel panelToggle = new JPanel();
		panelToggle.setBounds(321, 141, 304, 81);
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
		panelAlarm.setBounds(263, 247, 436, 162);
		panelAlarm.setOpaque(true);
		panelAlarm.setBackground(new Color(227, 228, 250));
		add(panelAlarm);
		panelAlarm.setLayout(null);

		JLabel lblHour = new JLabel("Hour");
		lblHour.setBounds(179, 69, 83, 35);
		panelAlarm.add(lblHour);
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setFont(new Font("Calibri", Font.BOLD, 24));

		JLabel lblMinute = new JLabel("Minutes");
		lblMinute.setBounds(343, 69, 83, 35);
		panelAlarm.add(lblMinute);
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinute.setFont(new Font("Calibri", Font.BOLD, 24));

		lblHourField = new JLabel("" + displayHr);
		lblHourField.setBounds(114, 52, 73, 71);
		panelAlarm.add(lblHourField);
		lblHourField.setForeground(SystemColor.text);
		lblHourField.setFont(new Font("Calibri", Font.BOLD, 20));
		lblHourField.setHorizontalAlignment(SwingConstants.CENTER);
		lblHourField.setOpaque(true);
		lblHourField.setBackground(new Color(91, 155, 213));
		lblHourField.setLabelFor(lblHour);

		lblMinField = new JLabel("" + displayMin);
		lblMinField.setBounds(260, 52, 73, 71);
		panelAlarm.add(lblMinField);
		lblMinField.setForeground(SystemColor.text);
		lblMinField.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinField.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMinField.setOpaque(true);
		lblMinField.setBackground(new Color(91, 155, 213));
		lblMinField.setLabelFor(lblMinute);

		JLabel lblLeft = new JLabel("Alert in");
		lblLeft.setBounds(10, 56, 94, 58);
		panelAlarm.add(lblLeft);
		lblLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeft.setFont(new Font("Calibri", Font.BOLD, 24));
	}
} // @jve:decl-index=0:visual-constraint="-7,12"
