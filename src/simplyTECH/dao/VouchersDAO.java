package simplyTECH.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;
import simplyTECH.entity.Vouchers;

public class VouchersDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	
	public static Vouchers searchByUsername(String uname, int id) {
		//Person person = null;
		Vouchers vouchers = null;
		Statement stmt = null;
        String searchQuery = "select * from vouchers where username ='"
                + uname + "'and id = '"+id+"' ";

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
            	int id2 = rs.getInt("id");
                String username = rs.getString("username");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String subtitle = rs.getString("subtitle");
                String details = rs.getString("details");
                //person = new Person();
                vouchers = new Vouchers();
                vouchers.setId(id2);
                vouchers.setUsername(username);
                vouchers.setImage(image);
                vouchers.setTitle(title);
                vouchers.setSubtitle(subtitle);
                vouchers.setDetails(details); 
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  vouchers;
	}
	
	public static Vouchers searchById(int id) {
		//Person person = null;
		Vouchers vouchers = null;
		Statement stmt = null;
        String searchQuery = "select * from vouchers where id = '"+id+"' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the id = " + id + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int id2 = rs.getInt("id");
                String username = rs.getString("username");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String subtitle = rs.getString("subtitle");
                String details = rs.getString("details");
                //person = new Person();
                vouchers = new Vouchers();
                vouchers.setId(id2);
                vouchers.setUsername(username);
                vouchers.setImage(image);
                vouchers.setTitle(title);
                vouchers.setSubtitle(subtitle);
                vouchers.setDetails(details); 
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  vouchers;
	}
	public static Vouchers searchById(int idTi,int id) {
		//Person person = null;
		Vouchers vouchers = null;
		Statement stmt = null;
		String searchQuery = "select * from vouchers where ID ='"
                + idTi + "'and VouchersID = '"+id+"' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the id = " + id + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int id2 = rs.getInt("id");
                String username = rs.getString("username");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String subtitle = rs.getString("subtitle");
                String details = rs.getString("details");
                //person = new Person();
                vouchers = new Vouchers();
                vouchers.setId(id2);
                vouchers.setUsername(username);
                vouchers.setImage(image);
                vouchers.setTitle(title);
                vouchers.setSubtitle(subtitle);
                vouchers.setDetails(details); 
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  vouchers;
	}

	public static int getMax() throws SQLException{
		int count = 0;
		Statement stmt = null;
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
    	stmt = con.createStatement();
    	String query = "SELECT MAX(VouchersID) FROM vouchers";
    	ResultSet rs =stmt.executeQuery(query);
    	while(rs.next()){
             count = rs.getInt("MAX(VouchersID)");
           }
        return count;
	}
}
