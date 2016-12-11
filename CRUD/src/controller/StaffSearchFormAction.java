package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScRgSkDao;
import dto.Religion;
import dto.School;
import dto.SearchOption;
import dto.Skill;

public class StaffSearchFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("	----- StaffSearchFormAction.java  ��� �˻� Ŭ���� ����-----");
		String path = null;
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		System.out.println("		�̸� : "+name);
		String[] gender = request.getParameterValues("gender");
		System.out.println("		���� : " +gender);
		String religionNo = request.getParameter("religionNo");
		System.out.println("		���� : "+religionNo);
		String[] schoolNo = request.getParameterValues("schoolNo");
		System.out.println("		�з� : "+schoolNo);
		String graduateday = request.getParameter("graduateday");
		System.out.println("		�����⵵ : "+graduateday);
		String[] skillNo = request.getParameterValues("skillNo");
		
		
		System.out.println("		�˻� �� �غ� ����,�з�,��� �������� ����");
		ScRgSkDao dao = new ScRgSkDao();
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		System.out.println("		�˻� �� �غ� ����,�з�,��� �������� ����");
		
		System.out.println("		�˻� ���� ���� ");
		SearchOption so = new SearchOption();
		so.setName(name);
		so.setGender(gender);
		so.setReligionNo(religionNo);
		so.setSchoolNo(schoolNo);
		so.setSkillNo(skillNo);
		so.setGraduateday(graduateday);
			
		System.out.println("		�˻� ��� �������� ����");
		
		System.out.println("		�˻� ��� �������� ����");	
		
		//���� �з� ��� ����
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffSearchForm.jsp";
		
		System.out.println("	----- StaffSearchForm.java  ��� �˻� Ŭ���� ���� -----");
		return path;
	}

}
