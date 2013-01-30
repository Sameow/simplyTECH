package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import simplytech.dao.DBController;
import simplytech.entity.Staff;

public class StaffManagementDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
//	public static int getNoOfRecords() throws SQLException{
//		int totalNoOfStaff = 0;
//		Statement stmt = null;
//		Connection con=null;
//		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
//		stmt = con.createStatement();
//		String query = "SELECT COUNT(*) AS NumberOfstaff FROM staffdetails";
//		ResultSet rs =stmt.executeQuery(query);
//		System.out.println("Error here?");
//		while(rs.next()){
//	         totalNoOfStaff = rs.getInt("COUNT(*)");
//	       }
//		System.out.println("totalNoOfStaff = "+totalNoOfStaff);
//			return totalNoOfStaff;
//	}
	
	public static boolean updateStaff(int idOfPersonUpdated, String changedUsername, String changedMobile, String changedGender, String changedPosition) {
			boolean success = false;
			DBController db = new DBController();
			String dbQuery = "UPDATE person,staffdetails SET person.Username='"+changedUsername+"', person.Mobile='"+changedMobile+"', person.Gender='"+changedGender+"', staffdetails.position='"+changedPosition+"' WHERE person.ID = staffdetails.ID AND person.ID= '"+idOfPersonUpdated+"'";
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
                String mobile=rs.getString("Mobile");
                //From staffdetails
                Staff staffdetails = StaffDAO.createById(id);
                String position=staffdetails.getPosition();
                Staff staff = new Staff();
                staff.setId(id);
                staff.setName(name);
                staff.setGender(gender);
              	staff.setUsername(username);
              	staff.setMobile(mobile);
              	staff.setPosition(position);
                staffList.add(staff);
            }
        } catch (Exception e) {
        	System.out.println("Cannot create array");
        }

		return  staffList;
	}
}
