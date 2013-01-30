package simplytech.room;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Attractions extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelAttractions = null;
	private JLabel jLabelNearby = null;
	private JLabel jLabelNearbyAttractions = null;
	private JLabel jLabelCentral = null;
	private JLabel jLabelCentralAttractions = null;
	private JLabel jLabelNorthAttractions = null;
	private JLabel jLabelNorth = null;
	private JButton jButtonNearby1 = null;
	private JButton jButtonNearby2 = null;
	private JButton jButtonNearby3 = null;
	private JButton jButtonNearby4 = null;
	private JButton jButtonCentral1 = null;
	private JButton jButtonCentral2 = null;
	private JButton jButtonCentral3 = null;
	private JButton jButtonNorth1 = null;
	private JButton jButtonNorth2 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	/**
	 * This method initializes jButtonNearby1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNearby1() {
		if (jButtonNearby1 == null) {
			jButtonNearby1 = new JButton();
			jButtonNearby1.setToolTipText("Gardens By the Bay");
			jButtonNearby1.setBounds(10, 61, 139, 117);
			jButtonNearby1.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/nearby1.png")));
			jButtonNearby1
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JPanel panel = new GBB(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					});
		}
		return jButtonNearby1;
	}

	/**
	 * This method initializes jButtonNearby2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNearby2() {
		if (jButtonNearby2 == null) {
			jButtonNearby2 = new JButton();
			jButtonNearby2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new MBS(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonNearby2.setToolTipText("Marina Bay Sands");
			jButtonNearby2.setBounds(157, 61, 139, 117);
			jButtonNearby2.setHorizontalAlignment(SwingConstants.CENTER);
			jButtonNearby2.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonNearby2.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonNearby2.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/nearby2.png")));
		}
		return jButtonNearby2;
	}

	/**
	 * This method initializes jButtonNearby3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNearby3() {
		if (jButtonNearby3 == null) {
			jButtonNearby3 = new JButton();
			jButtonNearby3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new suntecCity(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonNearby3.setToolTipText("Suntec City Singapore");
			jButtonNearby3.setBounds(10, 227, 139, 117);
			jButtonNearby3.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/nearby3.png")));
		}
		return jButtonNearby3;
	}

	/**
	 * This method initializes jButtonNearby4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNearby4() {
		if (jButtonNearby4 == null) {
			jButtonNearby4 = new JButton();
			jButtonNearby4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new esplanade(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonNearby4.setToolTipText("Esplanade");
			jButtonNearby4.setBounds(157, 227, 139, 117);
			jButtonNearby4.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/nearby4.png")));
		}
		return jButtonNearby4;
	}

	/**
	 * This method initializes jButtonCentral1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCentral1() {
		if (jButtonCentral1 == null) {
			jButtonCentral1 = new JButton();
			jButtonCentral1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new orchardION(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonCentral1.setToolTipText("Orchard Ion");
			jButtonCentral1.setBounds(10, 62, 139, 117);
			jButtonCentral1.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/central1.png")));
		}
		return jButtonCentral1;
	}

	/**
	 * This method initializes jButtonCentral2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCentral2() {
		if (jButtonCentral2 == null) {
			jButtonCentral2 = new JButton();
			jButtonCentral2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new wismaAtria(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonCentral2.setToolTipText("Wisma Atria");
			jButtonCentral2.setBounds(157, 62, 139, 117);
			jButtonCentral2.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/central2.png")));
		}
		return jButtonCentral2;
	}

	/**
	 * This method initializes jButtonCentral3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCentral3() {
		if (jButtonCentral3 == null) {
			jButtonCentral3 = new JButton();
			jButtonCentral3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new somerset313(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonCentral3.setToolTipText("313 Somerset");
			jButtonCentral3.setBounds(10, 226, 139, 117);
			jButtonCentral3.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/central3.png")));
		}
		return jButtonCentral3;
	}

	/**
	 * This method initializes jButtonNorth1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNorth1() {
		if (jButtonNorth1 == null) {
			jButtonNorth1 = new JButton();
			jButtonNorth1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new botanicGarden(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonNorth1.setToolTipText("Botanic Garden");
			jButtonNorth1.setBounds(10, 63, 139, 117);
			jButtonNorth1.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/north1.png")));
		}
		return jButtonNorth1;
	}

	/**
	 * This method initializes jButtonNorth2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNorth2() {
		if (jButtonNorth2 == null) {
			jButtonNorth2 = new JButton();
			jButtonNorth2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new hawParVilla(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jButtonNorth2.setToolTipText("Haw Par Villa");
			jButtonNorth2.setBounds(165, 63, 139, 117);
			jButtonNorth2.setIcon(new ImageIcon(Attractions.class
					.getResource("/simplytech/image/north2.png")));
		}
		return jButtonNorth2;
	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public Attractions() {
		super();
		initialize();
	}

	public Attractions(JFrame f) {
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
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(Attractions.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// System.out.println("mouseClicked()"); // TODO Auto-generated
				// Event stub mouseClicked()
				JPanel panel = new RoomHomePagePanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		jLabelAttractions = new JLabel();
		jLabelAttractions.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelAttractions.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelAttractions.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelAttractions.setLocation(new Point(91, 23));
		jLabelAttractions.setSize(new Dimension(216, 35));
		jLabelAttractions.setPreferredSize(new Dimension(216, 35));
		jLabelAttractions.setText("Attractions");
		this.setLayout(null);
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelAttractions, null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);
		add(getPanel_1());
		add(getPanel_2());
		add(getPanel_3());
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(SystemColor.activeCaptionText, 3,
					true));
			panel_1.setBounds(16, 163, 314, 389);
			panel_1.setLayout(null);
			jLabelNearbyAttractions = new JLabel();
			jLabelNearbyAttractions.setBounds(157, 5, 0, 0);
			panel_1.add(jLabelNearbyAttractions);
			jLabelNearbyAttractions.setText("");
			panel_1.add(getJButtonNearby1());
			panel_1.add(getJButtonNearby2());
			panel_1.add(getJButtonNearby3());
			panel_1.add(getJButtonNearby4());
			jLabelNearby = new JLabel();
			jLabelNearby.setBounds(0, 0, 314, 41);
			panel_1.add(jLabelNearby);
			jLabelNearby.setFont(new Font("Calibri", Font.BOLD, 18));
			jLabelNearby.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelNearby.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNearby.setText("Nearby");
			jLabelNearby.setOpaque(true);
			jLabelNearby.setBackground(new Color(91, 155, 231));
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(SystemColor.activeCaptionText, 3,
					true));
			panel_2.setBounds(350, 163, 314, 389);
			panel_2.setLayout(null);
			jLabelCentralAttractions = new JLabel();
			jLabelCentralAttractions.setBounds(157, 5, 0, 0);
			panel_2.add(jLabelCentralAttractions);
			jLabelCentralAttractions.setText("");
			jLabelCentral = new JLabel();
			jLabelCentral.setBounds(0, 0, 314, 41);
			panel_2.add(jLabelCentral);
			jLabelCentral.setText("Central");
			jLabelCentral.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelCentral.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelCentral.setFont(new Font("Calibri", Font.BOLD, 18));
			jLabelCentral.setOpaque(true);
			jLabelCentral.setBackground(new Color(91, 155, 231));
			panel_2.add(getJButtonCentral1());
			panel_2.add(getJButtonCentral2());
			panel_2.add(getJButtonCentral3());
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(SystemColor.activeCaptionText, 3,
					true));
			panel_3.setBounds(700, 163, 314, 389);
			panel_3.setLayout(null);
			jLabelNorthAttractions = new JLabel();
			jLabelNorthAttractions.setBounds(157, 5, 0, 0);
			panel_3.add(jLabelNorthAttractions);
			jLabelNorthAttractions.setText("");

			jLabelNorth = new JLabel();
			jLabelNorth.setBounds(0, 0, 314, 41);
			panel_3.add(jLabelNorth);
			jLabelNorth.setText("North");
			jLabelNorth.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelNorth.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNorth.setFont(new Font("Calibri", Font.BOLD, 18));
			jLabelNorth.setOpaque(true);
			jLabelNorth.setBackground(new Color(91, 155, 231));
			panel_3.add(getJButtonNorth1());
			panel_3.add(getJButtonNorth2());
		}
		return panel_3;
	}
} // @jve:decl-index=0:visual-constraint="17,11"
