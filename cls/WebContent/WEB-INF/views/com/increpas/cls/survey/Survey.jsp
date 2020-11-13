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
		<h1 class="w3-padding w3-blue">설문 문항</h1>
		<div class="w3-col w3-padding w3-card-4">
			<form class ="w3-col w3-padding w3-left-align w3-border-bottom" id="sfrm">
				<!-- 문항 추가 -->
<%-- 					<input type="hidden" name="sno" value="${QUEST[1].sno}"> --%>
				
				<h4 class="w3-col m12 w3-text-red w3-border-bottom">${QUEST[1].body}</h4>
				<div class="w3-col w3-margin-bottom">
				<c:set var="sno" value="${0}"/>
				<c:forEach var="data" items="${QUEST}" varStatus="st">
					<c:set var="sno" value="${sno + 1}"/>
					<div class="w3-col txt14"><b>${st.count}.${data.qbody}</b></div>
					<c:forEach var="sel" items="${SELECT[data.qno]}" varStatus="str">
						
						<div class="w3-col">
							<div class="pdl30 txt12"><input type="radio" value="${sel.qno}" id="${data.qbody}" name="${sel.qno}">${str.count}) ${sel.qbody}</div>
						</div>
						
					</c:forEach>
					
				</c:forEach>
				</div>
			</form>
			<input type = "hidden" id="cnt" value="${sno}">
			<div class="w3-col">
				<div class="w3-col m2 w3-left w3-button w3-green" id="hbtn">home</div>
				<div class="w3-col m2 w3-right w3-button w3-blue" id="sbtn">submit</div>
			</div>
		</div>
	</div>
</body>
</html>