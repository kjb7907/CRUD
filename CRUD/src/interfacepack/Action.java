package interfacepack;

import javax.servlet.http.*;

//Action 인터페이스 forward 할 경로를 지정하는 ActionForward 타입 인스턴스 반환을 위한 인터페이스
public interface Action {
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
