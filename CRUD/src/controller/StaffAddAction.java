package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffAndSkillDao;
import dao.StaffDao;
import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class StaffAddAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("	----- StaffAddAction.java start 사원 등록 처리 클래스 시작 -----");
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		System.out.println("		이름 : "+name);
		String sn = request.getParameter("sn1")+request.getParameter("sn2");
		System.out.println("		주민번호 : " +sn);
		int religionNo = Integer.parseInt(request.getParameter("religionNo"));
		System.out.println("		종교 : "+religionNo);
		int schoolNo = Integer.parseInt(request.getParameter("schoolNo"));
		System.out.println("		학력 : "+schoolNo);
		String graduateday = request.getParameter("graduateday");
		System.out.println("		졸업년도 : "+graduateday);
		String[] skillNo = request.getParameterValues("skillNo");
		
		
		//사원 등록에 필요한 객체들 생성
		Staff staff = new Staff();
		Religion religion = new Religion();
		School school = new School();
		ArrayList<Skill> arr = new ArrayList<Skill>();
		
		
		for(int i= 0;i<skillNo.length;i++){ //기술정보 세팅
			Skill skill = new Skill();
			skill.setNo(Integer.parseInt(skillNo[i]));
			System.out.println("		"+skill.toString());
			arr.add(skill);
		}
		
		religion.setNo(religionNo);//종교정보 세팅
		school.setNo(schoolNo); //학력정보 세팅
		
		religion.toString();
		school.toString();
		
		staff.setName(name);//사원정보 세팅
		staff.setSn(sn);
		staff.setReligion(religion);
		staff.setSchool(school);
		staff.setGraduateday(graduateday);

		
		StaffDao dao1 = new StaffDao();
		int result = dao1.staffInsert(staff,arr);
		if(result == 0 ){
			System.out.println("		사원등록 실패");
		}else{
			System.out.println("		사원등록 성공");
		}
		System.out.println("	----- StaffAddAction.java close 사원 등록 처리 클래스 종료 -----");

		return null;
	}

}
