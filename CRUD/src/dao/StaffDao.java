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
		System.out.println("----- dao.StaffDao.java start ������� �Է� ���� ���� Ŭ���� -----");
		System.out.println("");
	}
	
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("----- dao.staffDao.staffInsert �޼��� ������� �Է� �޼��� -----");
		conn=DBUtil.getConnection();
		int result=0;
		int staffResult=0;
		int skillResult=0;
		int staffNo = 0;
		try{
			//Ʈ������
			conn.setAutoCommit(false);
			
			//������� ���
			staffPstmt = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES (STAFF_SEQ.nextval,?,?,?,?,?)");
			staffPstmt.setString(1,staff.getName());
			staffPstmt.setString(2, staff.getSn());
			staffPstmt.setString(3, staff.getGraduateday());
			staffPstmt.setInt(4, staff.getSchool().getNo());
			staffPstmt.setInt(5, staff.getReligion().getNo());
			staffResult = staffPstmt.executeUpdate();
			System.out.println("������� �Է� �Ϸ�");
			staffPstmt.close();
			
			//�����ȣ ��������
			selectPstmt = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			selectPstmt.setString(1, staff.getSn());
			System.out.println(selectPstmt+"<--pstmt2");
			rs = selectPstmt.executeQuery();
			if(rs.next()){
				staffNo = rs.getInt("NO");
				System.out.println("�����ȣ"+rs.getInt("NO"));
				System.out.println("�����ȣ �������� �Ϸ�");
			}else{
				System.out.println("�����ȣ �������� ����");
				return result;
			}
			selectPstmt.close();
			
			//������ �����ȣ�� ��� ������� �Է�
			skillPstmt = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Staff st = new Staff();
				st.setNo(staffNo);//������ �����ȣ ��� ��ü�� �Է�
				Skill skill = arr.get(i); //��ų��ü�� �����ϰ� �迭�� ��ų��ü�� ��´�.
				skillPstmt.setInt(1, st.getNo()); //������ �����ȣ �������� ����
				skillPstmt.setInt(2, skill.getNo()); //��ų��ü�� ��ȣ ����
				skillResult = skillPstmt.executeUpdate();
			}
			System.out.println("��� ��� �Է� �Ϸ�");
			
			//�����ϼ������� �Ǵ� 
			if(staffResult!=0 && skillResult!=0){
				//�������,��� �Է� ������ result �� 1 ����
				System.out.println("----- ��� ����,��� �Է� ����-----");
				result = 1;
			}else{
				//�������,��� �Է� ���н� result �� 0 ����
				System.out.println("----- ��� ����,��� �Է� ���� -----");
				result = 0;
			}		
			conn.setAutoCommit(true);
			
		}catch(Exception e){
			System.out.println("----- ��� ��� ���� -----");
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
