package simplytech.staff;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

import simplytech.dao.AnnouncementDAO;
import simplytech.dao.VouchersDAO;
import simplytech.entity.Vouchers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditVouchers extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabelImage;
	private JTextPane jTextPaneTitle = null;
	private JLabel jLabelDate1 = null;
	private JLabel jLabelPointsRequired;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JLabel jLabelDate2 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JPanel panel = null;
	private ArrayList<Vouchers> vouchers;
	private JLabel vouchersImage;
	private String image = null;
	private String title = null;
	private String subtitle = null;
	private String details = null;
	private int pointsRequired = 0;
	private JScrollPane scrollPane;
	private JScrollBar verticalScrollBar = null;
	private String username;
	private int k;
	private int count = 0;
	private ArrayList<JTextPane> panes = new ArrayList<JTextPane>();
	private JTextPane setPanes = null;
	private String[] titles;
	private Vouchers voucher;
	private ArrayList<Vouchers> createVouchers = new ArrayList<Vouchers>();
	private int loopCount = 0;
	private Rectangle rectangle = new Rectangle(0, 0, 0, 1000);
	private JLabel errorMessage;
	private String expiryDate;
	private String previousPanel = null;
	private String voucherType = null;
	private int voucherId;
	private String vouchersType = "Food Vouchers";
	private ArrayList<JLabel> jLabelImagesCancel = new ArrayList<JLabel>();
	private JLabel jLabelImageCancel = null;

	/**
	 * This is the default constructor
	 */
	public EditVouchers() {
		super();
		initialize();
	}

	public EditVouchers(JFrame f) {
		this();
		myFrame = f;
	}

	public EditVouchers(JFrame f, String vouchersType) {
		myFrame = f;
		this.vouchersType = vouchersType;
		initialize();
	}

	private void initialize() {

		jLabelDate2 = new JLabel();
		jLabelPointsRequired = new JLabel();
		jLabelPointsRequired.setBounds(new Rectangle(699, 207, 244, 30));
		jLabelPointsRequired.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelPointsRequired.setVisible(true);
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
		this.add(jLabelPointsRequired, null);
		this.add(getJTextPaneSubtitle(), null);
		this.add(getJTextPaneDetails(), null);
		this.add(jLabelDate2, null);
		this.add(jLabelBack, null);
		this.add(getScrollPane());
		// this.add(panel);
		panel.add(getErrorMessage());
		add(getJBtnCreate());
		add(getBtnFoodVouchers());
		add(getBtnFreeStays());
		add(getBtnRecreation());
		add(getBtnShoppingVouchers());
		vouchers = VouchersDAO.retrieveAll(vouchersType);
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
		vouchers = VouchersDAO.retrieveAll(vouchersType);
		for (k = 0; k < vouchers.size(); k++) {
			if (vouchers.size() != 0) {
				yAxis++;
				voucherId = vouchers.get(k).getId();
				image = vouchers.get(k).getImage();
				title = vouchers.get(k).getTitle();
				subtitle = vouchers.get(k).getSubtitle();
				details = vouchers.get(k).getDetails();
				pointsRequired = vouchers.get(k).getPointsRequired();
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
				jLabelPointsRequired.setText("Points required: "
						+ vouchers.get(0).getPointsRequired());
				vouchersImage = new JLabel();
				vouchersImage.setBounds(new Rectangle(52, -90 + (yAxis * 100),
						80, 69));
				vouchersImage.setIcon(new ImageIcon(image));
				jLabelImageCancel = new JLabel();
				jLabelImageCancel.setName(k + "");
				jLabelImageCancel.setIcon(new ImageIcon(getClass().getResource(
						"/simplyTECH/image/Cancel.png")));
				jLabelImageCancel.setBounds(new Rectangle(300, -105
						+ (yAxis * 100), 189, 109));
				jLabelImageCancel.setVisible(false);
				jLabelImageCancel
						.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseClicked(java.awt.event.MouseEvent e) {
								JLabel q = (JLabel) (e.getSource());
								try {
									int id = Integer.parseInt(q.getName());
									int option = JOptionPane.showConfirmDialog(
											myFrame,
											"Are you sure you want to delete "
													+ vouchers.get(id)
															.getTitle() + "?",
											"Confirmation",
											JOptionPane.YES_NO_OPTION);
									if (option == JOptionPane.YES_OPTION) {
										try {
											VouchersDAO.deleteVoucher(vouchers
													.get(id).getId());
											JPanel panel = new EditVouchers(
													myFrame);
											myFrame.getContentPane()
													.removeAll();
											myFrame.getContentPane().add(panel);
											myFrame.getContentPane()
													.revalidate();
											myFrame.getContentPane().repaint();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								} catch (NumberFormatException nFE) {
								}
							}
						});
				jLabelImagesCancel.add(jLabelImageCancel);
				setPanes.addMouseListener(new RightClicker() {
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
						voucherId = vouchers.get(id - 1).getId();
						pointsRequired = vouchers.get(id - 1)
								.getPointsRequired();
						jLabelImage.setIcon(new ImageIcon(image));
						jTextPaneTitle.setText(title);
						jTextPaneSubtitle.setText(subtitle);
						jTextPaneDetails.setText(details);
						jLabelPointsRequired.setText("Points required: "
								+ pointsRequired);
						panes.get(id - 1).setBackground(new Color(31, 78, 121));
					}
				});
				panel.add(panes.get(loopCount));
				panel.add(vouchersImage);
				panel.add(jLabelImagesCancel.get(k));
				panel.setSize(100, vouchers.size() * 100);
				panel.setPreferredSize(panel.getSize());
				loopCount++;
			}
		}
		return panes;
	}

	private class RightClicker extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (e.isMetaDown()) {
				for (int i = 0; i < jLabelImagesCancel.size(); i++) {
					if (jLabelImagesCancel.get(i).isVisible() == false) {
						jLabelImagesCancel.get(i).setVisible(true);
					} else {
						jLabelImagesCancel.get(i).setVisible(false);
					}
				}
			}
		}
	}

	int l = 0;
	private JButton jBtnCreate;
	private JButton btnFoodVouchers;
	private JButton btnFreeStays;
	private JButton btnRecreation;
	private JButton btnShoppingVouchers;

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
			scrollPane.setBounds(32, 147, 370, 382);
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
			errorMessage.setText("There are no vouchers.");
			errorMessage.setVisible(false);
		}
		return errorMessage;
	}

	private JButton getJBtnCreate() {
		if (jBtnCreate == null) {
			jBtnCreate = new JButton("Create");
			jBtnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JPanel panel = new CreateVouchersPanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jBtnCreate.setBounds(853, 33, 123, 40);
			jBtnCreate.setBackground(new Color(91, 155, 213));
			jBtnCreate.setForeground(new Color(255, 255, 255));
			jBtnCreate.setFont(new Font("Calibri", Font.BOLD, 27));
		}
		return jBtnCreate;
	}

	private JButton getBtnFoodVouchers() {
		if (btnFoodVouchers == null) {
			btnFoodVouchers = new JButton("Food");
			btnFoodVouchers.setBounds(26, 103, 89, 23);
			btnFoodVouchers.setBackground(new Color(91, 155, 213));
			btnFoodVouchers.setForeground(new Color(255, 255, 255));
			btnFoodVouchers.setFont(new Font("Calibri", Font.PLAIN, 18));
			btnFoodVouchers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vouchersType = "Food Vouchers";
					JPanel panel = new EditVouchers(myFrame, vouchersType);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return btnFoodVouchers;
	}

	private JButton getBtnFreeStays() {
		if (btnFreeStays == null) {
			btnFreeStays = new JButton("Stays");
			btnFreeStays.setBounds(120, 103, 89, 23);
			btnFreeStays.setBackground(new Color(91, 155, 213));
			btnFreeStays.setForeground(new Color(255, 255, 255));
			btnFreeStays.setFont(new Font("Calibri", Font.PLAIN, 18));
			btnFreeStays.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vouchersType = "Free Stays";
					JPanel panel = new EditVouchers(myFrame, vouchersType);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});

		}
		return btnFreeStays;
	}

	private JButton getBtnRecreation() {
		if (btnRecreation == null) {
			btnRecreation = new JButton("Relax");
			btnRecreation.setBounds(213, 103, 89, 23);
			btnRecreation.setBackground(new Color(91, 155, 213));
			btnRecreation.setForeground(new Color(255, 255, 255));
			btnRecreation.setFont(new Font("Calibri", Font.PLAIN, 18));
			btnRecreation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vouchersType = "Recreation";
					JPanel panel = new EditVouchers(myFrame, vouchersType);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});

		}
		return btnRecreation;
	}

	private JButton getBtnShoppingVouchers() {
		if (btnShoppingVouchers == null) {
			btnShoppingVouchers = new JButton("Shop");
			btnShoppingVouchers.setBounds(306, 103, 89, 23);
			btnShoppingVouchers.setBackground(new Color(91, 155, 213));
			btnShoppingVouchers.setForeground(new Color(255, 255, 255));
			btnShoppingVouchers.setFont(new Font("Calibri", Font.PLAIN, 18));
			btnShoppingVouchers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vouchersType = "Shopping Vouchers";
					JPanel panel = new EditVouchers(myFrame, vouchersType);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});

		}
		return btnShoppingVouchers;
	}
} // @jve:decl-index=0:visual-constraint="20,10"
