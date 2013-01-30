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

public class suntecCity extends JPanel {

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
	public suntecCity() {
		super();
		initialize();
	}

	public suntecCity(JFrame f) {
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
		jLabelBack.setIcon(new ImageIcon(suntecCity.class
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
		jLabelLocation.setText("Suntec City");
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
		jLabelPicture.setIcon(new ImageIcon(suntecCity.class
				.getResource("/simplytech/image/suntec-city.jpg")));
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
				.setText("Listed by the Guinness Book of Records in 1998 as the largest fountain in the world, the Fountain of Wealth* is located within one of Singapore largest shopping malls, Suntec City. \r\nIn fact, the shopping and office district was constructed in accordance to Feng Shui principles. The 5 towering office blocks are designed to represent a left hand\u2019s fingers, with the fountain sitting in the middle of the \u201Cpalm\u201D, symbolising wealth.\r\n\r\nAnd during certain periods of the day, visitors are invited to walk around the fountain\u2019s base for good luck. At night, the fountain comes alive with spectacular laser performances and song dedications.\r\n\r\nSuntec city engages over 300 retail outlets, 50 pushcarts and 100 F&B establishments spreading across 4 floors. The mega mall is divided into 4 zones: the Galleria, offering high-end labels, the Tropics, emphasising on lifestyle merchandises and services, the Fountain Terrace, specialising in F&B, and the Entertainment Centre, comprising of a cinema, fitness gym, an arcade and many more.\r\n\r\nWith its close proximity to the Central Business District and top tourist spots, it\u2019s no wonder this shopping, entertainment and dining centre is the perfect one-stop place to unwind \u2013 a must-visit for all tourists.\r\n\r\n*The Fountain of Wealth will be closed temporarily from 1 Sep 2012 to Jun 2013 (opening date tbc) for upgrading works. For further enquiry, please contact Suntec Customer Service at 68252668 / 68252669 or visit www.sunteccitymall.com for more information. Thank you.     ");
		scrollPane.setViewportView(txtrGardensByThe);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_3.addTab("Directions", null, scrollPane_1, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabbedPane);

		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("By MRT", null, scrollPane_4, null);

		JTextArea txtrViaTheCircle = new JTextArea();
		txtrViaTheCircle.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrViaTheCircle.setWrapStyleWord(true);
		txtrViaTheCircle.setLineWrap(true);
		txtrViaTheCircle
				.setText("The nearest MRT Station is Esplanade Station. Alternatively, you can also alight at City Hall Interchange. From there, you can then take a 10 minutes\u2019 walk via the underground City Link Mall.");
		scrollPane_4.setViewportView(txtrViaTheCircle);

		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("By Bus", null, scrollPane_5, null);

		JTextArea txtrFromTheHelix = new JTextArea();
		txtrFromTheHelix.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrFromTheHelix.setWrapStyleWord(true);
		txtrFromTheHelix.setLineWrap(true);
		txtrFromTheHelix
				.setText("Bus services to Suntec Singapore: 36, 97, 106, 111, 133, 501, 502, 518, 857, 700. Alight right in front of the Convention Centre.");
		scrollPane_5.setViewportView(txtrFromTheHelix);
	}
}
