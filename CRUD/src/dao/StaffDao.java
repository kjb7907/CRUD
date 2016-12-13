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
		System.out.println("		----- dao.StaffDao.java ������� �Է� ���� ���� Ŭ���� -----");
	}
	
	public ArrayList<Staff> staffListAll(){
		System.out.println("			----- dao.staffDao.staffListAll ��ü ��� staff ��ü�� �������� �޼��� -----");
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
	
	//������� �Է� 
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("			----- dao.staffDao.staffInsert ������� �Է� �޼��� -----");
		conn=Dao.getConnection();
		int result=0;
		int staffRow=0;
		int skillRow=0;
		int staffNo = 0;
		try{
			//Ʈ������
			conn.setAutoCommit(false);
			
			//������� ��� �� �����ȣ ��������
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
			System.out.println("				�����ȣ:"+staffNo);
			System.out.println("				������� �Է� �Ϸ�");

			//������ �����ȣ�� ��� ������� �Է�
			skillPstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Skill skill = arr.get(i); //��ų��ü�� �����ϰ� �迭�� ��ų��ü�� ��´�.
				skillPstmt.setInt(1, staffNo); //������ �����ȣ �������� ����
				skillPstmt.setInt(2, skill.getNo()); //��ų��ü�� ��ȣ ����
				skillRow = skillPstmt.executeUpdate();
			}
			System.out.println("				��� ��� �Է� �Ϸ�");
			
			//�����ϼ������� �Ǵ� 
			if(staffRow!=0 && skillRow!=0){
				//�������,��� �Է� ������ result �� 1 ����
				System.out.println("				��� ����,��� �Է� ����");
				result = 1;
			}else{
				//�������,��� �Է� ���н� result �� 0 ����
				System.out.println("				��� ����,��� �Է� ����");
				result = 0;
			}		
			conn.commit();
			
		}catch(Exception e){
			System.out.println("				��� ��� ����");
			result =0;
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			Dao.close(rs, staffPstmt, skillPstmt, conn);
		}
		return result;
	}

}
