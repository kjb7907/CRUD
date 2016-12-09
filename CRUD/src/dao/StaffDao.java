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
		System.out.println("----- dao.StaffDao.java start ������� �Է� ���� ���� Ŭ���� -----");
		System.out.println("");
	}
	
	public int staffInsert(Staff staff,ArrayList<Skill> arr){
		System.out.println("----- dao.staffDao.staffInsert �޼��� ������� �Է� �޼��� -----");
		conn=DBUtil.getConnection();
		int result=0;
		try{
			//������� ���
			pstmt1 = conn.prepareStatement
					("INSERT INTO STAFF (no,name,sn,graduateday,schoolno,religionno) VALUES (STAFF_SEQ.nextval,?,?,?,?,?)");
			pstmt1.setString(1,staff.getName());
			pstmt1.setString(2, staff.getSn());
			pstmt1.setString(3, staff.getGraduateday());
			pstmt1.setInt(4, staff.getSchool().getNo());
			pstmt1.setInt(5, staff.getReligion().getNo());
			result = pstmt1.executeUpdate();
			System.out.println("������� �Է� �Ϸ�");
			
			//�����ȣ ��������
			pstmt2 = conn.prepareStatement("SELECT no FROM STAFF WHERE sn = ?");
			pstmt2.setString(1, staff.getSn());
			System.out.println(pstmt2+"<--pstmt2");
			rs = pstmt2.executeQuery();
			System.out.println("�����ȣ������������������");
			rs.next();
			System.out.println("rs.next()����");
			int staffNo = rs.getInt("no");
			System.out.println("�����ȣ �������� �Ϸ�");
			
			//������ �����ȣ�� ��� ������� �Է�
			pstmt1 = conn.prepareStatement
					("INSERT INTO STAFFSKILL(no,staffno,skillno) VALUES(STAFFSKILL_SEQ.nextval,?,?)");
			for(int i=0;i<arr.size();i++){ 
				Staff st = new Staff();
				st.setNo(staffNo);//������ �����ȣ ��� ��ü�� �Է�
				Skill skill = arr.get(i); //��ų��ü�� �����ϰ� �迭�� ��ų��ü�� ��´�.
				pstmt1.setInt(1, st.getNo()); //������ �����ȣ �������� ����
				pstmt1.setInt(2, skill.getNo()); //��ų��ü�� ��ȣ ����
				pstmt1.executeUpdate();
			}
			System.out.println("��� ��� �Է� �Ϸ�");
			
			System.out.println("----- ��� ��� ����-----");
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
