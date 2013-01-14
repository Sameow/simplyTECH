package simplyTECH.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;
import simplyTECH.entity.*;

public class CheckLoginDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static boolean createCheckLogin(String username, int id, String idTi) throws SQLException{
				
		boolean success = false;
		DBController db = new DBController();
		
		String dbQuery;	
		db.getConnection();		

		dbQuery = "INSERT INTO checkLogin (Username,ID,IdTi) VALUES ('"+username+"','"+id+"','"+idTi+"')";
				
	    if (db.updateRequest(dbQuery) == 1){
	        success = true;
	    }
		db.terminate();
		return success;
	}

	
	public static CheckLogin searchByIdTi(String idTi){
		CheckLogin cl = null;
		Statement stmt = null;
        String searchQuery = "select * from checklogin where idti ='"
                + idTi + "'";
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("LOLZ member with the ID = " + idTi + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
                String username = rs.getString("username");
                int Id = rs.getInt("ID");
                cl = new CheckLogin();
                cl.setId(Id);
                cl.setUsername(username);           
                }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return cl;
	}
	
	public static boolean delete(String idTi) throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();

		dbQuery = "DELETE FROM checklogin WHERE IdTi = '"+idTi+"'";

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;

	}
	
}
