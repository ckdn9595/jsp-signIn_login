$(document).ready(function(){
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var target = '/cls/main.cls';
		switch(tid){
			case 'hbtn':
			
			break;
			case 'lbtn':
			target = '/cls/member/login.cls'
			break;
			case 'jbtn':
			
			target = '/cls/member/join.cls'
			break;
			case 'obtn':
			
				target = '/cls/member/logout.cls'
			break;
			case 'rbtn':
				$('#body').val('');
			return;
			case 'wbtn':
			var txt = $('#body').val();
			if(!txt){
				$('#body').focus();
				return;
			}
				$('#frm3').submit();
			return;
			break;
		}
		$(location).attr('href',target);
	});
	
	$('.pagebtn').click(function (){
		var str = $(this).text();
		
		var sPage = '';
		if(str == 'pre'){
			sPage = $(this).attr('id');
		}else if(str == 'next'){
			sPage = $(this).attr('id');
			
		}else{
			sPage = str;
		}
		
//		$(location).attr('href','/cls/guestBoard/gBoardList.cls?nowPage='+ sPage);

		$('#nowPage').val(sPage);
		
		$('#gfrm').submit();
	});
	
});







