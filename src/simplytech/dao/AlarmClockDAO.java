package simplytech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
import simplytech.entity.AlarmClock;

public class AlarmClockDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static AlarmClock searchByUsername(String name, int id) {

		AlarmClock alarmClock = null;
		Statement stmt = null;
		String searchQuery = "select * from alarmclock where username ='"
				+ name + "'and id = '" + id + "'";

		try {
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				System.out.println("member with the username = " + name
						+ " does not exist. ");
			} else if (more) {
				int id2 = rs.getInt("id");
				String username = rs.getString("username");
				int hour = rs.getInt("hour");
				int minute = rs.getInt("minute");

				alarmClock = new AlarmClock();
				alarmClock.setId(id2);
				alarmClock.setUsername(username);
				alarmClock.setHour(hour);
				alarmClock.setMinute(minute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarmClock;
	}

	public static AlarmClock searchById(int id) {

		AlarmClock alarmClock = null;
		Statement stmt = null;
		String searchQuery = "select * from alarmclock where id = " + id;

		try {
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				System.out.println("member with the id = " + id
						+ " does not exist. ");
			} else if (more) {
				int id2 = rs.getInt("id");
				String username = rs.getString("username");
				int hour = rs.getInt("hour");
				int minute = rs.getInt("minute");

				alarmClock = new AlarmClock();
				alarmClock.setId(id2);
				alarmClock.setUsername(username);
				alarmClock.setHour(hour);
				alarmClock.setMinute(minute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarmClock;
	}

	public static int getMax() throws SQLException {
		int count = 0;
		Statement stmt = null;
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:8888/simplytech", "simplyTECH",
				"hahaudie");
		stmt = con.createStatement();
		String query = "SELECT MAX(AlarmClockID) FROM alarmclock";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			count = rs.getInt("MAX(AlarmClockID)");
		}
		return count;
	}

	public static void save(simplytech.entity.AlarmClock alarm) {

		Statement stmt = null;

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// query for inserting into the table
			String query = "insert into alarmclock(hour,minute,username,id) values(?,?,?,?)";
			pstmt = currentCon.prepareStatement(query);

			// inserting values
			pstmt.setInt(1, alarm.getHour());
			pstmt.setInt(2, alarm.getMinute());
			pstmt.setString(3, alarm.getUsername());
			pstmt.setInt(4, alarm.getId());
			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out.println("Set Alarm fail: An Exception has occurred! "
					+ ex);
		}

		// exception handling
		finally {
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

	}

	public static void removeByUserName(String username) {
		Statement stmt = null;
		String un = username;

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// query for inserting into the table
			String query = "delete from alarmclock where username = " + un;

			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out.println("Set Alarm fail: An Exception has occurred! "
					+ ex);
		}

		// exception handling
		finally {
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

	}
}
