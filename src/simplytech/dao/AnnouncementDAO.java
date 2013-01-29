package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Announcement;


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

	public static Announcement searchById(int id) {
		//Person person = null;
		Announcement announcement = null;
		Statement stmt = null;
        String searchQuery = "select * from announcement where ID ='"
                + id + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the ID = " + id + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int id1 = rs.getInt("id");
            	String image = rs.getString("image");
            	String title = rs.getString("title");
            	String details = rs.getString("details");
            	String type = rs.getString("type");
            	announcement = new Announcement();
            	announcement.setId(id1);
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

	public static int getCount(String type) throws SQLException {
		int count = 0;
		Statement stmt = null;
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
    	stmt = con.createStatement();
    	String query = "SELECT COUNT(type) FROM announcement WHERE type = '"+type+"'";
    	ResultSet rs =stmt.executeQuery(query);
    	while(rs.next()){
             count = rs.getInt("COUNT(type)");
           }
        return count;
	}
	
	public static int getMax(String type) throws SQLException{
		int count = 0;
		Statement stmt = null;
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
    	stmt = con.createStatement();
    	String query = "SELECT MAX(ID) FROM announcement WHERE type = '"+type+"'";
    	ResultSet rs =stmt.executeQuery(query);
    	while(rs.next()){
             count = rs.getInt("MAX(ID)");
           }
        return count;
	}
	
	public static ArrayList<Announcement> retrieveAll(String type) {
		Announcement announcement = null;
		Statement stmt = null;
        String searchQuery = "select * from announcement where type = '"+type+"'";
        ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
        	while (rs.next()) {
        		int id = rs.getInt("id");
            	String title = rs.getString("title");
            	String details = rs.getString("details");
            	String image = rs.getString("image");
            	String announcementType = rs.getString("type");
            	announcement = new Announcement();
            	announcement.setId(id);
            	announcement.setDetails(details);
            	announcement.setTitle(title);
            	announcement.setImage(image);
            	announcement.setType(announcementType);
            	announcementList.add(announcement);
            	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return  announcementList;
	}

	public static void deleteAnnouncement(int i) throws SQLException{
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		String dbQuery = "DELETE FROM announcement WHERE id = '"+i+"'";
		stmt=con.createStatement();
		stmt.executeUpdate(dbQuery);
	}
	
	public static boolean createAnnouncement(Announcement announcement) throws SQLException {
		int id = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM announcement";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			id = rs.getInt("MAX(ID)") + 1;
		}
		String type = announcement.getType();
		String image = announcement.getImage();
		String title = announcement.getTitle();
		String details = announcement.getDetails();
		
		boolean success = false;
		DBController db = new DBController();

		String dbQuery;
		db.getConnection();

		dbQuery = "INSERT INTO announcement (ID,type,image,title,details) VALUES ('"
				+ id
				+ "','"
				+ type
				+ "','"
				+ image
				+ "','"
				+ title
				+ "','"
				+ details
				+ "')";

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}

}
