package simplytech.room;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class GBB extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelAttractionsLocation = null;
	private JLabel jLabelPicture = null;
	private JLabel jLabelLocation = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public GBB() {
		super();
		initialize();
	}

	public GBB(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(GBB.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					start = calendar.getInstance().getTimeInMillis();
				}
				public void mouseReleased(MouseEvent arg0) {
					stop = calendar.getInstance().getTimeInMillis();
					if (stop - start < 500) {
						JPanel panel = new Attractions(myFrame);
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
		jLabelLocation = new JLabel();
		jLabelLocation.setBounds(new Rectangle(435, 132, 391, 34));
		jLabelLocation.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelLocation.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelLocation.setBackground(new Color(91, 155, 231));
		jLabelLocation.setForeground(new Color(51, 51, 51));
		jLabelLocation.setText("Gardens by the Bay");
		jLabelLocation.setOpaque(true);
		jLabelAttractionsLocation = new JLabel();
		jLabelAttractionsLocation
				.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelAttractionsLocation
				.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelAttractionsLocation.setText("Attractions ");
		jLabelAttractionsLocation.setLocation(new Point(91, 23));
		jLabelAttractionsLocation.setSize(new Dimension(238, 35));
		jLabelAttractionsLocation.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		jLabelPicture = new JLabel();
		jLabelPicture.setBounds(new Rectangle(60, 114, 331, 436));
		jLabelPicture.setIcon(new ImageIcon(GBB.class
				.getResource("/simplytech/image/GBB.png")));
		jLabelPicture.setText("");
		this.add(jLabelPicture, null);
		this.add(jLabelAttractionsLocation, null);
		this.add(jLabelLocation, null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBorder(new LineBorder(SystemColor.activeCaptionText, 3,
				true));
		tabbedPane_3.setFont(new Font("Calibri", Font.BOLD, 15));
		tabbedPane_3.setBounds(435, 166, 391, 377);
		add(tabbedPane_3);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_3.addTab("Informations", null, scrollPane, null);

		JTextArea txtrGardensByThe = new JTextArea();
		txtrGardensByThe.setWrapStyleWord(true);
		txtrGardensByThe.setLineWrap(true);
		txtrGardensByThe.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrGardensByThe
				.setText("Gardens by the Bay brings to life NParks' vision of creating a City in a Garden. The Gardens captures the essence of Singapore as the premier tropical Garden City with the perfect environment in which to live and work - making Singapore a leading global city of the 21st century.\r\n\r\nIn January 2006, an international master plan design competition was launched to seek world-class design ideas for Gardens by the Bay. It drew more than 70 entries submitted by 170 firms, from over 24 countries, including 35 from Singapore.\r\n\r\nAn 11-member Jury comprising local and international experts shortlisted eight teams and two winners were announced in September 2006; namely Grant Associates for Bay South and Gustafson Porter for Bay East, both from the UK. A decision was made to develop Bay Central later.\r\n\r\nA public exhibition of the master plan concepts and models of the winning teams was held in September 2006 at the Singapore Botanic Gardens. Over 10,000 people visited the exhibition and over 700 gave their feedback. An overwhelming majority 85% of those surveyed liked the features in the master plans and over 97% said they would visit the gardens.\r\n\r\nBay South Gardens broke ground in November 2007, signalling the commencement of the Gardens\u2019 development. Subsequently, development of Bay East Gardens also commenced. It was developed as an interim garden to be used as a staging site for some of the rowing and canoeing events of the Youth Olympic Games (YOG) in August 2010. Following the YOG, Bay East underwent reinstatement works and was open to the public in October 2011.\r\n\r\nA special preview of parts of Bay South Gardens, including the Flower Dome, was held in November 2011 in conjunction with the World Orchid Conference (WOC). Some 300,000 members of the public visited both WOC and Bay \r\nSouth Gardens.");
		scrollPane.setViewportView(txtrGardensByThe);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_3.addTab("Directions", null, scrollPane_1, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabbedPane);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("By Car/Taxi", null, scrollPane_3, null);

		JTextArea txtrFromEastCoast = new JTextArea();
		txtrFromEastCoast
				.setText("From East Coast Parkway (ECP) heading towards the city:\r\nTake Exit 17A and turn left onto Marina Place\r\nContinue through to Marina Boulevard\r\nTurn left at Marina Gardens Drive\r\n\r\nFrom East Coast Parkway (ECP) heading towards Changi Airport:\r\nTake Exit 17 and turn right onto Central Boulevard\r\nTurn right onto Marina Station Road\r\nTurn left onto Marina Street\r\nFollow through onto Marina Boulevard\r\nTurn left at Marina Gardens Drive");
		txtrFromEastCoast.setWrapStyleWord(true);
		txtrFromEastCoast.setLineWrap(true);
		txtrFromEastCoast.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane_3.setViewportView(txtrFromEastCoast);

		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("By MRT/Bus", null, scrollPane_4, null);

		JTextArea txtrViaTheCircle = new JTextArea();
		txtrViaTheCircle.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrViaTheCircle.setWrapStyleWord(true);
		txtrViaTheCircle.setLineWrap(true);
		txtrViaTheCircle
				.setText("Via the Circle Line:\r\nAlight at Bayfront MRT Station (CE1)\r\nTake exit B and follow the underground linkway\r\nExit and cross the Dragonfly Bridge into Gardens by the Bay\r\n\r\nVia the North-South Line:\r\nAlight at Marina Bay MRT (NS27/CE2) station\r\nTake exit A and hop onto bus service 400\r\nAlight 4 stops later at the bus stop along Marina Gardens Drive");
		scrollPane_4.setViewportView(txtrViaTheCircle);

		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("Walking", null, scrollPane_5, null);

		JTextArea txtrFromTheHelix = new JTextArea();
		txtrFromTheHelix.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrFromTheHelix.setWrapStyleWord(true);
		txtrFromTheHelix.setLineWrap(true);
		txtrFromTheHelix
				.setText("From the Helix Bridge towards the Art Science Museum:\r\nFollow the footpath which leads under the ECP, that will bring you directly into Bay South Garden along the waterfront.\r\n\r\nFrom Marina Bay Sands Expo and Convention Centre:\r\nWalk across the Lions Bridge on Level 4 which connects to the Dragonfly Bridge into Bay South Garden.\r\n");
		scrollPane_5.setViewportView(txtrFromTheHelix);

		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_3.addTab("Pricing", null, scrollPane_2, null);

		JTextArea txtrOutdoorGardensRates = new JTextArea();
		txtrOutdoorGardensRates
				.setText("Outdoor Gardens\r\n\r\nRates:  \tFree Admission\r\nHours:  \tDaily\r\n05:00 AM - 02:00 AM\r\n\r\nConservatories\r\n\r\nRates:  \tFrom $8 - $28\r\nHours:  \tDaily\r\n09:00 AM - 09:00 PM\r\nLast ticket sale at 08:00 PM \r\nLast admission at 08:30 PM\r\n\r\nOCBC Skyway\r\n\r\nRates:   \t\r\nFrom $3 - $5\r\n\r\nHours:  \t\r\nMonday - Friday\r\n09:00 AM - 09:00 PM\r\nLast ticket sale at 08:00 PM\r\nLast admission at 08:30 PM\r\n\r\nWeekends & PH\r\n09:00 AM - 09:00 PM\r\nLast ticket sale at 07:00 PM\r\nLast admission at 07:30 PM\r\n");
		txtrOutdoorGardensRates.setWrapStyleWord(true);
		txtrOutdoorGardensRates.setLineWrap(true);
		txtrOutdoorGardensRates.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane_2.setViewportView(txtrOutdoorGardensRates);
	}
}
