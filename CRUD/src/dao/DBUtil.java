package dao;

import java.sql.Connection;

public class DBUtil {
	private static final String driver;
	private static final String url;
	private static final String user;
	private static final String pw;
	static {
		driver = ""; 
		url = "";
		user = "";
		pw = "";
	}
	
	public static Connection getConnection() {
		return null;
	}
}
