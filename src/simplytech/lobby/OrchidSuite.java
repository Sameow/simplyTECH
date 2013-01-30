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

public class OrchidSuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel panel1 = null;
	private Panel panelOrchidLine = null;
	private JLabel jLabelOrchidSuite = null;
	private JTextPane jTextPaneAbout = null;
	private JTextPane jTextPaneAboutHeader = null;
	private JLabel jLabelOrchidPicture = null;
	private JTextPane jTextPaneConvenienceHeader = null;
	private JLabel jLabelConvenienceText = null;
	private JTextPane jTextPaneFeatureHeader = null;
	private JLabel jLabelFeatureText = null;
	private JLabel jLabelOrchidBack = null;
	private JFrame myFrame = null;
	private JButton jButtonBook = null;
	/**
	 * This is the default constructor
	 */
	public OrchidSuite() {
		super();
		initialize();
	}
	public OrchidSuite(JFrame f) {
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
		jLabelOrchidBack = new JLabel();
		jLabelOrchidBack.setText("");
		jLabelOrchidBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelOrchidBack.setIcon(new ImageIcon(OrchidSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelOrchidBack.addMouseListener(new java.awt.event.MouseListener() {
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
		jLabelFeatureText.setIcon(new ImageIcon(OrchidSuite.class.getResource("/simplytech/image/featureText.JPG")));
		jLabelFeatureText.setLocation(new Point(750, 110));
		jLabelConvenienceText = new JLabel();
		jLabelConvenienceText.setIcon(new ImageIcon(OrchidSuite.class.getResource("/simplytech/image/convenienceText.jpg")));
		jLabelConvenienceText.setLocation(new Point(500, 110));
		jLabelConvenienceText.setSize(new Dimension(300, 300));
		jLabelConvenienceText.setText("");
		jLabelOrchidPicture = new JLabel();
		jLabelOrchidPicture.setText("");
		jLabelOrchidPicture.setIcon(new ImageIcon(OrchidSuite.class.getResource("/simplytech/image/orchidSnapshot.jpg")));
		jLabelOrchidPicture.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelOrchidPicture.setSize(new Dimension(500, 300));
		jLabelOrchidPicture.setLocation(new Point(30, 110));
		jLabelOrchidPicture.setEnabled(true);
		jLabelOrchidPicture.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelOrchidSuite = new JLabel();
		jLabelOrchidSuite.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelOrchidSuite.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelOrchidSuite.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelOrchidSuite.setBounds(new Rectangle(91, 23, 200, 35));
		jLabelOrchidSuite.setText("Orchid Suite");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getPanel1(), null);
		this.add(getPanelOrchidLine(), null);
		this.add(jLabelOrchidSuite, null);
		this.add(getJTextPaneAbout(), null);
		this.add(getJTextPaneAboutHeader(), null);
		this.add(jLabelOrchidPicture, null);
		this.add(getJTextPaneConvenienceHeader(), null);
		this.add(jLabelConvenienceText, null);
		this.add(getJTextPaneFeatureHeader(), null);
		this.add(jLabelFeatureText, null);
		this.add(jLabelOrchidBack, null);
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
		if (panelOrchidLine == null) {
			panelOrchidLine = new Panel();
			panelOrchidLine.setLayout(null);
			panelOrchidLine.setFont(new Font("Arial", Font.BOLD, 12));
			panelOrchidLine.setName("");
			panelOrchidLine.setLocation(new Point(0, 78));
			panelOrchidLine.setSize(new Dimension(371, 4));
			panelOrchidLine.setMinimumSize(new Dimension(300, 4));
			panelOrchidLine.setBackground(new Color(91, 155, 213));
		}
		return panelOrchidLine;
	}

	/**
	 * This method initializes jTextPaneAbout	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAbout() {
		if (jTextPaneAbout == null) {
			jTextPaneAbout = new JTextPane();
			jTextPaneAbout.setText("This Orchid Suite offers a separate bedroom with a spacious, comfortable king size bed set apart from the serene living quarters.");
			jTextPaneAbout.setSize(new Dimension(450, 80));
			jTextPaneAbout.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneAbout.setBackground(new Color(227, 228, 250));
			jTextPaneAbout.setEditable(false);
			jTextPaneAbout.setLocation(new Point(30, 420));
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
	 * This method initializes jTextPaneConvenienceHeader	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneConvenienceHeader() {
		if (jTextPaneConvenienceHeader == null) {
			jTextPaneConvenienceHeader = new JTextPane();
			jTextPaneConvenienceHeader.setFont(new Font("Calibri", Font.BOLD, 20));
			jTextPaneConvenienceHeader.setSize(new Dimension(130, 30));
			jTextPaneConvenienceHeader.setText("Convenience");
			jTextPaneConvenienceHeader.setBackground(new Color(227, 228, 250));
			jTextPaneConvenienceHeader.setEditable(false);
			jTextPaneConvenienceHeader.setLocation(new Point(500, 130));
		}
		return jTextPaneConvenienceHeader;
	}

	/**
	 * This method initializes jTextPaneFeatureHeader	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneFeatureHeader() {
		if (jTextPaneFeatureHeader == null) {
			jTextPaneFeatureHeader = new JTextPane();
			jTextPaneFeatureHeader.setText("Features");
			jTextPaneFeatureHeader.setSize(new Dimension(80, 30));
			jTextPaneFeatureHeader.setFont(new Font("Calibri", Font.BOLD, 20));
			jTextPaneFeatureHeader.setBackground(new Color(227, 228, 250));
			jTextPaneFeatureHeader.setLocation(new Point(750, 130));
		}
		return jTextPaneFeatureHeader;
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
