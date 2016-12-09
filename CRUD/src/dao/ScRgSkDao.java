package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;

import dto.Religion;
import dto.School;
import dto.Skill;

public class ScRgSkDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	

	//생성자메서드
	public ScRgSkDao() {
		System.out.println("----- dao.ScRgSkDao.java start 학력,종교,기술 정보 가져오는 클래스 시작 -----");
		System.out.println("");
	}
	
	public ArrayList<School> schoolSelect(){
		
		System.out.println("----- dao.ScRgSkDao.schoolSelect 학력 항목 가져오는 메서드 -----");
		conn=Dao.getConnection();
		ArrayList<School> arr = new ArrayList<School>();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM SCHOOL ORDER BY no ASC");
			System.out.println(pstmt+"<---pstmt");
			rs = pstmt.executeQuery();
			while(rs.next()){
				School sc = new School();
				sc.setNo(rs.getInt("no"));
				sc.setGraduate(rs.getString("graduate"));
				arr.add(sc);
			}
			System.out.println("----- 학력 항목 가져오기 성공 -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- 학력항목 가져오기 실패 -----");
			e.printStackTrace();
		}finally{
			Dao.close(rs, pstmt,conn);
		}
		return arr;
	}
	
	public ArrayList<Religion> religionSelect(){
		
		System.out.println("----- dao.ScRgSkDao.religionSelect 종교 항목 가져오는 메서드 -----");
		conn=Dao.getConnection();
		ArrayList<Religion> arr = new ArrayList<Religion>();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM RELIGION ORDER BY no ASC");
			System.out.println(pstmt+"<---pstmt");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Religion sc = new Religion();
				sc.setNo(rs.getInt("no"));
				sc.setName(rs.getString("name"));
				arr.add(sc);
			}
			System.out.println("----- 종교 항목 가져오기 성공 -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- 종교항목 가져오기 실패 -----");
			e.printStackTrace();
		}finally{
			Dao.close(rs, pstmt,conn);
		}
		return arr;
	}
	
	public ArrayList<Skill> skillSelect(){
		
		System.out.println("----- dao.ScRgSkDao.skillSelect 기술 항목 가져오는 메서드 -----");
		conn=Dao.getConnection();
		ArrayList<Skill> arr = new ArrayList<Skill>();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM Skill ORDER BY no ASC");
			System.out.println(pstmt+"<---pstmt");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Skill sk = new Skill();
				sk.setNo(rs.getInt("no"));
				sk.setName(rs.getString("name"));
				arr.add(sk);
			}
			System.out.println("----- 기술 항목 가져오기 성공 -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- 기술항목 가져오기 실패 -----");
			e.printStackTrace();
		}finally{
			Dao.close(rs, pstmt,conn);
		}
		return arr;
	}
	

}
