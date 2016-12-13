package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;

public class StaffDao {
	
	Connection conn;
	PreparedStatement staffPstmt;
	PreparedStatement skillPstmt;
	ResultSet rs;
	ArrayList<Staff> stfArr;
	ArrayList<Skill> skArr;
	
	public StaffDao(){
		System.out.println("		----- dao.StaffDao.java 사원정보 입력 수정 삭제 클래스 -----");
	}
	
	public ArrayList<Staff> staffListAll(){
		System.out.println("			----- dao.staffDao.staffListAll 전체 사원 staff 객체로 가져오는 메서드 -----");
		conn=Dao.getConnection();
		try {
			staffPstmt = conn.prepareStatement("SELECT no,name,sn,graduateday,schoolno,religionno FROM STAFF");
			rs = staffPstmt.executeQuery();
			while(rs.next()){
				
				Religion rel = new Religion();
				rel.setNo(rs.getInt("religionno"));
				School sc = new School();
				sc.setNo(rs.getInt("schoolno"));
				Staff st = new Staff();
				st.setNo(rs.getInt("no"));
				st.setName(rs.getString("name"));
				st.setSn(rs.getString("sn"));
				st.setGraduateday(rs.getString("graduateday"));
				st.setReligion(rel);
				st.setSchool(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dao.close(rs, staffPstmt, conn);
		}
		return stfArr;
	}
	
	//사원정보 입력 
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("			----- dao.staffDao.staffInsert 사원정보 입력 메서드 -----");
		conn=Dao.getConnection();
		int result=0;
		int staffRow=0;
		int skillRow=0;
		int staffNo = 0;
		try{
			//트랜젝션
			conn.setAutoCommit(false);
			
			//사원정보 등록 및 사원번호 가져오기
			String[] keyCol ={"no"};
			staffPstmt = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES"
							+ "(STAFF_SEQ.nextval,?,?,?,?,?)",keyCol);
			staffPstmt.setString(1,staff.getName());
			staffPstmt.setString(2, staff.getSn());
			staffPstmt.setString(3, staff.getGraduateday());
			staffPstmt.setInt(4, staff.getSchool().getNo());
			staffPstmt.setInt(5, staff.getReligion().getNo());
			staffRow = staffPstmt.executeUpdate();
			rs=staffPstmt.getGeneratedKeys();
			if(rs.next()){
				staffNo = rs.getInt(1);
			}
			System.out.println("				사원번호:"+staffNo);
			System.out.println("				사원정보 입력 완료");

			//가져온 사원번호로 사원 기술정보 입력
			skillPstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Skill skill = arr.get(i); //스킬객체를 생성하고 배열의 스킬객체를 담는다.
				skillPstmt.setInt(1, staffNo); //가져온 사원번호 쿼리문에 전달
				skillPstmt.setInt(2, skill.getNo()); //스킬객체의 번호 전달
				skillRow = skillPstmt.executeUpdate();
			}
			System.out.println("				사원 기술 입력 완료");
			
			//사원등록성공여부 판단 
			if(staffRow!=0 && skillRow!=0){
				//사원정보,기술 입력 성공시 result 에 1 대입
				System.out.println("				사원 정보,기술 입력 성공");
				result = 1;
			}else{
				//사원정보,기술 입력 실패시 result 에 0 대입
				System.out.println("				사원 정보,기술 입력 실패");
				result = 0;
			}		
			conn.commit();
			
		}catch(Exception e){
			System.out.println("				사원 등록 실패");
			result =0;
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			Dao.close(rs, staffPstmt, skillPstmt, conn);
		}
		return result;
	}

}
