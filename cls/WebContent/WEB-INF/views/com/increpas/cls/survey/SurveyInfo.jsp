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
<script type="text/javascript" src="/cls/js/Survey.js"></script>
</head>
<body>
	<div class = "w3-content w3-center mw700">
		<h1 class="w3-padding w3-blue">진행중인 설문조사</h1>
		<div class="w3-col w3-padding w3-card-4">
			<form class ="w3-col" method="POST" action="/cls/survey/survey.cls" id="frm">
				<input type="hidden" name="sno" id="sno">
				<c:forEach var="data" items="${LIST}" varStatus="st">
					<div class=" w3-col m9 w3-text-red txt14"><b>${st.count}. ${data.body}</b></div>
					<c:if test="${data.cnt eq 0}">
						<div class="w3-button w3-col m2 w3-small w3-orange sibtn" id="${data.sno}">참여</div>
					</c:if>
					<c:if test="${data.cnt ne 0}">
						<div class="w3-button w3-col m2 w3-small w3-orange srbtn" id="r${data.sno}">결과보기</div>
					</c:if>
				</c:forEach>
			</form>
		</div>
	</div>
	
</body>
</html>