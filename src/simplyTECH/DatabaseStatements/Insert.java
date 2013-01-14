package simplyTECH.DatabaseStatements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Insert {
	public static void main(String args[]) throws Exception{
		Connection con=null;
		Statement stmt=null;
		
		try {
			// step 1
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
					
			// step 2
			stmt=con.createStatement();
			String sqlStr;
			int returnCode;
			
			// step 3
			sqlStr="insert into person (id,name,NRIC,username,password,mobile,address,email) values (2,'Bei Ri Ber','s1234567a','brb','hahaudie','81234567','180 Ang Mo Kio Ave 8 Singapore 56789','hahaudie@hotmail.com')";
			returnCode=stmt.executeUpdate(sqlStr);
			
			// step 4
			System.out.println(returnCode+" row(s) inserted");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		} finally {
			// step 5
			if (stmt!=null) stmt.close();
			if (con!=null) con.close();
		}
	}
}