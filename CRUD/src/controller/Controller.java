package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScRgSkDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import interfacepack.Action;
import sun.net.www.content.text.plain;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();

    }
    
    public void init()throws ServletException{
        System.out.println("-----controller.java init 메서드 시작 -----");
        System.out.println("-----controller.java init 메서드 종료 -----");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-----Controller.java Start 컨트롤러 시작  -----");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 //요청온 주소에서 contextPath만큼 자른 문자열로 요청 판단
		 System.out.println("	요청 : "+command);
		 Action action=null;
		 String path=null;
		 
		 //사원 등록 요청시
		 if(command.equals("/StaffAddForm.jbin")){
			 
			 System.out.println("	조건 : 사원등록 폼");
				action = new StaffAddFormAction();
				try {
					path = action.execute(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffAddAction.jbin")){
			 
			 System.out.println("	조건 : 사원등록 처리");
			 action  = new StaffAddAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffList.jbin")){
			 
			 System.out.println("	조건 : 사원 리스트");
			 action  = new StaffListAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffSearchForm.jbin")){
			
			 System.out.println("	조건 : 사원검색");
			 action  = new StaffSearchFormAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }
		 	
		 //forward
			if(path != null){
					System.out.println("	----- 경로 이동 시작 ------");
					RequestDispatcher dispatcher=
						request.getRequestDispatcher(path);
					System.out.println("		이동경로 : "+path);
					dispatcher.forward(request, response);
			}
			System.out.println("-----Controller.java close 컨트롤러 종료-----");
			System.out.println("");
	}
}

