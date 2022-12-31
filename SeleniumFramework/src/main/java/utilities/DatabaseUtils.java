package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
	
	public static ResultSet getDBConnectionResult(String query) {
		//Load the driver class
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			//Create the connection object
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				if(con!=null) {
					System.out.println("Database connection is established successfully.");
				}
				else {
					System.err.println("Database connection could not be established");
				}
				
			//Create the statement object
				Statement statement=null;
				try {
					statement = con.createStatement();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			//Execute the query
				ResultSet rs=null;
				try {
					rs = statement.executeQuery(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			/*	String value=null;
		
				try {
					while(rs.next()) {
					value=  rs.getString(column);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} */
		
				
			 return rs;
				
	}

}