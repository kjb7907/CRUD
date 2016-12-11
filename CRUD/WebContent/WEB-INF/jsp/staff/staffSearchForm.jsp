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
<!-- �˻��� ���� -->
<div class="col-sm-10">            
	<div class="panel panel-success">
	  <div class="panel-heading">
	    <h3 class="panel-title">��� ��ȸ</h3>
	  </div>
	  <div class="panel-body">
	  
	    <form class="form-inline" action = "<%=request.getContextPath()%>/StaffSearchForm.jbin" method = "post">
	    	<table class = "table" style = "width:600px">
	    		<tr>
					<td>�̸�  </td> 
					<td><input name = "name" type = "text" style = "width:100px;"></td>
					<td>����</td>
					<td><input type = "checkbox" name = "gender" value="1">�� 
						<input type = "checkbox" name = "gender" value="2">��
					</td>
					<td>����</td>
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
					<td>�з�</td>
					<td>
						<c:forEach var ="sc" items="${scList}">
							<input type = "checkbox" name = "schoolNo" value ="${sc.no}">${sc.graduate}
						</c:forEach>
					</td>
					<td>���</td>
					<td colspan = "3">
						<c:forEach var="sk" items = "${skList}">
							<input name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>������</td>
					<td colspan="4"><input type = "date"> ~ <input type = "date"></td>
				</tr>
				<tr>
					<td>
						 <button type="submit" class="btn btn-success">�˻�</button>
					</td>
				</tr>
			</table>
	    </form>
	    <br>
	    <!-- �˻���� ���� -->
	    <div class="panel panel-success">
	 		 <div class="panel-heading">
	   			 <h3 class="panel-title">�˻� ���</h3>
	  		</div>
	  	</div>
	    	<table class = "table">
		    	<thead>
		    		<th>�̸�</th> <th>����</th> <th>����</th> <th>�з�</th> <th>�������</th> <th>������</th> <th>������ư</th> <th>������ư</th>
		    	</thead>
		    </table>
		 <!-- �˻���� ���� -->
	  </div>
	</div>
</div>
<!-- �˻��� �� -->

</body>
</html>