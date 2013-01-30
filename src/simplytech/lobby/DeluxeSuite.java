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

public class DeluxeSuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel panel1 = null;
	private Panel panelDeluxeLine = null;
	private JLabel jLabelDeluxeSuite = null;
	private JTextPane jTextPaneAbout = null;
	private JTextPane jTextPaneAboutHeader = null;
	private JLabel jLabelDeluxePicture = null;
	private JLabel jLabelConvenienceText = null;
	private JLabel jLabelFeatureText = null;
	private JLabel jLabelDeluxeBack = null;
	private JFrame myFrame = null;
	private JButton jButtonBook = null;
	/**
	 * This is the default constructor
	 */
	public DeluxeSuite() {
		super();
		initialize();
	}
	public DeluxeSuite(JFrame f) {
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
		jLabelDeluxeBack = new JLabel();
		jLabelDeluxeBack.setText("");
		jLabelDeluxeBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelDeluxeBack.setIcon(new ImageIcon(DeluxeSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelDeluxeBack.addMouseListener(new java.awt.event.MouseListener() {
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
		jLabelFeatureText = new JLabel();
		jLabelFeatureText.setText("");
		jLabelFeatureText.setSize(new Dimension(250, 300));
		jLabelFeatureText.setIcon(new ImageIcon(DeluxeSuite.class.getResource("/simplytech/image/deluxeText2.JPG")));
		jLabelFeatureText.setLocation(new Point(750, 90));
		jLabelConvenienceText = new JLabel();
		jLabelConvenienceText.setIcon(new ImageIcon(DeluxeSuite.class.getResource("/simplytech/image/deluxeText.JPG")));
		jLabelConvenienceText.setLocation(new Point(500, 110));
		jLabelConvenienceText.setSize(new Dimension(300, 300));
		jLabelConvenienceText.setText("");
		jLabelDeluxePicture = new JLabel();
		jLabelDeluxePicture.setText("");
		jLabelDeluxePicture.setIcon(new ImageIcon(DeluxeSuite.class.getResource("/simplytech/image/deluxeSnapshot.JPG")));
		jLabelDeluxePicture.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelDeluxePicture.setSize(new Dimension(500, 269));
		jLabelDeluxePicture.setLocation(new Point(30, 130));
		jLabelDeluxePicture.setEnabled(true);
		jLabelDeluxePicture.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelDeluxeSuite = new JLabel();
		jLabelDeluxeSuite.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelDeluxeSuite.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelDeluxeSuite.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelDeluxeSuite.setBounds(new Rectangle(91, 23, 200, 35));
		jLabelDeluxeSuite.setText("Deluxe Suite");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getPanel1(), null);
		this.add(getPanelOrchidLine(), null);
		this.add(jLabelDeluxeSuite, null);
		this.add(getJTextPaneAbout(), null);
		this.add(getJTextPaneAboutHeader(), null);
		this.add(jLabelDeluxePicture, null);
		this.add(jLabelConvenienceText, null);
		this.add(jLabelFeatureText, null);
		this.add(jLabelDeluxeBack, null);
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
		if (panelDeluxeLine == null) {
			panelDeluxeLine = new Panel();
			panelDeluxeLine.setLayout(null);
			panelDeluxeLine.setFont(new Font("Arial", Font.BOLD, 12));
			panelDeluxeLine.setName("");
			panelDeluxeLine.setLocation(new Point(0, 78));
			panelDeluxeLine.setSize(new Dimension(371, 4));
			panelDeluxeLine.setMinimumSize(new Dimension(300, 4));
			panelDeluxeLine.setBackground(new Color(91, 155, 213));
		}
		return panelDeluxeLine;
	}

	/**
	 * This method initializes jTextPaneAbout	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAbout() {
		if (jTextPaneAbout == null) {
			jTextPaneAbout = new JTextPane();
			jTextPaneAbout.setText("Discover the extraordinary comforts of this priceless gem.This Deluxe Suite offers entertainment in grand style with two magnificent living rooms, dining room and state-of-the-art media room. ");
			jTextPaneAbout.setSize(new Dimension(500, 80));
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
			jTextPaneAboutHeader.setLocation(new Point(30, 396));
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

