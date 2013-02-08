package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.entity.Menu;
import simplytech.databasestatements.DBConnectionManager;

public class MenuDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static Menu searchByUsername(String name, int id) {

		Menu menu = null;
		Statement stmt = null;
		String searchQuery = "select * from menu where username ='" + name
				+ "'and id = '" + id + "'";

		try {
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				System.out.println("member with the username = " + name
						+ " does not exist. ");
			} else if (more) {
				int id2 = rs.getInt("id");
				String username = rs.getString("username");
				int quantity = rs.getInt("quantity");
				String item = rs.getString("item");
				double totalPrice = rs.getDouble("totalPrice");
				int points = rs.getInt("points");
				int menuID = rs.getInt(getMax());

				menu = new Menu();
				menu.setId(id2);
				menu.setUsername(username);
				menu.setQuantity(quantity);
				menu.setItem(item);
				menu.setTotalPrice(totalPrice);
				menu.setPoints(points);
				menu.setMenuID(menuID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

	public static Menu searchById(int id) {

		Menu menu = null;
		Statement stmt = null;
		String searchQuery = "select * from menu where id =" + id;

		try {
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				System.out.println("member with the id = " + id
						+ " does not exist. ");
			} else if (more) {
				int id2 = rs.getInt("id");
				String username = rs.getString("username");
				int quantity = rs.getInt("quantity");
				String item = rs.getString("item");
				double totalPrice = rs.getDouble("totalPrice");
				int points = rs.getInt("points");
				int menuID = rs.getInt(getMax());

				menu = new Menu();
				menu.setId(id2);
				menu.setUsername(username);
				menu.setQuantity(quantity);
				menu.setItem(item);
				menu.setTotalPrice(totalPrice);
				menu.setPoints(points);
				menu.setMenuID(menuID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

	public static int getMax() throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(menuID) FROM menu";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(menuID)");
		}
		return count;
	}

	public static void save(simplytech.entity.Menu menu) {

		Statement stmt = null;

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// query for inserting into the table
			String query = "insert into menu(item,quantity,totalPrice, points, username, id,menuID) values(?,?,?,?,?,?,?,?)";
			pstmt = currentCon.prepareStatement(query);

			// inserting values
			pstmt.setString(1, menu.getItem());
			pstmt.setInt(2, menu.getQuantity());
			pstmt.setDouble(3, menu.getTotalPrice());
			pstmt.setInt(4, menu.getPoints());
			pstmt.setString(5, menu.getUsername());
			pstmt.setInt(6, menu.getId());
			pstmt.setInt(7, menu.getMenuID());
			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out.println("Order fail: An Exception has occurred! " + ex);
		}

		// exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

	}
}
