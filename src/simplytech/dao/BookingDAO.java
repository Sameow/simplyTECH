package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Booking;

public class BookingDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static Booking searchByUsername(String name, int id) {

		Booking booking = null;
		Statement stmt = null;
		String searchQuery = "select * from booking where username ='" + name
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
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int points = rs.getInt("points");
				int bookingID = rs.getInt(getMax());

				booking = new Booking();
				booking.setId(id2);
				booking.setUsername(username);
				booking.setTitle(title);
				booking.setPrice(price);
				booking.setPoints(points);
				booking.setBookingID(bookingID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booking;
	}

	public static Booking searchById(int id) {

		Booking booking = null;
		Statement stmt = null;
		String searchQuery = "select * from booking where id = " + id;

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
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int points = rs.getInt("points");
				int bookingID = rs.getInt(getMax());

				booking = new Booking();
				booking.setId(id2);
				booking.setUsername(username);
				booking.setTitle(title);
				booking.setPrice(price);
				booking.setPoints(points);
				booking.setBookingID(bookingID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booking;
	}

	public static int getMax() throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(bookingID) FROM booking";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(bookingID)");
		}
		return count;
	}

	public static void save(Booking b) {

		Statement stmt = null;

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// query for inserting into the table
			String query = "insert into booking(title, price, points,username, id,bookingID) values(?,?,?,?,?,?)";
			pstmt = currentCon.prepareStatement(query);

			// inserting values
			pstmt.setString(1, b.getTitle());
			pstmt.setDouble(2, b.getPrice());
			pstmt.setInt(3, b.getPoints());
			pstmt.setString(4, b.getUsername());
			pstmt.setInt(5, b.getId());
			pstmt.setInt(6, b.getBookingID());
			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out
					.println("Booking fail: An Exception has occurred! " + ex);
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
