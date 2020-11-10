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
<script type="text/javascript" src="/cls/js/guestBoard.js"></script>
</head>
<body>
	<div class="w3-content w3-center mw650">
		<h1 class="w3-orange w3-padding w3-card-4">댓글 게시판</h1>
<!-- 		<div class="w3-col w3-border-bottom pdb10"> -->
<!-- 			<div class="w3-col m2 w3-left pdh1"> -->
<!-- 				<span class="w3-col w3-button w3-small w3-green w3-hover-lime w3-left mt0 btnBox" id="hbtn">Home</span> -->
<!-- 			</div> -->
<%-- 			<c:if test="${empty SID}"> --%>
<!-- 				<div class="w3-col m2 w3-right pdh1"> -->
<!-- 					<span class="w3-col w3-button w3-small w3-orange w3-hover-deep-orange mt0 btnBox" id="lbtn">로그인</span> -->
<!-- 				</div> -->
<!-- 				<div class="w3-col m2 w3-right pdh1"> -->
<!-- 					<span class="w3-col w3-button w3-small w3-blue w3-hover-aqua w3-right mt0 btnBox" id="jbtn">회원가입</span> -->
<!-- 				</div> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${not empty SID}"> --%>
<!-- 				<div class="w3-col m2 w3-right pdh1"> -->
<!-- 					<span class="w3-col w3-button w3-small w3-red w3-hover-orange w3-right mt0 btnBox" id="obtn">로그아웃</span> -->
<!-- 				</div> -->
<%-- 			</c:if> --%>
<!-- 		</div> -->
		
		<!-- 글 입력창 -->
		
<%-- 		<c:if test="${(not empty SID) and (CNT eq 0)}"> --%>
<!-- 		<div class="w3-col pb10 w3-border-bottom w3-border-lightgrey pb20" > -->
<!-- 			<div class="w3-col w3-card-4 pd10"> -->
<!-- 				<div class="w3-col w3-border-bottom w3-left-align w3-text-grey mb10">글 작 성</div> -->
<!-- 				<div class="w3-col"> -->
<!-- 					<div class="w3-col inblock avtbox100 pdr10"> -->
<!-- 						<img src="/cls/img/avatar/img_avatar1.png" class="avtimg100 w3-border"> -->
<!-- 					</div> -->
<!-- 					<form class="w3-rest" method="post" action="/cls/guestBoard/gBoardWrite.cls" id='frm3' name='frm3'> -->
<!-- 						<textarea class="w3-input w3-border h72" style="resize: none;" placeholder="인삿말을 작성하세요!" id="body" name="body"></textarea> -->
<!-- 						<div class="w3-col pdh1 mt5"> -->
<!-- 							<span class="w3-col m2 w3-left w3-button w3-small w3-orange w3-hover-deep-orange btnBox" id="rbtn">reset</span> -->
<!-- 							<span class="w3-col m2 w3-right w3-button w3-small w3-orange w3-hover-deep-orange btnBox" id="wbtn">글 등 록</span> -->
<!-- 						</div> -->
<!-- 					</form> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 		</c:if> --%>
		<!-- 글 목 록 창 -->
<%-- 		<c:forEach var="data" items="${LIST}"> --%>
			<div class="w3-col w3-card-4 pd10 w3-margin-top">
				<div class="w3-col">
					<div class = "w3-col m2 w3-border-right">글번호 </div>
					<div class = "w3-col m2 w3-border-right">작성자  </div>
					<div class = "w3-col m5 w3-border-right">글내용  </div>
					<div class = "w3-col m3 w3-border-right">작성일  </div>					
				</div>
			</div>
			
<%-- 		</c:forEach> --%>
<!-- 		<div class="w3-col w3-center w3-margin-top w3-margin-bottom"> -->
<!-- 			<form class="w3-bar w3-border w3-round" method = "post" action="/cls/guestBoard/gBoardList.cls" name="gfrm" id="gfrm"> -->
<!-- 				<input type="hidden" name = "nowPage" id="nowPage"> -->
<%-- 				<c:if test="${PAGE.startPage != 1}"> --%>
<%-- 				  <span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.startPage -1}">pre</span> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${PAGE.startPage == 1}"> --%>
<!-- 				  <span class="w3-bar-item w3-grey pagebtn">pre</span> -->
<%-- 				</c:if> --%>
<%-- 				<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}"> --%>
<%-- 				 	 <span class="w3-bar-item w3-button w3-hover-lime pagebtn">${page}</span> --%>
<%-- 				</c:forEach> --%>
<%-- 				<c:if test="${PAGE.endPage != PAGE.totalPage}"> --%>
<%-- 				  <span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.endPage +1}">next</span> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${PAGE.endPage == PAGE.totalPage}"> --%>
<!-- 				  <span class="w3-bar-item w3-grey pagebtn">next</span> -->
<%-- 				</c:if> --%>
<!-- 			</form> -->
<!-- 		</div> -->
		
	</div>
</body>
</html>