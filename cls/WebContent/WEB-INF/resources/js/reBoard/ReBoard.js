$(function(){
	$('.pbtn').click(function(){
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
});