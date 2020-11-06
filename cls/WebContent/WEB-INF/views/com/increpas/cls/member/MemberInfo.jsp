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
<script type="text/javascript" src="/cls/js/MemberInfo.js"></script>
</head>
<body>
	<div class="w3-content w3-center mw650">
		<h1 class="w3-purple w3-padding w3-card-4">${VO.id} 회원 information</h1>
		<div class="w3-center mw650 w3-col">
			<h5 class="w3-col m2 w3-border w3-button w3-left w3-green w3-hover-light-pink" id="home">home</h5>
			<h5 class="w3-col m2 w3-border w3-button w3-right w3-green w3-hover-light-pink" id="edit">edit</h5>
			<h5 class="w3-col m2 w3-border w3-button w3-right w3-green w3-hover-light-pink" id="out">탈퇴</h5>
		</div>
		<div class="w3-content w3-border mt100">
			<div class=" w3-padding w3-left w3-margin w3-border imgbox2">
				<img src="/cls/img/avatar/${AVT.savename}" class="imgsrc2">
			</div>
			<div class="w3-content w3-padding w3-margin w3-align-left imgbox2">
				<h5 class="" id="mno">회원번호:${VO.mno}</h5>
				<h5 class="" id="mid">아이디:${VO.id}</h5>
				<h5 class="" id="mname">이름:${VO.name}</h5>
				<h5 class="" id="mmail">이메일:${VO.mail}</h5>
				<h5 class="" id="mgen">성별:${VO.gen}</h5>
				<h5 class="" id="mjoin">가입일:${VO.sdate}</h5>
			</div>
		</div>
			<div class=" box w3-hide w3-col" id="box">
					<input class="w3-col m7 w3-margin w3-left" type="text" id="pmail" name="pmail" placeholder="바꿀 메일 입력">
					<h5 class="w3-col m3 w3-border w3-small w3-button w3-left w3-green w3-hover-light-pink" id="change">입력</h5>
				<c:forEach var="data" items="${LIST}">
					<c:if test="${data.gen == VO.gen}">
						<div class=" w3-padding w3-margin imgbox2">
							<input type="radio" name="radio" id="radio" val="${data.ano}"><span>${data.ano}</span>
							<img src="/cls/img/avatar/${data.savename}" class="imgsrc2">
						</div>
					</c:if>
				</c:forEach>
			</div>
	</div>
</body>
</html>