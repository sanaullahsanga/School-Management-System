package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	public String USER = "root";
	public String PASS = "";
	public Connection conn;
	public Statement stmt,s1,s2,s3,s4;
	public ResultSet rs=null; 
	
	public jdbc()
	{
		conn = null;
		stmt = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/sms_ooad";

		   //  Database credentials		   
		      //STEP 2: Register JDBC driver
		      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Connected database successfully...");
		      System.out.println("Welcome to School Management System");
		      try {
				stmt = conn.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
