package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Skill;
import dto.Staff;

public class StaffDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Staff> stfArr;
	ArrayList<Skill> skArr;
	
	public StaffDao(){
		System.out.println("----- dao.StaffDao.java start ������� �Է� ���� ���� Ŭ���� -----");
		System.out.println("");
	}
	
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("----- dao.staffDao.staffInsert �޼��� ������� �Է� �޼��� -----");
		conn=DBUtil.getConnection();
		int result=0;
		try{
			pstmt = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES (STAFF_SEQ.nextval,?,?,?,?,?)");
			pstmt.setString(1,staff.getName());
			pstmt.setString(2, staff.getSn());
			pstmt.setString(3, staff.getGraduateday());
			pstmt.setInt(4, staff.getSchool().getNo());
			pstmt.setInt(5, staff.getReligion().getNo());
			result = pstmt.executeUpdate();
			System.out.println("----- ��� ��� ����-----");
		}catch(Exception e){
			System.out.println("----- ��� ��� ���� -----");
			e.printStackTrace();
			result =0;
		}
		return result;
	}

}
