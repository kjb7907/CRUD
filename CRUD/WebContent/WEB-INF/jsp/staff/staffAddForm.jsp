<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "dto.*" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
  $(document).ready(function()
  {
    $("#btn").click(function()
    {
      console.log('btn click'); //버튼클릭까지 넘어옴
      //이름 유효성 검사
      if($("#name").val() == ""){	//이름입력칸이 비어있을경우
          $("#nameHelper").text('이름을 입력하세요.');
          $("#name").focus();
      }else if($("#name").val() != ""){	//이름입력칸이 공백이 아니고
        for(var i = 0; i<$("#name").val().length; i++){	//입력된 문자의 유니코드가 128과 같거나 크면
          if($("#name").val().charCodeAt(i)<128){
		      $("#nameHelper").text('한글만 입력 가능합니다.');
		      $("#name").focus();
          }else{	//조건 만족시에는 Helper 공백
	          $("#nameHelper").text('');
	          $("#name").blur();
          }
        }
       }
		//나머지 
		if(!($.isNumeric($("#sn1").val()))){
			console.log("주민등록번호 앞자리 미선택");
			$("#snHelper").text(" 첫번째 입력칸 6자리 숫자만 입력 가능합니다.");
			$("#sn1").focus();
		}else if(!($.isNumeric($("#sn2").val()))){
			console.log("주민등록번호 뒷자리 미선택");
			$("#snHelper").text(" ");
			$("#snHelper").text(" 두번째 입력칸 7자리 숫자만 입력 가능합니다.");
			$("#sn2").focus();
     	}else if($("#religion").val() == ""){
			console.log("종교미선택");
			$("#snHelper").text(" ");
			$("#relHelper").text(" 종교를 선택하세요.");
		}else if((!$("#school1").is(":checked"))&&(!$("#school2").is(":checked"))&&(!$("#school3").is(":checked"))){
			console.log("학력 미선택");
			$("#relHelper").text("");
			$("#scHelper").text("최종학력을 선택해주세요");
		}else if((!$("#skill1").is(":checked"))&&(!$("#skill2").is(":checked"))&&(!$("#skill3").is(":checked"))&&(!$("#skill4").is(":checked"))&&(!$("#skill5").is(":checked"))){
			console.log("기술 미선택");
			$("#scHelper").text("");
			$("#skHelper").text("기술을 1개 이상 선택해주세요");
		}else if($("#date").val()==""){
			console.log($("#date").val());
			console.log("졸업일 미선택");
			$("#skHelper").text("");
			$("#dateHelper").text("졸업일을 선택해 주세요");
			$("#date").focus();
		}else{
			console.log("회원가입 조건 충족");
			$("form").submit();
		}
   	 
    });
  });
</script>
</head>
<body>

<%@ include file = "../module/naviside.jsp" %>


<div class="col-sm-8">
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">사원 등록</h3>
	  </div>
	  <div class="panel-body">

	    <form class="form-inline" action = "<%=request.getContextPath()%>/StaffAddAction.jbin" method = "post">
	    	<table class = "table">

	    		<tr>
					<td style = "width:100px">이름  </td>
					<td>
						<input id = "name" name = "name" type = "text" style = "width:150px;">
						<span id = "nameHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>주민등록번호</td>
					<td>
						<input id = "sn1" name = "sn1" type = "text"  style = "width:100px;" >
						 -
						<input id = "sn2" name = "sn2" type = "text" style = "width:100px;">
						<span id = "snHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>종교</td>
					<td>
						<select  name = "religionNo" id="religion" style = "width:100px;">
				          	<option value= ""></option>
							<c:forEach var="rel" items="${relList}">
								<option value = "${rel.no}"> ${rel.no} ${rel.name}</option>
							</c:forEach>
						</select>
			            <span id = "relHelper" style = " font-size:1em;  color: red;">
			          </td>
				</tr>

				<tr>
					<td>학력</td>
					<td>
						<c:forEach var ="sc" items="${scList}">
							<input id = "school${sc.no}" type = "radio" name = "schoolNo" value ="${sc.no}">${sc.graduate}
						</c:forEach>
						<span id = "scHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>기술</td>
					<td>
						<c:forEach var="sk" items = "${skList}">
							<input id = "skill${sk.no}" name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>
						<span id = "skHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>졸업년도</td>
					<td>
						<input id="date" type ="date" name = "graduateday">
						<span id = "dateHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

			</table>
			 <button type="reset" class="btn btn-default">취소</button>
       <button id = "btn" type="button" class="btn btn-primary">등록</button>
	    </form>
	  </div>
	</div>
</div>
</body>
</html>
