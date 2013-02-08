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

public class esplanade extends JPanel {

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
	public esplanade() {
		super();
		initialize();
	}

	public esplanade(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(esplanade.class
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
		jLabelLocation.setText("Esplanade");
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
		jLabelPicture.setIcon(new ImageIcon(esplanade.class
				.getResource("/simplytech/image/esplanade.JPG")));
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
				.setText("Esplanade \u2013 Theatres on the Bay is a waterside building located on six hectares of waterfront land alongside Marina Bay near the mouth of the Singapore River, purpose-built to be the centre for performing arts for the island nation of Singapore. Taking its name from the nearby Esplanade, it contains a Concert Hall which seats about 1,600 and a Theatre with a capacity of about 2,000 for the performing arts.\r\n\r\nThe library@esplanade is located on the third floor of the building. There are outdoor performing centres, and retail and food space at the Esplanade Mall. There is an outdoor open space on the fourth floor of the building, which is the highest point open to the public.\r\n\r\nAs one of the world\u2019s busiest arts centres, Esplanade offers a staggering range of programmes which caters to all audiences. In addition to Esplanade Presents performances, other offerings by diverse presenters complement the programmes at the centre, ensuring that there is something for everyone.\r\n\r\nEsplanade\u2019s programmes are broadly organised around key areas \u2013 the community and access programmes form the foundation of activities at the centre, collaborations with mainly local arts groups help develop the industry, while leading international productions offer innovative programmes in the major arts genres. These programmes are presented in different festivals and series designed to appeal to the broadest range of audiences.\r\n\r\nEsplanade's in-house programming team presents over 14 festivals and 20 on-going series throughout the year. As a centre for everyone, the programmes range from PLAYtime! for 2 to 4 year olds, Bitesize - a monthly talk and workshop taster series for a range of Arts topics, to At The Concourse - a non-ticketed music series that runs everyday of the year, as well as Coffee Morning Afternoon Tea - concerts featuring nostalgic English and Chinese golden hits by veteran local artists.");
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
				.setText("The Esplanade is easily accessible via public buses. \r\n\r\nBus numbers: 36, 56, 70M, 97, 111, 133, 162M, 195, 502, 531, 1N, 2N, 3N, 4N, 5N, 6N, 75, 77, 106, 700A, 857, 960, 961, NR1, NR2, NR5, NR6, NR7, NR8. \r\n\r\nThe nearest bus stop is also located along Raffles Avenue, outside the Esplanade Mall entrance. \r\n");
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
				.setText("Esplanade is just a 10-minute walk from the City Hall and Esplanade Circle Line (Exit D) Stations through an underpass which also links four shopping centres \u2013Citylink, Raffles City, Marina Square, SuntecCity and MilleniaWalk. ");
		scrollPane_4.setViewportView(txtrViaTheCircle);
	}
}
