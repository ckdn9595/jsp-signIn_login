
$(document).ready(function(){
	$('.brow').click(function(){
		var sno = $(this).attr('id');
		alert(sno);
	});
	
	$('.pagebtn').click(function(){
		// 버튼 내용 알아내고
		var strPage = $(this).attr('id');
		
		if(!strPage){
			strPage = $(this).html();
		}
		
		$('#nowPage').val(strPage);
		// 전송주소 설정하고
		$('#bfrm').attr('action', '/cls/board/BoardList.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#rbtn').click(function(){
		$('#bfrm').attr('action', '/cls/board/boardWrite.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#obtn').click(function(){
		$('#bfrm').attr('action', '/cls/member/logout.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#ibtn').click(function(){
		$('#bfrm').attr('action', '/cls/member/login.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#jbtn').click(function(){
		$('#bfrm').attr('action', '/cls/member/join.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#hbtn').click(function(){
		$('#bfrm').attr('action', '/cls/main.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	$('#hbtn').click(function(){
		$('#wfrm').attr('action', '/cls/main.cls');
		// 폼태그 전송하고
		$('#wfrm').submit();
	});
	
	$('#wbtn').click(function(){
		var shead = $('#title').val();
		var sbody = $('#body').val();
		if((!shead) || (!sbody)){
			return;
		};
		$('#wfrm').submit();
	});
	var tmp = $('.divht').html();
	$('.upfile').change(function(){
		$(this).removeClass('upfile');
		$('.divht').append(tmp);
	});
	
});