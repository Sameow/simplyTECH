package simplyTECH.DatabaseStatements;

import java.sql.ResultSet;

public class UseDataBaseController {
	public static void main(String args[]){
		viewAllFriends();
	}
	
	public static void viewAllFriends(){
		
		DBController db=new DBController(); // create a DBController object
		
		db.getConnection();  // setup the connection
		String sql="Select * from person"; // prepare sql statement
		ResultSet rset=db.readRequest(sql); // call to execute the database query
		
		try { // process the result return
			while (rset.next()){
				int id=rset.getInt("ID");
				String name= rset.getString("name");
				String gender=rset.getString("gender");
				String NRIC=rset.getString("NRIC");
				String username=rset.getString("username");
				String password=rset.getString("password");
				String mobile=rset.getString("mobile");
				String address=rset.getString("address");
				String email=rset.getString("email");
				System.out.printf("%-10s %-15s %-10s %-25s %-25s %-15s %-10s %-40s %-65s%n",id,name,gender,NRIC,username,password,mobile,address,email);		
			}
		} catch (Exception e){
			System.out.println("Error reading from database");
		}
	}
	public static void insertFriend() throws Exception{
		DBController dbc = new DBController();
		dbc.updateRequest();
	}
	
	
}