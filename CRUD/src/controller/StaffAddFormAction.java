package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.ScRgSkDao;
import dao.StaffDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;

public class StaffAddFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("----- StaffAddFormAction.java start ��� ��� �� �غ�ܰ� ���� -----");
		request.setCharacterEncoding("euc-kr");
		String path = null;
		
		//���� �з� ��� ��������
		
		ScRgSkDao dao = new ScRgSkDao();
		
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		
		
		path ="/WEB-INF/jsp/staff/staffAddForm.jsp";
		
		System.out.println("----- StaffAddFormAction.java start ��� ��� �� �غ�ܰ� ���� -----");
		System.out.println("");
		return path;
		

	}

}
