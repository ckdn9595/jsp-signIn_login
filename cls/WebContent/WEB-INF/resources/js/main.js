$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href','/cls/member/login.cls');
	});
	$('#obtn').click(function(){
		$(location).attr('href','/cls/member/logout.cls');
	});
	$('#jbtn').click(function(){
		$(location).attr('href','/cls/member/join.cls');
	});
	
	$('#ibtn').click(function(){
		$('#frm').submit();
	});
});
