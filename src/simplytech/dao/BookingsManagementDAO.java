package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import simplytech.dao.DBController;
import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Booking;
import simplytech.entity.Customer;
import simplytech.entity.Staff;

public class BookingsManagementDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	
	public static ArrayList<Booking> retrieveAllBooking() throws SQLException{
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt = con.createStatement();
        String searchQuery = "select * from booking";
        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        try {
            // connect to DB
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String title=rs.getString("title");
                
                Booking Booking = new Booking();
                Booking.setId(id);
                Booking.setUsername(username);
                Booking.setTitle(title);
                
                bookingList.add(Booking);
            }
        } catch (Exception e) {
        	System.out.println("Cannot create array");
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
		return  bookingList;
	}
	
	public static boolean deleteBooking(int id) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "DELETE FROM person WHERE ID ='" + id + "'";
		try {
			if (db.updateRequest(dbQuery) == 1) {
				if(deleteStaffDetails(id))
				success = true;
			}
		} catch (SQLException e) {
			System.out.println("Error in SQL queries");
			e.printStackTrace();
		}
		return success;
	}
	
	private static boolean deleteStaffDetails(int id) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "DELETE FROM staffdetails WHERE ID ='" + id + "'";
		try {
			if (db.updateRequest(dbQuery) == 1) {
				success = true;
			}
		} catch (SQLException e) {
			System.out.println("Error in secondary SQL query");
			e.printStackTrace();
		}
		return success;
	}
}
