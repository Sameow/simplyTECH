package simplyTECH.DatabaseStatements;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Read {
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
		
			
			// step 3
			sqlStr="select * from person";
			ResultSet rset=stmt.executeQuery(sqlStr);
			
			// step 4
			while (rset.next()){
				int id=rset.getInt("ID");
				String name= rset.getString("Name");
				String username=rset.getString("Username");
				String password=rset.getString("Password");
				String mobile=rset.getString("Mobile");
				String address=rset.getString("Address");
				String email=rset.getString("Email" +
						"");
				String NRIC = rset.getString("NRIC");
				System.out.printf("%-10s %-15s %15s %20s %30s %20s %40s %30s%n",id,name,NRIC,username, password, mobile, address, email);
			}
			
		} catch (SQLException ex){
			ex.printStackTrace();
		} finally {
			// step 5
			if (stmt!=null) stmt.close();
			if (con!=null) con.close();
		}
	}
}