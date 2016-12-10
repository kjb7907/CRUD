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
		
		System.out.println("	----- StaffSearchForm.java  사원 검색 폼 클래스 시작-----");
		String path = null;
		
		//종교 학력 기술 가져오기
		
		ScRgSkDao dao = new ScRgSkDao();
		
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffSearchForm.jsp";
		
		System.out.println("	----- StaffSearchForm.java  사원 검색 폼 클래스 종료 -----");
		return path;
	}

}
