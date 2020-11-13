<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/cls/js/Survey.js">
	$(document).ready(function(){
		$('#frm').submit();
	})
</script>
</head>
<body>
	<form method="post" action="${VIEW}" id = "frm">
		<input type="hidden" name = "sno" value="${SNO}">
	</form>
</body>
</html>