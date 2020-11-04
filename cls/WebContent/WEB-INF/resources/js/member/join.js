$(document).ready(function(){
	$('#idck').click(function(){
		//할일
		//1. 아이디 입력값을 알아낸다
		var sid= $('#id').val();
		
		if(!sid){
			return;
		}
		$.ajax({
			url:'/cls/member/idCheck.cls',
			type:'post',
			dataType:'json',
			data:{
				id: sid
			},
			success:function(data){
				if(data.result =='OK'){
					$('#idmsg').html('사용가능하다 인마');
					$('#idmsg').removeClass('w3-text-red');
					$('#idmsg').addClass('w3-text-blue');
					$('#idmsg').stop().slideDown(500);
				}else{
					$('#idmsg').html('사용불가능하다 인마');
					$('#idmsg').removeClass('w3-text-blue');
					$('#idmsg').addClass('w3-text-red');
					$('#idmsg').stop().slideDown(500);
				}
			},
			error:function(){
				alert('##에러##');
			}
			
		});
	});
	$('#pw').keyup(function(){
		var spw = $(this).val();
		var pattern = /^.*(?=^[a-zA-Z0-9#@$%!^&]{8,})(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[~!@#$%^&]).*$/;
		var result = pattern.test(spw);
		
		if(result){
			$(this).removeClass('w3-pale-red');
			$(this).addClass('w3-teal');
		}else{
			$(this).removeClass('w3-teal');
			$(this).addClass('w3-pale-red');
		}
	});
	$("#repw").keyup(function(){
		var spw = $('#pw').val();
		
		var srepw = $(this).val();
		
		if(spw == srepw){
			$('#pwmsg').css('color','green');
			$('#pwmsg').html('사용 가능하다 인마')
			$('#pwmsg').stop().show();
			setTimeout(hidePwTag, 1500);
		}else{
			$('#pwmsg').css('color','red');
			$('#pwmsg').html('사용 불가능하다 인마')
			$('#pwmsg').stop().show();
		}
	});
	function hidePwTag(){
		$('#repw').parent().parent().stop().slideUp(300);
	};
	
	//회원이름 정구식 검사
	$("#name").change(function(){
		var sname = $(this).val();
		var pattern = /^[가-힣]{2,10}$/;
		var result = pattern.test(sname);
		if(!result){
			$('#name').removeClass('w3-pale-blue');
			$('#name').addClass('w3-pale-red');
			$('#name').focus();
		}else{
			
			$('#name').removeClass('w3-pale-red');
			$('#name').addClass('w3-pale-blue');
		}
//		alert(result);
//		if(result == false){}
//		$(this).val('');
	});
	
	$(".gen").click(function(){
		//할일
		// 1.무슨성별인지 선택
		var sgen = $(this).val();
		if(sgen == 'M'){
			$('.avtFfr').stop().hide();
			$('.avtMfr').stop().slideDown(300);
		}else{
			$('.avtMfr').stop().hide();
			$('.avtFfr').stop().slideDown(300);
		}
		
	});
	$('#hbtn').click(function(){
		$(location).attr('href','/cls/main.cls');
	});
	$('#jbtn').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		var sname = $('#name').val();
		var smail = $('#mail').val();
		var stel = $('#tel').val();
		var sgen = $('.gen:checked').val();
		var savt = $('.avt:checked').val();
		alert(savt);
		if(!(sid && spw && sname && smail && stel && sgen && savt)){
				return;
		}
		
		$('#frm').attr('method','POST');	
		$('#frm').attr('action','/cls/member/joinProc.cls');	
//		$(location).attr('href','/cls/main.cls');
		$('#frm').submit();	
	});
});