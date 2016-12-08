package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class StaffAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("----- StaffAddAction.java start ��� ��� ó�� �غ�ܰ� ���� -----");
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		System.out.println("�̸� : "+name);
		String sn = request.getParameter("sn1")+request.getParameter("sn2");
		System.out.println("�ֹι�ȣ : " +sn);
		int religionNo = Integer.parseInt(request.getParameter("religionNo"));
		System.out.println("���� : "+religionNo);
		int schoolNo = Integer.parseInt(request.getParameter("schoolNo"));
		System.out.println("�з� : "+schoolNo);
		String graduateday = request.getParameter("graduateday");
		System.out.println("�����⵵ : "+graduateday);
		String[] skillNo = request.getParameterValues("skillNo");
		
		ActionForward forward = new ActionForward();
		
		//��� ��Ͽ� �ʿ��� ��ü�� ����
		Staff staff = new Staff();
		Religion religion = new Religion();
		School school = new School();
		ArrayList<Skill> arr = new ArrayList<Skill>();
		
		
		for(int i= 0;i<skillNo.length;i++){ //������� ����
			Skill skill = new Skill();
			skill.setNo(Integer.parseInt(skillNo[i]));
			System.out.println(skill.toString());
			arr.add(skill);
		}
		
		religion.setNo(religionNo);//�������� ����
		school.setNo(schoolNo); //�з����� ����
		
		religion.toString();
		school.toString();
		
		staff.setName(name);
		staff.setSn(sn);
		staff.setReligion(religion);
		staff.setSchool(school);
		staff.setGraduateday(graduateday);
		System.out.println("��� ���� ����");
		
		StaffDao dao = new StaffDao();
		dao.staffInsert(staff, arr);
		
			
		System.out.println("----- StaffAddAction.java close ��� ��� ó�� �غ�ܰ� ���� -----");
		
		return null;
	}

}
