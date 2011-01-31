package se.kyh.ad10s.scrumapp;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.*;

public class DbManager {

	private static Connection conn = null;

	private static void init() throws Exception {
		
		String userName = "root";
		String password = " ";

		String url = "jdbc:mysql://localhost/scrumapp";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		conn = DriverManager.getConnection(url, userName, password);

	}

	public static Connection getConnection() throws Exception {
		if (conn == null) {
			init();
		}
		return conn;
	}

	public static void close() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Database");
			} catch (Exception e) {
				
			}
		}
	}
}
