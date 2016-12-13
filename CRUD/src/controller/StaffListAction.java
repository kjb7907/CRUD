package controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScRgSkDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import interfacepack.Action;

public class StaffListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("	----- StaffSearchFormAction.java  ��� ����Ʈ Ŭ���� ����-----");
		String path = null;
		
		System.out.println("		�˻� �� �غ� ����,�з�,��� �������� ����");
		ScRgSkDao dao = new ScRgSkDao();
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		System.out.println("		�˻� �� �غ� ����,�з�,��� �������� ����");
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffList.jsp";
		
		System.out.println("	----- StaffSearchForm.java  ��� ����Ʈ Ŭ���� ���� -----");
		return path;

	}

}
