package com.librarymanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","root");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
