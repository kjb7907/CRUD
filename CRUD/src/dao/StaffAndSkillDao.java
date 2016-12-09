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
		System.out.println("----- dao.StaffAndSkill.java ����� ��� �����Է��ϴ� Ŭ���� -----");
		System.out.println("");
	}
	
	public int StaffAndSkillInsert(Staff staff,ArrayList<Skill> arr){
		int result = 0;
		conn = Dao.getConnection();
		
		try {
			//�����ȣ ��������
			pstmt = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			pstmt.setString(1, staff.getSn());
			rs = pstmt.executeQuery();
			rs.next();
			
			//������ �����ȣ�� ��� ������� �Է�
			pstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?");
			for(int i=0;i<arr.size();i++){ 
				Skill skill = arr.get(i); //��ų��ü�� �����ϰ� �迭�� ��ų��ü�� ��´�.
				pstmt.setInt(1, staff.getNo()); //�Ű������ι��� �����ü�� �����ȣ ����
				pstmt.setInt(2, skill.getNo()); //��ų��ü�� ��ȣ ����
				pstmt.executeUpdate();
				result+=1;
			}
			System.out.println("----- ��� ������� �Է� ���� -----");
		} catch (SQLException e) {
			System.out.println("----- ��� ������� �Է� ����- ----");
			e.printStackTrace();
		}
		
		return result;
	}
}
