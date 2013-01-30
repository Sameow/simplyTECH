package simplytech.room;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;

import simplytech.dao.AccommodationsDAO;
import simplytech.dao.BookingDAO;
import simplytech.dao.MenuDAO;
import simplytech.dao.RoomServiceDAO;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Summary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelSummary;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private String title;
	private double menuPrice;
	private int points;
	private String username;
	private int currentPoints;
	private int id;
	private String roomService;
	private String item;
	private int quantity;
	private double bookingPrice;
	private String bookingTitle;
	private double grandTotal;
	private String suite;
	private double accoPrice;
	private int accoDay;

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(0, 78, 371, 4);
			jTextPane.setBackground(new Color(91, 155, 213));
		}
		return jTextPane;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * This is the default constructor
	 */
	public Summary() {
		super();
		initialize();
	}

	public Summary(JFrame f) {
		this();
		myFrame = f;
		initialize();
	}

	public double getPrice() {
		return menuPrice;
	}

	public void setPrice(double price) {
		this.menuPrice = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		username = MainFrame.getPersonWhoLogin().getUsername();
		id = MainFrame.getPersonWhoLogin().getId();
		currentPoints = MainFrame.getPersonWhoLogin().getPoints();
		roomService = RoomServiceDAO.searchById(id).getService();
		item = MenuDAO.searchById(id).getItem();
		menuPrice = MenuDAO.searchById(id).getTotalPrice();
		quantity = MenuDAO.searchById(id).getQuantity();
		bookingTitle = BookingDAO.searchById(id).getTitle();
		bookingPrice = BookingDAO.searchById(id).getPrice();
		suite = AccommodationsDAO.searchById(id + "").getAccoSuite();
		accoPrice = AccommodationsDAO.searchById(id + "").getAccoPrice();
		accoDay = AccommodationsDAO.searchById(id + "").getAccoDay();
		grandTotal = menuPrice + bookingPrice + accoPrice;

		jLabelBack = new JLabel();
		jLabelBack.setBounds(-13, -25, 128, 128);
		jLabelBack.setText("");
		jLabelBack.setIcon(new ImageIcon(Summary.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// System.out.println("mouseClicked()"); // TODO Auto-generated
				// Event stub mouseClicked()
				JPanel panel = new MyAccountsPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelSummary = new JLabel();
		jLabelSummary.setBounds(91, 23, 216, 35);
		jLabelSummary.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelSummary.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelSummary.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelSummary.setText("Summary");
		this.setSize(1024, 600);
		this.setBackground(new Color(227, 228, 250));
		setLayout(null);
		this.add(jLabelSummary);
		this.add(jLabelBack);
		this.add(getJTextPane());

		JScrollPane summary = new JScrollPane();
		summary.setBounds(128, 163, 772, 378);
		add(summary);

		JPanel summaryPanel = new JPanel();
		summaryPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		summary.setViewportView(summaryPanel);
		summaryPanel.setLayout(null);

		JLabel lblPoints = new JLabel("Points :    " + currentPoints);
		lblPoints.setBounds(10, 11, 160, 31);
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setFont(new Font("Calibri", Font.BOLD, 22));
		summaryPanel.add(lblPoints);

		JLabel lblRoomServices = new JLabel("Room Services");
		lblRoomServices.setBounds(10, 44, 160, 31);
		lblRoomServices.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoomServices.setFont(new Font("Calibri", Font.BOLD, 18));
		summaryPanel.add(lblRoomServices);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 66, 116, 1);
		textPane.setBackground(Color.BLACK);
		summaryPanel.add(textPane);

		JTextArea textAreaRS = new JTextArea();
		textAreaRS.setBounds(10, 75, 200, 73);
		textAreaRS.setLineWrap(true);
		textAreaRS.setWrapStyleWord(true);
		textAreaRS.setFont(new Font("Calibri", Font.BOLD, 18));
		summaryPanel.add(textAreaRS);
		textAreaRS.setEditable(false);
		textAreaRS.setBackground(new Color(237, 237, 237));
		textAreaRS.setText("" + roomService + "\n");

		JLabel labelFNB = new JLabel("Food & Beverages");
		labelFNB.setBounds(10, 149, 160, 31);
		labelFNB.setHorizontalAlignment(SwingConstants.LEFT);
		labelFNB.setFont(new Font("Calibri", Font.BOLD, 18));
		summaryPanel.add(labelFNB);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 171, 140, 1);
		textPane_1.setBackground(Color.BLACK);
		summaryPanel.add(textPane_1);

		JTextArea textAreaFNB = new JTextArea();
		textAreaFNB.setBounds(10, 179, 517, 73);
		textAreaFNB.setEditable(false);
		textAreaFNB.setWrapStyleWord(true);
		textAreaFNB.setText("" + item + "     X     " + quantity + "\n$"
				+ menuPrice + "\n");
		textAreaFNB.setLineWrap(true);
		textAreaFNB.setFont(new Font("Calibri", Font.BOLD, 18));
		textAreaFNB.setBackground(SystemColor.control);
		summaryPanel.add(textAreaFNB);

		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setHorizontalAlignment(SwingConstants.LEFT);
		lblBooking.setFont(new Font("Calibri", Font.BOLD, 18));
		lblBooking.setBounds(10, 250, 160, 31);
		summaryPanel.add(lblBooking);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(Color.BLACK);
		textPane_2.setBounds(10, 272, 65, 1);
		summaryPanel.add(textPane_2);

		JTextArea textAreaBooking = new JTextArea();
		textAreaBooking.setWrapStyleWord(true);
		textAreaBooking
				.setText("" + bookingTitle + "\n$" + bookingPrice + "\n");
		textAreaBooking.setLineWrap(true);
		textAreaBooking.setFont(new Font("Calibri", Font.BOLD, 18));
		textAreaBooking.setEditable(false);
		textAreaBooking.setBackground(SystemColor.control);
		textAreaBooking.setBounds(10, 279, 517, 73);
		summaryPanel.add(textAreaBooking);

		JLabel lblallPricesInclusive = new JLabel(
				"*All prices inclusive of 7% GST and service charge. ");
		lblallPricesInclusive.setHorizontalAlignment(SwingConstants.LEFT);
		lblallPricesInclusive.setFont(new Font("Calibri", Font.BOLD, 11));
		lblallPricesInclusive.setBounds(20, 356, 264, 20);
		summaryPanel.add(lblallPricesInclusive);

		JLabel lblAccommodations = new JLabel("Accommodations");
		lblAccommodations.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccommodations.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAccommodations.setBounds(332, 44, 160, 31);
		summaryPanel.add(lblAccommodations);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(Color.BLACK);
		textPane_3.setBounds(332, 66, 135, 1);
		summaryPanel.add(textPane_3);

		JTextArea textAreaAccommodation = new JTextArea();
		textAreaAccommodation.setWrapStyleWord(true);
		textAreaAccommodation.setText("" + suite + "     X     " + accoDay
				+ " day(s)\n" + "$" + accoPrice);
		textAreaAccommodation.setLineWrap(true);
		textAreaAccommodation.setFont(new Font("Calibri", Font.BOLD, 18));
		textAreaAccommodation.setEditable(false);
		textAreaAccommodation.setBackground(SystemColor.control);
		textAreaAccommodation.setBounds(332, 74, 384, 73);
		summaryPanel.add(textAreaAccommodation);

		JLabel lblIdNo = new JLabel("ID No. :     " + id);
		lblIdNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdNo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblIdNo.setBounds(218, 11, 160, 31);
		summaryPanel.add(lblIdNo);

		JLabel lblGrandTotal = new JLabel("Grand Total :      $" + grandTotal);
		lblGrandTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblGrandTotal.setFont(new Font("Calibri", Font.BOLD, 26));
		lblGrandTotal.setBounds(332, 248, 315, 31);
		summaryPanel.add(lblGrandTotal);
	}
}

