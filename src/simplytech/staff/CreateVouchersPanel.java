package simplytech.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import simplytech.components.ImageFilter;
import simplytech.components.Utils;
import simplytech.dao.VouchersDAO;
import simplytech.entity.Vouchers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateVouchersPanel extends JPanel {

	private JLabel jLabelBack = null;
	private JFrame myFrame = null;
	private JLabel jLabel = null;
	private JTextPane jTextPane = null;
	private JLabel jLabelNewImage = null;
	private JTextPane jTextPaneTitle = null;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JLabel lblNewLabel = null;
	private JTextPane jTextPane1 = null;
	private JTextField textFieldTitle;
	private JTextField textFieldSubtitle;
	private JLabel jLabelPath = null;
	private JTextPane textPaneDetails = null;
	private JLabel lblDetails = null;
	private JLabel lblSubtitle = null;
	private JLabel lblTitle = null;
	private JLabel lblImage = null;
	private String newImage;
	private JLabel lblPoints;
	private JSpinner spinner;
	private JButton btnNewButton;
	private String newType;
	private String newTitle;
	private String newSubtitle;
	private String newDetails;
	private int newPointsRequired;
	private JLabel lblType;
	private JComboBox comboBoxType;

	/**
	 * Create the panel.
	 */
	public CreateVouchersPanel(JFrame f) {
		super();
		myFrame = f;
		initialize();
	}

	public void initialize() {
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource(
				"/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new EditVouchers(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Create Vouchers");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(260, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelNewImage = new JLabel("");
		jLabelNewImage.setBounds(42, 172, 110, 105);

		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBack);
		this.add(jLabel);
		this.add(getJTextPane());
		this.add(jLabelNewImage);
		this.add(getJTextPane1());

		jTextPaneTitle = new JTextPane();
		jTextPaneTitle.setBounds(new Rectangle(162, 172, 147, 35));
		jTextPaneTitle.setText(newTitle);
		// jTextPaneTitle.setBounds(new Rectangle(215, 210, 152, 60));
		jTextPaneTitle.setFont(new Font("Calibri", Font.BOLD, 22));
		jTextPaneTitle.setBackground(new Color(227, 228, 250));
		add(jTextPaneTitle);

		jTextPaneSubtitle = new JTextPane();
		jTextPaneSubtitle.setText(newSubtitle);
		jTextPaneSubtitle.setBounds(new Rectangle(162, 208, 147, 73));
		jTextPaneSubtitle.setBackground(new Color(227, 228, 250));
		jTextPaneSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		add(jTextPaneSubtitle);

		jTextPaneDetails = new JTextPane();
		jTextPaneDetails.setText(newDetails);
		jTextPaneDetails.setBounds(45, 321, 264, 202);
		jTextPaneDetails.setFont(new Font("Calibri", Font.PLAIN, 16));
		jTextPaneDetails.setBackground(new Color(227, 228, 250));
		add(jTextPaneDetails);

		lblImage = new JLabel("Image:");
		lblImage.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblImage.setBounds(418, 161, 76, 23);
		add(lblImage);
		lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTitle.setBounds(430, 259, 64, 14);
		add(lblTitle);

		lblSubtitle = new JLabel("Subtitle:");
		lblSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSubtitle.setBounds(405, 312, 89, 14);
		add(lblSubtitle);

		lblDetails = new JLabel("Details:");
		lblDetails.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDetails.setBounds(410, 365, 64, 14);
		add(lblDetails);

		textFieldTitle = new JTextField();
		textFieldTitle.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				newTitle = textFieldTitle.getText();
				jTextPaneTitle.setText(textFieldTitle.getText());
			}
		});
		textFieldTitle.setBounds(492, 257, 260, 20);
		add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textFieldSubtitle = new JTextField();
		textFieldSubtitle.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				newSubtitle = textFieldSubtitle.getText();
				jTextPaneSubtitle.setText(textFieldSubtitle.getText());
			}
		});
		textFieldSubtitle.setColumns(10);
		textFieldSubtitle.setBounds(492, 310, 260, 20);
		add(textFieldSubtitle);

		textPaneDetails = new JTextPane();
		textPaneDetails.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				jTextPaneDetails.setText(textPaneDetails.getText());
				newDetails = textPaneDetails.getText();
			}
		});
		textPaneDetails.setBounds(492, 359, 264, 105);
		add(textPaneDetails);

		jLabelPath = new JLabel("null");
		jLabelPath.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLabelPath.setBounds(492, 166, 260, 14);
		add(jLabelPath);

		JLabel lblUpload = new JLabel("Upload");
		lblUpload.setBounds(775, 172, 46, 18);
		lblUpload.setFont(new Font("Calibri", Font.BOLD, 12));
		lblUpload.setForeground(new Color(58, 115, 255));
		lblUpload.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.showDialog(jfc, "Choose an image file");
				if (jfc.getSelectedFile() != null) {
					ImageFilter imageFilter = new ImageFilter();
					if (imageFilter(jfc.getSelectedFile())) {
						newImage = jfc.getSelectedFile().getAbsolutePath();
						jLabelPath.setText(newImage);
						jLabelNewImage.setIcon(new ImageIcon(newImage));
						jLabelNewImage.setText("");
					}
				}
			}
		});
		add(lblUpload);

		lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPoints.setBounds(419, 208, 76, 23);
		add(lblPoints);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(100)));
		spinner.setBounds(495, 210, 64, 20);
		add(spinner);

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newImageForSql = "";
				newType = (String) comboBoxType.getSelectedItem();
				try {
					newPointsRequired = (int) spinner.getValue();
				} catch (NumberFormatException nFE) {
				}
				try {
					if (!(newImage.isEmpty()) && !(newTitle.isEmpty())
							&& !(newSubtitle.isEmpty())
							&& !(newDetails.isEmpty())
							&& !(newType.equals("Choose type"))
							&& (newPointsRequired != 0)) {
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
							System.out.println(">>>>>" + newPointsRequired);
							Vouchers voucher = new Vouchers(newType, newTitle,
									newSubtitle, newDetails, newImageForSql,
									newPointsRequired);
							try {
								VouchersDAO.createVoucher(voucher);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} else {
						JOptionPane.showConfirmDialog(myFrame,
								"Do not leave any fields blank.",
								"Confirmation", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showConfirmDialog(myFrame,
							"Do not leave any fields blank!", "Confirmation",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(831, 500, 110, 36);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(91, 155, 213));
		btnNewButton.setText("Create");
		add(btnNewButton);

		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblType.setBounds(419, 493, 55, 14);
		add(lblType);

		comboBoxType = new JComboBox();
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {
				"Choose type", "Food Vouchers", "Free Stays", "Recreation",
				"Shopping Vouchers" }));
		comboBoxType.setBounds(492, 489, 200, 23);
		add(comboBoxType);
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

	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setBackground(new Color(91, 155, 213));
			jTextPane1.setSize(new Dimension(4, 351));
			jTextPane1.setLocation(new Point(378, 156));
		}
		return jTextPane1;
	}

	private boolean imageFilter(File f) {
		if (f.isDirectory()) {
			return true;
		}

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

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
