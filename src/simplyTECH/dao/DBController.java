 package simplyTECH.dao;

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
