package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScRgSkDao;
import dto.Religion;
import dto.School;
import dto.Skill;

public class StaffSearchFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("	----- StaffSearchForm.java  ��� �˻� �� Ŭ���� ����-----");
		String path = null;
		
		//���� �з� ��� ��������
		
		ScRgSkDao dao = new ScRgSkDao();
		
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffSearchForm.jsp";
		
		System.out.println("	----- StaffSearchForm.java  ��� �˻� �� Ŭ���� ���� -----");
		return path;
	}

}
