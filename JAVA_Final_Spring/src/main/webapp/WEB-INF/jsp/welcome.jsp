﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Date"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Welcome</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		function init(){
			if('${msg}' !="")
			{
				alert('${msg}');
			}

			if('${logout_alert}' !="")
			{
				alert('${logout_alert}');
			}
		}
	</script>
</head>
<body onload="init()">
	<%@ include file="menu.jsp"%>
	<%!String greeting = "기말과제 홈페이지 입니다.";
	String tagline = "Welcome to my Home";%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				<%=greeting%>
			</h1>
		</div>
	</div>	
	<div class="container">
		<div class="text-center">
			<h3>
				<%=tagline%>
			</h3>
		</div>
		<hr>
	</div>	
	<%@ include file="footer.jsp"%>
</body>
</html>