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
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		System.out.println("----- StaffAddFormAction.java start ���� ��� �� �غ�ܰ� ���� -----");
		
		//���� �з� ��� ��������
		
		ScRgSkDao dao = new ScRgSkDao();
		
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		
		
		forward.setPath("/WEB-INF/jsp/staff/staffAdd.jsp");
		
		System.out.println("----- StaffAddFormAction.java start ���� ��� �� �غ�ܰ� ���� -----");
		System.out.println("");
		return forward;
		

	}

}
