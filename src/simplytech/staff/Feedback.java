package simplytech.staff;

import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class Feedback extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButtonBackButton = null;
	private JLabel jLabelBar = null;
	private JLabel jLabelFeedback = null;
	private JLabel jLabelCompleteSurvey = null;
	private JButton jButtonSubmit = null;
	private JLabel jLabelVeryPoor = null;
	private JLabel jLabelSimplyTech = null;
	private JLabel jLabelHelpfulStaff = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JLabel jLabelPleasantStaff = null;
	private JRadioButton jRadioButton4 = null;
	private JRadioButton jRadioButton5 = null;
	private JRadioButton jRadioButton6 = null;
	private JLabel jLabelEfficientStaff = null;
	private JRadioButton jRadioButton7 = null;
	private JRadioButton jRadioButton8 = null;
	private JRadioButton jRadioButton9 = null;
	private JLabel jLabelVeryPoor2 = null;
	private JLabel jLabelWaitingTime = null;
	private JFrame myFrame = null;
	private JRadioButton jRadioButton10 = null;
	private JRadioButton jRadioButton11 = null;
	private JRadioButton jRadioButton12 = null;
	/**
	 * This is the default constructor
	 */
	public Feedback() {
		super();
		initialize();
	}
	
	public Feedback(JFrame f){
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
		jLabelWaitingTime = new JLabel();
		jLabelWaitingTime.setBounds(new Rectangle(315, 257, 92, 29));
		jLabelWaitingTime.setText("Waiting Time");
		jLabelVeryPoor2 = new JLabel();
		jLabelVeryPoor2.setText("Poor   Average   Good");
		jLabelVeryPoor2.setSize(new Dimension(136, 58));
		jLabelVeryPoor2.setLocation(new Point(452, 190));
		jLabelEfficientStaff = new JLabel();
		jLabelEfficientStaff.setBounds(new Rectangle(46, 346, 89, 28));
		jLabelEfficientStaff.setText("Efficient Staff");
		jLabelPleasantStaff = new JLabel();
		jLabelPleasantStaff.setBounds(new Rectangle(46, 302, 89, 30));
		jLabelPleasantStaff.setText("Pleasant Staff");
		jLabelHelpfulStaff = new JLabel();
		jLabelHelpfulStaff.setBounds(new Rectangle(47, 251, 86, 35));
		jLabelHelpfulStaff.setText("Helpful Staff");
		jLabelSimplyTech = new JLabel();
		jLabelSimplyTech.setBounds(new Rectangle(829, 533, 177, 42));
		jLabelSimplyTech.setIcon(new ImageIcon(getClass().getResource("/Image/by simplytech.png")));
		jLabelSimplyTech.setText("");
		jLabelVeryPoor = new JLabel();
		jLabelVeryPoor.setBounds(new Rectangle(151, 190, 136, 58));
		jLabelVeryPoor.setText("Poor   Average   Good");
		jLabelCompleteSurvey = new JLabel();
		jLabelCompleteSurvey.setBounds(new Rectangle(391, 30, 405, 60));
		jLabelCompleteSurvey.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelCompleteSurvey.setText("Complete the survey to win 50 points");
		jLabelFeedback = new JLabel();
		jLabelFeedback.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelFeedback.setLocation(new Point(91, 23));
		jLabelFeedback.setSize(new Dimension(156, 35));
		jLabelFeedback.setText("Feedback");
		jLabelBar = new JLabel();
		jLabelBar.setBackground(new Color(91, 155, 213));
		jLabelBar.setSize(new Dimension(371, 4));
		jLabelBar.setLocation(new Point(0, 78));
		jLabelBar.setText("");
		jLabelBar.setOpaque(true);
		this.setSize(1013, 580);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		
		this.add(jLabelFeedback, null);
		this.add(getJButtonBackButton(), null);
		this.add(jLabelBar, null);
		this.add(jLabelCompleteSurvey, null);
		this.add(getJButtonSubmit(), null);
		this.add(jLabelVeryPoor, null);
		this.add(jLabelSimplyTech, null);
		this.add(jLabelHelpfulStaff, null);
		this.add(getJRadioButton1(), null);
		this.add(getJRadioButton2(), null);
		this.add(getJRadioButton3(), null);
		this.add(jLabelPleasantStaff, null);
		this.add(getJRadioButton4(), null);
		this.add(getJRadioButton5(), null);
		this.add(getJRadioButton6(), null);
		this.add(jLabelEfficientStaff, null);
		this.add(getJRadioButton7(), null);
		this.add(getJRadioButton8(), null);
		this.add(getJRadioButton9(), null);
		this.add(jLabelVeryPoor2, null);
		this.add(jLabelWaitingTime, null);
		this.add(getJRadioButton10(), null);
		this.add(getJRadioButton11(), null);
		this.add(getJRadioButton12(), null);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(jRadioButton1);
		group1.add(jRadioButton2);
		group1.add(jRadioButton3);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(jRadioButton4);
		group2.add(jRadioButton5);
		group2.add(jRadioButton6);
		
		ButtonGroup group3 = new ButtonGroup();
		group3.add(jRadioButton7);
		group3.add(jRadioButton8);
		group3.add(jRadioButton9);

		ButtonGroup group4 = new ButtonGroup();
		group4.add(jRadioButton10);
		group4.add(jRadioButton11);
		group4.add(jRadioButton12);
	}

	/**
	 * This method initializes jButtonBackButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBackButton() {
		if (jButtonBackButton == null) {
			jButtonBackButton = new JButton();
			jButtonBackButton.setBackground(new Color(227, 228, 250));
			jButtonBackButton.setLocation(new Point(-13, -3));
			jButtonBackButton.setSize(new Dimension(130, 82));
			jButtonBackButton.setIcon(new ImageIcon(getClass().getResource("/Image/Swap Left.png")));
			jButtonBackButton.setOpaque(false);
			Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2, true); // the third parameter - true, says it's round
		    jButtonBackButton.setBorder(roundedBorder);
		}
		return jButtonBackButton;
	}

	/**
	 * This method initializes jButtonSubmit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSubmit() {
		if (jButtonSubmit == null) {
			jButtonSubmit = new JButton();
			jButtonSubmit.setBounds(new Rectangle(811, 103, 134, 63));
			jButtonSubmit.setText("Submit");
			jButtonSubmit.setForeground(Color.white);
			jButtonSubmit.setFont(new Font("Dialog", Font.BOLD, 24));
			jButtonSubmit.setBackground(new Color(91, 155, 213));
			Border roundedBorder = new LineBorder(new Color(227, 228, 250), 2, true); // the third parameter - true, says it's round
		    jButtonSubmit.setBorder(roundedBorder);
		}
		return jButtonSubmit;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setSize(new Dimension(21, 21));
			jRadioButton1.setLocation(new Point(150, 254));
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setBounds(new Rectangle(195, 254, 21, 21));
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setSize(new Dimension(21, 21));
			jRadioButton3.setLocation(new Point(239, 254));
		}
		return jRadioButton3;
	}

	/**
	 * This method initializes jRadioButton4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setSize(new Dimension(21, 21));
			jRadioButton4.setLocation(new Point(150, 301));
		}
		return jRadioButton4;
	}

	/**
	 * This method initializes jRadioButton5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton5() {
		if (jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton();
			jRadioButton5.setBounds(new Rectangle(195, 301, 21, 21));
		}
		return jRadioButton5;
	}

	/**
	 * This method initializes jRadioButton6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton6() {
		if (jRadioButton6 == null) {
			jRadioButton6 = new JRadioButton();
			jRadioButton6.setBounds(new Rectangle(241, 301, 21, 21));
		}
		return jRadioButton6;
	}

	/**
	 * This method initializes jRadioButton7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton7() {
		if (jRadioButton7 == null) {
			jRadioButton7 = new JRadioButton();
			jRadioButton7.setSize(new Dimension(21, 21));
			jRadioButton7.setLocation(new Point(151, 347));
		}
		return jRadioButton7;
	}

	/**
	 * This method initializes jRadioButton8	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton8() {
		if (jRadioButton8 == null) {
			jRadioButton8 = new JRadioButton();
			jRadioButton8.setSize(new Dimension(21, 21));
			jRadioButton8.setLocation(new Point(196, 347));
		}
		return jRadioButton8;
	}

	/**
	 * This method initializes jRadioButton9	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton9() {
		if (jRadioButton9 == null) {
			jRadioButton9 = new JRadioButton();
			jRadioButton9.setBounds(new Rectangle(240, 347, 21, 21));
		}
		return jRadioButton9;
	}

	/**
	 * This method initializes jRadioButton10	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton10() {
		if (jRadioButton10 == null) {
			jRadioButton10 = new JRadioButton();
			jRadioButton10.setBounds(new Rectangle(450, 256, 21, 21));
		}
		return jRadioButton10;
	}

	/**
	 * This method initializes jRadioButton11	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton11() {
		if (jRadioButton11 == null) {
			jRadioButton11 = new JRadioButton();
			jRadioButton11.setBounds(new Rectangle(496, 256, 21, 21));
		}
		return jRadioButton11;
	}

	/**
	 * This method initializes jRadioButton12	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton12() {
		if (jRadioButton12 == null) {
			jRadioButton12 = new JRadioButton();
			jRadioButton12.setBounds(new Rectangle(540, 257, 21, 21));
		}
		return jRadioButton12;
	}
	

}
