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

public class somerset313 extends JPanel {

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
	public somerset313() {
		super();
		initialize();
	}

	public somerset313(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(somerset313.class
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
		jLabelLocation.setText("313 @ Somerset");
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
		jLabelPicture.setIcon(new ImageIcon(somerset313.class
				.getResource("/simplytech/image/313.jpg")));
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
				.setText("About 313@somerset\r\n313@somerset is one of the first major retail developments undertaken by Lend Lease in Asia and delivered through its fully integrated property business model of which Lend Lease provides investment management, development, project management and construction, to asset and property management services . It is a significant milestone for the Lend Lease Group as it marks its first green field development in Asia and its first development in Singapore\u2019s premier shopping street \u2013 Orchard Road.\r\n \r\nFashion\r\nEmbracing Singaporeans\u2019 passion for fashion, 313@somerset assembles an exceptional range of leading global and local brands that deliver a unique, expansive and aspirational mid level fashion offer including Zara, Uniqlo, Forever 21, New Look and Esprit.\r\n \r\nFood\r\nThe 3 unique dining precincts will create a landmark entertainment offer catering to all tastes and appetites:\r\n \r\nDiscovery Walk\r\nThis unique themed precinct directly linked to the Orchard Road strip will offer an enviable clustering of restaurants and lounges including Brotzeit German Bier Bar & Restaurant, Yomenya Goemon, JiBiru Japanese Craft Beer Bar, March\u00E9 Restaurant & Natural Bakery, Malones Irish Restaurant and Bar, Absolute Thai and Trattoria Italian Kitchen. This \u201CWalking Street\u201D will reflect a relaxed ambience and sanctuary from the Orchard Road bustle.\r\n \r\nFood Hall\r\nLocated on B3 and anchored by Cold Storage Specialty and Guardian Health & Beauty, the Food Hall is ideally positioned to offer a convenient one-stop shop for every day fresh food produce and a wide selection of takeaway foods and casual restaurants including Din Tai Fung, F.I.S.H., Hot Tomato Caf\u00E9 & Grill, Paradise Inn and Tarafuku Japanese Buffet Restaurant.\r\n \r\nFood Court\r\nSituated on Level 5, the Food Court will be the next generation food dining experience with the largest Food Republic outlet including 21 stalls and 5 mini-restaurants, reflecting a predominantly Asian influence.\r\n \r\nLifestyle\r\nIndulging the Singaporean market\u2019s fascination with all things new, 313@somerset assembles an eclectic mix of leading lifestyle stores including EpiCentre (Apple Premium Reseller), EpiLife, HMV, Smiggle, Stadium and Starhub.\r\n \r\nLevels\r\n8 retail levels in total\r\n3 basement levels (B3 to B1), with direct access to Somerset MRT station at B2\r\n5 levels above ground (L1 to L5)\r\n \r\nRetail\r\n177 outlets\r\n \r\nStreet Frontage\r\n95 metres direct frontage to Orchard Road\r\n70 metres direct frontage to Somerset Road\r\n \r\nNLA\r\n294,000 sq ft of retail offer\r\n \r\nParking\r\n228 car park bays on L6 & L7");
		scrollPane.setViewportView(txtrGardensByThe);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_3.addTab("Directions", null, scrollPane_1, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabbedPane);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("By Bus", null, scrollPane_3, null);

		JTextArea txtrFromEastCoast = new JTextArea();
		txtrFromEastCoast
				.setText("Orchard Road\r\n7, 14, 14E, 16, 65, 106, 111, 123, 175, 502, 502A, 502B\r\n\r\nSomerset Road\r\n7, 14, 14E, 16, 36, 65, 77, 106, 111, 123, 124, 128, 143, 162, 162M, 167, 171, 174, 174E, 175, 190,\r\n502, 502A, 502B, 700, 700A");
		txtrFromEastCoast.setWrapStyleWord(true);
		txtrFromEastCoast.setLineWrap(true);
		txtrFromEastCoast.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane_3.setViewportView(txtrFromEastCoast);

		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("By MRT", null, scrollPane_4, null);

		JTextArea txtrViaTheCircle = new JTextArea();
		txtrViaTheCircle.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrViaTheCircle.setWrapStyleWord(true);
		txtrViaTheCircle.setLineWrap(true);
		txtrViaTheCircle.setText("Somerset MRT Station (North-South line)");
		scrollPane_4.setViewportView(txtrViaTheCircle);
	}
}
