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

public class MBS extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelAttractionsLocation = null;
	private JLabel jLabelPicture = null;
	private JLabel jLabelLocation = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;

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
	public MBS() {
		super();
		initialize();
	}

	public MBS(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(MBS.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// System.out.println("mouseClicked()"); // TODO Auto-generated
				// Event stub mouseClicked()
				JPanel panel = new Attractions(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelLocation = new JLabel();
		jLabelLocation.setBounds(new Rectangle(435, 132, 391, 34));
		jLabelLocation.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelLocation.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelLocation.setBackground(new Color(91, 155, 231));
		jLabelLocation.setForeground(new Color(51, 51, 51));
		jLabelLocation.setText("Marina Bay Sands");
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
		jLabelPicture.setIcon(new ImageIcon(MBS.class
				.getResource("/simplytech/image/Marina_bay_sands.JPG")));
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
				.setText("Marina Bay Sands is an Integrated Resort fronting Marina Bay in Singapore. Developed by Las Vegas Sands, it is billed as the world's most expensive standalone casino property at S$8 billion, including cost of the prime land.\r\n\r\nWith the casino complete, the resort features a 2,561-room hotel, a 1,300,000-square-foot (120,000 m2) convention-exhibition centre, the 800,000-square-foot (74,000 m2) The Shoppes at Marina Bay Sands mall, a museum, two large theatres, seven \"celebrity chef\" restaurants, two floating Crystal Pavilions, an ice skating rink, and the world's largest atrium casino with 500 tables and 1,600 slot machines. The complex is topped by a 340m-long SkyPark with a capacity of 3,900 people and a 150m infinity swimming pool, set on top of the world's largest public cantilevered platform, which overhangs the north tower by 67m. The 20-hectare resort was designed by Moshe Safdie Architects. The local architect of record was Aedas Singapore, and engineering was provided by Arup and Parsons Brinkerhoff (MEP). The main contractor was Ssangyong Engineering and Construction.\r\n\r\nOriginally set to open in 2009, Las Vegas Sands faced delays caused by escalating costs of material and labour shortages from the onset. The severe global financial crisis also pressured the company to delay its projects elsewhere to complete the integrated resort. Although Marina Bay Sands has been compared on scale and development costs to MGM's CityCenter, the latter is a mixed-use development, with condominium properties (comprising three of the seven main structures) being sold off.\r\n\r\nThe resort and SkyPark were officially opened on 23 and 24 June 2010 as part of a two-day celebration, following the casino's opening on 27 April that year. The SkyPark opened the following day. The theatres were completed in time for the first performance by Riverdance on 30 November. The indoor skating rink, which uses artificial ice, opened to a performance by Michelle Kwan on 18 December. The ArtScience Museum opened to the public and the debut of a 13-minute light, laser and water spectacle called Wonder Full on 19 February 2011 marked the full completion of the entire Integrated Resort.\r\n\r\nThe grand opening of Marina Bay Sands was held on 17 February 2011. It also marked the opening of the seven celebrity chef restaurants. The highly-anticipated Broadway musical The Lion King debuted on 3 March 2011. The last portion of the Marina Bay Sands, the floating pavilions, were finally opened to the public when the two tenants, Louis Vuitton and Pangaea Club, opened on 18 and 22 September 2011 respectively.");
		scrollPane.setViewportView(txtrGardensByThe);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_3.addTab("Directions", null, scrollPane_1, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabbedPane);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("By water taxi", null, scrollPane_3, null);

		JTextArea txtrFromEastCoast = new JTextArea();
		txtrFromEastCoast
				.setText("Water taxis can be taken from Grand Copthorne Water Front, Raffles Landing Side, Boat Quay, River Side Point and Robertson Quay to Marina Bay Sands. Ticket ranges from SGD$4 to SGD$16.");
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
		txtrViaTheCircle
				.setText("Via the North-South Line:\r\n-4 mins walk from the Marina Bay.\r\n\r\nVia the Circle Line:\r\n-10 mins walk from Promenade on the Circle Line.\r\n\r\n-Bayfront on the Circle Line, operational in 14 January 2012 and upcoming Downtown Line, operational in 2013.");
		scrollPane_4.setViewportView(txtrViaTheCircle);

		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("By Bus", null, scrollPane_5, null);

		JTextArea txtrFromTheHelix = new JTextArea();
		txtrFromTheHelix.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrFromTheHelix.setWrapStyleWord(true);
		txtrFromTheHelix.setLineWrap(true);
		txtrFromTheHelix
				.setText("Services 97/97e, 106, 133, 502/502A, 518/518A, NR1 (Available on Fridays, Saturdays and eve of Public Holidays), and NR6 (Available on Fridays, Saturdays and eve of Public Holidays).");
		scrollPane_5.setViewportView(txtrFromTheHelix);
	}
}
