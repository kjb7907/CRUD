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
		
		System.out.println("	----- StaffSearchFormAction.java  사원 검색 클래스 시작-----");
		String path = null;
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		System.out.println("		이름 : "+name);
		String[] gender = request.getParameterValues("gender");
		System.out.println("		성별 : " +gender);
		String religionNo = request.getParameter("religionNo");
		System.out.println("		종교 : "+religionNo);
		String[] schoolNo = request.getParameterValues("schoolNo");
		System.out.println("		학력 : "+schoolNo);
		String graduateday = request.getParameter("graduateday");
		System.out.println("		졸업년도 : "+graduateday);
		String[] skillNo = request.getParameterValues("skillNo");
		
		
		System.out.println("		검색 폼 준비 종교,학력,기술 가져오기 시작");
		ScRgSkDao dao = new ScRgSkDao();
		ArrayList<Religion> relList = dao.religionSelect();
		ArrayList<School> scList = dao.schoolSelect();
		ArrayList<Skill> skList = dao.skillSelect();
		System.out.println("		검색 폼 준비 종교,학력,기술 가져오기 종료");
		
		System.out.println("		검색 조건 세팅 ");
		SearchOption so = new SearchOption();
		so.setName(name);
		so.setGender(gender);
		so.setReligionNo(religionNo);
		so.setSchoolNo(schoolNo);
		so.setSkillNo(skillNo);
		so.setGraduateday(graduateday);
			
		System.out.println("		검색 결과 가져오기 시작");
		
		System.out.println("		검색 결과 가져오기 종료");	
		
		//종교 학력 기술 세팅
		request.setAttribute("relList", relList);
		request.setAttribute("scList", scList);
		request.setAttribute("skList", skList);
		path ="/WEB-INF/jsp/staff/staffSearchForm.jsp";
		
		System.out.println("	----- StaffSearchForm.java  사원 검색 클래스 종료 -----");
		return path;
	}

}
