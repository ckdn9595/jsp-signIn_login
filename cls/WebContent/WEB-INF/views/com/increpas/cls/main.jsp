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
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script type="text/javascript" src="/cls/js/main.js"></script>
<style>
	h5 {
		font-size:20px;	
		height:40px;
		line-height:100%;
	}
</style>
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
	<form method="POST" action="/cls/member/memberInfo.cls" id="frm" name="frm">
		<input type="hidden" id="id" name="name" value="${SID}">
	</form>
	<div class="w3-content w3-center mw600">
		<h1 class="w3-teal w3-padding">CLS Project</h1>
		<div class="w3-col w3-padding w3-margin-top">
			<c:if test="${empty SID}">			
				<h5 class="w3-col m2 w3-button w3-indigo w3-hover-light-blue w3-left" id="jbtn">Join</h5>
				<h5 class="w3-col m2 w3-button w3-indigo w3-hover-light-blue w3-right" id="lbtn">Login</h5>
			</c:if>
			<c:if test="${not empty SID}">
			<div class="w3-col" id="btnfr">
			<hr>
				<div class="w3-col w3-border-botom">
					<h5 class="w3-cell m2 w3-button w3-left w3-red w3-hover-light-pink" id="ibtn">회원정보</h5>
					<h5 class="w3-cell m2 w3-button w3-right w3-red w3-hover-light-pink" id="obtn">LogOut</h5>
				</div>
			</div>
			</c:if>
				<div class="w3-col mt10">
					<div class="w3-col m3 pdh10">
						<h5 class="w3-col w3-button w3-left w3-green w3-hover-light-pink" id="gbtn">방명록</h5>
					</div>
					<div class="w3-col m3 pdh10">
						<h5 class="w3-col w3-button w3-left w3-yellow w3-hover-light-pink" id="sbtn">설문 조사</h5>
					</div>
					<c:if test="${RCNT ==0}">
						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-left w3-black w3-hover-light-pink" id="irbtn">댓글 쓰기</h5>
						</div>
					</c:if>	
					<div class="w3-col m3 pdh10">
						<h5 class="w3-col w3-button w3-left w3-black w3-hover-light-pink" id="rbtn">댓글 게시판</h5>
					</div>
					<div class="w3-col m3 pdh10">
						<h5 class="w3-col w3-button w3-left w3-gray w3-hover-light-pink" id="fbtn">파일게시판</h5>
					</div>
				</div>				
		</div>
		<div id="naverIdLogin"></div>
<!-- 		<div id="naverIdLogin"></div> -->
	</div>
		<!-- //네이버아이디로로그인 버튼 노출 영역 -->
		
		<!-- 네이버아디디로로그인 초기화 Script -->
		<script type="text/javascript">
			var naverLogin = new naver.LoginWithNaverId(
				{
					clientId: "개발자센터에 등록한 ClientID",
					callbackUrl: "개발자센터에 등록한 callback Url",
					isPopup: false, /* 팝업을 통한 연동처리 여부 */
					loginButton: {color: "green", type: 5, height: 100} /* 로그인 버튼의 타입을 지정 */
				}
			);
			
			/* 설정정보를 초기화하고 연동을 준비 */
			naverLogin.init();
		</script>
</body>
</html>