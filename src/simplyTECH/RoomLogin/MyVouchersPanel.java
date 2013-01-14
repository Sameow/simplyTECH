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
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class MyVouchersPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JTextPane jTextPaneFoodVoucherLunch = null;
	private JLabel jLabel1 = null;
	private JTextPane jTextPane1 = null;
	private JLabel jLabelFoodVoucherLunch1 = null;
	private JTextPane jTextPaneTitle1 = null;
	private JLabel jLabelDate1 = null;
	private JTextPane jTextPaneDescriptionBig1 = null;
	private JTextPane jTextPaneDescription1 = null;
	private JLabel jLabel11 = null;
	private JTextPane jTextPaneFoodVoucherBreakfast = null;
	private JLabel jLabelFoodVoucherBreakfast = null;
	private JTextPane jTextPaneTitle2 = null;
	private JLabel jLabelDate2 = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPaneDescription2 = null;
	/**
	 * This is the default constructor
	 */
	public MyVouchersPanel() {
		super();
		initialize();
	}
	public MyVouchersPanel(JFrame f){
		this();
		myFrame = f;
		//initialize();
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
		jLabelDate2 = new JLabel();
		jLabelDate2.setBounds(new Rectangle(717, 210, 114, 16));
		jLabelDate2.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelDate2.setText("11/5/2012 - 19/5/2012");
		jLabelDate2.setVisible(false);
		jLabelFoodVoucherBreakfast = new JLabel();
		jLabelFoodVoucherBreakfast.setBounds(new Rectangle(583, 125, 110, 105));
		jLabelFoodVoucherBreakfast.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/FoodVoucherBreakfastBig.png")));
		jLabelFoodVoucherBreakfast.setText("");
		jLabelFoodVoucherBreakfast.setVisible(false);
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(112, 242, 69, 69));
		jLabel11.setText("");
		jLabel11.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/FoodVoucherBreakfast.png")));
		jLabelDate1 = new JLabel();
		jLabelDate1.setBounds(new Rectangle(718, 207, 138, 22));
		jLabelDate1.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabelDate1.setText("11/5/2012 - 19/5/2012");
		jLabelDate1.setVisible(true);
		jLabelFoodVoucherLunch1 = new JLabel();
		jLabelFoodVoucherLunch1.setBounds(new Rectangle(585, 121, 111, 114));
		jLabelFoodVoucherLunch1.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/FoodVoucherLunchBig.png")));
		jLabelFoodVoucherLunch1.setText("");
		jLabelFoodVoucherLunch1.setVisible(true);
		jLabel1 = new JLabel();
		jLabel1.setIcon(new ImageIcon(getClass().getResource("/simplyTECH/image/FoodVoucherLunch.png")));
		jLabel1.setLocation(new Point(111, 139));
		jLabel1.setSize(new Dimension(189, 83));
		jLabel1.setText("");
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
		this.add(getJTextPaneFoodVoucherLunch(), null);
		this.add(jLabel1, null);
		this.add(getJTextPane1(), null);
		this.add(jLabelFoodVoucherLunch1, null);
		this.add(getJTextPaneTitle1(), null);
		this.add(jLabelDate1, null);
		this.add(getJTextPaneDescriptionBig1(), null);
		this.add(getJTextPaneDescription1(), null);
		this.add(jLabel11, null);
		this.add(getJTextPaneFoodVoucherBreakfast(), null);
		this.add(jLabelFoodVoucherBreakfast, null);
		this.add(getJTextPaneTitle2(), null);
		this.add(jLabelDate2, null);
		this.add(jLabelBack, null);
		this.add(getJTextPaneDescription2(), null);
	}

	/**
	 * This method initializes jTextPane	
	 * 	{ *** VE HEADER ***}<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.0"
    xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore"
    xmlns:java.awt="java:/java.awt" xmlns:java.lang="java:/java.lang" xmlns:javax.swing="java:/javax.swing"
    xmlns:org.eclipse.jem.internal.instantiation="http:///org/eclipse/jem/internal/instantiation.ecore"
    xmlns:org.eclipse.ve.internal.cdm="http:///org/eclipse/ve/internal/cdm.ecore">
  <javax.swing:JLabel xmi:id="ID_0" font="ID_2" preferredSize="ID_3" text="ID_4">
    <allocation xsi:type="org.eclipse.jem.internal.instantiation:ParseTreeAllocation">
      <expression xsi:type="org.eclipse.jem.internal.instantiation:PTClassInstanceCreation" type="javax.swing.JLabel"/>
    </allocation>
  </javax.swing:JLabel>
  <org.eclipse.ve.internal.cdm:AnnotationEMF xmi:id="ID_1" annotates="ID_0">
    <keyedValues xsi:type="ecore:EStringToStringMapEntry" key="org.eclipse.ve.internal.cde.core.nameincomposition"
        value="jLabel"/>
  </org.eclipse.ve.internal.cdm:AnnotationEMF>
  <java.awt:Font xmi:id="ID_2">
    <allocation xsi:type="org.eclipse.jem.internal.instantiation:ParseTreeAllocation">
      <expression xsi:type="org.eclipse.jem.internal.instantiation:PTClassInstanceCreation" type="java.awt.Font">
        <arguments xsi:type="org.eclipse.jem.internal.instantiation:PTStringLiteral" escapedValue="&quot;Calibri&quot;"/>
        <arguments xsi:type="org.eclipse.jem.internal.instantiation:PTFieldAccess" field="BOLD">
          <receiver xsi:type="org.eclipse.jem.internal.instantiation:PTName" name="java.awt.Font"/>
        </arguments>
        <arguments xsi:type="org.eclipse.jem.internal.instantiation:PTNumberLiteral" token="36"/>
      </expression>
    </allocation>
  </java.awt:Font>
  <java.awt:Dimension xmi:id="ID_3">
    <allocation xsi:type="org.eclipse.jem.internal.instantiation:ParseTreeAllocation">
      <expression xsi:type="org.eclipse.jem.internal.instantiation:PTClassInstanceCreation" type="java.awt.Dimension">
        <arguments xsi:type="org.eclipse.jem.internal.instantiation:PTNumberLiteral" token="55"/>
        <arguments xsi:type="org.eclipse.jem.internal.instantiation:PTNumberLiteral" token="24"/>
      </expression>
    </allocation>
  </java.awt:Dimension>
  <java.lang:String xmi:id="ID_4">
    <allocation xsi:type="org.eclipse.jem.internal.instantiation:InitStringAllocation" initString="&quot;My Account&quot;"/>
  </java.lang:String>
</xmi:XMI>

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
	 * This method initializes jTextPaneFoodVoucherLunch	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneFoodVoucherLunch() {
		if (jTextPaneFoodVoucherLunch == null) {
			jTextPaneFoodVoucherLunch = new JTextPane();
			jTextPaneFoodVoucherLunch.setBounds(new Rectangle(180, 146, 159, 69));
			jTextPaneFoodVoucherLunch.setBackground(new Color(31, 78, 121));
			jTextPaneFoodVoucherLunch.setFont(new Font("Calibri", Font.PLAIN, 20));
			jTextPaneFoodVoucherLunch.setForeground(Color.white);
			jTextPaneFoodVoucherLunch.setEditable(false);
			jTextPaneFoodVoucherLunch.setText("Food Voucher (For 1) - Lunch");
			jTextPaneFoodVoucherLunch.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextPaneFoodVoucherLunch.setBackground(new Color(31, 78, 121));
					jLabelFoodVoucherLunch1.setVisible(true);
					jTextPaneDescriptionBig1.setVisible(true);
					jTextPaneTitle1.setVisible(true);
					jTextPaneDescription1.setVisible(true);
					jTextPaneFoodVoucherBreakfast.setBackground(new Color(91, 155, 213));
					jLabelFoodVoucherBreakfast.setVisible(false);
					jTextPaneTitle2.setVisible(false);
					jLabelDate2.setVisible(false);
					jLabelDate1.setVisible(true);
					jTextPaneDescription1.setVisible(true);
					jTextPaneDescription2.setVisible(false);
				}
			});
		}
		return jTextPaneFoodVoucherLunch;
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
	private JTextPane getJTextPaneTitle1() {
		if (jTextPaneTitle1 == null) {
			jTextPaneTitle1 = new JTextPane();
			jTextPaneTitle1.setBounds(new Rectangle(716, 123, 169, 78));
			jTextPaneTitle1.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle1.setBackground(new Color(227, 228, 250));
			jTextPaneTitle1.setText("Food Voucher (For 1) - Lunch");
			jTextPaneTitle1.setVisible(true);
		}
		return jTextPaneTitle1;
	}

	/**
	 * This method initializes jTextPaneDescriptionBig1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescriptionBig1() {
		if (jTextPaneDescriptionBig1 == null) {
			jTextPaneDescriptionBig1 = new JTextPane();
			jTextPaneDescriptionBig1.setBounds(new Rectangle(586, 257, 296, 87));
			jTextPaneDescriptionBig1.setFont(new Font("Calibri", Font.PLAIN, 18));
			jTextPaneDescriptionBig1.setBackground(new Color(227, 228, 250));
			jTextPaneDescriptionBig1.setText("Redeem this voucher to enjoy 50% off the second person");
			jTextPaneDescriptionBig1.setVisible(true);
		}
		return jTextPaneDescriptionBig1;
	}

	/**
	 * This method initializes jTextPaneDescription1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescription1() {
		if (jTextPaneDescription1 == null) {
			jTextPaneDescription1 = new JTextPane();
			jTextPaneDescription1.setBounds(new Rectangle(578, 341, 354, 157));
			jTextPaneDescription1.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDescription1.setBackground(new Color(227, 228, 250));
			jTextPaneDescription1.setText("Voucher is only valid for 7 days upon purchase. 50% is only applicable to the second or subsequent person you bring. 1 time use only.  Voucher is non transferable and non-refundable. Voucher is only valid from 12pm to 3pm daily.");
			jTextPaneDescription1.setVisible(true);
		}
		return jTextPaneDescription1;
	}

	/**
	 * This method initializes jTextPaneFoodVoucherBreakfast	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneFoodVoucherBreakfast() {
		if (jTextPaneFoodVoucherBreakfast == null) {
			jTextPaneFoodVoucherBreakfast = new JTextPane();
			jTextPaneFoodVoucherBreakfast.setFont(new Font("Calibri", Font.PLAIN, 20));
			jTextPaneFoodVoucherBreakfast.setForeground(Color.white);
			jTextPaneFoodVoucherBreakfast.setText("Food Voucher (For 1) - Breakfast");
			jTextPaneFoodVoucherBreakfast.setEditable(false);
			jTextPaneFoodVoucherBreakfast.setLocation(new Point(181, 242));
			jTextPaneFoodVoucherBreakfast.setSize(new Dimension(159, 69));
			jTextPaneFoodVoucherBreakfast.setBackground(new Color(91, 155, 213));
			jTextPaneFoodVoucherBreakfast
					.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextPaneFoodVoucherBreakfast.setBackground(new Color(31, 78, 121));
							jTextPaneFoodVoucherLunch.setBackground(new Color(91, 155, 213));
							jLabelFoodVoucherLunch1.setVisible(false);
							//jLabelFoodVoucherLunch1.set
							jLabelDate1.setVisible(false);
							jTextPaneDescriptionBig1.setVisible(true);
							jTextPaneTitle1.setVisible(false);	
							jTextPaneDescription1.setVisible(true);
							jLabelFoodVoucherBreakfast.setVisible(true);
							jTextPaneTitle2.setVisible(true);
							jLabelDate2.setVisible(true);
							//myFrame.validate();
							//myFrame.repaint();

							jTextPaneDescription1.setVisible(false);
							jTextPaneDescription2.setVisible(true);

						}
					});
		}
		return jTextPaneFoodVoucherBreakfast;
	}

	/**
	 * This method initializes jTextPaneTitle2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneTitle2() {
		if (jTextPaneTitle2 == null) {
			jTextPaneTitle2 = new JTextPane();
			jTextPaneTitle2.setFont(new Font("Calibri", Font.BOLD, 22));
			jTextPaneTitle2.setBackground(new Color(227, 228, 250));
			jTextPaneTitle2.setText("Food Voucher (For 1) - Breakfast");
			jTextPaneTitle2.setLocation(new Point(712, 122));
			jTextPaneTitle2.setSize(new Dimension(175, 78));
			jTextPaneTitle2.setVisible(false);
		}
		return jTextPaneTitle2;
	}
	/**
	 * This method initializes jTextPaneDescription2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescription2() {
		if (jTextPaneDescription2 == null) {
			jTextPaneDescription2 = new JTextPane();
			jTextPaneDescription2.setBounds(new Rectangle(576, 338, 350, 131));
			jTextPaneDescription2.setFont(new Font("Calibri", Font.PLAIN, 16));
			jTextPaneDescription2.setBackground(new Color(227, 228, 250));
			jTextPaneDescription2.setText("Voucher is only valid for 7 days upon purchase. 50% is only applicable to the second or subsequent person you bring. 1 time use only.  Voucher is non transferable and non-refundable. Voucher is only valid from 7am to 11am daily.");
			jTextPaneDescription2.setVisible(false);
		}
		return jTextPaneDescription2;
	}

}  //  @jve:decl-index=0:visual-constraint="20,10"
