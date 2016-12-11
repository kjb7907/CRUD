package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SearchOption;
import dto.Staff;

public class SearchDao {
	Connection conn;
	PreparedStatement staffPstmt;
	PreparedStatement skillPstmt;
	ResultSet rs;
	ArrayList<Staff> stfArr;
	
	//이름만 입력시
	
	public void SearchDao(){
		System.out.println("		----- dao.StaffDao.java 검색 클래스 -----");
	}
	
	public ArrayList<Staff> SearchDaoName(SearchOption so){
		System.out.println("			조건: 이름");
		conn = Dao.getConnection();	
		String sql = "";
		try {
			staffPstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return stfArr;
	}
}
