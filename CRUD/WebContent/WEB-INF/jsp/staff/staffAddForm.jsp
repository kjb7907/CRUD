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
       console.log(($.isNumeric($("#sn1").val())));
       console.log((!$.isNumeric($("#sn1").val())));
       if(!($.isNumeric($("#sn1").val()))){
			$("#sn1Helper").text(" 첫번째 입력칸 6자리 숫자만 입력 가능합니다.");
			$("#sn1").focus();
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
						<input name = "sn1" type = "text"  style = "width:100px;" >
						 -
						<input name = "sn2" type = "text" style = "width:100px;">
						<span id = "sn1Helper" style = " font-size:1em;  color: red;">
						<span id = "sn2Helper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>종교</td>
					<td>
						<select  name = "religionNo" id="select" style = "width:100px;">
				          	<option value= ""></option>
							<c:forEach var="rel" items="${relList}">
								<option value = "${rel.no}"> ${rel.no} ${rel.name}</option>
							</c:forEach>
						</select></td>
				</tr>

				<tr>
					<td>학력</td>
					<td>
						<c:forEach var ="sc" items="${scList}">
							<input type = "radio" name = "schoolNo" value ="${sc.no}">${sc.graduate}
						</c:forEach>
					</td>
				</tr>

				<tr>
					<td>기술</td>
					<td>
						<c:forEach var="sk" items = "${skList}">
							<input name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>
					</td>
				</tr>

				<tr>
					<td>졸업년도</td>
					<td><input type ="date" name = "graduateday"></td>
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
