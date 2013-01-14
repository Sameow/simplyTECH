package simplyTECH.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplyTECH.entity.Person;
import simplyTECH.DatabaseStatements.DBConnectionManager;
import simplyTECH.dao.DBController;

public class PersonDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static int getMax() throws SQLException{
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
			return id;
	}
	
	public static boolean createPerson(Person person) throws SQLException{
		int id = 0;
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM person";
		ResultSet rs =stmt.executeQuery(query);
		while(rs.next()){
	         id = rs.getInt("MAX(ID)") + 1;
	       }
		String name = person.getName();
		String gender = person.getGender();
		String NRIC = person.getNRIC();
		String username = person.getUsername();
		String password = person.getPassword();
		String mobile = person.getMobile();
		String address = person.getAddress();
		String email = person.getEmail();
		String userType = person.getUserType();
		
		boolean success = false;
		DBController db = new DBController();
		
		String dbQuery;	
		db.getConnection();		

		dbQuery = "INSERT INTO person (ID,Name,Gender,NRIC,Username,Password,Mobile,Address,Email,UserType) VALUES ('"+id+"','"+name+"','"+gender+"','"+NRIC+"','"+username+"','"+password+"','"+mobile+"','"+address+"','"+email+"','"+userType+"')";
				
	    if (db.updateRequest(dbQuery) == 1){
	        success = true;
	    }
		db.terminate();
		return success;
	}
	
	public static Person searchByUsername(String uname) {
		Person person = null;
		Statement stmt = null;
        String searchQuery = "select * from person where username ='"
                + uname + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the username = " + uname + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String NRIC = rs.getString("NRIC");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobile = rs.getString("mobile");
                String address= rs.getString("address");
                String email = rs.getString("email");
                person = new Person();
                person.setId(id);
                person.setName(name);
                System.out.print("Name is set");
                System.out.print(name);
                System.out.print(username);
                person.setGender(gender);
                person.setNRIC(NRIC);
                person.setUsername(username);
                person.setPassword(password);
                person.setMobile(mobile);
                person.setAddress(address);
                person.setEmail(email);
                person.setPassword(password);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  person;
	}

	public static Person searchById(int Id) {
		String Idd;
		Idd = Id + "";
		Person person = null;
		Statement stmt = null;
        String searchQuery = "select * from person where ID ='"
                + Idd + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("Member with the ID = " + Id + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String NRIC = rs.getString("NRIC");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobile = rs.getString("mobile");
                String address= rs.getString("address");
                String email = rs.getString("email");
                person = new Person();
                person.setId(id);
                person.setName(name);
                person.setGender(gender);
                person.setNRIC(NRIC);
                person.setUsername(username);
                person.setPassword(password);
                person.setMobile(mobile);
                person.setAddress(address);
                person.setEmail(email);
                person.setPassword(password);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  person;
	}
	
	public static boolean deleteLatest() throws SQLException{
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
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();

		dbQuery = "DELETE FROM person WHERE ID = " + id; 

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;
	}
	
	public static boolean updatePersonPassword(String password, String username) throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Password = '"+password+"' WHERE Username = '"+username+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;

	}
	
	public static boolean updateUsername(String username, String ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Username = '"+username+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;


	}
	public static boolean updatePassword(String password, String ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Password = '"+password+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

	public static boolean updateMobile(String mobile, String ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Mobile = '"+mobile+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

	public static boolean updateEmail(String email, String ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Email = '"+email+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

	public static boolean updateAddress(String address, String ID) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Address = '"+address+"' WHERE ID = '"+ID+"'";	
		db.getConnection();	

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}

}
