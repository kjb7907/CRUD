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
      console.log('btn click'); //��ưŬ������ �Ѿ��
      //�̸� ��ȿ�� �˻�
      if($("#name").val() == ""){	//�̸��Է�ĭ�� ����������
          $("#nameHelper").text('�̸��� �Է��ϼ���.');
          $("#name").focus();
      }else if($("#name").val() != ""){	//�̸��Է�ĭ�� ������ �ƴϰ�
        for(var i = 0; i<$("#name").val().length; i++){	//�Էµ� ������ �����ڵ尡 128�� ���ų� ũ��
          if($("#name").val().charCodeAt(i)<128){
		      $("#nameHelper").text('�ѱ۸� �Է� �����մϴ�.');
		      $("#name").focus();
          }else{	//���� �����ÿ��� Helper ����
	          $("#nameHelper").text('');
	          $("#name").blur();
          }
        }
       }
		//������ 
		if(!($.isNumeric($("#sn1").val()))){
			console.log("�ֹε�Ϲ�ȣ ���ڸ� �̼���");
			$("#snHelper").text(" ù��° �Է�ĭ 6�ڸ� ���ڸ� �Է� �����մϴ�.");
			$("#sn1").focus();
		}else if(!($.isNumeric($("#sn2").val()))){
			console.log("�ֹε�Ϲ�ȣ ���ڸ� �̼���");
			$("#snHelper").text(" ");
			$("#snHelper").text(" �ι�° �Է�ĭ 7�ڸ� ���ڸ� �Է� �����մϴ�.");
			$("#sn2").focus();
     	}else if($("#religion").val() == ""){
			console.log("�����̼���");
			$("#snHelper").text(" ");
			$("#relHelper").text(" ������ �����ϼ���.");
		}else if((!$("#school1").is(":checked"))&&(!$("#school2").is(":checked"))&&(!$("#school3").is(":checked"))){
			console.log("�з� �̼���");
			$("#relHelper").text("");
			$("#scHelper").text("�����з��� �������ּ���");
		}else if((!$("#skill1").is(":checked"))&&(!$("#skill2").is(":checked"))&&(!$("#skill3").is(":checked"))&&(!$("#skill4").is(":checked"))&&(!$("#skill5").is(":checked"))){
			console.log("��� �̼���");
			$("#scHelper").text("");
			$("#skHelper").text("����� 1�� �̻� �������ּ���");
		}else if($("#date").val()==""){
			console.log($("#date").val());
			console.log("������ �̼���");
			$("#skHelper").text("");
			$("#dateHelper").text("�������� ������ �ּ���");
			$("#date").focus();
		}else{
			console.log("ȸ������ ���� ����");
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
	    <h3 class="panel-title">��� ���</h3>
	  </div>
	  <div class="panel-body">

	    <form class="form-inline" action = "<%=request.getContextPath()%>/StaffAddAction.jbin" method = "post">
	    	<table class = "table">

	    		<tr>
					<td style = "width:100px">�̸�  </td>
					<td>
						<input id = "name" name = "name" type = "text" style = "width:150px;">
						<span id = "nameHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>�ֹε�Ϲ�ȣ</td>
					<td>
						<input id = "sn1" name = "sn1" type = "text"  style = "width:100px;" >
						 -
						<input id = "sn2" name = "sn2" type = "text" style = "width:100px;">
						<span id = "snHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>����</td>
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
					<td>�з�</td>
					<td>
						<c:forEach var ="sc" items="${scList}">
							<input id = "school${sc.no}" type = "radio" name = "schoolNo" value ="${sc.no}">${sc.graduate}
						</c:forEach>
						<span id = "scHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>���</td>
					<td>
						<c:forEach var="sk" items = "${skList}">
							<input id = "skill${sk.no}" name = "skillNo" type="checkbox" value="${sk.no}">${sk.name}
						</c:forEach>
						<span id = "skHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

				<tr>
					<td>�����⵵</td>
					<td>
						<input id="date" type ="date" name = "graduateday">
						<span id = "dateHelper" style = " font-size:1em;  color: red;">
					</td>
				</tr>

			</table>
			 <button type="reset" class="btn btn-default">���</button>
       <button id = "btn" type="button" class="btn btn-primary">���</button>
	    </form>
	  </div>
	</div>
</div>
</body>
</html>
