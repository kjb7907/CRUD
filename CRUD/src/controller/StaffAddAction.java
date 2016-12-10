package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffAndSkillDao;
import dao.StaffDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class StaffAddAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("	----- StaffAddAction.java start ��� ��� ó�� Ŭ���� ���� -----");
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		System.out.println("		�̸� : "+name);
		String sn = request.getParameter("sn1")+request.getParameter("sn2");
		System.out.println("		�ֹι�ȣ : " +sn);
		int religionNo = Integer.parseInt(request.getParameter("religionNo"));
		System.out.println("		���� : "+religionNo);
		int schoolNo = Integer.parseInt(request.getParameter("schoolNo"));
		System.out.println("		�з� : "+schoolNo);
		String graduateday = request.getParameter("graduateday");
		System.out.println("		�����⵵ : "+graduateday);
		String[] skillNo = request.getParameterValues("skillNo");
		
		
		//��� ��Ͽ� �ʿ��� ��ü�� ����
		Staff staff = new Staff();
		Religion religion = new Religion();
		School school = new School();
		ArrayList<Skill> arr = new ArrayList<Skill>();
		
		
		for(int i= 0;i<skillNo.length;i++){ //������� ����
			Skill skill = new Skill();
			skill.setNo(Integer.parseInt(skillNo[i]));
			System.out.println("		"+skill.toString());
			arr.add(skill);
		}
		
		religion.setNo(religionNo);//�������� ����
		school.setNo(schoolNo); //�з����� ����
		
		religion.toString();
		school.toString();
		
		staff.setName(name);//������� ����
		staff.setSn(sn);
		staff.setReligion(religion);
		staff.setSchool(school);
		staff.setGraduateday(graduateday);

		
		StaffDao dao1 = new StaffDao();
		int result = dao1.staffInsert(staff,arr);
		if(result == 0 ){
			System.out.println("		������ ����");
		}else{
			System.out.println("		������ ����");
		}
		System.out.println("	----- StaffAddAction.java close ��� ��� ó�� Ŭ���� ���� -----");

		return null;
	}

}
