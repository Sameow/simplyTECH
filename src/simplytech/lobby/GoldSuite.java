package simplytech.lobby;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GoldSuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel panel1 = null;
	private Panel panelGoldLine = null;
	private JLabel jLabelGoldSuite = null;
	private JTextPane jTextPaneAbout = null;
	private JTextPane jTextPaneAboutHeader = null;
	private JLabel jLabelGoldPicture = null;
	private JLabel jLabelGoldConvenienceText = null;
	private JLabel jLabelGoldFeatureText = null;
	private JLabel jLabelGoldBack = null;
	private JFrame myFrame = null;
	private JButton jButtonBook = null;
	/**
	 * This is the default constructor
	 */
	public GoldSuite() {
		super();
		initialize();
	}
	public GoldSuite(JFrame f) {
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
		jLabelGoldBack = new JLabel();
		jLabelGoldBack.setText("");
		jLabelGoldBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelGoldBack.setIcon(new ImageIcon(GoldSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelGoldBack.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new LobbySuite(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
			}
			public void mouseReleased(java.awt.event.MouseEvent e) {
			}
			public void mouseEntered(java.awt.event.MouseEvent e) {
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
			}
		});
		jLabelGoldFeatureText = new JLabel();
		jLabelGoldFeatureText.setText("");
		jLabelGoldFeatureText.setSize(new Dimension(250, 300));
		jLabelGoldFeatureText.setIcon(new ImageIcon(GoldSuite.class.getResource("/simplytech/image/goldText2.JPG")));
		jLabelGoldFeatureText.setLocation(new Point(750, 110));
		jLabelGoldConvenienceText = new JLabel();
		jLabelGoldConvenienceText.setIcon(new ImageIcon(GoldSuite.class.getResource("/simplytech/image/goldText.JPG")));
		jLabelGoldConvenienceText.setLocation(new Point(500, 110));
		jLabelGoldConvenienceText.setSize(new Dimension(300, 300));
		jLabelGoldConvenienceText.setText("");
		jLabelGoldPicture = new JLabel();
		jLabelGoldPicture.setText("");
		jLabelGoldPicture.setIcon(new ImageIcon(GoldSuite.class.getResource("/simplytech/image/GoldSuite.jpg")));
		jLabelGoldPicture.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelGoldPicture.setSize(new Dimension(500, 269));
		jLabelGoldPicture.setLocation(new Point(30, 130));
		jLabelGoldPicture.setEnabled(true);
		jLabelGoldPicture.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelGoldSuite = new JLabel();
		jLabelGoldSuite.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelGoldSuite.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelGoldSuite.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelGoldSuite.setBounds(new Rectangle(91, 23, 200, 35));
		jLabelGoldSuite.setText("Gold Suite");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getPanel1(), null);
		this.add(getPanelOrchidLine(), null);
		this.add(jLabelGoldSuite, null);
		this.add(getJTextPaneAbout(), null);
		this.add(getJTextPaneAboutHeader(), null);
		this.add(jLabelGoldPicture, null);
		this.add(jLabelGoldConvenienceText, null);
		this.add(jLabelGoldFeatureText, null);
		this.add(jLabelGoldBack, null);
		this.add(getJButtonBook(), null);
	}

	/**
	 * This method initializes panel1	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanel1() {
		if (panel1 == null) {
			panel1 = new Panel();
			panel1.setLayout(new GridBagLayout());
			panel1.setBackground(new Color(91, 155, 213));
			panel1.setBounds(new Rectangle(0, 0, 0, 0));
			panel1.setMinimumSize(new Dimension(200, 300));
		}
		return panel1;
	}

	/**
	 * This method initializes panelOrchidLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanelOrchidLine() {
		if (panelGoldLine == null) {
			panelGoldLine = new Panel();
			panelGoldLine.setLayout(null);
			panelGoldLine.setFont(new Font("Arial", Font.BOLD, 12));
			panelGoldLine.setName("");
			panelGoldLine.setLocation(new Point(0, 78));
			panelGoldLine.setSize(new Dimension(371, 4));
			panelGoldLine.setMinimumSize(new Dimension(300, 4));
			panelGoldLine.setBackground(new Color(91, 155, 213));
		}
		return panelGoldLine;
	}

	/**
	 * This method initializes jTextPaneAbout	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAbout() {
		if (jTextPaneAbout == null) {
			jTextPaneAbout = new JTextPane();
			jTextPaneAbout.setText("Revel in inspired elegance of the suite.This Gold Suite offers Ample entertainment areas and a dedicated butler team 24-hours a day ensure a magnificent stay.");
			jTextPaneAbout.setSize(new Dimension(450, 80));
			jTextPaneAbout.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneAbout.setBackground(new Color(227, 228, 250));
			jTextPaneAbout.setEditable(false);
			jTextPaneAbout.setLocation(new Point(30, 425));
		}
		return jTextPaneAbout;
	}

	/**
	 * This method initializes jTextPaneAboutHeader	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAboutHeader() {
		if (jTextPaneAboutHeader == null) {
			jTextPaneAboutHeader = new JTextPane();
			jTextPaneAboutHeader.setEditable(false);
			jTextPaneAboutHeader.setBackground(new Color(227, 228, 250));
			jTextPaneAboutHeader.setLocation(new Point(30, 390));
			jTextPaneAboutHeader.setText("About");
			jTextPaneAboutHeader.setFont(new Font("Calibri", Font.BOLD, 24));
			jTextPaneAboutHeader.setPreferredSize(new Dimension(100, 30));
			jTextPaneAboutHeader.setSize(new Dimension(80, 40));
		}
		return jTextPaneAboutHeader;
	}
	/**
	 * This method initializes jButtonBook	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBook() {
		if (jButtonBook == null) {
			jButtonBook = new JButton();
			jButtonBook.setBounds(new Rectangle(770, 440, 150, 80));
			jButtonBook.setFont(new Font("Arial", Font.BOLD, 24));
			jButtonBook.setForeground(Color.white);
			jButtonBook.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonBook.setText("Book");
			jButtonBook.setBackground(new Color(91, 155, 213));
			jButtonBook.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanel panel = new Accommodations(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jButtonBook;
	}

}

