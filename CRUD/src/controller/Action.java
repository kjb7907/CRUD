package controller;

import javax.servlet.http.*;

//Action �������̽� forward �� ��θ� �����ϴ� ActionForward Ÿ�� �ν��Ͻ� ��ȯ�� ���� �������̽�
public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
