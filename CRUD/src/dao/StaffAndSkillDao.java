package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Skill;
import dto.Staff;

public class StaffAndSkillDao{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public StaffAndSkillDao(){
		System.out.println("----- dao.StaffAndSkill.java 사원의 기술 정보입력하는 클래스 -----");
		System.out.println("");
	}
	
	public int StaffAndSkillInsert(Staff staff,ArrayList<Skill> arr){
		int result = 0;
		conn = Dao.getConnection();
		
		try {
			//사원번호 가져오기
			pstmt = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			pstmt.setString(1, staff.getSn());
			rs = pstmt.executeQuery();
			rs.next();
			
			//가져온 사원번호로 사원 기술정보 입력
			pstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?");
			for(int i=0;i<arr.size();i++){ 
				Skill skill = arr.get(i); //스킬객체를 생성하고 배열의 스킬객체를 담는다.
				pstmt.setInt(1, staff.getNo()); //매개변수로받은 사원객체의 사원번호 전달
				pstmt.setInt(2, skill.getNo()); //스킬객체의 번호 전달
				pstmt.executeUpdate();
				result+=1;
			}
			System.out.println("----- 사원 기술정보 입력 성공 -----");
		} catch (SQLException e) {
			System.out.println("----- 사원 기술정보 입력 실패- ----");
			e.printStackTrace();
		}
		
		return result;
	}
}
