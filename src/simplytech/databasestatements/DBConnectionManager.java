package simplytech.databasestatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	static Connection con;
    static String url;
    public static Connection getConnection() {
     
        try {
            String url = "jdbc:mysql://localhost:8888/simplytech";
            // assuming "DataSource" is your DataSource name

            Class.forName("com.mysql.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, "simplyTECH", "hahaudie");
            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {// "logger" prints in to a file;
           
            System.out.println(e);
        }

        return con;
    }
}
