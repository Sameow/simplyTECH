package simplyTECH.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import simplyTECH.DatabaseStatements.DBConnectionManager;
import simplyTECH.entity.CustomerDetails;
import simplyTECH.entity.Person;

public class CustomerDetailsDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static boolean createCustomer(CustomerDetails customer) throws SQLException{
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
		
		dbQuery = "INSERT INTO customerdetails (ID,ExtraCharges,Stay,Membership,Checkout,Points,DoNotDisturb,Alarm)" +
				" VALUES ('"+id+"','"+extraCharges+"','"+stay+"','"+membership+"','"+checkout+"','"+points+"'," +
						"'"+doNotDisturb+"','"+alarm+"')";
		
		if(db.updateRequest(dbQuery) == 1){
			success = true;
		}
		db.terminate();
		return success;
	}
	public static CustomerDetails searchByUsername(String uname) {
		//System.out.println("NAME IS:"+uname);
		CustomerDetails cd = null;
		Statement stmt = null;
        String searchQuery = "SELECT * FROM customerdetails, person WHERE customerdetails.username ='"
                + uname + "' AND person.username = '"+uname+"'";
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            //
            
            stmt.addBatch(searchQuery);
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the username = " + uname + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more==true) {
            	//int ID = rs.getInt("Id");
            	String loginName = rs.getString("username");
            	double extraCharges = rs.getDouble("extraCharges");
            	int stay = rs.getInt("stay");
            	String membership = rs.getString("membership");
            	String checkOut = rs.getString("checkOut");
            	int points = rs.getInt("points");
            	int doNotDisturb = rs.getInt("doNotDisturb");
            	String alarm = rs.getString("alarm");
            	System.out.println("AAA" + membership);
            	cd = new CustomerDetails();
            	cd.setLoginName(loginName);
            	cd.setExtraCharges(extraCharges);
            	cd.setMembership(membership);
            	cd.setCheckOut(checkOut);
            	cd.setPoints(points);
            	cd.setDoNotDisturb(doNotDisturb);
            	cd.setAlarm(alarm);
            	String name = rs.getString("name");
                String gender = rs.getString("gender");
                String NRIC = rs.getString("NRIC");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobile = rs.getString("mobile");
                String address= rs.getString("address");
                String email = rs.getString("email");
                System.out.print("Name is set");
                System.out.print(name);
                System.out.print(username);
                cd.setName(name);
                cd.setGender(gender);
                cd.setNRIC(NRIC);
                cd.setUsername(username);
                cd.setPassword(password);
                cd.setMobile(mobile);
                cd.setAddress(address);
                cd.setEmail(email);
                cd.setPassword(password);
                System.out.println("WHAT YOU WANT: " + name);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return cd;
	}
	
	public static CustomerDetails searchById(int Id) {
		CustomerDetails cd = null;
		Statement stmt = null;
		 String searchQuery = "SELECT * FROM customerdetails, person WHERE customerdetails.ID ='"
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
            	double extraCharges = rs.getDouble("extraCharges");
            	int stay = rs.getInt("stay");
            	String membership = rs.getString("membership");
            	String checkOut = rs.getString("checkOut");
            	int points = rs.getInt("points");
            	int doNotDisturb = rs.getInt("doNotDisturb");
            	String alarm = rs.getString("alarm");
            	cd = new CustomerDetails();
            	cd.setId(ID);
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
                cd.setName(name);
                cd.setGender(gender);
                cd.setNRIC(NRIC);
                cd.setUsername(username);
                cd.setPassword(password);
                cd.setMobile(mobile);
                cd.setAddress(address);
                cd.setEmail(email);
                cd.setPassword(password);
            
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return cd;
	}	

	public static boolean updateDND(int dnd, int ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET DoNotDisturb = '"+dnd+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

}
