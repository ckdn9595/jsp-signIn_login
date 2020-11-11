$(function(){
	$('.pagebtn').click(function(){
		// 어떤 버튼이 클릭됬는지 알아낸다.
		var str = $(this).text();
		
		var sno = $(this).attr('id');
		
		if(!sno){
			sno = str;
		}
		
		$('#pfrm').attr('method', 'POST');
		$('#pfrm').attr('action', '/cls/reBoard/reBoardList.cls');
		$('#pfrm').prepend('<input type="hidden" name="nowPage" value="' + sno + '">');
		$('#pfrm').submit();
	});
	
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var url = "/cls/main.cls";
		
		switch(tid){
			case 'hbtn':
				url="/cls/main.cls";
			break;
			case 'lbtn':
				url="/cls/member/login.cls";
			break;
			case 'jbtn':
				url="/cls/member/join.cls";
			break;
			case 'obtn':
				url="/cls/member/logout.cls";
			break;
		}
		$(location).attr('href',url);
	});
	
	$('#wbtn').click(function(){
		$('#wmodal').css('display','block');
		$('#body').val('');
		$('#wrbtn').html
	});
	$('#mcbtn').click(function(){
		$('#wmodal').css('display','none');
	});
	
	$('#rrbtn').click(function(){
		$('#body').val('');
	});
	
	$('#wrbtn').click(function(){
//		var txt = $('#body').val();
		var btn = $(this).text();
		alert(btn);
		
		if(btn == '글 등 록'){
			$('#frm3').attr('method','post');
			$('#frm3').attr('action','/cls/reBoard/reBoardWriteProc.cls');
			$('#frm3').submit();	
		}else{
			$('#frm3').attr('action','/cls/reBoard/reBoardEditProc.cls');
			
			$('#frm3').submit();
			
		}
	});
	$('.dbtn').click(function(){
		var str = $(this).attr("id");
		var tno = str.substring(1);
		
		$('#dbno').val(tno);
		$('#frm1').submit();
		
	});
	
	$('.ebtn').click(function(){
		$('#wmodal').css('display','block');
		var str = $(this).attr('id');
		var str2 = str.substr(1);
		
		$('#tno').val(str2);
		$('#wrbtn').text('글 변경');
		$('#body').val('');
		
	})
	$('.rebtn').click(function(){
		var tno = $(this).attr('id');
		$('#tno').val(tno);
		
		$('#frm3').attr('action', '/cls/reBoard/reBoardComment.cls');
		$('#frm3').submit();
	})
});