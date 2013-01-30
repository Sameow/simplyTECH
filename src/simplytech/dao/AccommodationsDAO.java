package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.AccommodationsEntity;

public class AccommodationsDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static AccommodationsEntity searchById(String iD) {
		AccommodationsEntity accoHuman = null;
		Statement stmt = null;
		String searchQuery = "select * from accommodations where ID ='" + iD + "'";
		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist then set the isValid variable to false
			if (!more) {
				System.out.println("member with the username =" + iD
						+ "does not exist");
			}
			// if user exists set the isValid variable to truee
			else if (more) {
				int id = rs.getInt("id");
				String accoSuite = rs.getString("Suite");
				int accoDay = rs.getInt("Day");
				int accoRoom = rs.getInt("Room");
				double accoPrice = new Double(rs.getString("Price"));
				String accoCheckOut = rs.getString("Checkout");
				accoHuman = new AccommodationsEntity();
				accoHuman.setAccoDay(accoDay);
				accoHuman.setAccoPrice(accoPrice);
				accoHuman.setAccoRoom(accoRoom);
				accoHuman.setAccoSuite(accoSuite);
				accoHuman.setAccoCheckOut(accoCheckOut);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accoHuman;
	}

	public static void createAccommodation(AccommodationsEntity accommodation)
			throws SQLException {
		DBController db = new DBController();
		db.updateRequest("INSERT INTO accommodations (id, Suite, Price, Room, CheckOut, Day, RoomNumber) VALUES('"
				+ accommodation.getId()
				+ "','"
				+ accommodation.getAccoSuite()
				+ "','"
				+ accommodation.getAccoPrice()
				+ "','"
				+ accommodation.getAccoRoom()
				+ "','"
				+ accommodation.getAccoCheckOut()
				+ "','"
				+ accommodation.getAccoDay()
				+ "','"
				+ accommodation.getAccoRoomNumber() + "')");
	}

	public static int getMax() throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(id) FROM accommodations";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(id)");
		}
		return count;
	}

}
