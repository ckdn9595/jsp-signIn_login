//var tmp = $('.divht').html();
//var tmpcnt = 1;
//function appendhtml(){
////		$(this).removeAttr('oninput')
////		$(this).attr('name','file'+ tmpcnt);
//		$('.divht').append(tmp);
//		tmpcnt += 1;
//}
$(document).ready(function(){
	$('.brow').click(function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		// 전송주소 설정하고
		$('#bfrm').attr('action', '/cls/board/BoardDetail.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
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
		var sid = $('#id').val();
		if((!shead) || (!sbody) || (!sid)){
			alert("로그인, 제목, 내용중 무언가가 없단다 아이야")
			return;
		};
		$('#wfrm').submit();
	});
	$('.upfile').change(function(){
		var str = $(this).attr('id');
		var lach = str.substr(str.length-1, 1);
		lach = Number(lach);
		num = lach + 1;
		$('#file'+num).removeClass('w3-hide');
	})
	
	
});