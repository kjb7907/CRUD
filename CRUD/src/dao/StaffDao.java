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
		System.out.println("----- dao.StaffDao.java start 사원정보 입력 수정 삭제 클래스 -----");
		System.out.println("");
	}
	
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("----- dao.staffDao.staffInsert 메서드 사원정보 입력 메서드 -----");
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
			System.out.println("----- 사원 등록 성공-----");
		}catch(Exception e){
			System.out.println("----- 사원 등록 실패 -----");
			e.printStackTrace();
			result =0;
		}
		return result;
	}

}
