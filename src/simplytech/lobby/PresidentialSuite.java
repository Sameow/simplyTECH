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

public class PresidentialSuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel panel1 = null;
	private Panel panelOrchidLine = null;
	private JLabel jLabelPresidentialSuite = null;
	private JTextPane jTextPaneAbout = null;
	private JTextPane jTextPaneAboutHeader = null;
	private JLabel jLabelPresidentialPicture = null;
	private JLabel jLabelConvenienceText = null;
	private JLabel jLabelFeatureText = null;
	private JLabel jLabelPresidentialBack = null;
	private JFrame myFrame = null;
	private JButton jButtonBook = null;
	/**
	 * This is the default constructor
	 */
	public PresidentialSuite() {
		super();
		initialize();
	}
	public PresidentialSuite(JFrame f) {
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
		jLabelPresidentialBack = new JLabel();
		jLabelPresidentialBack.setText("");
		jLabelPresidentialBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelPresidentialBack.setIcon(new ImageIcon(PresidentialSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelPresidentialBack.addMouseListener(new java.awt.event.MouseListener() {
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
		jLabelFeatureText.setSize(new Dimension(274, 300));
		jLabelFeatureText.setIcon(new ImageIcon(PresidentialSuite.class.getResource("/simplytech/image/presidentialText2.JPG")));
		jLabelFeatureText.setLocation(new Point(735, 115));
		jLabelConvenienceText = new JLabel();
		jLabelConvenienceText.setIcon(new ImageIcon(PresidentialSuite.class.getResource("/simplytech/image/presidentialText.JPG")));
		jLabelConvenienceText.setLocation(new Point(500, 110));
		jLabelConvenienceText.setSize(new Dimension(300, 300));
		jLabelConvenienceText.setText("");
		jLabelPresidentialPicture = new JLabel();
		jLabelPresidentialPicture.setText("");
		jLabelPresidentialPicture.setIcon(new ImageIcon(PresidentialSuite.class.getResource("/simplytech/image/presidentialSnapshot.JPG")));
		jLabelPresidentialPicture.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelPresidentialPicture.setSize(new Dimension(500, 269));
		jLabelPresidentialPicture.setLocation(new Point(30, 130));
		jLabelPresidentialPicture.setEnabled(true);
		jLabelPresidentialPicture.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelPresidentialSuite = new JLabel();
		jLabelPresidentialSuite.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelPresidentialSuite.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelPresidentialSuite.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPresidentialSuite.setBounds(new Rectangle(91, 23, 250, 35));
		jLabelPresidentialSuite.setText("Presidential Suite");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getPanel1(), null);
		this.add(getPanelOrchidLine(), null);
		this.add(jLabelPresidentialSuite, null);
		this.add(getJTextPaneAbout(), null);
		this.add(getJTextPaneAboutHeader(), null);
		this.add(jLabelPresidentialPicture, null);
		this.add(jLabelConvenienceText, null);
		this.add(jLabelFeatureText, null);
		this.add(jLabelPresidentialBack, null);
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
			jTextPaneAbout.setText("Experience the ultimate in luxury. This 629-square meter suite offers unobstructed views of the striking Singapore city skyline or lush Gardens by the Bay from three bedroom balconies.");
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

