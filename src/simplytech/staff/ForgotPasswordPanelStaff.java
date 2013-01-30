package simplytech.staff;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.KeyEvent;

public class ForgotPasswordPanelStaff extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JEditorPane jEditorPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JTextField jTextFieldFullName = null;
	private JTextField jTextFieldID = null;
	private JTextField jTextFieldUsername = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel3 = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabel4 = null;
	private JButton jButtonDone = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel51 = null;
	private JLabel jLabel511 = null;
	private JLabel jLabelBack = null;
	/**
	 * This is the default constructor
	 */
	public ForgotPasswordPanelStaff() {
		super();
		initialize();
	}

	public ForgotPasswordPanelStaff(JFrame f){
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
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/Image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			//	System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new WelcomePanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabel511 = new JLabel();
		jLabel511.setBounds(new Rectangle(577, 545, 371, 23));
		jLabel511.setText("123abc@hotmail.com");
		jLabel511.setVerticalAlignment(SwingConstants.CENTER);
		jLabel511.setForeground(new Color(49, 122, 182));
		jLabel511.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabel511.setVisible(false);
		jLabel51 = new JLabel();
		jLabel51.setBounds(new Rectangle(577, 523, 249, 23));
		jLabel51.setText("to your email");
		jLabel51.setVerticalAlignment(SwingConstants.CENTER);
		jLabel51.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabel51.setVisible(false);
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(578, 494, 340, 41));
		jLabel5.setFont(new Font("Calibri", Font.PLAIN, 18));
		jLabel5.setVerticalAlignment(SwingConstants.CENTER);
		jLabel5.setText("A replacement password has been");
		jLabel5.setVisible(false);
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(620, 691, 113, 49));
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/Image/simplyTECHBottomRight.PNG")));
		jLabel4.setText("");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(565, 219, 91, 76));
		jLabel3.setFont(new Font("Calibri Light", Font.PLAIN, 36));
		jLabel3.setText("OR");
		jLabel111 = new JLabel();
		jLabel111.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel111.setText("Username:");
		jLabel111.setSize(new Dimension(178, 33));
		jLabel111.setLocation(new Point(123, 417));
		jLabel111.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel11 = new JLabel();
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setText("ID:");
		jLabel11.setLocation(new Point(123, 332));
		jLabel11.setSize(new Dimension(178, 33));
		jLabel11.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(123, 247, 178, 33));
		jLabel1.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setText("Full name:");
		jLabel2 = new JLabel();
		jLabel2.setText("forgot your password?");
		jLabel2.setLocation(new Point(199, 119));
		jLabel2.setSize(new Dimension(377, 67));
		jLabel2.setFont(new Font("Calibri Light", Font.PLAIN, 34));
		jLabel = new JLabel();
		jLabel.setText("");
		jLabel.setSize(new Dimension(384, 135));
		jLabel.setLocation(new Point(508, 26));
		jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/Image/CheckmateBySimplyTECH.png")));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJEditorPane(), null);
		this.add(jLabel, null);
		this.add(jLabel2, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel111, null);
		this.add(getJTextFieldFullName(), null);
		this.add(getJTextFieldID(), null);
		this.add(getJTextFieldUsername(), null);
		this.add(getJTextPane(), null);
		this.add(jLabel3, null);
		this.add(getJTextPane1(), null);
		this.add(jLabel4, null);
		this.add(getJButtonDone(), null);
		this.add(jLabel5, null);
		this.add(jLabel51, null);
		this.add(jLabel511, null);
		this.add(jLabelBack, null);
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setEditable(false);
			jEditorPane.setLocation(new Point(165, 148));
			jEditorPane.setSize(new Dimension(21, 8));
			jEditorPane.setBackground(new Color(237, 125, 49));
		}
		return jEditorPane;
	}

	/**
	 * This method initializes jTextFieldFullName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFullName() {
		if (jTextFieldFullName == null) {
			jTextFieldFullName = new JTextField();
			jTextFieldFullName.setBounds(new Rectangle(318, 248, 196, 32));
		}
		return jTextFieldFullName;
	}

	/**
	 * This method initializes jTextFieldID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldID() {
		if (jTextFieldID == null) {
			jTextFieldID = new JTextField();
			jTextFieldID.setLocation(new Point(318, 333));
			jTextFieldID.setSize(new Dimension(196, 32));
		}
		return jTextFieldID;
	}

	/**
	 * This method initializes jTextFieldUsername	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldUsername() {
		if (jTextFieldUsername == null) {
			jTextFieldUsername = new JTextField();
			jTextFieldUsername.setLocation(new Point(318, 417));
			jTextFieldUsername.setSize(new Dimension(196, 32));
		}
		return jTextFieldUsername;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setLocation(new Point(554, 231));
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(1, 300));
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
			jTextPane1.setBounds(new Rectangle(591, 302, 253, 167));
			jTextPane1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			jTextPane1.setBackground(new Color(227, 228, 250));
			jTextPane1.setText("Approach one of our friendly staff with your IC or passport to change your password.");
		}
		return jTextPane1;
	}

	/**
	 * This method initializes jButtonDone	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDone() {
		if (jButtonDone == null) {
			jButtonDone = new JButton();
			jButtonDone.setBounds(new Rectangle(286, 496, 142, 57));
			jButtonDone.setFont(new Font("Calibri", Font.BOLD, 36));
			jButtonDone.setForeground(Color.white);
			jButtonDone.setToolTipText("");
			jButtonDone.setText("Done");
			jButtonDone.setBackground(new Color(91, 155, 213));
			jButtonDone.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jLabel5.setVisible(true);
					jLabel51.setVisible(true);
					jLabel511.setVisible(true);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonDone;
	}

}
