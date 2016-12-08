package dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	static Connection conn;
	
	private static final String driver;
	private static final String url;
	private static final String user;
	private static final String pw;
	static {
		driver = "oracle.jdbc.OracleDriver"; 
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		user = "ACE";
		pw = "java0000";
	}
	
	public static Connection getConnection() {
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("db¿¬°á");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
