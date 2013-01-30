package simplytech.lobby;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class SandsSuite extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelSandsBack = null;
	private Panel sandsPanelLine = null;
	private JLabel jLabelSandsSuiteHeader = null;
	private JLabel jLabelSandsSnapshot = null;
	private JTextPane jTextPaneSands = null;
	private JTextPane jTextPaneSandsHeader = null;
	private JFrame myFrame = null;
	private JLabel jLabelSandsConvenience = null;
	private JLabel jLabelSandsFeatures = null;
	private JButton jButtonBook = null;

	/**
	 * This is the default constructor
	 */
	public SandsSuite() {
		super();
		initialize();
	}
	public SandsSuite(JFrame f){
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
		jLabelSandsFeatures = new JLabel();
		jLabelSandsFeatures.setIcon(new ImageIcon(SandsSuite.class.getResource("/simplytech/image/sandsText2.JPG")));
		jLabelSandsFeatures.setLocation(new Point(750, 120));
		jLabelSandsFeatures.setSize(new Dimension(250, 250));
		jLabelSandsFeatures.setText("");
		jLabelSandsConvenience = new JLabel();
		jLabelSandsConvenience.setIcon(new ImageIcon(SandsSuite.class.getResource("/simplytech/image/sandsText.JPG")));
		jLabelSandsConvenience.setPreferredSize(new Dimension(100, 252));
		jLabelSandsConvenience.setBounds(new Rectangle(500, 120, 250, 250));
		jLabelSandsConvenience.setText("");
		jLabelSandsSnapshot = new JLabel();
		jLabelSandsSnapshot.setIcon(new ImageIcon(SandsSuite.class.getResource("/simplytech/image/sandsSnapshot.JPG")));
		jLabelSandsSnapshot.setBounds(new Rectangle(30, 120, 420, 250));
		jLabelSandsSnapshot.setText("");
		jLabelSandsSuiteHeader = new JLabel();
		jLabelSandsSuiteHeader.setBounds(new Rectangle(91, 23, 167, 35));
		jLabelSandsSuiteHeader.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelSandsSuiteHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelSandsSuiteHeader.setText("Sands Suite");
		jLabelSandsSuiteHeader.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelSandsBack = new JLabel();
		jLabelSandsBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelSandsBack.setText("");
		jLabelSandsBack.setIcon(new ImageIcon(SandsSuite.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelSandsBack.addMouseListener(new java.awt.event.MouseListener() {
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
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.setBounds(new Rectangle(0, 0, 1024, 600));
		this.add(jLabelSandsBack, null);
		this.add(getSandsPanelLine(), null);
		this.add(jLabelSandsSuiteHeader, null);
		this.add(jLabelSandsSnapshot, null);
		this.add(getJTextPaneSands(), null);
		this.add(getJTextPaneOrchidHeader(), null);
		this.add(jLabelSandsConvenience, null);
		this.add(jLabelSandsFeatures, null);
		this.add(getJButtonBook(), null);
	}

	/**
	 * This method initializes sandsPanelLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getSandsPanelLine() {
		if (sandsPanelLine == null) {
			sandsPanelLine = new Panel();
			sandsPanelLine.setLayout(null);
			sandsPanelLine.setFont(new Font("Arial", Font.BOLD, 12));
			sandsPanelLine.setMinimumSize(new Dimension(300, 4));
			sandsPanelLine.setName("");
			sandsPanelLine.setBounds(new Rectangle(0, 78, 371, 4));
			sandsPanelLine.setBackground(new Color(91, 155, 213));
		}
		return sandsPanelLine;
	}

	/**
	 * This method initializes jTextPaneSands	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneSands() {
		if (jTextPaneSands == null) {
			jTextPaneSands = new JTextPane();
			jTextPaneSands.setBounds(new Rectangle(30, 425, 580, 100));
			jTextPaneSands.setText("Relax in comfort and luxury as you enjoy dedicated butler service 24-hours a day. Choose a Sands Suite with Sea View for a guaranteed view of the best horizon of a five-star hotel in Singapore. ");
			jTextPaneSands.setFont(new Font("Arial", Font.PLAIN, 17));
			jTextPaneSands.setEditable(false);
			jTextPaneSands.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneSands;
	}

	/**
	 * This method initializes jTextPaneOrchidHeader	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneOrchidHeader() {
		if (jTextPaneSandsHeader == null) {
			jTextPaneSandsHeader = new JTextPane();
			jTextPaneSandsHeader.setText("About");
			jTextPaneSandsHeader.setFont(new Font("Arial", Font.BOLD, 22));
			jTextPaneSandsHeader.setBounds(new Rectangle(30, 390, 100, 30));
			jTextPaneSandsHeader.setEditable(false);
			jTextPaneSandsHeader.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneSandsHeader;
	}
	/**
	 * This method initializes jButtonBook	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBook() {
		if (jButtonBook == null) {
			jButtonBook = new JButton();
			jButtonBook.setText("Book");
			jButtonBook.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonBook.setFont(new Font("Arial", Font.BOLD, 24));
			jButtonBook.setBounds(new Rectangle(770, 440, 150, 80));
			jButtonBook.setForeground(Color.white);
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

}  //  @jve:decl-index=0:visual-constraint="10,-4"
