package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Skill;
import dto.Staff;

public class StaffDao extends Dao {
	
	Connection conn;
	PreparedStatement staffPstmt;
	PreparedStatement selectPstmt;
	PreparedStatement skillPstmt;
	ResultSet rs;
	ArrayList<Staff> stfArr;
	
	public StaffDao(){
		System.out.println("----- dao.StaffDao.java start 사원정보 입력 수정 삭제 클래스 -----");
		System.out.println("");
	}
	
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("----- dao.staffDao.staffInsert 메서드 사원정보 입력 메서드 -----");
		conn=DBUtil.getConnection();
		int result=0;
		int staffResult=0;
		int skillResult=0;
		int staffNo = 0;
		try{
			//트랜젝션
			conn.setAutoCommit(false);
			
			//사원정보 등록
			staffPstmt = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES (STAFF_SEQ.nextval,?,?,?,?,?)");
			staffPstmt.setString(1,staff.getName());
			staffPstmt.setString(2, staff.getSn());
			staffPstmt.setString(3, staff.getGraduateday());
			staffPstmt.setInt(4, staff.getSchool().getNo());
			staffPstmt.setInt(5, staff.getReligion().getNo());
			staffResult = staffPstmt.executeUpdate();
			System.out.println("사원정보 입력 완료");
			staffPstmt.close();
			
			//사원번호 가져오기
			selectPstmt = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			selectPstmt.setString(1, staff.getSn());
			System.out.println(selectPstmt+"<--pstmt2");
			rs = selectPstmt.executeQuery();
			if(rs.next()){
				staffNo = rs.getInt("NO");
				System.out.println("사원번호"+rs.getInt("NO"));
				System.out.println("사원번호 가져오기 완료");
			}else{
				System.out.println("사원번호 가져오기 실패");
				return result;
			}
			selectPstmt.close();
			
			//가져온 사원번호로 사원 기술정보 입력
			skillPstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Staff st = new Staff();
				st.setNo(staffNo);//가져온 사원번호 사원 객체에 입력
				Skill skill = arr.get(i); //스킬객체를 생성하고 배열의 스킬객체를 담는다.
				skillPstmt.setInt(1, st.getNo()); //가져온 사원번호 쿼리문에 전달
				skillPstmt.setInt(2, skill.getNo()); //스킬객체의 번호 전달
				skillResult = skillPstmt.executeUpdate();
			}
			System.out.println("사원 기술 입력 완료");
			
			//사원등록성공여부 판단 
			if(staffResult!=0 && skillResult!=0){
				//사원정보,기술 입력 성공시 result 에 1 대입
				System.out.println("----- 사원 정보,기술 입력 성공-----");
				result = 1;
			}else{
				//사원정보,기술 입력 실패시 result 에 0 대입
				System.out.println("----- 사원 정보,기술 입력 실패 -----");
				result = 0;
			}		
			conn.setAutoCommit(true);
			
		}catch(Exception e){
			System.out.println("----- 사원 등록 실패 -----");
			e.printStackTrace();
			result =0;
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				staffPstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				selectPstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
