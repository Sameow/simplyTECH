package simplytech.room;

import javax.management.timer.Timer;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import simplytech.dao.CustomerVouchersDAO;
import simplytech.entity.CustomerVouchers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyVouchersPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabelImage;
	private JTextPane jTextPaneTitle = null;
	private JLabel jLabelDate1 = null;
	private JLabel jLabelDate;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JLabel jLabelDate2 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JPanel panel = null;
	private ArrayList<CustomerVouchers> vouchers;
	private JLabel vouchersImage;
	private String image = null;
	private String title = null;
	private String subtitle = null;
	private String details = null;
	private JScrollPane scrollPane;
	private JScrollBar verticalScrollBar = null;
	private String username;
	private int k;
	private int count = 0;
	private ArrayList<JTextPane> panes = new ArrayList<JTextPane>();
	private JTextPane setPanes = null;
	private String[] titles;
	private CustomerVouchers voucher;
	private ArrayList<CustomerVouchers> createVouchers = new ArrayList<CustomerVouchers>();
	private int loopCount = 0;
	private Rectangle rectangle = new Rectangle(0, 0, 0, 1000);
	private JLabel errorMessage;
	private String expiryDate;
	private String previousPanel = null;
	private String voucherType = null;
	private int vouchersId;
	private Timer timer = new Timer();
	private Calendar calendar;
	private long start;
	private long stop;

	/**
	 * This is the default constructor
	 */
	public MyVouchersPanel2() {
		super();
		initialize();
	}

	public MyVouchersPanel2(JFrame f, String previousPanel, String voucherType) {
		this();
		myFrame = f;
		this.previousPanel = previousPanel;
		this.voucherType = voucherType;
	}

	private void initialize() {

		jLabelDate2 = new JLabel();
		jLabelDate = new JLabel();
		jLabelDate.setBounds(new Rectangle(699, 207, 244, 30));
		jLabelDate.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelDate.setVisible(true);
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start = calendar.getInstance().getTimeInMillis();			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				stop = calendar.getInstance().getTimeInMillis();
				if (stop - start < 500){
					JPanel panel = new MyAccountsPanel(myFrame);
					if (previousPanel == "RedemptionPanel") {
						panel = new RedemptionPanel(myFrame, voucherType);
					} else if (previousPanel == "MyAccountsPanel") {
						panel = new MyAccountsPanel(myFrame);
					} else if (previousPanel == "MyAccountsPanel2") {
						panel = new MyAccountsPanel2(myFrame);
					}
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
				else {
					JPanel panel = new RoomHomePagePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();	
				}
					
			}
			
		});
		jLabelImage = new JLabel();
		jLabelImage.setBounds(new Rectangle(578, 123, 111, 114));
		jLabelImage.setText("");
		jLabelImage.setVisible(true);
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("My Vouchers");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(216, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		panel = new JPanel();
		panel.setSize(100, 100);
		panel.setPreferredSize(panel.getSize());
		panel.setBackground(new Color(227, 228, 250));
		panel.setLayout(null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane(), null);
		this.add(jLabel, null);
		this.add(getJTextPane1(), null);
		this.add(jLabelImage, null);
		this.add(getJTextPaneTitle(), null);
		this.add(jLabelDate, null);
		this.add(getJTextPaneSubtitle(), null);
		this.add(getJTextPaneDetails(), null);
		this.add(jLabelDate2, null);
		this.add(jLabelBack, null);
		this.add(getScrollPane());
		// this.add(panel);
		panel.add(getErrorMessage());
		vouchers = CustomerVouchersDAO.retrieveAll(MainFrame
				.getPersonWhoLogin().getId());
		if (vouchers.size() == 0) {
			errorMessage.setVisible(true);
		} else {
			image = vouchers.get(0).getImage();
			subtitle = vouchers.get(0).getSubtitle();
			details = vouchers.get(0).getDetails();
			jLabelImage.setIcon(new ImageIcon(image));
			createPanes();
		}
	}

	private int max;

	private ArrayList<JTextPane> createPanes() {
		int yAxis = 0;

		for (k = 0; k < vouchers.size(); k++) {
			// vouchers = CustomerVouchersDAO.searchById(customerId, k);
			if (vouchers != null) {
				yAxis++;
				vouchersId = vouchers.get(k).getVouchersId();
				username = vouchers.get(k).getUsername();
				image = vouchers.get(k).getImage();
				title = vouchers.get(k).getTitle();
				subtitle = vouchers.get(k).getSubtitle();
				details = vouchers.get(k).getDetails();
				// voucher = new CustomerVouchers(yAxis, vouchersId, title,
				// subtitle, details,
				// image);
				// createVouchers.add(voucher);
				setPanes = new JTextPane();
				setPanes.setBounds(new Rectangle(131, -90 + (yAxis * 100), 159,
						69));
				setPanes.setBackground(new Color(91, 155, 213));
				setPanes.setFont(new Font("Calibri", Font.PLAIN, 20));
				setPanes.setForeground(Color.white);
				setPanes.setEditable(false);
				setPanes.setText(title);
				setPanes.setName(yAxis + "");
				panes.add(setPanes);
				panes.get(0).setBackground(new Color(31, 78, 121));
				jLabelImage.setIcon(new ImageIcon(vouchers.get(0).getImage()));
				jTextPaneTitle.setText(vouchers.get(0).getTitle());
				jTextPaneSubtitle.setText(vouchers.get(0).getSubtitle());
				jTextPaneDetails.setText(vouchers.get(0).getDetails());
				jLabelDate.setText("Expires: " + vouchers.get(0).getExpiryDate());
				vouchersId = vouchers.get(0).getVouchersId();
				vouchersImage = new JLabel();
				vouchersImage.setBounds(new Rectangle(52, -90 + (yAxis * 100),
						80, 69));
				vouchersImage.setIcon(new ImageIcon(image));
				setPanes.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						for (int i = 0; i < panes.size(); i++) {
							panes.get(i).setBackground(new Color(91, 155, 213));
						}
						JTextPane p = (JTextPane) (arg0.getSource());
						String stringID = p.getName() + "";
						int id = Integer.parseInt(stringID);
						vouchers.get(loopCount - 1);
						title = vouchers.get(id - 1).getTitle();
						subtitle = vouchers.get(id - 1).getSubtitle();
						details = vouchers.get(id - 1).getDetails();
						image = vouchers.get(id - 1).getImage();
						expiryDate = vouchers.get(id - 1).getExpiryDate();
						vouchersId = vouchers.get(id - 1).getVouchersId();
						jLabelImage.setIcon(new ImageIcon(image));
						jTextPaneTitle.setText(title);
						jTextPaneSubtitle.setText(subtitle);
						jTextPaneDetails.setText(details);
						jLabelDate.setText("Expires: " + expiryDate);
						panes.get(id - 1).setBackground(new Color(31, 78, 121));
					}
				});
				panel.add(panes.get(loopCount));
				panel.add(vouchersImage);
				panel.setSize(100, vouchers.size() * 100);
				panel.setPreferredSize(panel.getSize());
				loopCount++;
			}
		}
		return panes;
	}

	int l = 0;

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
	 * This method initializes jTextPane1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {

			jTextPane1 = new JTextPane();
			jTextPane1.setBackground(new Color(91, 155, 213));
			jTextPane1.setSize(new Dimension(4, 351));
			jTextPane1.setLocation(new Point(458, 155));
		}
		return jTextPane1;
	}

	/**
	 * This method initializes jTextPaneTitle1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneTitle() {
		if (jTextPaneTitle == null) {
			jTextPaneTitle = new JTextPane();
			jTextPaneTitle.setBounds(new Rectangle(699, 123, 173, 78));
			jTextPaneTitle.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle.setBackground(new Color(227, 228, 250));
			jTextPaneTitle.setText(title);
			jTextPaneTitle.setVisible(true);
		}
		return jTextPaneTitle;
	}

	/**
	 * This method initializes jTextPaneDescriptionBig1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneSubtitle() {
		if (jTextPaneSubtitle == null) {
			jTextPaneSubtitle = new JTextPane();
			jTextPaneSubtitle.setBounds(new Rectangle(578, 256, 296, 87));
			jTextPaneSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneSubtitle.setBackground(new Color(227, 228, 250));
			jTextPaneSubtitle.setText(subtitle);
			jTextPaneSubtitle.setVisible(true);
		}
		return jTextPaneSubtitle;
	}

	/**
	 * This method initializes jTextPaneDescription1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDetails() {
		if (jTextPaneDetails == null) {
			jTextPaneDetails = new JTextPane();
			jTextPaneDetails.setBounds(new Rectangle(578, 337, 336, 157));
			jTextPaneDetails.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDetails.setBackground(new Color(227, 228, 250));
			jTextPaneDetails.setText(details);
			jTextPaneDetails.setVisible(true);
		}
		return jTextPaneDetails;
	}

	private JScrollBar getVerticalScrollBar() {
		if (verticalScrollBar == null) {
			verticalScrollBar.setLocation(10, 10);
		}
		return verticalScrollBar;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(panel);
			scrollPane.setBounds(32, 117, 370, 422);
			scrollPane
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(new Color(227, 228, 250));
			scrollPane
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			verticalScrollBar = scrollPane.getVerticalScrollBar();
			scrollPane.getVerticalScrollBar().setValue(-500);
			scrollPane.scrollRectToVisible(rectangle);
		}
		return scrollPane;
	}

	private JLabel getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JLabel("");
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBounds(78, 197, 220, 23);
			errorMessage.setText("You do not have any vouchers.");
			errorMessage.setVisible(false);
		}
		return errorMessage;
	}
} // @jve:decl-index=0:visual-constraint="20,10"
