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

public class hawParVilla extends JPanel {

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
	public hawParVilla() {
		super();
		initialize();
	}

	public hawParVilla(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(hawParVilla.class
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
		jLabelLocation.setText("Haw Par Villa");
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
		jLabelPicture.setIcon(new ImageIcon(hawParVilla.class
				.getResource("/simplytech/image/haw-par-villaJPG.JPG")));
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
				.setText("Haw Par Villa is a theme park located along Pasir Panjang Road, Singapore. The park contains over 1,000 statues and 150 giant dioramas depicting scenes from Chinese mythology, folklore, legends, history, and illustrations of various aspects of Confucianism.\r\nThe park, originally called \"Tiger Balm Gardens\", was built in 1937 by the Burmese brothers Aw Boon Haw and Aw Boon Par, the developers of Tiger Balm, as a venue for teaching traditional Chinese values. They moved their business from Burma (Myanmar) to Singapore in 1926 and purchased the site in 1935.\r\nIn 1988, the Singapore Tourism Board took charge of the Tiger Balm Gardens and renamed it \"Haw Par Villa Dragon World\". The \"Haw Par\" in the park's name are based on the Aw brothers' personal names - \"Haw\" and \"Par\", which literally mean \"tiger\" and \"leopard\". The dioramas and statues were restored, while plays, acrobatic displays, and puppet shows were organised and held there. The management imposed entrance fees but the high fees discouraged visitors, so the management incurred a loss of S$31.5 million after 10 years. The park management made profit during its first year of operations after renovations in 1994, broke even in 1995, but started making losses over the next three years and was forced to provide free entry in 1998. In March 2001, the Singapore Tourism Board renamed it \"Tiger Balm Gardens\" and entrance fees dropped. The park is now open every day from 9am to 7pm and admission is free.\r\nThe best known attraction in Haw Par Villa is the Ten Courts of Hell, which features gruesome depictions of Hell in Chinese mythology and Buddhism. This attraction used to be set inside a 60-metre long trail of a Chinese dragon but the dragon has been demolished, so the attraction is now covered by grey stone walls.\r\nOther major attractions include: dioramas of scenes from Journey to the West, Fengshen Bang, The Twenty-four Filial Exemplars, Legend of the White Snake, Romance of the Three Kingdoms; statues of mythological figures such as the Laughing Buddha and Guanyin, and historical personages such as Jiang Ziya, Su Wu and Lin Zexu; the 12 animals in the Chinese zodiac, and others. There are also monuments dedicated to the Aw brothers and their parents.");
		scrollPane.setViewportView(txtrGardensByThe);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_3.addTab("Directions", null, scrollPane_1, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabbedPane);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("By Bus", null, scrollPane_3, null);

		JTextArea txtrFromEastCoast = new JTextArea();
		txtrFromEastCoast.setText("Bus 10, 30, 30E, 51, 143, 188 and 200");
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
		txtrViaTheCircle.setText("Via Circle Line:\r\nHaw Par Villa MRT ");
		scrollPane_4.setViewportView(txtrViaTheCircle);

		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_3.addTab("Pricing", null, scrollPane_2, null);

		JTextArea txtrOutdoorGardensRates = new JTextArea();
		txtrOutdoorGardensRates
				.setText("Opening Hours: \r\n9.00am to 7.00pm daily \r\n\r\nAdmission Rates: \r\nFree");
		txtrOutdoorGardensRates.setWrapStyleWord(true);
		txtrOutdoorGardensRates.setLineWrap(true);
		txtrOutdoorGardensRates.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane_2.setViewportView(txtrOutdoorGardensRates);
	}
}
