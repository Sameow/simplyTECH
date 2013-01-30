package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Customer;
import simplytech.entity.Person;

public class CustomerDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static boolean createCustomer(Customer customer) throws SQLException{
		int id = 0;
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM person";
		ResultSet rs =stmt.executeQuery(query);
		while(rs.next()){
	         id = rs.getInt("MAX(ID)");
	    }
		
		String roomNumber = customer.getRoomNumber();
		double extraCharges = customer.getExtraCharges();
		int stay = customer.getStay();
		String membership = customer.getMembership();
		String checkout = customer.getCheckOut();
		int points = customer.getPoints();
		int doNotDisturb = customer.getDoNotDisturb();
		String alarm = customer.getAlarm();
	
		boolean success = false;
		DBController db = new DBController();
		
		String dbQuery;
		db.getConnection();
		
		dbQuery = "INSERT INTO Customer (ID, RoomNumber, ExtraCharges,Stay,Membership,Checkout,Points,DoNotDisturb,Alarm)" +
				" VALUES ('"+id+"','"+roomNumber+"','"+extraCharges+"','"+stay+"','"+membership+"','"+checkout+"','"+points+"'," +
						"'"+doNotDisturb+"','"+alarm+"')";
		
		if(db.updateRequest(dbQuery) == 1){
			success = true;
		}
		db.terminate();
		return success;
	}
	
	public static Customer searchById(int Id) {
		Customer cd = null;
		Statement stmt = null;
		 String searchQuery = "SELECT * FROM Customer, person WHERE Customer.ID ='"
	                + Id + "' AND person.ID = '"+Id+"'";
	       
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the ID = " + Id + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int ID = rs.getInt("Id");
            	String loginName = rs.getString("username");
            	String roomNumber = rs.getString("roomNumber");
            	double extraCharges = rs.getDouble("extraCharges");
            	int stay = rs.getInt("stay");
            	String membership = rs.getString("membership");
            	String checkOut = rs.getString("checkOut");
            	int points = rs.getInt("points");
            	int doNotDisturb = rs.getInt("doNotDisturb");
            	String alarm = rs.getString("alarm");
            	cd = new Customer();
            	cd.setId(ID);
            	cd.setRoomNumber(roomNumber);
            	cd.setLoginName(loginName);
            	cd.setExtraCharges(extraCharges);
            	cd.setMembership(membership);
            	cd.setCheckOut(checkOut);
            	cd.setPoints(points);
            	cd.setDoNotDisturb(doNotDisturb);
            	cd.setAlarm(alarm);
            	//From Person
            	String name = rs.getString("name");
                String gender = rs.getString("gender");
                String NRIC = rs.getString("NRIC");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobile = rs.getString("mobile");
                String address= rs.getString("address");
                String email = rs.getString("email");
                String userType = rs.getString("userType");
                cd.setName(name);
                cd.setGender(gender);
                cd.setNRIC(NRIC);
                cd.setUsername(username);
                cd.setPassword(password);
                cd.setMobile(mobile);
                cd.setAddress(address);
                cd.setEmail(email);
                cd.setPassword(password);
                cd.setUserType(userType);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return cd;
	}	

	public static boolean updateDND(int dnd, int ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE customer SET DoNotDisturb = '"+dnd+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

	public static boolean updatePoints(int points, int id) throws SQLException{
		boolean success = false;
		String query = "UPDATE Customer SET Points = '"+points+"' WHERE ID = '"+id+"'";
		DBController db = new DBController();
		db.getConnection();
		if(db.updateRequest(query) == 1){
			success = true;
		}
		db.terminate();
		return success;
	}
	
	public static boolean updateCharges(double charges, int id) throws SQLException{
		boolean success = false;
		String query = "UPDATE Customer SET ExtraCharges = '"+charges+"' WHERE ID = '"+id+"'";
		DBController db = new DBController();
		db.getConnection();
		if(db.updateRequest(query) == 1){
			success = true;
		}
		db.terminate();
		return success;
	}
	
	public static Customer searchByRoomNumber(String roomNumber) {
		Customer cd = null;
		Statement stmt = null;
		 String searchQuery = "SELECT * FROM Customer WHERE RoomNumber ='"
	                + roomNumber + "'";
	       
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the roomNumber= " + roomNumber + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int ID = rs.getInt("Id");
            	String roomNumber1 = rs.getString("roomNumber");
            	double extraCharges = rs.getDouble("extraCharges");
            	int stay = rs.getInt("stay");
            	String membership = rs.getString("membership");
            	String checkOut = rs.getString("checkOut");
            	int points = rs.getInt("points");
            	int doNotDisturb = rs.getInt("doNotDisturb");
            	String alarm = rs.getString("alarm");
            	cd = new Customer();
            	cd.setId(ID);
            	cd.setRoomNumber(roomNumber1);
            	cd.setExtraCharges(extraCharges);
            	cd.setMembership(membership);
            	cd.setCheckOut(checkOut);
            	cd.setPoints(points);
            	cd.setDoNotDisturb(doNotDisturb);
            	cd.setAlarm(alarm);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return cd;
	}	
	
	public static boolean updateMembership(String membership, int id) throws SQLException{
		boolean success = false;
		String query = "UPDATE Customer SET membership = '"+membership+"' WHERE ID = '"+id+"'";
		DBController db = new DBController();
		db.getConnection();
		if(db.updateRequest(query) == 1){
			success = true;
		}
		db.terminate();
		return success;
	}

	
}
