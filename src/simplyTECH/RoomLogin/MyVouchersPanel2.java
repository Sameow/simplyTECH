package simplyTECH.RoomLogin;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.border.LineBorder;


import simplyTECH.Components.MACAddress;
import simplyTECH.dao.CheckLoginDAO;
import simplyTECH.dao.VouchersDAO;
import simplyTECH.entity.CheckLogin;
import simplyTECH.entity.Vouchers;

import java.awt.Component;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyVouchersPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JTextPane jTextPaneFoodVoucherLunch = null;
	private JLabel jLabel1 = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabelFoodVoucherLunch1 = null;
	private JLabel jLabelImage;
	private JTextPane jTextPaneTitle = null;
	private JLabel jLabelDate1 = null;
	private JTextPane jTextPaneSubtitle = null;
	private JTextPane jTextPaneDetails = null;
	private JLabel jLabel11 = null;
	private JLabel jLabelFoodVoucherBreakfast = null;
	private JLabel jLabelDate2 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JScrollPane jScrollPane = null;
	private JPanel panel = null;
	private Vouchers vouchers;
	/**
	 * This is the default constructor
	 */
	public MyVouchersPanel2() {
		super();
		initialize();
	}
	public MyVouchersPanel2(JFrame f){
		this();
		myFrame = f;
	//	initialize();
	}

	private String image = null;
	private String title = null;
	private String subtitle = null;
	private String details = null;
	private String loginUsername = null;
	private int loginID = 0;
	private JScrollPane scrollPane;
	private Statement stmt = null;
	private Connection con=null;
	private String query;
	private ResultSet rs;
	private int id = 50;
	private void initialize() {
		
		String macAddress = null;
		MACAddress mac = new MACAddress();
		try {
			macAddress = mac.getMAC();
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("MacAddress: "+macAddress);
		CheckLogin cl = new CheckLogin();
		cl = CheckLoginDAO.searchByIdTi(macAddress);
		loginUsername = cl.getUsername();
		loginID = cl.getId();
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			//	System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				JPanel panel = new MyAccountsPanel(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		
		vouchers = VouchersDAO.searchById(loginID);
		//vouchers = vouchers.searchByUsername(loginUsername);

		image = vouchers.getImage();
		subtitle = vouchers.getSubtitle();
		details = vouchers.getDetails();
		jLabelDate2 = new JLabel();
		
		//jLabelDate2.setBounds(new Rectangle(717, 210, 114, 16));
		//jLabelDate2.setFont(new Font("Calibri", Font.PLAIN, 12));
		//jLabelDate2.setText("11/5/2012 - 19/5/2012");
		//jLabelDate2.setVisible(false);
		jLabelDate1 = new JLabel();
		jLabelDate1.setBounds(new Rectangle(718, 207, 138, 22));
		jLabelDate1.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelDate1.setText("11/5/2012 - 19/5/2012");
		jLabelDate1.setVisible(true);
		//
		jLabelImage = new JLabel();
		jLabelImage.setBounds(new Rectangle(578, 123, 111, 114));
		jLabelImage.setIcon(new ImageIcon(getClass().getResource(image)));
		jLabelImage.setText("");
		jLabelImage.setVisible(true);
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(55, 24));
		jLabel.setText("My Vouchers");
		jLabel.setLocation(new Point(91, 23));
		jLabel.setSize(new Dimension(216, 35));
		jLabel.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(getJTextPane(), null);
		this.add(jLabel, null);
		this.add(getJTextPane1(), null);
		this.add(jLabelImage, null);
		this.add(getJTextPaneTitle(), null);
		this.add(jLabelDate1, null);
		this.add(getJTextPaneSubtitle(), null);
		this.add(getJTextPaneDetails(), null);
		this.add(jLabelDate2, null);
		this.add(jLabelBack, null);
		
	//	String panelColor = "227,228,250";
		 panel = new JPanel();
			//panel.setBounds(32, 117, 330, 402);
		//	panel.setBorder(new LineBorder(new Color(227,228,250), 5, true));
			//panel.setPreferredSize(preferredSize());
		 panel.setSize(32,300);	
		 panel.setPreferredSize(getSize());
		 add(panel);
	     panel.setBackground(new Color(227,228,250));
	     panel.setLayout(null);
	     
	     ArrayList<JTextPane> panes = null;
		panes = createPanes();
	     for (int i=0; i < panes.size(); i++){
//	    	panes[i].addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent arg0) {
					
					//}
				//});
	     }
	      //  panel.add(getLblNewLabel());
	        add(getScrollPane());
		/*JTextPane[] panes=createPanes();
        for (int i=0;i<panes.length;i++){
            panel.add(panes[i]);
        }*/
        
       	//this.add(getJScrollPane());
	    	
	}
	
	private String username;
	private int k;
	private int a;
	private int count = 0;
	private ArrayList<JTextPane> panes = new ArrayList<JTextPane>();
	private JTextPane setPanes = null;
	private String[] titles;
	private Vouchers voucher;
	private ArrayList<Vouchers> createVouchers = new ArrayList<Vouchers>();
	
	private ArrayList<JTextPane> createPanes(){
	       // JLabel[] labels=new JLabel[10];
	        int yAxis;
	        username = vouchers.getUsername();
	        try {
				count = VouchersDAO.getMax();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        titles = new String[count+1];
	        
	       // panes = new JTextPane[count+1];
	        System.out.println(count);
	        for (k=1;k<=count;k++){		
	        	System.out.println("IF LOOP IS OK");
				if (username.equals(loginUsername)){	
					//System.out.println("ASASASSA");
					vouchers = VouchersDAO.searchById(loginID, k);
					if (vouchers != null){
						System.out.println("VOUCHERS NOT NULL!");
					username = vouchers.getUsername();
					image = vouchers.getImage();
					title = vouchers.getTitle();
					titles[k] = vouchers.getTitle();
					subtitle = vouchers.getSubtitle();
					details = vouchers.getDetails();
					voucher = new Vouchers(k,title,subtitle,details);
					createVouchers.add(voucher);
					yAxis = k * 100;
				    setPanes=new JTextPane();
		            setPanes.setBounds(new Rectangle(181, -90 + yAxis, 159, 69));
		    	    setPanes.setBackground(new Color(31, 78, 121));
		    		setPanes.setFont(new Font("Calibri", Font.PLAIN, 20));
		    		setPanes.setForeground(Color.white);
		    		setPanes.setEditable(false);
		    		setPanes.setText(title);
		    		setPanes.setName(k+"");
		    		//Panes are created but the actionListener group all of them under the same actionListener
		    		setPanes.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent arg0) {
							Vouchers setVouchers = createVouchers.get(k-2);
							String title = setVouchers.getTitle();
							String subtitle = setVouchers.getSubtitle();
							String details = setVouchers.getDetails();
							System.out.println(titles[k-1]);
							jTextPaneTitle.setText(title);
							jTextPaneSubtitle.setText(subtitle);
							jTextPaneDetails.setText(details);
						}
					});
		    		panes.add(setPanes);
		    		panel.add(panes.get(k-1));
		    		}
	        }}
	 			return panes;
	}
	
	int l = 0;
	/*private void setVouchers(){
		for(l = 0; l < count; l++){
			panes.get(1).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					vouchers = VouchersDAO.searchById(l);
					//String title = vouchers.getTitle();
					jTextPaneTitle.setText("ASSA");
				}
			});
		}
	}*/



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
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			
			jTextPane1 = new JTextPane();
			jTextPane1.setBackground(new Color(91, 155, 213));
			jTextPane1.setSize(new Dimension(4, 351));
			jTextPane1.setLocation(new Point(458, 155));
		}
		return jTextPane1;
	}

	/**
	 * This method initializes jTextPaneTitle1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTitle() {
		if (jTextPaneTitle == null) {
			jTextPaneTitle = new JTextPane();
			jTextPaneTitle.setBounds(new Rectangle(699, 123, 173, 78));
			jTextPaneTitle.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle.setBackground(new Color(227, 228, 250));
			jTextPaneTitle.setText(title);
			jTextPaneTitle.setVisible(true);
		}
		return jTextPaneTitle;
	}

	/**
	 * This method initializes jTextPaneDescriptionBig1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneSubtitle() {
		if (jTextPaneSubtitle == null) {
			jTextPaneSubtitle = new JTextPane();
			jTextPaneSubtitle.setBounds(new Rectangle(586, 257, 296, 87));
			jTextPaneSubtitle.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneSubtitle.setBackground(new Color(227, 228, 250));
			jTextPaneSubtitle.setText(subtitle);
			jTextPaneSubtitle.setVisible(true);
		}
		return jTextPaneSubtitle;
	}

	/**
	 * This method initializes jTextPaneDescription1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDetails() {
		if (jTextPaneDetails == null) {
			jTextPaneDetails = new JTextPane();
			jTextPaneDetails.setBounds(new Rectangle(596, 341, 336, 157));
			jTextPaneDetails.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDetails.setBackground(new Color(227, 228, 250));
			jTextPaneDetails.setText(details);
			jTextPaneDetails.setVisible(true);
		}
		return jTextPaneDetails;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(panel);
			scrollPane.setBounds(32, 117, 370, 422);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(new Color(227,228,250));
		}
		return scrollPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="20,10"
