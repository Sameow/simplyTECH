package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Announcement;
import simplytech.entity.CustomerVouchers;
import simplytech.entity.Person;

public class CustomerVouchersDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static boolean createVoucher(CustomerVouchers cv, int id,
			String username) throws SQLException {
		int vouchersID = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(VouchersID) FROM customervouchers WHERE id = '"
				+ id + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			vouchersID = rs.getInt("MAX(VouchersID)") + 1;
		}
		// String query2 =
		// "INSERT INTO vouchers (ID,Username, Image, Title, Subtitle, Details) values ('"+loginID+"','"+username+"','"+image+"','"+title+"','"+subtitle+"','"+details+"')";
		String title = cv.getTitle();
		String subtitle = cv.getSubtitle();
		String details = cv.getDetails();
		String image = cv.getImage();
		String expiryDate = cv.getExpiryDate();

		boolean success = false;
		DBController db = new DBController();

		String dbQuery;
		db.getConnection();

		dbQuery = "INSERT INTO customervouchers (ID, VouchersID, Image, Title, Subtitle, Details, ExpiryDate) values ('"
				+ id
				+ "','"
				+ vouchersID
				+ "','"
				+ image
				+ "','"
				+ title
				+ "','"
				+ subtitle
				+ "','"
				+ details
				+ "','"
				+ expiryDate + "')";

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}

	public static CustomerVouchers searchById(int id) {
		// Person person = null;
		CustomerVouchers vouchers = null;
		Statement stmt = null;
		String searchQuery = "select * from customervouchers where id = '" + id
				+ "' ";

		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("member with the id = " + id
						+ " does not exst");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				int id2 = rs.getInt("id");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String subtitle = rs.getString("subtitle");
				String details = rs.getString("details");
				String expiryDate = rs.getString("expiryDate");
				// person = new Person();
				vouchers = new CustomerVouchers();
				vouchers.setId(id2);
				vouchers.setImage(image);
				vouchers.setTitle(title);
				vouchers.setSubtitle(subtitle);
				vouchers.setDetails(details);
				vouchers.setExpiryDate(expiryDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return vouchers;
	}

	public static CustomerVouchers searchById(int idTi, int id) {
		// Person person = null;
		CustomerVouchers vouchers = null;
		Statement stmt = null;
		String searchQuery = "select * from customervouchers where ID ='"
				+ idTi + "'and VouchersID = '" + id + "' ";

		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("member with the id = " + id
						+ " does not exst");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				int id2 = rs.getInt("id");
				int vouchersId = rs.getInt("vouchersId");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String subtitle = rs.getString("subtitle");
				String details = rs.getString("details");
				String expiryDate = rs.getString("expiryDate");
				vouchers = new CustomerVouchers();
				vouchers.setVouchersId(vouchersId);
				vouchers.setId(id2);
				vouchers.setImage(image);
				vouchers.setTitle(title);
				vouchers.setSubtitle(subtitle);
				vouchers.setDetails(details);
				vouchers.setExpiryDate(expiryDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return vouchers;
	}

	public static int getMax(int id) throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(VouchersID) FROM customervouchers WHERE id = '"
				+ id + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(VouchersID)");
		}
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
		return count;
	}

	public static void deleteVoucher(int VouchersId) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		String dbQuery = "DELETE FROM customervouchers WHERE VouchersID = '"
				+ VouchersId + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(dbQuery);
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

	public static void deleteVoucher(String expiryDate) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		String dbQuery = "DELETE FROM customervouchers WHERE expiryDate = '"
				+ expiryDate + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(dbQuery);
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

	public static int getCount(int id) throws SQLException {
		// TODO Auto-generated method st
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT COUNT(id) FROM customervouchers";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("COUNT(id)");
		}
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

		return count;
	}

	public static ArrayList<CustomerVouchers> retrieveAll(int id) {
		CustomerVouchers vouchers = null;
		Statement stmt = null;
		String searchQuery = "select * from customervouchers where id = '" + id
				+ "'";
		ArrayList<CustomerVouchers> customerVouchersList = new ArrayList<CustomerVouchers>();
		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while (rs.next()) {
				int id2 = rs.getInt("id");
				int vouchersId = rs.getInt("vouchersId");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String subtitle = rs.getString("subtitle");
				String details = rs.getString("details");
				String expiryDate = rs.getString("expiryDate");
				vouchers = new CustomerVouchers();
				vouchers.setVouchersId(vouchersId);
				vouchers.setId(id2);
				vouchers.setImage(image);
				vouchers.setTitle(title);
				vouchers.setSubtitle(subtitle);
				vouchers.setDetails(details);
				vouchers.setExpiryDate(expiryDate);
				customerVouchersList.add(vouchers);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		return customerVouchersList;
	}

}
