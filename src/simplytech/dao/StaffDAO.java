package simplytech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import simplytech.databasestatements.DBConnectionManager;
//import entity.Person;
import simplytech.entity.Staff;


public class StaffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static Staff createByUsername(String uname) {
		Staff staffWithParentAttribute = new Staff();
		Staff staffWithStaffAttribute= new Staff();
		//String staff = "Staff";
		Statement stmt = null;
        String searchQuery = "SELECT * FROM person WHERE Username='"
                + uname;

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
            	System.out.println("SQL Query did not work");
             return null;
            }

            // if user exists set the isValid variable to true
            else if (more) {
                int id = rs.getInt("id");
                //To get all other attributes unique to Staff that Person doesnt have. 
                staffWithStaffAttribute=createById(id);
                //Use this object to set non-inherited attributes
                String name = rs.getString("Name");
                String gender = rs.getString("gender");
                String NRIC = rs.getString("NRIC");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobile = rs.getString("mobile");
                String address= rs.getString("address");
                String email = rs.getString("email");
                String userType=rs.getString("UserType");
                String workingSince=staffWithStaffAttribute.getWorkingSince();
                String position=staffWithStaffAttribute.getPosition();
                staffWithParentAttribute.setId(id);
                staffWithParentAttribute.setName(name);
                staffWithParentAttribute.setGender(gender);
                staffWithParentAttribute.setNRIC(NRIC);
                staffWithParentAttribute.setUsername(username);
                staffWithParentAttribute.setPassword(password);
                staffWithParentAttribute.setMobile(mobile);
                staffWithParentAttribute.setAddress(address);
                staffWithParentAttribute.setEmail(email);
                staffWithParentAttribute.setPassword(password);
                staffWithParentAttribute.setUserType(userType);
                staffWithParentAttribute.setPosition(position);
                staffWithParentAttribute.setWorkingSince(workingSince);  
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

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
		return  staffWithParentAttribute;
	}
	
	public static Staff createById(int Id) {
		Staff staff = new Staff();
		Statement stmt = null;
		String searchQuery = "select * from staffdetails, person where staffdetails.ID ='"+ Id + "' AND person.ID='"+Id+"'";

    try {
        // connect to DB
        currentCon = DBConnectionManager.getConnection();
        stmt = currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        boolean more = rs.next();

        // if user does not exist set the isValid variable to false
        if (!more) {
          System.out.println("Member with the ID = " + Id + " does not exist");
        }

        // if user exists set the isValid variable to true
        else if (more) {
        	//From staffdetails
        	String workingSince=rs.getString("workingSince");
            String position=rs.getString("position");
            staff.setWorkingSince(workingSince);
            staff.setPosition(position);
            //From person
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String NRIC = rs.getString("NRIC");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String mobile = rs.getString("mobile");
            String address= rs.getString("address");
            String email = rs.getString("email");
            String userType = rs.getString("userType");
            staff.setId(id);
            staff.setName(name);
            staff.setGender(gender);
            staff.setNRIC(NRIC);
            staff.setUsername(username);
            staff.setPassword(password);
            staff.setMobile(mobile);
            staff.setAddress(address);
            staff.setEmail(email);
            staff.setPassword(password);
            staff.setUserType(userType);
        }
    } catch (Exception e) {
    }
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
    return staff;
	}
}
