package in.ems.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	 private static Connection conn;

	    public static Connection getConnection() {
	        try {
	            if (conn == null) {
	                Class.forName("com.mysql.cj.jdbc.Driver");

	                conn = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/ems_db",
	                    "root",
	                    "dexysexy@69"   // change password if needed
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
	
}
