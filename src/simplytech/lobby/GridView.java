package simplytech.lobby;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

import simplytech.dao.CreditCardDAO;
import simplytech.dao.CustomerDAO;
import simplytech.dao.PersonDAO;
import simplytech.entity.CreditCard;
import simplytech.entity.Customer;
import simplytech.entity.Person;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GridView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelGridViewHeader = null;
	private JLabel jLabelGridViewBack = null;
	private Panel PanelGridViewLine = null;
	private JLabel jLabelGridViewName = null;
	private JLabel jLabelGridViewCard = null;
	private JLabel jLabelGridViewMembership = null;
	private JTextPane jTextPaneTaken = null;
	private JTextPane jTextPaneAvailable = null;
	private JTextPane jTextPaneTakenText = null;
	private JTextPane jTextPaneAvailableText = null;
	private JTextPane jTextPaneSelected = null;
	private JTextPane jTextPaneSelectedText = null;
	private JTextPane jTextPaneTile2 = null;
	private JTextPane jTextPaneTile3 = null;
	private JTextPane jTextPaneTile11 = null;
	private JTextPane jTextPaneTile12 = null;
	private JTextPane jTextPaneTile13 = null;
	private JTextPane jTextPaneTile14 = null;
	private JTextPane jTextPaneWall = null;
	private JTextPane jTextPaneWallText = null;
	private JTextPane jTextPaneTile15 = null;
	private JTextPane jTextPaneTile16 = null;
	private JTextPane jTextPaneWallTile = null;
	private JTextPane jTextPaneWall2 = null;
	private JTextPane jTextPaneWall3 = null;
	private JTextPane jTextPaneWall4 = null;
	private JTextPane jTextPaneLegend = null;
	private JTextPane jTextPaneLegendUnderline = null;
	private JFrame myFrame = null;
	private JTextPane jTextPaneWall5 = null;
	private JTextPane textPane_10;
	private JTextPane textPane_11;
	private JTextPane textPane_12;
	private Person person = null;
	private String name;
	private CreditCard card = null;
	private JLabel displayPts;
	private JLabel displayMembership;
	private String cardNumber;
	private String cardType;
	private Customer cd = null;
	private String membership;
	private int points;
	private JLabel label;
	/**
	 * This is the default constructor
	 */
	public GridView() {
		super();
		initialize();
	}
	public GridView(JFrame f) {
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
		card = CreditCardDAO.searchById(MainFrame.getPersonWhoLogin().getId());
		cardNumber = card.getCardNumber()+"";
		cardType = card.getCardType();
		membership = MainFrame.getPersonWhoLogin().getMembership();
		points = MainFrame.getPersonWhoLogin().getPoints();
		jLabelGridViewMembership = new JLabel();
		jLabelGridViewMembership.setBounds(new Rectangle(30, 440, 150, 29));
		jLabelGridViewMembership.setPreferredSize(new Dimension(150, 29));
		jLabelGridViewMembership.setText("Membership:");
		jLabelGridViewMembership.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelGridViewCard = new JLabel();
		jLabelGridViewCard.setBounds(new Rectangle(30, 210, 80, 24));
		jLabelGridViewCard.setPreferredSize(new Dimension(80, 24));
		jLabelGridViewCard.setText("Card:");
		jLabelGridViewCard.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelGridViewName = new JLabel();
		jLabelGridViewName.setBounds(new Rectangle(30, 120, 85, 22));
		jLabelGridViewName.setText("Name:");
		jLabelGridViewName.setFont(new Font("Arial", Font.BOLD, 24));
		jLabelGridViewBack = new JLabel();
		jLabelGridViewBack.setText("");
		jLabelGridViewBack.setBounds(new Rectangle(-13, -3, 130, 80));
		jLabelGridViewBack.setIcon(new ImageIcon(GridView.class.getResource("/simplytech/image/Swap Left.png")));
		jLabelGridViewBack.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				JPanel panel = new Accommodations(myFrame);
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
		jLabelGridViewHeader = new JLabel();
		jLabelGridViewHeader.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelGridViewHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelGridViewHeader.setText("Grid View");
		jLabelGridViewHeader.setBounds(new Rectangle(91, 23, 140, 35));
		jLabelGridViewHeader.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelGridViewHeader, null);
		this.add(jLabelGridViewBack, null);
		this.add(getPanelGridViewLine(), null);
		this.add(jLabelGridViewName, null);
		this.add(jLabelGridViewCard, null);
		this.add(jLabelGridViewMembership, null);
		this.add(getJTextPaneTaken(), null);
		this.add(getJTextPaneAvailable(), null);
		this.add(getJTextPaneTakenText(), null);
		this.add(getJTextPaneAvailableText(), null);
		this.add(getJTextPaneSelected(), null);
		this.add(getJTextPaneSelectedText(), null);
		this.add(getJTextPaneTile2(), null);
		this.add(getJTextPaneTile3(), null);
		this.add(getJTextPaneTile11(), null);
		this.add(getJTextPaneTile12(), null);
		this.add(getJTextPaneTile13(), null);
		this.add(getJTextPaneTile14(), null);
		this.add(getJTextPaneWall(), null);
		this.add(getJTextPaneWallText(), null);
		this.add(getJTextPaneTile15(), null);
		this.add(getJTextPaneTile16(), null);
		this.add(getJTextPaneWallTile(), null);
		this.add(getJTextPaneWall2(), null);
		this.add(getJTextPaneWall3(), null);
		this.add(getJTextPaneWall4(), null);
		this.add(getJTextPaneLegend(), null);
		this.add(getJTextPaneLegendUnderline(), null);
		this.add(getJTextPaneWall5(), null);
		
		JLabel displayName = new JLabel("");
		displayName.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayName.setBounds(40, 150, 187, 31);
		displayName.setText(MainFrame.getPersonWhoLogin().getName());
		add(displayName);
		
		JLabel displayCard = new JLabel("");
		displayCard.setFont(new Font("Calibri", Font.PLAIN, 24));
		displayCard.setBounds(40, 240, 235, 31);
		displayCard.setText(cardType + " XXX-" + cardNumber.charAt(12)+cardNumber.charAt(13)+cardNumber.charAt(14)+cardNumber.charAt(15));
		add(displayCard);
		add(getDisplayPts());
		add(displayMembership());
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(new Rectangle(950, 100, 40, 90));
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(900, 350, 90, 40);
		add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(new Rectangle(500, 350, 90, 40));
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(650, 350, 140, 40);
		add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(new Rectangle(520, 120, 40, 40));
		textPane_2.setBackground(Color.LIGHT_GRAY);
		textPane_2.setBounds(700, 323, 40, 40);
		add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBounds(new Rectangle(950, 100, 40, 90));
		textPane_3.setBackground(Color.LIGHT_GRAY);
		textPane_3.setBounds(850, 100, 100, 40);
		add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBounds(new Rectangle(500, 100, 40, 90));
		textPane_4.setBackground(Color.LIGHT_GRAY);
		textPane_4.setBounds(500, 300, 40, 90);
		add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBounds(new Rectangle(500, 350, 90, 40));
		textPane_5.setBackground(Color.LIGHT_GRAY);
		textPane_5.setBounds(650, 100, 140, 40);
		add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setBounds(new Rectangle(520, 120, 40, 40));
		textPane_6.setBackground(Color.LIGHT_GRAY);
		textPane_6.setBounds(700, 120, 40, 40);
		add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setBounds(new Rectangle(520, 120, 40, 40));
		textPane_7.setBackground(Color.LIGHT_GRAY);
		textPane_7.setBounds(700, 171, 40, 40);
		add(textPane_7);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEditable(false);
		textPane_8.setBounds(new Rectangle(520, 120, 40, 40));
		textPane_8.setBackground(Color.LIGHT_GRAY);
		textPane_8.setBounds(700, 222, 40, 40);
		add(textPane_8);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setEditable(false);
		textPane_9.setBounds(new Rectangle(520, 120, 40, 40));
		textPane_9.setBackground(Color.LIGHT_GRAY);
		textPane_9.setBounds(700, 273, 40, 40);
		add(textPane_9);
		add(getTextPane_10());
		add(getTextPane_11());
		add(getTextPane_12());
		add(getLabel());
		
		JTextPane textPane_13 = new JTextPane();
		textPane_13.setText("Building Floor:");
		textPane_13.setSize(new Dimension(100, 50));
		textPane_13.setLocation(new Point(650, 300));
		textPane_13.setFont(new Font("Arial", Font.PLAIN, 18));
		textPane_13.setBackground(new Color(227, 228, 250));
		textPane_13.setBounds(790, 440, 100, 50);
		add(textPane_13);
		
		JComboBox comboBox_BuildingFloor = new JComboBox();
		comboBox_BuildingFloor.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_BuildingFloor.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_BuildingFloor.setBounds(900, 467, 50, 23);
		add(comboBox_BuildingFloor);
	}
	private JLabel getDisplayPts() {
		if (displayPts == null) {
			displayPts = new JLabel("");
			displayPts.setText(MainFrame.getPersonWhoLogin().getPoints()+"");
			displayPts.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayPts.setBounds(40, 360, 127, 31);
		}
		return displayPts;
	}
	private JLabel displayMembership() {
		if (displayMembership == null) {
			displayMembership = new JLabel("");
			displayMembership.setFont(new Font("Calibri", Font.PLAIN, 24));
			displayMembership.setBounds(40, 470, 187, 31);
			displayMembership.setText(MainFrame.getPersonWhoLogin().getMembership());
		}
		return displayMembership;
	}

	/**
	 * This method initializes PanelGridViewLine	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanelGridViewLine() {
		if (PanelGridViewLine == null) {
			PanelGridViewLine = new Panel();
			PanelGridViewLine.setLayout(null);
			PanelGridViewLine.setFont(new Font("Arial", Font.BOLD, 12));
			PanelGridViewLine.setMinimumSize(new Dimension(300, 4));
			PanelGridViewLine.setName("");
			PanelGridViewLine.setBounds(new Rectangle(0, 78, 371, 4));
			PanelGridViewLine.setBackground(new Color(91, 155, 213));
		}
		return PanelGridViewLine;
	}

	/**
	 * This method initializes jTextPaneTaken	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTaken() {
		if (jTextPaneTaken == null) {
			jTextPaneTaken = new JTextPane();
			jTextPaneTaken.setBackground(Color.red);
			jTextPaneTaken.setBounds(new Rectangle(500, 485, 25, 25));
			jTextPaneTaken.setEditable(false);
		}
		return jTextPaneTaken;
	}

	/**
	 * This method initializes jTextPaneAvailable	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAvailable() {
		if (jTextPaneAvailable == null) {
			jTextPaneAvailable = new JTextPane();
			jTextPaneAvailable.setBackground(Color.green);
			jTextPaneAvailable.setBounds(new Rectangle(500, 450, 25, 25));
			jTextPaneAvailable.setEditable(false);
		}
		return jTextPaneAvailable;
	}

	/**
	 * This method initializes jTextPaneTakenText	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTakenText() {
		if (jTextPaneTakenText == null) {
			jTextPaneTakenText = new JTextPane();
			jTextPaneTakenText.setBackground(new Color(227, 228, 250));
			jTextPaneTakenText.setText("Taken");
			jTextPaneTakenText.setEditable(false);
			jTextPaneTakenText.setBounds(new Rectangle(530, 480, 80, 25));
			jTextPaneTakenText.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return jTextPaneTakenText;
	}

	/**
	 * This method initializes jTextPaneAvailableText	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneAvailableText() {
		if (jTextPaneAvailableText == null) {
			jTextPaneAvailableText = new JTextPane();
			jTextPaneAvailableText.setBackground(new Color(227, 228, 250));
			jTextPaneAvailableText.setEditable(false);
			jTextPaneAvailableText.setText("Available");
			jTextPaneAvailableText.setBounds(new Rectangle(530, 445, 80, 25));
			jTextPaneAvailableText.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return jTextPaneAvailableText;
	}

	/**
	 * This method initializes jTextPaneSelected	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneSelected() {
		if (jTextPaneSelected == null) {
			jTextPaneSelected = new JTextPane();
			jTextPaneSelected.setEditable(false);
			jTextPaneSelected.setBounds(new Rectangle(620, 450, 25, 25));
			jTextPaneSelected.setBackground(Color.cyan);
		}
		return jTextPaneSelected;
	}

	/**
	 * This method initializes jTextPaneSelectedText	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneSelectedText() {
		if (jTextPaneSelectedText == null) {
			jTextPaneSelectedText = new JTextPane();
			jTextPaneSelectedText.setText("Selected");
			jTextPaneSelectedText.setBackground(new Color(227, 228, 250));
			jTextPaneSelectedText.setBounds(new Rectangle(650, 445, 78, 28));
			jTextPaneSelectedText.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return jTextPaneSelectedText;
	}

	/**
	 * This method initializes jTextPaneTile2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile2() {
		if (jTextPaneTile2 == null) {
			jTextPaneTile2 = new JTextPane();
			jTextPaneTile2.setEditable(false);
			jTextPaneTile2.setLocation(new Point(850, 350));
			jTextPaneTile2.setSize(new Dimension(40, 40));
			jTextPaneTile2.setBackground(Color.red);
		}
		return jTextPaneTile2;
	}

	/**
	 * This method initializes jTextPaneTile3	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile3() {
		if (jTextPaneTile3 == null) {
			jTextPaneTile3 = new JTextPane();
			jTextPaneTile3.setEditable(false);
			jTextPaneTile3.setLocation(new Point(800, 350));
			jTextPaneTile3.setSize(new Dimension(40, 40));
			jTextPaneTile3.setBackground(Color.green);
			jTextPaneTile3.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextPaneTile3.getBackground() == Color.green){
						jTextPaneTile3.setBackground(Color.cyan);
					}
					else
					jTextPaneTile3	.setBackground(Color.green);
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
		}
		return jTextPaneTile3;
	}

	/**
	 * This method initializes jTextPaneTile11	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile11() {
		if (jTextPaneTile11 == null) {
			jTextPaneTile11 = new JTextPane();
			jTextPaneTile11.setEditable(false);
			jTextPaneTile11.setLocation(new Point(500, 250));
			jTextPaneTile11.setSize(new Dimension(40, 40));
			jTextPaneTile11.setBackground(Color.green);
			jTextPaneTile11.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextPaneTile11.getBackground() == Color.green){
						jTextPaneTile11.setBackground(Color.cyan);
					}
					else
					jTextPaneTile11.setBackground(Color.green);
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
		}
		return jTextPaneTile11;
	}

	/**
	 * This method initializes jTextPaneTile12	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile12() {
		if (jTextPaneTile12 == null) {
			jTextPaneTile12 = new JTextPane();
			jTextPaneTile12.setEditable(false);
			jTextPaneTile12.setLocation(new Point(500, 200));
			jTextPaneTile12.setSize(new Dimension(40, 40));
			jTextPaneTile12.setBackground(Color.red);
		}
		return jTextPaneTile12;
	}

	/**
	 * This method initializes jTextPaneTile13	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile13() {
		if (jTextPaneTile13 == null) {
			jTextPaneTile13 = new JTextPane();
			jTextPaneTile13.setEditable(false);
			jTextPaneTile13.setBounds(new Rectangle(950, 300, 40, 40));
			jTextPaneTile13.setBackground(Color.red);
		}
		return jTextPaneTile13;
	}

	/**
	 * This method initializes jTextPaneTile14	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile14() {
		if (jTextPaneTile14 == null) {
			jTextPaneTile14 = new JTextPane();
			jTextPaneTile14.setEditable(false);
			jTextPaneTile14.setBounds(new Rectangle(950, 200, 40, 40));
			jTextPaneTile14.setBackground(Color.green);
			jTextPaneTile14.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextPaneTile14.getBackground() == Color.green){
						jTextPaneTile14.setBackground(Color.cyan);
					}
					else
					jTextPaneTile14.setBackground(Color.green);
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
		}
		return jTextPaneTile14;
	}

	/**
	 * This method initializes jTextPaneWall	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWall() {
		if (jTextPaneWall == null) {
			jTextPaneWall = new JTextPane();
			jTextPaneWall.setEditable(false);
			jTextPaneWall.setBounds(new Rectangle(620, 485, 25, 25));
			jTextPaneWall.setBackground(Color.lightGray);
		}
		return jTextPaneWall;
	}

	/**
	 * This method initializes jTextPaneWallText	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWallText() {
		if (jTextPaneWallText == null) {
			jTextPaneWallText = new JTextPane();
			jTextPaneWallText.setBackground(new Color(227, 228, 250));
			jTextPaneWallText.setText("Pillars");
			jTextPaneWallText.setBounds(new Rectangle(650, 480, 50, 28));
			jTextPaneWallText.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return jTextPaneWallText;
	}

	/**
	 * This method initializes jTextPaneTile15	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile15() {
		if (jTextPaneTile15 == null) {
			jTextPaneTile15 = new JTextPane();
			jTextPaneTile15.setEditable(false);
			jTextPaneTile15.setBounds(new Rectangle(950, 250, 40, 40));
			jTextPaneTile15.setBackground(Color.red);
		}
		return jTextPaneTile15;
	}

	/**
	 * This method initializes jTextPaneTile16	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTile16() {
		if (jTextPaneTile16 == null) {
			jTextPaneTile16 = new JTextPane();
			jTextPaneTile16.setEditable(false);
			jTextPaneTile16.setSize(new Dimension(40, 40));
			jTextPaneTile16.setLocation(new Point(600, 100));
			jTextPaneTile16.setBackground(Color.green);
			jTextPaneTile16.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					
					if (jTextPaneTile16.getBackground() == Color.green){
						jTextPaneTile16.setBackground(Color.cyan);
					}
					else
					jTextPaneTile16.setBackground(Color.green);
				}
			});
		}
		return jTextPaneTile16;
	}

	/**
	 * This method initializes jTextPaneWallTile	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWallTile() {
		if (jTextPaneWallTile == null) {
			jTextPaneWallTile = new JTextPane();
			jTextPaneWallTile.setBounds(new Rectangle(500, 100, 40, 90));
			jTextPaneWallTile.setEditable(false);
			jTextPaneWallTile.setBackground(Color.lightGray);
		}
		return jTextPaneWallTile;
	}

	/**
	 * This method initializes jTextPaneWall2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWall2() {
		if (jTextPaneWall2 == null) {
			jTextPaneWall2 = new JTextPane();
			jTextPaneWall2.setBackground(Color.lightGray);
			jTextPaneWall2.setSize(new Dimension(90, 40));
			jTextPaneWall2.setEditable(false);
			jTextPaneWall2.setLocation(new Point(500, 100));
		}
		return jTextPaneWall2;
	}

	/**
	 * This method initializes jTextPaneWall3	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWall3() {
		if (jTextPaneWall3 == null) {
			jTextPaneWall3 = new JTextPane();
			jTextPaneWall3.setBounds(new Rectangle(520, 120, 40, 40));
			jTextPaneWall3.setEditable(false);
			jTextPaneWall3.setBackground(Color.lightGray);
		}
		return jTextPaneWall3;
	}

	/**
	 * This method initializes jTextPaneWall4	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWall4() {
		if (jTextPaneWall4 == null) {
			jTextPaneWall4 = new JTextPane();
			jTextPaneWall4.setBounds(new Rectangle(950, 100, 40, 90));
			jTextPaneWall4.setEditable(false);
			jTextPaneWall4.setBackground(Color.lightGray);
		}
		return jTextPaneWall4;
	}

	/**
	 * This method initializes jTextPaneLegend	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneLegend() {
		if (jTextPaneLegend == null) {
			jTextPaneLegend = new JTextPane();
			jTextPaneLegend.setText("Legend");
			jTextPaneLegend.setLocation(new Point(500, 400));
			jTextPaneLegend.setSize(new Dimension(100, 35));
			jTextPaneLegend.setFont(new Font("Arial", Font.BOLD, 24));
			jTextPaneLegend.setPreferredSize(new Dimension(92, 30));
			jTextPaneLegend.setEditable(false);
			jTextPaneLegend.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneLegend;
	}

	/**
	 * This method initializes jTextPaneLegendUnderline	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneLegendUnderline() {
		if (jTextPaneLegendUnderline == null) {
			jTextPaneLegendUnderline = new JTextPane();
			jTextPaneLegendUnderline.setBackground(Color.black);
			jTextPaneLegendUnderline.setSize(new Dimension(100, 2));
			jTextPaneLegendUnderline.setLocation(new Point(500, 434));
		}
		return jTextPaneLegendUnderline;
	}
	/**
	 * This method initializes jTextPaneWall5	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneWall5() {
		if (jTextPaneWall5 == null) {
			jTextPaneWall5 = new JTextPane();
			jTextPaneWall5.setBounds(new Rectangle(500, 350, 90, 40));
			jTextPaneWall5.setEditable(false);
			jTextPaneWall5.setBackground(Color.lightGray);
		}
		return jTextPaneWall5;
	}
	private JTextPane getTextPane_10() {
		if (textPane_10 == null) {
			textPane_10 = new JTextPane();
			textPane_10.setEditable(false);
			textPane_10.setBounds(new Rectangle(520, 120, 40, 40));
			textPane_10.setBackground(Color.LIGHT_GRAY);
			textPane_10.setBounds(928, 120, 40, 40);
		}
		return textPane_10;
	}
	private JTextPane getTextPane_11() {
		if (textPane_11 == null) {
			textPane_11 = new JTextPane();
			textPane_11.setEditable(false);
			textPane_11.setBounds(new Rectangle(520, 120, 40, 40));
			textPane_11.setBackground(Color.LIGHT_GRAY);
			textPane_11.setBounds(800, 100, 40, 40);
		}
		return textPane_11;
	}
	private JTextPane getTextPane_12() {
		if (textPane_12 == null) {
			textPane_12 = new JTextPane();
			textPane_12.setEditable(false);
			textPane_12.setBounds(new Rectangle(520, 120, 40, 40));
			textPane_12.setBackground(Color.LIGHT_GRAY);
			textPane_12.setBounds(600, 350, 40, 40);
		}
		return textPane_12;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel();
			label.setText("Points:");
			label.setFont(new Font("Arial", Font.BOLD, 24));
			label.setBounds(new Rectangle(30, 280, 120, 24));
			label.setBounds(30, 325, 120, 30);
		}
		return label;
	}
}  //  @jve:decl-index=0:visual-constraint="29,17"
