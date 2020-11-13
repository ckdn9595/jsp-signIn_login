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
				<h4 class="w3-col m12 w3-text-red w3-border-bottom">${LIST.get(0).sbody}</h4>
			<form class ="w3-col w3-padding w3-left-align w3-border-bottom">
				<!-- 문항 추가 -->
				<c:set var="no" value="${0}"/>
				<c:set var="subno" value="${0}" />
				<c:forEach var="data" items="${LIST}" varStatus="st">
					<c:if test="${data.upno == 0}">
						<c:set var="no" value="${no + 1}" />
							<c:if test="${st.index==0}">
								<div class="w3-col w3-margin-bottom">
									<div class="w3-col txt14"><b>${no}. ${data.qbody}</b></div>
							</c:if>	
							<c:if test="${st.index!=0}">
								</div>
								<div class="w3-col w3-margin-bottom">
									<div class="w3-col txt14"><b>${no}. ${data.qbody}</b></div>
							</c:if>	
					</c:if>
						
					<c:if test="${data.upno !=0 }">
						<c:set var="subno" value="${subno + 1}" />
							<div class="w3-col">
								<div class=" w3-col pdl30 txt12">${subno}) ${data.qbody}</div>
								<div class="w3-col m10 w3-black" style="width:${data.per}%; height:10px;"><p></p></div>
								<div class="w3-col m2 w3-text-grean">${data.per}%</div>
							</div>
					</c:if>
				</c:forEach>
					
					</div>
			</form>
			<div class="w3-col w3-margin-top">
				<div class="w3-col w3-button w3-green w3-hover-lime" id="hbtn">home</div>
				<div class="w3-col w3-button w3-green w3-hover-lime" id="sibtn">인포</div>
			</div>
		</div>
	</div>
</body>
</html>