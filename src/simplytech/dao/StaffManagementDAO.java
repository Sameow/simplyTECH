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
import simplytech.entity.Staff;

public class StaffManagementDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	public static boolean updateStaff(int idOfPersonUpdated, String changedEmail, String changedMobile, String changedGender, String changedPosition, String changedPassword) {
			boolean success = false;
			DBController db = new DBController();
			String dbQuery = "UPDATE person SET Email='"+changedEmail+"', Mobile='"+changedMobile+"', Gender='"+changedGender+"', Password='"+changedPassword+"' WHERE ID= '"+idOfPersonUpdated+"'";
			db.getConnection();	
			try {
				if (updateStaffTable(idOfPersonUpdated, changedPosition)) {
				if (db.updateRequest(dbQuery) == 1){
				        success = true;
					}
				}
			} catch (SQLException e) {
				System.out.println(e);
			} 
			db.terminate();
			return success;
	}
	private static boolean updateStaffTable(int idOfPersonUpdated, String changedPosition) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE staffdetails SET position='"+changedPosition+"' WHERE ID= '"+idOfPersonUpdated+"'";
		db.getConnection();	
		try {
			if (db.updateRequest(dbQuery) == 1){
			        success = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} 
		db.terminate();
		return success;
	}
	public static ArrayList<Staff> retrieveAll() throws SQLException{
		Statement stmt = null;
		Connection con=null;
		String staffForSQL = "Staff";
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt = con.createStatement();
        String searchQuery = "select * from person where person.UserType='"+staffForSQL+"'";
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        try {
            // connect to DB
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            	//From Person
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                String username = rs.getString("Username");
                String password=rs.getString("Password");
                String mobile=rs.getString("Mobile");
                String email=rs.getString("Email");
                //From staffdetails
                Staff staffdetails = StaffDAO.createById(id);
                String position=staffdetails.getPosition();
                
                Staff staff = new Staff();
                staff.setId(id);
                staff.setName(name);
                staff.setGender(gender);
              	staff.setUsername(username);
              	staff.setPassword(password);
              	staff.setMobile(mobile);
              	staff.setEmail(email);
              	staff.setPosition(position);
                staffList.add(staff);
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
		return  staffList;
	}
	public static boolean createStaff(String newName, String newGender, String newUsername, String newPassword, String newMobile, String newEmail,  String newPosition, String newWorkingSince) {
		
		Statement stmt = null;
		
		// get the last member ID 
		try {	
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String getMax = "select Max(ID) from person";
			//String getMax = "select Max(member_id) from person";
			rs1 = stmt.executeQuery(getMax);
			rs1.next();
			int maxId = rs1.getInt(1);
			System.out.println(maxId);
			int nextId = maxId + 1;
			
			DBController db = new DBController();
			String dbQuery = "INSERT INTO person (ID, Name, Gender,Username,Password,Mobile,Address,Email,UserType)" +
					" VALUES ('"+nextId+"','"+newName+"','"+newGender+"','"+newUsername+"','"+newPassword+"','"+newMobile+"','"+"Not required"+"','"+newEmail+"','"+"Staff"+"')";
			
			if(db.updateRequest(dbQuery) == 1){
				if(createStaffInStaffDBTable(nextId, newPosition, newWorkingSince)) {
				return true;
				}
				else {
					System.out.println("Fail to update in staffdetails");
					return false;
				}			
			}
			else {
				System.out.println("1st update failed");
				db.terminate();
				return false;
			}
			
		} catch (Exception ex) {
			System.out.println("Registration failed: An Exception has occurred! "
					+ ex);
			return false;
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
	private static boolean createStaffInStaffDBTable(int nextId, String newPosition, String newWorkingSince) {
		DBController db = new DBController();
		String dbQuery = "INSERT INTO staffdetails (ID, workingSince, position)" +
				" VALUES ('"+nextId+"','"+newWorkingSince+"','"+newPosition+"')";
		
		try {
			if(db.updateRequest(dbQuery) == 1){
				return true;
			}
			else {
				db.terminate();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			db.terminate();
			return false;
		}
	}
	
	public static boolean deleteStaff(int id) {
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
