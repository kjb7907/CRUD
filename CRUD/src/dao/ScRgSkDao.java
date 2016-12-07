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

public class ScRgSkDao extends Dao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	

	//�����ڸ޼��� DB����
	public ScRgSkDao() {
		System.out.println("----- �з�,����,��� ���� �������� Ŭ���� -----");
	}
	
	public ArrayList<School> schoolSelect(){
		
		System.out.println("----- �з� �׸� �������� �޼��� -----");
		conn=DBUtil.getConnection();
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
			System.out.println("----- �з� �׸� �������� ���� -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- �з��׸� �������� ���� -----");
			e.printStackTrace();
		}finally{
			super.close(rs, pstmt,conn);
		}
		return arr;
	}
	
	public ArrayList<Religion> religionSelect(){
		
		System.out.println("----- ���� �׸� �������� �޼��� -----");
		conn=DBUtil.getConnection();
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
			System.out.println("----- ���� �׸� �������� ���� -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- �����׸� �������� ���� -----");
			e.printStackTrace();
		}finally{
			super.close(rs, pstmt,conn);
		}
		return arr;
	}
	
	public ArrayList<Skill> skillSelect(){
		
		System.out.println("----- ��� �׸� �������� �޼��� -----");
		conn=DBUtil.getConnection();
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
			System.out.println("----- ��� �׸� �������� ���� -----");
			System.out.println("");
		}catch(Exception e){
			System.out.println("----- ����׸� �������� ���� -----");
			e.printStackTrace();
		}finally{
			super.close(rs, pstmt,conn);
		}
		return arr;
	}
	

}
