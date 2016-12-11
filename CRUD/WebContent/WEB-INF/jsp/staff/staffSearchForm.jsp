<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "../module/naviside.jsp" %>
<!-- 검색폼 시작 -->
<div class="col-sm-10">            
	<div class="panel panel-success">
	  <div class="panel-heading">
	    <h3 class="panel-title">사원 조회</h3>
	  </div>
	  <div class="panel-body">
	  
	    <form class="form-inline" action = "<%=request.getContextPath()%>/StaffSearchForm.jbin" method = "post">
	    	<table class = "table" style = "width:600px">
	    		<tr>
					<td>이름  </td> 
					<td><input name = "name" type = "text" style = "width:100px;"></td>
					<td>성별</td>
					<td><input type = "checkbox" name = "gender" value="1">남 
						<input type = "checkbox" name = "gender" value="2">여
					</td>
					<td>종교</td>
					<td>
						<select  name = "religionNo" id="select" style = "width:100px;">
				          	<option value= "0"></option>
				         	<c:forEach var="rel" items="${relList}">
								<option value = "${rel.no}"> ${rel.no} ${rel.name}</option>
							</c:forEach>
				        </select>
					</td>
				</tr>
				
				<tr>
					<td>학력</td>
					<td>
						<c:forEach var ="sc" items="${scList}">
							<input type = "checkbox" name = "schoolNo" value ="${sc.no}">${sc.graduate}
						</c:forEach>
					</td>
					<td>기술</td>
					<td colspan = "3">
						<c:forEach var="sk" items = "${skList}">
							<input name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>졸업일</td>
					<td colspan="4"><input type = "date"> ~ <input type = "date"></td>
				</tr>
				<tr>
					<td>
						 <button type="submit" class="btn btn-success">검색</button>
					</td>
				</tr>
			</table>
	    </form>
	    <br>
	    <!-- 검색결과 시작 -->
	    <div class="panel panel-success">
	 		 <div class="panel-heading">
	   			 <h3 class="panel-title">검색 결과</h3>
	  		</div>
	  	</div>
	    	<table class = "table">
		    	<thead>
		    		<th>이름</th> <th>성별</th> <th>종교</th> <th>학력</th> <th>보유기술</th> <th>졸업일</th> <th>수정버튼</th> <th>삭제버튼</th>
		    	</thead>
		    </table>
		 <!-- 검색결과 종료 -->
	  </div>
	</div>
</div>
<!-- 검색폼 끝 -->

</body>
</html>