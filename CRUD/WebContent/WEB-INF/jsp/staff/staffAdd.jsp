<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page import = "dto.*" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<School> arr = (ArrayList<School>)request.getAttribute("scList");
System.out.println(arr.get(1));
//request �Ѿ���� Ȯ��
%>
<%@ include file = "../module/naviside.jsp" %>


            
<div class="col-sm-8">            
	<div class="panel panel-success">
	  <div class="panel-heading">
	    <h3 class="panel-title">��� ���</h3>
	  </div>
	  <div class="panel-body">
	  
	    <form class="form-inline" action = "<%=request.getContextPath()%>/StaffAddAction.jbin" method = "post">
	    	<table class = "table">
	    	
	    		<tr>
					<td>�̸� : </td><td><input name = "name" type = "text" style = "width:100px;"></td>
				</tr>
				
				<tr>
					<td>�ֹε�Ϲ�ȣ:</td>
					<td>
						<input name = "sn1" type = "text"  style = "width:100px;" >
						 - 
						<input name = "sn2" type = "text" style = "width:100px;">
					</td>
				</tr>
				
				<tr>
					<td>����</td> 
					<td>
						<select  name = "religionNo" id="select" style = "width:100px;">
				          <option value= ""></option>
						<c:forEach var="rel" items="${relList}">
							<option value = "${rel.no}">${rel.name}
						</c:forEach>
						</select></td>
				</tr>
				
				<tr>
					<td>�з�</td>
					<td>
					
					<c:forEach var ="sc" items="${scList}">
						<input type = "radio" name = "schoolNo" value ="${sc.no}">${sc.graduate}
					</c:forEach>
					</td>
				</tr>
				
				<tr>
					<td>���</td>
					<td>
						<c:forEach var="sk" items = "${skList}">
							<input name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>

					</td>
				</tr>
				
				<tr>
					<td>�����⵵</td>
					<td><input type ="date" name = "graduateday"></td>
				</tr>
				
			</table>
			 <button type="reset" class="btn btn-default">���</button>
        	 <button type="submit" class="btn btn-primary">���</button>
	    </form>
	  </div>
	</div>
</div>
</body>
</html>