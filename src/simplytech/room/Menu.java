package simplytech.room;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ListSelectionModel;

import simplytech.dao.CustomerDAO;
import simplytech.dao.MenuDAO;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelMenu = null;
	private JButton jButtonOrder = null;
	private JFrame myFrame = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JTabbedPane menuPane;
	private JTabbedPane breakfastPane;
	private JTabbedPane lunchPane;
	private JTabbedPane dinnerPane;
	private JPanel omeletPanel;
	private JTable table;
	private JTable table_1;
	private JPanel starter;
	private JTable table_2;
	private JTable table_3;
	private JPanel salads;
	private JTable table_4;
	private JPanel pizzaa;
	private JTable table_5;
	private JPanel entree;
	private JTable table_6;
	private JPanel starters;
	private JTable table_7;
	private JPanel mainCourse;
	private JPanel dessert;
	private JTable table_8;
	private JTable table_9;
	private JButton buttonOrder;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private int quantity;
	private String item;
	private double price;
	private double totalPrice;
	private int points;
	private String username;
	private int id;
	private int currentPoints;
	private double currentCharges;
	private int finalPoints;
	private double finalCharges;
	private Calendar calendar;
	private long start;
	private long stop;

	/**
	 * This is the default constructor
	 */
	public Menu() {
		super();
		initialize();
	}

	public Menu(JFrame f) {
		this();
		myFrame = f;
		initialize();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		username = MainFrame.getPersonWhoLogin().getUsername();
		id = MainFrame.getPersonWhoLogin().getId();
		currentCharges = MainFrame.getPersonWhoLogin().getExtraCharges();
		currentPoints = MainFrame.getPersonWhoLogin().getPoints();

		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(Menu.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start = calendar.getInstance().getTimeInMillis();
			}
			public void mouseReleased(MouseEvent arg0) {
				stop = calendar.getInstance().getTimeInMillis();
				if (stop - start < 500) {
					JPanel panel = new RoomServices(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				} else {
					JPanel panel = new RoomHomePagePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			}
		});
		jLabelMenu = new JLabel();
		jLabelMenu.setPreferredSize(new Dimension(300, 85));
		jLabelMenu.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelMenu.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelMenu.setText("Menu");
		jLabelMenu.setSize(new Dimension(216, 35));
		jLabelMenu.setLocation(new Point(91, 23));
		jLabelMenu.setFont(new Font("Arial", Font.BOLD, 28));
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelMenu, null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);
		add(getMenuPane());

		JLabel lblAllPricesIn = new JLabel(
				"All Prices in SGD$ and inclusive of GST.");
		lblAllPricesIn.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAllPricesIn.setBounds(85, 510, 566, 26);
		add(lblAllPricesIn);
	}

	/**
	 * This method initializes jButtonDone
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonOrder() {
		if (jButtonOrder == null) {
			jButtonOrder = new JButton();
			jButtonOrder.setBounds(338, 269, 216, 35);
			jButtonOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int row = table.getSelectedRow();
					int col = table.getColumnCount();

					for (int i = 0; i < col; i++) {
						item = (String) table.getValueAt(row, i = 0);
						setItem(item);
						price = (Double) table.getValueAt(row, i = 1);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "" + "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e) {
						// TODO Auto-generated catchuunto block
						e.printStackTrace();
					}
				}
			});
			jButtonOrder.setFont(new Font("Calibri", Font.BOLD, 24));
			jButtonOrder.setPreferredSize(new Dimension(92, 45));
			jButtonOrder.setText("Place Order");
			jButtonOrder.setBackground(new Color(91, 155, 231));
		}
		return jButtonOrder;
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

	private JTabbedPane getMenuPane() {
		if (menuPane == null) {
			menuPane = new JTabbedPane(JTabbedPane.TOP);
			menuPane.setFont(new Font("Calibri", Font.BOLD, 18));
			menuPane.setBorder(new LineBorder(SystemColor.activeCaptionText, 3,
					true));
			menuPane.setBounds(75, 108, 876, 391);
			menuPane.addTab("Breakfast (8am - 11am)", null, getBreakfastPane(),
					null);
			menuPane.addTab("Lunch (11.30am - 2pm)", null, getLunchPane(), null);
			menuPane.addTab(" Dinner (5pm- 10pm)", null, getDinnerPane(), null);
		}
		return menuPane;
	}

	private JTabbedPane getBreakfastPane() {
		if (breakfastPane == null) {
			breakfastPane = new JTabbedPane(JTabbedPane.TOP);
			breakfastPane.setFont(new Font("Calibri", Font.BOLD, 15));
			breakfastPane.addTab("Omelets", null, getOmeletPanel(), null);

			JPanel beveragesPane = new JPanel();
			breakfastPane.addTab("Beverages", null, beveragesPane, null);
			beveragesPane.setLayout(null);

			table_1 = new JTable();
			table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_1.setModel(new DefaultTableModel(new Object[][] {
					{ "Milk", new Double(1.95) },
					{ "Hot Chocolate", new Double(1.95) },
					{ "Coffee", new Double(1.95) },
					{ "Lemonade", new Double(1.95) }, }, new String[] {
					"Beverages", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_1.getColumnModel().getColumn(0).setResizable(false);
			table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_1.getColumnModel().getColumn(1).setResizable(false);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(30);
			table_1.setRowHeight(50);
			table_1.setFont(new Font("Calibri", Font.BOLD, 18));
			table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_1.setFillsViewportHeight(true);
			table_1.setBounds(63, 34, 708, 200);
			beveragesPane.add(table_1);

			JButton buttonOrder = new JButton();
			buttonOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int row = table_1.getSelectedRow();
					int col = table_1.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_1.getValueAt(row, i = 0);
						setItem(item);
						price = (Double) table_1.getValueAt(row, i = 1);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e) {
						// TODO Auto-generated catchuunto block
						e.printStackTrace();
					}
				}
			});
			buttonOrder.setText("Place Order");
			buttonOrder.setPreferredSize(new Dimension(92, 45));
			buttonOrder.setFont(new Font("Calibri", Font.BOLD, 24));
			buttonOrder.setBackground(new Color(91, 155, 231));
			buttonOrder.setBounds(356, 269, 216, 35);
			beveragesPane.add(buttonOrder);
		}
		return breakfastPane;
	}

	private JTabbedPane getLunchPane() {
		if (lunchPane == null) {
			lunchPane = new JTabbedPane(JTabbedPane.TOP);
			lunchPane.setFont(new Font("Calibri", Font.BOLD, 15));
			lunchPane.addTab("Starter", null, getStarter(), null);

			JPanel sandwiches = new JPanel();
			lunchPane.addTab("Sandwiches", null, sandwiches, null);
			sandwiches.setLayout(null);
			sandwiches.add(getTable_3());
			sandwiches.add(getButton());
			lunchPane.addTab("Salads", null, getSalads(), null);
			lunchPane.addTab("Pizzas", null, getPizzaa(), null);
			lunchPane.addTab("Entree", null, getEntree(), null);
		}
		return lunchPane;
	}

	private JTabbedPane getDinnerPane() {
		if (dinnerPane == null) {
			dinnerPane = new JTabbedPane(JTabbedPane.TOP);
			dinnerPane.setFont(new Font("Calibri", Font.BOLD, 15));
			dinnerPane.addTab("Starter", null, getStarters(), null);
			dinnerPane.addTab("Main Course", null, getMainCourse(), null);
			dinnerPane.addTab("Desserts", null, getDessert(), null);
		}
		return dinnerPane;
	}

	private JPanel getOmeletPanel() {
		if (omeletPanel == null) {
			omeletPanel = new JPanel();
			omeletPanel.setLayout(null);

			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFillsViewportHeight(true);
			table.setBounds(60, 38, 756, 200);
			table.setModel(new DefaultTableModel(new Object[][] {
					{ "Plain Omelet", new Double(5.95) },
					{ "Ham & Cheese Omelet", new Double(7.95) },
					{ "Bacon & Cheese Omelet", new Double(7.95) },
					{ "Sausage & Cheese Omelet", new Double(7.95) }, },
					new String[] { "Omelets", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(200);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(30);
			table.setRowHeight(50);
			table.setFont(new Font("Calibri", Font.BOLD, 18));
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			omeletPanel.add(table);
			omeletPanel.add(getJButtonOrder());
		}
		return omeletPanel;
	}

	private JPanel getStarter() {
		if (starter == null) {
			starter = new JPanel();
			starter.setLayout(null);

			table_2 = new JTable();
			table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_2.setFont(new Font("Calibri", Font.BOLD, 18));
			table_2.setModel(new DefaultTableModel(new Object[][] {
					{ "Steamed Vegetable", new Double(16.55) },
					{ "Creamy White Asparagus Bisque", new Double(9.55) },
					{ "Charred Pesto Shrimp Skewer", new Double(15.99) },
					{ "Spicy Ahi Tuna ", new Double(14.25) },
					{ "Onion Soup", new Double(12.55) }, }, new String[] {
					"Starter", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_2.getColumnModel().getColumn(0).setResizable(false);
			table_2.getColumnModel().getColumn(0).setPreferredWidth(174);
			table_2.getColumnModel().getColumn(0).setMinWidth(40);
			table_2.getColumnModel().getColumn(1).setResizable(false);
			table_2.getColumnModel().getColumn(1).setPreferredWidth(80);
			table_2.setRowHeight(50);
			table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_2.setFillsViewportHeight(true);
			table_2.setBounds(76, 11, 717, 250);
			starter.add(table_2);
			starter.add(getButtonOrder());
		}
		return starter;
	}

	private JTable getTable_3() {
		if (table_3 == null) {
			table_3 = new JTable();
			table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_3.setModel(new DefaultTableModel(new Object[][] {
					{ "CP Angus Burger", new Double(16.55) },
					{ "\"Crowne\" Burger", new Double(17.65) },
					{ "Elevator Burger", new Double(12.95) },
					{ "Grilled Stick Sandwich", new Double(15.99) },
					{ "Classical Falafel", new Double(14.25) }, },
					new String[] { "Sandwiches", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_3.getColumnModel().getColumn(0).setResizable(false);
			table_3.getColumnModel().getColumn(1).setResizable(false);
			table_3.setRowHeight(50);
			table_3.setFont(new Font("Calibri", Font.BOLD, 18));
			table_3.setFillsViewportHeight(true);
			table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_3.setBounds(54, 11, 756, 250);
		}
		return table_3;
	}

	private JPanel getSalads() {
		if (salads == null) {
			salads = new JPanel();
			salads.setLayout(null);
			salads.add(getTable_4());
			salads.add(getButton_1());
		}
		return salads;
	}

	private JTable getTable_4() {
		if (table_4 == null) {
			table_4 = new JTable();
			table_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_4.setModel(new DefaultTableModel(new Object[][] {
					{ "Rainbow Chopped Salad", new Double(15.95) },
					{ "Citrus French Bean Salad", new Double(12.55) },
					{ "1605 Salad", new Double(14.85) },
					{ "Caesar Salad", new Double(14.85) },
					{ "Veal Culet Salad", new Double(16.95) }, }, new String[] {
					"Salads", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_4.getColumnModel().getColumn(0).setResizable(false);
			table_4.getColumnModel().getColumn(1).setResizable(false);
			table_4.setRowHeight(50);
			table_4.setFont(new Font("Calibri", Font.BOLD, 18));
			table_4.setFillsViewportHeight(true);
			table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_4.setBounds(40, 11, 747, 250);
		}
		return table_4;
	}

	private JPanel getPizzaa() {
		if (pizzaa == null) {
			pizzaa = new JPanel();
			pizzaa.setLayout(null);
			pizzaa.add(getTable_5());
			pizzaa.add(getButton_2());
		}
		return pizzaa;
	}

	private JTable getTable_5() {
		if (table_5 == null) {
			table_5 = new JTable();
			table_5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_5.setModel(new DefaultTableModel(new Object[][] {
					{ "Pepperoni", new Double(16.55) },
					{ "Italian", new Double(15.85) },
					{ "Vegetarian", new Double(14.55) },
					{ "Hawaiian", new Double(17.65) }, }, new String[] {
					"Pizzas", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_5.getColumnModel().getColumn(0).setResizable(false);
			table_5.getColumnModel().getColumn(1).setResizable(false);
			table_5.setRowHeight(50);
			table_5.setFont(new Font("Calibri", Font.BOLD, 18));
			table_5.setFillsViewportHeight(true);
			table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_5.setBounds(42, 35, 745, 200);
		}
		return table_5;
	}

	private JPanel getEntree() {
		if (entree == null) {
			entree = new JPanel();
			entree.setLayout(null);
			entree.add(getTable_6());
			entree.add(getButton_3());
		}
		return entree;
	}

	private JTable getTable_6() {
		if (table_6 == null) {
			table_6 = new JTable();
			table_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_6.setModel(new DefaultTableModel(new Object[][] {
					{ "Seared Atlantic Salmon", new Double(24.65) },
					{ "Jumbo Lump Crab Cakes", new Double(29.95) },
					{ "Cajun Blackened Catfish", new Double(27.55) },
					{ "Chicken & Waffles", new Double(23.45) },
					{ "Steak Au Poivre", new Double(32.55) }, }, new String[] {
					"Entree", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_6.getColumnModel().getColumn(0).setResizable(false);
			table_6.getColumnModel().getColumn(1).setResizable(false);
			table_6.setRowHeight(50);
			table_6.setFont(new Font("Calibri", Font.BOLD, 18));
			table_6.setFillsViewportHeight(true);
			table_6.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_6.setBounds(40, 11, 745, 250);
		}
		return table_6;
	}

	private JPanel getStarters() {
		if (starters == null) {
			starters = new JPanel();
			starters.setLayout(null);
			starters.add(getTable_7());
			starters.add(getButton_4());
		}
		return starters;
	}

	private JTable getTable_7() {
		if (table_7 == null) {
			table_7 = new JTable();
			table_7.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_7.setModel(new DefaultTableModel(new Object[][] {
					{ "Tea Poached Chicken Breast Salad", new Double(16.25) },
					{ "Chargrilled Asparagus", new Double(16.45) },
					{ "Pigeon with Oyster Dressing", new Double(17.55) },
					{ "Crab with Pepper Fonfetti", new Double(17.85) },
					{ "Pistachio Praline Scallop", new Double(18.95) }, },
					new String[] { "New column", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_7.getColumnModel().getColumn(0).setResizable(false);
			table_7.getColumnModel().getColumn(0).setPreferredWidth(180);
			table_7.getColumnModel().getColumn(1).setResizable(false);
			table_7.setRowHeight(50);
			table_7.setFont(new Font("Calibri", Font.BOLD, 18));
			table_7.setFillsViewportHeight(true);
			table_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_7.setBounds(38, 11, 745, 250);
		}
		return table_7;
	}

	private JPanel getMainCourse() {
		if (mainCourse == null) {
			mainCourse = new JPanel();
			mainCourse.setLayout(null);
			mainCourse.add(getTable_8());
			mainCourse.add(getButton_5());
		}
		return mainCourse;
	}

	private JPanel getDessert() {
		if (dessert == null) {
			dessert = new JPanel();
			dessert.setLayout(null);
			dessert.add(getTable_9());
			dessert.add(getButton_6());
		}
		return dessert;
	}

	private JTable getTable_8() {
		if (table_8 == null) {
			table_8 = new JTable();
			table_8.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_8.setModel(new DefaultTableModel(new Object[][] {
					{ "John Dory with Saffron Potato", new Double(19.95) },
					{ "Pancetta Lardons Duck", new Double(28.55) },
					{ "Seared Supreme Chicken", new Double(19.55) },
					{ "Sauce Vierged Lamb", new Double(17.85) },
					{ "Foie Gras", new Double(25.65) }, }, new String[] {
					"Main Course", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_8.getColumnModel().getColumn(0).setResizable(false);
			table_8.getColumnModel().getColumn(1).setResizable(false);
			table_8.setRowHeight(50);
			table_8.setFont(new Font("Calibri", Font.BOLD, 18));
			table_8.setFillsViewportHeight(true);
			table_8.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_8.setBounds(58, 11, 745, 250);
		}
		return table_8;
	}

	private JTable getTable_9() {
		if (table_9 == null) {
			table_9 = new JTable();
			table_9.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_9.setModel(new DefaultTableModel(new Object[][] {
					{ "Pistachio Biscotti", new Double(6.55) },
					{ "Panacotta", new Double(6.55) },
					{ "Lemon Meringue Pie", new Double(6.55) },
					{ "Chutney", new Double(7.55) }, }, new String[] {
					"Desserts", "Price (SGD$)" }) {
				Class[] columnTypes = new Class[] { String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table_9.getColumnModel().getColumn(0).setResizable(false);
			table_9.getColumnModel().getColumn(1).setResizable(false);
			table_9.setRowHeight(50);
			table_9.setFont(new Font("Calibri", Font.BOLD, 18));
			table_9.setFillsViewportHeight(true);
			table_9.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_9.setBounds(46, 42, 745, 200);
		}
		return table_9;
	}

	private JButton getButtonOrder() {
		if (buttonOrder == null) {
			buttonOrder = new JButton();
			buttonOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_2.getSelectedRow();
					int col = table_2.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_2.getValueAt(row, i = 0);
						setItem(item);
						price = (Double) table_2.getValueAt(row, i = 1);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e7) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e7.printStackTrace();
					}

				}
			});
			buttonOrder.setText("Place Order");
			buttonOrder.setPreferredSize(new Dimension(92, 45));
			buttonOrder.setFont(new Font("Calibri", Font.BOLD, 24));
			buttonOrder.setBackground(new Color(91, 155, 231));
			buttonOrder.setBounds(367, 272, 216, 35);
		}
		return buttonOrder;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_3.getSelectedRow();
					int col = table_3.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_3.getValueAt(row, i = 0);
						price = (Double) table_3.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e6) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e6.printStackTrace();
					}

				}
			});
			button.setText("Place Order");
			button.setPreferredSize(new Dimension(92, 45));
			button.setFont(new Font("Calibri", Font.BOLD, 24));
			button.setBackground(new Color(91, 155, 231));
			button.setBounds(352, 272, 216, 35);
		}
		return button;
	}

	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton();
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_4.getSelectedRow();
					int col = table_4.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_4.getValueAt(row, i = 0);
						price = (Double) table_4.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e5) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e5.printStackTrace();
					}

				}

			});
			button_1.setText("Place Order");
			button_1.setPreferredSize(new Dimension(92, 45));
			button_1.setFont(new Font("Calibri", Font.BOLD, 24));
			button_1.setBackground(new Color(91, 155, 231));
			button_1.setBounds(364, 269, 216, 35);
		}
		return button_1;
	}

	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton();
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int row = table_5.getSelectedRow();
					int col = table_5.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_5.getValueAt(row, i = 0);
						price = (Double) table_5.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
				}

			});
			button_2.setText("Place Order");
			button_2.setPreferredSize(new Dimension(92, 45));
			button_2.setFont(new Font("Calibri", Font.BOLD, 24));
			button_2.setBackground(new Color(91, 155, 231));
			button_2.setBounds(348, 257, 216, 35);
		}
		return button_2;
	}

	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton();
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_6.getSelectedRow();
					int col = table_6.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_6.getValueAt(row, i = 0);
						price = (Double) table_6.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					setPoints(points);
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e4.printStackTrace();
					}

				}
			});
			button_3.setText("Place Order");
			button_3.setPreferredSize(new Dimension(92, 45));
			button_3.setFont(new Font("Calibri", Font.BOLD, 24));
			button_3.setBackground(new Color(91, 155, 231));
			button_3.setBounds(361, 272, 216, 35);
		}
		return button_3;
	}

	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton();
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_7.getSelectedRow();
					int col = table_7.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_7.getValueAt(row, i = 0);
						price = (Double) table_7.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e3.printStackTrace();
					}

				}
			});
			button_4.setText("Place Order");
			button_4.setPreferredSize(new Dimension(92, 45));
			button_4.setFont(new Font("Calibri", Font.BOLD, 24));
			button_4.setBackground(new Color(91, 155, 231));
			button_4.setBounds(350, 269, 216, 35);
		}
		return button_4;
	}

	private JButton getButton_5() {
		if (button_5 == null) {
			button_5 = new JButton();
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_8.getSelectedRow();
					int col = table_8.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_8.getValueAt(row, i = 0);
						price = (Double) table_8.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e2.printStackTrace();
					}

				}
			});
			button_5.setText("Place Order");
			button_5.setPreferredSize(new Dimension(92, 45));
			button_5.setFont(new Font("Calibri", Font.BOLD, 24));
			button_5.setBackground(new Color(91, 155, 231));
			button_5.setBounds(349, 272, 216, 35);
		}
		return button_5;
	}

	private JButton getButton_6() {
		if (button_6 == null) {
			button_6 = new JButton();
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_9.getSelectedRow();
					int col = table_9.getColumnCount();

					for (int i = 0; i < col; i++) {

						item = (String) table_9.getValueAt(row, i = 0);
						price = (Double) table_9.getValueAt(row, i = 1);
						setItem(item);
						setPrice(price);
					}

					quantity = Integer.parseInt(JOptionPane.showInputDialog(
							myFrame, "Quantity:", "Place order",
							JOptionPane.PLAIN_MESSAGE));
					setQuantity(quantity);
					totalPrice = price * quantity;
					points = (int) totalPrice;
					finalCharges = currentCharges + totalPrice;
					finalPoints = currentPoints + points;

					JOptionPane.showConfirmDialog(myFrame, "You have ordered: "
							+ quantity + " x " + item + "\n Total: SGD$"
							+ totalPrice + "\n Points earned: " + points,
							"Place order", JOptionPane.OK_OPTION);

					simplytech.entity.Menu menu = new simplytech.entity.Menu();
					menu.setQuantity(quantity);
					menu.setItem(item);
					menu.setTotalPrice(totalPrice);
					menu.setPoints(points);
					menu.setUsername(username);
					menu.setId(id);
					MenuDAO.save(menu);
					try {
						CustomerDAO.updateCharges(finalCharges, MainFrame
								.getPersonWhoLogin().getId());
						CustomerDAO.updatePoints(finalPoints, MainFrame
								.getPersonWhoLogin().getId());
						MainFrame.getPersonWhoLogin().setExtraCharges(
								finalCharges);
						MainFrame.getPersonWhoLogin().setPoints(finalPoints);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("failed");
						e1.printStackTrace();
					}

				}
			});
			button_6.setText("Place Order");
			button_6.setPreferredSize(new Dimension(92, 45));
			button_6.setFont(new Font("Calibri", Font.BOLD, 24));
			button_6.setBackground(new Color(91, 155, 231));
			button_6.setBounds(310, 267, 216, 35);
		}
		return button_6;
	}
}

// Read in the data from the user here.