package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.entity.Person;
import simplytech.databasestatements.DBConnectionManager;
import simplytech.dao.DBController;

public class PersonDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static int getMax() throws SQLException {
		int id = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM person";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			id = rs.getInt("MAX(ID)");
		}
		return id;
	}

	public static boolean createPerson(Person person) throws SQLException {
		int id = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(ID) FROM person";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			id = rs.getInt("MAX(ID)") + 1;
		}
		String name = person.getName();
		String gender = person.getGender();
		String NRIC = person.getNRIC();
		String username = person.getUsername();
		String password = person.getPassword();
		String mobile = person.getMobile();
		String address = person.getAddress();
		String email = person.getEmail();
		String userType = person.getUserType();

		boolean success = false;
		DBController db = new DBController();

		String dbQuery;
		db.getConnection();

		dbQuery = "INSERT INTO person (ID,Name,Gender,NRIC,Username,Password,Mobile,Address,Email,UserType) VALUES ('"
				+ id
				+ "','"
				+ name
				+ "','"
				+ gender
				+ "','"
				+ NRIC
				+ "','"
				+ username
				+ "','"
				+ password
				+ "','"
				+ mobile
				+ "','"
				+ address + "','" + email + "','" + userType + "')";

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}

	public static Person searchByUsername(String uname) {
		Person person = null;
		Statement stmt = null;
		String searchQuery = "select * from person where username ='" + uname
				+ "' ";

		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("member with the username = " + uname
						+ " does not exst");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String NRIC = rs.getString("NRIC");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String email = rs.getString("email");
				person = new Person();
				person.setId(id);
				person.setName(name);
				person.setGender(gender);
				person.setNRIC(NRIC);
				person.setUsername(username);
				person.setPassword(password);
				person.setMobile(mobile);
				person.setAddress(address);
				person.setEmail(email);
				person.setPassword(password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return person;
	}
	
	public static boolean updatePerson(Person person, String ID) throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET Username = '" + person.getUsername()
				+ "', password = '" + person.getPassword() + "', mobile = '" + person.getMobile()
				+ "', email = '" + person.getEmail() + "', address = '"+person.getAddress()+"' WHERE ID = '" + ID + "'";

		db.getConnection();

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}

	public static boolean updatePersonPassword(String inputPassword,
			String username) throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE person SET password = '" + inputPassword + "' WHERE username = '" + username + "'";

		db.getConnection();

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}

}
