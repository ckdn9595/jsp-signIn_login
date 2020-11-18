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
<!-- <script type="text/javascript" src="/cls/js/"></script> -->
</head>
<body>
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-padding">게시판 상세보기</h1>
		
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">작성자</label>
				<div class="w3-col m9 pdl20 w3-label" id="id">jiwoo</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title</label>
				<div class="w3-col m9 pdl20">
					<div  id="title" 
							class="w3-col w3-input w3-border pdl20">
					</div>
				</div>
			</div>
			<div class="w3-col w3-margin-top filefrr">
					<label class="w3-col m2 w3-right-align w3-label">File</label>   
					<div class="w3-col m9 pdl20 divht">
						<div id="file0"
								class="w3-col w3-input w3-border pdl10 upfile">
						</div>
					</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Message</label>
				<div class="w3-col m9 pdl20 filefr">
					<div  id="body" 
							class="w3-col w3-border">
					</div>
				</div>
			</div>

		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-blue w3-hover-aqua" id="wbtn">수정</div>
		</div>
	</div>
</body>
</html>