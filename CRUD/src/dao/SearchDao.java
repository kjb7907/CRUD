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
	
	//�̸��� �Է½�
	
	public void SearchDao(){
		System.out.println("		----- dao.StaffDao.java �˻� Ŭ���� -----");
	}
	
	public ArrayList<Staff> SearchDaoName(SearchOption so){
		System.out.println("			����: �̸�");
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
