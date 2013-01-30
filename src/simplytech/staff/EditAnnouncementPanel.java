package simplytech.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import simplytech.components.ImageFilter;
import simplytech.components.Utils;
import simplytech.dao.AnnouncementDAO;
import simplytech.dao.CustomerVouchersDAO;
import simplytech.entity.Announcement;
import simplytech.entity.CustomerVouchers;
import simplytech.room.MyAccountsPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

public class EditAnnouncementPanel extends JPanel {

	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JPanel panel = null;
	private JLabel setPanes = null;
	private JScrollPane scrollPane = null;
	private JTextPane highlightPane = null;
	private JLabel announcementImage = null;
	private int customerId = 0;
	private int k = 0;
	private int id = 0;
	private Announcement announcement;
	private String image;
	private String title;
	private String type;
	private String details;
	private String announcementType;
	private JLabel jLabelImage = null;
	private int max;
	private int loopCount = 0;
	private JLabel imageLabel = null;
	private String newTitle = null;
	private String newType = null;
	private String newDetails = null;
	private String newImage = null;
	private ArrayList<Announcement> announcementArr = new ArrayList<Announcement>();
	private ArrayList<JLabel> panes = new ArrayList<JLabel>();
	private ArrayList<JLabel> jLabelImages = new ArrayList<JLabel>();
	private ArrayList<String> titles = new ArrayList<String>();
	private JLabel label = null;
	private JTextPane textPaneDetails = null;
	private ArrayList<JLabel> announcementImages = new ArrayList<JLabel>();
	private String newImageForSql = "";
	private ImageFilter imageFilter = null;
	private int count;
	private int announcementsCount = 0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel jLabelPath;
	private JTextField textFieldTitle;
	private JLabel label_1;

	/**
	 * Create the panel.
	 */

	public EditAnnouncementPanel(JFrame f, String announcementType) {
		super();
		myFrame = f;
		this.announcementType = announcementType;
		initialize();
	}

	public void initialize() {

		announcementArr = AnnouncementDAO.retrieveAll(announcementType);
		if (announcementArr.size() == 0) {
			// errorMessage.setText("Customer does not have any vouchers");
		} else {
			type = announcementArr.get(0).getType();
			image = announcementArr.get(0).getImage();
			title = announcementArr.get(0).getTitle();
			details = announcementArr.get(0).getDetails();
			id = announcementArr.get(0).getId();
		}
		imageFilter = new ImageFilter();
		this.setLayout(null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJLabelBack());
		this.add(getJTextPane());
		this.add(getJLabel());
		this.add(getPanel());
		this.add(getScrollPane());

		JButton jBtnCreate = new JButton("Create");
		jBtnCreate.setForeground(new Color(255, 255, 255));
		jBtnCreate.setFont(new Font("Calibri", Font.BOLD, 33));
		jBtnCreate.setBackground(new Color(91, 155, 213));
		jBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (!(newDetails.isEmpty()) && !(newTitle.isEmpty())
							&& !(newImage.isEmpty())) {
						int option = JOptionPane.showConfirmDialog(myFrame,
								"Create " + newTitle + "?", "Confirmation",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							for (int i = 0; i < newImage.length(); i++) {
								if (newImage.charAt(i) == '\\') {
									newImageForSql = newImageForSql + "\\\\";
								} else {
									newImageForSql = newImageForSql
											+ newImage.charAt(i);
								}
							}
							Announcement announcement = new Announcement(
									newTitle, newDetails, newImageForSql,
									announcementType);
							try {
								AnnouncementDAO
										.createAnnouncement(announcement);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							JPanel panel = new EditAnnouncementPanel(myFrame,
									announcementType);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					} else {
						int option1 = JOptionPane.showConfirmDialog(myFrame,
								"Do not leave any fields blank!",
								"Confirmation", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception e) {
					int option1 = JOptionPane.showConfirmDialog(myFrame,
							"Do not leave any fields blank!", "Confirmation",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		jBtnCreate.setBounds(661, 508, 128, 47);
		add(jBtnCreate);

		imageLabel = new JLabel("");
		imageLabel.setText("null");
		imageLabel.setBounds(570, 114, 203, 149);
		add(imageLabel);

		label = new JLabel();
		label.setBounds(783, 117, 139, 149);
		label.setBackground(new Color(227, 228, 250));
		label.setText("<html>\r\n<body>\r\n<h2>" + newTitle
				+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>" + newDetails
				+ "</p>\r\n</body>\r\n</html>");
		add(label);
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getJLabelPath());

		textFieldTitle = new JTextField();
		textFieldTitle.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				newTitle = textFieldTitle.getText();
				label.setText("<html>\r\n<body>\r\n<h2>" + newTitle
						+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>"
						+ newDetails + "</p>\r\n</body>\r\n</html>");

			}
		});
		textFieldTitle.setBounds(580, 322, 293, 20);
		add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textPaneDetails = new JTextPane();
		textPaneDetails.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				newDetails = textPaneDetails.getText();
				label.setText("<html>\r\n<body>\r\n<h2>" + newTitle
						+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>"
						+ newDetails + "</p>\r\n</body>\r\n</html>");

			}
		});
		textPaneDetails.setBounds(584, 375, 293, 82);
		add(textPaneDetails);

		JLabel lblImage = new JLabel("Image:");
		lblImage.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblImage.setBounds(504, 284, 60, 20);
		add(lblImage);

		JLabel lblChange = new JLabel("Upload");
		lblChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.showDialog(jfc, "Choose an image file");
				if (jfc.getSelectedFile() != null) {
					ImageFilter imageFilter = new ImageFilter();
					if (imageFilter(jfc.getSelectedFile())) {
						newImage = jfc.getSelectedFile().getAbsolutePath();
						jLabelPath.setText(newImage);
						imageLabel.setIcon(new ImageIcon(newImage));
						imageLabel.setText("");
					}
				}
			}
		});
		lblChange.setFont(new Font("Calibri", Font.BOLD, 12));
		lblChange.setForeground(new Color(58, 115, 255));
		lblChange.setBounds(876, 289, 46, 14);
		add(lblChange);
		add(getLabel_1());
		createPanes();

	}

	private boolean imageFilter(File f) {
		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.tiff) || extension.equals(Utils.tif)
					|| extension.equals(Utils.gif)
					|| extension.equals(Utils.jpeg)
					|| extension.equals(Utils.jpg)
					|| extension.equals(Utils.png)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	private ArrayList<JLabel> createPanes() {
		int yAxis = 0;

		for (k = 0; k < announcementArr.size(); k++) {
			if (announcementArr.size() != 0) {
				yAxis++;
				image = announcementArr.get(k).getImage();
				title = announcementArr.get(k).getTitle();
				titles.add(announcementArr.get(k).getTitle());
				details = announcementArr.get(k).getDetails();
				setPanes = new JLabel();
				setPanes.setBounds(new Rectangle(172, -105 + (yAxis * 125),
						189, 109));
				setPanes.setFont(new Font("Calibri", Font.PLAIN, 20));
				setPanes.setText("<html>\r\n<body>\r\n<h2>" + title
						+ "</h2>\r\n</br>\r\n</br>\r\n</br>\r\n<p>" + details
						+ "</p>\r\n</body>\r\n</html>");
				setPanes.setName(yAxis + "");
				panes.add(setPanes);
				panes.get(0).setBackground(new Color(31, 78, 121));
				jLabelImage = new JLabel();
				jLabelImage.setName(k + "");
				jLabelImage.setIcon(new ImageIcon(getClass().getResource(
						"/simplyTECH/image/Cancel.png")));
				jLabelImage.setBounds(new Rectangle(322, -135 + (yAxis * 125),
						189, 109));
				jLabelImage.setVisible(false);
				jLabelImage.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						JLabel q = (JLabel) (e.getSource());
						try {
							int id = Integer.parseInt(q.getName());
							int option = JOptionPane.showConfirmDialog(
									myFrame,
									"Are you sure you want to delete "
											+ titles.get(id) + "?",
									"Confirmation", JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								try {
									AnnouncementDAO
											.deleteAnnouncement(announcementArr
													.get(id).getId());
									JPanel panel = new EditAnnouncementPanel(
											myFrame, announcementType);
									myFrame.getContentPane().removeAll();
									myFrame.getContentPane().add(panel);
									myFrame.getContentPane().revalidate();
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
				jLabelImages.add(jLabelImage);
				announcementImage = new JLabel();
				announcementImage.setIcon(new ImageIcon(image));
				announcementImage.setBounds(new Rectangle(12, -105
						+ (yAxis * 125), 150, 109));

				setPanes.addMouseListener(new RightClicker() {
					public void mouseClicked(MouseEvent arg0) {
						for (int i = 0; i < panes.size(); i++) {
							panes.get(i).setBackground(new Color(91, 155, 213));
						}
						JLabel p = (JLabel) (arg0.getSource());
						String stringID = p.getName() + "";
						int id = Integer.parseInt(stringID);
						panes.get(id - 1).setBackground(new Color(31, 78, 121));
					}
				});
				panel.add(jLabelImage);
				panel.add(panes.get(loopCount));
				panel.add(announcementImage);
				panel.setSize(100, announcementArr.size() * 128);
				panel.setPreferredSize(panel.getSize());
				loopCount++;
			}
		}
		return panes;
	}

	private class RightClicker extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (e.isMetaDown()) {
				for (int i = 0; i < jLabelImages.size(); i++) {
					if (jLabelImages.get(i).isVisible() == false) {
						jLabelImages.get(i).setVisible(true);
					} else {
						jLabelImages.get(i).setVisible(false);
					}
				}
			}
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(panel);
			scrollPane.setBounds(32, 117, 390, 422);
			scrollPane.setBackground(new Color(227, 228, 250));

		}
		return scrollPane;
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

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLocation(321, 0);
			panel.setSize(100, 100);
			panel.setPreferredSize(panel.getSize());
			panel.setBackground(new Color(227, 228, 250));
			panel.setLayout(null);
		}
		return panel;
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

	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setPreferredSize(new Dimension(55, 24));
			jLabel.setText("Edit Announcement");
			jLabel.setLocation(new Point(91, 23));
			jLabel.setSize(new Dimension(341, 35));
			jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		}
		return jLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Title:");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(518, 324, 52, 14);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Details:");
			lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(504, 375, 70, 14);
		}
		return lblNewLabel_2;
	}

	private JLabel getJLabelPath() {
		if (jLabelPath == null) {
			jLabelPath = new JLabel("");
			jLabelPath.setText(null);
			jLabelPath.setBounds(580, 284, 293, 23);
		}
		return jLabelPath;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel();
			label_1.setText("(" + announcementType + ")");
			label_1.setSize(new Dimension(341, 35));
			label_1.setPreferredSize(new Dimension(55, 24));
			label_1.setLocation(new Point(91, 23));
			label_1.setFont(new Font("Arial", Font.BOLD, 15));
			label_1.setBounds(362, 28, 341, 35);
		}
		return label_1;
	}
}
