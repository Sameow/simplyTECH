package simplyTECH.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;
import simplyTECH.entity.Announcement;


public class AnnouncementDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static int maxID() throws SQLException{
		int count = 0;
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM announcement";
		ResultSet rs =stmt.executeQuery(query);
		while(rs.next()){
	         count = rs.getInt("MAX(ID)");
	       }
		return count;
	}

	public static Announcement searchByIdTi(int idTi) {
		//Person person = null;
		Announcement announcement = null;
		Statement stmt = null;
        String searchQuery = "select * from announcement where ID ='"
                + idTi + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the ID = " + idTi + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	String image = rs.getString("image");
            	String title = rs.getString("title");
            	String details = rs.getString("details");
            	String type = rs.getString("type");
            	announcement = new Announcement();
            	announcement.setType(type);
            	announcement.setImage(image);
            	announcement.setTitle(title);
            	announcement.setDetails(details);
            	
            	}
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  announcement;
	}
	

}
