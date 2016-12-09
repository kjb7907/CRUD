package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//��� �������� DB���� �� ��ü����� ���Ḧ ���� Ŭ����

public class Dao {
	
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
			System.out.println("db����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// PreparedStaatement ��ü 1���ϰ�� ����
	public static void close1(ResultSet rs,PreparedStatement pstmt,Connection conn){

		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	
	// PreparedStaatement ��ü 2���ϰ�� ����
	public static void close2(ResultSet rs,PreparedStatement pstmt1,PreparedStatement pstmt2,Connection conn){

		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
		if (pstmt2 != null) try { pstmt2.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
}
