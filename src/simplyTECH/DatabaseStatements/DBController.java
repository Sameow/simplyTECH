 package simplyTECH.DatabaseStatements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class DBController {
	private Connection con;
	private String dbSource="//localhost:8888/simplytech";
	private String user="simplyTECH";	  // the username of the sql user
	private String password="hahaudie";  // your password of the sql user
	
	/********************************************************
	 * Method Name : testDriver
	 * Input Parameter : nil 
	 * Purpose : To test if the driver is properly installed
	 * Return :nil
	 *******************************************************/
	public static void testDriver() throws Exception { 
		System.out.println("Initializing Server... "); 
	try { 
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println(" Driver Found."); 
	} 
	catch (ClassNotFoundException e) { 
		System.out.println(" Driver Not Found, exiting.."); 
		throw (e); 
		} 
	} 

	public void getConnection(){ 
		String url = ""; 
		try { 
			url = "jdbc:mysql:"+dbSource; 
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Successfully connected to " + dbSource+ "."); 
		} 
		catch (java.sql.SQLException e) { 
			System.out.println("Connection failed ->"+ dbSource); 
			System.out.println(e); 
		} 
	} 
	
	/************************************************************
	 * Method Name : readRequest 
	 * Input Parameter : String (database query) 
	 * Purpose : Obtain the result set from the db query 
	 * Return : resultSet (records from the query)
	 ************************************************************/
	public ResultSet readRequest(String dbQuery) {
		ResultSet rs = null;
		System.out.println("DB Query: " + dbQuery);
		try {
			// create a statement object
			Statement stmt = con.createStatement();
			// execute an SQL query and get the result
			rs = stmt.executeQuery(dbQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	/********************************************************
	 * Method Name : updateRequest
	 * Input Parameter : nil 
	 * Purpose : To update the database
	 * Return :nil
	 *******************************************************/
	
	public void createFriend(){
		
	}
	public void updateRequest() throws Exception{
		Scanner sc = new Scanner(System.in);
		int choice;
		Statement stmt = null;
		String sqlStr;
		String name;
		int mobile;
		String username;
		String password;
		String email;
		String address;
		String newPhone;
		String phone;
		String NRIC;
		int returnCode;
		int id;
		int count = 0;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt=con.createStatement();
		System.out.println("Choose your actions: ");
		System.out.println("1 = Insert");		
		System.out.println("2 = Update");
		System.out.println("3 = Delete");
		choice = sc.nextInt();
		
		if (choice == 1){
			
			
			String query = "SELECT MAX(ID) FROM person";
			ResultSet rs =stmt.executeQuery(query);
			//int count1 = rs.getInt("SELECT MAX(ID) FROM person");
			//count = rs.getInt("MAX(ID)") + 1; 
			while(rs.next()){
               //  System.out.println("MAX(user_id)="+rs.getInt("MAX(ID)"));    
                 count = rs.getInt("MAX(ID)") + 1;
                // System.out.print(count);
               }
		//	System.out.print(rs.getInt("MAX(ID)"));
			//	System.out.print(count1);
			sc.nextLine();
			System.out.print("Enter the name \t\t: ");
			name = sc.nextLine();
			System.out.print("Enter the NRIC \t: ");
			NRIC = sc.nextLine();
			System.out.print("Enter the username \t: ");
			username = sc.nextLine();
			System.out.print("Enter the password \t: ");
			password = sc.nextLine();
			System.out.print("Enter your address \t: ");
			address = sc.nextLine();
			System.out.print("Enter the email \t: ");
			email = sc.nextLine();
			System.out.print("Enter the mobile \t: ");
			mobile = sc.nextInt();
			
			//sqlStr = "insert into friends (id,Fname,phone,address) values ('32','kz','91234567','amk')";
			sqlStr="insert into person (ID,Name,NRIC,Username,Password,Mobile,Address,Email) values ('"+count+"','"+name+"','"+NRIC+"','"+username+"','"+password+"','"+mobile+"','"+address+"','"+email+"')";
			returnCode=stmt.executeUpdate(sqlStr);
			if (returnCode > 0)
				System.out.print("SUCCESS!");
			else
				System.out.print("FAILED!");
		}
		else if (choice == 2){
			int number = 0;
			System.out.print("Enter phone number: ");
			number = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter new number: ");
			newPhone = sc.nextLine();
			try
			{
			sqlStr = "UPDATE person SET Mobile='"+newPhone+"' WHERE Mobile='"+number+"'";
			returnCode=stmt.executeUpdate(sqlStr);
			if(returnCode > 0)
				System.out.print("UPDATED!");
			else
				System.out.print("FAILED!");
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		else if (choice == 3){
			
			System.out.print("Enter phone number to delete: ");
			sc.nextLine();
			phone = sc.nextLine();
			sqlStr="DELETE FROM person WHERE Mobile='"+phone+"'";
			returnCode=stmt.executeUpdate(sqlStr);
			if (returnCode > 0)
				System.out.print("DELETED!");
			else
				System.out.print("FAILED!");
		}
		
	}
	
	/***********************************************************
	 * Method Name : terminate 
	 * Input Parameter : nil 
	 * Purpose : Close db conection 
	 * Return :nil
	 **********************************************************/
	public void terminate() {
		// close connection
		try {
			con.close();
			System.out.println("Connection is closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updateRequest(String dbQuery) throws SQLException {
		int returnCode;
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt=con.createStatement();
		returnCode=stmt.executeUpdate(dbQuery);
		return returnCode;
	}
}
