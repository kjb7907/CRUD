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
		System.out.println("	----- StaffSearchFormAction.java  사원 리스트 클래스 시작-----");
		String path = null;
		
		System.out.println("		검색 폼 준비 종교,학력,기술 가져오기 시작");
		ScRgSkDao dao = new ScRgSkDao();
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		System.out.println("		검색 폼 준비 종교,학력,기술 가져오기 종료");
		
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffList.jsp";
		
		System.out.println("	----- StaffSearchForm.java  사원 리스트 클래스 종료 -----");
		return path;

	}

}
