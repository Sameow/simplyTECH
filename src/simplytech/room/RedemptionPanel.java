package simplytech.room;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import simplytech.components.MACAddress;
import simplytech.databasestatements.DBController;
import simplytech.dao.CustomerDAO;
import simplytech.dao.CustomerVouchersDAO;
import simplytech.dao.PersonDAO;
import simplytech.dao.VouchersDAO;
import simplytech.entity.CustomerVouchers;
import simplytech.entity.Person;
import simplytech.entity.Vouchers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.SocketException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RedemptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelImage;
	private JLabel jLabelPoints = null;
	private JTextPane jTextPaneTitle = null;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JTextPane jTextPane1 = null;
	private JButton jButtonRedeem = null;
	private JLabel jLabel41 = null;
	private JLabel jLabelMyVouchers = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private String voucherType;
	private ArrayList<Vouchers> vouchers = null;
	private Vouchers voucher = null;
	private int min = 0;
	private int max = 0;
	private String setTitle;
	private String setSubtitle;
	private String setDetails;
	private String setImage;
	private int setPointsRequired;
	private JPanel panel = null;
	private JTextPane setPanes = null;
	private JLabel vouchersImage = null;
	private ArrayList<JTextPane> panes = new ArrayList<JTextPane>();
	private JScrollPane scrollPane = null;
	private int maxVoucher = 0;
	private int minVoucher = 0;
	private int k = 0;
	private Vouchers createVoucher = null;
	private ArrayList<Vouchers> createVouchers = null;
	private int loopCount = 0;
	private int yIncrement = 1;
	private int minusPoints = 750;
	private int finalPoints = 0;
	private DBController db;
	private String title;
	private String subtitle;
	private String details;
	private String macAddress = null;
	private String imageForSql = "";

	/**
	 * This is the default constructor
	 */
	public RedemptionPanel() {
		super();
	}

	public RedemptionPanel(JFrame f, String voucherType) {
		this();
		this.voucherType = voucherType;
		myFrame = f;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		vouchers = new ArrayList<Vouchers>();
		try {
			min = VouchersDAO.getMin(voucherType);
			max = VouchersDAO.getMax(voucherType);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		voucher = VouchersDAO.searchByType(voucherType, min);
		setTitle = voucher.getTitle();
		setSubtitle = voucher.getSubtitle();
		setDetails = voucher.getDetails();
		setImage = voucher.getImage();
		setPointsRequired = voucher.getPointsRequired();
		for (int i = min; i < max; i++) {
			voucher = VouchersDAO.searchByType(voucherType, i);
			vouchers.add(voucher);
		}

		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new PointsRewardSystemPanel2(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelMyVouchers = new JLabel();
		jLabelMyVouchers.setBounds(new Rectangle(813, 28, 193, 34));
		jLabelMyVouchers.setText("My Vouchers");
		jLabelMyVouchers.setForeground(new Color(58, 115, 255));
		jLabelMyVouchers.setFont(new Font("Calibri", Font.PLAIN, 24));
		jLabelMyVouchers.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new MyVouchersPanel2(myFrame, "RedemptionPanel",
						voucherType);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel41 = new JLabel();
		jLabel41.setBounds(new Rectangle(511, 103, 131, 23));
		jLabel41.setText("More");
		jLabel41.setFont(new Font("Calibri", Font.BOLD, 34));
		jLabelPoints = new JLabel();
		jLabelPoints.setBounds(new Rectangle(216, 282, 184, 37));
		jLabelPoints.setText(setPointsRequired + " points");
		jLabelPoints.setName(setPointsRequired + "");
		jLabelPoints.setFont(new Font("Calibri", Font.PLAIN, 14));
		jLabelImage = new JLabel();
		jLabelImage.setBounds(new Rectangle(79, 210, 110, 105));
		jLabelImage.setText("");
		jLabelImage.setIcon(new ImageIcon(setImage));
		jLabelImage.setName(setImage);
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(55, 103, 320, 69));
		jLabel4.setText("Your points: "
				+ MainFrame.getPersonWhoLogin().getPoints());
		jLabel4.setFont(new Font("Calibri", Font.PLAIN, 27));
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Points Reward System");
		jLabel.setSize(new Dimension(345, 35));
		jLabel.setLocation(new Point(91, 23));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		panel = new JPanel();
		panel.setSize(300, 350);
		panel.setPreferredSize(panel.getSize());
		panel.setLocation(561, 154);
		panel.setBackground(new Color(227, 228, 250));
		panel.setLayout(null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setEnabled(true);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabel, null);
		this.add(getJTextPane(), null);
		this.add(jLabel4, null);
		this.add(jLabelImage, null);
		this.add(jLabelPoints, null);
		this.add(getJTextPaneTitle(), null);
		this.add(getJTextPaneSubtitle(), null);
		this.add(getJTextPaneDetails(), null);
		this.add(getJTextPane1(), null);
		this.add(getJButtonRedeem(), null);
		this.add(jLabel41, null);
		this.add(panel);
		this.add(jLabelMyVouchers, null);
		this.add(jLabelBack, null);
		this.add(getScrollPane());
		createPanes();
	}

	private ArrayList<JTextPane> createPanes() {
		createVouchers = new ArrayList<Vouchers>();
		int yAxis;
		try {
			maxVoucher = VouchersDAO.getMax(voucherType);
			minVoucher = VouchersDAO.getMin(voucherType);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (k = minVoucher; k <= maxVoucher; k++) {
			createVoucher = VouchersDAO.searchByType(voucherType, k);
			yAxis = yIncrement * 100;
			if (createVoucher != null) {
				setTitle = createVoucher.getTitle();
				setSubtitle = createVoucher.getSubtitle();
				setDetails = createVoucher.getDetails();
				setImage = createVoucher.getImage();
				setPointsRequired = createVoucher.getPointsRequired();
				voucher = new Vouchers(setTitle, setSubtitle, setDetails,
						setImage, setPointsRequired);
				createVouchers.add(voucher);

				setPanes = new JTextPane();
				setPanes.setBounds(new Rectangle(131, -90 + yAxis, 159, 69));
				setPanes.setBackground(new Color(91, 155, 213));
				setPanes.setFont(new Font("Calibri", Font.PLAIN, 20));
				setPanes.setForeground(Color.white);
				setPanes.setEditable(false);
				setPanes.setText(setTitle);
				setPanes.setName(loopCount + "");
				panes.add(setPanes);
				panes.get(0).setBackground(new Color(31, 78, 121));
				vouchersImage = new JLabel();
				vouchersImage.setBounds(new Rectangle(51, -90 + yAxis, 80, 69));
				vouchersImage.setIcon(new ImageIcon(setImage));
				setPanes.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						for (int i = 0; i < panes.size(); i++) {
							panes.get(i).setBackground(new Color(91, 155, 213));
						}
						JTextPane p = (JTextPane) (arg0.getSource());
						String stringID = p.getName() + "";
						int id = Integer.parseInt(stringID);
						String title = createVouchers.get(id).getTitle();
						String subtitle = createVouchers.get(id).getSubtitle();
						String details = createVouchers.get(id).getDetails();
						String image = createVouchers.get(id).getImage();
						int pointsRequired = createVouchers.get(id)
								.getPointsRequired();
						jLabelImage.setIcon(new ImageIcon(image));
						jTextPaneTitle.setText(title);
						jTextPaneSubtitle.setText(subtitle);
						jTextPaneDetails.setText(details);
						jLabelPoints.setText(pointsRequired + "");
						jLabelPoints.setName(pointsRequired + "");
						panes.get(id).setBackground(new Color(31, 78, 121));
					}
				});
				panel.add(panes.get(loopCount));
				panel.add(vouchersImage);
				panel.setSize(300, yIncrement * 100);
				panel.setPreferredSize(panel.getSize());
				loopCount++;
				yIncrement++;
			}
		}
		return panes;
	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setPreferredSize(new Dimension(371, 4));
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 78));
			jTextPane.setBackground(new Color(91, 155, 213));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPaneTitle2
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneTitle() {
		if (jTextPaneTitle == null) {
			jTextPaneTitle = new JTextPane();
			jTextPaneTitle.setBounds(new Rectangle(215, 210, 152, 60));
			jTextPaneTitle.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle.setBackground(new Color(227, 228, 250));
			jTextPaneTitle.setText(setTitle);
			jTextPaneTitle.setVisible(true);
		}
		return jTextPaneTitle;
	}

	/**
	 * This method initializes jTextPaneDescription1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneSubtitle() {
		if (jTextPaneSubtitle == null) {
			jTextPaneSubtitle = new JTextPane();
			jTextPaneSubtitle.setBounds(new Rectangle(66, 331, 315, 60));
			jTextPaneSubtitle.setBackground(new Color(227, 228, 250));
			jTextPaneSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneSubtitle.setText(setSubtitle);
		}
		return jTextPaneSubtitle;
	}

	/**
	 * This method initializes jTextPaneDetails1
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPaneDetails() {
		if (jTextPaneDetails == null) {
			jTextPaneDetails = new JTextPane();
			jTextPaneDetails.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDetails.setBackground(new Color(227, 228, 250));
			jTextPaneDetails.setText(setDetails);
			jTextPaneDetails.setLocation(new Point(63, 400));
			jTextPaneDetails.setSize(new Dimension(315, 500));
			jTextPaneDetails.setVisible(true);
		}
		return jTextPaneDetails;
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
	 * This method initializes jButtonRedeem
	 * 
	 * @return javax.swing.JButton
	 */

	private JButton getJButtonRedeem() {
		if (jButtonRedeem == null) {
			jButtonRedeem = new JButton();
			final int points = MainFrame.getPersonWhoLogin().getPoints();
			db = new DBController();
			title = jTextPaneTitle.getText();
			subtitle = jTextPaneSubtitle.getText();
			details = jTextPaneDetails.getText();
			jButtonRedeem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int option = JOptionPane.showConfirmDialog(myFrame,
							"Are you sure you want to redeem?", "Confirmation",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						minusPoints = Integer.parseInt(jLabelPoints.getName());
						finalPoints = points - minusPoints;
						if (finalPoints < 0) {
							JOptionPane.showConfirmDialog(myFrame,
									"Not enough points!", "Confirmation",
									JOptionPane.PLAIN_MESSAGE);
						} else {
							SimpleDateFormat timeFormat = new SimpleDateFormat(
									"HH:mm:ss dd MMM yyyy");
							Date date = new Date();
							Calendar c = Calendar.getInstance();
							c.setTime(date);
							c.add(Calendar.DATE, 30);
							String expiryDate = timeFormat.format(c.getTime());
							for (int i = 0; i < jLabelImage.getName().length(); i++) {
								if (jLabelImage.getName().charAt(i) == '\\') {
									imageForSql = imageForSql + "\\\\";
								} else {
									imageForSql = imageForSql
											+ jLabelImage.getName().charAt(i);
								}
							}
							CustomerVouchers cv = new CustomerVouchers(
									MainFrame.getPersonWhoLogin().getId(),
									jTextPaneTitle.getText(), jTextPaneSubtitle
											.getText(), jTextPaneDetails
											.getText(), imageForSql, expiryDate);
							try {
								CustomerDAO.updatePoints(finalPoints, MainFrame
										.getPersonWhoLogin().getId());
								MainFrame.getPersonWhoLogin().setPoints(
										finalPoints);
								CustomerVouchersDAO.createVoucher(cv, MainFrame
										.getPersonWhoLogin().getId(), MainFrame
										.getPersonWhoLogin().getUsername());
							} catch (SQLException e) {
								e.printStackTrace();
							}
							JPanel panel = new RedemptionPanel(myFrame,
									voucherType);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					}
				}
			});
			jButtonRedeem.setBounds(new Rectangle(298, 115, 107, 47));
			jButtonRedeem.setFont(new Font("Calibri", Font.BOLD, 20));
			jButtonRedeem.setForeground(Color.white);
			jButtonRedeem.setText("Redeem");
			jButtonRedeem.setBackground(new Color(91, 155, 213));
		}
		return jButtonRedeem;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(panel);
			scrollPane.setBounds(532, 147, 370, 372);
			scrollPane
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(new Color(227, 228, 250));
			scrollPane
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		return scrollPane;
	}

}