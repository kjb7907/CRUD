<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Staff Management</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">HOME <span class="sr-only">(current)</span></a></li>
        <li><a href="#">사원관리</a></li>
       </ul>
    </div>
  </div>
</nav>
<div class="col-sm-2 sidenav">
	<div class = "well">
		<div class="list-group">
		  <a href="#" class="list-group-item active">
		   	관리자 메뉴
		  </a>

		  <a href="#" class="list-group-item">사원 목록
		  </a>
		  <a href="#" class="list-group-item">사원 조회
		  </a>
		  <a href="<%=request.getContextPath() %>/staffAddForm.jbin" class="list-group-item">사원 등록
		  </a>
		  </br></br></br></br></br></br></br></br></br></br></br></br>
		  </br></br></br></br></br></br></br></br></br></br></br></br>
		  </br></br></br></br></br></br></br></br></br></br></br></br>
		  </br></br></br></br></br></br></br></br></br></br></br></br>
		</div>
	</div>
</div>
</body>
</html>