package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.content.text.plain;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();

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
		 System.out.println("요청 : "+command);
		 Action action=null;
		 String path=null;
		 
		 //사원 등록 요청시
		 if(command.equals("/staffAddForm.jbin")){
			 
			 System.out.println("----- 조건 : 사원등록 폼  -----");
			 /*
			  	사원등록 폼에 스킬,종교,학력 객체를 DB에서 가져와 전달하기위해
			   	StaffAddFormAction 메서드 호출한 반환값 action 객체에 저장하고
			   	ActionFoward 객체에 execute 메서드의 반환값 저장해 포워딩할 경로 세팅
			  */
				action = new StaffAddFormAction();
				try {
					path = action.execute(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffAddAction.jbin")){
			 
			 System.out.println("----- 조건 : 사원등록 처리  -----");
			 action  = new StaffAddAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffList.jbin")){
			 
			 System.out.println("----- 조건 : 사원 리스트 -----");
			 action  = new StaffAddAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffSearchForm.jbin")){
			 
			 System.out.println("----- 조건 : 사원조회 -----");
			 action  = new StaffSearchFormAction();
				try {
					path=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }
		 	
		 //forward
			if(path != null){
					System.out.println("----- 경로 이동 시작 ------");
					RequestDispatcher dispatcher=
						request.getRequestDispatcher(path);
					System.out.println(path + "<--- forward.getPath()[jsp 이동경로]Controller.java");
					System.out.println();
					dispatcher.forward(request, response);
			}
			System.out.println("-----Controller.java close 컨트롤러 종료-----");
			System.out.println("");
	}
}

