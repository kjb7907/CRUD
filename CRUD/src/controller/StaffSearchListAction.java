package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfacepack.Action;

public class StaffSearchListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("	----- StaffSEarchListAction.java 사원 검색 리스트 출력 클래스 시작 -----");
		String path = null;
		
		
		
		path = "/WEB-INF/jsp/staff/staffSearchList.jsp";
		System.out.println("	----- StaffSEarchListAction.java 사원 검색 리스트 출력 클래스 종료 -----");
		return path;
	}

}
		