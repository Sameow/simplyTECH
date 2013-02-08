package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.RoomServices;

public class RoomServiceDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static RoomServices searchByUsername(String name, int id) {

		RoomServices roomService = null;
		Statement stmt = null;
		String searchQuery = "select * from roomservices where username ='"
				+ name + "'and id = '" + id + "'";
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
				String service = rs.getString("service");
				int roomServicesID = rs.getInt(getMax());

				roomService = new RoomServices();
				roomService.setId(id2);
				roomService.setUsername(username);
				roomService.setService(service);
				roomService.setRoomServicesID(roomServicesID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomService;
	}

	public static RoomServices searchById(int id) {

		RoomServices roomService = null;
		Statement stmt = null;
		String searchQuery = "select * from roomservices where id =" + id;

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
				String service = rs.getString("service");
				int roomServicesID = rs.getInt(getMax());

				roomService = new RoomServices();
				roomService.setId(id2);
				roomService.setUsername(username);
				roomService.setService(service);
				roomService.setRoomServicesID(roomServicesID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomService;
	}

	public static int getMax() throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(roomServicesID) FROM roomservices";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(roomServicesID)");
		}
		return count;
	}

	public static void save(simplytech.entity.RoomServices r) {

		Statement stmt = null;

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// query for inserting into the table
			String query = "insert into roomservices(service,username,id,roomServicesID) values(?,?,?,?)";
			pstmt = currentCon.prepareStatement(query);

			// inserting values
			pstmt.setString(1, r.getService());
			pstmt.setString(2, r.getUsername());
			pstmt.setInt(3, r.getId());
			pstmt.setInt(4, r.getRoomServicesID());
			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out
					.println("Booking of room services fail: An Exception has occurred! "
							+ ex);
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
