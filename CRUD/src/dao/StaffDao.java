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
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
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
		try{
			//사원정보 등록
			pstmt1 = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES (STAFF_SEQ.nextval,?,?,?,?,?)");
			pstmt1.setString(1,staff.getName());
			pstmt1.setString(2, staff.getSn());
			pstmt1.setString(3, staff.getGraduateday());
			pstmt1.setInt(4, staff.getSchool().getNo());
			pstmt1.setInt(5, staff.getReligion().getNo());
			result = pstmt1.executeUpdate();
			System.out.println("사원정보 입력 완료");
			
			//사원번호 가져오기
			pstmt2 = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			pstmt2.setString(1, staff.getSn());
			System.out.println(pstmt2+"<--pstmt2");
			rs = pstmt2.executeQuery();
			System.out.println("사원번호가져오는쿼리문실행");
			rs.next();
			System.out.println("rs.next()까지");
			int staffNo = rs.getInt("no");
			System.out.println("사원번호 가져오기 완료");
			
			//가져온 사원번호로 사원 기술정보 입력
			pstmt1 = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Staff st = new Staff();
				st.setNo(staffNo);//가져온 사원번호 사원 객체에 입력
				Skill skill = arr.get(i); //스킬객체를 생성하고 배열의 스킬객체를 담는다.
				pstmt1.setInt(1, st.getNo()); //가져온 사원번호 쿼리문에 전달
				pstmt1.setInt(2, skill.getNo()); //스킬객체의 번호 전달
				pstmt1.executeUpdate();
			}
			System.out.println("사원 기술 입력 완료");
			
			System.out.println("----- 사원 등록 성공-----");
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
				pstmt1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt2.close();
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
