package simplytech.dao;

import java.sql.ResultSet;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.Announcement;
import simplytech.entity.CreditCard;
import simplytech.entity.CustomerVouchers;
import simplytech.entity.Vouchers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VouchersDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static Vouchers searchByType(String voucherType, int id){
		Statement stmt = null;
		Vouchers vouchers = null;
		String searchQuery = "SELECT * FROM vouchers WHERE type = '" + voucherType + "' AND ID = '"+id+"'";
		
		try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            // if user does not exist set the isValid variable to false
            if (!more) {
            //  System.out.println("voucher with the type = " + voucherType + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	
            	int vouchersId = rs.getInt("id");
            	String type = rs.getString("type");
            	String title = rs.getString("title");
            	String subtitle = rs.getString("subtitle");
            	String details = rs.getString("details");
            	String image = rs.getString("image");
            	int pointsRequired = rs.getInt("pointsRequired");
            	vouchers = new Vouchers();
            	vouchers.setTitle(type);
            	vouchers.setTitle(title);
            	vouchers.setSubtitle(subtitle);
            	vouchers.setDetails(details);
            	vouchers.setImage(image);
            	vouchers.setPointsRequired(pointsRequired);
     	
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return vouchers;
	}
	
	public static int getMax(String voucherType) throws SQLException{
		int count = 0;
		Statement stmt = null;
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
    	stmt = con.createStatement();
    	String query = "SELECT MAX(ID) FROM vouchers where type = '"+voucherType+"'";
    	ResultSet rs =stmt.executeQuery(query);
    	while(rs.next()){
             count = rs.getInt("MAX(ID)");
           }
        return count;
	}
	
	public static int getMin(String voucherType) throws SQLException{
		int count = 0;
		Statement stmt = null;
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
    	stmt = con.createStatement();
    	String query = "SELECT MIN(ID) FROM vouchers where type = '"+voucherType+"'";
    	ResultSet rs =stmt.executeQuery(query);
    	while(rs.next()){
             count = rs.getInt("MIN(ID)");
           }
        return count;
	}
	
	public static ArrayList<Vouchers> retrieveAll(String type) {
		Vouchers voucher = null;
		Statement stmt = null;
        String searchQuery = "select * from vouchers where type = '"+type+"'";
        ArrayList<Vouchers> voucherList = new ArrayList<Vouchers>();
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
        	while (rs.next()) {
        		int id = rs.getInt("id");
        		String type1 = rs.getString("type");
            	String title = rs.getString("title");
            	String subtitle = rs.getString("subtitle");
            	String details = rs.getString("details");
            	String image = rs.getString("image");
            	int pointsRequired = rs.getInt("pointsRequired");
            	voucher = new Vouchers();
            	voucher.setId(id);
            	voucher.setType(type1);
            	voucher.setTitle(title);
            	voucher.setSubtitle(subtitle);
            	voucher.setDetails(details);
            	voucher.setImage(image);
            	voucher.setPointsRequired(pointsRequired);
            	voucherList.add(voucher);
            	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return  voucherList;
	}

	public static Vouchers searchByType(String type) {
		//Person person = null;
		Vouchers voucher = null;
		Statement stmt = null;
        String searchQuery = "select * from voucher where type ='"
                + type + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("voucher does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
            	int id = rs.getInt("id");
        		String type1 = rs.getString("type");
            	String title = rs.getString("title");
            	String subtitle = rs.getString("subtitle");
            	String details = rs.getString("details");
            	String image = rs.getString("image");
            	int pointsRequired = rs.getInt("pointsRequired");
            	voucher = new Vouchers();
            	voucher.setId(id);
            	voucher.setType(type1);
            	voucher.setTitle(title);
            	voucher.setSubtitle(subtitle);
            	voucher.setDetails(details);
            	voucher.setImage(image);
            	voucher.setPointsRequired(pointsRequired);
            	
            	}
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  voucher;
	}

	public static void deleteVoucher(int i) throws SQLException{
		Statement stmt = null;
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:8888/simplytech","simplyTECH","hahaudie");
		String dbQuery = "DELETE FROM vouchers WHERE id = '"+i+"'";
		stmt=con.createStatement();
		stmt.executeUpdate(dbQuery);
	}
	
	public static boolean createVoucher(Vouchers voucher) throws SQLException {
		int id = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM vouchers";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			id = rs.getInt("MAX(ID)") + 1;
		}
		String type = voucher.getType();
		String image = voucher.getImage();
		String title = voucher.getTitle();
		String details = voucher.getDetails();
		String subtitle = voucher.getSubtitle();
		int pointsRequired = voucher.getPointsRequired();
		
		boolean success = false;
		DBController db = new DBController();

		String dbQuery;
		db.getConnection();

		dbQuery = "INSERT INTO vouchers (ID,type,image,title,subtitle,details, pointsRequired) VALUES ('"
				+ id
				+ "','"
				+ type
				+ "','"
				+ image
				+ "','"
				+ title
				+ "','"
				+ subtitle
				+ "','"
				+ details
				+ "','"
				+ pointsRequired
				+ "')";

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}


}
