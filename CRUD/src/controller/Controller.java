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
		
		System.out.println("-----Controller.java Start ��Ʈ�ѷ� ����  -----");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 //��û�� �ּҿ��� contextPath��ŭ �ڸ� ���ڿ��� ��û �Ǵ�
		 System.out.println("��û : "+command);
		 ActionForward forward=null;
		 Action action=null;
		 
		 //��� ��� ��û��
		 if(command.equals("/staffAddForm.jbin")){
			 
			 System.out.println("----- ���� : ������ ��  -----");
			 /*
			  	������ ���� ��ų,����,�з� ��ü�� DB���� ������ �����ϱ�����
			   	StaffAddFormAction �޼��� ȣ���� ��ȯ�� action ��ü�� �����ϰ�
			   	ActionFoward ��ü�� execute �޼����� ��ȯ�� ������ �������� ��� ����
			  */
				action = new StaffAddFormAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
		 }else if(command.equals("/StaffAddAction.jbin")){
			 
			 System.out.println("----- ���� : ������ ó��  -----");
			 action  = new StaffAddFormAction();
				try {
					forward=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 }
		 	
		 //forward
			if(forward != null){
					System.out.println("----- ��� �̵� ���� ------");
					RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
					System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]Controller.java");
					System.out.println();
					dispatcher.forward(request, response);
			}
			System.out.println("-----Controller.java close ��Ʈ�ѷ� ����-----");
	}
}

