package dto;

public class SearchOption {
	String name;
	String[] gender;
	String religionNo;
	String[] schoolNo;
	String graduateday;
	String[] skillNo;
	
	public String toString(){
		return "검색조건 이름:"+name+" 성별:"+gender+" 종교:"+religionNo+" 학력"+schoolNo+" 기술:"+skillNo+" 졸업일:"+graduateday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getGender() {
		return gender;
	}
	public void setGender(String[] gender) {
		this.gender = gender;
	}
	public String getReligionNo() {
		return religionNo;
	}
	public void setReligionNo(String religionNo) {
		this.religionNo = religionNo;
	}
	public String[] getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(String[] schoolNo) {
		this.schoolNo = schoolNo;
	}
	public String getGraduateday() {
		return graduateday;
	}
	public void setGraduateday(String graduateday) {
		this.graduateday = graduateday;
	}
	public String[] getSkillNo() {
		return skillNo;
	}
	public void setSkillNo(String[] skillNo) {
		this.skillNo = skillNo;
	}
}
