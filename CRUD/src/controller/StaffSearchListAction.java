package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfacepack.Action;

public class StaffSearchListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("	----- StaffSEarchListAction.java ��� �˻� ����Ʈ ��� Ŭ���� ���� -----");
		String path = null;
		
		
		
		path = "/WEB-INF/jsp/staff/staffSearchList.jsp";
		System.out.println("	----- StaffSEarchListAction.java ��� �˻� ����Ʈ ��� Ŭ���� ���� -----");
		return path;
	}

}
		