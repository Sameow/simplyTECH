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

public class botanicGarden extends JPanel {

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
	public botanicGarden() {
		super();
		initialize();
	}

	public botanicGarden(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(botanicGarden.class
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
		jLabelLocation.setText("Botanic Garden");
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
		jLabelPicture.setBounds(new Rectangle(56, 114, 331, 436));
		jLabelPicture.setIcon(new ImageIcon(botanicGarden.class
				.getResource("/simplytech/image/botanic-garden.jpg")));
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
				.setText("The Singapore Botanic Gardens is a dynamic and living monument to the foresight of the founding fathers of Singapore. Sir Stamford Raffles, the founder of Singapore and a keen naturalist, established the first botanical and experimental garden on Government Hill (Fort Canning Hill) in 1822, shortly after his arrival in Singapore. He aimed to introduce cultivation of economic crops such as cocoa and nutmeg. However, without a full-time salaried director and sufficient funding, the garden languished and was closed in 1829, after Raffles' death.");
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
				.setText("By Car: \r\nCar Parking Facilities are available at the Singapore Botanic Gardens' Visitor Centre, Bukit Timah Car Park at Bukit Timah Core, Botany Centre, Jacob Ballas Children's Garden and Public Parking along Tyersall Avenue.\r\n\r\nBy Taxi:\r\nThere is a Taxi Drop-Off and Pick-Up point at the Visitor Centre along Cluny Road.");
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
				.setText("By Mass Rapid Transit (MRT, Circle Line):\r\nAlight at Eco Garden (North end of the Gardens) via the Botanic Gardens Station. \r\n\r\nThis new station along the Circle Line brings you closer to the junction of Bukit Timah and Cluny Park Road and provides you access to the NUS School of Law. \r\n\r\nBy Bus:\r\nGet to the Gardens by Public Bus\r\nvia Holland Road or Bukit Timah Road.\r\n\r\nVia Holland Road\r\nSBS Transit 7, 105, 123, 174\r\nSMRT 75, 77, 106\r\n\r\nVia Bukit Timah Road\r\nSBS Transit 48, 66, 151, 153, 154, 156, 170\r\nSMRT 67, 171");
		scrollPane_4.setViewportView(txtrViaTheCircle);

		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("By Coach", null, scrollPane_6, null);

		JTextArea txtrACoachDropoff = new JTextArea();
		txtrACoachDropoff.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrACoachDropoff.setWrapStyleWord(true);
		txtrACoachDropoff.setLineWrap(true);
		txtrACoachDropoff
				.setText("a) Coach Drop-off Point is located at the Singapore Botanic Gardens' Visitor Centre, the Ginger Garden Coach Drop-off Point and Jacob Ballas Children's Garden. \r\n\r\nb) Coach Parking is available at the Singapore Botanic Gardens' Visitor Centre, Tyersall Avenue Public Coach Park and Jacob Ballas Children's Garden.");
		scrollPane_6.setViewportView(txtrACoachDropoff);

		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("Walking", null, scrollPane_5, null);

		JTextArea txtrFromTheHelix = new JTextArea();
		txtrFromTheHelix.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrFromTheHelix.setWrapStyleWord(true);
		txtrFromTheHelix.setLineWrap(true);
		txtrFromTheHelix
				.setText("Entrance to the Gardens is easy through the Gardens' major entrances: Tanglin Gate, Burkill Gate, Nassim Gate and Cluny Park Gate, and through the Bukit Timah Entrance.");
		scrollPane_5.setViewportView(txtrFromTheHelix);

		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_3.addTab("Pricing", null, scrollPane_2, null);

		JTextArea txtrOutdoorGardensRates = new JTextArea();
		txtrOutdoorGardensRates
				.setText("Singapore Botanic Gardens\r\n\r\nOpening hours:\t5 am to 12 midnight daily\r\nAdmission Fee:\tFree\r\n\r\n\r\nNational Orchid Garden\r\n\r\nOpening hours:\t8.30 am to 7 pm daily (last ticket sale at 6pm).\r\nAdmission Fee:\t\r\nAdults\t \t $5.00\r\nStudents\t \t$1.00\r\nSenior Citizens(60 years and Above)\t \t$1.00\r\nChildren (below 12 years)\t \tFree\r\n\r\n\r\nJacob Ballas Children's Garden \r\n\r\nOpening hours:\t\r\n8.00am - 7.00pm (last admission at 6.30pm)\r\nThe Children's Garden is closed on Mondays (except when it falls on a designated public holiday)\r\n\r\nAdmission Fee:\t\r\nFree\r\nThe Children's Garden is open to children up to 12 years old. All children have to be accompanied by an adult.\r\n\r\n\r\nLibrary of Botany and Horticulture\r\n\r\nPlease note that the Library will be closed on Saturdays and Sundays from 2 July 2012 onwards.\r\nOpening hours:\tMondays to Fridays\r\nWeekends & Public Holidays\t9.00am - 5.00pm \r\nClosed");
		txtrOutdoorGardensRates.setWrapStyleWord(true);
		txtrOutdoorGardensRates.setLineWrap(true);
		txtrOutdoorGardensRates.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane_2.setViewportView(txtrOutdoorGardensRates);
	}
}
