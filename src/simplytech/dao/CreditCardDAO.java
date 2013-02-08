package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.CreditCard;

public class CreditCardDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static boolean createCreditCard(CreditCard cc) throws SQLException {
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
		String cardNumber = cc.getCardNumber();
		int expiryMonth = cc.getExpiryMonth();
		int expiryYear = cc.getExpiryYear();
		String expiryDate = cc.getExpiryDate();
		String cardHolderName = cc.getCardHolderName();
		String country = cc.getCountry();
		int CVC = cc.getCVC();
		String streetAddress = cc.getStreetAddress();
		String cardType = cc.getCardType();

		boolean success = false;
		DBController db = new DBController();

		String dbQuery = "INSERT INTO creditcard (ID,CardNumber,ExpiryMonth,ExpiryYear,ExpiryDate,CardHolderName,Country,"
				+ "CVC,StreetAddress,CardType) VALUES ('"
				+ id
				+ "','"
				+ cardNumber
				+ "','"
				+ expiryMonth
				+ "','"
				+ expiryYear
				+ "','"
				+ expiryDate
				+ "','"
				+ cardHolderName
				+ "','"
				+ country
				+ "','"
				+ CVC + "','" + streetAddress + "','" + cardType + "')";
		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			stmt = null;
		}

		if (currentCon != null) {
			try {
				currentCon.close();
			} catch (Exception e) {
			}

			currentCon = null;
		}
		return success;
	}

	public static CreditCard searchById(int Id) {
		// Person person = null;
		Statement stmt = null;
		CreditCard creditCard = null;
		String searchQuery = "select * from creditcard where ID ='" + Id + "' ";

		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("member with the ID = " + Id
						+ " does not exst");
			}

			// if user exists set the isValid variable to true
			else if (more) {

				int id = rs.getInt("id");
				String cardNumber = rs.getString("cardNumber");
				int expiryMonth = rs.getInt("expiryMonth");
				int expiryYear = rs.getInt("expiryYear");
				String expiryDate = rs.getString("expiryDate");
				String cardHolderName = rs.getString("cardHolderName");
				String country = rs.getString("country");
				int CVC = rs.getInt("CVC");
				String streetAddress = rs.getString("streetAddress");
				String cardType = rs.getString("cardType");

				creditCard = new CreditCard();
				creditCard.setId(id);
				creditCard.setCardNumber(cardNumber);
				creditCard.setExpiryMonth(expiryMonth);
				creditCard.setExpiryYear(expiryYear);
				creditCard.setExpiryDate(expiryDate);
				creditCard.setCountry(country);
				creditCard.setCVC(CVC);
				creditCard.setStreetAddress(streetAddress);
				creditCard.setCardType(cardType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return creditCard;
	}

	public static boolean updateCreditCard(CreditCard cc, int ID)
			throws SQLException {
		String cardNumber = cc.getCardNumber();
		int expiryMonth = cc.getExpiryMonth();
		int expiryYear = cc.getExpiryYear();
		String expiryDate = cc.getExpiryDate();
		String cardHolderName = cc.getCardHolderName();
		String country = cc.getCountry();
		int CVC = cc.getCVC();
		String streetAddress = cc.getStreetAddress();
		String cardType = cc.getCardType();
		boolean success = false;
		DBController db = new DBController();
		String dbQuery = "UPDATE creditcard set CardNumber = '" + cardNumber
				+ "'," + "ExpiryMonth='" + expiryMonth + "',ExpiryYear='"
				+ expiryYear + "'," + "ExpiryDate='" + expiryDate
				+ "',CardHolderName='" + cardHolderName + "'," + "Country='"
				+ country + "',CVC='" + CVC + "',StreetAddress='"
				+ streetAddress + "'," + "cardType='" + cardType
				+ "'WHERE ID = '" + ID + "'";
		db.getConnection();

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}
		db.terminate();
		return success;
	}
}
