<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/cls/js/main.js"></script>
<script type="text/javascript">
// 	$(function(){
// 		var sid = '${SID}'; //세션을 찾ㅂ음
// 		if(sid){
// 			$('#lbtn').css('display', 'none');
// 			$('#btnfr').css('display', 'block');
// 		}
		
// 	})
</script>
</head>
<body>
	<div class="w3-content w3-center mw700">
		<h1 class="w3-teal w3-padding">CLS Project</h1>
		<div class="w3-col w3-padding w3-margin-top">
			<c:if test="${empty SID}">
			<h5 class="w3-col w3-button w3-indigo w3-hover-light-blue" id="lbtn">Login</h5>
			</c:if>
			<c:if test="${not empty SID}">
			<div class="w3-col" id="btnfr">
				<h5 class="w3-cell m2 w3-button w3-red w3-hover-light-pink" id="obtn">LogOut</h5>
			</div>
			</c:if>
		</div>
	</div>
</body>
</html>