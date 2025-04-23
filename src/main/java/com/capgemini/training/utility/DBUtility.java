package com.capgemini.training.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static final String url = "jdbc:mysql://localhost:3306/employeejdbc";
	public static final String username ="root";
	public static final String password = "Rupini@123"; //give your password
	private static Connection connection = null;
	
	public static Connection getDBConnection()
			throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver registered");
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established");
		return connection;
	}
	
	public static void getDBConnectionClose() throws SQLException{
		connection.close();
	}

}
