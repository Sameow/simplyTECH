package simplyTECH.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;


public class CheckLogin {

	
	private String username;
	private int Id;
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	public CheckLogin(){
		
	}
	public CheckLogin(String username, int id) {
		super();
		this.username = username;
		Id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	/*public static CheckLogin searchByIdTi(String IdTi) {
		CheckLogin checkLogin = null;
		Statement stmt = null;
        String searchQuery = "select * from checklogin where IdTi ='"
                + IdTi + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("Invalid!");
            }

            // if user exists set the isValid variable to true
            else if (more) {
     
                int id = rs.getInt("ID");
                String username = rs.getString("Username");
                checkLogin = new CheckLogin();
                checkLogin.setId(id);
                checkLogin.setUsername(username);
                }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return checkLogin;
	}*/

}
