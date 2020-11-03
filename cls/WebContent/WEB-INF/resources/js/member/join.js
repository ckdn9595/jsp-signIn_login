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
			
		})
	});
})