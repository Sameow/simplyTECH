package simplytech.staff;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import simplytech.room.MyAccountsPanel;
import simplytech.dao.CustomerDAO;
import simplytech.dao.CustomerVouchersDAO;
import simplytech.entity.Customer;
import simplytech.entity.CustomerVouchers;

import java.awt.Font;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

public class UseVouchers extends JPanel {

	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JPanel panel = null;
	private JTextPane setPanes = null;
	private ArrayList<CustomerVouchers> vouchers = null;
	private int id = 0;
	private int count = 0;
	private int max = 0;
	private String[] titles = null;
	private int k = 0;
	private String image = null;
	private String title = null;
	private String subtitle = null;
	private String details = null;
	private CustomerVouchers voucher;
	private ArrayList<CustomerVouchers> createVouchers = new ArrayList<CustomerVouchers>();
	private ArrayList<JTextPane> panes = new ArrayList<JTextPane>();
	private JLabel jLabelImage = null;
	private JTextPane jTextPaneTitle = null;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JLabel vouchersImage = null;
	private int loopCount = 0;
	private JScrollPane scrollPane = null;
	private JScrollBar verticalScrollBar = null;
	private int vouchersId = 0;
	private int vouchersId2 = 0;
	private String title2;
	private String subtitle2;
	private String details2;
	private String image2;
	private int customerId = 0;
	private String username;
	private String customerUsername = "";
	private JLabel errorMessage;

	/**
	 * Create the panel.
	 */

	public UseVouchers(JFrame f, int customerId) {
		super();
		myFrame = f;
		this.customerId = customerId;
		initialize();
	}

	public void initialize() {
		this.add(getPanel());
		panel.add(getErrorMessage());

		vouchers = CustomerVouchersDAO.retrieveAll(customerId);
		if (vouchers.size() == 0) {
			errorMessage.setText("Customer does not have any vouchers.");
		} else {

		}
		
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane());
		this.add(getJLabelBack());
		this.add(getJLabel());
		this.add(getJLabelImage());
		this.add(getJTextPaneTitle());
		this.add(getJTextPaneSubtitle());
		this.add(getJTextPaneDetails());
		createPanes();
		
		this.add(getScrollPane());

		JButton jButtonRedeem = new JButton("New button");
		jButtonRedeem.setBounds(847, 35, 111, 51);
		jButtonRedeem.setFont(new Font("Calibri", Font.BOLD, 20));
		jButtonRedeem.setForeground(Color.white);
		jButtonRedeem.setText("Delete");
		jButtonRedeem.setBackground(Color.RED);
		jButtonRedeem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				if (createVouchers != null) {
					int option = JOptionPane.showConfirmDialog(myFrame,
							"Are you sure you want to delete " + title2 + "?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						try {
							CustomerVouchersDAO.deleteVoucher(vouchersId2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JPanel panel = new UseVouchers(myFrame, customerId);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
				} else {
					int option1 = JOptionPane.showConfirmDialog(myFrame,
							"Customer has no vouchers!", "Confirmation",
							JOptionPane.YES_NO_OPTION);
				}
			}
		});
		this.add(jButtonRedeem);
		scrollPane.getVerticalScrollBar().setValue(20);
		System.out.println(">>" + scrollPane);
		scrollPane.getVerticalScrollBar().setValues(20, 20, 0, 100);
	}

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
				vouchersId2 = vouchers.get(0).getVouchersId();
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
						title2 = vouchers.get(id - 1).getTitle();
						subtitle2 = vouchers.get(id - 1).getSubtitle();
						details2 = vouchers.get(id - 1).getDetails();
						image2 = vouchers.get(id - 1).getImage();
						vouchersId2 = vouchers.get(id - 1).getVouchersId();
						jLabelImage.setIcon(new ImageIcon(image2));
						jTextPaneTitle.setText(title2);
						jTextPaneSubtitle.setText(subtitle2);
						jTextPaneDetails.setText(details2);
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

	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 78));
		}
		return jTextPane;
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

	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setPreferredSize(new Dimension(55, 24));
			jLabel.setText("Vouchers");
			jLabel.setLocation(new Point(91, 23));
			jLabel.setSize(new Dimension(216, 35));
			jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		}
		return jLabel;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLocation(321, 0);
			panel.setSize(100, 100);
			panel.setPreferredSize(panel.getSize());
			panel.setBackground(new Color(227, 228, 250));
			panel.setLayout(null);
			panel.add(getErrorMessage());
		}
		return panel;
	}

	private JLabel getJLabelImage() {
		if (jLabelImage == null) {
			jLabelImage = new JLabel();
			jLabelImage.setBounds(new Rectangle(578, 123, 111, 114));
			jLabelImage.setText("");
			jLabelImage.setVisible(true);
		}
		return jLabelImage;
	}

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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(panel);
			scrollPane.setAutoscrolls(false);
			scrollPane.setBounds(32, 117, 370, 422);
			scrollPane.setBackground(new Color(227, 228, 250));
		}
		return scrollPane;
	}

	private JLabel getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new JLabel("");
			errorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
			errorMessage.setBounds(70, 100, 338, 30);
		}
		return errorMessage;
	}
}
