package simplytech.staff;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;

import simplytech.components.DesEncryption;
import simplytech.dao.BookingDAO;
import simplytech.dao.BookingsManagementDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.dao.StaffDAO;
import simplytech.dao.StaffManagementDAO;
import simplytech.entity.Booking;
import simplytech.entity.Customer;
import simplytech.entity.Person;
import simplytech.entity.Staff;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class EditBookings extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JLabel jLabelBar = null;
	private JLabel jLabelEditStaffAccount = null;
	private JLabel jLabelEditBookings;
	private JLabel jLabelBack = null;
	private JLabel labelDeleteStaff;

	private String selectedTextPaneTitle;;

	private JScrollPane ScrollPaneContainingBookingsTextPanes;
	private JPanel panelWithBookingsTextPanes;

	private JTextField jTextFieldTitle = null;

	private JTextPane selectedTextPane;
	private Booking selectedBooking;

	ArrayList<JTextPane> bookingsTextPanes = new ArrayList<JTextPane>();
	private ArrayList<Booking> bookingsArray;
	private ArrayList<Customer> customerArray;
	private JLabel titleLabel;

	public EditBookings(JFrame f) {
		super();
		myFrame = f;
		initialize();
	}

	/**
	 * 
	 */
	private void initialize() {
		// Gather all bookings and room services.
		try {
			customerArray = CustomerDAO.retrieveAll("Customer");
			bookingsArray = BookingsManagementDAO.retrieveAllBooking();
		} catch (SQLException e) {
			System.err.println("Unable to retrieve booking details" + e);
		}
		selectedBooking = bookingsArray.get(0);
		jLabelEditBookings = new JLabel();
		jLabelEditBookings.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelEditBookings.setLocation(new Point(91, 23));
		jLabelEditBookings.setSize(new Dimension(431, 35));
		jLabelEditBookings.setText("Edit Bookings");
		jLabelBar = new JLabel();
		jLabelBar.setText("");
		jLabelBar.setLocation(new Point(0, 78));
		jLabelBar.setSize(new Dimension(371, 4));
		jLabelBar.setBackground(new Color(91, 155, 213));
		jLabelBar.setOpaque(true);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelEditBookings, null);
		this.add(getJLabelBack());
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBar, null);
		this.add(getJTextFieldTitle());
		add(getScrollPaneContainingBookingsTextPanes());
		createBookingsTextPanes();

		labelDeleteStaff = new JLabel();
		/*
		 * labelDeleteStaff.addMouseListener(new MouseAdapter() { public void
		 * mouseClicked(MouseEvent arg0) { if
		 * (MainFrame.getPersonWhoLogin().getPosition().equals("Manager")){ int
		 * confirmingDelete = JOptionPane.showConfirmDialog(myFrame,
		 * "Delete selected staff??", "Confirmation",
		 * JOptionPane.YES_NO_OPTION); if (confirmingDelete ==
		 * JOptionPane.YES_OPTION) { if
		 * (StaffManagementDAO.deleteStaff(selectedStaff.getId())) {
		 * JOptionPane.showMessageDialog(null, "Staff deleted!", "Success!",
		 * JOptionPane.INFORMATION_MESSAGE); //refresh page JPanel panel = new
		 * EditBookings(myFrame); myFrame.getContentPane().removeAll();
		 * myFrame.getContentPane().add(panel);
		 * myFrame.getContentPane().validate();
		 * myFrame.getContentPane().repaint(); } else {
		 * JOptionPane.showMessageDialog(null, "Unable to delete staff",
		 * "Error in if loop!", JOptionPane.ERROR_MESSAGE); } } else { JPanel
		 * panel = new EditBookings(myFrame);
		 * myFrame.getContentPane().removeAll();
		 * myFrame.getContentPane().add(panel);
		 * myFrame.getContentPane().validate();
		 * myFrame.getContentPane().repaint(); } } else
		 * JOptionPane.showMessageDialog(null,
		 * "Only Managers are allowed to delete staff.", "Access denied.",
		 * JOptionPane.ERROR_MESSAGE); } });
		 */
		labelDeleteStaff.setText("Delete Booking");
		labelDeleteStaff.setOpaque(true);
		labelDeleteStaff.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteStaff.setForeground(Color.WHITE);
		labelDeleteStaff.setBounds(new Rectangle(675, 494, 176, 43));
		labelDeleteStaff.setBackground(new Color(91, 155, 213));
		labelDeleteStaff.setBounds(34, 435, 176, 43);
		add(labelDeleteStaff);

		titleLabel = new JLabel();
		titleLabel.setText("Title:");
		titleLabel.setSize(new Dimension(431, 35));
		titleLabel.setLocation(new Point(91, 23));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
		titleLabel.setBounds(400, 127, 84, 35);
		add(titleLabel);

		// Dont know why this doesnt work, will review after exams
		// //Gather all staff details
		// try {
		// staffArray=StaffManagementDAO.retrieveAll();
		// System.out.println("staffArray.size()= "+ staffArray.size());
		// } catch (SQLException e) {
		// System.out.println("Unable to create staff array");
		// }
		// //Generate text panes based on no. of Staff
		// int noOfStaffTextPanesCreated=0;
		// int yCoordinate=0;
		// for (int i=0; i<staffArray.size(); i++) {
		// System.out.println("noOfStaffTextPanesCreated = "+noOfStaffTextPanesCreated);
		// System.out.println("yCoordinate = "+yCoordinate);
		// //1st textpane y coordinate is 136
		// this.add(getJTextPaneNameOnTheLeft((136+yCoordinate),
		// staffArray.get(noOfStaffTextPanesCreated)));
		// noOfStaffTextPanesCreated++;
		// yCoordinate+=50;
		// }
	}

	private JScrollPane getScrollPaneContainingBookingsTextPanes() {
		if (ScrollPaneContainingBookingsTextPanes == null) {
			ScrollPaneContainingBookingsTextPanes = new JScrollPane();
			ScrollPaneContainingBookingsTextPanes.setBounds(232, 119, 138, 413);
			ScrollPaneContainingBookingsTextPanes.setViewportBorder(null);
			ScrollPaneContainingBookingsTextPanes
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			ScrollPaneContainingBookingsTextPanes.setBackground(new Color(227,
					228, 250));
			panelWithBookingsTextPanes = new JPanel();
			ScrollPaneContainingBookingsTextPanes
					.setViewportView(panelWithBookingsTextPanes);
			panelWithBookingsTextPanes.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelWithBookingsTextPanes.setBackground(new Color(227, 228, 250));
			panelWithBookingsTextPanes.setLayout(null);
		}
		return ScrollPaneContainingBookingsTextPanes;
	}

	private JLabel getJLabelBack() {
		if (jLabelBack == null) {
			jLabelBack = new JLabel();
			jLabelBack.setText("");
			jLabelBack.setSize(new Dimension(128, 128));
			jLabelBack.setLocation(new Point(-13, -25));
			jLabelBack.setIcon(new ImageIcon(getClass().getResource(
					"/simplyTECH/image/Swap Left.png")));
			jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					JPanel panel = new StaffMainPage(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jLabelBack;
	}

	private JTextField getJTextFieldTitle() {
		if (jTextFieldTitle == null) {
			jTextFieldTitle = new JTextField();
			jTextFieldTitle.setBounds(new Rectangle(478, 119, 216, 50));
			jTextFieldTitle.setFont(new Font("Calibri", Font.PLAIN, 24));
			jTextFieldTitle.setBackground(Color.WHITE);
			jTextFieldTitle.setEditable(false);
		}
		return jTextFieldTitle;
	}

	private ArrayList<JTextPane> createBookingsTextPanes() {
		// 1st textpane y coordinate is 136
		int yValue = 30;
		int loopCount = 1;

		for (int i = 0; i < bookingsArray.size(); i++) {
			if (bookingsArray != null) {
				int id = bookingsArray.get(i).getId();
				String name = null;

				for (int k = 0; k < customerArray.size(); k++) {
					if (customerArray.get(k).getId()==id) {
						name = customerArray.get(k).getName();
						System.out.println("name = "+name);
					}
				}
				JTextPane bookingsTextPane = new JTextPane();
				bookingsTextPane.setBounds(new Rectangle(0, yValue, 150, 36));
				// Prepare y value for next pane
				yValue += 50;

				bookingsTextPane.setBackground(new Color(91, 155, 213));
				bookingsTextPane.setFont(new Font("Calibri", Font.BOLD, 18));
				bookingsTextPane.setForeground(Color.white);
				bookingsTextPane.setEditable(false);
				bookingsTextPane.setText(name);
				bookingsTextPane.setName(i + "");
				bookingsTextPanes.add(bookingsTextPane);
				// Set for 1st textPane's info to show initially
				selectedBooking = bookingsArray.get(0);
				bookingsTextPanes.get(0).setBackground(new Color(31, 78, 121));
				jTextFieldTitle.setText(selectedBooking.getTitle());

				// Stuff that happens when a TextPane is clicked
				bookingsTextPane.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						// For later methods
						String selectedCustomerUsername = null;
						int selectedCustomerID = -1;
						// Change bg color when clicked
						for (int i = 0; i < bookingsTextPanes.size(); i++) {
							bookingsTextPanes.get(i).setBackground(
									new Color(91, 155, 213));
						}
						// Extract info for selected TextPane
						selectedTextPane = (JTextPane) (arg0.getSource());

						// find the selectedTextPane in the text pane array
						// because bookings in DB has no unique property
						for (int i = 0; i < bookingsTextPanes.size(); i++) {
							System.out
									.println("bookingsTextPanes.get(i).getName() = "
											+ bookingsTextPanes.get(i)
													.getName());
							if (bookingsTextPanes.get(i).getName() == selectedTextPane
									.getName())
								selectedTextPane = bookingsTextPanes.get(i);
						}

						System.out.println("selectedTextPane.getName() = "
								+ selectedTextPane.getName());
						// Look for name in customerArray and find his username
						for (int i = 0; i < customerArray.size(); i++) {
							if (customerArray.get(i).getName()
									.equals(selectedTextPane.getText())) {
								selectedCustomerUsername = customerArray.get(i)
										.getUsername();
								selectedCustomerID = customerArray.get(i)
										.getId();
							}
						}
						// Create the booking of selectedTextPane
						System.out.println("selectedCustomerUsername = "
								+ selectedCustomerUsername);
						selectedBooking = BookingDAO.searchByUsername(
								selectedCustomerUsername, selectedCustomerID);
						if (selectedBooking != null) {
							selectedTextPaneTitle = selectedBooking.getTitle();
						}

						// Set info for selected textPane
						jTextFieldTitle.setText(selectedTextPaneTitle);

						int indexOfBookingTextPanesWhoHasSelectedCustomerName = -1;
						for (int i = 0; i < bookingsTextPanes.size(); i++) {
							if (bookingsTextPanes.get(i).getText()
									.equals(selectedTextPane.getText())) {// Find
																			// index
																			// of
																			// text
																			// pane
																			// who
																			// has
																			// same
																			// text
																			// as
																			// the
																			// selected
																			// textpane
								indexOfBookingTextPanesWhoHasSelectedCustomerName = i;
							}
						}
						if (indexOfBookingTextPanesWhoHasSelectedCustomerName == -1)
							System.out.println("Error");
						else
							bookingsTextPanes
									.get(indexOfBookingTextPanesWhoHasSelectedCustomerName)
									.setBackground(new Color(31, 78, 121));// set
																			// bg
																			// color
																			// of
																			// selected
																			// textpane
																			// to
																			// indicate
																			// selection
					}
				});
				// Adding non-selected text pane (Other non selected text panes
				// added when this for loop finishes)
				panelWithBookingsTextPanes.add(bookingsTextPanes
						.get(loopCount - 1));
				panelWithBookingsTextPanes.setSize(200,
						bookingsTextPanes.size() * 100);
				panelWithBookingsTextPanes
						.setPreferredSize(panelWithBookingsTextPanes.getSize());
				loopCount++;
			}
		}
		return bookingsTextPanes;
	}
}