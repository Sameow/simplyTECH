package simplytech.room;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JTextPane;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContactPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBack = null;
	private JLabel jLabel = null;
	private JTextPane jTextPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JTextPane jTextPaneTaxi = null;
	private JFrame myFrame = null;
	private JTextPane jTextPaneTaxi1 = null;
	private JTextPane jTextPaneShoppingMall = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable1 = null;
	private JTextPane jTextPaneShoppingCentre = null;
	/**
	 * This is the default constructor
	 */
	public ContactPanel() {
		super();
		initialize();
	}
	
	public ContactPanel(JFrame f){
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
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("Contacts");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(345, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplytech/Image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			//	System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new RoomHomePagePanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBack, null);
		this.add(jLabel, null);
		this.add(getJTextPane(), null);
		this.add(getJScrollPane(), null);
		this.add(getJTextPaneTaxi(), null);
		this.add(getJTextPaneTaxi1(), null);
		this.add(getJTextPaneShoppingMall(), null);
		this.add(getJScrollPane1(), null);
		this.add(getJTextPaneShoppingCentre(), null);
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
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(465, 114, 519, 424));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			Object rowData[][] = { 
					{"Dial-A-Cab","6342 5222","Mdm Tan"},	
    				{"Comfort", "6123 4567", "Ms Low"},
					{"Pime", "6234 5678", "Mr Ong"},
					{"SMRT", "6457 8962", "Mr Tan"},
					{"CityCab", "6552 1111", "Mdm Ong"},
					{"Smart Cab","6485 7777","Ms Ng"},
					{"TransCab","6555 3333","Ms Tan"},	
					{"Premier Cab","6363 6888","Mdm Tan"},	
					{"Yellow-Top Taxi","6293 5545","Mr Lim"},	
					{"Taxi Singapore","6600 2800","Ms Lee"},	
			};
			Object columnNames[] = { "Company", "Number", "Name"};
			jTable = new JTable(rowData, columnNames);
			jTable.setBackground(new Color(91, 155, 213));
			jTable.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTable.setIntercellSpacing(new Dimension(1, 1));
			jTable.setRowHeight(50);
			jTable.setShowVerticalLines(true);
			jTable.setShowHorizontalLines(true);
			jTable.setForeground(Color.white);
		}
		return jTable;
	}

	/**
	 * This method initializes jTextPaneTaxi	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTaxi() {
		if (jTextPaneTaxi == null) {
			jTextPaneTaxi = new JTextPane();
			jTextPaneTaxi.setBounds(new Rectangle(100, 133, 242, 52));
			jTextPaneTaxi.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPaneTaxi.setText("Taxis");
			jTextPaneTaxi.setEditable(false);
			jTextPaneTaxi.setForeground(Color.white);
			jTextPaneTaxi.setBackground(new Color(91, 155, 213));
			jTextPaneTaxi.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTextPaneTaxi.setBackground(new Color(31, 78, 121));
					jTextPaneShoppingMall.setBackground(new Color(91, 155, 213));
					jTextPaneTaxi1.setVisible(true);
					jScrollPane.setVisible(true);
					jTextPaneShoppingCentre.setVisible(false);
				}
			
			});
		}
		return jTextPaneTaxi;
	}

	/**
	 * This method initializes jTextPaneTaxi1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTaxi1() {
		if (jTextPaneTaxi1 == null) {
			jTextPaneTaxi1 = new JTextPane();
			jTextPaneTaxi1.setBounds(new Rectangle(461, 63, 57, 43));
			jTextPaneTaxi1.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPaneTaxi1.setText("Taxi");
			jTextPaneTaxi1.setEditable(false);
			jTextPaneTaxi1.setBackground(new Color(227, 228, 250));
		}
		return jTextPaneTaxi1;
	}

	/**
	 * This method initializes jTextPaneShoppingMall	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneShoppingMall() {
		if (jTextPaneShoppingMall == null) {
			jTextPaneShoppingMall = new JTextPane();
			jTextPaneShoppingMall.setBounds(new Rectangle(101, 206, 242, 54));
			jTextPaneShoppingMall.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPaneShoppingMall.setForeground(Color.white);
			jTextPaneShoppingMall.setText("Shopping Malls");
			jTextPaneShoppingMall.setEditable(false);
			jTextPaneShoppingMall.setBackground(new Color(91, 155, 213));
			jTextPaneShoppingMall.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTextPaneShoppingMall.setBackground(new Color(31, 78, 121));
					jTextPaneTaxi.setBackground(new Color(91, 155, 213));
					jTextPaneTaxi1.setVisible(false);
					jScrollPane.setVisible(false);
					jTextPaneShoppingCentre.setVisible(true);
					
				}
			});
		}
		return jTextPaneShoppingMall;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(465, 114, 519, 424));
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			Object rowData[][] = { 
					{"313@somerset","6342 5222","Mdm Tan"},	
    				{"Bugis Junction", "6123 4567", "Ms Low"},
					{"Centrepoint", "6234 5678", "Mr Ong"},
					{"Changi Airport", "6457 8962", "Mr Tan"},
					{"City Square Mall", "6552 1111", "Mdm Ong"},
					{"Delfi Orchard","6485 7777","Ms Ng"},
					{"Far East Shopping Centre","6555 3333","Ms Tan"},	
					{"FestiveWalk at Resorts World Sentosa","6363 6888","Mdm Tan"},	
					{"Funan Digitalife Mall","6293 5545","Mr Lim"},	
					{"Golden Mile Complex","6600 2800","Ms Lee"},	
			};
			Object columnNames[] = { "Company", "Number", "Name"};
			jTable1 = new JTable(rowData, columnNames);
			jTable1.setBackground(new Color(91, 155, 213));
			jTable1.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTable1.setIntercellSpacing(new Dimension(1, 1));
			jTable1.setRowHeight(50);
			jTable1.setShowVerticalLines(true);
			jTable1.setShowHorizontalLines(true);
			jTable1.setForeground(Color.white);
	}
		return jTable1;
	}

	/**
	 * This method initializes jTextPaneShoppingCentre	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneShoppingCentre() {
		if (jTextPaneShoppingCentre == null) {
			jTextPaneShoppingCentre = new JTextPane();
			jTextPaneShoppingCentre.setBounds(new Rectangle(462, 64, 212, 43));
			jTextPaneShoppingCentre.setFont(new Font("Calibri", Font.BOLD, 30));
			jTextPaneShoppingCentre.setText("Shopping Malls");
			jTextPaneShoppingCentre.setEditable(false);
			jTextPaneShoppingCentre.setBackground(new Color(227, 228, 250));
			jTextPaneShoppingCentre.setVisible(false);
		}
		return jTextPaneShoppingCentre;
	}
}
